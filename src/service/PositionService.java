package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import connexion.Connexion;
import dao.IDao;
import entities.GPSTracker;

import entities.Position;
import entities.Vehicule;
import entities.VehiculeGPSTracker;
public class PositionService implements IDao<Position> {
	private GPSTrackerService ts = new GPSTrackerService();
        
	@Override
	public boolean create(Position o) {
		try {
			String req = "insert into Position values (null, ?,?,?,?)";
			PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
			pr.setDouble(1, o.getLatitude());
			pr.setDouble(2, o.getLongitude());
			pr.setDate(3,new Date (o.getDate().getTime()));
			pr.setInt(4,o.getGpsTracker().getId());
		
			if (pr.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			System.out.println("Create : Erreur");
		}
		return false;
	}

	@Override
	public boolean delete(Position o) {
		try {
			String req = "delete from  Position where id  = ?";
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
	public boolean update(Position o) {
		try {
			String req = "update Position set latitude = ? ,longitude = ? , date = ? ,idTracker = ? where id = ?";
			PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
			pr.setDouble(1, o.getLatitude());
			pr.setDouble(2, o.getLongitude());
			pr.setDate(3,new Date (o.getDate().getTime()));
			pr.setInt(4,o.getGpsTracker().getId());
			pr.setInt(5, o.getId());
			if (pr.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			System.out.println("Create : Erreur");
		}
		return false;
	}

	@Override
	public Position findById(int id) {
		try {
			String req = "select * from Position where id  = ?";
			PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
			pr.setInt(1, id);
			ResultSet rs = pr.executeQuery();
			if (rs.next()) {
				return new Position(rs.getInt("id"), rs.getDouble("latitude"),rs.getDouble("longitude"),rs.getDate("date"),ts.findById(rs.getInt("idTracker")));
			}

		} catch (SQLException e) {
			System.out.println("Tracker : FindById");
		}

		return null;
	}

	@Override
	public List<Position> findAll() {
		List<Position> positions = new ArrayList<Position>();
		try {
			String req = "select * from Position";
			PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
			ResultSet rs = pr.executeQuery();
			while (rs.next())
				positions.add(new Position(rs.getInt("id"), rs.getDouble("latitude"), rs.getDouble("longitude"),
						rs.getDate("date"), ts.findById(rs.getInt("idTracker"))));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return positions;
	}
        public List <Position> findPositionsBetweenDates (GPSTracker tracker, java.util.Date dateDebut, java.util.Date dateFin){
		List<Position> ps = new ArrayList<Position>();
		for (Position p : findAll()) {
			
				if (p.getDate().after(dateDebut) && p.getDate().before(dateFin) && p.getGpsTracker().getId() == tracker.getId() ) {
					ps.add(p);
				}
			}

		return ps;
	}

  
}
