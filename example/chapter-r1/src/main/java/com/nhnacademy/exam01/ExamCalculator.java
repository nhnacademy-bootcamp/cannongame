package com.nhnacademy.exam01;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ExamCalculator {
    static int operand1 = 0;
    static int operand2 = 0;
    static String operator = "";

    class ActionListnerImpl implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
        }
    }

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        // 제목 설정``
        frame.setTitle("GridBagLayout");
        //// 크기 설정
        frame.setSize(400, 300);
        //
        frame.setLayout(new GridBagLayout());

        final JTextField label = new JTextField();
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setText("0");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = GridBagConstraints.RELATIVE;
        frame.add(label, constraints);

        ActionListener inputNumberActionListener = e -> {
            if (e.getSource() instanceof JButton) {
                if (label.getText().equals("0")) {
                    label.setText(((JButton) e.getSource()).getText());
                } else {
                    label.setText(label.getText() + ((JButton) e.getSource()).getText());
                }
            }
        };

        ActionListener operatorActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JButton) {
                    switch (((JButton) e.getSource()).getText()) {
                        case "+": {
                            operand1 = Integer.valueOf(label.getText());
                            operator = ((JButton) e.getSource()).getText();
                            label.setText("0");
                        }
                            break;
                        case "-": {
                        }
                            break;
                        case "*": {
                        }
                            break;
                        case "/": {
                        }
                            break;
                        case "=": {
                            operand2 = Integer.valueOf(label.getText());
                            label.setText("" + (operand1 + operand2));
                        }
                            break;
                    }
                }
            }
        };

        JButton button = new JButton("1");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        button.addActionListener(inputNumberActionListener);
        frame.add(button, constraints);

        button = new JButton("2");
        constraints.weightx = 0.5;
        constraints.gridx = 1;
        constraints.gridy = 1;
        button.addActionListener(inputNumberActionListener);
        frame.add(button, constraints);

        button = new JButton("3");
        constraints.weightx = 0.5;
        constraints.gridx = 2;
        constraints.gridy = 1;
        button.addActionListener(inputNumberActionListener);
        frame.add(button, constraints);

        button = new JButton("+");
        constraints.weightx = 0.5;
        constraints.gridx = 3;
        constraints.gridy = 1;
        button.addActionListener(operatorActionListener);
        frame.add(button, constraints);

        button = new JButton("4");
        constraints.weightx = 0.5;
        constraints.gridx = 0;
        constraints.gridy = 2;
        button.addActionListener(inputNumberActionListener);
        frame.add(button, constraints);

        button = new JButton("5");
        constraints.weightx = 0.5;
        constraints.gridx = 1;
        constraints.gridy = 2;
        button.addActionListener(inputNumberActionListener);
        frame.add(button, constraints);

        button = new JButton("6");
        constraints.weightx = 0.5;
        constraints.gridx = 2;
        constraints.gridy = 2;
        button.addActionListener(inputNumberActionListener);
        frame.add(button, constraints);

        button = new JButton("-");
        constraints.weightx = 0.5;
        constraints.gridx = 3;
        constraints.gridy = 2;
        frame.add(button, constraints);

        button = new JButton("7");
        constraints.weightx = 0.5;
        constraints.gridx = 0;
        constraints.gridy = 3;
        button.addActionListener(inputNumberActionListener);
        frame.add(button, constraints);

        button = new JButton("8");
        constraints.weightx = 0.5;
        constraints.gridx = 1;
        constraints.gridy = 3;
        button.addActionListener(inputNumberActionListener);
        frame.add(button, constraints);

        button = new JButton("9");
        constraints.weightx = 0.5;
        constraints.gridx = 2;
        constraints.gridy = 3;
        button.addActionListener(inputNumberActionListener);
        frame.add(button, constraints);

        button = new JButton("*");
        constraints.weightx = 0.5;
        constraints.gridx = 3;
        constraints.gridy = 3;
        frame.add(button, constraints);

        button = new JButton("0");
        constraints.weightx = 0.5;
        constraints.gridx = 0;
        constraints.gridy = 4;
        button.addActionListener(inputNumberActionListener);
        frame.add(button, constraints);

        button = new JButton("/");
        constraints.weightx = 0.5;
        constraints.gridx = 3;
        constraints.gridy = 4;
        frame.add(button, constraints);

        button = new JButton("=");
        constraints.weightx = 0.5;
        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        button.addActionListener(operatorActionListener);
        frame.add(button, constraints);

        button = new JButton("AC");
        constraints.weightx = 0.5;
        constraints.gridx = 3;
        constraints.gridy = 5;
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if ((e.getSource() instanceof JButton)
                        && (((JButton) e.getSource()).getText().equals("AC"))) {
                    label.setText("0");
                }
            }

        });
        frame.add(button, constraints);

        frame.setVisible(true);
    }
}