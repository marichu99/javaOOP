package com.mabera.supervisor;

import com.mabera.employee.Employee;
import com.mabera.task.Task;

public interface SupervisorInterface {
    boolean checkTaskStatus(Task task);
    Employee reportTaskDelay(int employeeID);
}
