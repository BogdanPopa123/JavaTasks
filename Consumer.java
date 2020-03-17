package com.company;

import java.io.*;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable
{

    BlockingQueue<Integer> queue;
    public Consumer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }

    @Override
    public void run()
    {
        try
        {
            String fileSavingPath = "D:/IntellijProjects/JavaTask3/src/com/company/ProducerConsumerOUT.txt";
            File outputFile = new File(fileSavingPath);
            FileWriter fileWriter = new FileWriter(outputFile);
            if(!outputFile.exists())
            {
                try
                {
                    outputFile.createNewFile();
                }catch(IOException e)
                {
                    System.out.println("EROARE 2");
                    e.printStackTrace();
                }
            }
            while(true)
            {
                int data = queue.take();
                if(data<100)
                {
                    data++;
                    fileWriter.write("" + data + '\n' );

                }
                else if(data>=100)
                {
                    data--;
                    fileWriter.write("" + data + '\n' );
                }
                else if(queue.isEmpty())
                {
                    break;
                }
             /*   try
                {
                    Thread.sleep(100);
                }catch(InterruptedException e)
                {
                    e.printStackTrace();
                }   */
            }

        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }catch(IOException e)
        {
            e.printStackTrace();
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
