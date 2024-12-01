package lk.ijse.gdse.service.util;


import lk.ijse.gdse.dto.VehicleDTO;
import lk.ijse.gdse.entity.VehicleEntity;
import lk.ijse.gdse.exception.NotFoundException;
import lk.ijse.gdse.repo.VehicleRepo;
import lk.ijse.gdse.service.VehicleService;
import lk.ijse.gdse.util.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class VehicleServiceIMPL implements VehicleService {

    private final Converter convert;

    private final VehicleRepo vehicleRepo;

    @Override
    public VehicleDTO saveVehicle(VehicleDTO vehicleDTO) {
        return convert.toVehicleDTO(vehicleRepo.save(convert.toVehicleEntity(vehicleDTO)));
    }

    @Override
    public VehicleDTO getSelectedVehicle(String vehicle_id) {
        Optional<VehicleEntity> byId = vehicleRepo.findById(vehicle_id);
        if (byId.isEmpty()) {
            throw new NotFoundException("The vehicle id cannot be found  :" + vehicle_id);
        }
        return convert.toVehicleDTO(byId.get());
        // vehicleRepo.findById(vehicle_id).orElseThrow(()->new NotFoundException("Vehicle Id Not Found :"+ vehicle_id));

    }

    @Override
    public void updateVehicle(String vehicle_id, VehicleDTO vehicleDTO) {
        Optional<VehicleEntity> vehicleEntity = vehicleRepo.findById(vehicle_id);
        if (vehicleEntity.isEmpty()) {
            throw new NotFoundException("The vehicle id cannot be found  :" + vehicle_id);

        }
        VehicleEntity vehicle = vehicleEntity.get();
        vehicle.setDriver_name(vehicleDTO.getDriver_name());
        vehicle.setVehicle_brand(vehicleDTO.getVehicle_brand());
        vehicle.setVehicle_category(vehicleDTO.getVehicle_category());
        vehicle.setFuel_type(vehicleDTO.getFuel_type());
        vehicle.setFuel_usage(vehicleDTO.getFuel_usage());
        vehicle.setSeat_capacity(vehicleDTO.getSeat_capacity());
        vehicle.setTransmission(vehicleDTO.getTransmission());

    }

    @Override
    public void deleteVehicle(String vehicle_id) {
        Optional<VehicleEntity> byId = vehicleRepo.findById(vehicle_id);
        if (byId.isEmpty()) {
            throw new NotFoundException("The vehicle id cannot be found  :" + vehicle_id);
        }
        vehicleRepo.deleteById(vehicle_id);
    }

    @Override
    public List<VehicleDTO> getAllVehicle() {
        return vehicleRepo.findAll().stream().map(vehicle->convert.toVehicleDTO(vehicle)).collect(Collectors.toList());
    }

    @Override
    public List<VehicleDTO> getByName(String name) {
        return null;
    }
}
