package com.crawlyfi.lib.message_broker;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import com.crawlyfi.lib.message_broker.EndPoint;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

/**
 * EventConsumer
 */
public class EventConsumer extends EndPoint implements Runnable, Consumer {

    private Integer priority = 0;
    private Integer prefetch = 0;
    private Boolean autoAck = false;
    private Boolean exclusive = false;


    public EventConsumer(String[] settings, Integer prefetch, Boolean autoAck, Integer priority, Boolean exclusive) throws IOException {
        super(settings);
        this.priority = priority;
        this.prefetch = prefetch;
        this.autoAck = autoAck;
        this.exclusive = exclusive;
        channel.basicQos(this.prefetch);
    }    

    public EventConsumer(String[] settings, Integer prefetch, Boolean autoAck, Integer priority) throws IOException {
        super(settings);
        this.priority = priority;
        this.prefetch = prefetch;
        this.autoAck = autoAck;
        channel.basicQos(this.prefetch);
    }

    @Override
    public void run() {
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("x-priority", priority);                                
            try {
                channel.basicConsume(endPointName, this.autoAck, "", false, this.exclusive, args, this);    
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }

    private void ackMessage(Envelope env) {
        if(this.autoAck)
            return;

        try {
            channel.basicAck(env.getDeliveryTag(), true);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
	/**
	 * Called when new message is available.
	 */
    @Override
    public void handleDelivery(String consumerTag, Envelope env, BasicProperties props, byte[] body) throws IOException {
        handleMessage(new String(body, StandardCharsets.UTF_8));
        this.ackMessage(env);
    }
    
	/**
	 * Called when consumer is registered.
	 */
	public void handleConsumeOk(String consumerTag) {
		System.out.println("Consumer "+consumerTag +" registered");		
	}

    public void handleMessage(String message) {}
    @Override public void handleCancelOk(String consumerTag) {}
    @Override public void handleCancel(String consumerTag) throws IOException {}
    @Override public void handleShutdownSignal(String consumerTag, ShutdownSignalException sig) {}
    @Override public void handleRecoverOk(String consumerTag) {}
}