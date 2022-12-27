package es.upm.dit.apsv.traceconsumer2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.core.env.Environment;

import org.springframework.web.client.HttpClientErrorException;

import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.function.Consumer;

import es.upm.dit.apsv.traceconsumer2.model.Trace;
import es.upm.dit.apsv.traceconsumer2.model.TransportationOrder;
import es.upm.dit.apsv.traceconsumer2.repository.TraceRepository;
import es.upm.dit.apsv.traceconsumer2.repository.TransportationOrderRepository;

@SpringBootApplication
public class Traceconsumer2Application {

	private static final Logger log = LoggerFactory.getLogger(Traceconsumer2Application.class);

	@Autowired
	private TraceRepository traceRepository;
	// ! traceconsumer2
	@Autowired
	private TransportationOrderRepository transportationOrderRepository;

	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(Traceconsumer2Application.class, args);
	}


	@Bean("consumer")
	public Consumer<Trace> checkTrace() {
		return t -> {
			t.setTraceId(t.getTruck() + t.getLastSeen());
			traceRepository.save(t);
			// ! traceconsumer1
			// String uri = env.getProperty("orders.server");
			// RestTemplate restTemplate = new RestTemplate();
			TransportationOrder result = null;
			// ! traceconsumer2
			Optional<TransportationOrder> ot;

			try {
				// ! traceconsumer1
				// result = restTemplate.getForObject(uri + t.getTruck(), TransportationOrder.class);
				// ! traceconsumer2
				ot = transportationOrderRepository.findById(t.getTruck());
				if (ot.isPresent()) 
					result = ot.get();
			} catch (HttpClientErrorException.NotFound ex) {
				result = null;
			}
			if (result != null && result.getSt() == 0) {
				result.setLastDate(t.getLastSeen());
				result.setLastLat(t.getLat());
				result.setLastLong(t.getLng());
				if (result.distanceToDestination() < 10)
					result.setSt(1);
				// ! traceconsumer1
				// restTemplate.put(uri, result, TransportationOrder.class);
				// ! traceconsumer2
				transportationOrderRepository.save(result);
				log.info("Order updated: " + result);

			}

		};
	}
}
