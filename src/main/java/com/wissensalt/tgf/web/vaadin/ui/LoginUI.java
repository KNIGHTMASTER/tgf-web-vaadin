package com.wissensalt.tgf.web.vaadin.ui;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.ClientConnector;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.spring.server.SpringVaadinServlet;
import com.vaadin.ui.ConnectorTracker;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.wissensalt.tgf.web.vaadin.constant.TGFConstant;
import com.wissensalt.tgf.web.vaadin.theme.ValoThemeSessionInitListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;


/**
 * Created on 9/27/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Title("Login App")
@Theme("tgf")
@SpringUI(path = "/login")
@PreserveOnRefresh
@Scope(scopeName = "prototype")
public class LoginUI extends UI {
    /**
     *
     *
     */
    private static final long serialVersionUID = -6619434669245765004L;

    @Autowired
    private SpringViewProvider springViewProvider;

    private ConnectorTracker tracker;

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginUI.class);

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = LoginUI.class)
    public static class Servlet extends SpringVaadinServlet {
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

    @Override
    protected void init(VaadinRequest request) {
        this.setSizeFull();
        this.setResponsive(true);

        VerticalLayout root = new VerticalLayout();
        root.setSpacing(true);
        root.setMargin(false);

        setContent(root);

        Navigator navigator = new Navigator(this, this);
        navigator.addProvider(springViewProvider);
        getUI().getNavigator().navigateTo(TGFConstant.ViewNames.LOGIN_VIEW);
    }

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
                        LOGGER.error("Failed Connector : " +connector.getClass().getSimpleName());
                        LOGGER.error(e.toString());
                        throw e;
                    }
                }

            };
        }

        return tracker;
    }
}
