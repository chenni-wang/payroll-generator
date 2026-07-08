package student;

/*
 *This class represents an employee whose pay is divided by 24 for two payments every month
 */
public class SalaryEmployee extends AbstractEmployee {
    /**
     * This is a constructor for SalaryEmployee.
     * @param name employee name
     * @param id employee ID
     * @param payRate annual salary
     * @param ytdEarnings year-to-date earnings
     * @param ytdTaxesPaid year-to-date taxes paid
     * @param pretaxDeductions pretax deductions
     */
    public SalaryEmployee(String name, String id, double payRate,
                          double ytdEarnings, double ytdTaxesPaid,
                          double pretaxDeductions) {
        super(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
    }

    @Override
    public String getEmployeeType() {
        return "SALARY";
    }

    @Override
    protected double calculateGrossPay(double hoursWorked) {
        return getPayRate() / 24;
    }
}
