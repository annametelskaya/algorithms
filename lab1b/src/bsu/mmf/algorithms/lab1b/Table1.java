package bsu.mmf.algorithms.lab1b;

public class Table1 {
    public String name;
    public int salary;

    @Override
    public String toString() {
        return "Имя: " + name + ", зарплата: " + salary + "\n";
    }

    public Table1(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
