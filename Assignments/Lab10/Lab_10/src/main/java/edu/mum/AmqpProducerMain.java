package edu.mum;

import edu.mum.amqp.ItemService;
import edu.mum.amqp.ItemServiceImpl;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AmqpProducerMain {
	
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("classpath:META-INF/spring/item-app-context.xml");
        RabbitTemplate rabbitTemplate = context.getBean("itemStoreTemplate", RabbitTemplate.class);


        try{
            Thread.sleep(10000);
            ItemService itemService = new ItemServiceImpl();
            itemService.publish(rabbitTemplate);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
