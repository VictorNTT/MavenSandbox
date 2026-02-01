package org.example.sandbox.chroniclequeue.demo;

public interface TradeListener {
    void onTrade(long timestamp, String symbol, double price, int quantity);
}