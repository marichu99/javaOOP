package com.mabera.employee;

import java.util.Scanner;

import com.mabera.developer.Developer;
import com.mabera.manager.Manager;
import com.mabera.supervisor.Supervisor;

public class EmployeeInterfaceImpl implements EmployeeInterface{
    public Scanner myScanner = new Scanner(System.in);
    @Override
    public Employee createEmployee(String rank) {
        // TODO Auto-generated method stub
        System.out.println("************************************");
        System.out.print("Enter your first name: ");
        String fName = myScanner.nextLine();
        System.out.print("Enter your last name: ");
        String lName = myScanner.nextLine();
        System.out.print("Kindly enter your Employee ID: ");
        int employeeID = myScanner.nextInt();
        
        
        if(rank == "manager"){
            System.out.println("The rank is "+rank);
             Employee employee = new Manager(fName,lName,employeeID,rank);       
             return employee;      
        }else if(rank =="supervisor"){
            Employee employee = new Supervisor(fName,lName,employeeID,rank);
            return employee;
        }else if( rank == "developer"){
             Employee employee = new Developer(fName,lName,employeeID,rank);
             return employee;
        }   
        return null;
    }
}
