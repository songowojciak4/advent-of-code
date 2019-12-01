package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Day1 day1 = new Day1();
		List<Integer> masses = day1.readInput("example-input.txt");
		List<Integer> fuels = new ArrayList<Integer>();
		for(int mass:masses){
			fuels.add(day1.calculateFuel(mass));
		}
		System.out.println(fuels.toString());
		System.out.println(day1.calculateTotalFuel(fuels));
		
		List <Integer> updatedFuels = new ArrayList<Integer>();
		
		for(int fuel:fuels){
			updatedFuels.add(day1.calculateExtraFuel(fuel));
		}
		
		System.out.println(updatedFuels.toString());
		System.out.println(day1.calculateTotalFuel(updatedFuels));
		
		System.out.println("answer:");
		masses = day1.readInput("input.txt");
		fuels = new ArrayList<Integer>();
		for(int mass:masses){
			fuels.add(day1.calculateFuel(mass));
		}
		System.out.println(fuels.toString());
		System.out.println(day1.calculateTotalFuel(fuels));
		
		updatedFuels = new ArrayList<Integer>();
		
		for(int fuel:fuels){
			updatedFuels.add(day1.calculateExtraFuel(fuel));
		}
		
		System.out.println(updatedFuels.toString());
		System.out.println(day1.calculateTotalFuel(updatedFuels));
		
		
		
	}

	public List<Integer> readInput(String filename) throws FileNotFoundException{
		List<Integer> inputMass = new ArrayList<Integer>();
		Scanner sc = new Scanner(new File("..\\day1\\inputs\\" + filename));
		while(sc.hasNextInt()){
			inputMass.add(sc.nextInt());
		}
		sc.close();
		return inputMass;
	}
	
	public int calculateFuel(int mass){
		//need to calculate 
		return (mass/3)-2;
	}
	
	public int calculateTotalFuel(List<Integer> fuels){
		int maxFuelNeeded = 0;
		for (int fuel:fuels){
			maxFuelNeeded+=fuel;
		}
		return maxFuelNeeded;
	}
	int totalFuelForThisModule = 0;
	public int calculateExtraFuel(int fuel){
		
		if(fuel>0){
		//	System.out.println(totalFuelForThisModule);
		//	System.out.println(fuel);
			totalFuelForThisModule += fuel;
			return calculateExtraFuel(calculateFuel(fuel));
		} 
		int total = totalFuelForThisModule;
		totalFuelForThisModule = 0;
		return total;
	}
}
