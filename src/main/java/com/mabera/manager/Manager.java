package com.mabera.manager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.mabera.employee.Employee;
import com.mabera.task.Task;

public class Manager extends Employee implements ManagerInterface{
    public Scanner myScanner = new Scanner(System.in);
    public  Manager(String firstname, String lastname, int employeeID, String employeeRank){
        super(firstname, lastname, employeeID, employeeRank);
    }
    public Manager(){
        super();
    }
    @Override
    public Task createTask(Employee employee) {
        // set up a date time formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // TODO Auto-generated method stub
        System.out.println("*************************************************");
        System.out.println("Welcome to the task assignment platform");
        System.out.print("Enter the task ID: ");
        int taskID = myScanner.nextInt();
        myScanner.nextLine();
        System.out.print("Enter the task description: ");
        String taskDescription = myScanner.nextLine();
        System.out.print("Enter the task due date[yyyy-mm-dd]: ");
        LocalDate duedate = LocalDate.parse(myScanner.nextLine(),formatter);

        Task task = new Task(taskID,taskDescription,false,LocalDate.now(),employee,duedate);

        System.out.println("************************************");
        System.out.println("You have successfully created a task");
        return task;                
    }
    
    
}
