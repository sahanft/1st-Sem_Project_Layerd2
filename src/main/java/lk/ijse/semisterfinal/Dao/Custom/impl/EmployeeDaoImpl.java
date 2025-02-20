package lk.ijse.semisterfinal.Dao.Custom.impl;


import lk.ijse.semisterfinal.DB.DbConnetion;
import lk.ijse.semisterfinal.Dao.Custom.EmployeeDao;
import lk.ijse.semisterfinal.Dao.SqlUtil;
import lk.ijse.semisterfinal.dto.AddEmployeeDTO;
import lk.ijse.semisterfinal.entity.AddEmployeeEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public boolean add(AddEmployeeEntity e) throws SQLException, ClassNotFoundException {
       return SqlUtil.test("INSERT INTO employee VALUES(?,?,?,?,?,?,?,?,?,?,?,?)",e.getEmployeeId(),e.getEmployeeName(),e.getEmpAddress(),e.getEmployeePhone(),e.getEmpDate(),e.getEmpPosition(),
               e.getEmail(),e.getGender(),e.getEducation(),e.getBasicSalary(),e.getExpiriance(),e.getDe());

    }


    @Override
    public ArrayList<AddEmployeeEntity> getAll() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SqlUtil.test("SELECT * FROM employee");
        ArrayList <AddEmployeeEntity> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            AddEmployeeEntity dto = new AddEmployeeEntity(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getInt(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8),
                            resultSet.getString(9),
                            resultSet.getDouble(10),
                            resultSet.getString(11),
                            resultSet.getString(12));

            dtoList.add(dto);
        }

        return dtoList;
    }


    @Override
    public boolean update(AddEmployeeEntity dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("UPDATE employee SET employeeName = ?, empAddress = ?, employeePhone = ?, empDate = ? , empPosition =?, email =?, gender =?, education =?, basicSalary =?, expiriance =?, de =?  WHERE employeeId = ?",
                dto.getEmployeeName(),dto.getEmpAddress(),dto.getEmployeePhone(),dto.getEmpDate(),dto.getEmpPosition(),
                dto.getEmail(),dto.getGender(),dto.getEducation(),dto.getBasicSalary(),dto.getExpiriance(),dto.getDe(),dto.getEmployeeId());

    }


    @Override
    public boolean delete(AddEmployeeEntity id) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("DELETE FROM employee WHERE employeeId = ?",id.getEmployeeId());

    }

    public AddEmployeeEntity searchEmployee(String id) throws SQLException, ClassNotFoundException {

        PreparedStatement pstm = SqlUtil.test("SELECT * FROM employee WHERE employeeId = ? ");
        pstm.setString(1, id);

        ResultSet resultSet = pstm.executeQuery();

        AddEmployeeEntity dto = null;

        if (resultSet.next()){
            String eid = resultSet.getString(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            int mobile = Integer.parseInt(String.valueOf(resultSet.getInt(4)));
            String date = resultSet.getString(5);
            String email = resultSet.getString(7);
            String position = resultSet.getString(6);
            double bSalary = resultSet.getDouble(10);

            dto = new AddEmployeeEntity(eid,name,address,mobile,date,email,position,bSalary);
        }
        return dto;
    }


}
