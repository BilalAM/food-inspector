package food.inspection.ingestor.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Inspection {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate inspectionDate;
    private boolean hasCriticalViolations;
    private String violations;


}
