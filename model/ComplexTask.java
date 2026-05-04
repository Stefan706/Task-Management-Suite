package org.tucn.pt.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public non-sealed class ComplexTask extends Task implements Serializable
{
    List<Task> tasks=new ArrayList<>();
    public ComplexTask(int idTask, String statusTask)
    {
        super(idTask,statusTask);
    }
    public void addTask(Task t)
    {
        for(Task task:tasks)
        {
            if(task.getId()==t.getId())
            {
                System.out.println("Error: Duplicate Id");
                return;
            }
        }
        tasks.add(t);
        System.out.println("Task added");
    }
    public void deleteTask(Task task)
    {
        tasks.remove(task);
    }
    @Override
    public int estimateDuration()
    {
        int total=0;
        for(Task t:tasks)
        {
            total+=t.estimateDuration();
        }
        return total;
    }
    public List<Task> getTasks() {
        return tasks;
    }
    @Override
    public void setStatusTask(String statusTask) {
        super.setStatusTask(statusTask);
        for (Task t : tasks) {
            t.setStatusTask(statusTask);
        }
    }
}
