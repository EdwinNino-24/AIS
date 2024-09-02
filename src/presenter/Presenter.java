package presenter;

import model.Candidate;
import model.CandidateComparator;
import model.InformationSystem;
import view.View;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.toedter.calendar.JCalendar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Presenter {

    private final InformationSystem model;
    private final View view;

    public Presenter(InformationSystem model, View view) {
        this.model = model;
        this.view = view;

        // Obtener el calendario de la vista
        JCalendar calendar = view.getCalendar();

        // Agregar un PropertyChangeListener al calendario
        calendar.addPropertyChangeListener("calendar", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                Date selectedDate = calendar.getDate();
                if (selectedDate != null) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String formattedDate = dateFormat.format(selectedDate);
                    view.getDateField().setText(formattedDate);
                }
            }
        });

        this.view.setAddButtonListener(new AddButtonListener());
        this.view.setShowCalendarButtonListener(new ShowCalendarButtonListener());
    }

    class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String firstName = view.getFirstName();
            String lastName = view.getLastName();
            String ethnicity = view.getEthnicity();
            String date = view.getDate();
            int icfes = view.getIcfesScore();
            int math = view.getMathScore();
            int english = view.getEnglishScore();

            Candidate newCandidate = new Candidate(firstName, lastName, ethnicity, date, icfes, math, english);
            model.addCandidate(newCandidate);
            model.getCandidates().sort(new CandidateComparator());

            view.getTableModel().setRowCount(0);
            for (Candidate candidate : model.getCandidates()) {
                view.getTableModel().addRow(new Object[]{
                        candidate.getFirstName(),
                        candidate.getLastName(),
                        candidate.getEthnicity(),
                        candidate.getRegistrationDate(),
                        candidate.getIcfesScore(),
                        candidate.getMathScore(),
                        candidate.getEnglishScore()});
            }
        }
    }

    class ShowCalendarButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean visible = !view.getCalendar().isVisible();
            view.setCalendarVisibility(visible);
        }
    }
}
