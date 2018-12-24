package com.wissensalt.tgf.web.vaadin.component.layout;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.CssLayout;
import com.wissensalt.tgf.web.vaadin.component.button.menu.MenuButton;
import com.wissensalt.tgf.web.vaadin.component.panel.PanelAppName;
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
@Scope(scopeName = "prototype")
public class MenuCssLayout extends CssLayout implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 6824490283093810180L;

    @Autowired
    private MenuButton menuButton;

    @Autowired
    private PanelAppName panelAppName;

    @PostConstruct
    @Override
    public void initComponents() {
        this.addComponent(menuButton);
        this.addComponent(panelAppName);
    }
}
