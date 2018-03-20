public class EmployeeDatabase{
  static void allStaff(Staff[] staff){
    for(int i = 0; i < staff.length; i++){
      staff[i].printStaff();
    }
  }
  static void allFaculty(Faculty[] faculty){
    for(int i = 0; i < faculty.length; i++){
      faculty[i].printFaculty();
    }
  }
  
 

  public static void main(String[] args){
    

    String[] benAr1 = new String[3];
    benAr1[0] = "Benefit 1: Annual Bonus";
    benAr1[1] = "Benefit 2: Health Insurance";
    benAr1[2] = "Benefit 3: Dental";
    
    String[] benAr2 = new String[1];
    benAr2[0] = "Benefit 1: Health insurance";
    
    String[] benAr3 = new String[2];
    benAr3[0] = "Benefit 1: Health insurance";
    benAr3[1] = "Benefit 2: Vision";
    
    String[] benAr4 = new String[1];
    benAr4[0] = "No Benefits. This worker is disposable.";
    
    
///Staff/////////////////////////////////////////////////////////
// a Staff is a new Staff(String Name, int SSN, String Degree
//                        String[] benefitsArray)
    
    Staff[] allstaff = new Staff[3];
    Staff davesting = new Staff("Dave Sting", "Male",
                                   123456, 9999, benAr1);
    allstaff[0] = davesting;
    
    Staff rogerroger = new Staff("Roger Roger", "Male",
                                   123956, 2000, benAr3);
    allstaff[1] = rogerroger;
    
    Staff ashleyroger = new Staff("Ashley Roger", "Female",
                                   123456, 999, benAr2);
    
    allstaff[2] = ashleyroger;
    
    
    System.out.println("#########Faculty########");
    allStaff(allstaff);
///Faculty//////////////////////////////////////////////////////
// a FulltimeFaculty = new FulltimeFaculty(String name, String gender, 
//                                         int ssn, String degrees,
//                                         String[] benefitsArray)
  
    Faculty[] allfaculty = new Faculty[3];
    Faculty billybob = new FulltimeFaculty("Billy Bob", "Male",
                                   1237776, "High School", benAr1);
    allfaculty[0] = billybob;
    
    Faculty macymay = new ParttimeFaculty("Macy May", "Female",
                                   123956,"High School", benAr4);
    allfaculty[1] = macymay;
    
    Faculty davecook = new FulltimeFaculty("Dave Cook", "Male",
                                   1244456, "High School", benAr4);
    allfaculty[2] = davecook;
    
    System.out.println("#########Faculty########");
    allFaculty(allfaculty);  
  
  }
  
}