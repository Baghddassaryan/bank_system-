package models;


import enums.ServiceType;

import java.time.LocalDateTime;

/**
 * Represents a customer appointment at the bank.
 */
public class Appointment {
    private String customerName;
    private ServiceType serviceType;
    private LocalDateTime preferredTime;
    private int priority; // lower number = higher priority

    public Appointment(String customerName, ServiceType serviceType,
                       LocalDateTime preferredTime, int priority) {
        if (customerName == null || customerName.isBlank()) {
            throw new IllegalArgumentException("Customer name cannot be empty.");
        }
        if (priority < 0) {
            throw new IllegalArgumentException("Priority must be non-negative.");
        }
        this.customerName = customerName;
        this.serviceType = serviceType;
        this.preferredTime = preferredTime;
        this.priority = priority;
    }

    public String getCustomerName() { return customerName; }
    public ServiceType getServiceType() { return serviceType; }
    public LocalDateTime getPreferredTime() { return preferredTime; }
    public int getPriority() { return priority; }

    @Override
    public String toString() {
        return String.format("Appointment[customer=%s, service=%s, time=%s, priority=%d]",
                customerName, serviceType, preferredTime, priority);
    }
}