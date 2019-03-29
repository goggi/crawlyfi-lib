package com.crawlyfi.lib.message_broker;

import java.io.IOException;

/**
 * The producer endpoint that writes to the queue.
 * @author Goran
 *
 */
public class Producer extends EndPoint{

	public Producer(String[] settings) throws IOException{
		super(settings);
	}	

	public void sendMessage(String message) throws IOException {
		if(isExchange) 
			sendExchangeMessage(message);
		else
			sendQueMessage(message);
	}

	private void sendQueMessage(String message) throws IOException {
	    channel.basicPublish("",endPointName, null, message.getBytes());
	}	
	private void sendExchangeMessage(String message) throws IOException {
	    channel.basicPublish(endPointName,routingKey, null, message.getBytes());
	}

    public Producer setExchange(String exchangeName) throws IOException {
		super.setExchange(exchangeName);
        return this;
    }
    public Producer bindQueToExchange(String queName, String exchangeName) throws IOException {        
		super.bindQueToExchange(queName, exchangeName);
        return this;       
    }    
    public Producer setQue(String queName) throws IOException {
		super.setQue(queName);
        return this;
    }  	
}