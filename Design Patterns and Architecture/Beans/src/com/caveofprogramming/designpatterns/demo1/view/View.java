package com.caveofprogramming.designpatterns.demo1.view;

import com.caveofprogramming.designpatterns.demo1.controller.Controller;
import com.caveofprogramming.designpatterns.demo1.model.Database;
import com.caveofprogramming.designpatterns.demo1.model.Model;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class View extends JFrame implements ActionListener{

    private Model model;
    private JButton okButton;
    private JTextField nameField;
    private JPasswordField passField;

    private LoginListener loginListener;

    public View (Model model) {
        super("MVC Demo");
        this.model = model;

        nameField = new JTextField(10);
        passField = new JPasswordField(10);
        okButton = new JButton("OK");

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.LAST_LINE_END;
        gc.gridx = 1;
        gc.gridy = 1;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.insets = new Insets(100, 0, 0, 10);
        gc.fill = GridBagConstraints.NONE;

        add(new JLabel("Name: "), gc);

        gc.anchor = GridBagConstraints.LAST_LINE_START;
        gc.gridx = 2;
        gc.gridy = 1;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.insets = new Insets(100, 0, 0, 0);
        gc.fill = GridBagConstraints.NONE;

        add(nameField, gc);

        gc.anchor = GridBagConstraints.LINE_END;
        gc.gridx = 1;
        gc.gridy = 2;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.insets = new Insets(0, 0, 0, 10);
        gc.fill = GridBagConstraints.NONE;

        add(new JLabel("Password: "), gc);

        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 2;
        gc.gridy = 2;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.fill = GridBagConstraints.NONE;

        add(passField, gc);

        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.gridx = 2;
        gc.gridy = 3;
        gc.weightx = 1;
        gc.weighty = 100;
        gc.fill = GridBagConstraints.NONE;

        add(okButton, gc);

        okButton.addActionListener(this);

//        Database database = new Database();
//        Database db = Database.getInstance();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                Database.getInstance().connect();
            }

            @Override
            public void windowClosing(WindowEvent e) {
                Database.getInstance().disconnect();
            }
        });

        setSize(600, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String name = nameField.getText();
        String password = new String(passField.getPassword());

        fireLoginEvent(new LoginFormEvent(name, password));
    }

    public void setLoginListener(LoginListener loginListener) {
        this.loginListener = loginListener;
    }

    public void fireLoginEvent(LoginFormEvent event) {
        if(loginListener != null) {
            loginListener.loginPerformed(event);
        }
    }

}
