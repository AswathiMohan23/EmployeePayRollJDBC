package java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class EmployeePayrollData {
    private String name;
    private int id;
    private double salary;
    public LocalDate start;

    public EmployeePayrollData( String name,int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public EmployeePayrollData( int id,String name, double salary, LocalDate start) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.start = start;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeePayrollData{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }

    @Override
    public  boolean equals(Object o){
        if(this==o) return true;
        if(o==null || getClass()!=o.getClass()) return false;
        EmployeePayrollData that =(EmployeePayrollData) o;
        return id == that.id && Double.compare(that.salary,salary)== 0 &&
                name.equals(that.name);
    }


}
