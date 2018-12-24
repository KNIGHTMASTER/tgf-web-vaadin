package com.wissensalt.tgf.web.vaadin.ui;

import com.vaadin.annotations.*;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.*;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Component;
import com.vaadin.ui.ConnectorTracker;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;
import com.wissensalt.tgf.web.vaadin.client.LoginClient;
import com.wissensalt.tgf.web.vaadin.component.button.menu.MenuUserSetting;
import com.wissensalt.tgf.web.vaadin.component.layout.MenuCssLayout;
import com.wissensalt.tgf.web.vaadin.component.layout.MenuItemsLayout;
import com.wissensalt.tgf.web.vaadin.component.layout.ValoMenuLayout;
import com.wissensalt.tgf.web.vaadin.component.menu.MenuBuilder;
import com.wissensalt.tgf.web.vaadin.constant.TGFConstant;
import com.wissensalt.tgf.web.vaadin.constant.TGFValoTheme;
import com.wissensalt.tgf.web.vaadin.dto.MenuDTO;
import com.wissensalt.tgf.web.vaadin.dto.MenuItemDTO;
import com.wissensalt.tgf.web.vaadin.theme.ValoThemeSessionInitListener;
import com.wissensalt.tgf.web.vaadin.util.UIConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * Created on 9/13/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Title("Application Web Backend")
@Theme(value = "tgf")
/*@Widgetset("id.co.telkomsigma.tgf.web.admin.vaadin.TgfWidgetSet")*/
@SpringUI(path = "/admin")
@Scope(scopeName = "prototype")
@PreserveOnRefresh
public class WebAdminUI extends UI {
    /**
     *
     *
     */
    private static final long serialVersionUID = 8873273007871074028L;

    @Autowired
    private SpringViewProvider springViewProvider;

    @Autowired
    private ValoMenuLayout root;

    @Autowired
    private MenuBuilder menuBuilder;

    @Autowired
    private MenuCssLayout menuCssLayout;

    @Autowired
    private MenuUserSetting menuUserSetting;

    @Autowired
    private MenuDTO menuDTO;

    @Value("${app.title}")
    private String appTitle;

    @Autowired
    private MenuItemsLayout menuItemsLayout;
    private CssLayout menuItems;

