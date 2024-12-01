package lk.ijse.gdse.service.util;


import lk.ijse.gdse.dto.VehicleImageDTO;
import lk.ijse.gdse.entity.VehicleEntity;
import lk.ijse.gdse.entity.VehicleImageEntity;
import lk.ijse.gdse.exception.NotFoundException;
import lk.ijse.gdse.repo.VehicleImageRepo;
import lk.ijse.gdse.repo.VehicleRepo;
import lk.ijse.gdse.service.VehicleImageService;
import lk.ijse.gdse.util.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class VehicleImageServiceIMPL implements VehicleImageService {

    private final Converter converter;

    private final VehicleImageRepo vehicleImageRepo;
    private  final VehicleRepo vehicleRepo;


   /* private String saveImage(byte[] imageData){
        VehicleImageEntity vehicleImageEntity=new VehicleImageEntity();
        vehicleImageEntity.setVehicle_image(Arrays.toString(imageData));
        vehicleImageRepo.save(imageData);

    }*/


    @Override
    public VehicleImageDTO saveVehicleImage(String vehicle_id,VehicleImageDTO imageDTO) {
        System.out.println(imageDTO.getVehicle_image() +"vehicle Image");
        VehicleEntity vehicleEntity = vehicleRepo.findById(vehicle_id).orElseThrow();

        VehicleImageEntity imageEntity= converter.toVehicleImageEntity(imageDTO);
        System.out.println(imageEntity.getVehicle_image() +"Vehicle Entity Image");
        imageEntity.setVehicle(vehicleEntity);

        System.out.println(imageDTO.getVehicle_image()+"Vehicle Image Dto");
        String image= Base64.getEncoder().encodeToString(imageDTO.getVehicle_image());
        System.out.println(image + " NEW");


        VehicleImageDTO vehicleImageDTO = converter.toVehicleImageDTO(vehicleImageRepo.save(imageEntity));
        vehicleImageDTO.setVehicle_image(image.getBytes());
        System.out.println(vehicleImageDTO+"******");
        return vehicleImageDTO;
    }

    @Override
    public VehicleImageDTO getSelectedVehicleImage(String image_id) {
        VehicleImageEntity vehicleImageEntity = vehicleImageRepo.findById(image_id).orElseThrow(()->new NotFoundException("The vehicle id cannot be found :"+image_id));
        VehicleImageDTO vehicleImageDTO = converter.toVehicleImageDTO(vehicleImageEntity);
        vehicleImageDTO.setVehicle_id(vehicleImageEntity.getVehicle().getVehicle_id());
        vehicleImageDTO.setVehicle_image(vehicleImageEntity.getVehicle_image().getBytes());
        /*vehicleImageEntity.setVehicle_image(vehicleImageEntity.getVehicle_image());*/
        System.out.println(vehicleImageDTO.getVehicle_image() + "Vehicle Imagessssss");
        /*System.out.println(vehicleImageEntity.getVehicle_image() + " Vehicle Image Entity");*/
        /*String vImages= Arrays.toString(vehicleImageDTO.getVehicle_image());*/
        /*System.out.println(vImages + "Vehicle Service");*/
        return vehicleImageDTO;
    }

    @Override
    public void updateVehicleImage(String image_id,VehicleImageDTO imageDTO) {
        Optional<VehicleImageEntity> imageEntity=vehicleImageRepo.findById(image_id);
        if (imageEntity.isEmpty()){
            throw new NotFoundException("The vehicle id cannot be found :"+image_id);

        }
        VehicleImageEntity vehicleImage=imageEntity.get();
        vehicleImage.setVehicle_image(Arrays.toString(imageDTO.getVehicle_image()));

    }

    @Override
    public void deleteVehicleImage(String image_id) {
        Optional<VehicleImageEntity> byId = vehicleImageRepo.findById(image_id);
        if (byId.isEmpty()){
            throw new NotFoundException("The vehicle id cannot be found :"+image_id);
        }
        vehicleImageRepo.deleteById(image_id);

    }

    @Override
    public List<VehicleImageDTO> getAllVehicleImages() {
        return vehicleImageRepo.findAll().stream().map(vehicleImage->converter.toVehicleImageDTO(vehicleImage)).collect(Collectors.toList());
    }



}
