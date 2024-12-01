package lk.ijse.gdse.dto;


import lk.ijse.gdse.entity.VehicleEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor

@ToString
public class VehicleImageDTO {

    private String image_id;

    private byte[] vehicle_image;


    private String vehicle_id;

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public byte[] getVehicle_image() {
        return vehicle_image;
    }

    public void setVehicle_image(byte[] vehicle_image) {
        this.vehicle_image = vehicle_image;
    }

    public String getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(String vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public VehicleImageDTO(String image_id, byte[] vehicle_image) {
        this.image_id = image_id;
        this.vehicle_image = vehicle_image;
    }
}
