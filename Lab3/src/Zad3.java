import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zad3 {
    static JFrame frame;
    static JTextArea textArea;

    // Konstruktor
    Zad3(String[] args) {                                                   // Inicjalizacja okna
        // Tworzenie ramki
        frame = new JFrame("Zadanie numer 3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);               // Ustawienie akcji przy zamknięciu okna
        frame.setSize(600, 400);                                // Ustawienie rozmiaru okna

        // Wywołanie dialogu do wprowadzenia imienia
        String name = JOptionPane.showInputDialog(frame, "Podaj swoje imię:", "Zadanie numer 3",
                JOptionPane.PLAIN_MESSAGE);

        if (name == null || name.trim().isEmpty()) {                        // Jeśli użytkownik nic nie wpisał
            name = "Nieznajomy";
        }

        // Tworzenie komponentów
        textArea = new JTextArea("Witaj " + name);
        textArea.setEditable(false);                                        // JTextArea tylko do odczytu

        // Ustawianie układu
        JPanel panel = new JPanel(new GridBagLayout());                     // GridBagLayout do centrowania

        panel.add(textArea);

        panel.setBackground(Color.decode("#DC667C"));                  // Ustawienie koloru tła
        textArea.setBackground(Color.decode("#DC667C"));               // Ustawienie koloru tła
        textArea.setFont(new Font("Arial", Font.BOLD, 24));     // Ustawienie czcionki
        textArea.setForeground(Color.WHITE); // Ustawienie koloru tekstu

        frame.add(panel);
    }

    // Metoda do wyświetlania okna
    public void show() {
        frame.setLocationRelativeTo(null);                                 // Ustawienie okna na środku ekranu
        frame.setVisible(true);                                            // Ustawienie widoczności okna
    }

    // Punkt wejścia programu
    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Zad3(args).show();
            }
        });
    }
}