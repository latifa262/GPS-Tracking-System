package test;

import java.sql.SQLException;
import java.sql.Statement;

import connexion.Connexion;

public class Test {

	public static void main(String[] args) {
	 try {
			String createTableGPSTracker = "create table GPSTracker ("
					+ "id int primary key auto_increment,"
					+ "simNumber varchar(20));";
			String createTablePosition = "create table Position ("
					+ "id int primary key auto_increment,"
					+ "latitude double,"
					+ "longitude double,"
					+ "date date, "
					+ "idTracker int);";
			
			String createTableVehicule = "create table Vehicule (" 
					+ "id int primary key auto_increment,"
					+ "matricule varchar(30),"
					+ "marque varchar(30),"
					+ "type varchar(30));";
			
			String createTableVehiculeGPSTracker ="create table VehiculeGPSTracker ("
					+ "id int primary key auto_increment,"
					+ "datedebut Date,"
					+ "datefin Date,"
					+ "idVehicule int,"
					+ "idTracker int);";
			String createTablecompte = "create table comptes ("
					+ "id int primary key auto_increment,"
                                        + "nom varchar(20),"
					+ "motdepasse varchar(20));";
                        
                        String fk = "alter table position add "
					+ "constraint fk foreign key (idTracker) "
					+ "references GPSTracker(id)"
					+ "ON DELETE CASCADE ON UPDATE CASCADE";
                        
			String fk1 = "alter table VehiculeGPSTracker add constraint fk1 "
			        + "foreign key (idTracker)"
					+ "references GPSTracker(id) "
			        + "ON DELETE CASCADE ON UPDATE CASCADE;";
			
			String fk2 ="alter table VehiculeGPSTracker add constraint fk2 "
					+ "foreign key (idVehicule)"
					+"references Vehicule(id) "
					+"ON DELETE CASCADE ON UPDATE CASCADE";
			
			
			Statement st = Connexion.getConnection().createStatement();
			st.execute("SET FOREIGN_KEY_CHECKS = 0");
			st.execute("drop table if exists GPSTracker");
			st.execute("drop table if exists Position");
			st.execute("drop table if exists Vehicule");
			st.execute("drop table if exists VehiculeGPSTracker");
                        st.execute("drop table if exists comptes");
			st.execute("SET FOREIGN_KEY_CHECKS = 1");
			st.executeUpdate(createTableGPSTracker); 
			st.executeUpdate(createTablePosition);
			st.executeUpdate(createTableVehicule);
			st.executeUpdate(fk);
			st.executeUpdate(createTableVehiculeGPSTracker);
			st.executeUpdate(fk1);
			st.executeUpdate(fk2); 
			st.executeUpdate(createTablecompte);
		} catch (SQLException e) {
			e.printStackTrace();
		}

    }

}
