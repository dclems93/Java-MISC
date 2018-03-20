public abstract class Faculty extends Employee{
  String degree;

  
  public String getDegree(){
   return this.degree; 
  }
  
  public void printFaculty(){
    System.out.println("NAME:       "+ this.getName());
    System.out.println("Gender:     " + this.getGender());
    System.out.println("SSN:        " + this.getSSN());
    System.out.println("WAGE:       $ " + this.getWages());
    System.out.println("Degree:     " + this.getDegree());
    System.out.println("Offleave:   " + this.getOffleave());
    System.out.println("Benefits:   ");
    this.getBenefits();
    System.out.println("");
                       
  }
  
}