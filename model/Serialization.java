        package org.tucn.pt.model;

        import org.tucn.pt.business.TaskManagement;

        import java.io.*;

        public class Serialization
        {
            private static final String FILE_NAME = "tasks.ser";
            public static void save(TaskManagement tm)
            {
                try
                {
                    ObjectOutputStream out = new ObjectOutputStream(
                            new FileOutputStream(FILE_NAME));

                    out.writeObject(tm);
                    out.close();

                    System.out.println("Data saved successfully");
                }
                catch(IOException e)
                {
                    System.out.println("Error saving data");
                    e.printStackTrace();
                }
            }
            public static TaskManagement load()
            {
                try
                {
                    ObjectInputStream in = new ObjectInputStream(
                            new FileInputStream(FILE_NAME));

                    TaskManagement tm = (TaskManagement) in.readObject();
                    in.close();

                    System.out.println("Data loaded successfully");
                    return tm;
                }
                catch(Exception e)
                {
                    System.out.println("No saved data found, starting new system");
                    return new TaskManagement();
                }
            }
        }
