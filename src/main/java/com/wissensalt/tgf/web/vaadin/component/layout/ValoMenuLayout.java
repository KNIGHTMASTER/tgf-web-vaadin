/*
 * Copyright 2000-2014 Vaadin Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.wissensalt.tgf.web.vaadin.component.layout;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.wissensalt.tgf.web.vaadin.constant.TGFValoTheme;
import com.wissensalt.tgf.web.vaadin.util.IComponentInitializer;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;

/**
 *
 * @author Vaadin Ltd
 */
@SpringComponent
@Scope(scopeName = "prototype")
public class ValoMenuLayout extends HorizontalLayout implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 9071674166333438296L;

    private CssLayout contentArea = new CssLayout();

    private CssLayout menuArea = new CssLayout();

    private ComponentContainer viewDisplay;

    public ComponentContainer getContentContainer() {
        return contentArea;
    }

    public void addMenu(Component menu) {
        menu.addStyleName(ValoTheme.MENU_PART);
        menuArea.addComponent(menu);
    }

    public void removeMenu(Component menu) {
        menu.removeStyleName(ValoTheme.MENU_PART);
        menuArea.removeComponent(menu);
    }

    @PostConstruct
    @Override
    public void initComponents() {
        this.setWidth("100%");
        this.setSizeFull();
        this.setMargin(false);

        menuArea.setPrimaryStyleName(ValoTheme.MENU_ROOT);

        contentArea.setPrimaryStyleName(TGFValoTheme.VALO_CONTENT);
        contentArea.addStyleName(TGFValoTheme.V_SCROLLABLE);
        contentArea.setSizeFull();

        addComponents(menuArea, contentArea);
        setExpandRatio(contentArea, 1);

        viewDisplay = this.getContentContainer();
    }

    public ComponentContainer getViewDisplay() {
        return viewDisplay;
    }

    public void setViewDisplay(ComponentContainer viewDisplay) {
        this.viewDisplay = viewDisplay;
    }

    public CssLayout getMenuArea() {
        return menuArea;
    }
}
