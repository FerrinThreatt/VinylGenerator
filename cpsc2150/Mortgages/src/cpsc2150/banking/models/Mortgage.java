package cpsc2150.banking;

import cpsc2150.banking.models.AbsMortgage;
import cpsc2150.banking.models.ICustomer;
import cpsc2150.banking.models.IMortgage;
import cpsc2150.banking.models.Customer;
import java.lang.Math;
public class Mortgage extends AbsMortgage implements IMortgage{
    /**
     * @invariant monthInYear == 12 AND cost >=0 AND cost >= down >= 0 AND YEARS >0 AND cust != null
     * Correspondence self.houseCost = cost AND self.downPayment = down AND self.years = YEARS AND self.customer = cust
     */
    private int monthInYear = 12;
    private double cost;
    private double down;
    private int YEARS;
    private ICustomer cust;

    /**
     * This creates a new object to track information for a customer's mortgage
     *
     * @param houseCost the cost of the customer's house
     * @param downPayment the customer's down payment for the house
     * @param years the number of years on the mortgage
     * @param customer the customer's object/data
     *
     * @pre houseCost >= 0 AND houseCost >= downPayment >= 0 AND years >= 0 AND customer is initialized
     * @post cost = houseCost AND down = downPayment AND YEARS = years AND cust = customer
     */
    public Mortgage(double houseCost, double downPayment, int years, ICustomer customer){
        cost = houseCost;
        down = downPayment;
        YEARS = years;
        cust = customer;
    }

    @Override
    public boolean loanApproved(){
        double pd = down/cost;
        double dToIR = (cust.getMonthlyDebtPayments() + getPayment())/(cust.getIncome() / monthInYear);
        if((getRate() <= RATETOOHIGH) && (pd >= MIN_PERCENT_DOWN) && (dToIR <= DTOITOOHIGH)){
            return true;
        }
        return false;
    }

    @Override
    public double getPayment(){
        double mIR = getRate()/monthInYear;
        double num = mIR * getPrincipal();
        double den = 1 - Math.pow((1 + mIR), -1*YEARS*monthInYear);

        return num/den;
    }

    @Override
    public double getRate(){
        double rate = BASERATE;
        double pd = down/cost;
        if(YEARS < MAX_YEARS){
            rate += GOODRATEADD;
        }
        else{
            rate += NORMALRATEADD;
        }

        if(pd < PREFERRED_PERCENT_DOWN){
            rate += GOODRATEADD;
        }

        if(cust.getCreditScore() < BADCREDIT){
            rate += VERYBADRATEADD;
        }
        else if(cust.getCreditScore() < FAIRCREDIT){
            rate += BADRATEADD;
        }
        else if(cust.getCreditScore() < GOODCREDIT){
            rate += NORMALRATEADD;
        }
        else if(cust.getCreditScore() < GREATCREDIT){
            rate += GOODRATEADD;
        }

        return rate;
    }

    @Override
    public double getPrincipal(){
        return cost - down;
    }

    @Override
    public int getYears(){
        return YEARS;
    }
}

