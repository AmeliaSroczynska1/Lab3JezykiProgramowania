import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zad4 {
    static JFrame frame;
    static JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, buttonPlus, buttonMinus, buttonDivide, buttonMultiply, buttonEqual, buttonClear;
    static JTextField textField;

    private static String currentText = ""; // Do przechowywania aktualnego tekstu w polu tekstowym
    private static String operator = "";   // Do przechowywania operatora
    private static double firstOperand = 0; // Pierwszy

    // Konstruktor
    Zad4(String[] args) {
        // Tworzenie ramki
        frame = new JFrame("Zadanie numer 4");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Tworzenie komponentów
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        button0 = new JButton("0");
        buttonPlus = new JButton("+");
        buttonMinus = new JButton("-");
        buttonMultiply = new JButton("*");
        buttonDivide = new JButton("/");
        buttonEqual = new JButton("=");
        buttonClear = new JButton("C");

        textField = new JTextField();
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT); // Wyrównanie do prawej
        textField.setFont(new Font("Arial", Font.BOLD, 15));

        // Ustawianie układu
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Odstępy między elementami
        panel.setBackground(Color.decode("#DC667C"));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(textField, gbc);

        // Ustawienia miejsca i dodanie do Panel
        gbc.gridx = 0;          // Początek w kolumnie 0
        gbc.gridy = 0;          // Pierwszy rząd
        gbc.gridwidth = 4;      // Zajmij 4 kolumny
        gbc.fill = GridBagConstraints.HORIZONTAL; // Rozciąganie w poziomie
        panel.add(textField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1; // Reset dla przycisków
        //gbc.anchor = GridBagConstraints.EAST;                   // Wyrównanie do prawej
        panel.add(button7, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1; // Reset dla przycisków
        //gbc.anchor = GridBagConstraints.WEST;                   // Wyrównanie do lewej
        panel.add(button8, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1; // Reset dla przycisków
        panel.add(button9, gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 1; // Reset dla przycisków
        panel.add(buttonDivide, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1; // Reset dla przycisków
        panel.add(button4, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1; // Reset dla przycisków
        panel.add(button5, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1; // Reset dla przycisków
        panel.add(button6, gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 1; // Reset dla przycisków
        panel.add(buttonMultiply, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1; // Reset dla przycisków
        panel.add(button1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1; // Reset dla przycisków
        panel.add(button2, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1; // Reset dla przycisków
        panel.add(button3, gbc);

        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridwidth = 1; // Reset dla przycisków
        panel.add(buttonMinus, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1; // Reset dla przycisków
        panel.add(buttonEqual, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1; // Reset dla przycisków
        panel.add(button0, gbc);

        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.gridwidth = 1; // Reset dla przycisków
        panel.add(buttonPlus, gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;
        panel.add(buttonClear, gbc);

        // Obsługa zdarzeń
        ActionListener numberListener = e -> {
            JButton source = (JButton) e.getSource();
            currentText += source.getText();
            textField.setText(currentText);
        };

        JButton[] numberButtons = {button0, button1, button2, button3, button4, button5, button6, button7, button8, button9};

        for (JButton btn : numberButtons) {
            btn.addActionListener(numberListener);
        }

        buttonClear.addActionListener(e -> {
            currentText = "";
            operator = "";
            firstOperand = 0;
            textField.setText("");
        });

        ActionListener operatorListener = e -> {
            JButton source = (JButton) e.getSource();
            operator = source.getText();
            if (!currentText.isEmpty()) {
                firstOperand = Double.parseDouble(currentText);
                currentText = "";
                textField.setText(operator);
            }
        };

        buttonPlus.addActionListener(operatorListener);
        buttonMinus.addActionListener(operatorListener);
        buttonMultiply.addActionListener(operatorListener);
        buttonDivide.addActionListener(operatorListener);

        buttonEqual.addActionListener(e -> {
            if (!currentText.isEmpty() && !operator.isEmpty()) {
                double secondOperand = Double.parseDouble(currentText);
                double result = 0;

                switch (operator) {
                    case "+":
                        result = firstOperand + secondOperand;
                        break;
                    case "-":
                        result = firstOperand - secondOperand;
                        break;
                    case "*":
                        result = firstOperand * secondOperand;
                        break;
                    case "/":
                        if (secondOperand != 0) {
                            result = firstOperand / secondOperand;
                        } else {
                            textField.setText("Error: Div by 0");
                            return;
                        }
                        break;
                }

                // Sprawdzenie, czy wynik jest liczbą całkowitą
                if (result == (int) result) {
                    textField.setText(String.valueOf((int) result)); // Usuń .0
                } else {
                    textField.setText(String.valueOf(result));
                }

                currentText = String.valueOf(result);
                operator = "";
                firstOperand = 0;
            }
        });

        frame.add(panel);
    }

    // Metoda do wyświetlania okna
    public void show() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Punkt wejścia programu
    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Zad4(args).show();
            }
        });
    }
}
