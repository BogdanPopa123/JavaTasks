package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

public class WorkingThread implements  Runnable {

        //private BlockingQueue<Integer> queue;
        private int[] array;
        private int arrayIndex;
        private File inputFile;
        private CountDownLatch countDownLatch;

        public WorkingThread(int[] array, int i, File inputFile, CountDownLatch countDownLatch){
            this.array=array;
            this.arrayIndex=i;
            this.inputFile=inputFile;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run(){
            try(Scanner scanner = new Scanner(inputFile)){
                int sum = 0;
                while(scanner.hasNextLine()){
                    String data = scanner.nextLine();
                    sum += add(data);
                }
                array[arrayIndex] = sum;
            }catch(FileNotFoundException e){
                System.out.println("This file doesn't exist : " + inputFile.getName());
                e.printStackTrace();
            }finally{
                countDownLatch.countDown();
             }
        }



        private int add(String data)
        {
            int reqdata=0;
            try{
                 reqdata = Integer.parseInt(data);

            }catch(NumberFormatException e){
                e.printStackTrace();
            }
            return reqdata;
        }


}
