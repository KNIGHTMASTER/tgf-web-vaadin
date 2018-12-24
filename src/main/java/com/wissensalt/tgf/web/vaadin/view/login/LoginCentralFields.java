package com.wissensalt.tgf.web.vaadin.view.login;

import com.vaadin.data.Binder;
import com.vaadin.data.ValidationResult;
import com.vaadin.data.Validator;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.VerticalLayout;
import com.wissensalt.tgf.web.vaadin.component.checkbox.CheckBoxStaySignedIn;
import com.wissensalt.tgf.web.vaadin.component.link.LinkForgotPassword;
import com.wissensalt.tgf.web.vaadin.component.passwordfield.LoginPasswordField;
import com.wissensalt.tgf.web.vaadin.component.textfield.login.UserNameTextField;
import com.wissensalt.tgf.web.vaadin.dto.request.RequestLoginDTO;
import com.wissensalt.tgf.web.vaadin.util.IComponentInitializer;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created on 10/6/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringComponent
public class LoginCentralFields extends VerticalLayout implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 503855646119985763L;

    @Autowired
    LoginPasswordField loginPasswordField;

    @Autowired
    UserNameTextField userNameTextField;

    @Autowired
    CheckBoxStaySignedIn checkBoxStaySignedIn;

    @Autowired
    LinkForgotPassword linkForgotPassword;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setSpacing(true);
        this.setMargin(false);
        this.addComponent(userNameTextField);
        this.addComponent(loginPasswordField);
        this.addComponent(checkBoxStaySignedIn);
        this.addComponent(linkForgotPassword);

        Validator<String> userNameValidator = (dataToValidate, valueContext) -> {
            if(dataToValidate.length() <= 0) {
                return  ValidationResult.error("Username can not be null");
            } else {
                return  ValidationResult.ok() ;
            }
        };

        Validator<String> passwordValidator = (dataToValidate, valueContext) -> {
            if(dataToValidate.length() <= 0) {
                return  ValidationResult.error("Password can not be null");
            } else {
                return  ValidationResult.ok() ;
            }
        };

        new Binder<RequestLoginDTO>()
                .forField(userNameTextField)
                .withValidator(userNameValidator)
                .bind(RequestLoginDTO::getUserName, RequestLoginDTO::setUserName);

        new Binder<RequestLoginDTO>()
                .forField(loginPasswordField)
                .withValidator(passwordValidator)
                .bind(RequestLoginDTO::getPassword, RequestLoginDTO::setPassword);
    }

    public LoginPasswordField getLoginPasswordField() {
        return loginPasswordField;
    }

    public void setLoginPasswordField(LoginPasswordField loginPasswordField) {
        this.loginPasswordField = loginPasswordField;
    }

    public UserNameTextField getUserNameTextField() {
        return userNameTextField;
    }

    public void setUserNameTextField(UserNameTextField userNameTextField) {
        this.userNameTextField = userNameTextField;
    }

    public CheckBoxStaySignedIn getCheckBoxStaySignedIn() {
        return checkBoxStaySignedIn;
    }

    public void setCheckBoxStaySignedIn(CheckBoxStaySignedIn checkBoxStaySignedIn) {
        this.checkBoxStaySignedIn = checkBoxStaySignedIn;
    }

    public LinkForgotPassword getLinkForgotPassword() {
        return linkForgotPassword;
    }

    public void setLinkForgotPassword(LinkForgotPassword linkForgotPassword) {
        this.linkForgotPassword = linkForgotPassword;
    }
}
