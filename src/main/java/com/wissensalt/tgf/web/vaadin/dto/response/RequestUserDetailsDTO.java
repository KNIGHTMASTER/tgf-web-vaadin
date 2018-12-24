package com.wissensalt.tgf.web.vaadin.dto.response;

import java.io.Serializable;

/**
 * Created on 3/31/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class RequestUserDetailsDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -4503541401282722351L;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
