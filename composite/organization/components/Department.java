package organization.components;

import organization.Component;

import java.util.ArrayList;
import java.util.List;

public class Department extends Component {
    private List<Component> children = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public void printData() {
        System.out.println("Department: " + name);
    }

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public Component getChild(int index) {
        return children.get(index);
    }

    public double getTotalSalary() {
        double totalSalary = 0;
        for (Component child : children) {
            if (child instanceof Employee) {
                totalSalary += ((Employee) child).salary;
            } else if (child instanceof Department) {
                totalSalary += ((Department) child).getTotalSalary();
            }
        }
        return totalSalary;
    }
}
