package lk.ijse.gdse.repo;

import lk.ijse.gdse.entity.VehicleEntity;
import lk.ijse.gdse.entity.VehicleImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleImageRepo extends JpaRepository<VehicleImageEntity,String> {
  /*  VehicleImageEntity save(VehicleImageEntity imageEntity);
    VehicleImageEntity getVehicleImageEntityByVehicle_image_id(String image_id);
    void deleteByVehicle_image_id(String image_id);*/
    List<VehicleImageEntity> findAll();

    List<VehicleImageEntity> findAllByVehicle(VehicleEntity entity);
}
