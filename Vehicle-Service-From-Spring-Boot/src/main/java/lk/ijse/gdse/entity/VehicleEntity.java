package lk.ijse.gdse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "vehicle")
public class VehicleEntity implements SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String vehicle_id;
    @Column(nullable = false)
    private String driver_name;
    @Column(nullable = false)
    private String driver_contact_number;
    @Column(nullable = false)
    private String vehicle_brand;
    @Column(nullable = false)
    private String vehicle_category;
    @Column(nullable = false)
    private String vehicle_type;
    @Column(nullable = false)
    private String fuel_type;
    @Column(nullable = false)
    private String fuel_usage;
    @Column(nullable = false)
    private String hybrid_or_no;
    @Column(nullable = false)
    private String seat_capacity;
    @Column(nullable = false)
    private String transmission;
    @Column(nullable = false)
    private String remark;


    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VehicleImageEntity> images;

    /*@OneToMany(mappedBy = "vehicle")
    private List<MainTravelServiceEntity> mainTravelServiceEntities;*/

    public VehicleEntity(String vehicle_id, String diver_name, String vehicle_brand, String vehicle_category, String fuel_type, String fuel_usage, String seat_capacity, String transmission) {
        this.vehicle_id = vehicle_id;
        this.driver_name = diver_name;
        this.vehicle_brand = vehicle_brand;
        this.vehicle_category = vehicle_category;
        this.fuel_type = fuel_type;
        this.fuel_usage = fuel_usage;
        this.seat_capacity = seat_capacity;
        this.transmission = transmission;
    }
}
