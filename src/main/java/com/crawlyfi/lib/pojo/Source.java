package com.crawlyfi.lib.pojo;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class Source {

    @SerializedName("source_variable")
    private String variable = "";

    @SerializedName("source_type")
    private String type = "";    

    @SerializedName("source_value")
    private String value = "";

    private ArrayList<String> valueList = new ArrayList<String>();
    private Boolean valueIsList = false;

    /**
     * @return the variable
     */
    public String getVariable() {
        return variable;
    }

    /**
     * @param variable the variable to set
     */
    public void setVariable(String variable) {
        this.variable = variable;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return the valueIsList
     */
    public Boolean isValueList() {
        return valueIsList;
    }

    /**
     * @param valueIsList the valueIsList to set
     */
    public void setValueIsList(Boolean valueIsList) {
        this.valueIsList = valueIsList;
    }

    /**
     * @return the valueList
     */
    public ArrayList<String> getValueList() {
        return valueList;
    }

    /**
     * @param valueList the valueList to set
     */
    public void setValueList(ArrayList<String> valueList) {
        this.valueList = valueList;
    }

    /**
     * @return the valueIsList
     */
    public Boolean getValueIsList() {
        return valueIsList;
    }

}
