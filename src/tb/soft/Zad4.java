package tb.soft;// Stwórz prosty interfejs kalkulatora, który zawiera przyciski z cyframi i podstawowymi operacjami (dodawanie,
// odejmowanie, mnożenie, dzielenie). Pozwól użytkownikom wykonywać obliczenia i wyświetlać wyniki w polu JTextField
// lub JLabel. Upewnij się, że elementy GUI są odpowiednio dostosowane pod względem rozmiaru i pozycji.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Zad4 {
    private final JFrame frame; // Główne okno aplikacji
    private final JPanel panel; // Panel, który przechowuje komponenty
    private final JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9,
            buttonEqual, buttonMinus, buttonPlus, buttonMultiply, buttonDivide, buttonClear; // Przyciski dla cyfr i operacji
    private final JTextField textField; // Pole tekstowe do wyświetlania wprowadzanych danych i wyników
    private String currentText = ""; // Aktualny tekst wprowadzony przez użytkownika
    private double firstNumber = 0; // Pierwsza liczba używana w obliczeniach
    private String operator = ""; // Aktualnie wybrany operator matematyczny

    public Zad4(String[] args) {
        frame = new JFrame("Kalkulator");
        panel = new JPanel(new GridBagLayout());
        textField = new JTextField();
        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        buttonEqual = new JButton("=");
        buttonMinus = new JButton("-");
        buttonPlus = new JButton("+");
        buttonMultiply = new JButton("*");
        buttonDivide = new JButton("/");
        buttonClear = new JButton("C");

        addListeners();
    }

    private void addListeners() {
        // Dopisuje cyfrę do `currentText` i wyświetla w polu tekstowym
        ActionListener numberListener = e -> {
            JButton source = (JButton) e.getSource(); // Pobiera przycisk, który wywołał zdarzenie
            currentText += source.getText(); // Dodaje tekst przycisku do `currentText`
            textField.setText(currentText); // Wyświetla zaktualizowany tekst w polu tekstowym
        };

        // Dodanie słuchacza do wszystkich przycisków cyfr
        button0.addActionListener(numberListener);
        button1.addActionListener(numberListener);
        button2.addActionListener(numberListener);
        button3.addActionListener(numberListener);
        button4.addActionListener(numberListener);
        button5.addActionListener(numberListener);
        button6.addActionListener(numberListener);
        button7.addActionListener(numberListener);
        button8.addActionListener(numberListener);
        button9.addActionListener(numberListener);

        // Dodanie słuchaczy do przycisków operatorów
        buttonPlus.addActionListener(e -> setOperator("+"));
        buttonMinus.addActionListener(e -> setOperator("-"));
        buttonMultiply.addActionListener(e -> setOperator("*"));
        buttonDivide.addActionListener(e -> setOperator("/"));

        // Oblicza wynik i wyświetla go w polu tekstowym
        buttonEqual.addActionListener(e -> calculateResult());

        // Dodanie słuchacza do przycisku "C" - resetuje wszystkie dane kalkulatora
        buttonClear.addActionListener(e -> {
            currentText = ""; // Czyści bieżący tekst
            firstNumber = 0; // Resetuje pierwszą liczbę
            operator = ""; // Resetuje operator
            textField.setText(""); // Czyści pole tekstowe
        });
    }

    private void setOperator(String op) {
        // Ustawia operator i zapisuje pierwszą liczbę
        try {
            firstNumber = Double.parseDouble(currentText); // Parsuje bieżący tekst jako liczbę
            operator = op; // Zapisuje operator
            currentText = ""; // Czyści bieżący tekst, aby można było wprowadzić drugą liczbę
            textField.setText(""); // Czyści pole tekstowe
        } catch (NumberFormatException ex) {
            textField.setText("Błąd!"); // Wyświetla błąd, jeśli wprowadzono nieprawidłowe dane
        }
    }

    private void calculateResult() {
        // Oblicza wynik na podstawie operatora i dwóch liczb
        try {
            double secondNumber = Double.parseDouble(currentText); // Parsuje bieżący tekst jako drugą liczbę
            double result = switch (operator) { // Wykonuje odpowiednie działanie matematyczne
                case "+" -> firstNumber + secondNumber;
                case "-" -> firstNumber - secondNumber;
                case "*" -> firstNumber * secondNumber;
                case "/" -> secondNumber != 0 ? firstNumber / secondNumber : Double.NaN; // sprawdza czy dzielenie przez 0
                default -> 0; // Wartość domyślna w przypadku braku operatora
            };
            currentText = String.valueOf(result); // Przekształca wynik na tekst
            textField.setText(currentText); // Wyświetla wynik w polu tekstowym
            firstNumber = result; // Ustawia wynik jako nową pierwszą liczbę
            operator = ""; // Resetuje operator
        } catch (NumberFormatException ex) {
            textField.setText("Błąd!"); // Wyświetla błąd, jeśli wprowadzono nieprawidłowe dane
        }
    }

    public void show() {
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ustawia zamykanie aplikacji po zamknięciu okna
        frame.setSize(400, 300); // Ustawia rozmiar okna
        frame.setLocationRelativeTo(null); // Wyśrodkowuje okno na ekranie
        textField.setEditable(false); // Ustawia pole tekstowe jako tylko do odczytu
        textField.setFont(new Font("Arial", Font.BOLD, 20)); // Ustawia czcionkę w polu tekstowym
        textField.setHorizontalAlignment(JTextField.RIGHT); // Ustawia wyrównanie tekstu do prawej
        panel.setBackground(Color.decode("#DC667C"));       // Ustawienie koloru tła

        // Ustawienia układu przycisków
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Odstępy między elementami

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(textField, gbc); // Dodaje pole tekstowe do panelu

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        panel.add(button7, gbc);
        gbc.gridx = 1;
        panel.add(button8, gbc);
        gbc.gridx = 2;
        panel.add(button9, gbc);
        gbc.gridx = 3;
        panel.add(buttonDivide, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        panel.add(button4, gbc);
        gbc.gridx = 1;
        panel.add(button5, gbc);
        gbc.gridx = 2;
        panel.add(button6, gbc);
        gbc.gridx = 3;
        panel.add(buttonMultiply, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        panel.add(button1, gbc);
        gbc.gridx = 1;
        panel.add(button2, gbc);
        gbc.gridx = 2;
        panel.add(button3, gbc);
        gbc.gridx = 3;
        panel.add(buttonMinus, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        panel.add(buttonClear, gbc);
        gbc.gridx = 1;
        panel.add(button0, gbc);
        gbc.gridx = 2;
        panel.add(buttonEqual, gbc);
        gbc.gridx = 3;
        panel.add(buttonPlus, gbc);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Zad4(args).show());
    }
}
