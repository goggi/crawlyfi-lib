package com.crawlyfi.lib.message_broker;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Represents a connection with a queue
 * 
 * @author Goran
 *
 */
public abstract class EndPoint {

    protected Channel channel;
    protected Connection connection;
    protected String endPointName;
    protected String routingKey = "";
    protected String[] settings;
    protected boolean isExchange = false;


    public EndPoint(String[] settings) throws IOException {
        this.settings = settings;
        connect();
    }

    private void connect() throws IOException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(settings[0]);
        factory.setPort(Integer.parseInt(settings[1]));        
		factory.setUsername(settings[2]);
        factory.setPassword(settings[3]);
        try {
            connection = factory.newConnection();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        channel = connection.createChannel();        
    }

    public EndPoint  setExchange(String exchangeName) throws IOException {
        this.endPointName = exchangeName;
        this.isExchange = true;
        channel.exchangeDeclare(exchangeName, ExchangeType.FANOUT.getExchangeType());
        return this;
    }
    public EndPoint  bindQueToExchange(String queName, String exchangeName) throws IOException {        
        this.endPointName = queName;        
        channel.queueBind(queName, exchangeName, routingKey);
        return this;       
    }    
    public EndPoint setQue(String queName) throws IOException {
        this.endPointName = queName;
        channel.queueDeclare(queName, false, false, false, null);
        return this;
    }        
	
	
    /**
     * Close channel and connection. Not necessary as it happens implicitly any way. 
     * @throws IOException
     */
     public void close() throws IOException{
         try {
            this.channel.close();
        } catch (TimeoutException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         this.connection.close();
     }
}