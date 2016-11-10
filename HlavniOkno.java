package net.sevecek;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.sevecek.util.swing.*;

public class HlavniOkno extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    JLabel labNemo;
    JKeyboard klavesnice;
    JLabel labZralok;
    JTimer casovac;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    JPanel contentPane;
    Timer casovacZralok;
    Integer posunX;
    Integer posunY;

    public HlavniOkno() {
        initComponents();
    }

        private void priTiknutiCasovace(ActionEvent e) {
        Point poziceNema;
        poziceNema = labNemo.getLocation();
        Integer x;
        Integer y;
        x = poziceNema.x;
        y = poziceNema.y;

        if (klavesnice.isKeyDown(KeyEvent.VK_UP)) {
            if (y > 0) {
                y = y - 10;
            }
        }
        if (klavesnice.isKeyDown(KeyEvent.VK_DOWN)) {
            if (y + labNemo.getHeight() < contentPane.getHeight()) {
                y = y + 10;
            }
        }
        if (klavesnice.isKeyDown(KeyEvent.VK_RIGHT)) {
            if (x + labNemo.getWidth() < contentPane.getWidth()) {
                labNemo.setIcon(new ImageIcon(getClass().getResource("/net/sevecek/Nemo-Right.png")));

                x = x + 10;
            }
        }
        if (klavesnice.isKeyDown(KeyEvent.VK_LEFT)) {
            labNemo.setIcon(new ImageIcon(getClass().getResource("/net/sevecek/Nemo-Left.png")));

            if (x > 0) {
                x = x - 10;
            }
        }

        poziceNema.x = x;
        poziceNema.y = y;
        labNemo.setLocation(poziceNema);
    }

    private void priOtevreniOkna(WindowEvent e) {
        casovac.start();
    }

    private void priZavreniOkna(WindowEvent e) {
        casovac.stop();
    }

    private void priKliknuti(MouseEvent e) {
        posunX = 5;
        posunY = 5;
        casovacZralok = new Timer (25, this :: tiknuti);
        casovacZralok.start();

    }

    private void tiknuti(ActionEvent actionEvent) {
        Point poziceZraloka;
        poziceZraloka = labZralok.getLocation();
        Integer x;
        Integer y;

        x = poziceZraloka.x;
        y = poziceZraloka.y;

        if (x < 0) {
            posunX = 2;
        }

        if (x + labZralok.getWidth() > contentPane.getWidth()) {
            posunX = -2;
        }

        if (y < 0) {
            posunY = 2;
        }

        if (y + labZralok.getHeight() > contentPane.getHeight()) {
            posunY = -2;
        }

        x = x + posunX;
        y = y + posunY;

        poziceZraloka.x = x;
        poziceZraloka.y = y;

        labZralok.setLocation(poziceZraloka);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        labNemo = new JLabel();
        klavesnice = new JKeyboard();
        labZralok = new JLabel();
        casovac = new JTimer();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nemo");
        setBackground(new Color(0, 153, 153));
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                priZavreniOkna(e);
            }
            @Override
            public void windowOpened(WindowEvent e) {
                priOtevreniOkna(e);
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                priKliknuti(e);
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        this.contentPane = (JPanel) this.getContentPane();
        this.contentPane.setBackground(this.getBackground());

        //---- labNemo ----
        labNemo.setIcon(new ImageIcon(getClass().getResource("/net/sevecek/Nemo-Left.png")));
        contentPane.add(labNemo);
        labNemo.setBounds(new Rectangle(new Point(205, 120), labNemo.getPreferredSize()));
        contentPane.add(klavesnice);
        klavesnice.setBounds(new Rectangle(new Point(15, 20), klavesnice.getPreferredSize()));

        //---- labZralok ----
        labZralok.setIcon(new ImageIcon(getClass().getResource("/net/sevecek/zralok.png")));
        contentPane.add(labZralok);
        labZralok.setBounds(new Rectangle(new Point(60, 125), labZralok.getPreferredSize()));

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        setSize(530, 435);
        setLocationRelativeTo(null);

        //---- casovac ----
        casovac.setDelay(50);
        casovac.addActionListener(e -> priTiknutiCasovace(e));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
