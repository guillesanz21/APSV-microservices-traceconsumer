package es.upm.dit.apsv.traceconsumer2.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Trace {
    @Id
    private String traceId;
    private String truck;
    private long lastSeen;
    private double lat;
    private double lng;
    
    public Trace() {
    }

    public Trace(String traceId, String truck, long lastSeen, double lat, double lng) {
        this.traceId = traceId;
        this.truck = truck;
        this.lastSeen = lastSeen;
        this.lat = lat;
        this.lng = lng;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getTruck() {
        return truck;
    }

    public void setTruck(String truck) {
        this.truck = truck;
    }

    public long getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(long lastSeen) {
        this.lastSeen = lastSeen;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Trace [traceId=" + traceId + ", truck=" + truck + ", lastSeen=" + lastSeen + ", lat=" + lat + ", lng="
                + lng + "]";
    }
 
}
