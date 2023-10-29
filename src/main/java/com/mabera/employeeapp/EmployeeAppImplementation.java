package com.mabera.employeeapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mabera.developer.Developer;
import com.mabera.employee.Employee;
import com.mabera.employee.EmployeeInterfaceImpl;
import com.mabera.manager.Manager;
import com.mabera.supervisor.Supervisor;
import com.mabera.task.Task;


public class EmployeeAppImplementation{
    public  Scanner myScanner = new Scanner(System.in);
    public  List<Task> thisTasks = new ArrayList<>();
    public  List<Employee> thisDevelopers = new ArrayList<>();
    public  List<Employee> thisManagers = new ArrayList<>();
    public  List<Employee> thisSupervisors =  new ArrayList<>();
    public static void main(String[] args) {
        EmployeeAppImplementation appImpl = new EmployeeAppImplementation();
        appImpl.showMenu();
    }

    private  void showMenu() {
        System.out.println("******************************");
        System.out.println("Employee management system");
        System.out.println("******************************");
        System.out.println("");
        System.out.println("1. Manager");
        System.out.println("2. Supervisor");
        System.out.println("3. Developer");
        System.out.print("Choose an option [1-3] :");

        int chosenInput= myScanner.nextInt();
        takeInput(chosenInput);
       
    }

    private  void takeInput(int chosenInput) {
        if((chosenInput) == 1){
                showManager();
            }else if((chosenInput) ==2){
                showSupervisor();
            }else if((chosenInput) == 3){
                showDeveloper();  
            }else{
                System.out.println("*************************************");
                System.out.println("Invalid choice, choose another option");
                showMenu();
            }
    }

    private  void showManager() {
        System.out.println("******************************");
        System.out.println("Manager panel");
        System.out.println("******************************");
        System.out.println("");
        System.out.println("1. Create Manager");
        System.out.println("2. Create tasks");
        System.out.println("3. Add Employee");
        System.out.println("4. View Employees");
        System.out.println("5. Main Menu");
        System.out.print("Choose an option [1-5] :");
        int chosenInput = myScanner.nextInt();
        myScanner.nextLine();
        managerOperations(chosenInput);
    }

    private  void managerOperations(int chosenInput) {
        if(chosenInput ==1){
            // lets create a manager
            createManager();
        }else if(chosenInput ==2){
            createTasks();
        }else if(chosenInput ==3){
            addEmployee();
        }else if(chosenInput ==4){
            showEmployees();
        }else if(chosenInput ==5){
            showMenu();
        }else{
            System.out.println("");
            System.out.println("Kindly select a valid choice [1-3]");
            System.out.println("");
            showManager();
        }
    }
    private void showEmployees() {
        for(Employee manager :thisManagers){
            System.out.println(manager.toString());
        }
        for(Employee developer :thisDevelopers){
            System.out.println(developer.toString());
        }
        for(Employee supervisor :thisSupervisors){
            System.out.println(supervisor.toString());
        }              
    }

    private  void addEmployee() {
        EmployeeInterfaceImpl impl = new EmployeeInterfaceImpl();
        System.out.println("");
        System.out.print("Kindly enter the rank of the employee you want to create [manager/supervisor/developer]: ");
        String rank = myScanner.nextLine();
        impl.createEmployee(rank);      
        showManager();  
    }

    private  void createTasks() {
        Manager manager = new Manager();
        // get the devs to assign the tasks to 
        
        System.out.println("");
        System.out.print("Enter the employee ID of the assignee of this task : ");
        int employeeID = myScanner.nextInt();
        myScanner.nextLine();
        System.out.println("");
        
        if(thisDevelopers.size()>0){
            
            for(Employee developer : thisDevelopers){
                if(developer.getEmployeeID() == employeeID){
                    Task task = manager.createTask(developer);
                    // assign the task to this employee
                    thisTasks.add(task);
                }else{
                    System.out.println("This employee does not exist, kindly create one");
                    showDeveloper();
                }
            }      
        }else{
            // create some devs first
            System.out.println("");
            System.out.println("Kindly create some developers first");
            System.out.println("");
            showDeveloper();
        }
        
        
    }
    private  Employee employeeInterfaceFunction(String rank){
        EmployeeInterfaceImpl impl = new EmployeeInterfaceImpl();
        return impl.createEmployee(rank);
    }
    private  void createManager() {
        System.out.print("How many managers do you want to create? ");
        int noManagers =myScanner.nextInt();
        for(int i =0 ;i<noManagers;i++){
            Employee manager = employeeInterfaceFunction("manager");
            System.out.println(manager.toString());
            thisManagers.add(i,manager);
            System.out.println("You have successfully created a manager");
        }        
        showManager();
    }

