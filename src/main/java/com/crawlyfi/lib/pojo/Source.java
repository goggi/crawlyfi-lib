package com.crawlyfi.lib.pojo;

import com.google.gson.annotations.SerializedName;

public class Source {

    @SerializedName("source_variable")
    private String variable;

    @SerializedName("source_type")
    private String type;    

    @SerializedName("source_value")
    private String value = "";

    private String[] valueList;
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
     * @return the valueList
     */
    public String[] getValueList() {
        return valueList;
    }

    /**
     * @param valueList the valueList to set
     */
    public void setValueList(String[] valueList) {
        this.valueList = valueList;
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

}
