import java.util.Arrays;

public class ArrayList{
  
  int[] array;
  int size;
  

  public ArrayList(int size){
   this.array = new int[size];
   this.size = size;
  }
  
  
  //////////////////////////////////////////////////////////////////////////////////////////
  // sizeOf()
  // returns ArrayList size
  public int sizeOf(){
    return size;
    
  }
  
  
  ////////////////////////////////////////////////////////////////////////////////////////////
  // PrintIt()
  // Prints the ArrayList to sysout
  public void PrintIt(){
    String print = "{ ";
    
    for(int i=0 ; i < this.size ; i++){
     print += array[i] + " "; 
    }
    System.out.println(print + "}");
  }
  
  ////////////////////////////////////////////////////////////////////////////////////////////
  // ExtendAdd adds a new element to the end of the ArrayList, extending it by 1;
  public void ExtendAdd(int number){
    this.size = size+1;
    int[] temp = new int[this.size];
      for(int i=0; i < this.size ; i++){
        if(i == this.size - 1){
        temp[i] = number;
        array = new int[size];
        for(i=0; i < this.size ; i++){
          array[i] = temp[i];
        }
        break;
      }
        else temp[i] = array[i];
    }  
  }
  
  ////////////////////////////////////////////////////////////////////////////////////////
  // AddAt inserts an element at a prarticular position, extending the size of the 
  // Array list by 1 and moving all the elements after the new element to the right
  // by one.
  public void AddAt(int number, int position){
    int[] temp = new int[this.size];
    for(int i = 0; i < this.size; i++){
      temp[i] = array[i];
    }
    this.size += 1;
    this.array = new int[size];
    for(int i = 0; i < this.size; i++){
      if(i == position){
        array[i] = number;
        for(int a = i; a < this.size -1; a++){
         array[a+1] = temp[a]; 
        }
        break;
      }
      else array[i] = temp[i];
      
    }
      
  }
    
  
  ///////////////////////////////////////////////////////////////////////////////////////////
  // insert(int number) and insert(int number, int posn)
  // inserts numbers into an ArrayList without extending the array list
  public void insert(int number){
   array[size - 1] = number; 
    
  }
  public void insert(int number, int position){
    array[position] = number;
  }
  
  
  ////////////////////////////////////////////////////////////////////////////////////////////
  // searchFor(int number)
  // searches for a number and returns it's position
  public String searchFor(int number){
    String returnval = "";
    for(int i=0; i < this.size ; i++){
      if( number == array[i] ){
        returnval += i;
        break;
      }
      else if( i == this.size - 1 ){
       returnval += "this number is not in the array"; 
       break;
      }
    }
    return returnval;
  }
  
}