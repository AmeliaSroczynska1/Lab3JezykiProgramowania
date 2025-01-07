// Utwórz aplikację GUI do zarządzania listą kontaktów, w której użytkownicy mogą dodawać, edytować i usuwać
// kontakty. Każdy wpis kontaktu powinien zawierać pola na imię, numer telefonu i adres e-mail. Pozwól użytkownikom
// modyfikować lub usuwać kontakty oraz wyświetlaj listę kontaktów w obszarze przewijalnym.

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zad6 {

    private final JFrame frame;
    private final JTable table;
    private final DefaultTableModel tableModel;
    private final JTextField nameField;
    private final JTextField phoneField;
    private final JTextField emailField;
    private final JScrollPane scrollPane;
    private final JPanel panel;
    private final JButton addButton;
    private final JButton editButton;
    private final JButton deleteButton;

    public Zad6(String[] args) {
        frame = new JFrame("Lista kontaktów");
        tableModel = new DefaultTableModel(new Object[]{"Imię", "Numer", "Email"}, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);

        panel = new JPanel(new GridLayout(4, 2, 5, 5));
        nameField = new JTextField();
        phoneField = new JTextField();
        emailField = new JTextField();

        addButton = new JButton("Dodaj kontakt");
        editButton = new JButton("Edytuj kontakt");
        deleteButton = new JButton("Usuń kontakt");
    }

    public void show() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.getContentPane().setBackground(Color.decode("#DC667C")); // Ustawienie tła okna
        panel.setBackground(Color.decode("#DC667C")); // Ustawienie tła panelu
        scrollPane.getViewport().setBackground(Color.decode("#DC667C")); // Tło dla JScrollPane
        table.setBackground(Color.decode("#DC667C")); // Tło dla tabeli

        frame.setLocationRelativeTo(null); // Ustawienie okna na środku ekranu

        panel.add(addButton);
        panel.add(editButton);
        panel.add(deleteButton);

        panel.add(new JLabel("Imię:"));
        panel.add(nameField);
        panel.add(new JLabel("Numer:"));
        panel.add(phoneField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addContact();
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editContact();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteContact();
            }
        });

        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void addContact() {
        String name = nameField.getText().trim();
        String phone = phoneField.getText().trim();
        String email = emailField.getText().trim();

        if (!name.isEmpty() && !phone.isEmpty() && !email.isEmpty()) {
            tableModel.addRow(new Object[]{name, phone, email});
            clearFields();
        } else {
            JOptionPane.showMessageDialog(frame, "Uzupełnij wszystkie pola", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editContact() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String name = nameField.getText().trim();
            String phone = phoneField.getText().trim();
            String email = emailField.getText().trim();

            if (!name.isEmpty() && !phone.isEmpty() && !email.isEmpty()) {
                tableModel.setValueAt(name, selectedRow, 0);
                tableModel.setValueAt(phone, selectedRow, 1);
                tableModel.setValueAt(email, selectedRow, 2);
                clearFields();
            } else {
                JOptionPane.showMessageDialog(frame, "Uzupełnij wszystkie pola.", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Wybierz kontakt, który chcesz edytować.", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteContact() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(frame, "Wybierz kontakt do usunięcia.", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        nameField.setText("");
        phoneField.setText("");
        emailField.setText("");
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Zad6(args).show();
            }
        });
    }
}
