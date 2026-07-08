package student;

/*
 *This class represents an employee whose pay is calculated by hoursworked
 */
public class HourlyEmployee extends AbstractEmployee {
    /**
     * This is a constructor for HourlyEmployee.
     *
     * @param name             Employee's name
     * @param id               Employee's ID
     * @param payRate          Employee's pay rate
     * @param pretaxDeductions Employee's pretax deductions
     * @param ytdEarnings      Employee's year-to-date earnings
     * @param ytdTaxesPaid  Employee's year-to-date taxes paid
     */
    public HourlyEmployee(String name, String id, double payRate,
                          double ytdEarnings, double ytdTaxesPaid,
                          double pretaxDeductions) {
        super(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
    }

    @Override
    public String getEmployeeType() {
        return "HOURLY";
    }

    @Override
    protected double calculateGrossPay(double hoursWorked) {
        if (hoursWorked < 40) {
            return hoursWorked * getPayRate();
        } else {
            return getPayRate() * 40 + getPayRate() * 1.5 * (hoursWorked - 40);
        }
    }
}
