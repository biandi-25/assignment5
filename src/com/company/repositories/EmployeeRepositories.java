package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Employee;
import com.company.repositories.interfaces.IEmployeeRepositories;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class EmployeeRepositories implements IEmployeeRepositories {

    private final IDB db = null;

    public EmployeeRepositories() { this.db = db;    }

    @Override
    public boolean createEmployee(Employee employee){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO work(name, surname, status, hobby, level) VALUES (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, employee.getName());
            st.setString(2, employee.getSurname());
            st.setString(3, employee.getStatus());
            st.setString(4, employee.getHobby());
            st.setString(5, employee.getLevel());


            st.execute();
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Employee getEmployee(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            var sql = "SELECT id,name, surname, status, hobby, level FROM work WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if(rs.next()){
                Employee employee=new Employee(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("status"),
                        rs.getString("hobby"),
                        rs.getString("level"));
                                        return employee;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try{
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    @Override
    public boolean removeEmployeeById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            PreparedStatement preparedStatement=con.prepareStatement( "DELETE FROM work WHERE id = ?");
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return false;
    }

}
