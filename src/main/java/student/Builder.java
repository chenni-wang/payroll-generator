package student;

/**
 * This is a static class (essentially functions) that will help you build objects from CSV strings.
 * These objects are then used in the rest of the program. Often these builders are associated
 * with the objects themselves and the concept of a factory, but we placed
 * them here to keep the code clean (and to help guide you).
 */
public final class Builder {

    private Builder() {
    }


    /**
     * Builds an employee object from a CSV string.
     * <p>
     * You may end up checking the type of employee (hourly or salary) by looking at the first
     * element of the CSV string. Then building an object specific to that type.
     *
     * @param csv the CSV string
     * @return the employee object
     */
    public static IEmployee buildEmployeeFromCSV(String csv) {
        if (csv == null || csv.isBlank()){
            return null;
        }

        String[] parts = csv.split(",");

        if (parts.length != 7){
            return null;
        }

        try {
            String type = parts[0].trim();
            String name = parts[1].trim();
            String id = parts[2].trim();
            double payRate = Double.parseDouble(parts[3].trim());
            double pretaxDeductions = Double.parseDouble(parts[4].trim());
            double ytdE = Double.parseDouble(parts[5].trim());
            double ytdT = Double.parseDouble(parts[6].trim());

            if (type.equals("HOURLY")) {
                return new HourlyEmployee(name, id, payRate, ytdE, ytdT, pretaxDeductions);
            } else {
                return new SalaryEmployee(name, id, payRate, ytdE, ytdT, pretaxDeductions);
            }

        } catch (NumberFormatException e) {
            System.err.println("String cannot convert to double:" + csv);
        }

        return null;
    }


    /**
     * Converts a TimeCard from a CSV String.
     *
     * @param csv csv string
     * @return a TimeCard object
     */
    public static ITimeCard buildTimeCardFromCSV(String csv) {
        if (csv == null || csv.isBlank()) {
            return null;
        }

        String[] parts = csv.split(",");

        if (parts.length != 2) {
            return null;
        }

        try {
            String id = parts[0].trim();
            double hoursworked = Double.parseDouble(parts[1].trim());
            return new TimeCard(id, hoursworked);

        } catch (NumberFormatException e) {
            System.err.println("string fail converting to double:" + csv);

        }
        return null;
    }
}
