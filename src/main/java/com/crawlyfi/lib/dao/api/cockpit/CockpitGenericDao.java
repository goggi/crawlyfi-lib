package com.crawlyfi.lib.dao.api.cockpit;

import com.crawlyfi.lib.dao.api.ApiGenericDao;

import org.json.JSONArray;
import org.json.JSONObject;

public class CockpitGenericDao<T> extends ApiGenericDao<T> {

    private String IdAttribute = "_id";

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
			.put(getIdAttribute(), (String) id      
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
    /**
     * @return the idAttribute
     */
    public String getIdAttribute() {
        return IdAttribute;
    }

    /**
     * @param idAttribute the idAttribute to set
     */
    public void setIdAttribute(String idAttribute) {
        this.IdAttribute = idAttribute;
    }

}