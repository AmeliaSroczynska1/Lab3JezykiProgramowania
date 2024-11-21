import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zad2 {
    static JFrame frame;
    static JButton button, colorButton, resizeButton, moveButton;
    static JLabel label, label1;
    static JTextField textField;
    static JPasswordField passwordField;
    static JTextArea textArea;

    // Konstruktor
    Zad2(String[] args) {
        // Tworzenie ramki
        frame = new JFrame("Zadanie numer 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ustawienie akcji przy zamknięciu okna
        frame.setSize(600, 400);                 // Ustawienie rozmiaru okna

        // Tworzenie komponentów
        label = new JLabel("Nazwa użytkownika: ");
        label1 = new JLabel("Hasło: ");
        button = new JButton("Zaloguj");
        textField = new JTextField(15);
        passwordField = new JPasswordField(15);
        textArea = new JTextArea();
        colorButton = new JButton("Zmień kolor przycisku \"Zaloguj\"");
        resizeButton = new JButton("Zmień rozmiar przycisku \"Zaloguj\"");
        moveButton = new JButton("Przesuń przycisk \"Zaloguj\"");

        textArea.setEditable(false);                        // JTextArea tylko do odczytu

        // Ustawianie układu
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Odstępy między elementami

        // Ustawienia miejsca i dodanie do Panel dla label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST; // Wyrównanie do prawej
        panel.add(label, gbc);

        // Ustawienia miejsca i dodanie do Panel dla textField
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST; // Wyrównanie do lewej
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
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(button, gbc);

        // Ustawienia miejsca i dodanie do Panel dla textArea
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2; // Rozciąga na całą szerokość panelu
        gbc.fill = GridBagConstraints.HORIZONTAL; // Wypełnia całą szerokość
        panel.add(textArea, gbc);

        // Ustawienia miejsca i dodanie do Panel dla colorButton
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panel.add(colorButton, gbc);

        // Ustawienia miejsca i dodanie do Panel dla resizeButton
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(resizeButton, gbc);

        // Ustawienia miejsca i dodanie do Panel dla moveButton
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        panel.add(moveButton, gbc);

        // Ustawienie kolorów tła
        panel.setBackground(Color.decode("#DC667C"));
        textArea.setBackground(Color.decode("#DC667C"));
        textField.setBackground(Color.decode("#DC667C"));
        passwordField.setBackground(Color.decode("#DC667C"));

        frame.add(panel);

        // Dodanie akcji do przycisku "Zaloguj"
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textField.getText();                      // Pobieranie danych z JTextField i JPasswordField
                String password = new String(passwordField.getPassword());

                textArea.append("Nazwa użytkownika: " + username + "\n");   // Dodanie danych do JTextArea
                textArea.append("Hasło: " + password);

                textField.setText("");                                      // Czyszczenie danych
                passwordField.setText("");
            }
        });

        // Dodanie akcji do przycisku zmiany koloru przycisku "Zaloguj"
        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color newColor = JColorChooser.showDialog(frame, "Okno dialogowe do wyboru koloru", Color.RED);
                if (newColor != null) {
                    button.setBackground(newColor);
                }
            }
        });

        // Dodanie akcji do przycisku zmiany rozmiaru przycisku "Zaloguj"
        resizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newWidth = JOptionPane.showInputDialog(frame, "Podaj nową szerokość:");
                String newHeight = JOptionPane.showInputDialog(frame, "Podaj nową wysokość:");

                try {
                    int width = Integer.parseInt(newWidth);
                    int height = Integer.parseInt(newHeight);
                    frame.setSize(width, height);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Wprowadź poprawne liczby.");
                }
            }
        });

        // Dodanie akcji do przycisku przesunięcia
        moveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newX = JOptionPane.showInputDialog(frame, "Podaj nową pozycję X dla przycisku \"Zaloguj\" w oknie:");
                String newY = JOptionPane.showInputDialog(frame, "Podaj nową pozycję Y dla przycisku \"Zaloguj\" w oknie:");

                try {
                    int x = Integer.parseInt(newX);
                    int y = Integer.parseInt(newY);
                    button.setLocation(x, y);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Wprowadź poprawne liczby.");
                }
            }
        });
    }

    // Metoda do wyświetlania okna
    public void show() {
        frame.setLocationRelativeTo(null); // Ustawienie okna na środku ekranu
        frame.setVisible(true); // Ustawienie widoczności okna
    }

    // Punkt wejścia programu
    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Zad2(args).show();
            }
        });
    }
}
