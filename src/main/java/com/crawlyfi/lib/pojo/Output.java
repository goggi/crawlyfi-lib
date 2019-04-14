package com.crawlyfi.lib.pojo;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class Output {

    @SerializedName("output")
    private String output = "";

    @SerializedName("input")
    private String input = "";

    @SerializedName("type")
    private String type = "";

    @SerializedName("list")
    private Boolean list = false;

    @SerializedName("rule")
    private String rule = "";

    private String value = "";
    private ArrayList<String> valueList = new  ArrayList<String>();

    /**
     * @return the output
     */
    public String getOutput() {
        return output;
    }

    /**
     * @param output the output to set
     */
    public void setOutput(String output) {
        this.output = output;
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
    public Boolean isList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(Boolean list) {
        this.list = list;
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
     * @return the list
     */
    public Boolean getList() {
        return list;
    }

    /**
     * @return the input
     */
    public String getInput() {
        return input;
    }

    /**
     * @param input the input to set
     */
    public void setInput(String input) {
        this.input = input;
    }


}
