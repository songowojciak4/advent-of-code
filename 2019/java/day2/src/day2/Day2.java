package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2 {
	List<Integer> input = new ArrayList<Integer>();
	List<Integer> finalAnswer = new ArrayList<Integer>(); 
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Day2 day2 = new Day2();
		day2.input = day2.readInput("input-orig.txt");
		day2.finalAnswer = day2.readInput("input-orig.txt");

		int pos1=0;
		int pos2=0;
		for(int k=0; k<100;k++){
			for(int l=0; l<100;l++){
				day2.input.set(1, k);

				day2.input.set(2, l);
				for(int i=0; i<day2.input.size(); i=i+4){
					if(i>=day2.input.size()||day2.input.get(i)==99){
						break;
					}
					List<Integer> sequence = new ArrayList<Integer>();
					for(int j=0; j<5;j++){
						sequence.add(day2.input.get(i+j));
					}

					int resultCode = day2.carryOutOpcode(sequence);
					if(resultCode==-1){
						break;
					}			
				}

				if (day2.finalAnswer.get(0)==19690720){
					pos1 = day2.input.get(1);
					pos2 = day2.input.get(2);
					break;
				}

				day2.input = day2.readInput("input-orig.txt");
				day2.finalAnswer = day2.input;


			}
			if (day2.finalAnswer.get(0)==19690720){
				pos1 = day2.input.get(1);
				pos2 = day2.input.get(2);
				System.out.println(day2.finalAnswer.get(0));
				System.out.println(day2.finalAnswer.get(1));
				System.out.println(day2.finalAnswer.get(2));
				System.out.println(day2.finalAnswer);
				break;
			}

		}	
	}

	public List<Integer> readInput(String filename) throws FileNotFoundException{
		List<Integer> inputSequences = new ArrayList<Integer>();
		Scanner sc = new Scanner(new File("..\\day2\\inputs\\" + filename)).useDelimiter(",");
		while(sc.hasNextInt()){
			inputSequences.add(sc.nextInt());
		}
		sc.close();
		return inputSequences;
	}

	public int carryOutOpcode(List<Integer> sequence){
		if(sequence.get(0)!=1 && sequence.get(0)!=2){
			return -1;
		}
		if(sequence.get(0)==1){
			//add
			finalAnswer.set(sequence.get(3),input.get(sequence.get(1))+
					input.get(sequence.get(2)));

		}
		else if(sequence.get(0)==2){
			//multiply
			finalAnswer.set(sequence.get(3),input.get(sequence.get(1))*
					input.get(sequence.get(2)));
		}
		if(sequence.get(4)==99){
			return 0;
		}

		return 1;
	}
}
