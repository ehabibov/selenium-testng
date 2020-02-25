package com.ehabibov.entities;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

@Data
@Builder
@FieldNameConstants
public class SystemUser {

    private String userName;
    private String userRole;
    private String employeeName;
    private String status;
    private String password;
}