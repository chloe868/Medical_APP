/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medical_Previous;

import javax.swing.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.*;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPasswordField;
//import javax.swing.JTextField;

/**
 *
 * @author herrerach_sd2022
 */
public class Botica extends JFrame {

    private static class RoundedBorder implements Border {

        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }

    public Botica() {
        JFrame f = new JFrame("MedicineApp");
        try {
            f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\herrerach_sd2022\\Downloads/pills.jpg")).getScaledInstance(500, 300, Image.SCALE_SMOOTH))));
        } catch (IOException e) {
            e.printStackTrace();
        }


        f.pack();
        f.setVisible(true);

        JPanel panel = new JPanel();
        JLabel label = new JLabel("LOGIN ", JLabel.CENTER);
        JLabel user = new JLabel("UserName:\t");
        JLabel pass = new JLabel("Password:\t");

        label.setBounds(150, 10, 220, 20);
        user.setBounds(150, 50, 100, 50);
        pass.setBounds(150, 90, 100, 50);
        JTextField userField = new JTextField();
        JPasswordField passField = new JPasswordField();
        userField.setBounds(250, 65, 130, 20);
        passField.setBounds(250, 105, 130, 20);

        JButton btnLogin = new JButton("Sign In");
        btnLogin.setBounds(200, 150, 100, 20);
        btnLogin.setBorder((Border) new RoundedBorder(20));
        btnLogin.setForeground(Color.BLUE);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }

        });
        JLabel create = new JLabel("Don't have an Account yet? ");
        create.setBounds(180, 170, 220, 50);
        JButton btnRegister = new JButton("Sign Up");
        btnRegister.setBounds(200, 210, 100, 20);
        btnRegister.setBorder((Border) new RoundedBorder(20));
        btnRegister.setForeground(Color.BLACK);
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new simpleRegister();
            }
        });

        f.add(label);
        f.add(user);
        f.add(pass);
        f.add(userField);
        f.add(passField);
        f.add(btnLogin);
        f.add(create);
        f.add(btnRegister);

        f.add(panel);
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(500, 300);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public class simpleRegister extends JFrame {

        public simpleRegister() {
            JFrame f = new JFrame("MedicineApp");
            try {
                f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\herrerach_sd2022\\Downloads/pills.jpg")).getScaledInstance(500, 300, Image.SCALE_SMOOTH))));
            } catch (IOException e) {
                e.printStackTrace();
            }
            f.pack();
            f.setVisible(true);

            JPanel panel = new JPanel();
            JLabel reglabel = new JLabel("REGISTER ", JLabel.CENTER);
            JLabel reguser = new JLabel("UserName:\t");
            JLabel regpass = new JLabel("Password:\t");
            JLabel regconpass = new JLabel("Confirm Password:\t");

//        b1.setBounds(4,1,1,1);
            reglabel.setBounds(150, 10, 220, 20);
            reguser.setBounds(150, 50, 100, 50);
            regpass.setBounds(150, 90, 100, 50);
            regconpass.setBounds(150, 130, 150, 50);
            JTextField reguserField = new JTextField();
            JPasswordField regpassField = new JPasswordField();
            JPasswordField regconpassField = new JPasswordField();
            reguserField.setBounds(270, 65, 130, 20);
            regpassField.setBounds(270, 105, 130, 20);
            regconpassField.setBounds(270, 145, 130, 20);

            JButton btnReg = new JButton("Register");
            btnReg.setBounds(200, 180, 100, 20);
            btnReg.setBorder((Border) new RoundedBorder(20));
            btnReg.setForeground(Color.BLACK);
            btnReg.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                }

            });
            JLabel already = new JLabel("Already have an Account? ");
            already.setBounds(180, 190, 220, 50);
            JButton btnLog = new JButton("Sign In");
            btnLog.setBounds(200, 230, 100, 20);
            btnLog.setBorder((Border) new RoundedBorder(20));
            btnLog.setForeground(Color.BLUE);
            btnLog.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f.setVisible(false);
                    new Botica();
                }

            });

            f.add(reglabel);
            f.add(reguser);
            f.add(regpass);
            f.add(regconpass);
            f.add(reguserField);
            f.add(regpassField);
            f.add(regconpassField);
            f.add(btnReg);
            f.add(already);
            f.add(btnLog);

            f.add(panel);
            f.setLayout(null);
            f.setVisible(true);
            f.setSize(500, 300);

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }
    }

    public class simpleDashboard extends JFrame {

        public simpleDashboard() {

        }
    }
}

