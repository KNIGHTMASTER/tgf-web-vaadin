package com.wissensalt.tgf.web.vaadin.util;

/**
 * Created on 10/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface UIConstant {
    interface Common {
        String BASE_PACKAGES = "id.co.telkomsigma.tmf";
        String AUTHORIZATION = "Authorization";
        String BEARER_PREFIX = "Bearer ";
        String BASIC_PREFIX = "Basic ";
        String REALM_PREFIX = "realm=";
        String REALM_BASIC = BASIC_PREFIX.concat(REALM_PREFIX).concat("\"Authorization/client\"");
        String REALM_BEARER = BEARER_PREFIX.concat(REALM_PREFIX).concat("\"oauth\"");
        String WWW_AUTHANTICATE = "WWW-Authenticate";
        String METHOD_POST = "POST";
        String CLIENT_IDENTIFIER = "client_id";
        String CLIENT_SECRET = "client_secret";
        String HTTP_REQUEST = "HTTP.REQUEST";
        String ACCESS_TOKEN = "access_token";

        String DATE_FORMAT = "dd-MM-yyyy";
        String DATE_TIME_FORMAT = "dd-MM-yyyy";
        String PUBLIC_USER = "Public User";

        String APPLICATION_JSON = "application/json";
        String APPLICATION_XML = "application/xml";

        interface GeneralValue{
            int ONE = 1;
            int ZERO = 0;
            int MIN_ONE = -1;

            String OK = "OK";
            String KEY = "Key";
            String VALUE = "Value";
        }

        interface Punctuation {
            String SPACE = " ";
            String COLON = ":";
            String SEMI_COLON = ";";
            String COMMA = ",";
            String QUESTION = "?";
            String UNDERSCORE = "_";
            String HYPHEN = "-";
            String SLASH = "/";
            String AT_MARK = "@";
            String EMPTY = "";
            String PERCENTAGE = "%";
        }
    }
}
