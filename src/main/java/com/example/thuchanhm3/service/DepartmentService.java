package com.example.thuchanhm3.service;

import com.example.thuchanhm3.dao.DepartmentDAO;
import com.example.thuchanhm3.model.Department;

import java.util.List;

public class DepartmentService {

    private final DepartmentDAO departmentDAO;
    private static DepartmentService departmentService;

    private DepartmentService() {
        departmentDAO = new DepartmentDAO();
    }

    public static DepartmentService getInstance() {
        if (departmentService == null) {
            departmentService = new DepartmentService();
        }
        return departmentService;
    }

    public List<Department> findAll() {
        return departmentDAO.findAll();
    }

    public boolean checkById(int id) {
        Department department = departmentDAO.findById(id);
        return department != null;
    }
}
