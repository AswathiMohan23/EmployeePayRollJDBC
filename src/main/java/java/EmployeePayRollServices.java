package java;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.EmployeePayrollEnum.FILE_IO;


public class EmployeePayRollServices {
    private List<EmployeePayrollData> employeePayrollList;
    public static String PAYROLL_FILE_NAME = "payrollFile.txt";


    public EmployeePayRollServices(List<EmployeePayrollData> employeePayrollList) {
        this.employeePayrollList = employeePayrollList;
    }

    /**
     *
     * @param employeePayrollList :
     */
    public EmployeePayRollServices(ArrayList<EmployeePayrollData> employeePayrollList) {
        this.employeePayrollList=employeePayrollList;
    }


    public static void main(String[] args) {
        System.out.println("Welcome to Employee Pay roll Services");
        ArrayList<EmployeePayrollData>employeePayrollList=new ArrayList<EmployeePayrollData>();
        EmployeePayRollServices employeePayRollServices =new EmployeePayRollServices(employeePayrollList);
        Scanner sc=new Scanner(System.in);
        employeePayRollServices.readEmployeePayrollData(sc);
        employeePayRollServices.writeEmployeePayrollData(FILE_IO);
    }


    private EmployeePayrollData getEmployeePayrollData(String name){
        return this.employeePayrollList.stream()
                .filter(employeePayrollDataItem -> employeePayrollDataItem.getName().equals(name))
                .findFirst().orElse(null);
    }

    void writeEmployeePayrollData(EmployeePayrollEnum fileIo) {
        if(fileIo.equals(EmployeePayrollEnum.CONSOLE_IO))
             System.out.println("\nWriting employee payRoll data o console\n"+employeePayrollList);
        else if(fileIo.equals(FILE_IO))
            new EmployeePayrollFileIOService().writeData(employeePayrollList);
    }

    private void readEmployeePayrollData(Scanner sc) {
        System.out.println("Enter employee Name : ");
        String name=sc.next();
        System.out.println("Enter employee id : ");
        int id =sc.nextInt();
        System.out.println("Enter employee Salary : ");
        double salary=sc.nextDouble();
        employeePayrollList.add(new EmployeePayrollData(name,id,salary));
    }

    public void printData(EmployeePayrollEnum fileIo){
        try {
            Files.lines(new File("payrollFile.txt").toPath())
                    .forEach(System.out::println);
        }catch (IOException e){}
    }

    public long countEntries(EmployeePayrollEnum fileIo){
        long entries=0;
        try {
            entries=Files.lines(new File("payrollFile.txt").toPath())
                    .count();
        }catch (IOException e){}
        return entries;
    }


}

