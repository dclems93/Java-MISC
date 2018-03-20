public abstract class Employee{
   
  int ssn;
  String gender;
  int wages;
  int offleave;
  String[] benefits;
  String name;
   
   
   public String getName(){
    return this.name; 
   }
   
   public String getGender(){
    return this.gender; 
   }
   
   public int getSSN(){
     return this.ssn;
   }
   
   public int getWages(){
     return this.wages;
  }
   
   public int getOffleave(){
     return this.offleave;
   }
   
  void getBenefits(){
    for(int i=0; i < benefits.length; i++){
      System.out.println(benefits[i]); 
    }
  }

  
}