package com.mabera.supervisor;

import com.mabera.employee.Employee;
import com.mabera.manager.Manager;
import com.mabera.task.Task;

public class Supervisor extends Manager implements SupervisorInterface{

    public Supervisor(String firstname, String lastname, int employeeID, String employeeRank) {
        super(firstname, lastname, employeeID, employeeRank);
        //TODO Auto-generated constructor stub
    }
    public Supervisor(){
        super();
    }

    @Override
    public boolean checkTaskStatus(Task task) {
        // TODO Auto-generated method stub
        
        return task.isTaskDone();
    }

    @Override
    public Employee reportTaskDelay(int employeeID) {
        // TODO Auto-generated method stub
        
        return null;
    }

}
