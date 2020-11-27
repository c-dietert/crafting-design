package XYZ.infrastructure;

import XYZ.model.vehicle.Vehicle;
import XYZ.model.vehicle.VehicleRepository;

import java.util.List;

public class DefaultVehilceRepository implements VehicleRepository {

    @Override
    public List<Vehicle> findAllEmpty() {
        return null;
    }
}
