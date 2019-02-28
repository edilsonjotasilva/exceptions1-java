package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner in = new Scanner(System.in);
		System.out.println("Roon Number: ");
		Integer roonNumber = in.nextInt();
		System.out.println("Check-In Date");
		Date checkIn = sdf.parse(in.next());
		System.out.println("Check-Out Date");
		Date checkOut = sdf.parse(in.next());
		if (checkIn.after(checkOut)) {
			System.out.println("check-Out Date must be after check-In");
		} else {
			Reservation reservation = new Reservation(roonNumber, checkIn, checkOut);
			System.out.println(reservation);
		}
		System.out.println("Enter data to update reservation");
		System.out.println("Check-In Date");
		checkIn = sdf.parse(in.next());
		System.out.println("Check-Out Date");
		checkOut = sdf.parse(in.next());
		Date now = new Date();
		if(checkIn.before(now)|| checkOut.before(now)) {
			System.out.println("the dates cant be before today");
		}else if(checkIn.after(checkOut)) {
			System.out.println("check-Out Date must be after check-In");
		}else {
			Reservation reservation = new Reservation(roonNumber, checkIn, checkOut);
			System.out.println(reservation);
		}
		in.close();
	}

}
