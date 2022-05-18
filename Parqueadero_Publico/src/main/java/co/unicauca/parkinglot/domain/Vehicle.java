
package co.unicauca.parkinglot.domain;

public class Vehicle {
    private String placa;
    private TypeEnum tipoVehiculo;

    public Vehicle(String placa, TypeEnum tipoVehiculo) {
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
    }

    public Vehicle() {
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public TypeEnum getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TypeEnum tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString(){
        return "Vehicle [plate=" + placa + ", type=" + tipoVehiculo + "]";
    }
       
}
