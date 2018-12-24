package com.wissensalt.tgf.web.vaadin.component.label;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Label;
import com.wissensalt.tgf.web.vaadin.util.IComponentInitializer;
import com.wissensalt.tgf.web.vaadin.rb.IResourceBundleLocator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created on 9/27/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringComponent
public class LabelSignIn extends Label implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 4462195891794618261L;

    @Autowired
    IResourceBundleLocator rb;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setCaption(rb.getResourceBundle().getString("panel.login.caption"));
        this.setCaptionAsHtml(true);
    }
}
