package App.BusResv;

import java.util.Scanner;
import java.sql.SQLException;

public class BusDemo {

	public static void main(String[] args)  {
		BusDAO busdao = new BusDAO();
		try {
			busdao.displayBusInfo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		int userOpt = 1;
		Scanner scanner = new Scanner(System.in);
		
		while(userOpt==1) {
			System.out.println("Enter 1 to Book and 2 to exit");
			userOpt = scanner.nextInt();
			if(userOpt == 1) {
				Booking booking = new Booking();
				try {
					if(booking.isAvailable()) {
						BookingDAO bookingdao = new BookingDAO();
						bookingdao.addBooking(booking);
						System.out.println("Your booking is confirmed");
					}
					else
						System.out.println("Sorry. Bus is full. Try another bus or date.");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		scanner.close();
	}

}
