package lk.ijse.gdse.api;

import jakarta.validation.Valid;
import lk.ijse.gdse.dto.VehicleDTO;
import lk.ijse.gdse.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicle")
@CrossOrigin("*")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    VehicleDTO saveVehicle(@Valid @RequestBody VehicleDTO vehicleDTO) {
//        VehicleDTO vehicleDTO=new VehicleDTO();
//        vehicleDTO.setDriver_name(driver_name);
//        vehicleDTO.setVehicle_brand(vehicle_brand);
//        vehicleDTO.setVehicle_category(vehicle_category);
//        vehicleDTO.setFuel_type(fuel_type);
//        vehicleDTO.setFuel_usage(fuel_usage);
//        vehicleDTO.setSeat_capacity(seat_capacity);
//        vehicleDTO.setTransmission(transmission);


        System.out.println(vehicleDTO.getVehicle_id() + "***");
        return vehicleService.saveVehicle(vehicleDTO);
    }

    //    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping(consumes = "application/json",produces = "application/json")
//    VehicleDTO saveVehicle(@Valid @RequestBody VehicleDTO vehicleDTO){
//        System.out.println(vehicleDTO.getVehicle_id());
//        System.out.println(vehicleDTO.getDriver_name());
//        System.out.println(vehicleDTO.getVehicle_brand());
//        System.out.println(vehicleDTO.getVehicle_category());
//        System.out.println(vehicleDTO.getFuel_usage());
//        System.out.println(vehicleDTO.getFuel_type());
//        System.out.println(vehicleDTO.getTransmission());
//        return vehicleService.saveVehicle(vehicleDTO);
//    }
    @GetMapping("/{vehicle_id}")
    ResponseEntity<VehicleDTO> getVehicle(@Valid @PathVariable String vehicle_id) {
        VehicleDTO vehicleDTO = vehicleService.getSelectedVehicle(vehicle_id);
        return new ResponseEntity<>(vehicleDTO, HttpStatus.OK);
    }


    @DeleteMapping("/{vehicle_id}")
    void deleteVehicle(@Valid @PathVariable String vehicle_id) {
        vehicleService.deleteVehicle(vehicle_id);

    }

    @PatchMapping("/{vehicle_id}")
    void updateVehicle(@Valid @PathVariable String vehicle_id, @RequestBody VehicleDTO vehicleDTO) {
        vehicleService.updateVehicle(vehicle_id, vehicleDTO);

    }
    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getAllGuide() {
        List<VehicleDTO> dto = vehicleService.getAllVehicle();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
