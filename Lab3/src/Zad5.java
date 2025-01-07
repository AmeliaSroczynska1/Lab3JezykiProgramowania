// Stwórz GUI do sprawdzania siły hasła. Udostępnij pole tekstowe do wprowadzania haseł oraz przycisk do sprawdzania
// siły hasła. Zaimplementuj logikę oceny siły hasła (np. długość, rodzaje znaków) i wyświetl wynik w oknie dialogowym
// lub na interfejsie.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zad5 {
    private final JFrame frame;
    private final JPanel panel;
    private final JLabel labelUsername, labelPassword;
    private final JTextField textField;
    private final JPasswordField passwordField;
    private final JButton button;
    private final JButton buttonCheck;

    public Zad5(String[] args) {
        frame = new JFrame("Logowanie");
        panel = new JPanel(new GridBagLayout());
        labelUsername = new JLabel("Nazwa użytkownika:");
        labelPassword = new JLabel("Hasło:");
        textField = new JTextField(15);
        passwordField = new JPasswordField(15);
        button = new JButton("Zaloguj");
        buttonCheck = new JButton("Sprawdź siłę swojego hasła");
    }

    public void show() {
        // Ustawienia głównego okna
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);                      // Ustawienie okna na środku ekranu

        panel.setBackground(Color.decode("#DC667C"));       // Ustawienie koloru tła
        textField.setBackground(Color.decode("#DC667C"));
        passwordField.setBackground(Color.decode("#DC667C"));

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
        panel.add(buttonCheck, gbc);

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
                    textField.setText("");
                    passwordField.setText("");
                }
            }
        });

        buttonCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);
                String passwordStrength;
                int specialCharCount = 0;

                // Zestaw znaków specjalnych
                String specialChars = "!@#$%^&*()_+-=[]{}|;:',.<>?/";

                // Iteracja przez każdy znak w haśle
                for (char c : password.toCharArray()) {
                    if (specialChars.contains(String.valueOf(c))) {
                        specialCharCount++;
                    }
                }
                if(specialCharCount<2) passwordStrength = "Słabe";
                else if(specialCharCount<6) passwordStrength = "Średnie";
                else passwordStrength = "Mocne";

                JOptionPane.showMessageDialog(null, passwordStrength, "Siła hasła w skali 1-10:", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        frame.setVisible(true);
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Zad5(args).show();
            }
        });
    }
}
