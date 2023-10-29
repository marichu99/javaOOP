package com.mabera.developer;

import com.mabera.employee.Employee;
import com.mabera.task.Task;

public class Developer extends Employee implements DeveloperInterface{
    public Developer(String firstname, String lastname, int employeeID, String employeeRank) {
        super(firstname, lastname, employeeID, employeeRank);
    }
    public Developer(){
        super();
    }
  
    @Override
    public void completeTask(Task task) {
        // TODO Auto-generated method stub
        task.setTaskDone(true);        
    }

    @Override
    public Task viewTasks(Employee employee) {
        // TODO Auto-generated method stub
        return employee.getTask();
        
    }
        
}
