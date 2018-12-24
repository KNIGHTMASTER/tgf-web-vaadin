package com.wissensalt.tgf.web.vaadin.view.login;

import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;
import com.wissensalt.tgf.web.vaadin.component.button.login.LoginButton;
import com.wissensalt.tgf.web.vaadin.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created on 9/27/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringComponent
public class SignInButtonPanel extends VerticalLayout implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -8409111690265727107L;

    @Autowired
    private LoginButton loginButton;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setWidth("400px");
        this.setHeight("70px");
        this.setMargin(new MarginInfo(false, true, false, false));
        this.addComponent(loginButton);
        this.setComponentAlignment(loginButton, Alignment.MIDDLE_RIGHT);
//        this.addStyleName("valo-base-color");
    }

    public LoginButton getLoginButton() {
        return loginButton;
    }
}
