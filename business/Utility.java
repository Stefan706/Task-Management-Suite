    package org.tucn.pt.business;

    import org.tucn.pt.model.Employee;
    import org.tucn.pt.model.Task;

    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

    public class Utility
    {
        public static String filterEmployees(Map<Employee, List<Task>> map)
        {
            StringBuilder result = new StringBuilder();
            Map<String,Integer> duration=new HashMap<>();
            for(Employee e:map.keySet()) {
                int total = 0;
                for (Task t : map.get(e)) {
                    if (t.getStatusTask().equals("Completed")) {
                        total += t.estimateDuration();
                    }
                }
                if (total > 40) {
                    duration.put(e.getName(), total);
                }
            }
            duration.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue())
                    .forEach(e -> result.append(e.getKey()).append("\n"));

            return result.toString();
        }
        public static Map<String, Map<String,Integer>>taskStatistics(
                Map<Employee,List<Task>>map)
        {
            Map<String,Map<String,Integer>> result =new HashMap<>();
            for(Employee e: map.keySet())
            {
                int completed=0;
                int incompleted=0;
                for(Task t: map.get(e))
                {
                    if(t.getStatusTask().equals("Completed"))
                    {
                        completed++;
                    }
                    else
                    {
                        incompleted++;
                    }
                }
                Map<String,Integer> stats=new HashMap<>();
                stats.put("Completed",completed);
                stats.put("Incompleted",incompleted);
                result.put(e.getName(),stats);
            }
            return result;
        }
    }
