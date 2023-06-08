package com.example.thuchanhm3.dao;

import com.example.thuchanhm3.dao.connection.MyConnection;
import com.example.thuchanhm3.model.Department;
import com.example.thuchanhm3.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private static Connection connection = MyConnection.getConnection();
    private static EmployeeDAO employeeDAO;

    public static EmployeeDAO getInstance() {
        if (employeeDAO == null) {
            employeeDAO = new EmployeeDAO();
        }
        return employeeDAO;
    }

    public static List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        String query = "select * from employee;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phone_number = resultSet.getString("phone_number");
                double salary = resultSet.getDouble("salary");
                int departmentId = resultSet.getInt("department_id");
                Department department = DepartmentDAO.getInstance().findById(departmentId);
                employeeList.add( new Employee(id, name, email, address, phone_number, salary, department));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public Employee findById(int id) {
        Employee employee = null;
        String query = "select * from employee where id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phone_number = resultSet.getString("phone_number");
                double salary = resultSet.getDouble("salary");
                int departmentId = resultSet.getInt("department_id");
                Department department = DepartmentDAO.getInstance().findById(departmentId);
                employee = new Employee(id, name, email, address, phone_number, salary, department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    public void addEmployee(Employee employee) {
        String query = "insert into employee (name, email, address, phone_number, salary, department_id) values \n" +
                "(?, ?, ?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setString(4, employee.getPhone_number());
            preparedStatement.setDouble(5, employee.getSalary());
            preparedStatement.setInt(6, employee.getDepartment().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(Employee employee) {
        String query = "update employee set name = ?, email = ?, address = ?, phone_number = ?, salary = ?, department_id = ? where id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setString(4, employee.getPhone_number());
            preparedStatement.setDouble(5, employee.getSalary());
            preparedStatement.setInt(6, employee.getDepartment().getId());
            preparedStatement.setInt(7, employee.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        String query = "delete from employee where id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
