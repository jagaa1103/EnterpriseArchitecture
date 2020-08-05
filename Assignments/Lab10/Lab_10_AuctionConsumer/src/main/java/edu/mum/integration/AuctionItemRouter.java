 
package edu.mum.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;

import edu.mum.domain.Item;

@MessageEndpoint
public class AuctionItemRouter {

    final Logger logger = LoggerFactory.getLogger(AuctionItemRouter.class);

	@Router(inputChannel="processedItem")
	public String processAuctionItem(Item item) {
	    String destination = null;
	    
  	    if(item != null && item.getPrice() > 20) {
  	    	destination = "highpricechannel";
  	    }else {
  	    	destination = "moderatepricechannel";
  	    }
	
		return destination;
	}

}
//