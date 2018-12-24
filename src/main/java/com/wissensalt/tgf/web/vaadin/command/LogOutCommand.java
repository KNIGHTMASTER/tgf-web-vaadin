package com.wissensalt.tgf.web.vaadin.command;

import com.vaadin.server.Page;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created on 10/27/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class LogOutCommand implements MenuBar.Command {
    /**
     *
     *
     */
    private static final long serialVersionUID = 164316776829858477L;

    @Value("${url-logged-out}")
    private String urlLoggedOut;

    @Override
    public void menuSelected(MenuBar.MenuItem selectedItem) {
        if(selectedItem.getText().equals("Sign Out")){
            if (UI.getCurrent().getSession() != null){
                System.out.println("Vaadin Session != null");
            }

            if (VaadinSession.getCurrent().getSession() != null) {
                System.out.println("Vaadin Sesion 2 != null");
            }

            if (VaadinService.getCurrentRequest().getWrappedSession() != null){
                System.out.println("Wrapped session !=null");
            }
            UI.getCurrent().getSession().close();
            UI.getCurrent().getSession().getService().closeSession(VaadinSession.getCurrent());
            UI.getCurrent().close();

            VaadinSession.getCurrent().getSession().invalidate();
            VaadinService.getCurrentRequest().getWrappedSession().invalidate();

            UI.getCurrent().getConnectorTracker().markAllConnectorsDirty();
            UI.getCurrent().getConnectorTracker().markAllClientSidesUninitialized();


            SecurityContextHolder.clearContext();

            Page.getCurrent().setLocation(urlLoggedOut);
        }
    }

}
