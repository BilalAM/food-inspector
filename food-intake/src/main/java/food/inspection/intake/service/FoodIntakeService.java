package food.inspection.intake.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FoodIntakeService {

    private final RabbitTemplate rabbitTemplate;

    public void pushToQueue(@NotNull final String rawData) {
        try {
            log.info("Pushing {}", rawData);
            rabbitTemplate.convertAndSend("inspection", rawData, postProcessor -> {
                postProcessor.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                return postProcessor;
            });
        } catch (Exception e) {
            log.error("Event not sent to broker.", e);
        }
    }


}
