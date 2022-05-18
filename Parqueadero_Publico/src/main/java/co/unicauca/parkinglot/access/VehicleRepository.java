package co.unicauca.parkinglot.access;

import co.unicauca.parkinglot.domain.TypeEnum;
import co.unicauca.parkinglot.domain.Vehicle;
import co.unicauca.parkinglot.domain.service.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VehicleRepository implements IVehicleRepository{
    
    private Connection conn;
    
    public VehicleRepository(){
        initDatabase();
    }

    @Override
    public boolean save(Vehicle objVehiculo) {
        try{
            if(objVehiculo == null || objVehiculo.getPlaca().isBlank() || objVehiculo.getTipoVehiculo().toString().isBlank()){
                return false;
            }
            String sql = "INSERT INTO Vehiculo(Placa, Tipo) VALUES (?,?)";
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, objVehiculo.getPlaca());
            pstmt.setString(2, objVehiculo.getTipoVehiculo().toString());
            pstmt.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return false;
    }

    @Override
    public List<Vehicle> list() {
        List<Vehicle> vehiculos = new ArrayList<>();
        try {

            String sql = "SELECT Placa, Tipo FROM Vehiculo";
            //this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vehicle newVehiculo = new Vehicle();
                newVehiculo.setPlaca(rs.getString("Placa"));
                newVehiculo.setTipoVehiculo(TypeEnum.valueOf(rs.getString("Tipo")));

                vehiculos.add(newVehiculo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehiculos;
    }
    
    private void initDatabase(){
        String sql = "CREATE TABLE IF NOT EXISTS Vehiculo (\n"
                + "Placa TEXT PRIMARY KEY, \n"
                + "Tipo TEXT NOT NULL \n"
                + ");";
        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void connect() {
//        String url = "jdbc:sqlite::memory:";
        String url = "jdbc:sqlite:./mydatabase";

        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
