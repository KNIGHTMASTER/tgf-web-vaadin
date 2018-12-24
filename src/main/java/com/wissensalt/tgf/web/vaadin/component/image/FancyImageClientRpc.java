package com.wissensalt.tgf.web.vaadin.component.image;

import com.vaadin.shared.communication.ClientRpc;

/**
 * Created on 9/28/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface FancyImageClientRpc extends ClientRpc {
    public void showImage(String resId);
}
