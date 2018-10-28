package com.hillel.elementary.javageeks.dir;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.text.NumberFormat;

/*Write a Java program that accepts two integers from the user and then prints the sum, the difference,
 the product, the average, the distance (the difference between integer),
  the maximum (the larger of the two integers), the minimum (smaller of the two integers) */

public class TwoIntegersTaskOne extends JFrame {
    private JFormattedTextField inFirst, inSecond;
    private JTextField outSum, outDif, outProd, outAvg, outDist, outMax, outMin;
    private JTextField [] allOutFs;

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame tit = new TwoIntegersTaskOne();
                tit.setTitle("Two integers task");
                tit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                tit.setSize(400, 300);
                tit.setVisible(true);
            }
        });
    }

    TwoIntegersTaskOne(){
        JPanel mainPanel = new JPanel();
        setContentPane(mainPanel);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        NumberFormat integerFieldFormatter = NumberFormat.getIntegerInstance();
        integerFieldFormatter.setMaximumFractionDigits(0);

        inFirst = new JFormattedTextField(integerFieldFormatter);
        inFirst.setColumns(10);
        inFirst.setValue(0);
        inSecond = new JFormattedTextField(integerFieldFormatter);
        inSecond.setColumns(10);
        inSecond.setValue(0);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout( new GridLayout(2, 2));

        inputPanel.add(new JLabel("The first integer: "));
        inputPanel.add(inFirst);
        inputPanel.add(new JLabel("The second integer: "));
        inputPanel.add(inSecond);
        inputPanel.setBorder(BorderFactory.createTitledBorder("Input data"));
        mainPanel.add(inputPanel);

        JButton button = new JButton("Evaluate");
        button.addActionListener(new EvaluateListener());
        mainPanel.add(button);

        JPanel outPanel = new JPanel();
        outPanel.setLayout( new GridLayout(7, 2));
        outPanel.setBorder(BorderFactory.createTitledBorder("Output data"));
        mainPanel.add(outPanel);
        setOutField(outPanel, "The sum", "outSum");
        setOutField(outPanel, "The difference", "outDif");
        setOutField(outPanel, "The product", "outProd");
        setOutField(outPanel, "The average", "outAvg");
        setOutField(outPanel, "The distance", "outDist");
        setOutField(outPanel, "The maximum", "outMax");
        setOutField(outPanel, "The minimum", "outMin");

        allOutFs = new JTextField [] {outSum, outDif, outProd, outAvg, outDist, outMax, outMin};
    }

    void setOutField(JPanel fPanel, String title, String fName) {
        fPanel.add(new JLabel(title));
        try {
            Field field = getClass().getDeclaredField(fName);
            field.setAccessible(true);
            JTextField newFieldValue = new JTextField();
            newFieldValue.setEditable(false);
            field.set(this, newFieldValue);
            fPanel.add(newFieldValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class EvaluateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (inFirst.getValue() == null || inSecond.getValue() == null) {
                for (int i = 0; i < allOutFs.length; i++) {
                    JTextField tf = allOutFs[i];
                    tf.setText("");
                }
                return;
            }

            long first = ((Number)inFirst.getValue()).longValue();
            long second = ((Number)inSecond.getValue()).longValue();

            outSum.setText(Long.toString(first + second));

            long difference = first - second;
            outDif.setText(Long.toString(difference));

            outProd.setText(Long.toString(first * second));

            outAvg.setText(Double.toString((first + second) / 2.0D));

            long distance = first - second;
            if (distance < 0) distance = distance * -1;
            outDist.setText(Long.toString(distance));

            if (first > second) {
                outMax.setText(Long.toString(first));
                outMin.setText(Long.toString(second));
            } else {
                outMax.setText(Long.toString(second));
                outMin.setText(Long.toString(first));
            }

        }
    }
}