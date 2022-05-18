package co.unicauca.parkinglot.access;

public class RepositoryFactory {
    private static RepositoryFactory instance;

    public RepositoryFactory() {
    }
    
    public RepositoryFactory(RepositoryFactory instance) {
        this.instance = instance;
    }

    public static RepositoryFactory getInstance() {
        if (instance == null) {
            instance = new RepositoryFactory();
        }
        return instance;
    }
    
    public IVehicleRepository getRepository(String type) {
        IVehicleRepository result = null;
        switch (type) {
            case "default":
                result = new VehicleRepository();
                break;
        }
        return result;
    }
}
