package com.wissensalt.tgf.web.vaadin.view.login;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;
import com.wissensalt.tgf.web.vaadin.util.IComponentInitializer;
import com.wissensalt.tgf.web.vaadin.constant.TGFConstant;
import com.wissensalt.tgf.web.vaadin.util.IComponentAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;

/**
 * Created on 7/13/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringView(name = TGFConstant.ViewNames.LOGIN_VIEW)
@Scope(scopeName = "request")
@UIScope
public class LoginView extends VerticalLayout implements View, IComponentInitializer, IComponentAction {
    /**
     *
     *
     */
    private static final long serialVersionUID = 8682971569973011022L;

    @Autowired
    private LoginPanelCreateAccount loginPanelCreateAccount;

    @Autowired
    private PanelLoginForm panelLoginForm;

    @Value("${url-logged-in}")
    private String urlLoggedIn;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setMargin(false);
        this.addComponent(loginPanelCreateAccount);
        this.addComponent(panelLoginForm);

        this.setComponentAlignment(panelLoginForm, Alignment.MIDDLE_CENTER);

        this.setExpandRatio(loginPanelCreateAccount, 0.2f);
        this.setExpandRatio(panelLoginForm, 0.8f);

        initAction();
    }

    @Override
    public void initAction() {

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
