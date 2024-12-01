package lk.ijse.gdse.api;

import jakarta.validation.Valid;
import lk.ijse.gdse.dto.VehicleDTO;
import lk.ijse.gdse.dto.VehicleImageDTO;
import lk.ijse.gdse.repo.VehicleImageRepo;
import lk.ijse.gdse.service.VehicleImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicleImage")
@CrossOrigin("*")
public class VehicleImageController {
    private final VehicleImageRepo vehicleImageRepo;
    private final VehicleImageService vehicleImageService;

    public VehicleImageController(VehicleImageRepo vehicleImageRepo, VehicleImageService vehicleImageService) {
        this.vehicleImageRepo = vehicleImageRepo;
        this.vehicleImageService = vehicleImageService;

    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/{vehicle_id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public VehicleImageDTO saveVehicleImage(@Valid @RequestPart List<MultipartFile> vehicle_image
            , @PathVariable String vehicle_id){

        List<byte[]> vehicleImagesData = new ArrayList<>();

        /*String VImag= Base64.getEncoder().encodeToString(vehicle_image);*/
        for (MultipartFile image : vehicle_image) {
            VehicleImageDTO imageDTO=new VehicleImageDTO();

            try {
                imageDTO.setVehicle_image(image.getBytes());
               /* byte[] imageData = image.getBytes();
                vehicleImagesData.add(imageData);*/

            } catch (IOException e) {
                e.printStackTrace();
            }
            return vehicleImageService.saveVehicleImage(vehicle_id, imageDTO);

        }
        return null;

    }
    @RequestMapping("/test")
    @PostMapping()
    public String testSave(@RequestPart List<MultipartFile>images ){
        /*System.out.println("");*/

        return images.size()+"";

    }
    @GetMapping(value = "/{image_id}",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<VehicleImageDTO> getVehicle(@Valid @PathVariable String image_id){
        VehicleImageDTO selectedVehicleImage = vehicleImageService.getSelectedVehicleImage(image_id);

        return new ResponseEntity<>(selectedVehicleImage,HttpStatus.OK);
    }

    @DeleteMapping("/{image_id}")
    void deleteVehicleImage( @PathVariable String image_id){
     vehicleImageService.deleteVehicleImage(image_id);
    }

    @PatchMapping("/{image_id}")
    public ResponseEntity<String> updateVehicleImage(
            @RequestPart List<MultipartFile> vehicle_image,
            @PathVariable String image_id
    ){
        List<VehicleImageDTO> vehicleImagesData = new ArrayList<>();


        for (MultipartFile image : vehicle_image) {
            try {
                VehicleImageDTO imageDTO = new VehicleImageDTO();
                imageDTO.setVehicle_image(image.getBytes());
                vehicleImagesData.add(imageDTO);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (VehicleImageDTO imageDTO : vehicleImagesData) {
            vehicleImageService.updateVehicleImage(image_id, imageDTO);
        }
        return ResponseEntity.ok("Updated");
        /*List<byte[]> vehicleImagesData = new ArrayList<>();

        *//*String VImag= Base64.getEncoder().encodeToString(vehicle_image);*//*
        for (MultipartFile image : vehicle_image) {
            try {
                byte[] imageData = image.getBytes();
                vehicleImagesData.add(imageData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        VehicleImageDTO vehicleImageDTO=new VehicleImageDTO();
        vehicleImageDTO.setVehicle_image(vehicle_image.toString().getBytes());

        vehicleImageService.updateVehicleImage(image_id,vehicleImageDTO);
        return String.valueOf(new ResponseEntity<>(HttpStatus.OK));
*/
    }
    @GetMapping
    public ResponseEntity<List<VehicleImageDTO>> getAllGuide() {
        List<VehicleImageDTO> dto = vehicleImageService.getAllVehicleImages();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
