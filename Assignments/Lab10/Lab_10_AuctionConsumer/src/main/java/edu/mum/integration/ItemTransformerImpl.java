 
package edu.mum.integration;

import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Component;

import edu.mum.domain.Item;

/**
 * Routes order based on order type.
 * 
 */
public class ItemTransformerImpl implements ItemTransformer {

     /**
     * Transform Item from AMQP to Modified Item for JMS
      */
	@Transformer(inputChannel="fromAmqpItem", outputChannel="processedItem")
	public Item transformItem(Item item) {

 	 
		item.setAuctionId(item.getName() + item.getVersion());
		
		return item;
	}

}
//