package com.crawlyfi.lib.dao.api;

import com.crawlyfi.lib.dao.core.GenericDao;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.json.JSONArray;
import org.json.JSONObject;

public abstract class ApiGenericDao<T> extends GenericDao<T> {

    private String apiUrl;
    private JSONObject body;
    private JSONArray respons;

    public ApiGenericDao(){
    }

    @Override
    public T findById(Object id) {
        return null;
    }

    protected HttpResponse<JsonNode> callApi(){
        try {
            
            return Unirest
                    .post(getApiUrl())
                    .header("Content-Type", "application/json").header("accept", "application/json")
                    .body(getBody()).asJson();

        } catch (UnirestException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return the apiUrl
     */
    protected String getApiUrl() {
        return apiUrl;
    }

    /**
     * @param apiUrl the apiUrl to set
     */
    protected void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    /**
     * @return the body
     */
    protected JSONObject getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    protected void setBody(JSONObject body) {
        this.body = body;
    }

    /**
     * @return the respons
     */
    protected JSONArray getRespons() {
        return respons;
    }

    /**
     * @param respons the respons to set
     */
    protected void setRespons(JSONArray respons) {
        this.respons = respons;
    }

}