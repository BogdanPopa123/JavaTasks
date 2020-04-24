package com.company;

import java.text.MessageFormat;
import java.util.List;

public interface Task4tableDAO {

    boolean create(Task4tableModel task4tableModel); // insert a new row

    List<Task4tableModel> findAll();      //read all

    Task4tableModel findById(int id);     //read a row using its id

    boolean update(Task4tableModel task4tableModel);               //modifies a row's stats

    boolean delete(Task4tableModel task4tableModel);               //deletes a row




}
