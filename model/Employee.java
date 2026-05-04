package org.tucn.pt.model;

import java.io.Serializable;

public class Employee implements Serializable
{
    protected int idEmployee;
    protected String name;
    public Employee(int idEmployee, String name)
    {
        this.idEmployee=idEmployee;
        this.name=name;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return idEmployee == employee.idEmployee;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(idEmployee);
    }
}

