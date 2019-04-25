package com.crawlyfi.lib.dao.api.cockpit;

import com.crawlyfi.lib.dao.api.ApiGenericDao;

import org.json.JSONArray;
import org.json.JSONObject;

public class CockpitGenericDao<T> extends ApiGenericDao<T> {

    private String cockpitUrl;
    private JSONObject filter = new JSONObject();
    private JSONObject data = new JSONObject();
    private String collection;

    public CockpitGenericDao() {
    }

    @Override
    public T findById(Object id) {
        setApiUrl(getCockpitUrl()+"/get/"+getCollection());
        getFilter().put("_id", id);
        setBody(buildResponseBody().put("limit", 1));
        fetchFromApi();
        return null;
    }

    protected void fetchFromApi(){
        setRespons(callApi().getBody().getArray());
    }

    protected void saveToApi() {
        callApi();
    }

	protected JSONObject buildResponseBody() {
        return new JSONObject()
        .put("filter", getFilter())
        .put("simple", 1)
        ;
    }

    protected JSONObject buildSaveBody() {
        return new JSONObject()
        .put("data", getData());
    }

    protected JSONArray getJSONArrayFromRespons(String attribute){
        try {
            return  getRespons().getJSONObject(0).getJSONArray(attribute);
        } catch (Exception e) {
            return null;
        }

    }

    protected JSONObject getJSONObjectFromRespons(String attribute){
            try {
                return getRespons().getJSONObject(0).getJSONObject(attribute);
            } catch (Exception e) {
                return null;
            }
    }

    protected String getAttribute(String attribute){
        try {
            return  getRespons().getJSONObject(0).getString(attribute);
        } catch (Exception e) {
            return "";
        }

    }

    protected String getCollectionId(JSONObject collection){
        return collection.getString("_id");
    }

    protected boolean entiriesExist(JSONArray crawlerEntriesList){
        return crawlerEntriesList != null && crawlerEntriesList.length() > 0;
    }

    /**
     * @return the filter
     */
    protected JSONObject getFilter() {
        return filter;
    }

    /**
     * @param filter the filter to set
     */
    protected void setFilter(JSONObject filter) {
        this.filter = filter;
    }

    /**
     * @return the data
     */
    protected JSONObject getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    protected void setData(JSONObject data) {
        this.data = data;
    }

    /**
     * @return the collection
     */
    protected String getCollection() {
        return collection;
    }

    /**
     * @param collection the collection to set
     */
    protected void setCollection(String collection) {
        this.collection = collection;
    }

    /**
     * @return the cockpitUrl
     */
    public String getCockpitUrl() {
        return cockpitUrl;
    }

    /**
     * @param cockpitUrl the cockpitUrl to set
     */
    public void setCockpitUrl(String cockpitUrl) {
        this.cockpitUrl = cockpitUrl;
    }

}