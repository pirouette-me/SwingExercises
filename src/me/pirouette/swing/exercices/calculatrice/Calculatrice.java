package me.pirouette.swing.exercices.calculatrice;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Calculatrice extends JFrame {
    public Calculatrice() {

        super("Calculatrice");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        JPanel contentPane = (JPanel) this.getContentPane();

        //contentPane.setBackground(Color.BLUE);

        JLabel display = new JLabel("0");
        display.setPreferredSize(new Dimension(500, 40));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setFont(display.getFont().deriveFont(32.0f));
        //display.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        //display.setBackground(Color.WHITE);
        contentPane.add(display, BorderLayout.NORTH);

        JPanel numbers = new JPanel(new GridLayout(4,3,1,1));
        numbers.setFont(numbers.getFont().deriveFont(32.0f));

        JButton btnOne = new JButton("1");
        btnOne.addActionListener(this::btnListener);
        numbers.add(btnOne);
        JButton btnTwo = new JButton("2");
        btnTwo.addActionListener(this::btnListener);
        numbers.add(btnTwo);
        JButton btnThree = new JButton("3");
        btnThree.addActionListener(this::btnListener);
        numbers.add(btnThree);
        JButton btnFour = new JButton("4");
        numbers.add(btnFour);
        JButton btnFive = new JButton("5");
        numbers.add(btnFive);
        JButton btnSix = new JButton("6");
        numbers.add(btnSix);
        JButton btnSeven = new JButton("7");
        numbers.add(btnSeven);
        JButton btnEight = new JButton("8");
        numbers.add(btnEight);
        JButton btnNine = new JButton("9");
        numbers.add(btnNine);
        JButton btnZero = new JButton("0");
        numbers.add(btnZero);
        JButton btnDecimal = new JButton(".");
        numbers.add(btnDecimal);
        JButton btnEquals = new JButton("=");
        numbers.add(btnEquals);

        numbers.setPreferredSize(new Dimension((int) (getWidth()*.7),0));
        numbers.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println(e.getSource());
            }
        });
        numbers.setFont(numbers.getFont().deriveFont(64.0f));

        contentPane.add(numbers, BorderLayout.WEST);

        JPanel operators = new JPanel(new GridLayout(5,1,1,1));
        operators.setPreferredSize(new Dimension((int) (getWidth()*.25),0));

        JButton btnClear = new JButton("C");
        operators.add(btnClear);
        JButton btnPlus = new JButton("+");
        operators.add(btnPlus);
        JButton btnMinus = new JButton("-");
        operators.add(btnMinus);
        JButton btnMultiply = new JButton("*");
        operators.add(btnMultiply);
        JButton btnDivide = new JButton("/");
        operators.add(btnDivide);




        contentPane.add(operators, BorderLayout.EAST);

























        /*super("JSplitPanelSample");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800,500);
        this.setLocationRelativeTo(null);
        JPanel contentPane = (JPanel) this.getContentPane();

        JTree projectTree = new JTree();
        JScrollPane projectScrollPane = new JScrollPane(projectTree);
        projectScrollPane.setPreferredSize(new Dimension(200,0));

        JTextArea editor = new JTextArea();
        JScrollPane editorScrollPane = new JScrollPane(editor);

        JTextArea console = new JTextArea();
        JScrollPane consoleScrollPane = new JScrollPane(console);

        JTree outlineTree = new JTree();
        JScrollPane outlineScrollPane = new JScrollPane(outlineTree);

        JSplitPane horizontalSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, editorScrollPane, outlineScrollPane);
        horizontalSplitPane.setResizeWeight(.6);

        JSplitPane  verticalSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, horizontalSplitPane, consoleScrollPane);
        verticalSplitPane.setResizeWeight(.5);

        JSplitPane mainSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, projectScrollPane, verticalSplitPane);

        contentPane.add(mainSplitPane, BorderLayout.CENTER);


         */

    }

    private void btnListener(ActionEvent actionEvent) {
        System.out.println(actionEvent.getSource());
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        // Apply a look 'n' feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        // Start my window
        Calculatrice myWindow = new Calculatrice();
        myWindow.setVisible(true);
    }
}
