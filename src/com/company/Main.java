package com.company;

import javax.swing.table.TableModel;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) {

      //  List<BlockingQueue<Integer>> list = new ArrayList<BlockingQueue<Integer>>();
        int[] array = new int[args.length];
        CountDownLatch countDownLatch = new CountDownLatch(args.length);
        if(args.length == 0)
        {
            System.err.println("No input file");
            System.exit(2);
        }

        String savingPath = "D:/IntellijProjects/JavaTask4/src/com/company/";

        for(int i=0; i<args.length; i++){
            String fileName = savingPath + args[i];
            File inputFile = new File(fileName);
            Thread thread = new Thread(new WorkingThread(array, i, inputFile, countDownLatch));
            thread.start();
        }

        try{
            countDownLatch.await();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        Connection connection = null;
        PreparedStatement queryStatement = null, insertStatement = null, truncateStatement = null;
        ResultSet resultSet = null;


          try{
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/task4db", "bogdan123", "bogdanbogdan123");
          //  truncateStatement=connection.prepareStatement("TRUNCATE TABLE task4table");
          //  truncateStatement.execute();


            Task4tableDAO task4tableDAO = new Task4tableDAOimpl(connection);

            Task4tableModel newRow = new Task4tableModel();
            newRow.setId(33);
            newRow.setSum(500);
            newRow.setFileName("TestingRow");





       /*    for(int i=0; i<args.length; i++){
               insertStatement=connection.prepareStatement("INSERT INTO task4table (id, Sum, FileName) VALUES(" + i + ", " + array[i]+", '" + args[i] + "')" );
                insertStatement.execute();
                releaseResource(insertStatement);
            }
            // inserted a new row
            task4tableDAO.create(newRow);

            queryStatement = connection.prepareStatement("SELECT * FROM task4table");
            resultSet = queryStatement.executeQuery();
            while(resultSet.next()){
                int id =resultSet.getInt("id" );
                int sum = resultSet.getInt("Sum");
                String fileName = resultSet.getString("FileName");
                System.out.println(id + " " + sum + " " + fileName);
            }              */

          List<Task4tableModel>findAllList = task4tableDAO.findAll();
          for(Task4tableModel row : findAllList){
              System.out.println(row);
          }

          Task4tableModel newObject = new Task4tableModel();
          newObject.setId(56);
          newObject.setSum(2020);
          newObject.setFileName("Testing");
          task4tableDAO.create(newObject);




            //findById
            Task4tableModel findByIdRow = task4tableDAO.findById(2);

            System.out.println("Looking for id 2 : " + findByIdRow.getId()+"  "+findByIdRow.getSum()+ "  " + findByIdRow.getFileName());

            //update

            findByIdRow.setId(33);
            findByIdRow.setSum(300);
            findByIdRow.setFileName("Updated the fileName");
            task4tableDAO.update(findByIdRow);

            System.out.println("\n \n \n");

            //findAll
            List<Task4tableModel> list = new ArrayList<>();
            list = task4tableDAO.findAll();
            for(Task4tableModel row : list){
                System.out.println(row);
            }

            //delete
            findByIdRow.setId(33);
            task4tableDAO.delete(findByIdRow);


        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            releaseResources(queryStatement, connection, resultSet, truncateStatement);
        }

    }


    private static void releaseResource(AutoCloseable autocloseable){
        if(autocloseable!=null){
            try{
                autocloseable.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    private  static void releaseResources(AutoCloseable ... autoCloseables){
        for(AutoCloseable autoCloseable : autoCloseables){
            releaseResource(autoCloseable);
        }
    }





}