    private  void showSupervisor() {
        System.out.println("******************************");
        System.out.println("Supervisor's panel");
        System.out.println("******************************");
        System.out.println("");
        System.out.println("1. Create Supervisor");
        System.out.println("2. Check Task Status");
        System.out.println("3. Report Task Delay ");
        System.out.println("4. Main Menu");
        System.out.print("Choose an option [1-5]: ");
        int chosenInput = myScanner.nextInt();
        myScanner.nextLine();
        supervisorOperations(chosenInput);
    }

    private  void supervisorOperations(int chosenInput) {
        if(chosenInput ==1){
            // lets create a supervisor
            createSupervisor();
        }else if(chosenInput ==2){
            checkTaskStatus();
        }else if(chosenInput ==3){
            showDelayedTasks();
        }else if(chosenInput ==4){
            showMenu();
        }else{
            System.out.println("*************************************");
            System.out.println("Invalid choice, choose another option");
            showDeveloper();
        }
    }

    private  void showDelayedTasks() {
        for(Task task :thisTasks){
            if(task.getTaskDueDate().isAfter(LocalDate.now())){
                task.toString();
            }
        }
    }

    private  void checkTaskStatus() {
        Supervisor supervisor = new Supervisor();
        System.out.print("Kindly enter the task ID of the task you want checked out: ");
        int taskID = myScanner.nextInt();
        myScanner.nextLine();
        for(Task task : thisTasks){
            if(task.getTaskID() == taskID){
                System.out.println("The task status is "+supervisor.checkTaskStatus(task));
            }
        }
    }

    private  void createSupervisor() {
        thisSupervisors.add(employeeInterfaceFunction("supervisor"));
        System.out.println("The Supervisor has been created successfully");
    }

    private  void showDeveloper() {
        System.out.println("******************************");
        System.out.println("Developer's panel");
        System.out.println("******************************");
        System.out.println("");
        System.out.println("1. Create Developer");
        System.out.println("2. Complete Tasks");
        System.out.println("3. View Tasks");
        System.out.println("4. Main Menu");
        System.out.print("Choose an option [1-3]: ");
        int chosenInput = myScanner.nextInt();
        myScanner.nextLine();
        developerOperations(chosenInput);
    }

    private  void developerOperations(int chosenInput) {
        if(chosenInput ==1){
            // lets create a developer
            createDeveloper();
        }else if(chosenInput ==2){
            completeTask();
        }else if(chosenInput ==3){
            viewTasksDeveloper();
        }
        else if(chosenInput ==4){
            showMenu();
        }else{
            System.out.println("*************************************");
            System.out.println("Invalid choice, choose another option");
            showDeveloper();
        }
    }

    private  void viewTasksDeveloper() {
        System.out.print("Kindly enter your employee ID: ");
        int employeeID = myScanner.nextInt();
        myScanner.nextLine();
        if(thisTasks.size()>0){
            for(Task task : thisTasks){
                if(task.getAssginee().getEmployeeID() == employeeID){
                    // print out the different tasks of that employee
                    System.out.println(task.toString());
                }else{
                    System.out.println("This employee has no task assigned to them");
                }
            }
        }else{
            System.out.println("Kindly create some tasks .....");
            showManager();
        }

    }

    private  void completeTask() {
        Developer developer = new Developer();
        // first establish that the task is available
        Task thisTask = developer.getTask();
        if(thisTask != null){
            developer.completeTask(thisTask);
            System.out.println("Task completed successfully !");
        }else{
            System.out.println("Kindly add a task through the manager's panel");
            showMenu();
        }
        
    }

    private  void createDeveloper() {
        thisDevelopers.add(employeeInterfaceFunction("developer"));
        System.out.println("************************************");        
        showDeveloper();
    }
}
