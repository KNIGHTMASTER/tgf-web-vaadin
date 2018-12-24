package com.wissensalt.tgf.web.vaadin.component.button.menu;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;
import com.wissensalt.tgf.web.vaadin.component.layout.MenuCssLayout;
import com.wissensalt.tgf.web.vaadin.constant.TGFValoTheme;
import com.wissensalt.tgf.web.vaadin.util.IComponentAction;
import com.wissensalt.tgf.web.vaadin.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created on 9/14/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringComponent
//@Scope(scopeName = "prototype")
public class MenuButton extends Button implements IComponentInitializer, IComponentAction {
    /**
     *
     *
     */
    private static final long serialVersionUID = -2616977514897812000L;

    @Autowired
    private MenuCssLayout menuCssLayout;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setCaption("Menu");
        this.addStyleName(ValoTheme.BUTTON_PRIMARY);
        this.addStyleName(ValoTheme.BUTTON_SMALL);
        this.addStyleName(TGFValoTheme.VALO_MENU_TOGGLE);
        this.setIcon(VaadinIcons.LIST);
        initAction();
    }

    @Override
    public void initAction() {
        this.addClickListener(event -> {
            if (menuCssLayout.getStyleName().contains(TGFValoTheme.VALO_MENU_VISIBLE)) {
                menuCssLayout.removeStyleName(TGFValoTheme.VALO_MENU_VISIBLE);
            } else {
                menuCssLayout.addStyleName(TGFValoTheme.VALO_MENU_VISIBLE);
            }
        });
    }
}
