public class LinkedList{
  int size;
  Node node;

////////////////////////////////////////////////////////////
// Notes: 
// ====a LinkedList contains a node. 
// ========a node contains a value and a next
// ========a next is one of: null, a node
//
// =====The index of a LinkedList starts from 0, which is the outer most element.
// 
//
/////////////////////////////////////////////////////////////




  public LinkedList(int levels){
    Node node;
    this.size = levels;
    this.node = new Node(0, null);
    if(levels != 0){
      for(int i = 0; i < levels; i++){
        this.node = new Node(0, this.node);
      }
    }
  }
  //////////////////////////////////////////////////////////////////////////
  // insert(int number) and insert(int number, int posn)
  // inserts numbers in either a posn or the end of the LinkedList
  public void insert(int number, int posn){

    this.nodeAt(posn + 1).data = number;
  }
  
  public void insert(int number){
   
    this.nodeAt(this.size).data = number;
  }
  
  
  /////////////////////////////////////////////////////////////////////////
  // PrintIt()
  // Prints a Linked List
  public void PrintIt(){
                        
    String output = "(" + this.nodeAt(this.size).data + ", " 
      + this.nodeAt(this.size).next + " )";
    for(int i = size - 1; i > 0; i--){
      output= "( " + nodeAt(i).data + ", " + output + " )";
    }
    System.out.println(output);
  }
  
  ///////////////////////////////////////////////////////////////////////////////////////
  // nodeAt()
  // Returns a node at a particular position, starting with 0 at the outermost element.
  public Node nodeAt(int index){
    Node nodeReturn = this.node;
    if(index == 0){
      nodeReturn = this.node;
    }
    else for(int i = 0; i < index; i++){
      
      if(i == index){
        break;
      }
      else nodeReturn = nodeReturn.next;
    }
    return nodeReturn;
  }
  
  /////////////////////////////////////////////////////////////////////////////////////////////////
  // searchIt() returns position of specific element in LinkedList, starting from the outside at 0.
  public String searchFor(int searched){
   String index = "";
   Node rest = this.node;
   for(int i = 0; i < this.size; i++){
     if(rest.data == searched){
       index = "" + i;
       break;
     }
     else if(i==this.size){
      index = "Node is not contained within LinkedList";
      break;
     }
     else rest = rest.next;
   }
   return index;
  }
  
  ///////////////////////////////////////////////////////////////////////////////////////////////////
  // sizeOf()
  // returns the size of the LinkedList()
  
  public int sizeOf(){
   return this.size; 
  }
  
  
}