package fooddelivery;

import fooddelivery.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired StoreRepository storeRepository;
    @Autowired DeliveryRepository deliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPayApproved_PrepareDelivery(@Payload PayApproved payApproved){

        if(!payApproved.validate()) return;

        System.out.println("\n\n##### listener PrepareDelivery : " + payApproved.toJson() + "\n\n");

        Delivery delivery = new Delivery(payApproved.getStoreId(), payApproved.getOrderId());
        deliveryRepository.save(delivery);
    }

    // @StreamListener(KafkaProcessor.INPUT)
    // public void wheneverReviewRegistered_UpdateReviewCount(@Payload ReviewRegistered reviewRegistered){

    //     if(!reviewRegistered.validate()) return;

    //     System.out.println("\n\n##### listener UpdateReviewCount : " + reviewRegistered.toJson() + "\n\n");

    //     // Sample Logic //
    //     // Store store = new Store();
    //     // storeRepository.save(store);
    //     // Delivery delivery = new Delivery();
    //     // deliveryRepository.save(delivery);
            
    // }

    // @StreamListener(KafkaProcessor.INPUT)
    // public void wheneverReviewDeleted_UpdateReviewCount(@Payload ReviewDeleted reviewDeleted){

    //     if(!reviewDeleted.validate()) return;

    //     System.out.println("\n\n##### listener UpdateReviewCount : " + reviewDeleted.toJson() + "\n\n");

    //     // Sample Logic //
    //     // Store store = new Store();
    //     // storeRepository.save(store);
    //     // Delivery delivery = new Delivery();
    //     // deliveryRepository.save(delivery);
            
    // }

    // @StreamListener(KafkaProcessor.INPUT)
    // public void wheneverPayCanceled_CancelDelivery(@Payload PayCanceled payCanceled){

    //     if(!payCanceled.validate()) return;

    //     System.out.println("\n\n##### listener CancelDelivery : " + payCanceled.toJson() + "\n\n");

    //     // Sample Logic //
    //     // Store store = new Store();
    //     // storeRepository.save(store);
    //     // Delivery delivery = new Delivery();
    //     // deliveryRepository.save(delivery);
    // }

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
