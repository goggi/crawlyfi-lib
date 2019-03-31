package com.crawlyfi.lib.message_broker;

import java.io.IOException;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

/**
 * The endpoint that consumes messages off of the queue. Happens to be runnable.
 * @author syntx
 *
 */
public class QueueConsumer extends EndPoint implements Runnable, Consumer{
	
	
	public QueueConsumer(String[] settings) throws IOException {
		super(settings);		
	}

	public void run() {
		try {
			//start consuming messages. Auto acknowledge messages.
			channel.basicConsume(endPointName, true,this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Called when consumer is registered.
	 */
	public void handleConsumeOk(String consumerTag) {
		System.out.println("Consumer "+consumerTag +" registered");		
	}

	/**
	 * Called when new message is available.
	 */
	public void handleDelivery(String consumerTag, Envelope env, BasicProperties props, byte[] body) throws IOException {				
		handleMessage(new String(body, "UTF-8"));
	}


    public QueueConsumer setExchange(String exchangeName) throws IOException {
		super.setExchange(exchangeName);
        return this;
    }
    public QueueConsumer bindQueToExchange(String queName, String exchangeName) throws IOException {        
		super.bindQueToExchange(queName, exchangeName);
        return this;       
    }    
    public QueueConsumer setQue(String queName) throws IOException {
		super.setQue(queName);
        return this;
    }  
	
	public void handleMessage(String message) {}
	public void handleCancel(String consumerTag) {}
	public void handleCancelOk(String consumerTag) {}
	public void handleRecoverOk(String consumerTag) {}
	public void handleShutdownSignal(String consumerTag, ShutdownSignalException arg1) {}
}