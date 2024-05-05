package food.inspection.intake.controller;

import food.inspection.intake.service.FoodIntakeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/v1/inspection/")
@RequiredArgsConstructor
public class FoodInspectionController {

    private final FoodIntakeService intakeService;

    /**
     * I am a dumb controller, I just take whatever rawData i get and push to a queue :(
     */
    @PostMapping
    public ResponseEntity<String> postInspection(@RequestBody String rawData) {
        intakeService.pushToQueue(rawData);
        return ResponseEntity.ok(rawData);
    }

}
