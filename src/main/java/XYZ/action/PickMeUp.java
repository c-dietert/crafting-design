package XYZ.action;

import XYZ.model.*;
import XYZ.model.duration.DurationServce;
import XYZ.model.route.Location;
import XYZ.model.route.RouteService;
import XYZ.model.vehicle.VehicleService;

import java.util.List;

public class PickMeUp {
    public PickMeUp(VehicleService vehicleService, RouteService routeService, DurationServce durationServce) {
    }

    public PickUpDetails execute(Location location, List<Passenger> passengers) {
        return null;
    }
}
