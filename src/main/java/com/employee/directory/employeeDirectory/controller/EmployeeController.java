package com.employee.directory.employeeDirectory.controller;

import com.employee.directory.employeeDirectory.entity.Employee;
import com.employee.directory.employeeDirectory.utils.Language;
import com.employee.directory.employeeDirectory.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/employees")
@PropertySource("classpath:bar.properties")
public class EmployeeController {
    @Value( "${button.save}" )
    private String save;

    @Value( "${employee.save}" )
    private String saveEmployee;

    @Value( "${back.list.employees}" )
    private  String backListEmployees;

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String employeeList(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "employee/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        getTranslationForEditPage(model);
        return "employee/employee-form";
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees/list";
    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        getTranslationForEditPage(model);
        return "employee/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id, Model model) {
        employeeService.deleteById(id);
        return "redirect:list";
    }

    private void getTranslationForEditPage(Model model) {
        model.addAttribute("saveEmployee", saveEmployee);
        model.addAttribute("saveButton", save);
        model.addAttribute("backList", backListEmployees);
    }
}
