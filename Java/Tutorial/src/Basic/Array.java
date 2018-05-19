package Basic;

import java.util.Arrays;

import javax.sound.midi.Synthesizer;

public class Array {

	public static void main(String[] args) {
		//Declare an array; arr is the reference or pointer of the array.
		System.out.println("Array:");
		int[] arr;
		arr = new int[2];//Allocate memory without assignment
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);//All the elements in the array have default value 0;
		arr[0] = 1;
		arr[1] = 2;
		//arr[2] = 3; Exception IndexOutOfBounds
		int n = arr.length;
		System.out.println(n + "\nFor Each");
		
		//Allocate and Assignment simultaneously
		int[] a = new int[] {3,5,53,123,4,23,123};
		int[] b = {1,2,3,4};
		//int[] c = new int[5] {1,2,3,4,5}; Cannot Assign and set the length at the time;
		
		//Reinforcement For loop without index
		for (int i : a) {
			System.out.print(i + " ");//Can only read the value not write
			i = 10;//Not change the value in a
		}
		System.out.println();
		for (int i : a) {
			System.out.print(i + " ");//Can only read the value not write
		}
		System.out.println("\nArrayCopy with System.arraycopy()");
		
		//Array Copy
		int[] copyArr = new int[4];
		System.arraycopy(a, 1, copyArr, 2, 2);
		for (int i : copyArr) {
			System.out.print(i + " ");
		}
		System.out.println("\nArrayCopy with arr.clone");
		int[] cloneArr = a.clone();
		for (int i : cloneArr) {
			System.out.print(i + " ");
		}
		System.out.println('\n');
		
		//Two Dimension Array
		//Initialization
		int[][] a2 = new int[1][2];
		a2[0][1] = 3;
		int[][] b2 = new int[][] {{1,2,3},{2}};//Each dimesion has different length;
		System.out.println("Lengths in each sub array");
		for (int i = 0; i < b2.length; i++)
			System.out.print(b2[i].length + " ");
		int[][] c2 = {{1,2,3},{2,3}};
		int[][] d2 = new int[3][];
		d2[1] = new int[2];
		d2[2] = new int[3]; 
		System.out.println('\n');
		
		//Arrays
		//copyOfRange()
		System.out.println("Arrays.copyOfRange()");
		int[] arrCopy = Arrays.copyOfRange(a, 1, 8);//The last index 8 will not be included
		//Arrays.copyOfRange(a, 1, 1) will be empty. If last index is out of bound of a, it
		// will pad 0 to the target array.
		for (int i : arrCopy) {
			System.out.print(i + " ");
		}
		System.out.println();
		//toString()
		System.out.println("Arrays.toString()");
		System.out.println(Arrays.toString(arrCopy));
		//sort();
		System.out.println("Arrays.sort()");
		Arrays.sort(arrCopy);
		System.out.println(Arrays.toString(arrCopy));
		//binarySearch
		System.out.println("Arrays.binarySearch()");
		System.out.println(Arrays.binarySearch(arrCopy, 123));//smallest index of the value
		System.out.println(Arrays.binarySearch(arrCopy, 3));//Not found if index < 0
		//equals() judge if two arrays contains the same value
		System.out.println("Arrays.equals()");
		System.out.println(Arrays.equals(arrCopy, a));
		System.out.println(Arrays.equals(cloneArr, a));
		//fill()
		System.out.println("Arrays.fill()");
		Arrays.fill(arrCopy, -1);
		System.out.println(Arrays.toString(arrCopy));
		System.out.println('\n');
		
		//Practice
		System.out.println("Practice:");
		System.out.println("Find Min:");
		findMin();
		System.out.println("Reverse Array");
		reverseArray();
		System.out.println("Select Sort in ascending order");
		selectSort();
		System.out.println("Bubble Sort in descending order");
		bubbleSort();
		System.out.println("Find Max:");
		findMaxWithForEach();
		System.out.println("Merge two arrays");
		mergeArray();
		System.out.println("Find max in 2D array");
		findMaxIn2DArray();
		System.out.println("2D Array Sort");
		array2DSort();
	}
	
	//Prcatice 
	public static void findMin() {
		int[] arr = new int[5];
		for (int i = 0; i < 5; i++) {
			arr[i] = (int)(Math.random() * 99 + 1);
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		System.out.println(min + "\n");	
	}
	
	public static void reverseArray() {
		int[] arr = new int[5];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 99 + 1);
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < arr.length/2; i++) {
			arr[i] ^= arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] ^= arr[i];
			arr[i] ^=  arr[arr.length - 1 - i];
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println('\n');
	}
	
	public static void selectSort() {
		int[] arr = new int[5];
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			arr[i] = (int)(Math.random() * 99 + 1);
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[i]) {
					arr[i] ^= arr[j];
					arr[j] ^= arr[i];
					arr[i] ^= arr[j];
				}
			}
			System.out.print(arr[i] + " ");
		}
		System.out.println('\r');
	}
	
	public static void bubbleSort() {
		int[] arr = new int[5];
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			arr[i] = (int)(Math.random() * 99 + 1);
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] < arr[j + 1]) {
					arr[j] ^= arr[j + 1];
					arr[j + 1] ^= arr[j];
					arr[j] ^= arr[j + 1];
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println('\r');
	}
	
	public static void findMaxWithForEach() {
		int[] arr = new int[5];
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			arr[i] = (int)(Math.random() * 99 + 1);
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		int max = Integer.MIN_VALUE;
		for (int i : arr) {
			if (i > max)
				max = i;
		}
		System.out.println(max + "\r");
	}
	
	public static void mergeArray() {
		int len = (int)(Math.random() * 5 + 5);
		int[] arr1 = new int[len];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] =  (int)(Math.random() * 99 + 1);
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		len = (int)(Math.random() * 5 + 5);
		int[] arr2 = new int[len];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] =  (int)(Math.random() * 99 + 1);
			System.out.print(arr2[i] + " ");
		}
		System.out.println();
		int[] merge = new int[arr1.length + arr2.length];
		System.arraycopy(arr1, 0, merge, 0, arr1.length);
		System.arraycopy(arr2, 0, merge, arr1.length, arr2.length);
		for (int i : merge) {
			System.out.print(i + " ");
		}
		System.out.println('\n');
	}
	
	public static void findMaxIn2DArray() {
		int[][] arr = new int[5][5];
		int max = Integer.MIN_VALUE;
		int x = -1, y = -1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = (int)(Math.random() * 99 + 1);
				System.out.print(arr[i][j] + " ");
				max = Math.max(max, arr[i][j]);
				if (max == arr[i][j]) {
					x = i;
					y = j;
				}
			}
			System.out.println();
		}
		System.out.println(max + " " + x + " " + y);
	}
	
	public static void array2DSort() {
		int[][] arr2D = new int[5][8];
		int[] arr = new int[arr2D.length * arr2D[0].length];
		for (int i = 0; i < arr2D.length; i++) {
			for (int j = 0; j < arr2D[i].length; j++) {
				arr2D[i][j] = (int)(Math.random() * 99 + 1);
			}
			System.out.println(Arrays.toString(arr2D[i]));
			System.arraycopy(arr2D[i], 0, arr, i * arr2D[i].length, arr2D[i].length);
		}
		System.out.println();
		Arrays.sort(arr);
		for (int i = 0; i < arr2D.length; i++) {
			System.arraycopy(arr, i * arr2D[i].length, arr2D[i], 0, arr2D[i].length);
			System.out.println(Arrays.toString(arr2D[i]));
		}
	}
}
