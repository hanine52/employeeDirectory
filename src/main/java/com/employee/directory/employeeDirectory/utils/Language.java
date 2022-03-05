package com.employee.directory.employeeDirectory.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:bar.properties")
public class Language {

    @Value( "${button.save}" )
    private String save;

    @Value( "${employee.save}" )
    private String saveEmployee;

    @Value( "${back.list.employees}" )
    private  String BackListEmployees;

    public String getSave() {
        return save;
    }

    public String getSaveEmployee() {
        return saveEmployee;
    }

    public String getBackListEmployees() {
        return BackListEmployees;
    }
}
