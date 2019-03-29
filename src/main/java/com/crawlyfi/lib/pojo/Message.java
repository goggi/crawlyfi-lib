package com.crawlyfi.lib.pojo;

import java.util.ArrayList;
import java.util.UUID;

public class Message {
    private UUID messageId = UUID.randomUUID();
    private String configId;
    private String crawlerId;
    private Integer rowId;
    private ArrayList<Variable> variableList;
    private ArrayList<Source> sourceList;

    /**
     * @return the messageId
     */
    public UUID getMessageId() {
        return messageId;
    }

    /**
     * @param messageId the messageId to set
     */
    public void setMessageId(UUID messageId) {
        this.messageId = messageId;
    }

    /**
     * @return the configId
     */
    public String getConfigId() {
        return configId;
    }

    /**
     * @param configId the configId to set
     */
    public void setConfigId(String configId) {
        this.configId = configId;
    }

    /**
     * @return the crawlerId
     */
    public String getCrawlerId() {
        return crawlerId;
    }

    /**
     * @param crawlerId the crawlerId to set
     */
    public void setCrawlerId(String crawlerId) {
        this.crawlerId = crawlerId;
    }

    /**
     * @return the rowId
     */
    public Integer getRowId() {
        return rowId;
    }

    /**
     * @param rowId the rowId to set
     */
    public void setRowId(Integer rowId) {
        this.rowId = rowId;
    }

    /**
     * @return the variableList
     */
    public ArrayList<Variable> getVariableList() {
        return variableList;
    }

    /**
     * @param variableList the variableList to set
     */
    public void setVariableList(ArrayList<Variable> variableList) {
        this.variableList = variableList;
    }

    /**
     * @return the sourceList
     */
    public ArrayList<Source> getSourceList() {
        return sourceList;
    }

    /**
     * @param sourceList the sourceList to set
     */
    public void setSourceList(ArrayList<Source> sourceList) {
        this.sourceList = sourceList;
    }
}