package com.pri.dao;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

	import com.pri.entities.Seating;
	import com.pri.exception.AppException;
	import com.pri.utils.DBConnector;

	public class SeatingDAO {

		public List<Seating> getAll() throws AppException {
			
			List<Seating> seatingList = new ArrayList<Seating>();
			
			Connection conn = DBConnector.connect();
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = conn.prepareStatement("SELECT * FROM seating");
				
				rs = ps.executeQuery();
				
				while(rs.next())
				{
					Seating Seating = new Seating();
					Seating.setTableNo(rs.getInt("table_no"));
					Seating.setReservationId(rs.getInt("rsrv_id"));
					Seating.setStatus(rs.getString("status"));
					Seating.setPartySize(rs.getInt("party_size"));
					Seating.setBookingTime(rs.getString("booking_time"));
			
					seatingList.add(Seating);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new AppException(e.getMessage());
			}
			finally {
				DBConnector.closeResources(ps, rs, conn);
			}
			
			return seatingList;
		}
		
		
		public Seating getSeating(int SeatingId) throws AppException {
			
			Seating Seating = new Seating();
			
			Connection conn = DBConnector.connect();
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = conn.prepareStatement("SELECT * FROM seating where ID=?");
				ps.setInt(1, SeatingId);
				
				rs = ps.executeQuery();
				
				if(rs.next())
				{
					Seating.setTableNo(rs.getInt("table_no"));
					Seating.setReservationId(rs.getInt("rsrv_id"));
					Seating.setStatus(rs.getString("status"));
					Seating.setPartySize(rs.getInt("party_size"));
					Seating.setBookingTime(rs.getString("booking_time"));
						
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new AppException(e.getMessage());
			}
			finally {
				DBConnector.closeResources(ps, rs, conn);
			}
			
			return Seating;
		}
		
		
		public Seating addSeating(Seating Seating) throws AppException {
			
			Connection conn = DBConnector.connect();
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = conn.prepareStatement("INSERT INTO seating (table_no,rsrv_id,status,party_size,booking_time) VALUES (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setInt(1, Seating.getTableNo());
				ps.setInt(2, Seating.getReservationId());
				ps.setString(2, Seating.getStatus());
				ps.setInt(2, Seating.getPartySize());
				ps.setString(2, Seating.getBookingTime());
			
				ps.executeUpdate();
				
				rs = ps.getGeneratedKeys();
				
				if(rs.next())
				{
					Seating.setTableNo(rs.getInt(1));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new AppException(e.getMessage());
			}
			finally {
				DBConnector.closeResources(ps, rs, conn);
			}
			
			return Seating;
		}
	}
