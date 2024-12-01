package lk.ijse.gdse.util;


import lk.ijse.gdse.dto.VehicleDTO;
import lk.ijse.gdse.dto.VehicleImageDTO;
import lk.ijse.gdse.entity.VehicleEntity;
import lk.ijse.gdse.entity.VehicleImageEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.List;

@Component
public class Converter {
    private final ModelMapper modelMapper;

    public Converter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public VehicleEntity toVehicleEntity(VehicleDTO vehicleDTO){

        return modelMapper.map(vehicleDTO, VehicleEntity.class);
    }
    public  VehicleDTO toVehicleDTO(VehicleEntity  vehicleEntity){
        List<VehicleImageEntity> images = vehicleEntity.getImages();
        /*vehicleEntity.setImages(null);*/
        VehicleDTO map = modelMapper.map(vehicleEntity, VehicleDTO.class);
        if (images!=null){
            map.setImageDTOS(

                    images.stream().map(i->new VehicleImageDTO(i.getImage_id(),
                            Base64.getDecoder().decode(i.getVehicle_image()),
                            vehicleEntity.getVehicle_id())).toList());
        }


        return map;
    }
    public VehicleImageEntity toVehicleImageEntity(VehicleImageDTO vehicleImageDTO){


        VehicleImageEntity map = modelMapper.map(vehicleImageDTO, VehicleImageEntity.class);
    map.setVehicle_image(Base64.getEncoder().encodeToString(vehicleImageDTO.getVehicle_image()));
    return map;

    }
    public  VehicleImageDTO toVehicleImageDTO(VehicleImageEntity  vehicleImageEntity){

        return modelMapper.map(vehicleImageEntity, VehicleImageDTO.class);
    }
}
