package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.Scanner;

public class Producer implements Runnable {

    BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue){
        this.queue=queue;
    }

    @Override
    public void run(){
        try{
            String fileSavingPath = "D:/IntellijProjects/JavaTask3/src/com/company/ProducerConsumerIN.txt";
            File savingFile = new File(fileSavingPath);
            if(!savingFile.exists())
            {
                try
                {
                    savingFile.createNewFile();
                }catch(IOException e)
                {
                    System.out.println("EROARE");
                    e.printStackTrace();
                }
            }
            Scanner Scanner = new Scanner(savingFile);
            while(Scanner.hasNextLine())
            {
                String data = Scanner.nextLine();
                int reqdata = Integer.parseInt(data);
                queue.add(reqdata);
           /*     try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }      */

            }
        }catch(FileNotFoundException e){
            System.out.println("The file doesn't exist");
            e.printStackTrace();
        }

    }
}
