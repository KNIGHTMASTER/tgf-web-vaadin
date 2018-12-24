package com.wissensalt.tgf.web.vaadin.component.link;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Link;
import com.wissensalt.tgf.web.vaadin.util.IComponentInitializer;

import javax.annotation.PostConstruct;

/**
 * Created on 9/28/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringComponent
public class LinkForgotPassword extends Link implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -4464699437443034347L;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setCaption("Forgot Password");
    }
}
