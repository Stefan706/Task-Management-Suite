package org.tucn.pt.GUI;

import javax.swing.*;

public class View extends JFrame
{
    private JTextField employeeId;
    private JTextField taskId;
    private JTextField startHour;
    private JTextField endHour;
    private JButton assignSimple;
    private JButton assignComplex;
    private JButton modify;
    private JButton calculate;
    private JTextArea display;
    private JTextField employeeName;
    private JButton addEmployee;
    private JButton viewData;
    private JButton filter;
    private JButton statistics;
    private JTextField parentTaskId;
    public View()
    {
        setTitle("Employee Management App");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel employeeIdLabel=new JLabel("Employee ID");
        employeeIdLabel.setBounds(20,20,100,25);
        add(employeeIdLabel);

        employeeId=new JTextField();
        employeeId.setBounds(130,20,100,25);
        add(employeeId);

        JLabel employeeNameLabel=new JLabel("Employee Name:");
        employeeNameLabel.setBounds(250,20,100,25);
        add(employeeNameLabel);

        employeeName = new JTextField();
        employeeName.setBounds(360,20,150,25);
        add(employeeName);

        JLabel taskLabel=new JLabel("Task ID");
        taskLabel.setBounds(20,60,100,25);
        add(taskLabel);

        taskId=new JTextField();
        taskId.setBounds(130,60,100,25);
        add(taskId);

        JLabel parentTaskLabel = new JLabel("Parent Task:");
        parentTaskLabel.setBounds(520, 20, 80, 25);
        add(parentTaskLabel);

        parentTaskId = new JTextField();
        parentTaskId.setBounds(600, 20, 60, 25);
        add(parentTaskId);

        JLabel startLabel=new JLabel("Start Hour:");
        startLabel.setBounds(250,60,100,25);
        add(startLabel);

        startHour= new JTextField();
        startHour.setBounds(360,60,80,25);
        add(startHour);

        JLabel endLabel=new JLabel("End Hour:");
        endLabel.setBounds(460,60,100,25);
        add(endLabel);

        endHour= new JTextField();
        endHour.setBounds(550,60,80,25);
        add(endHour);

        addEmployee=new JButton("Add Employee");
        addEmployee.setBounds(20,100,150,30);
        add(addEmployee);

        assignSimple=new JButton("Assign Simple");
        assignSimple.setBounds(180,100,150,30);
        add(assignSimple);

        assignComplex=new JButton("Assign Complex");
        assignComplex.setBounds(340,100,150,30);
        add(assignComplex);

        modify=new JButton("Modify Status");
        modify.setBounds(20,140,150,30);
        add(modify);

        calculate=new JButton("Calculate Work");
        calculate.setBounds(180,140,150,30);
        add(calculate);

        viewData=new JButton("View Data");
        viewData.setBounds(340,140,150,30);
        add(viewData);

        filter=new JButton("Filter > 40h");
        filter.setBounds(100,180,150,30);
        add(filter);

        statistics=new JButton("Task Stats");
        statistics.setBounds(260,180,150,30);
        add(statistics);

        display=new JTextArea();
        display.setEditable(false);
        JScrollPane scroll=new JScrollPane(display);
        scroll.setBounds(20,230,640,200);
        add(scroll);

        setVisible(true);
    }

    public JTextField getEmployeeId() {
        return employeeId;
    }

    public JButton getStatistics() {
        return statistics;
    }

    public JButton getFilter() {
        return filter;
    }

    public JButton getViewData() {
        return viewData;
    }

    public JButton getAddEmployee() {
        return addEmployee;
    }

    public JTextField getEmployeeName() {
        return employeeName;
    }

    public JTextArea getDisplay() {
        return display;
    }

    public JButton getCalculate() {
        return calculate;
    }
    public JTextField getParentTaskId()
    {
        return parentTaskId;
    }

    public JButton getModify() {
        return modify;
    }

    public JButton getAssignComplex() {
        return assignComplex;
    }

    public JButton getAssignSimple() {
        return assignSimple;
    }

    public JTextField getEndHour() {
        return endHour;
    }

    public JTextField getStartHour() {
        return startHour;
    }

    public JTextField getTaskId() {
        return taskId;
    }
}