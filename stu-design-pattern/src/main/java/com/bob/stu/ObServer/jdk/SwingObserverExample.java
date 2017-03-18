package com.bob.stu.ObServer.jdk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * java.swing中的观察者模式
 *
 * @author bob {Tel：15811588260}-{Email：bobyang_coder@163.com}
 * @version 1.0
 * @since 2017/3/18
 */
public class SwingObserverExample {
    JFrame frame;

    public static void main(String[] args) {
        new SwingObserverExample().run();
    }

    public void run() {
        frame = new JFrame();
        JButton button = new JButton("我要干嘛?");
        button.addActionListener(new AngelListener());
        button.addActionListener(new BobListener());
        frame.getContentPane().add(BorderLayout.CENTER, button);
        frame.setBackground(Color.RED);
    }

    class AngelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("傻缺!");
        }
    }

    class BobListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("bob和lin");
        }
    }


}
