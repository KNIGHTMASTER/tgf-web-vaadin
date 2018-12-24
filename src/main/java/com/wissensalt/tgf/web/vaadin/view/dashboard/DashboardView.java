package com.wissensalt.tgf.web.vaadin.view.dashboard;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.wissensalt.tgf.web.vaadin.constant.TGFConstant;

/**
 * Created on 8/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringView(name = TGFConstant.ViewNames.DASHBOARD_VIEW)
@UIScope
public class DashboardView extends VerticalLayout implements View {
    /**
     *
     *
     */
    private static final long serialVersionUID = -585817829297756597L;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        this.addComponent(new Label("Oke"));
    }
}
