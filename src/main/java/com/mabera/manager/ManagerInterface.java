package com.mabera.manager;

import com.mabera.employee.Employee;
import com.mabera.task.Task;

public interface ManagerInterface {
    Task createTask(Employee employee);
}
