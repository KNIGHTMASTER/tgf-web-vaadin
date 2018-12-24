package com.wissensalt.tgf.web.vaadin.client;

import com.wissensalt.tgf.web.vaadin.util.restclient.spring.ARestClient;
import org.springframework.stereotype.Component;

/**
 * Created on 10/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class LoginClient extends ARestClient<String, Object> {
    @Override
    public Class<String> getObjectResultClass() {
        return String.class;
    }
}
