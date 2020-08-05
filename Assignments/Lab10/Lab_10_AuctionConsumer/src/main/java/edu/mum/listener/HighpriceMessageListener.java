package edu.mum.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.mum.domain.Item;


public class HighpriceMessageListener implements MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(HighpriceMessageListener.class);

    public void onMessage(Message message) {
        ObjectMessage objectMessage = (ObjectMessage) message;
        Item auctionItem = null;
		try {
			auctionItem = (Item) objectMessage.getObject();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("High Price Item - Message received: " );
        System.out.println("         Item Name: "  + 
                auctionItem.getName());
        System.out.println("         Item Price: "  + 
                auctionItem.getPrice());
        System.out.println("         Auction ID: "  + 
                auctionItem.getAuctionId());

    }
}
//