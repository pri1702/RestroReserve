package com.pri.rest.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pri.dao.ReservationsDAO;
import com.pri.entities.Reservations;
import com.pri.exception.AppException;
import com.pri.resp.AppResponse;

@Path("/reservations")
public class ReservationService {

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse getAll() 
	{
		AppResponse response = new AppResponse();
		ReservationsDAO dao = new ReservationsDAO();
		List<Reservations> reservationList=null;
		try {
			reservationList = dao.getAll();
			response.setPayLoad(reservationList);
			
			
		} catch (AppException e) {
			e.printStackTrace();
			response.setStatus(AppResponse.ERROR);
			response.setMessage(e.getMessage());
		}
		return response;
		//return reservationList;
	}

	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse getGetPerson(@PathParam("id") int reservationId)
	{
		AppResponse response = new AppResponse();
		ReservationsDAO dao = new ReservationsDAO();
		Reservations reservation;
		try {
			reservation= dao.getReservation(reservationId);
			response.setPayLoad(reservation);
			
			
		} catch (AppException e) {
			e.printStackTrace();
			response.setStatus(AppResponse.ERROR);
			response.setMessage(e.getMessage());
		}
		return response;
	}

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse addReservation(Reservations reservation){
		return null;
	}

	@POST
	@Path("/edit")
	public void editPerson(){
		
	}

	@DELETE
	@Path("/delete")
	public void deletePerson(){
		
	}

	
}
