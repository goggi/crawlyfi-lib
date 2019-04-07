package com.crawlyfi.lib.pojo;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class Input {

    @SerializedName("input")
    private String input = "";

    @SerializedName("type")
    private String type = "";

    @SerializedName("value")
    private String value = "";

    private ArrayList<String> valueList = new ArrayList<String>();

    public Input(){

    }

    public Input(Input input) {
        setType(new String(input.getType()));
        setValue(new String(input.getValue()));
        setValueList(cloneValueList(input.getValueList()));
        setInput(new String(input.getInput()));
    }

    public static ArrayList<String> cloneValueList(ArrayList<String> inputList) {
        ArrayList<String> clonedList = new ArrayList<String>(inputList.size());
        for (String input : inputList) {
            clonedList.add(new String(input));
        }
        return clonedList;
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
