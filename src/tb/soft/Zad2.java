package tb.soft;// W Twoim interfejsie Swing umożliw użytkownikom dynamiczną zmianę koloru, rozmiaru i pozycji komponentów.
// Dodaj przyciski, które, po kliknięciu, zmienią kolor określonego komponentu, zmienią jego rozmiar lub przesuną
// wewnątrz JFrame. Możesz użyć JDialog lub JOptionPane do pobierania od użytkownika informacji (np. wyboru koloru).


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zad2 {
    private final JFrame frame;
    private final JPanel panel;
    private final JLabel labelUsername, labelPassword;
    private final JTextField textField;
    private final JPasswordField passwordField;
    private final JButton button, colorButton, resizeButton, moveButton;
    private final JTextArea textArea;

    public Zad2(String[] args) {
        frame = new JFrame("Logowanie");
        panel = new JPanel(new GridBagLayout());
        labelUsername = new JLabel("Nazwa użytkownika:");
        labelPassword = new JLabel("Hasło:");
        textField = new JTextField(25);
        passwordField = new JPasswordField(25);
        button = new JButton("Zaloguj");
        colorButton = new JButton("Zmień kolor przycisku \"Zaloguj\"");
        resizeButton = new JButton("Zmień rozmiar przycisku \"Zaloguj\"");
        moveButton = new JButton("Przesuń przycisk \"Zaloguj\"");
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

        // Ustawienia miejsca i dodanie do Panel dla colorButton
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(colorButton, gbc);

        // Ustawienia miejsca i dodanie do Panel dla resizeButton
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(resizeButton, gbc);

        // Ustawienia miejsca i dodanie do Panel dla moveButton
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2; // Rozciąga na całą szerokość panelu
        gbc.fill = GridBagConstraints.HORIZONTAL;               // Wypełnia całą szerokość
        panel.add(moveButton, gbc);

        // Obsługa zdarzeń dla przycisku Zaloguj
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

        // Obsługa zdarzeń dla przycisku zmiany koloru
        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color newColor = JColorChooser.showDialog(frame, "Okno dialogowe do wyboru koloru", Color.BLUE);
                if (newColor != null) {
                    button.setBackground(newColor);
                }
            }
        });

        // Obsługa zdarzeń dla przycisku zmiany rozmiaru
        resizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newWidth = JOptionPane.showInputDialog(frame, "Podaj nową szerokość:");
                String newHeight = JOptionPane.showInputDialog(frame, "Podaj nową wysokość:");

                try {
                    int width = Integer.parseInt(newWidth);
                    int height = Integer.parseInt(newHeight);
                    button.setSize(width, height);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Wprowadź poprawne liczby.");
                }
            }
        });

        // Obsługa zdarzeń dla przycisku zmiany położenia
        moveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newX = JOptionPane.showInputDialog(frame, "Podaj nową pozycję X dla przycisku \"Zaloguj\"");
                String newY = JOptionPane.showInputDialog(frame, "Podaj nową pozycję Y dla przycisku \"Zaloguj\"");

                try{
                    int x = Integer.parseInt(newX);
                    int y = Integer.parseInt(newY);
                    button.setLocation(x,y);
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame, "Wprowadź poprawne dane");
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Zad2(args).show();
            }
        });
    }
}
