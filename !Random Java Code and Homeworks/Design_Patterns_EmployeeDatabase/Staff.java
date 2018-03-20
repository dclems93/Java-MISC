public class Staff extends Employee{
  
  public Staff(String names,
               String gender,
               int ssn,
               int wage,
               String[] benefitsArray){
    this.name = names;
    this.gender = gender;
    this.ssn = ssn;
    this.wages = wage;
    this.benefits = benefitsArray; 
    
  }
  
  void printStaff(){
    System.out.println("NAME:       "+ this.getName());
    System.out.println("Gender:     " + this.getGender());
    System.out.println("SSN:        " + this.getSSN());
    System.out.println("WAGE:       $ " + this.getWages());
    System.out.println("Benefits:   ");
    this.getBenefits();
    System.out.println("");
  }
}