//fullname:
//username:
//collaborator(s):

import java.util.*;
import java.io.*;

class Homework6 {
    public static void main(String[] args) throws Exception {
    
	//PARAMETERS FOR TESTING
    
	//For problem 1, 2
	String filename = "stuff.txt";  //MUST SPECIFY FILENAME IN SAME FOLDER
    
	//For problem 3, 4
	String numbers = "1 2 5 6 7 8"; //ONLY USE SINGLE SPACES! (will error if you use multiple spaces in a row)
    
	//For problem 5
	int n = 5;                      //ONLY SHOULD WORK FOR ODD NUMBERS 
    
	//**************** PROBLEM 1 *******************//
	int[][] matrix = create2DIntMatrixFromFile( filename );
	//Print out Matrix generated from file (must be in same folder)
	System.out.println("Problem 1: Matrix with " + matrix.length + " lines and " + matrix[0].length + " columns.");
	Homework6.show( matrix );
    
	System.out.println("Matrix is magic square? " + Homework6.isMagicSquare(matrix));
	System.out.println("-----------------");
    
	//**************** PROBLEM 2 *******************//
	ArrayList<ArrayList<Integer>> matrix2 = createArrayListMatrixFromFile( filename );
	//Print out Matrix generated from Array
	System.out.println("Problem 2: Matrix with " + matrix2.size() + " lines and " + matrix2.get(0).size() + " columns.");
	Homework6.show( matrix2 );
    
	System.out.println("Matrix is magic square? " + Homework6.isMagicSquare(matrix));
	System.out.println("-----------------");
    
	//**************** PROBLEM 3 *******************//
	int[][] magicMatrix = constructMagicSquare2DIntArray(n);
	//print out Magic Square
	System.out.println("Problem 3: Magic Square:");
	for (int row = 0; row < magicMatrix.length; row=row+1) {
	    for (int col = 0; col < magicMatrix.length; col=col+1) {
		System.out.printf(" %3d", magicMatrix[row][col]);
	    }
	    System.out.println();
	}
	System.out.println("-----------------");
    
    
	//**************** PROBLEM 4 *********************
	ArrayList<ArrayList<Integer>> magicMatrix2 = constructMagicSquareArrayList(n);
	//print out Magic Square
	System.out.println("Problem 4: Magic Square:");
	for (int row = 0; row < magicMatrix.length; row=row+1) {
	    for (int col = 0; col < magicMatrix.length; col=col+1) {
		System.out.printf(" %3d", magicMatrix2.get(row).get(col) );
	    }
	    System.out.println();
	}
	System.out.println("-----------------");

    
	//**************** PROBLEM 5 *********************
	// R6.26
	System.out.println("Problem 5: R6.26");
	int[] aa = new int[] { 0, 1, 2, 3 };
	ArrayList<Integer> b = new ArrayList<Integer>();
	for(int intValue : aa) {
	    b.add(intValue);
	}
    
	int[] c = new int[] { 4, 5, 6, 7, 8 };
	ArrayList<Integer> d = new ArrayList<Integer>();
	for(int intValue : c) {
	    d.add(intValue);
	}
	ArrayList<Integer> e = Homework6.append( b, d );
    
	System.out.println( e );
	System.out.println("-----------------");
    
	// R6.27
	System.out.println("Problem 5: R6.27");
	String[] nums = numbers.split(" ");
    
	//Populate the arrays from the input at top of file
	ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
	for (String arg : nums) {
	    ArrayList<Integer> row = new ArrayList<Integer>();
	    row.add(Integer.parseInt(arg));
	    a.add(row);
	}
    
	//Print out the process of merging
	System.out.println( a );
	while (a.size() > 1) {
	    for (int i = 0; i < a.size() - 1; i = i + 1) {
		a.add(i, Homework6.merge(a.remove(i), a.remove(i)));
		System.out.println( a );
	    }
	}
	System.out.println("-----------------");
 
    }
  
  
  
    // PROBLEM #1
    public static int[][] create2DIntMatrixFromFile(String filename) throws Exception {
	int[][] matrix = {{1}, {2}};
	return matrix;
    }
  
    public static boolean isMagicSquare(int[][] square) {
	return false;
    }
  
  
    // PROBLEM #2
    public static ArrayList<ArrayList<Integer>> createArrayListMatrixFromFile(String filename) throws Exception {
	ArrayList<ArrayList<Integer>> matrix= new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> row = new ArrayList<Integer>();
	row.add(1);
	matrix.add(row);
	return matrix;
    }
  
    public static boolean isMagicSquare( ArrayList<ArrayList<Integer>> square) {
	return false;
    }
  
  
    //PROBLEM #3
    public static int[][] constructMagicSquare2DIntArray(int size) {
	int[][] matrix = {{1}};
	return matrix;
    }
  
  
    //PROBLEM #4
    public static ArrayList<ArrayList<Integer>> constructMagicSquareArrayList(int size) {
	ArrayList<ArrayList<Integer>> matrix= new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> row = new ArrayList<Integer>();
	row.add(1);
	matrix.add(row);
	return matrix;
    }
  
  
    //Problem 5  P6.26
    public static ArrayList<Integer> append(ArrayList<Integer> a, ArrayList<Integer> b)
    {
	ArrayList<Integer> newList = new ArrayList<Integer>();
	return newList;
    }

    //Problem 5  P6.27
    static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b) {
	ArrayList<Integer> result = new ArrayList<Integer>();
	return result;
    }
  
  
  
  
    public static void show(ArrayList<ArrayList<Integer>> square) {
	for (ArrayList<Integer> row : square) {
	    for (Integer elem : row)
		System.out.printf("%3d ", elem);
	    System.out.println();
	}
	System.out.println("-----------------");
    }
  
    public static void show(int[][] square) {
	for (int[] row : square) {
	    for (int elem : row)
		System.out.printf("%3d ", elem);
	    System.out.println();
	}
	System.out.println("-----------------");
    }
  
}



