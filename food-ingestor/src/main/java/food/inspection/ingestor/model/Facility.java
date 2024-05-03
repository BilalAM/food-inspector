package food.inspection.ingestor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Facility {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Inspection inspections;

    private String facilityName;
    private String facilityAddressComplete;
    private String cuisine;
    private String facilityLatitude;
    private String facilityLongitude;
    private boolean isStillOpen;


}
