package organization.components;

import organization.Component;

import java.util.ArrayList;
import java.util.List;

public class Organization extends Component {
    private List<Component> children = new ArrayList<>();

    public Organization(String name) {
        super(name);
    }

    @Override
    public void printData(int data) {
        String pad = " ".repeat(data * 4);
        String insidePad = pad + " ".repeat(4);
        System.out.println(pad + "<Organization>");
        System.out.println(insidePad + "<Name>" + name + "</Name>");
        for (Component child : children) {
            child.printData(data + 1);
        }
        System.out.println(pad + "</Organization>");
    }

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        for (Component child : children) {
            if (child == component) {
                children.remove(component);
                return;
            }
            if (child instanceof Department) {
                child.remove(component);
            }
        }
    }

    @Override
    public Component getChild(int index) {
        return children.get(index);
    }

    public void printTotalSalary() {
        double totalSalary = 0;
        for (Component child : children) {
            if (child instanceof Employee) {
                totalSalary += ((Employee) child).salary;
            } else if (child instanceof Department) {
                totalSalary += ((Department) child).getTotalSalary();
            }
        }
        System.out.println("Total Salary: " + totalSalary + "$ annually");
    }
}
