import java.util.Scanner;

/*Employee(name,salary,workHours,hireYear) : Kurucu metot olup 4 parametre alacaktır.
 */
public class C_ebebek {
    public static void main(String[] args) {
        Scanner dat = new Scanner(System.in);
        System.out.println("What is the employee name?: ");
        String name = dat.nextLine().toUpperCase();
        System.out.println("How much is the salary: ");
        double salary = dat.nextDouble();
        System.out.println("How many hours does employee work in a week?: ");
        int workhours = dat.nextInt();
        System.out.println("What is the year of start?: ");
        int hireyear = dat.nextInt();

        employee(name, salary, workhours, hireyear);

    }//main sonu

    private static void employee(String name, double salary, int workhours, int hireyear) {

        double tax = tax(salary, workhours);
        int bonus = bonus(workhours);
        double raise = raiseSalary(hireyear, salary);


        System.out.println("\n\n\n" +
                           "Employee Name           : " + name);
        System.out.println("Year of start           : " + hireyear);
        System.out.println("Working Hours in a Week : " + workhours + " hours");
        System.out.println("\n" +
                           "Current Salary          : $" + salary);
        System.out.println("Bonus                   : $" + bonus(workhours));
        System.out.println("Tax                     : -$" + tax);
        System.out.println("Net Salary              : $" + (salary + bonus - tax));
        System.out.println("\n" +
                           "Raise Salary            : $" + raise);
        double newSalary = (salary + raise + bonus);
        double newTax = tax (newSalary,workhours);
        System.out.println("Bonus for next year     : $" + bonus);
        System.out.println("Tax for new salary      : -$" + newTax);
        System.out.println("New Salary              : $" + newSalary);
        System.out.println("Net New Salary          : $" + (newSalary-newTax));

    }


    public static double tax(double salary, int workhours) {
        double tax =0;
        double totalsalary=salary+bonus(workhours);
        if ( totalsalary < 1000) {
            tax = 0;
        } else tax = totalsalary * 0.03;

        return tax;
    }

    public static int bonus(int workhours) {
        int bonus = 0;
        if (workhours > 40) {
            bonus = (workhours - 40) * 30;
        }
        return bonus;
    }

    public static double raiseSalary(int hireyear, double salary) {
        double raiseSalary = 0;
        if ((2021 - hireyear) < 10) {
            raiseSalary = salary * 0.05;
        } else if ((2021 - hireyear) > 9 && (2021 - hireyear) < 20) {
            raiseSalary = salary * 0.1;
        } else if ((2021 - hireyear) > 19) {
            raiseSalary = salary * 0.15;}


        return raiseSalary;
    }
}
