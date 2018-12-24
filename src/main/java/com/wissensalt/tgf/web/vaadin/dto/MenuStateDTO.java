package com.wissensalt.tgf.web.vaadin.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created on 11/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
@Scope(scopeName = "session")
public class MenuStateDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 7536045259640002601L;

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
