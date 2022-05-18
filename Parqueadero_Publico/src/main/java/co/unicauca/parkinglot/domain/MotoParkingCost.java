package co.unicauca.parkinglot.domain;

import java.time.Duration;
import java.time.LocalDateTime;

public class MotoParkingCost implements IParkingCost{

    @Override
    public long calcularCosto(Vehicle vehiculo, LocalDateTime input, LocalDateTime output) {
        long costo;
        Duration durEstadia = Duration.between(input, output);
        
        if (durEstadia.toHours() < 1){
            return 1000;
        } else {
            durEstadia = durEstadia.minus(Duration.ofHours(1));
            costo = (Math.round((durEstadia.toMinutes()*1000)/60)/100)*100;
            costo = costo + 2000;
            return costo;
        }    
    }    
}
