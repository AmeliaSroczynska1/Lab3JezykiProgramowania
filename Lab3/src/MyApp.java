import javax.swing.*;
import java.awt.*;

public class MyApp extends JFrame {  // Klasa dziedziczy po JFrame

    // Konstruktor
    MyApp(String[] args) {
        // Inicjalizacja okna
        //super("Okno1"); // Ustawienie tytułu okna
        setSize(500, 400);     // Ustawienie rozmiaru okna
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ustawienie akcji przy zamknięciu okna
        setLocation(50,50);
        setLayout(new GridLayout(2, 6));

        add(new JButton("Przycisk 1"));
        add(new JButton("Przycisk 2"));
        add(new JButton("Przycisk 3"));
    }

    // Metoda do wyświetlania okna
    public void showWindow() {
        setVisible(true);  // Ustawienie widoczności okna
    }

    // Punkt wejścia programu
    public static void main(final String[] args) {
        // Wywołanie zadania na wątku dystrybucji zdarzeń (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MyApp(args).showWindow();  // Tworzenie instancji MyApp i wyświetlanie okna
            }
        });
    }
}
