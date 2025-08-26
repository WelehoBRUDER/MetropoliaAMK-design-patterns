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

        org.add(management);
        org.add(teachers);
        management.add(students);
        teachers.add(sales);

        Employee alice = new Employee("Alice", 90000);
        Employee bob = new Employee("Bob", 60000);
        Employee charlie = new Employee("Charlie", 50000);
        Employee dave = new Employee("Dave", 40000);
        Employee eve = new Employee("Eve", 30000);
        Employee frank = new Employee("Frank", 20000);
        Employee grace = new Employee("Grace", 10000);
        Employee heidi = new Employee("Heidi", 5000);
        Employee ivan = new Employee("Ivan", 3000);

        management.add(alice);
        management.add(bob);
        teachers.add(charlie);
        teachers.add(dave);
        students.add(eve);
        students.add(frank);
        sales.add(grace);
        sales.add(heidi);
        sales.add(ivan);

        org.printTotalSalary();
    }
}