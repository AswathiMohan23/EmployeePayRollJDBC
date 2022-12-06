package java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EmployeePayrollFileIOService {
    public String PAYROLL_FILE_NAME = "payrollFile.txt";

    public void writeData(List<EmployeePayrollData> employeePayrollDataList){
        StringBuffer empBuffer=new StringBuffer();
        employeePayrollDataList.forEach(employee -> {
            String employeeDataString =employee.toString().concat("\n");
            empBuffer.append(employeeDataString);
        });
        try {
            Files.write(Paths.get(PAYROLL_FILE_NAME),empBuffer.toString().getBytes());
        }catch (IOException e){}
    }


}
