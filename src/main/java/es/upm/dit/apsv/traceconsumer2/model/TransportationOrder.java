package es.upm.dit.apsv.traceconsumer2.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TransportationOrder {
    private String toid;
    @Id
    private String truck;
    private long originDate;
    private double originLat;
    private double originLong;
    private long dstDate;
    private double dstLat;
    private double dstLong;
    private long lastDate;
    private double lastLat;
    private double lastLong;
    private int st;

    public TransportationOrder() {
    }

    public TransportationOrder(String toid, String truck, long originDate, double originLat, double originLong,
            long dstDate, double dstLat, double dstLong, long lastDate, double lastLat, double lastLong, int st) {
        this.toid = toid;
        this.truck = truck;
        this.originDate = originDate;
        this.originLat = originLat;
        this.originLong = originLong;
        this.dstDate = dstDate;
        this.dstLat = dstLat;
        this.dstLong = dstLong;
        this.lastDate = lastDate;
        this.lastLat = lastLat;
        this.lastLong = lastLong;
        this.st = st;
    }

    public String getToid() {
        return toid;
    }



    public void setToid(String toid) {
        this.toid = toid;
    }



    public String getTruck() {
        return truck;
    }



    public void setTruck(String truck) {
        this.truck = truck;
    }



    public long getOriginDate() {
        return originDate;
    }



    public void setOriginDate(long originDate) {
        this.originDate = originDate;
    }



    public double getOriginLat() {
        return originLat;
    }



    public void setOriginLat(double originLat) {
        this.originLat = originLat;
    }



    public double getOriginLong() {
        return originLong;
    }



    public void setOriginLong(double originLong) {
        this.originLong = originLong;
    }



    public long getDstDate() {
        return dstDate;
    }



    public void setDstDate(long dstDate) {
        this.dstDate = dstDate;
    }



    public double getDstLat() {
        return dstLat;
    }



    public void setDstLat(double dstLat) {
        this.dstLat = dstLat;
    }



    public double getDstLong() {
        return dstLong;
    }



    public void setDstLong(double dstLong) {
        this.dstLong = dstLong;
    }



    public long getLastDate() {
        return lastDate;
    }



    public void setLastDate(long lastDate) {
        this.lastDate = lastDate;
    }



    public double getLastLat() {
        return lastLat;
    }



    public void setLastLat(double lastLat) {
        this.lastLat = lastLat;
    }



    public double getLastLong() {
        return lastLong;
    }



    public void setLastLong(double lastLong) {
        this.lastLong = lastLong;
    }



    public int getSt() {
        return st;
    }



    public void setSt(int st) {
        this.st = st;
    }

    @Override
    public String toString() {
        return "TransportationOrder [toid=" + toid + ", truck=" + truck + ", originDate=" + originDate + ", originLat="
                + originLat + ", originLong=" + originLong + ", dstDate=" + dstDate + ", dstLat=" + dstLat
                + ", dstLong=" + dstLong + ", lastDate=" + lastDate + ", lastLat=" + lastLat + ", lastLong=" + lastLong
                + ", st=" + st + "]";
    }

    
    public int distanceToDestination() {
        return (int) (Math.sqrt(Math.pow((this.dstLat-this.lastLat), 2) + Math.pow((this.dstLong-this.lastLong), 2)));
    }
}