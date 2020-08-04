package edu.mum.amqp;

import edu.mum.domain.Item;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class ItemServiceImpl implements ItemService {

    public void publish(RabbitTemplate rabbitTemplate) {


        Item item1 = new Item("Kazoo", "a Hummer", 40f, 1);
        rabbitTemplate.convertAndSend(item1);
        System.out.println("---------- DIRECT producer sent Item: " + item1.getName());


        Item item2 = new Item("Hammer", "Ball Pean", 20f, 2);
        rabbitTemplate.convertAndSend(item2);
        System.out.println("---------- DIRECT producer sent Item: " + item2.getName());
    }

}
