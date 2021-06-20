package fooddelivery;

import fooddelivery.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired 
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryStarted_ModifyOrderStatus(@Payload DeliveryStarted deliveryStarted){

        if(!deliveryStarted.validate()) {
            return;
        }

        System.out.println("\n\n##### listener ModifyOrderStatus : " + deliveryStarted.toJson() + "\n\n");

        Order order = orderRepository.findById(deliveryStarted.getOrderId()).get();
        order.setStatus("Deliver");
        orderRepository.save(order);
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryCanceled_ModifyOrderStatus(@Payload DeliveryCanceled deliveryCanceled){

        if(!deliveryCanceled.validate()) return;

        System.out.println("\n\n##### listener ModifyOrderStatus : " + deliveryCanceled.toJson() + "\n\n");

        // Sample Logic //
        Order order = orderRepository.findById(deliveryCanceled.getOrderId()).get();
        orderRepository.delete(order);            
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
