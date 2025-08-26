package organization;

import organization.components.Department;
import organization.components.Employee;
import organization.components.Organization;

public class Main {
    public static void main(String[] args) {
        Organization org = new Organization("Not-A-Pyramid-Scheme");
        Department management = new Department("Management");
        Department students = new Department("Students");
        Department teachers = new Department("Teachers");
        Department sales = new Department("Sales");
        Department interns = new Department("Interns");

        org.add(management);
        org.add(teachers);
        management.add(students);
        teachers.add(sales);
        sales.add(interns);

        Employee markus = new Employee("Markus (CEO)", 25000);
        Employee alice = new Employee("Alice", 12000);
        Employee bob = new Employee("Bob", 9500);
        Employee charlie = new Employee("Charlie", 8000);
        Employee dave = new Employee("Dave", 8000);
        Employee eve = new Employee("Eve", 6000);
        Employee frank = new Employee("Frank", 6200);
        Employee grace = new Employee("Grace", 7500);
        Employee heidi = new Employee("Heidi", 7700);
        Employee ivan = new Employee("Ivan", 4900);
        Employee judy = new Employee("Judy", 1000);

        org.add(markus);
        management.add(alice);
        management.add(bob);
        teachers.add(charlie);
        teachers.add(dave);
        students.add(eve);
        students.add(frank);
        sales.add(grace);
        sales.add(heidi);
        sales.add(ivan);
        interns.add(judy);

        org.printData(0);

        org.printTotalSalary();

        org.remove(ivan);

        org.printTotalSalary();
    }
}