//NAME: Ria Mukherji
//SMU ID: 48877496
//LAB: Lab 3 fall 2022
//INSTRUCTOR: Dixit,Paarul Howard,Ken

import java.util.Scanner;
public class SeatReservation {
 
	//main method responsible for interacting with user and printing seating charts.
	public static void main(String[] args) {
		//4 Arrays
		String[] rowASeats = new String[] {"1A","2A","3A"};
		String[] rowBSeats = new String [] {"1B","2B","3B"};
		double[] rowAPrices = new double[] {99.99,110.99,99.99};
		double[] rowBPrices = new double [] {75.99,85.99,75.99};
		//variable to store total
		double total = 0;
		
		display(rowASeats, rowBSeats, rowAPrices, rowBPrices);
		System.out.println("How many seats do you want to reserve?");
		Scanner scan = new Scanner(System.in);
		int numSeats = scan.nextInt();
		for (int i = 0; i<numSeats ; i++)
		{
			String row = getRow(scan);
			if (row.equalsIgnoreCase("A")){
				total += makeReservation(rowASeats,rowAPrices,"A",scan);
				
				}
			else if (row.equalsIgnoreCase("B")){
				total += makeReservation(rowBSeats,rowBPrices,"B",scan);
			}//end else if 
	    System.out.printf("Yor subtotal is: $%.2f\n", total);
	    System.out.println("----");
	    	
		}//end for
		printReceipt(numSeats,total);
	}// end main
	
	//printRecipt method prints out the final receipt using the parameters numSeats and total.
	public static void printReceipt(int numSeats, double total) {
		double fee = 14.99;
		double taxRate = .085;
		double tax;
		System.out.println("Thank you for reserving with us. Here's your receipt:\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.printf("Subtotal: $%.2f\n", total);
		System.out.printf("Fees: %d x $%.2f = $%.2f\n", numSeats, fee, numSeats*fee);
		tax = taxRate*((numSeats*fee)+ total);
		System.out.printf("Taxes: $%.2f\n", tax);
		System.out.printf("%s\n","=====================================================");
		System.out.printf("Total: $%.2f\n", tax+total);
		System.out.printf("%s\n","~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		
	}//end printRecipt
	
	//updateSeatingChart method updates the seating chart and places an X over unavailable seats using rowSeats and seatNum Parameters.
	public static void updateSeatingChart(String[] rowSeats, int 
			seatNum) {
            System.out.println("Updated row chart: ");
		rowSeats[seatNum-1]="X";
	}//end updateSeatingChart
	
	//makeReservation method asks the user which seat they want and prints and updates the seating chart using 4 parameters. It returns the price of the seat selected. 
	public  static  double  makeReservation(String[]  rowSeats,  double[] 
			prices,String row, Scanner scan) {
		System.out.printf("%s\n","===================================");
		printRowSeat(rowSeats);
		printRowPrices(prices);
		System.out.printf("%s\n","===================================");
		System.out.println("Which seat number do you want?");
		int seatNum = scan.nextInt();
		System.out.printf("The seat you selected is: %d%s\n", seatNum, row );
		System.out.printf("The price of the seat is: $%.2f\n", prices[seatNum-1]);
		updateSeatingChart(rowSeats,seatNum);
		System.out.printf("%s\n","===================================");
		printRowSeat(rowSeats);
		printRowPrices(prices);
		System.out.printf("%s\n","===================================");
		return prices[seatNum-1];
	}
	
	//getRow method gets and returns the user selected row using the scan parameter.
	public static String getRow(Scanner scan) {
		String row;
		System.out.print("Enter the row for the seat you want to reserve: (A/B)");
		row = scan.next();
		return row;
	}//end getRow
	
	//display displays the seating chart using its four parameters.
	public static void display(String[] rowASeats, String[] rowBSeats, 
			double[] rowAPrices, double[] rowBPrices) {
		System.out.printf("%s\n%s\n%s\n","Welcome to our event! Here's our seating chart with prices:","Seating Chart","===================================");
		
		printRowSeat(rowASeats);
		printRowPrices(rowAPrices);
		System.out.printf("%s\n","-----------------------------------");
		printRowSeat(rowBSeats);
		printRowPrices(rowBPrices);
		System.out.printf("%s\n","===================================");

	}//end display
	
	//printRowSeat method prints out the array containing the seats using the parameter rowSeats.
	public static void printRowSeat(String[] rowSeats) {
	
		System.out.print("|");
		for (int i = 0; i < rowSeats.length; i++)
		{
		 System.out.printf("%-11s", rowSeats[i]);
		}//end for loop
		System.out.printf("%-11s\n","|");
	}//end printRowSeat
	
	//printRowPrices method prints out the array containing the prices using the parameter rowPrices.
	public static void printRowPrices(double[] rowPrices) {
		System.out.print("|");
		for (int i = 0; i < rowPrices.length; i++)
		{
		 System.out.printf("$%-10.2f", rowPrices[i]);
		}//end for loop
		System.out.printf("%-10s\n","|");
		
	}//end printRowPrices

}//end SeatReservation class

