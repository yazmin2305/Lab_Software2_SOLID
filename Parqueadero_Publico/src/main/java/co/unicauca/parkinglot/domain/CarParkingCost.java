package co.unicauca.parkinglot.domain;

import java.time.Duration;
import java.time.LocalDateTime;

public class CarParkingCost implements IParkingCost{

    @Override
    public long calcularCosto(Vehicle vehiculo, LocalDateTime input, LocalDateTime output) {
        long costo;
        Duration durEstadia = Duration.between(input, output);
        
        if (durEstadia.toHours() < 1){
            return 2000;
        } else {
            durEstadia = durEstadia.minus(Duration.ofHours(1));
            //System.out.println("Estadia: "+(durEstadia.toMinutes()*2000)/60);
            costo = Math.round((((durEstadia.toMinutes()*2000)/60)/100)+1)*100;
            System.out.println("Costo: "+costo);
            costo = costo + 4000;
            return costo;
        }       
    }    
}
