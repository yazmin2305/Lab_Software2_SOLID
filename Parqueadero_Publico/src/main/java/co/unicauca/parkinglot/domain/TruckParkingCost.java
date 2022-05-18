package co.unicauca.parkinglot.domain;

import java.time.Duration;
import java.time.LocalDateTime;

public class TruckParkingCost implements IParkingCost{

    @Override
    public long calcularCosto(Vehicle vehiculo, LocalDateTime input, LocalDateTime output) {
        long costo;
        Duration durEstadia = Duration.between(input, input);
        
        if(durEstadia.toHours() <= 12){
            return 10000;
        }else if(durEstadia.toHours() > 12 && durEstadia.toHours() <= 24){
            return 15000;
        }else{
            durEstadia = durEstadia.minus(Duration.ofHours(24));
            costo = ((Math.round((durEstadia.toMinutes()*15000)/1440)));
            costo = costo + 15000;
            return costo;
        }
    }
    
     
}
