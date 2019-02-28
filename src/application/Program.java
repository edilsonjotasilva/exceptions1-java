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
		if (!checkOut.after(checkIn)) {
			System.out.println("check-Out Date must be after check-In");
		} else {
			Reservation reservation = new Reservation(roonNumber, checkIn, checkOut);
			System.out.println(reservation);

			System.out.println("Enter data to update reservation");
			System.out.println("Check-In Date(dd/MM/yyy)");
			checkIn = sdf.parse(in.next());
			System.out.println("Check-Out Date(dd/MM/yyy)");
			checkOut = sdf.parse(in.next());
			
			String error = reservation.updateDate(checkIn, checkOut);
			if(error != null) {
				System.out.println("Error: "+error);
			}else {
			System.out.println(reservation);
			}
		}
		in.close();
	}

}
