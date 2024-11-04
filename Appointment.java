package package12;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Appointment {
    private Doctor doctor;
    private Patient patient;
    private Date date;

    public Appointment(Doctor doctor, Patient patient, Date date) {
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return "Doctor: " + doctor.getName() + ", Patient: " + patient.getName() + ", Date: " + dateFormat.format(date);
    }
}
