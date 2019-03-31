package com.crawlyfi.lib.dao.api.cockpit;

import com.crawlyfi.lib.dao.api.ApiGenericDao;

import org.json.JSONArray;
import org.json.JSONObject;

public class CockpitGenericDao<T> extends ApiGenericDao<T> {
  
    private JSONObject filter = new JSONObject();
    public CockpitGenericDao(String apiUrl) {
        super(apiUrl);
    }

    @Override
    public T findById(Object id) {
        getFilter().put("_id", id);
        callCockpitAPI();
        return null;
    }

    protected void callCockpitAPI() {
        setBody(buildBody());            
        JSONArray entires = callApi().getBody().getObject().getJSONArray("entries");
        if(entiriesExist(entires))
            setRespons(entires.getJSONObject(0));        
    }

    @Override
	protected JSONObject buildBody() {
        return new JSONObject()
        .put("filter", getFilter())
        .put("limit", 1)
        ; 		
    }

    protected JSONArray getJSONArrayFromRespons(String attribute){
        return  getRespons().getJSONArray(attribute);
    }

    protected JSONObject getJSONObjectFromRespons(String attribute){
        return  getRespons().getJSONObject(attribute);
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
    public JSONObject getFilter() {
        return filter;
    }

    /**
     * @param filter the filter to set
     */
    public void setFilter(JSONObject filter) {
        this.filter = filter;
    }

}