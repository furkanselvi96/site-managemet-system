package com.sms.sitemanagement.view;

import com.sms.sitemanagement.dto.UserRequest;
import com.sms.sitemanagement.model.User;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;


@Route("login")
@CssImport("./generated/styles/login.css")
public class LoginView extends Div {


    @Autowired
    public LoginView() {
        addClassName("login-rich-content");

        LoginForm loginForm = new LoginForm();
        loginForm.getElement().getThemeList().add("dark");
        loginForm.setAction("login");

        add(loginForm);
        loginForm.getElement().setAttribute("no-autofocus", "");
    }




}






