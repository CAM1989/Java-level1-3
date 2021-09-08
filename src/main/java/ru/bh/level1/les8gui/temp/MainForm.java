package ru.bh.level1.les8gui.temp;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    public MainForm() {
        setBounds(500, 300, 600, 400);
        setTitle("Simple Swing App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTextArea textArea = new JTextArea();
        JScrollPane jsp = new JScrollPane(textArea);
        this.add(jsp, BorderLayout.CENTER);

        JPanel southPanel = new JPanel(new GridLayout(1, 10, 5, 0));
        this.add(southPanel, BorderLayout.SOUTH);

        for (int i = 1; i <= 10; i++) {
            JButton button = new JButton(String.valueOf(i));
            southPanel.add(button);

            final int index = i;

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textArea.append(String.valueOf(index) + '\n');
                }
            });
        }

        JTextField textField = new JTextField();
        this.add(textField, BorderLayout.NORTH);
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append(textField.getText() + '\n');
                textField.setText("");
            }
        });

        JSlider jSlider = new JSlider(0,100);
        this.add(jSlider, BorderLayout.EAST);
        jSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println(((JSlider)e.getSource()).getValue());
            }
        });

        setVisible(true);
    }

}
