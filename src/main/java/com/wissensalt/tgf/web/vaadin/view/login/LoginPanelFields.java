package com.wissensalt.tgf.web.vaadin.view.login;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.FormLayout;
import com.wissensalt.tgf.web.vaadin.component.passwordfield.LoginPasswordField;
import com.wissensalt.tgf.web.vaadin.component.textfield.login.UserNameTextField;
import com.wissensalt.tgf.web.vaadin.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created on 7/13/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringComponent
public class LoginPanelFields extends FormLayout implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -4890373141046484869L;

    @Autowired
    private SignInButtonPanel signInButtonPanel;

    @Autowired
    private LoginCentralFields loginCentralFields;

    @PostConstruct
    @Override
    public void initComponents() {
        this.addComponent(loginCentralFields);
        this.addComponent(signInButtonPanel);

        this.setComponentAlignment(loginCentralFields, Alignment.MIDDLE_CENTER);

        this.setSpacing(true);
        this.setMargin(false);
    }

    public LoginPasswordField getLoginPasswordField() {
        return loginCentralFields.getLoginPasswordField();
    }

    public UserNameTextField getUserNameTextField() {
        return loginCentralFields.getUserNameTextField();
    }

    public SignInButtonPanel getSignInButtonPanel() {
        return signInButtonPanel;
    }
}
