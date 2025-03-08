package org.petstore.models.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.OffsetDateTimeSerializer;

import java.time.OffsetDateTime;

public class Order {
    @JsonProperty("id")
    private long id;

    @JsonProperty("petId")
    private long petId;

    @JsonProperty("quantity")
    private int quantity;

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = InstantDeserializer.class)
    @JsonProperty("shipDate")
    private OffsetDateTime shipDate;

    @JsonProperty("status")
    private String status; // Enum: "placed", "approved", "delivered"

    @JsonProperty("complete")
    private boolean complete;

    public Order() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPetId() {
        return petId;
    }

    public void setPetId(long petId) {
        this.petId = petId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OffsetDateTime getShipDate() {
        return shipDate;
    }

    public void setShipDate(OffsetDateTime shipDate) {
        this.shipDate = shipDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}