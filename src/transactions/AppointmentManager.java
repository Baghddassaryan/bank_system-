package transactions;

import models.Appointment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Manages scheduling and retrieving customer appointments.
 */
public class AppointmentManager {
    private final List<Appointment> appointments = new ArrayList<>();

    /**
     * View all scheduled appointments.
     *
     * @return list of appointments
     */
    public List<Appointment> viewAllAppointments() {
        return new ArrayList<>(appointments); // возвращаем копию, чтобы список нельзя было извне менять
    }

    /**
     * Get the next appointment (based on priority and time).
     *
     * @return next appointment, or null if no appointments exist
     */
    public Appointment getNextAppointment() {
        return appointments.stream()
                .min(Comparator.comparingInt(Appointment::getPriority)
                        .thenComparing(Appointment::getPreferredTime))
                .orElse(null);
    }

    /**
     * Schedule a new appointment.
     *
     * @param appointment the appointment to add
     */
    public void scheduleAppointment(Appointment appointment) {
        appointments.add(appointment);
    }
}