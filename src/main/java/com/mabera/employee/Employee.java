package com.mabera.employee;

import com.mabera.task.Task;

public class Employee {
    private String employeeFirstName;
    private String employeeLastName;
    private int employeeID;
    private String employeeRank;
    private Task task;

    
    
    public Employee(String employeeFirstName, String employeeLastName, int employeeID, String employeeRank) {
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeeID = employeeID;
        this.employeeRank = employeeRank;
    }
    

    public Employee() {
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }
    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }
    public String getEmployeeLastName() {
        return employeeLastName;
    }
    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }
    public int getEmployeeID() {
        return employeeID;
    }
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    public String getEmployeeRank() {
        return employeeRank;
    }
    public void setEmployeeRank(String employeeRank) {
        this.employeeRank = employeeRank;
    }
    
    @Override
    public String toString() {
        return "Employee [employeeFirstName=" + employeeFirstName + ", employeeLastName=" + employeeLastName
                + ", employeeID=" + employeeID + ", employeeRank=" + employeeRank + "]";
    }


    public Task getTask() {
        return task;
    }


    public void setTask(Task task) {
        this.task = task;
    }   
    
}
