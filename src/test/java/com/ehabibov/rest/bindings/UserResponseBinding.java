package com.ehabibov.rest.bindings;

import java.io.Serializable;

public class UserResponseBinding implements Serializable {

    private String userName;
    private String userRole;
    private String status;
    private String employeeName;
    private String employeeId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return String.format("UserResponseBinding{userName=%s, userRole=%s, status=%s, employeeName=%s, employeeId=%s",
                userName, userRole, status, employeeName, employeeId);
    }
}