package fooddelivery;

import fooddelivery.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPayApproved_SendStatus(@Payload PayApproved payApproved){

        if(!payApproved.validate()) return;

        System.out.println("\n\n##### listener SendStatus : " + payApproved.toJson() + "\n\n");

        // Sample Logic //
            
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPayCanceled_SendStatus(@Payload PayCanceled payCanceled){

        if(!payCanceled.validate()) return;

        System.out.println("\n\n##### listener SendStatus : " + payCanceled.toJson() + "\n\n");

        // Sample Logic //
            
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryStarted_SendStatus(@Payload DeliveryStarted deliveryStarted){

        if(!deliveryStarted.validate()) return;

        System.out.println("\n\n##### listener SendStatus : " + deliveryStarted.toJson() + "\n\n");

        // Sample Logic //
            
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryCanceled_SendStatus(@Payload DeliveryCanceled deliveryCanceled){

        if(!deliveryCanceled.validate()) return;

        System.out.println("\n\n##### listener SendStatus : " + deliveryCanceled.toJson() + "\n\n");

        // Sample Logic //
            
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
