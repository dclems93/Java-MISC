//fullname: Dylan Dale
//username: dmdale
//collaborator(s): Robert, Steve and Adrian.

import java.util.*;
import java.io.*;

class Homework6 {
    public static void main(String[] args) throws Exception {

 //PARAMETERS FOR TESTING
 //For problem 1, 2
 String filename = "stuff.txt"; //MUST SPECIFY FILENAME IN SAME FOLDER
 //For problem 3, 4
 String numbers = "1 2 5 6 7 8"; //ONLY USE SINGLE SPACES! (will error if you use multiple spaces in a row)
 //For problem 5
 int n = 5; //ONLY SHOULD WORK FOR ODD NUMBERS

 //**************** PROBLEM 1 *******************//
 int[][] matrix = create2DIntMatrixFromFile( filename );
 System.out.println("Check");
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
      int[][] matrix = new int[0][]; // = {{1}, {2}};
      Scanner in = new Scanner(new File(filename));
      while (in.hasNextLine()) {
        String line = in.nextLine();
        Scanner tokens = new Scanner(line);
        int[] row = new int[0];
        while (tokens.hasNext()) {
          String token = tokens.next();
          int number = Integer.parseInt(token);
          row = Arrays.copyOf(row, row.length + 1);
          row[row.length - 1] = number;
        }
        matrix = Arrays.copyOf(matrix, matrix.length + 1);
        matrix[matrix.length - 1] = row;
      }
      return matrix;
    }

    public static boolean isMagicSquare(int[][] square) {
      boolean answer;
      int size = square.length;
      int sum_max = size * (size * size + 1 ) / 2;
      System.out.println( "The sum you're aiming for: " + sum_max );
      /* (a) is matrix a square or not?
       * (b) is any sum not sum_max?
       * (c) is any number between 1 and size * size once and only once?
       */
      if (a(square) && b(square) && c(square)) {
        answer = true;
        System.out.println( "Yes this structure is a magic square. ");
      } else {
        answer = false;
        System.out.println( "Not this structure is not a magic square. ");
      }
      return answer;
    }

    public static boolean a(int[][] m) {
      int size = m.length;
      boolean answer = true;
      for (int[] row : m) {
        if (row.length != size)
          answer = false;
      }
      System.out.println("Checking if square: " + answer);
      return answer;
   }

   public static boolean b(int[][] m) {
     int size = m.length;
     boolean answer = true;
     int sum_max = size * (size * size + 1 ) / 2;
     for (int[] row : m) {
       if (sum(row) != sum_max)
         answer = false;
     }
     System.out.println( "Checking line sums: " + answer );
     for (int column = 0; column < size; column++) {
       if (sum(m, column) != sum_max)
         answer = false;
     }
     System.out.println( "Checking column sums: " + answer );

     if (sumDiag(m, true) != sum_max || sumDiag(m, false) != sum_max)
       answer = false;

     return answer;
   }
   public static int sum(int[] row) {
     int sum = 0;
     for (int e : row)
       sum += e;
     return sum;
   }
   public static int sum(int[][] m, int column) {
     int sum = 0;
     int size = m.length;
     for (int line = 0; line < size; line++)
       sum += m[line][column];
     return sum;
 }

   public static boolean c(int[][] m) {
     boolean answer = true;
   int size = m.length;
   for (int i = 1; i <= size * size; i++)
     if (count(m, i) != 1)
     answer = false;
   System.out.println("Checking if this structure has all numbers exactly once: " + answer);
   return answer;
   }

   public static int count(int[][] m, int value) {
     int count = 0;
     for (int[] row : m)
     for (int element : row)
       if (element == value)
       count += 1;
     return count;
   }

   public static int sumDiag(int[][] m, boolean first) {
     int sum = 0, size=m.length;
     for (int i = 0; i < m.length; i++) {
       if (first)
       sum = sum + m[i][i];
       else
         sum = sum + m[i][size-1-i];
     }
     return sum;
   }

   // PROBLEM #2
   public static ArrayList<ArrayList<Integer>> createArrayListMatrixFromFile(String filename) throws Exception {
      ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();

      Scanner in = new Scanner(new File(filename));
      while (in.hasNextLine()) {
        String line = in.nextLine();
        ArrayList<Integer> row = new ArrayList<Integer>();
        Scanner tokens = new Scanner(line);
        while (tokens.hasNext()) {
          String token = tokens.next();
          row.add(Integer.parseInt(token));
        }
        matrix.add(row);
      }
       return matrix;
   }

    public static boolean isMagicSquare( ArrayList<ArrayList<Integer>> square) {
      int[][] a = convert(square);
      return isMagicSquare(a);
    }

    public static int[][] convert( ArrayList<ArrayList<Integer>> square ) {
      int size = square.size();
      int[][] m = new int[size][];
      for (int i = 0; i < size; i++) {
        ArrayList<Integer> row = square.get(i);
        m[i] = new int[row.size()];
        for (int j = 0; j < row.size(); j++) {
          m[i][j] = row.get(j);
        }
      }
      return m;
    }


   //PROBLEM #3

   public static int[][] constructMagicSquare2DIntArray(int size) {
     int[][] matrix = new int[0][];
     int[] row = new int [1];
     //row.append(row.length() + 1);
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


    //Problem 5 P6.26
   public static ArrayList<Integer> append(ArrayList<Integer> a, ArrayList<Integer> b)
   {
     ArrayList<Integer> answer = new ArrayList<Integer>();
     for ( int i = 0; i < ( a.size() + b.size() ); i++) {
       if ( i < a.size()) {
         answer.add(a.get(i));
       }
       else { answer.add(b.get(i - a.size())); }
     }
 return answer;
   }

   //Problem 5 P6.27
   static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b) {
     ArrayList<Integer> result = new ArrayList<Integer>();
     while( a.size() > 0 || b.size () > 0) {
       if( a.size() == 0) {
         result.add( b.remove(0) );
       }
       else if( b.size() == 0) {
         result.add( a.remove(0) );
       }
       else if( a.get(0) > b.get(0) ) {
         result.add( b.remove(0) );
       }
       else { result.add( a.remove(0) ); }
     }
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
