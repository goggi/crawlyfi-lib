package com.crawlyfi.lib.dao.api.cockpit;

import com.crawlyfi.lib.dao.api.ApiGenericDao;

import org.json.JSONArray;
import org.json.JSONObject;

public class CockpitGenericDao<T> extends ApiGenericDao<T> {


    public CockpitGenericDao(String apiUrl) {
        super(apiUrl);        
    }

    @Override
    public T findById(Object id) {        
        setBody(buildBody(id));        
        
        JSONArray entires = callApi().getBody().getObject().getJSONArray("entries");
        if(entiriesExist(entires))
            setRespons(entires.getJSONObject(0));
        
        return null;
    }

	@Override
	protected JSONObject buildBody(Object id) {
        return new JSONObject()
        .put("filter", new JSONObject()
			.put("_id", (String) id      
            )        
        )
        .put("limit", 1)
        ; 		
    }

    protected JSONArray getJSONArrayFromRespons(String attribute){
        return  getRespons().getJSONArray(attribute);
    }
    
    protected String getCollectionId(JSONObject collection){                    
        return collection.getString("_id");
    }

    protected boolean entiriesExist(JSONArray crawlerEntriesList){
        if(crawlerEntriesList != null && crawlerEntriesList.length() > 0 )
            return true;
        return false;
    }

}