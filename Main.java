package org.tucn.pt;

import org.tucn.pt.GUI.Controller;
import org.tucn.pt.GUI.View;
import org.tucn.pt.business.TaskManagement;
import org.tucn.pt.business.Utility;
import org.tucn.pt.model.ComplexTask;
import org.tucn.pt.model.Employee;
import org.tucn.pt.model.Serialization;
import org.tucn.pt.model.SimpleTask;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main
{
    public static void main(String[] args)
    {
        TaskManagement tm= Serialization.load();
        View view = new View();
        Controller controller = new Controller(view, tm);
    }
}
