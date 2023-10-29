package com.mabera.developer;

import com.mabera.employee.Employee;
import com.mabera.task.Task;

public interface DeveloperInterface {
    void completeTask(Task task);
    Task viewTasks(Employee employee);
    
}
