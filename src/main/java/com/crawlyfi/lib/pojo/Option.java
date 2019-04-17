package com.crawlyfi.lib.pojo;

import com.google.gson.annotations.SerializedName;

public class Option {

    @SerializedName("option")
    private String option = "";

    @SerializedName("value")
    private String value = "";

    /**
     * @return the option
     */
    public String getOption() {
        return option;
    }

    /**
     * @param option the option to set
     */
    public void setOption(String option) {
        this.option = option;
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

}
