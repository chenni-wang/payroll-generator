package student;

/*
 * A time card class includes the employee ID and the hours worked by this employee
 */

public class TimeCard implements ITimeCard {
    /** The employee's ID. */
    private String employeeID;
    /** The hours worked by the employee. */
    private double hoursWorked;

    /*
     * This is a constructor for TimeCard
     * @param hoursWork hours worked by the employee
     * @param employeeID employee's ID
     */
    public TimeCard(String employeeID, double hoursWorked) {
        this.employeeID = employeeID;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String getEmployeeID() {
        return employeeID;
    }

    @Override
    public double getHoursWorked() {
        return hoursWorked;
    }
}
