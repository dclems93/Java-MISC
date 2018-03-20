public class ParttimeFaculty extends Faculty{

  public ParttimeFaculty(String names, 
                         String gender,
                         int ssn,
                         String degrees, 
                         String[] benefitsArray){
    this.name = names;
    this.gender = gender;
    this.ssn = ssn;
    this.degree = degrees;
    this.benefits = benefitsArray;
    this.wages = 1500;
    this.offleave = 10;
  
  }
 
}