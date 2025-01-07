package tb.soft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Example {
    private final JFrame frame;          // Główne okno aplikacji
    private final JPanel panel;
    private final JTextField textField; // Pole tekstowe
    private final JLabel label;         // Etykieta, aby wyświetlać tekst użytkownika
    private final JButton submitButton, clearButton;     // Przycisk

    // Konstruktor
    Example(String[] args) {
        panel = new JPanel();
        // Inicjalizacja głównych komponentów GUI
        frame = new JFrame("MyApp - Przykład GUI");
        textField = new JTextField(20);
        label = new JLabel("Wpisz coś i kliknij przycisk:");
        submitButton = new JButton("Wyślij");
        clearButton = new JButton("Wyczyść");
    }

    // Metoda do tworzenia i wyświetlania GUI
    public void show() {
        // Ustawienia głównego okna
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);               // Zamyka aplikację po kliknięciu "X"
        frame.setSize(400, 200);                               // Ustawienie rozmiaru okna
        frame.setBackground(Color.decode("#FFFFFF"));                  // Ustawienie koloru tła
        textField.setFont(new Font("Arial", Font.BOLD, 11));    // Ustawienie czcionki
        textField.setForeground(Color.BLACK);                              // Ustawienie koloru tekstu
        frame.setLocationRelativeTo(null);                                 // Ustawienie okna na środku ekranu

        // Panel z elementami GUI
        panel.setLayout(new FlowLayout());      // Ustawiamy układ FlowLayout (komponenty obok siebie)

        // Dodawanie komponentów do panelu
        panel.add(label);        // Dodajemy etykietę
        panel.add(textField);    // Dodajemy pole tekstowe
        panel.add(submitButton); // Dodajemy przycisk do zatwierdzania
        panel.add(clearButton);  // Dodajemy przycisk do czyszczenia

        // Obsługa zdarzeń dla przycisków
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText(); // Pobieramy tekst z pola tekstowego
                if (text.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Pole nie może być puste!", "Błąd", JOptionPane.ERROR_MESSAGE); // Tworzymy nowe okno z komunikatem błędu
                } else {
                    label.setText("Wpisałeś: " + text); // Ustawiamy nowy tekst na etykiecie
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(""); // Czyścimy pole tekstowe
                label.setText("Wpisz coś i kliknij przycisk:"); // Resetujemy etykietę
            }
        });

        // Dodanie panelu do okna
        frame.add(panel, BorderLayout.CENTER);

        // Wyświetlenie okna
        frame.setVisible(true);
    }

    // Metoda główna
    public static void main(final String[] args) {
        // Uruchamiamy GUI na wątku EDT
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Example(args).show();
            }
        });
    }
}
