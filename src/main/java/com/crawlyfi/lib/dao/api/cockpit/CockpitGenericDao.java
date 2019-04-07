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
        setBody(buildResponseBody());            
        fetchFromApi();
        return null;
    }

    protected void fetchFromApi(){
        JSONArray entires = callApi().getBody().getObject().getJSONArray("entries");
        if(entiriesExist(entires))
            setRespons(entires.getJSONObject(0));        
    }

    protected void saveToApi() {
        callApi();
    }

	protected JSONObject buildResponseBody() {
        return new JSONObject()
        .put("filter", getFilter())
        .put("limit", 1)
        ; 		
    }

    protected JSONObject buildSaveBody() {
        return new JSONObject()
        .put("data", getData()); 		
    }    

    protected JSONArray getJSONArrayFromRespons(String attribute){
        return  getRespons().getJSONArray(attribute);
    }

    protected JSONObject getJSONObjectFromRespons(String attribute){
        return  getRespons().getJSONObject(attribute);
    }    

    protected String getAttribute(String attribute){
        return  getRespons().getString(attribute);
    }       

    protected String getCollectionId(JSONObject collection){                    
        return collection.getString("_id");
    }

    protected boolean entiriesExist(JSONArray crawlerEntriesList){
        if(crawlerEntriesList != null && crawlerEntriesList.length() > 0 )
            return true;
        return false;
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