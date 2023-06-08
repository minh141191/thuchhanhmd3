package com.example.thuchanhm3.service;

import com.example.thuchanhm3.dao.DepartmentDAO;
import com.example.thuchanhm3.dao.EmployeeDAO;
import com.example.thuchanhm3.model.Department;
import com.example.thuchanhm3.model.Employee;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class EmployeeService {

    private final EmployeeDAO employeeDAO;
    private static EmployeeService employeeService;

    private EmployeeService() {
        employeeDAO = new EmployeeDAO();

    }

    public static EmployeeService getInstance() {
        if (employeeService == null) {
            employeeService = new EmployeeService();
        }
        return employeeService;
    }

    public List<Employee> getEmployee() {
        return EmployeeDAO.findAll();
    }


    public void save(HttpServletRequest request) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone_number = request.getParameter("phone_number");
        double salary = Double.parseDouble(request.getParameter("salary"));
        int departmentId = Integer.parseInt(request.getParameter("department"));
        Department department = DepartmentDAO.getInstance().findById(departmentId);
        if (id != null) {
            int idUpdate = Integer.parseInt(id);
            employeeDAO.updateEmployee(new Employee(idUpdate, name, email, address, phone_number, salary, department));
        } else {
            employeeDAO.addEmployee(new Employee(name, email, address, phone_number, salary, department));
        }
    }

    public void deleteById(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeDAO.deleteById(id);
    }
    public Employee getById(int id) {
        return employeeDAO.findById(id);
    }

    public boolean checkById(int id) {
        Employee employee = employeeService.getById(id);
        return employee != null;
    }
}