package service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import connexion.Connexion;
import dao.IDao;
import java.util.LinkedHashSet;
import entities.GPSTracker;
import entities.Vehicule;
import entities.VehiculeGPSTracker;

public class VehiculeGPSTrackerService implements IDao<VehiculeGPSTracker> {
	private GPSTrackerService ts = new GPSTrackerService();
	private VehiculeService vs = new VehiculeService();

	@Override
	public boolean create(VehiculeGPSTracker o) {
		try {
			String req = "insert into VehiculeGPSTracker values (null, ?,null,?,?)";
			PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
			pr.setDate(1, new Date(o.getDateDebut().getTime()));
			//pr.setDate(2, new Date(o.getDateFin().getTime()));
                        //changedatefin(o);
                        pr.setInt(2, o.getGpsTracker().getId());
                        pr.setInt(3, o.getVehicule().getId());
			if (pr.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			System.out.println("Create : Erreur");
		}
		return false;
	}

	@Override
	public boolean delete(VehiculeGPSTracker o) {
		try {
			String req = "delete from  VehiculeGPSTracker where id  = ?";
			PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
			pr.setInt(1, o.getId());
			if (pr.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(VehiculeGPSTracker o) {
		try {
			String req = "update VehiculeGPSTracker set datedebut = ? ,datefin = ? , idTracker = ? ,idVehicule = ? where id = ?";
			PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
			pr.setDate(1, new Date(o.getDateDebut().getTime()));
			pr.setDate(2, new Date(o.getDateFin().getTime()));
			pr.setInt(3, o.getGpsTracker().getId());
			pr.setInt(4, o.getVehicule().getId());
			pr.setInt(5, o.getId());
			if (pr.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			System.out.println("Create : Erreur");
		}
		return false;
	}

	@Override
	public VehiculeGPSTracker findById(int id) {
		try {
			String req = "select * from VehiculeGPSTracker where id  = ?";
			PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
			pr.setInt(1, id);
			ResultSet rs = pr.executeQuery();
			if (rs.next()) {
				return new VehiculeGPSTracker(rs.getInt("id"), rs.getDate("datedebut"), rs.getDate("datefin"),
						ts.findById(rs.getInt("idTracker")), vs.findById(rs.getInt("idVehicule")));
			}

		} catch (SQLException e) {
			System.out.println("vehiculegpsTracker : FindById");
		}

		return null;
	}

	@Override
	public List<VehiculeGPSTracker> findAll() {
		List<VehiculeGPSTracker> vehiculegpstrackers = new ArrayList<VehiculeGPSTracker>();
		try {
			String req = "select * from VehiculeGPSTracker";
			PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
			ResultSet rs = pr.executeQuery();
			while (rs.next())
				vehiculegpstrackers.add(new VehiculeGPSTracker(rs.getInt("id"), rs.getDate("datedebut"), rs.getDate("datefin"),
						ts.findById(rs.getInt("idTracker")), vs.findById(rs.getInt("idVehicule"))));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehiculegpstrackers;
	}
	
	public List<Vehicule>findGPSTrackersBetweenDates (Vehicule vehicule, java.util.Date dateDebut, java.util.Date dateFin) {
		List<Vehicule> vs=new ArrayList<Vehicule>();
		for (VehiculeGPSTracker v : findAll()) {

			if (v.getDateDebut().after(dateDebut) && v.getDateFin().before(dateFin) && v.getId()==vehicule.getId()) {
				vs.add(v.getVehicule());

			}
			return vs;
		}
		return null;

	}
        
}
