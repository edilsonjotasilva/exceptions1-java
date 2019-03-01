package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainExceptions;

public class Reservation {
	private Date checkIn;
	private Date checkOut;
	private Integer roomNumber;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Scanner in = new Scanner(System.in);
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		if(!checkOut.after(checkIn)) {
			throw new DomainExceptions("CheckOut date must be after CheckIn date");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;

	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public long duration() {
		long difference = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);

	}

	public void updateDate(Date chekIn, Date checkOut)  {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainExceptions("the dates cant be before today");
		}
		if (!checkOut.after(checkIn)) {
			throw new DomainExceptions( "check-Out Date must be after check-In");
		} 
			this.checkIn = chekIn;
			this.checkOut = checkOut;
			
		
	}

	@Override
	public String toString() {
		return "RESERVATION: " + "\nRoon Number:" + roomNumber + ", Check-IN " + sdf.format(checkIn) + ", Check-Out "
				+ sdf.format(checkOut) + ", Duration: " + duration() + " Nights";
	}
	
}
