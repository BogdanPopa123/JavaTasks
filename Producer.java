package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.Scanner;

public class Producer implements Runnable {

    private BlockingQueue<Integer> queue;
    private File savingFile;

    public Producer(BlockingQueue<Integer> queue, File savingFile) {
        this.queue = queue;
        this.savingFile = savingFile;
    }

    @Override
    public void run(){
        try (Scanner scanner = new Scanner(savingFile)) {
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                addInQueue(data);
           /*     try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }      */

            }
        }  catch(FileNotFoundException e){
            System.out.println("The file doesn't exist");
            e.printStackTrace();
        }


    }

    private void addInQueue(String data) {
        try
        {
            int reqdata = Integer.parseInt(data);
            queue.add(reqdata);
        }  catch(NumberFormatException e)
        {
            e.printStackTrace();
        }
    }
}
