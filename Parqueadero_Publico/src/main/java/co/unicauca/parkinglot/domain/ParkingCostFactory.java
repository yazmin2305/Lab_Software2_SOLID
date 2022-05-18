package co.unicauca.parkinglot.domain;

import java.util.EnumMap;
import java.util.Map;

public class ParkingCostFactory {
    private Map<TypeEnum, IParkingCost> dictionary;
    private static ParkingCostFactory instance;
    
    public ParkingCostFactory() {
        dictionary = new EnumMap<>(TypeEnum.class);
        dictionary.put(TypeEnum.CARRO, new CarParkingCost());
        dictionary.put(TypeEnum.MOTO, new MotoParkingCost());
        dictionary.put(TypeEnum.CAMION, new TruckParkingCost()); 
    }
    
    public static ParkingCostFactory getInstance() {
        if (instance == null) {
            instance = new ParkingCostFactory();
        }
        return instance;
    }
    
    public IParkingCost getParkingCost(TypeEnum vehiculo) {
        IParkingCost result = null;
        if (dictionary.containsKey(vehiculo)) {
            result = dictionary.get(vehiculo);
        }
        return result;
    }
}
