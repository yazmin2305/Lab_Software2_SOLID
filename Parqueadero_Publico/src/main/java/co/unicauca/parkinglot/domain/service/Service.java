
package co.unicauca.parkinglot.domain.service;

import co.unicauca.parkinglot.access.IVehicleRepository;
import co.unicauca.parkinglot.domain.IParkingCost;
import co.unicauca.parkinglot.domain.ParkingCostFactory;
import co.unicauca.parkinglot.domain.TypeEnum;
import co.unicauca.parkinglot.domain.Vehicle;
import java.time.LocalDateTime;
import java.util.List;

public class Service {
    private IVehicleRepository repository;
    
    public Service(IVehicleRepository repositorio) {
        this.repository = repositorio;
    }
    public long calculateParkingCost(Vehicle objVehiculo, LocalDateTime input, LocalDateTime output){
        IParkingCost parking = ParkingCostFactory.getInstance().getParkingCost(objVehiculo.getTipoVehiculo());
        return parking.calcularCosto(objVehiculo, input, output);
    }
    
    public boolean saveVehicle(Vehicle objVehiculo) {
        List<Vehicle> listaVehiculos;
        
        if(objVehiculo == null || objVehiculo.getPlaca().isBlank() || objVehiculo.getTipoVehiculo().toString().isBlank()){
            return false;
        }    
        repository.save(objVehiculo);
        return true;
    }
    
    public List<Vehicle> listVehicles() {
        List<Vehicle> lstVehiculos = repository.list();
        return lstVehiculos;
    }
}
