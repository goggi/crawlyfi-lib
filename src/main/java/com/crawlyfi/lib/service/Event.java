package com.crawlyfi.lib.service;

import java.io.IOException;
import java.util.ArrayList;

import com.crawlyfi.lib.pojo.Message;
import com.crawlyfi.lib.pojo.Input;
import com.crawlyfi.lib.pojo.Output;
import com.crawlyfi.lib.message_broker.Producer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Event {

    private Message message;
    private Event parentEvent;
    private Producer producer;
    private String payload;

    public Event(Producer producer, Message message) {
        setProducer(producer);
        setMessage(message);
        publish();
    }


	public void publish() {
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        setPayload(gson.toJson(message));
        //System.out.println(getPayload());
        try {
            producer.sendMessage(getPayload());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    /**
     * @return the parentEvent
     */
    public Event getParentEvent() {
        return parentEvent;
    }

    /**
     * @param parentEvent the parentEvent to set
     */
    public void setParentEvent(Event parentEvent) {
        this.parentEvent = parentEvent;
    }


    /**
     * @return the producer
     */
    public Producer getProducer() {
        return producer;
    }

    /**
     * @param producer the producer to set
     */
    public void setProducer(Producer producer) {
        this.producer = producer;
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
     * @return the payload
     */
    public String getPayload() {
        return payload;
    }

    /**
     * @param payload the payload to set
     */
    public void setPayload(String payload) {
        this.payload = payload;
    }

}