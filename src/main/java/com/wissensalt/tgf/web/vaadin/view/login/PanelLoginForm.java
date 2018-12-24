package com.wissensalt.tgf.web.vaadin.view.login;

import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.wissensalt.tgf.web.vaadin.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created on 9/27/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringComponent
public class PanelLoginForm extends HorizontalLayout implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -6355047059963083993L;

    @Autowired
    private LoginPanelFields loginPanelFields;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setMargin(new MarginInfo(true, false, false, false));
        this.setMargin(false);
        this.addStyleName("layout-with-border");
        this.addStyleName("panel-white");
        this.addStyleName("panel-rounded");

        this.addComponent(loginPanelFields);
        this.setComponentAlignment(loginPanelFields, Alignment.MIDDLE_CENTER);
        this.setSpacing(true);
    }

}
