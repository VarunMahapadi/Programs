import java.util.Scanner;

public class CoPrimeCounter {

	public static void main(String args[]) throws Exception{
		
		Scanner scan = new Scanner(System.in);
		int arraySize = scan.nextInt();
		int[] input = new int[arraySize];
		for(int i =0 ; i < input.length ; i++) {
	        if (scan.hasNextLine()){
	        	input[i] = scan.nextInt();
	        }
		}

		//int input[] = {1,3};
		int output[] = coprimeCount(input);
		for(int i = 0; i < output.length; i++){
			System.out.println(output[i]);
		}
	}
	
	public static int[] coprimeCount(int[] input){
		
		int count;
		int countArray[] = new int[input.length];
		for(int i = 0; i < input.length; i++){
			count = 1;
			for(int j = 2; j < input[i]; j++){
				if(findGCD(j,input[i]) == 1) 
					count++;
			}
			countArray[i] = count;
		}
		
		return countArray;
	}
	
	
	private static int findGCD(int number1, int number2) { 
		if(number2 == 0){ 
			return number1; 
		} 
		return findGCD(number2, number1%number2); 
	}
}
