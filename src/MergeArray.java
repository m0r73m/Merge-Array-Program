import java.io.*;
import java.util.*;

public class MergeArray {

	private int[] array;
	private int arrayLength;
	
	public MergeArray() {
		
	}
	
	public void setArrayValue(int index, int value) {
		array[index] = value;
	}
	
	public void fillArray() throws IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Input the numbers to put in the array with spaces in between. No more then 15 numbers");
		System.out.print(">  ");
		String inputStr = input.readLine();
		
		StringTokenizer st = new StringTokenizer(inputStr);
		
		while(st.countTokens() > 15) {
			System.out.println("Input the numbers to put in the array with spaces in between. No more then 15 numbers");
			System.out.print(">  ");
			inputStr = input.readLine();
			
			st = new StringTokenizer(inputStr);
		}
		
		int index = 0;
		
		array = new int[st.countTokens()];
		arrayLength = st.countTokens();
		
		while(st.hasMoreTokens()) {
			array[index] = Integer.parseInt(st.nextToken());
			index++;
		}
		
	}
	
	public int[] getArray() {
		return array;
	}
	
	public int getArrayLength() {
		return arrayLength;
	}
	
	public int getArrayInt(int index) {
		return array[index];
	}
	
	public String toString() {
		
		String output = "[";
		int index = 0;
		
		removeDouble();
		
		while(index < arrayLength-1) {
			output += array[index] + ", ";
			index++;
		}

		output += array[index] + "]";
		return output;
		
	}
	
	private void removeDouble() {
		
		sortArray();
		
		for(int i = 0; i < arrayLength - 1; i++) {
			
			if(array[i] == array[i+1]) {
				for(int j = i + 1; j < arrayLength-1; j++) {
					array[j] = array[j+1];
				}
				array[array.length-1] = 0;
				
				arrayLength--;
			
				i--;
				
				sortArray();
				
			}
			
			
		}
		
	}
	
	private void sortArray() {
		
		for(int i = 0; i < arrayLength - 1; i++) {
			
			int minIndex = i;
			for(int j = i + 1; j < arrayLength; j++) {
				
				if(array[j] < array[minIndex]) {
					minIndex = j;
				}
				
			}
			
			int temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;

		}
		
	}
	
	public void mergeArrays(MergeArray array1, MergeArray array2) {
		
		int arrayOneTwoLength = array1.getArrayLength() + array2.getArrayLength();
		
		array = new int[arrayOneTwoLength];
		
		arrayLength = arrayOneTwoLength;
		
		for(int i = 0; i < array1.getArrayLength(); i++) {
			
			array[i] = array1.getArrayInt(i);
			
		}
		
		for(int i = 0; i < array2.getArrayLength(); i++) {
			
			array[i+array1.getArrayLength()] = array2.getArrayInt(i);
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		MergeArray array1 = new MergeArray();
		
		array1.fillArray();
		
		System.out.println(array1);
		
		MergeArray array2 = new MergeArray();
		
		array2.fillArray();
		
		System.out.println(array2);
		
		MergeArray array3 = new MergeArray();
		
		array3.mergeArrays(array1, array2);
		
		System.out.println("\nFinal Result - ");
		
		System.out.println(array3);
		
	}
	
}
