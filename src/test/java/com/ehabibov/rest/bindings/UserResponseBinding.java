package com.ehabibov.rest.bindings;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserResponseBinding implements Serializable {
    private static final long serialVersionUID = 3295741575613126271L;

    private String userName;
    private String userRole;
    private String status;
    private String employeeName;
    private String employeeId;

    @Override
    public String toString() {
        return String.format("UserResponseBinding{userName=%s, userRole=%s, status=%s, employeeName=%s, employeeId=%s",
                userName, userRole, status, employeeName, employeeId);
    }
}