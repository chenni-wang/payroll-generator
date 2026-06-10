package student;

/*
 * This class represents a pay stub for one employee
 */
public class PayStub implements IPayStub {
    private String employeeName;
    private double netPay;
    private double taxes;
    private double ytdEarnings;
    private double ytdTaxesPaid;

    /*
     * This is a constructor for PayStub.
     * @param employeeName employee's name
     * @param netPay pay for the current period
     * @param taxes  paid taxes for the current pay period
     * @param ytdEarnings new ytd earnings
     * @param ytdTaxesPaid new ytd taxes paid
     */
    public PayStub(String employeeName,
                   double netPay,
                   double taxes,
                   double ytdEarnings,
                   double ytdTaxesPaid){
        this.employeeName = employeeName;
        this.netPay = netPay;
        this.taxes = taxes;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
    }

    @Override
    public double getPay(){
        return netPay;
    }

    @Override
    public double getTaxesPaid(){
        return taxes;
    }

    @Override
    public String toCSV() {
        return employeeName+","
                +netPay+","
                +taxes+","
                +ytdEarnings+","
                +ytdTaxesPaid;
    }
}
