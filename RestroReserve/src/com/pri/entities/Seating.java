package com.pri.entities;

public class Seating {
private	int tableNo;
private	int reservationId;
private	String status;
private	int partySize;
private	String bookingTime;

public int getTableNo() {
	return tableNo;
}
public void setTableNo(int tableNo) {
	this.tableNo = tableNo;
}
public int getReservationId() {
	return reservationId;
}
public void setReservationId(int reservationId) {
	this.reservationId = reservationId;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public int getPartySize() {
	return partySize;
}
public void setPartySize(int partySize) {
	this.partySize = partySize;
}
public String getBookingTime() {
	return bookingTime;
}
public void setBookingTime(String bookingTime) {
	this.bookingTime = bookingTime;
}



}
