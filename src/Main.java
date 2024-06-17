import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
    static Float currentSelection = 0f;

    public static void main(String[] args) {
        JFrame mainWindow = new JFrame("Conversor de Moeda");
        JPanel panel = new JPanel();
        JTextField inputField = new JTextField();
        JLabel label = new JLabel();
        JButton calcButton = new JButton("Calcular");
        JLabel calcResult = new JLabel();
        JRadioButton opt1 = new JRadioButton("Dólar Americano", false);
        JRadioButton opt2 = new JRadioButton("Dólar Canadense", false);
        JRadioButton opt3 = new JRadioButton("Iene Japonês", false);
        ButtonGroup options = new ButtonGroup();

        //Jframe config scope
        mainWindow.setSize(250,300);
        mainWindow.setResizable(false);

        //JPanel config scope
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));

        //JLabel config scope
        label.setText("Digite a quantidade em reais (R$)");
        calcResult.setText("");

        //TextField config scope
        inputField.setColumns(2);

        //Button config scope
        calcButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String text = inputField.getText();

                try {
                    float inputValue = Float.parseFloat(text);
                    float Result = inputValue / currentSelection;
                    calcResult.setText(String.format("Valor de conversão: %.2f", Result));
                }
                catch(NumberFormatException exception){
                    exception.printStackTrace();
                    calcResult.setText("O valor para conversão é inválido");
                }

            }

        });

        //JRadioButton config scope

        opt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentSelection = CoinTypes.US_DOLLAR.getValue();
            }
        });

        opt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentSelection = CoinTypes.CA_DOLLAR.getValue();
            }
        });

        opt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentSelection = CoinTypes.JP_YEN.getValue();
            }
        });
        options.add(opt1);
        options.add(opt2);
        options.add(opt3);

        panel.add(label);
        panel.add(inputField);
        panel.add(calcButton);
        panel.add(calcResult);
        panel.add(opt1);
        panel.add(opt2);
        panel.add(opt3);

        mainWindow.add(panel);
        mainWindow.setVisible(true);
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
