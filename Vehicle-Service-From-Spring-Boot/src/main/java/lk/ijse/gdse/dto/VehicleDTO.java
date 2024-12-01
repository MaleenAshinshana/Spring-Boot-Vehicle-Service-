package lk.ijse.gdse.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import lk.ijse.gdse.entity.VehicleImageEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class VehicleDTO {
    @Null(message = "Vehicle ID will auto generate")
    private String vehicle_id;
    @NotNull(message = "Driver name cannot be empty")
    @Pattern(regexp = "[A-Za-z ]+")
    private String driver_name;
    @NotNull(message = "Driver contact number cannot be empty")
    private String driver_contact_number;
    @NotNull(message = "Vehicle Brand cannot be empty")
    private String vehicle_brand;
     @NotNull(message = "Vehicle Category cannot be empty")
    private String vehicle_category;
    @NotNull(message = "Vehicle Type cannot be empty")
    private String vehicle_type;
     @NotNull(message = "Fuel Type cannot be empty")
    private String fuel_type;
     @NotNull(message = "Fuel Usage cannot be empty")
    private String fuel_usage;
    @NotNull(message = "Hybrid Type cannot be empty")
    private String hybrid_or_no;
     @NotNull(message = "Seat Capacity cannot be empty")
    private String seat_capacity;
     @NotNull(message = "Transmission cannot be empty")
    private String transmission;


    private String remark;

    private List<VehicleImageDTO>imageDTOS=new ArrayList<>();
}
