public class FulltimeFaculty extends Faculty{

  public FulltimeFaculty(String names,
                         String gender,
                         int ssn,
                         String degrees, 
                         String[] benefitsArray){
    this.name = names;
    this.gender = gender;
    this.ssn = ssn;
    this.degree = degrees;
    this.benefits = benefitsArray; 
    this.wages = 2500;
    this.offleave = 20;
    
  }

}