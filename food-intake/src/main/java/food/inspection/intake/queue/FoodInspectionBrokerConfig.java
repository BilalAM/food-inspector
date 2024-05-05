package food.inspection.intake.queue;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FoodInspectionBrokerConfig {

    @Bean
    public Queue inspectionQueue() {
        return new Queue("inspection",true);
    }
}
