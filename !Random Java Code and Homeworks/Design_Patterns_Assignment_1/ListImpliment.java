import java.util.*;

class ListImpliment{

  public static void main(String[] args){
    ArrayList array1 = new ArrayList(5);
    
    // Method ArrayAdd takes a number and a position (both int) and places that number
    // in the position within the array. This method will keep the same size of Array.
    System.out.println("ALL ARRAYLIST METHODS BELOW:");
    System.out.println("");
    System.out.println("");
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    System.out.println("======ArrayList insert() and PrintIt():");
    System.out.println("Initial array:");
    
    array1.PrintIt();
    System.out.println("insert(5, 3)");
    array1.insert(5, 3);
    array1.PrintIt();
    System.out.println("insert(5)");
    array1.insert(5);
    array1.PrintIt();
    System.out.println("");
    System.out.println("");
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    //Search takes a number and returns the position of that number within the ArrayList
    System.out.println("=====ArrayList searchFor():");
    System.out.println("searchFor(5)");
    System.out.println(array1.searchFor(5));
    System.out.println("searchFor(7)");
    array1.searchFor(7);
    System.out.println("");
    System.out.println("");
    System.out.println("");
    
    // PrintIt takes an ArrayList and prints it in a legible form to the System.
    array1.PrintIt();
    
    // ExtendAdd takes an int and adds it to the end of the ArrayList, thus extending the
    // ArrayList by 1.
    
    System.out.println("======ArrayList ExtendAdd():");
    System.out.println("");
    System.out.println("ExtendAdd(7)");
    array1.ExtendAdd(7);
    System.out.println("ExtendAdd(8)");
    array1.ExtendAdd(8);
    System.out.println("ExtendAdd(99)");
    array1.ExtendAdd(99);
    array1.PrintIt();
    System.out.println("");
    System.out.println("");
    /////////////////////////////////////////////////////////////////////////////////////////////
    // AddAt() takes a number and position (both int) and places that number at the position,
    // and then copies the rest of the ArrayList. This extends the size of the ArrayList
    // by 1.
    System.out.println("======ArrayList AddAt()");
    System.out.println("");
    System.out.println("AddAt(77, 3)");
    array1.AddAt(77, 3);
    array1.PrintIt();
    System.out.println("AddAt(22, 4)");
    array1.AddAt(22, 4);
    array1.PrintIt();
    
    
    System.out.println("");
    System.out.println("");
   
    
    // PrintIt() functions the same with LinkedLists as it does with ArrayLists, only it displays
    // nodes as ( node.data, node.next )  and displays all of the nodes in a LinkedList in 
    // a clean output.
    
    System.out.println("=============ALL LINKEDLIST METHODS BELOW:");
    
    System.out.println("");
    System.out.println("");
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////////
    System.out.println("=====LinkedList PrintIt():");
    LinkedList list1 = new LinkedList(5);
  
    LinkedList list3 = new LinkedList(2);
    LinkedList list4 = new LinkedList(3);
    LinkedList list5 = new LinkedList(4);
    LinkedList list6 = new LinkedList(5);
    LinkedList list7  = new LinkedList(33);
    list1.PrintIt();
    list3.PrintIt();
    list4.PrintIt();
    list5.PrintIt();
    list6.PrintIt();
    
    System.out.println("");
    System.out.println("");
    //////////////////////////////////////////////////////////////////////////////////
    System.out.println("=====LinkedList nodeAt():");
    System.out.println(""+ list1.nodeAt(5).next);
    System.out.println(""+ list3.nodeAt(2).next);
    System.out.println(""+ list4.nodeAt(3).next);
    System.out.println(""+ list5.nodeAt(4).next);
    
    System.out.println("");
    System.out.println("");
    
    //////////////////////////////////////////////////////////////////////////////////
    System.out.println("=====LinkedList searchFor()");
    System.out.println("" + list4.searchFor(0));
    
    list6.PrintIt();
    
    System.out.println("insert(1,0)");
    list6.insert(1, 0);
    System.out.println("insert(2,1)");
    list6.insert(2, 1);
    System.out.println("insert(3,2)");
    list6.insert(3, 2);
    System.out.println("insert(4,3)");
    list6.insert(4, 3);
    System.out.println("insert(5,4)");
    list6.insert(5, 4);
    System.out.println("insert(99)");
    list6.insert(999);
    list6.PrintIt();
    
    //////////////////////////////////////////////////////////////////////////////////////
    System.out.println("=====LinkedList sizeOf():");
    System.out.println("Size of List1: " + list1.sizeOf());
    System.out.println("Size of List3: " + list3.sizeOf());
    System.out.println("Size of List4: " + list4.sizeOf());

  }

  
  
}