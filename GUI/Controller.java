package org.tucn.pt.GUI;

import org.tucn.pt.business.TaskManagement;
import org.tucn.pt.business.Utility;
import org.tucn.pt.model.ComplexTask;
import org.tucn.pt.model.Employee;
import org.tucn.pt.model.Serialization;
import org.tucn.pt.model.SimpleTask;
import org.tucn.pt.model.Task;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;

public class Controller
{
    private View view;
    private TaskManagement tm;

    public Controller(View view, TaskManagement tm)
    {
        this.view = view;
        this.tm = tm;

        view.getAddEmployee().addActionListener(e -> addEmployeeAction());
        view.getAssignSimple().addActionListener(e -> assignSimpleAction());
        view.getAssignComplex().addActionListener(e -> assignComplexAction());
        view.getModify().addActionListener(e -> modifyAction());
        view.getCalculate().addActionListener(e -> calculateAction());
        view.getViewData().addActionListener(e -> viewDataAction());
        view.getFilter().addActionListener(e -> filterAction());
        view.getStatistics().addActionListener(e -> statisticsAction());

        view.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                Serialization.save(tm);
            }
        });
    }

    private void addEmployeeAction()
    {
        try
        {
            int id = Integer.parseInt(view.getEmployeeId().getText());
            String name = view.getEmployeeName().getText();
            tm.addEmployee(new Employee(id,name));
            view.getDisplay().setText("Employee added");
        }
        catch (Exception ex)
        {
            view.getDisplay().setText("Error input");
        }
    }

    private void assignSimpleAction()
    {
        try {
            int empId = Integer.parseInt(view.getEmployeeId().getText());
            int taskId = Integer.parseInt(view.getTaskId().getText());
            int start = Integer.parseInt(view.getStartHour().getText());
            int end = Integer.parseInt(view.getEndHour().getText());

            SimpleTask st = new SimpleTask(taskId, "Uncompleted", start, end);
            String parentIdText = view.getParentTaskId().getText().trim();

            if (parentIdText.isEmpty()) {
                tm.assignTaskToEmployee(empId, st);
                view.getDisplay().setText("Simple task assigned directly to employee.");
            } else {
                int parentId = Integer.parseInt(parentIdText);
                tm.addSubTaskToComplex(empId, parentId, st);
                view.getDisplay().setText("Simple sub-task added to Complex Task " + parentId);
            }
        } catch (Exception ex) {
            view.getDisplay().setText("Error: " + ex.getMessage());
        }
    }

    private void assignComplexAction()
    {
        try {
            int empId = Integer.parseInt(view.getEmployeeId().getText());
            int taskId = Integer.parseInt(view.getTaskId().getText());

            ComplexTask ct = new ComplexTask(taskId, "Uncompleted");
            String parentIdText = view.getParentTaskId().getText().trim();

            if (parentIdText.isEmpty()) {
                tm.assignTaskToEmployee(empId, ct);
                view.getDisplay().setText("Complex task assigned directly to employee.");
            } else {
                int parentId = Integer.parseInt(parentIdText);
                tm.addSubTaskToComplex(empId, parentId, ct);
                view.getDisplay().setText("Complex sub-task added to Complex Task " + parentId);
            }
        } catch (Exception ex) {
            view.getDisplay().setText("Error: " + ex.getMessage());
        }
    }

    private void modifyAction()
    {
        try
        {
            int employeeId = Integer.parseInt(view.getEmployeeId().getText());
            int taskId = Integer.parseInt(view.getTaskId().getText());

            tm.modifyTaskStatus(employeeId, taskId);
            view.getDisplay().setText("Status modified");
        }
        catch (Exception ex)
        {
            view.getDisplay().setText("Error");
        }
    }

    private void calculateAction()
    {
        try
        {
            int employeeId = Integer.parseInt(view.getEmployeeId().getText());
            int result = tm.calculateEmployeeWorkDuration(employeeId);
            view.getDisplay().setText("Total: " + result);
        }
        catch (Exception ex)
        {
            view.getDisplay().setText("Error");
        }
    }

    private void viewDataAction()
    {
        StringBuilder sb = new StringBuilder();
        for(Employee e: tm.getMap().keySet())
        {
            sb.append("Employee: ").append(e.getName()).append("\n");
            for(Task t: tm.getMap().get(e))
            {
                sb.append("  Task ID: ").append(t.getIdTask())
                        .append(" Status: ").append(t.getStatusTask()).append("\n");
            }
        }
        view.getDisplay().setText(sb.toString());
    }

    private void filterAction()
    {
        String result = Utility.filterEmployees(tm.getMap());
        view.getDisplay().setText(result);
    }

    private void statisticsAction()
    {
        Map<String, Map<String,Integer>> stats = Utility.taskStatistics(tm.getMap());
        StringBuilder sb = new StringBuilder();
        for(String name: stats.keySet())
        {
            sb.append(name).append(": ")
                    .append("Completed=").append(stats.get(name).get("Completed"))
                    .append(" Incompleted=").append(stats.get(name).get("Incompleted"))
                    .append("\n");
        }
        view.getDisplay().setText(sb.toString());
    }
}