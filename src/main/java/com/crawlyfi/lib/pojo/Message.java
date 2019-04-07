package com.crawlyfi.lib.pojo;

import java.util.ArrayList;
import java.util.UUID;

public class Message {
    private UUID messageId = UUID.randomUUID();
    private String configName = "";
    private String configId = "";
    private String crawlerId = "";
    private String crawlerInstanceId = "";
    private String projectName = "";
    private String crawlerName = "";
    private Integer rowId = -1;
    private ArrayList<Input> inputList = new ArrayList<>();
    private ArrayList<Output> outputList = new ArrayList<>();


	public Input getInput(String inputName) {
		for(Input input : getInputList())
			if(input.getInput().equals(inputName))
				return input;
		return null;
    }

	public Output getOutput(String outputName) {
		for(Output output : getOutputList())
			if(output.getInput().equals(outputName))
				return output;
		return null;
	}

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
     * @return the configname
     */
    public String getConfigName() {
        return configName;
    }

    /**
     * @param configname the configname to set
     */
    public void setConfigName(String configname) {
        this.configName = configname;
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
     * @return the crawlerInstanceId
     */
    public String getCrawlerInstanceId() {
        return crawlerInstanceId;
    }

    /**
     * @param crawlerInstanceId the crawlerInstanceId to set
     */
    public void setCrawlerInstanceId(String crawlerInstanceId) {
        this.crawlerInstanceId = crawlerInstanceId;
    }

    /**
     * @return the crawlerName
     */
    public String getCrawlerName() {
        return crawlerName;
    }

    /**
     * @param crawlerName the crawlerName to set
     */
    public void setCrawlerName(String crawlerName) {
        this.crawlerName = crawlerName;
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
     * @return the inputList
     */
    public ArrayList<Input> getInputList() {
        return inputList;
    }

    /**
     * @param inputList the inputList to set
     */
    public void setInputList(ArrayList<Input> inputList) {
        this.inputList = inputList;
    }

    /**
     * @return the outputList
     */
    public ArrayList<Output> getOutputList() {
        return outputList;
    }

    /**
     * @param outputList the outputList to set
     */
    public void setOutputList(ArrayList<Output> outputList) {
        this.outputList = outputList;
    }

    /**
     * @return the projectName
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * @param projectName the projectName to set
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


}