package nl.stil4m.mollie.domain;

import java.util.Date;

public class Subscription {

    private String resource;
    private String id;
    private String customerId;
    private String mode;
    private Date createdDatetime;
    private String status;
    private Double amount;
    private Integer times;
    private String interval;
    private Date startDate;
    private String description;
    private String method;
    private Date cancelledDatetime;
    private Links links;

    public Subscription(String resource, String id, String customerId, String mode, Date createdDatetime, String status, Double amount, Integer times, String interval, Date startDate, String description, String method, Date cancelledDatetime, Links links) {
        this.resource = resource;
        this.id = id;
        this.customerId = customerId;
        this.mode = mode;
        this.createdDatetime = createdDatetime;
        this.status = status;
        this.amount = amount;
        this.times = times;
        this.interval = interval;
        this.startDate = startDate;
        this.description = description;
        this.method = method;
        this.cancelledDatetime = cancelledDatetime;
        this.links = links;
    }

    public String getResource() {
        return resource;
    }

    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getMode() {
        return mode;
    }

    public Date getCreatedDatetime() {
        return createdDatetime;
    }

    /**
     * The subscription's current status, depends on whether the customer has a pending, valid or invalid mandate.
     * <p>Possible values: pending active cancelled suspended completed</p>
     */
    public String getStatus() {
        return status;
    }

    public Double getAmount() {
        return amount;
    }

    public Integer getTimes() {
        return times;
    }

    public String getInterval() {
        return interval;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getDescription() {
        return description;
    }

    /**
     * The payment method used for this subscription, either forced on creation by specifying the method parameter, or null if any of the customer's valid mandates may be used.
     * <p>Possible values: creditcard directdebit null</p>
     */
    public String getMethod() {
        return method;
    }

    public Date getCancelledDatetime() {
        return cancelledDatetime;
    }

    public Links getLinks() {
        return links;
    }
}
