package lk.ijse.gdse.repo;

import lk.ijse.gdse.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.List;

@Repository
public interface VehicleRepo extends JpaRepository<VehicleEntity, String> {
    /*VehicleEntity save(VehicleEntity vehicleEntity);
    VehicleEntity getVehicleEntitiesByVehicle_id(String vehicle_id);
    void  deleteVehicleEntityByVehicle_id(String vehicle_id);*/

 List<VehicleEntity> findAll();

}
