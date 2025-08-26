package organization.components;

import organization.Component;

public class Employee extends Component {
    protected double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public void printData(int tabs) {
        String pad = " ".repeat(tabs * 4);
        String insidePad = pad + " ".repeat(4);
        System.out.println(pad + "<Employee>");
        System.out.println(insidePad + "<Name>" + name + "</Name>");
        System.out.println(insidePad + "<Salary>" + salary + "</Salary>");
        System.out.println(pad + "</Employee>");
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException("Cannot add to an employee");
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException("Cannot remove from an employee");
    }

    @Override
    public Component getChild(int index) {
        throw new UnsupportedOperationException("Employee has no children");
    }
}
