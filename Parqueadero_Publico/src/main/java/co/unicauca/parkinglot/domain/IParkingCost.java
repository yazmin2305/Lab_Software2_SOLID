
package co.unicauca.parkinglot.domain;

import java.time.LocalDateTime;

public interface IParkingCost {
    public long calcularCosto(Vehicle vehiculo, LocalDateTime input, LocalDateTime output);
}
