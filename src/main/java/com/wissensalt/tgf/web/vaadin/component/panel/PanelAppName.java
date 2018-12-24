package com.wissensalt.tgf.web.vaadin.component.panel;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.wissensalt.tgf.web.vaadin.component.label.LabelAppName;
import com.wissensalt.tgf.web.vaadin.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;

/**
 * Created on 9/14/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringComponent
@Scope(scopeName = "singleton")
public class PanelAppName extends HorizontalLayout implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -6831150810599749478L;

    @Autowired
    private LabelAppName labelAppName;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setWidth("100%");
        this.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
        this.addStyleName(ValoTheme.MENU_TITLE);
        this.addComponent(labelAppName);
        this.setExpandRatio(labelAppName, 1);
    }
}
