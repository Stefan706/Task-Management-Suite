package org.tucn.pt.business;

import org.tucn.pt.model.ComplexTask;
import org.tucn.pt.model.Employee;
import org.tucn.pt.model.Task;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManagement implements Serializable
{
    Map<Employee, List<Task>> map=new HashMap<>();
    public void addEmployee(Employee e)
    {
        map.putIfAbsent(e,new ArrayList<>());
    }
    public boolean assignTaskToEmployee(int idEmployee,Task task)
    {
        for(Employee e:map.keySet())
        {
            if(e.getIdEmployee()==idEmployee)
            {
                map.get(e).add(task);
                return true;
            }
        }
        System.out.println("Employee not found");
        return false;
    }
    public int calculateEmployeeWorkDuration(int idEmployee)
    {
        for(Employee e:map.keySet()) {
            if (e.getIdEmployee() == idEmployee) {
                int total = 0;
                for (Task t : map.get(e)) {
                    if (t.getStatusTask().equals("Completed")) {
                        total += t.estimateDuration();
                    }
                }
                return total;
            }
        }
        return 0;
    }
    private Task findTaskRecursive(List<Task> taskList, int targetId) {
        for (Task t : taskList) {
            if (t.getId() == targetId) return t;
            if (t instanceof ComplexTask) {
                Task found = findTaskRecursive(((ComplexTask) t).getTasks(), targetId);
                if (found != null) return found;
            }
        }
        return null;
    }
    public void addSubTaskToComplex(int employeeId, int parentTaskId, Task subTask) throws Exception {
        for (Employee e : map.keySet()) {
            if (e.getIdEmployee() == employeeId) {
                Task parent = findTaskRecursive(map.get(e), parentTaskId);
                if (parent != null) {
                    if (parent instanceof ComplexTask) {
                        ((ComplexTask) parent).addTask(subTask);
                        return;
                    } else {
                        throw new Exception("Parent class not complex");
                    }
                }
            }
        }
        throw new Exception("Parent not found");
    }
    public void modifyTaskStatus(int employeeId, int taskId) {
        for (Employee e : map.keySet()) {
            if (e.getIdEmployee() == employeeId) {
                Task t = findTaskRecursive(map.get(e), taskId);
                if (t != null) {
                    if (t.getStatusTask().equals("Uncompleted")) {
                        t.setStatusTask("Completed");
                    } else {
                        t.setStatusTask("Uncompleted");
                    }
                    return;
                }
            }
        }
    }
    public Map<Employee,List<Task>> getMap()
    {
        return map;
    }
}
