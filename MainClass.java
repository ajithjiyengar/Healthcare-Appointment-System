import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import package12.Appointment;
import package12.Doctor;
import package12.Patient;

public class MainClass {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Healthcare Appointment System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 2, 10, 10));
        JLabel doctorLabel = new JLabel("Enter Doctor's Name:");
        JTextField doctorField = new JTextField();
        frame.add(doctorLabel);
        frame.add(doctorField);
        JLabel patientLabel = new JLabel("Enter Patient's Name:");
        JTextField patientField = new JTextField();
        frame.add(patientLabel);
        frame.add(patientField);
        JLabel dateLabel = new JLabel("Enter Appointment Date (MM/dd/yyyy):");
        JTextField dateField = new JTextField();
        frame.add(dateLabel);
        frame.add(dateField);
        JButton createButton = new JButton("Create Appointment");
        frame.add(createButton);
        JLabel outputLabel = new JLabel("");
        frame.add(outputLabel);
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String doctorName = doctorField.getText();
                String patientName = patientField.getText();
                String dateString = dateField.getText();
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                Date date = null;

                try {
                    date = dateFormat.parse(dateString);
                    Doctor doctor = new Doctor(doctorName);
                    Patient patient = new Patient(patientName);
                    Appointment appointment = new Appointment(doctor, patient, date);
                    outputLabel.setText("<html>Appointment Created:<br>" + appointment.toString() + "</html>");

                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid date format. Please use MM/dd/yyyy.");
                }
            }
        });

        frame.setVisible(true);
    }
}
