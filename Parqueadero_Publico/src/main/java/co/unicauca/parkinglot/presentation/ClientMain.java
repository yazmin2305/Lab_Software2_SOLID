/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.presentation;

import co.unicauca.parkinglot.access.IVehicleRepository;
import co.unicauca.parkinglot.access.RepositoryFactory;
import co.unicauca.parkinglot.domain.TypeEnum;
import co.unicauca.parkinglot.domain.Vehicle;
import co.unicauca.parkinglot.domain.service.Service;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class ClientMain {
    public static void main(String[] args) {
        /*Vehicle veh = new Vehicle("FTK-123", TypeEnum.MOTO);
        LocalDateTime input = LocalDateTime.of(2022, Month.FEBRUARY, 22, 8, 0);
        LocalDateTime output = LocalDateTime.of(2022, Month.FEBRUARY, 22, 19, 30);
        IVehicleRepository repo = RepositoryFactory.getInstance().getRepository("default");
        System.out.println("repoo-. " + repo);
        Service service = new Service(repo);
        long result = service.calculateParkingCost(veh, input, output);
        System.out.println("Valor a pagar por la moto: " + result);
        service.saveVehicle(veh);
        veh = new Vehicle("JNK-124", TypeEnum.CARRO);
        service.saveVehicle(veh);
        List<Vehicle> list = service.listVehicles();
        list.forEach(vehicle -> {
            System.out.println(vehicle.toString());}); */  
        
        
        
        System.out.println("Carro 2 horas y 10 minutos");
        Vehicle veh = new Vehicle("FTK-123", TypeEnum.CARRO);
        LocalDateTime input = LocalDateTime.of(2021, Month.FEBRUARY, 22, 8, 0);
        LocalDateTime output = LocalDateTime.of(2021, Month.FEBRUARY, 22, 10, 10);
        IVehicleRepository repo = RepositoryFactory.getInstance().getRepository("default");
        Service service = new Service(repo);
        long expResult = 6400L;
        long result = service.calculateParkingCost(veh, input, output);
        System.out.println("Valor a pagar por el carro: " + result);
        /*Vehicle veh = new Vehicle("FTK-123", TypeEnum.MOTO);
        IVehicleRepository repo = RepositoryFactory.getInstance().getRepository("default");
        Service service = new Service(repo);
        System.out.println("Moto 3 horas y 45 minutos");
        LocalDateTime input = LocalDateTime.of(2021, Month.FEBRUARY, 22, 8, 0);
        LocalDateTime output = LocalDateTime.of(2021, Month.FEBRUARY, 22, 11, 45);
        //expResult = 4800L;
        long result = service.calculateParkingCost(veh, input, output);
        System.out.println("Valor a pagar por el moto: " + result);*/
    }  
        
}