//public class Botica extends JFrame {
//
//    JLabel title = new JLabel("REGISTER");
//    JLabel l1 = new JLabel("Name:");
//    JLabel l2 = new JLabel("Age:");
//    JLabel l3 = new JLabel("Username:");
//    JLabel l4 = new JLabel("Password:");
//    JLabel l5 = new JLabel("Confirm Password:");
//
//    JTextField t1 = new JTextField();
//    JTextField t2 = new JTextField();
//    JTextField t3 = new JTextField();
//    JTextField t5 = new JTextField();
//
//    ButtonGroup bg = new ButtonGroup();
//    JButton b = new JButton();
//    JPasswordField p = new JPasswordField();
//
//    public Botica() {
//        this.setLayout(null);
//        this.setVisible(true);
//        this.setSize(500, 500);
//        //(left/right, top/down, length(side), length(up))
//        title.setBounds(160, 50, 200, 30);
//        l1.setBounds(100, 120, 50, 10);
//        l2.setBounds(100, 170, 50, 15);
//        l3.setBounds(100, 220, 100, 10);
//        l4.setBounds(100, 270, 100, 10);
//        l5.setBounds(100, 320, 120, 10);
//        add(title);
//        add(l1);
//        add(l2);
//        add(l3);
//        add(l4);
//        add(l5);
//        t1.setBounds(215, 120, 150, 30);
//        add(t1);
//        t2.setBounds(215, 170, 150, 30);
//        add(t2);
//        t3.setBounds(215, 220, 150, 30);
//        add(t3);
//        p.setBounds(215, 270, 150, 30);
//        add(p);
//        t5.setBounds(215, 320, 150, 30);
//        add(t5);
//        b.setText("SUBMIT");
//        b.setBounds(200, 360, 80, 30);
//        add(b);
//        add(title);
//        Font font = new Font("Times New Roman", Font.BOLD, 30);
//        title.setFont(font);
//
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
//}
//LOGIN
//public class Botica extends JFrame {
//
//    public Botica() {
//        JFrame f = new JFrame("MedicineApp");
//        JPanel panel = new JPanel();
////      panel.setBounds(400,200,300,200);    
////        panel.setBackground(Color.gray);
//        JLabel label = new JLabel("WELCOME TO"
//                + "LOGIN ", JLabel.CENTER);
//        JLabel user = new JLabel("UserName:\t");
//        JLabel pass = new JLabel("Password:\t");
//
////        b1.setBounds(4,1,1,1);
//        label.setBounds(150, 10, 220, 20);
//        user.setBounds(150, 50, 100, 50);
//        pass.setBounds(150, 90, 100, 50);
//        JTextField userField = new JTextField();
//        JPasswordField passField = new JPasswordField();
//        userField.setBounds(250, 65, 80, 20);
//        passField.setBounds(250, 105, 80, 20);
//
//        JButton btnLogin = new JButton("submit");
//        btnLogin.setBounds(200, 150, 100, 20);
//        btnLogin.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//            }
//
//        });
//
//        f.add(label);
//        f.add(user);
//        f.add(pass);
//        f.add(userField);
//        f.add(passField);
//        f.add(btnLogin);
//
//        f.add(panel);
//        f.setLayout(null);
//        f.setVisible(true);
//        f.setSize(500, 300);
//
//    }
//}
