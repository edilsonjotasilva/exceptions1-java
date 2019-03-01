package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner in = new Scanner(System.in);
		try {
		System.out.println("Roon Number: ");
		Integer roonNumber = in.nextInt();
		System.out.println("Check-In Date");
		Date checkIn = sdf.parse(in.next());
		System.out.println("Check-Out Date");
		Date checkOut = sdf.parse(in.next());
	
		System.out.println("check-Out Date must be after check-In");
		
		Reservation reservation = new Reservation(roonNumber, checkIn, checkOut);
		System.out.println(reservation);
	
		System.out.println("Enter data to update reservation");
		System.out.println("Check-In Date(dd/MM/yyy)");
		checkIn = sdf.parse(in.next());
		System.out.println("Check-Out Date(dd/MM/yyy)");
		checkOut = sdf.parse(in.next());
		
		reservation.updateDate(checkIn, checkOut);
		}
		catch(ParseException e){
			System.out.println("Invalid date format");
		}
		catch (DomainExceptions e) {
			System.out.println("Error in Reservation: "+e.getMessage());
		}
//		catch (RuntimeException e) {
//			System.out.println("Unexpected Error ");
//		}
		
		in.close();
	
	}
}
