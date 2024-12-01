package lk.ijse.gdse.service;

import lk.ijse.gdse.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    VehicleDTO saveVehicle(VehicleDTO vehicleDTO);
    VehicleDTO getSelectedVehicle(String vehicle_id);
    void updateVehicle(String vehicle_id,VehicleDTO vehicleDTO);
    void deleteVehicle(String vehicle_id);
    List<VehicleDTO> getAllVehicle();
    List<VehicleDTO> getByName(String name);
}
