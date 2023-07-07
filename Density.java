//NAME: Ria Mukherji
//SMU ID: 48877496
//LAB: Lab 3 fall 2022
//INSTRUCTOR: Dixit,Paarul Howard,Ken

import java.util.Scanner;
public class Density {

	//main method prompts the user to enter the mass and volume for 3 compounds and calls calculateDensity.
	public static void main(String[] args) {
	
        Scanner scan = new Scanner(System.in);
		double[] mass = new double[3];
		double[] volume = new double[3];
		
		System.out.println("Enter the mass and volume for your 3 compounds.");
		for (int i = 0; i < 3; i++)
		{
			System.out.print("Enter mass in grams: ");
			mass[i] = scan.nextDouble();
			System.out.print("Enter volume in milliliters: ");
			volume[i] = scan.nextDouble();
		}//end for loop
		calculateDensity(mass,volume);
	}//end main
	
	//calculate density method calculates the density using the two arrays mass and volume as parameters.
	public static void calculateDensity(double[] mass, double[] volume)
	{
		for(int j = 0; j < mass.length; j++)
			System.out.printf("The density for mass = %.2f g and volume = %.2f ml is: %.2f g/ml \n", mass[j], volume[j], mass[j]/volume[j]);
	}//end calculateDensity

}//end Density class
