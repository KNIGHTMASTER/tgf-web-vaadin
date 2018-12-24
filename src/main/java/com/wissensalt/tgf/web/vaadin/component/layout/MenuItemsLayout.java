package com.wissensalt.tgf.web.vaadin.component.layout;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.CssLayout;
import com.wissensalt.tgf.web.vaadin.util.IComponentInitializer;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;

/**
 * Created on 10/31/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringComponent
@Scope(scopeName = "singleton")
public class MenuItemsLayout extends CssLayout implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 7186925395096605009L;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setId("menuItems");
    }
}
