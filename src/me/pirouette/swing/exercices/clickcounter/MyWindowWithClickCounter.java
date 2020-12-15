package me.pirouette.swing.exercices.clickcounter;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.*;

public class MyWindowWithClickCounter extends JFrame {

    private JButton btnPushMe = new JButton("Push me");
    private JButton btnClickMe = new JButton("Click me");
    private JLabel label = new JLabel();
    private int clickCounter = 0;

    public MyWindowWithClickCounter() throws HeadlessException {
        super("My first Swing application");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 20));


        btnPushMe.addActionListener(this::btnPushListener);
        contentPane.add(btnPushMe);

        btnClickMe.addActionListener((e) -> btnPushListener(e));
        btnClickMe.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnClickMe.setForeground(Color.RED);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnClickMe.setForeground(Color.BLACK);
            }
        });
        contentPane.add(btnClickMe);

        JCheckBox chkCheckMe = new JCheckBox("Check me");
        contentPane.add(chkCheckMe);

        JTextField txtEditMe = new JTextField("Edit me");
        txtEditMe.setPreferredSize(new Dimension(120, 30));
        contentPane.add(txtEditMe);

        contentPane.add(label);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //super.windowClosing(e);
                int clickedButton = JOptionPane.showConfirmDialog(MyWindowWithClickCounter.this,
                        "Etes-vous sur ?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (clickedButton == JOptionPane.YES_OPTION) {
                    MyWindowWithClickCounter.this.dispose();
                }
            }
        });

    }

    private void btnPushListener(ActionEvent e) {
        label.setText("Nombre de clics : " + ++clickCounter);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        // Apply a look 'n' feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        // Start my window
        MyWindowWithClickCounter myWindow = new MyWindowWithClickCounter();
        myWindow.setVisible(true);
    }
}
