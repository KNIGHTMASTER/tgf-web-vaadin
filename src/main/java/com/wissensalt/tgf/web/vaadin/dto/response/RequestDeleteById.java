package com.wissensalt.tgf.web.vaadin.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created on 2/9/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class RequestDeleteById implements Serializable {
    private static final long serialVersionUID = -3487789279591601744L;
    private String id;

    public RequestDeleteById() {
    }

    @JsonProperty("id")
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
