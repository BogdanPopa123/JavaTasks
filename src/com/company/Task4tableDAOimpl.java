package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Task4tableDAOimpl implements  Task4tableDAO {

    private final Connection connection;
    private static final String TABLE_NAME = "task4table";

    public Task4tableDAOimpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public boolean create(Task4tableModel task4tableModel){
        int rowInserted = 0;

        try(PreparedStatement createStatement = connection.prepareStatement("INSERT INTO " + TABLE_NAME +" (id, Sum, FileName) VALUES (?, ?, ?)")){
            createStatement.setInt(1, task4tableModel.getId());
            createStatement.setInt(2, task4tableModel.getSum());
            createStatement.setString(3, task4tableModel.getFileName());

            rowInserted = createStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return rowInserted == 1;
    }

    @Override
    public List<Task4tableModel> findAll(){
        List<Task4tableModel> task4tableModels = new ArrayList<>();

        try(PreparedStatement queryStatement = connection.prepareStatement("SELECT * FROM "+  TABLE_NAME) ;
            ResultSet resultSet = queryStatement.executeQuery()){

                while (resultSet.next()) {
                    Task4tableModel task4tableModelTEMP = new Task4tableModel();

                    task4tableModelTEMP.setId(resultSet.getInt("id"));
                    task4tableModelTEMP.setSum(resultSet.getInt("Sum"));
                    task4tableModelTEMP.setFileName(resultSet.getString("FileName"));

                    task4tableModels.add(task4tableModelTEMP);
                }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return task4tableModels;
    }

    @Override
    public Task4tableModel findById(int id){
        Task4tableModel task4tableModel = null;

        try(PreparedStatement queryStatement = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE id = ?")){

            queryStatement.setInt(1, id);
            ResultSet resultSet = queryStatement.executeQuery();

            while(resultSet.next()){
                task4tableModel = new Task4tableModel();
                task4tableModel.setId(resultSet.getInt("id"));
                task4tableModel.setSum(resultSet.getInt("Sum"));
                task4tableModel.setFileName(resultSet.getString("FileName"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return task4tableModel;
    }

    @Override
    public boolean update(Task4tableModel task4tableModel){
        int rowInserted = 0;

        try(PreparedStatement updateStatement = connection.prepareStatement("UPDATE " + TABLE_NAME + " SET Sum = ?, FileName = ? WHERE id = ?")){
            updateStatement.setInt(1, task4tableModel.getSum());
            updateStatement.setString(2, task4tableModel.getFileName());
            updateStatement.setInt(3, task4tableModel.getId());

            rowInserted=updateStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return rowInserted == 1;
    }

    @Override
    public boolean delete(Task4tableModel task4tableModel){
        int rowDeleted = 0;

        try(PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM " + TABLE_NAME + " WHERE id = ?")){
            deleteStatement.setInt(1, task4tableModel.getId());

            deleteStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }

        return rowDeleted == 1;
    }


}
