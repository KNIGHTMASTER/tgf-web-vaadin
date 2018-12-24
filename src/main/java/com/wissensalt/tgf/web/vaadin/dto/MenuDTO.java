package com.wissensalt.tgf.web.vaadin.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created on 9/13/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
@Scope(scopeName = "prototype")
public class MenuDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 2590150716412383167L;

    private LinkedList<MenuItemDTO> menuItemDTOs;

    public LinkedList<MenuItemDTO> getMenuItemDTOs() {
        return menuItemDTOs;
    }

    public void setMenuItemDTOs(LinkedList<MenuItemDTO> menuItemDTOs) {
        this.menuItemDTOs = menuItemDTOs;
    }

}
