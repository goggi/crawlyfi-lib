package com.crawlyfi.lib.service;

import com.crawlyfi.lib.pojo.Message;
import com.google.gson.Gson;

public class Factory {
	
	private Message message;

	public Factory(String payload){
		setMessage(new Gson().fromJson(payload, Message.class));        
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
}