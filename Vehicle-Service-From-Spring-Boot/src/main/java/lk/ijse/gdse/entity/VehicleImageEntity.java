package lk.ijse.gdse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "vehicleImage")
public class VehicleImageEntity implements SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String image_id;
    @Column(nullable = false,columnDefinition = "LongText")
    @Lob
    private String vehicle_image;

    @ManyToOne
    @JoinColumn(name = "vehicle_id",referencedColumnName = "vehicle_id")
    private VehicleEntity vehicle;

    public VehicleImageEntity(String image_id, String vehicle_image) {
        this.image_id = image_id;
        this.vehicle_image = vehicle_image;
    }
}
