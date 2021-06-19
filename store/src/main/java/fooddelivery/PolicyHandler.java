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
    @Autowired StoreRepository storeRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPayApproved_PrepareDelivery(@Payload PayApproved payApproved){

        if(!payApproved.validate()) return;

        System.out.println("\n\n##### listener PrepareDelivery : " + payApproved.toJson() + "\n\n");

        // Sample Logic //
        Store store = new Store();
        storeRepository.save(store);
            
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReviewRegistered_UpdateReviewCount(@Payload ReviewRegistered reviewRegistered){

        if(!reviewRegistered.validate()) return;

        System.out.println("\n\n##### listener UpdateReviewCount : " + reviewRegistered.toJson() + "\n\n");

        // Sample Logic //
        Store store = new Store();
        storeRepository.save(store);
            
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReviewDeleted_UpdateReviewCount(@Payload ReviewDeleted reviewDeleted){

        if(!reviewDeleted.validate()) return;

        System.out.println("\n\n##### listener UpdateReviewCount : " + reviewDeleted.toJson() + "\n\n");

        // Sample Logic //
        Store store = new Store();
        storeRepository.save(store);
            
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPayCanceled_CancelDelivery(@Payload PayCanceled payCanceled){

        if(!payCanceled.validate()) return;

        System.out.println("\n\n##### listener CancelDelivery : " + payCanceled.toJson() + "\n\n");

        // Sample Logic //
        Store store = new Store();
        storeRepository.save(store);
            
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
