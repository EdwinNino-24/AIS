package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class View extends JFrame {

    private JTextField firstNameField, lastNameField, ethnicityField, dateField, icfesField , mathField, englishField;
    private JButton addButton;
    JTable table;
    private DefaultTableModel tableModel;

    public View() {
        setupUI();
    }

    private void setupUI() {
        setTitle("Candidatos Admitidos 2025-1 | Ingeniería de Sistemas y Computación");
        setSize(850, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(8, 2));

        firstNameField = new JTextField();
        lastNameField = new JTextField();
        ethnicityField = new JTextField();
        dateField = new JTextField(new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime()));
        dateField.setEnabled(false);
        icfesField = new JTextField();
        mathField = new JTextField();
        englishField = new JTextField();

        ((PlainDocument) icfesField.getDocument()).setDocumentFilter(new DigitFilter());
        ((PlainDocument) mathField.getDocument()).setDocumentFilter(new DigitFilter());
        ((PlainDocument) englishField.getDocument()).setDocumentFilter(new DigitFilter());

        inputPanel.add(new JLabel("     Nombres:"));
        inputPanel.add(firstNameField);
        inputPanel.add(new JLabel("     Apellidos:"));
        inputPanel.add(lastNameField);
        inputPanel.add(new JLabel("     Etnia:"));
        inputPanel.add(ethnicityField);
        inputPanel.add(new JLabel("     Fecha de Inscripción:     "));
        inputPanel.add(dateField);
        inputPanel.add(new JLabel("     Puntaje ICFES:"));
        inputPanel.add(icfesField);
        inputPanel.add(new JLabel("     Puntaje Matemáticas:"));
        inputPanel.add(mathField);
        inputPanel.add(new JLabel("     Puntaje Inglés:"));
        inputPanel.add(englishField);

        addButton = new JButton("Añadir");
        inputPanel.add(new JLabel(""));
        inputPanel.add(addButton);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nombres");
        tableModel.addColumn("Apellidos");
        tableModel.addColumn("Etnia");
        tableModel.addColumn("Fecha");
        tableModel.addColumn("ICFES");
        tableModel.addColumn("Matemáticas");
        tableModel.addColumn("Inglés");

        table = new JTable(tableModel);
        table.setEnabled(false);
        table.setAutoResizeMode(1);
        JScrollPane tableScrollPane = new JScrollPane(table);

        add(inputPanel, BorderLayout.WEST);
        add(tableScrollPane, BorderLayout.EAST);
    }

    public String getFirstName() {
        return firstNameField.getText();
    }

    public String getLastName() {
        return lastNameField.getText();
    }

    public String getEthnicity() {
        return ethnicityField.getText();
    }

    public String getDate() {
        return dateField.getText();
    }

    public int getIcfesScore() {
        return Integer.parseInt(icfesField.getText());
    }

    public int getMathScore() {
        return Integer.parseInt(mathField.getText());
    }

    public int getEnglishScore() {
        return Integer.parseInt(englishField.getText());
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void setAddButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    static class DigitFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (string != null && string.matches("\\d+")) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (text != null && text.matches("\\d+")) {
                super.replace(fb, offset, length, text, attrs);
            }
        }
    }

}