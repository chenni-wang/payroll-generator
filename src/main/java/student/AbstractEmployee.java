package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class AbstractEmployee implements IEmployee {
    private String name;
    private String id;
    private double payRate;
    private double ytdEarnings;
    private double ytdTaxesPaid;
    private double pretaxDeductions;

    // tax=0.0145+0.062+0.15
    private static final double TAX_RATE = 0.2265;

    /*
    *This is a constructor for the abstractemployee
     */
    public AbstractEmployee(String name, String id, double payRate, double ytdEarnings, double ytdTaxesPaid, double pretaxDeductions){
        this.name = name;
        this.id = id;
        this.payRate = payRate;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
        this.pretaxDeductions = pretaxDeductions;
    }

    /**
     * Gets the employee's name.
     *
     * @return name the name of the employee
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Gets the employee's ID.
     *
     * @return id the ID of the employee
     */
    @Override
    public String getID() {
        return id;
    }

    /**
     * Gets the employee's pay rate.
     *
     * @return payRate the pay rate of the employee
     */
    @Override
    public double getPayRate() {
        return payRate;
    }


    /**
     * Gets the YTD earnings of the employee.
     *
     * @return ytdEarnings the YTD earnings of the employee
     */
    @Override
    public double getYTDEarnings() {
        return ytdEarnings;
    }

    /**
     * Gets the YTD taxes paid by the employee.
     *
     * @return ytdTaxesPaid the YTD taxes paid by the employee
     */
    @Override
    public double getYTDTaxesPaid() {
        return ytdTaxesPaid;
    }

    /**
     * Gets pretax deductions for the employee. Yes, on a normal paycheck this varies as either set
     * amounts or percents, and often more than one type of deduction.
     * <p>
     * For now, you can just assume a single pretax deduction as a whole dollar amount.
     *
     * @return pretaxDeductions the pretax deductions for the employee
     */
    @Override
    public double getPretaxDeductions() {
        return pretaxDeductions;
    }

    /*
    *calculated gross pay for current period
     */
    protected abstract double calculateGrossPay(double hoursWorked);

    /**
     * Runs the employee's payroll.
     * <p>
     * This will calculate the pay for the current pay, update the YTD earnings, and update the
     * taxes paid YTD.
     * <p>
     * taxes are calculated as 1.45% for medicare, 6.2% for social security, and 15% for
     * withholding. or 22.65% total. They are calculated on the net pay (after pretax deductions).
     * <p>
     * For hourly employees, the pay is calculated as payRate * hoursWorked for the first 40 hours,
     * then payRate * 1.5 * (hoursWorked - 40) for overtime.
     * <p>
     * For salary employees, it is pay rate divided by 24 for two payments every month.
     * <p>
     * If either type of employee has < 0 hours, they are skipped this payroll period.
     * (suggestion return null, and skip adding nulls to your paystub list)
     * <p>
     * Final net pay is calculated as pay - pretaxDeductions - taxes.
     * <p>
     * All numbers (across all methods) are rounded to the nearest cent. (2 decimal places)
     * <p>
     * SUGGESTION: You may want to use BigDecimal for the calculations to avoid floating point errors.
     * SUGGESTION: You may want to create an protected abstract calculateGrossPay(double hoursWorked)
     * method to calculate the gross pay for the pay period, as runPayroll is exactly
     * the same for both SalaryEmployee and HourlyEmployee, but calculateGrossPay is different.
     *
     * @param hoursWorked the hours worked for the pay period
     * @return the pay stub for the current pay period
     *
     */
    @Override
    public IPayStub runPayroll(double hoursWorked) {
        if (hoursWorked < 0){
            return null;
        }
        double gross = calculateGrossPay(hoursWorked);
        //gross-deduct-(gross-deduct)*tax_rate
        BigDecimal grossBD = BigDecimal.valueOf(gross).setScale(2, RoundingMode.HALF_UP);
        BigDecimal deduction = BigDecimal.valueOf(pretaxDeductions).setScale(2, RoundingMode.HALF_UP);
        BigDecimal taxAmount = grossBD.subtract(deduction).setScale(2, RoundingMode.HALF_UP);
        BigDecimal tax = taxAmount.multiply(BigDecimal.valueOf(TAX_RATE)).setScale(2, RoundingMode.HALF_UP);
        BigDecimal netPay = taxAmount.subtract(tax).setScale(2, RoundingMode.HALF_UP);

        ytdEarnings = BigDecimal.valueOf(ytdEarnings).add(netPay).setScale(2,RoundingMode.HALF_UP).doubleValue();
        ytdTaxesPaid = BigDecimal.valueOf(ytdTaxesPaid).add(tax).setScale(2,RoundingMode.HALF_UP).doubleValue();

        return new PayStub(name,netPay.doubleValue(),tax.doubleValue(),ytdEarnings,ytdTaxesPaid);
    }


    /**
     * Converts the employee to a CSV string.
     * <p>
     * Format of the String s as follows:
     * <p>
     * employee_type,name,ID,payRate,pretaxDeductions,YTDEarnings,YTDTaxesPaid
     * <p>
     * employee_type has the options for HOURLY or SALARY.
     * <p>
     * You do not have to worry about commas in the name or any other field.
     *
     * @return the employee as a CSV string
     */
    @Override
    public String toCSV() {
        return getEmployeeType() + "," + name + "," + id + ","+ payRate + "," +
                pretaxDeductions + ","+ ytdEarnings + "," + ytdTaxesPaid;
    }

}
