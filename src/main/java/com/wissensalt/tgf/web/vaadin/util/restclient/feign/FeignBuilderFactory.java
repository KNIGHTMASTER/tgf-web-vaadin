package com.wissensalt.tgf.web.vaadin.util.restclient.feign;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created on 2/9/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class FeignBuilderFactory {

    @Value("${api.base.url}")
    private String apiBaseUrl;

    public <T> T createClient(Class<T> type) {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .logger(new Slf4jLogger(type))
                .logLevel(feign.Logger.Level.FULL)
                .target(type, apiBaseUrl);
    }

    public String getApiBaseUrl() {
        return apiBaseUrl;
    }
}