    private static final Logger LOGGER = LoggerFactory.getLogger(WebAdminUI.class);

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = WebAdminUI.class)
    public static class Servlet extends VaadinServlet {
        /**
         *
         *
         */
        private static final long serialVersionUID = -6193754157357404543L;

        @Override
        protected void servletInitialized() throws ServletException {
            super.servletInitialized();
            getService().addSessionInitListener(new ValoThemeSessionInitListener());
        }
    }

    private String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }


    @Autowired
    LoginClient loginClient;

    @Override
    protected void init(VaadinRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("AUTH "+authentication.isAuthenticated());

        /*InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("loginstatus.txt");
        String data = null;
        try {
            data = readFromInputStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("DATA "+data.trim());*/

        /*loginClient.setParam("http://localhost:8484/simple-login/auth/login");
        String data = loginClient.queryClient();*/

        if (getPage().getWebBrowser().isIE() && getPage().getWebBrowser().getBrowserMajorVersion() == 9) {
            menuCssLayout.setWidth("320px");
        }
        Responsive.makeResponsive(this);
        getPage().setTitle(appTitle);
        setContent(root);

        /*System.out.println("DATA "+data.trim());
        if (*//*authentication.isAuthenticated()*//* data != null) {*/
            /*Map<String, Integer> infoAuth = (Map<String, Integer>) authentication.getDetails();
            Map.Entry<String, Integer> firstEntry = (Map.Entry<String, Integer>) infoAuth.entrySet().iterator().next();
            System.out.println("VALUE "+firstEntry.getValue());*/
            /*if (!data.trim().equals("login")){
                System.out.println("Generating Menu");*/

                LinkedList<MenuItemDTO> menuItemDTOs = new LinkedList<>();
                MenuItemDTO menuDashboard = new MenuItemDTO();
                menuDashboard.setName("Dashboard");
                menuDashboard.setKey(TGFConstant.ViewNames.DASHBOARD_VIEW);
                menuDashboard.setIcon(TGFConstant.Icons.DASHBOARD);
                menuDashboard.setViewName(TGFConstant.ViewNames.DASHBOARD_VIEW);

                MenuItemDTO menuSeparatorMaster = new MenuItemDTO();
                menuSeparatorMaster.setName("Master");
                menuSeparatorMaster.setKey(TGFConstant.ViewNames.MENU_SEPARATOR);

                MenuItemDTO masterCompany = new MenuItemDTO();
                masterCompany.setName("Company");
                masterCompany.setKey(TGFConstant.ViewNames.COMPANY_VIEW);
                masterCompany.setIcon(TGFConstant.Icons.AUTOMATION);
                masterCompany.setViewName(TGFConstant.ViewNames.COMPANY_VIEW);


                MenuItemDTO menuLogin = new MenuItemDTO();
                menuLogin.setName("Login");
                menuLogin.setKey(TGFConstant.ViewNames.LOGIN_VIEW);
                menuLogin.setIcon(TGFConstant.Icons.SAFE_LOCK);
                menuLogin.setViewName(TGFConstant.ViewNames.LOGIN_VIEW);

                menuItemDTOs.add(menuDashboard);
                menuItemDTOs.add(menuSeparatorMaster);
                menuItemDTOs.add(masterCompany);
                menuItemDTOs.add(menuLogin);

                menuDTO.setMenuItemDTOs(menuItemDTOs);

                menuCssLayout.addComponent(menuUserSetting);

                menuItems = menuBuilder.build(menuCssLayout, menuItemsLayout, menuDTO, getUI());
                root.addMenu(menuItems);

                addStyleName(ValoTheme.UI_WITH_MENU);

                Navigator navigator = new Navigator(this, root.getViewDisplay());
                navigator.addProvider(springViewProvider);

                String f = Page.getCurrent().getUriFragment();
                if ((f == null) || f.equals(UIConstant.Common.Punctuation.EMPTY)) {
                    getUI().getNavigator().navigateTo(TGFConstant.ViewNames.DASHBOARD_VIEW);
                }

                navigator.setErrorView(CommonParts.class);

                navigator.addViewChangeListener(new ViewChangeListener() {
                    /**
                     *
                     *
                     */
                    private static final long serialVersionUID = -160946546177404031L;

                    @Override
                    public boolean beforeViewChange(ViewChangeEvent event) {
                        return true;
                    }

                    @Override
                    public void afterViewChange(ViewChangeEvent event) {
                        for (Component aMenuItemsLayout : menuItemsLayout) {
                            aMenuItemsLayout.removeStyleName(TGFValoTheme.SELECTED);
                        }
                        for (MenuItemDTO item : menuDTO.getMenuItemDTOs()) {
                            if (event.getViewName().equals(item.getKey())) {
                                for (Component c : menuItemsLayout) {
                                    if (c.getCaption() != null && c.getCaption().startsWith(item.getName())) {
                                        c.addStyleName(TGFValoTheme.SELECTED);
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        menuCssLayout.removeStyleName(TGFValoTheme.VALO_MENU_VISIBLE);
                    }
                });

            /*}
        }*/
    }

    @PreDestroy
    public void beforeDestroyed() {
        System.out.println("Pre destroy");
        root.removeMenu(menuItems);
        menuCssLayout.removeComponent(menuUserSetting);
    }

    private ConnectorTracker tracker;

    @Override
    public ConnectorTracker getConnectorTracker() {
        if (this.tracker == null) {
            this.tracker =  new ConnectorTracker(this) {

                private static final long serialVersionUID = -2097881597523138495L;

                @Override
                public void registerConnector(ClientConnector connector) {
                    try {
                        super.registerConnector(connector);
                    } catch (RuntimeException e) {
                        LOGGER.error("Failed Connector : " +connector.getClass().getCanonicalName());
                        throw e;
                    }
                }

            };
        }

        return tracker;
    }
}
