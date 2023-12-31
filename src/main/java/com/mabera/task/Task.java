package com.mabera.task;

import java.time.LocalDate;

import com.mabera.employee.Employee;

public class Task {
    private int taskID;
    private String taskDescription;
    private boolean taskDone;
    private LocalDate taskStartedDate;
    private LocalDate taskDueDate;
    
    private Employee assginee;
    
    public Task(int taskID, String taskDescription, boolean taskDone, LocalDate taskStartedDate, Employee assignee,LocalDate taskDueDate) {
        this.taskID = taskID;
        this.taskDescription = taskDescription;
        this.taskDone = taskDone;
        this.taskStartedDate = taskStartedDate;
        this.assginee =assignee;
        this.taskDueDate=taskDueDate;
    }
    public Task() {
    }
    public int getTaskID() {
        return taskID;
    }
    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }
    public String getTaskDescription() {
        return taskDescription;
    }
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
    public boolean isTaskDone() {
        return taskDone;
    }
    public void setTaskDone(boolean taskDone) {
        this.taskDone = taskDone;
    }
    public LocalDate getTaskStartedDate() {
        return taskStartedDate;
    }
    public void setTaskStartedDate(LocalDate taskStartedDate) {
        this.taskStartedDate = taskStartedDate;
    }
    public Employee getAssginee() {
        return assginee;
    }
    public void setAssginee(Employee assginee) {
        this.assginee = assginee;
    }
    public LocalDate getTaskDueDate() {
        return taskDueDate;
    }
    public void setTaskDueDate(LocalDate taskDueDate) {
        this.taskDueDate = taskDueDate;
    }
    @Override
    public String toString() {
        return "Task [taskID=" + taskID + ", taskDescription=" + taskDescription + ", taskDone=" + taskDone
                + ", taskStartedDate=" + taskStartedDate + "]";
    }
    
    
    
}
