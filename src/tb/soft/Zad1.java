// Stwórz prostą aplikację GUI w Swing, która zawiera JFrame z tytułem, rozmiarem i opcją
// zamykania. Wewnątrz JFrame dodaj JPanel z kilkoma komponentami: JLabel, JTextField,
// JPasswordField, JButton i JTextArea. Pozwól użytkownikom wprowadzać tekst w polach tekstowych i
// wyświetlać wprowadzone dane w JTextArea po kliknięciu przycisku.
package tb.soft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zad1 {
    private final JFrame frame;
    private final JPanel panel;
    private final JLabel labelUsername, labelPassword;
    private final JTextField textField;
    private final JPasswordField passwordField;
    private final JButton button;
    private final JTextArea textArea;

    public Zad1(String[] args) {
        frame = new JFrame("Logowanie");
        panel = new JPanel(new GridBagLayout());
        labelUsername = new JLabel("Nazwa użytkownika:");
        labelPassword = new JLabel("Hasło:");
        textField = new JTextField(15);
        passwordField = new JPasswordField(15);
        button = new JButton("Zaloguj");
        textArea = new JTextArea();
    }

    public void show() {
        // Ustawienia głównego okna
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);                      // Ustawienie okna na środku ekranu
        textArea.setEditable(false);                                // JTextArea tylko do odczytu

        panel.setBackground(Color.decode("#DC667C"));       // Ustawienie koloru tła
        textArea.setBackground(Color.decode("#DC667C"));
        textField.setBackground(Color.decode("#DC667C"));
        passwordField.setBackground(Color.decode("#DC667C"));
        button.setBackground(Color.decode("#A3A3A3"));

        // Ustawianie układu
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Odstępy między elementami

        // Ustawienia miejsca i dodanie do Panel dla label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;                   // Wyrównanie do prawej
        panel.add(labelUsername, gbc);

        // Ustawienia miejsca i dodanie do Panel dla textField
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;                   // Wyrównanie do lewej
        panel.add(textField, gbc);

        // Ustawienia miejsca i dodanie do Panel dla label2
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(labelPassword, gbc);

        // Ustawienia miejsca i dodanie do Panel dla passwordField
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(passwordField, gbc);

        // Ustawienia miejsca i dodanie do Panel dla button
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(button, gbc);

        // Ustawienia miejsca i dodanie do Panel dla textArea
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2; // Rozciąga na całą szerokość panelu
        gbc.fill = GridBagConstraints.HORIZONTAL;               // Wypełnia całą szerokość
        panel.add(textArea, gbc);

        // Obsługa zdarzeń dla przycisków
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = textField.getText(); // Pobieramy tekst z pola tekstowego
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);
                if (login.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Musisz podać nazwę użytkowanika!", "Błąd", JOptionPane.ERROR_MESSAGE); // Tworzymy nowe okno z komunikatem błędu
                }
                else if(password.isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Musisz podać hasło!", "Błąd", JOptionPane.ERROR_MESSAGE); // Tworzymy nowe okno z komunikatem błędu
                }
                else {
                    textArea.setText("Twoja nazwa użytkowanika: " + login + "\nTwoje hasło: " + password); // Ustawiamy nowy tekst na etykiecie
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Zad1(args).show();
            }
        });
    }
}
