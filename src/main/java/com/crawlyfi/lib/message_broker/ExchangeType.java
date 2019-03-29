package com.crawlyfi.lib.message_broker;

public enum ExchangeType {
  
    DIRECT("direct"),
    TOPIC("topic"),
    FANOUT("fanout"),
    HEADER("headers");
    
    private final String exchangeName;
   
    ExchangeType(String exchangeName) {
      this.exchangeName = exchangeName;
    }
    
    public String getExchangeType() {
      return this.exchangeName;
    }
   
  }