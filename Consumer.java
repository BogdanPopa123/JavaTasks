package com.company;

import java.io.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable
{

    private BlockingQueue<Integer> queue;
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

            while(true)
            {
                Integer data = queue.poll(100, TimeUnit.MILLISECONDS);
                if (data == null)
                {
                    break;
                }
                if(data<100)
                {
                    data++;
                    fileWriter.write("" + data + '\n' );
                }
                else
                {
                    data--;
                    fileWriter.write("" + data + '\n' );
                }
             /*   try
                {
                    Thread.sleep(100);
                }catch(InterruptedException e)
                {
                    e.printStackTrace();
                }   */

            }
            fileWriter.close();

        }catch(IOException|InterruptedException e )
        {
            e.printStackTrace();
        }
    }
}
