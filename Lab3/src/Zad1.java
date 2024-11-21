import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zad1 {
    static JFrame frame;
    static JButton button;
    static JLabel label, label1;
    static JTextField textField;
    static JPasswordField passwordField;
    static JTextArea textArea;

    // Konstruktor
    Zad1(String[] args) {                                           // Inicjalizacja okna
        // Tworzenie ramki
        frame = new JFrame("Zadanie numer 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       // Ustawienie akcji przy zamknięciu okna
        frame.setSize(600, 400);                       // Ustawienie rozmiaru okna

        // Tworzenie komponentów
        label = new JLabel("Nazwa użytkownika: ");
        label1 = new JLabel("Hasło: ");
        button = new JButton("Zaloguj");
        textField = new JTextField(15);
        passwordField = new JPasswordField(15);
        textArea = new JTextArea();
        textArea.setEditable(false);                                // JTextArea tylko do odczytu

        // Ustawianie układu
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Odstępy między elementami

        // Ustawienia miejsca i dodanie do Panel dla label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;                   // Wyrównanie do prawej
        panel.add(label, gbc);

        // Ustawienia miejsca i dodanie do Panel dla textField
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;                   // Wyrównanie do lewej
        panel.add(textField, gbc);

        // Ustawienia miejsca i dodanie do Panel dla label2
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(label1, gbc);

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

        panel.setBackground(Color.decode("#DC667C"));       // Ustawienie koloru tła
        textArea.setBackground(Color.decode("#DC667C"));       // Ustawienie koloru tła
        textField.setBackground(Color.decode("#DC667C"));       // Ustawienie koloru tła
        passwordField.setBackground(Color.decode("#DC667C"));       // Ustawienie koloru tła
        button.setBackground(Color.decode("#A3A3A3"));       // Ustawienie koloru tła

        frame.add(panel);

        // Dodanie akcji do przycisku
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pobieranie danych z JTextField i JPasswordField
                String username = textField.getText();
                String password = new String(passwordField.getPassword());

                // Dodanie danych do JTextArea
                textArea.append("Nazwa użytkownika: " + username + "\n");
                textArea.append("Hasło: " + password);

                textField.setText("");                          // Czyszczenie danych
                passwordField.setText("");
            }
        });

    }

    // Metoda do wyświetlania okna
    public void show() {
        frame.setLocationRelativeTo(null);                      // Ustawienie okna na środku ekranu
        frame.setVisible(true);                                 // Ustawienie widoczności okna
    }

    // Punkt wejścia programu
    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Zad1(args).show();
            }
        });
    }
}