package edu.mum.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import edu.mum.domain.Item;

public class ItemServiceImpl implements ItemService {

	@Override
	public void publish(RabbitTemplate producerTemplate) {
		Item item1 = new Item(1L, 0, "Kazoo", (float)50.00,"Kazoo Description!");
		Item item2 = new Item(2L, 0, "Hammer", (float)10.00, "Hammer Description!");
		
		producerTemplate.convertAndSend(item1);
		producerTemplate.convertAndSend(item2);

	}

}
