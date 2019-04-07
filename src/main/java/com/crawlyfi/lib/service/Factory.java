package com.crawlyfi.lib.service;

import java.util.HashMap;

import com.crawlyfi.lib.message_broker.Producer;
import com.crawlyfi.lib.pojo.Input;
import com.crawlyfi.lib.pojo.Message;
import com.google.gson.Gson;

public class Factory {

	private Message message;
	private HashMap<String, Producer> producerList;

	public Factory(){
	}

	public Message createMessage(String payload) {
		return new Gson().fromJson(payload, Message.class);
	}

	/**
	 * @return the message
	 */
	public Message getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(Message message) {
        this.message = message;
	}

	/**
	 * @return the producerList
	 */
	public HashMap<String, Producer> getProducerList() {
		return producerList;
	}

	/**
	 * @param producerList the producerList to set
	 */
	public void setProducerList(HashMap<String, Producer> producerList) {
		this.producerList = producerList;
	}
}