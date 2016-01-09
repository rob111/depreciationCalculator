
package Project2;

/**
 *
 * @author Andrey Knyazev
 */
public class Calculations {
  private String method;
  private double cost;
  private double scrap;
  private int years;
  
  private double total;
  private double [] units;
  private double total_miles=0;
  
  private String tracking;
  
  private double accumulated=0;
  private double miles_check;

 
  double depreciation=0;
  
  public  Calculations(){
      
      method=null;
      cost=0;
      scrap=0;
      years=0;
  }

  public Calculations(String method ,double cost,double scrap, int years
   ) {
    this.cost = cost;
    this.scrap = scrap;
    this.years = years;
    this.method = method;
  }
  public Calculations(double cost, int years,
    
    double scrap, String method, double[] units) {
    this.cost = cost;
    this.scrap = scrap;
    this.years = years;
    this.method = method;
    this.units=units;
  }
  
  public double getSLDepreciation(){
  

       depreciation=(cost-scrap)/years;
       return depreciation;
  }
  
  public double getSYDDepreciation(int i){
  

   
    double sumyears=((years*(years+1))/2);
   
    double countyear=(years-i);
    
    depreciation=(countyear/sumyears)*(cost-scrap);  

    return depreciation;
  }
  
  public double getDDDepreciation(){
     
   
   double newcost=cost-getTotal();
      
   depreciation=((2/(double)years)*(newcost));
   
        setTotal(getTotal() + depreciation);
   
    
    return depreciation;
  }
  
  public double getUPDepreciation(){
  
  double depreciation=0;
  
  double baseline=cost-scrap;
  
  for (int k = 0; k < units.length; k++) {
            setTotal_miles(getTotal_miles() + units[k]);
         }
  
  return units.length;
  }
    /**
     * @return the name
     */
    public String getMethod() {
        return method;
    }

    /**
     * @param name the name to set
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * @return the scrap
     */
    public double getScrap() {
        return scrap;
    }

    /**
     * @param scrap the scrap to set
     */
    public void setScrap(double scrap) {
        this.scrap = scrap;
    }

    /**
     * @return the years
     */
    public int getYears() {
        return years;
    }

    /**
     * @param years the years to set
     */
    public void setYears(int years) {
        this.years = years;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the units
     */
    public double [] getUnits() {
        return units;
    }

    /**
     * @param units the units to set
     */
    public void setUnits(double[] units) {
        this.units = units;
    }

    /**
     * @return the total_miles
     */
    public double getTotal_miles() {
        return total_miles;
    }

    /**
     * @param total_miles the total_miles to set
     */
    public void setTotal_miles(double total_miles) {
        this.total_miles = total_miles;
    }
    /**
     * @return the action
     */
    public String getTracking() {
        return tracking;
    }

    /**
     * @param action the action to set
     */
    public void setTracking(String tracking) {
        this.tracking = tracking;
    }

    /**
     * @return the miles_check
     */
    public double getMiles_check() {
        return miles_check;
    }

    /**
     * @param miles_check the miles_check to set
     */
    public void setMiles_check(double miles_check) {
        this.miles_check = miles_check;
    }
}

