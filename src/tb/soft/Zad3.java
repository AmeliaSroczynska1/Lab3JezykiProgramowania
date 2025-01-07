package tb.soft;// Stwórz okno dialogowe, które prosi użytkownika o podanie swojego imienia. Po kliknięciu "OK" wyświetl
// wiadomość powitalną w głównym oknie za pomocą JOptionPane lub niestandardowego okna dialogowego (JDialog).
// Upewnij się, że okno dialogowe można łatwo zamknąć, a wprowadzone imię może być wyświetlane w głównym oknie.

import javax.swing.*;
import java.awt.*;

public class Zad3 {
    private final JFrame frame;
    private final JPanel panel;
    private final JTextArea textArea;

    Zad3(String[] args) {
        frame = new JFrame("Okno powitalne");
        panel = new JPanel();
        textArea = new JTextArea();
    }

    public void show() {
        // Ustawienia głównego okna
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);                      // Ustawienie okna na środku ekranu

        panel.setBackground(Color.decode("#DC667C"));       // Ustawienie koloru tła
        textArea.setBackground(Color.decode("#DC667C"));
        textArea.setFont(new Font("Arial", Font.BOLD, 24));     // Ustawienie czcionki
        textArea.setForeground(Color.WHITE); // Ustawienie koloru tekstu
        textArea.setEditable(false);                                // JTextArea tylko do odczytu
        panel.add(textArea);

        String name = JOptionPane.showInputDialog(frame, "Wprowadź swoj imię");

        textArea.setText("Witaj " + name);

        frame.setVisible(true);
    }

    public static void main(final String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Zad3(args).show();
            }
        });
    }
}