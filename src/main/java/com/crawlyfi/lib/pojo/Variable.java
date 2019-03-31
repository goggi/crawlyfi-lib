package com.crawlyfi.lib.pojo;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class Variable {

    @SerializedName("variable")
    private String variable;

    @SerializedName("source")
    private String source;    

    @SerializedName("type")
    private String type;

    @SerializedName("list")
    private Boolean list;

    @SerializedName("value")
    private String rule;

    private String value;
    private ArrayList<String> valueList;    

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
     * @return the source
     */
    public String getSource() {
        return source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(String source) {
        this.source = source;
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
     * @return the list
     */
    public Boolean getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(Boolean list) {
        this.list = list;
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
     * @return the rule
     */
    public String getRule() {
        return rule;
    }

    /**
     * @param rule the rule to set
     */
    public void setRule(String rule) {
        this.rule = rule;
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


}
