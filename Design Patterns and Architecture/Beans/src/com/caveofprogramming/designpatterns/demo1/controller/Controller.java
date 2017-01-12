package com.caveofprogramming.designpatterns.demo1.controller;

import com.caveofprogramming.designpatterns.demo1.model.Model;
import com.caveofprogramming.designpatterns.demo1.view.LoginFormEvent;
import com.caveofprogramming.designpatterns.demo1.view.LoginListener;
import com.caveofprogramming.designpatterns.demo1.view.View;

public class Controller implements LoginListener {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void loginPerformed(LoginFormEvent event) {
        System.out.println("Login event received: " + event.getName() + "; " + event.getPassword());
    }
}
