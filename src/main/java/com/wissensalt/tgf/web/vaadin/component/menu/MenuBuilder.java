package com.wissensalt.tgf.web.vaadin.component.menu;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;
import com.wissensalt.tgf.web.vaadin.constant.TGFConstant;
import com.wissensalt.tgf.web.vaadin.constant.TGFValoTheme;
import com.wissensalt.tgf.web.vaadin.dto.MenuDTO;
import com.wissensalt.tgf.web.vaadin.dto.MenuItemDTO;

import org.springframework.context.annotation.Scope;

/**
 * Created on 9/14/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringComponent
@Scope(scopeName = "prototype")
public class MenuBuilder {

    public CssLayout build(CssLayout p_MenuCssLayout, CssLayout p_MenuItemsLayout, MenuDTO p_MenuDTO, UI p_UI) {
        p_MenuItemsLayout.setPrimaryStyleName(TGFValoTheme.VALO_MENU_ITEMS);
        p_MenuCssLayout.addComponent(p_MenuItemsLayout);

        for (MenuItemDTO menuItem : p_MenuDTO.getMenuItemDTOs()) {
            if (menuItem.getKey().equals(TGFConstant.ViewNames.MENU_SEPARATOR)) {
                Label label = new Label(menuItem.getName(), ContentMode.HTML);
                label.setPrimaryStyleName(ValoTheme.MENU_SUBTITLE);
                label.addStyleName(ValoTheme.LABEL_H4);
                label.setSizeUndefined();
                p_MenuItemsLayout.addComponent(label);
            }else {
                Button b = new Button(menuItem.getName(), event -> p_UI.getNavigator().navigateTo(menuItem.getViewName()));
                b.setCaptionAsHtml(true);
                b.setPrimaryStyleName(ValoTheme.MENU_ITEM);
                b.setIcon(VaadinIcons.valueOf(menuItem.getIcon()));

                p_MenuItemsLayout.addComponent(b);
            }

        }

        p_MenuCssLayout.setId("menu_state");

        return p_MenuCssLayout;
    }
}
