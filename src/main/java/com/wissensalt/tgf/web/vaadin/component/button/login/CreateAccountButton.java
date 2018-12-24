package com.wissensalt.tgf.web.vaadin.component.button.login;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Link;
import com.wissensalt.tgf.web.vaadin.util.IComponentInitializer;

import javax.annotation.PostConstruct;

/**
 * Created on 9/27/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringComponent
public class CreateAccountButton extends Link implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 4503801160104413841L;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setCaption("CREATE ACCOUNT");
    }
}
