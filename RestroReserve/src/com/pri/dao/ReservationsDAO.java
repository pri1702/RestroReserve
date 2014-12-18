package com.pri.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pri.entities.Reservations;
import com.pri.exception.AppException;
import com.pri.utils.DBConnector;

public class ReservationsDAO {
 
		public List<Reservations> getAll() throws AppException{
			
		List<Reservations> resList = new ArrayList<Reservations>();
		
		Connection conn = DBConnector.connect();
		PreparedStatement ps = null;
		ResultSet rs= null;
		
		try{
			
			ps = conn.prepareStatement("SELECT * from reservations");
			rs = ps.executeQuery();
			
			while(rs.next()){
				Reservations reserve = new Reservations();
				reserve.setReservationId(rs.getInt("rsrv_id"));
				reserve.setName(rs.getString("name"));
				reserve.setDate(rs.getString("date"));
				reserve.setGuests(rs.getInt("no_of_guests"));
				resList.add(reserve);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
		finally{
			DBConnector.closeResources(ps, rs, conn);			
		}
		
		return resList;
		}
		

		public Reservations getReservation(int rId) throws AppException {
			
			Reservations reservation = new Reservations();
			
			Connection conn = DBConnector.connect();
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = conn.prepareStatement("SELECT * FROM reservations where rsrv_id=?");
				ps.setInt(1, rId);
				
				rs = ps.executeQuery();
				
				if(rs.next())
				{
					reservation.setReservationId(rs.getInt("rsrv_id"));
					reservation.setName(rs.getString("name"));
					reservation.setDate(rs.getString("date"));
					reservation.setGuests(rs.getInt("no_of_guests"));
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new AppException(e.getMessage());
			}
			finally {
				DBConnector.closeResources(ps, rs, conn);
			}
			
			return reservation;
		}
		
		
		public Reservations addReservations(Reservations Reservations) throws AppException {
			
			Connection conn = DBConnector.connect();
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = conn.prepareStatement("INSERT INTO reservations (name,date,no_of_guests) VALUES (?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
				//ps.setInt(1, Reservations.getReservationId());
				ps.setString(1, Reservations.getName());
				ps.setString(2, Reservations.getDate());
				ps.setInt(3, Reservations.getGuests());
				
				ps.executeUpdate();
				
				rs = ps.getGeneratedKeys();
				
				if(rs.next())
				{
					Reservations.setReservationId(rs.getInt(1));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new AppException(e.getMessage());
			}
			finally {
				DBConnector.closeResources(ps, rs, conn);
			}
			
			return Reservations;
		}
	}