package co.unicauca.parkinglot.access;

import co.unicauca.parkinglot.domain.Vehicle;
import java.util.List;

public interface IVehicleRepository {
    boolean save(Vehicle objVehiculo);
    List<Vehicle> list();
}
