package com.wissensalt.tgf.web.vaadin.util.restclient.feign;

import com.wissensalt.tgf.web.vaadin.dto.response.GenericListResponseDTO;
import com.wissensalt.tgf.web.vaadin.dto.response.GenericSingleDATAResponseDTO;
import com.wissensalt.tgf.web.vaadin.dto.response.RequestDeleteById;
import com.wissensalt.tgf.web.vaadin.dto.response.RequestFindById;
import com.wissensalt.tgf.web.vaadin.dto.response.RequestPaginationAllDTO;
import com.wissensalt.tgf.web.vaadin.dto.response.RequestPaginationByCodeDTO;
import com.wissensalt.tgf.web.vaadin.dto.response.RequestPaginationByNameDTO;
import com.wissensalt.tgf.web.vaadin.dto.response.ResponseData;
import com.wissensalt.tgf.web.vaadin.dto.response.ResponseGenericPaginationDTO;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

/**
 * Created on 2/9/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Headers({"Accept: application/json", "Content-Type: application/json"})
public interface IFeignScaffoldingClient<RESPONSE> {

    /*INQUIRY*/
    @Headers("x-auth-token: {token}")
    @RequestLine("GET /api/{entityName}/100004")
    GenericListResponseDTO<RESPONSE> findAll(@Param("token") String p_Token, @Param("entityName") String p_EntityName);

    @Headers("x-auth-token: {token}")
    @RequestLine("POST /api/{entityName}/100005")
    ResponseGenericPaginationDTO<RESPONSE> findPaginationAll(@Param("token") String p_Token, @Param("entityName") String p_EntityName, RequestPaginationAllDTO p_RequestPaginationAllDTO);

    @Headers("x-auth-token: {token}")
    @RequestLine("POST /api/{entityName}/100031")
    ResponseGenericPaginationDTO<RESPONSE> findPaginationByCodeOrderById(@Param("token") String p_Token, @Param("entityName") String p_EntityName, RequestPaginationByCodeDTO p_RequestPaginationByCodeDTO);

    @Headers("x-auth-token: {token}")
    @RequestLine("POST /api/{entityName}/100032")
    ResponseGenericPaginationDTO<RESPONSE> findPaginationByNameOrderById(@Param("token") String p_Token, @Param("entityName") String p_EntityName, RequestPaginationByNameDTO p_RequestPaginationByNameDTO);

    @Headers("x-auth-token: {token}")
    @RequestLine("POST /api/{entityName}/100006")
    GenericSingleDATAResponseDTO<RESPONSE> findById(@Param("token") String p_Token, @Param("entityName") String p_EntityName, RequestFindById p_RequestFindById);

    @Headers("x-auth-token: {token}")
    @RequestLine("GET /api/{entityName}/100017")
    GenericListResponseDTO selectLOV(@Param("token") String p_Token);

    /*TRANSACTION*/
    @Headers("x-auth-token: {token}")
    @RequestLine("POST /api/{entityName}/100023")
    ResponseData insert(@Param("token") String p_Token, @Param("entityName") String p_EntityName, RESPONSE p_RESPONSE);

    @Headers("x-auth-token: {token}")
    @RequestLine("PUT /api/{entityName}/100022")
    ResponseData update(@Param("token") String p_Token, @Param("entityName") String p_EntityName, RESPONSE p_RESPONSE);

    @Headers("x-auth-token: {token}")
    @RequestLine("DELETE /api/{entityName}/100026")
    ResponseData delete(@Param("token") String p_Token, @Param("entityName") String p_EntityName, RequestDeleteById p_RequestDeleteById);

    @Headers("x-auth-token: {token}")
    @RequestLine("DELETE /api/{entityName}/100029")
    ResponseData deleteCollection(@Param("token") String p_Token, @Param("entityName") String p_EntityName, List<String> p_ListOfIdToDelete);
}
