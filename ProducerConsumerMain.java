package com.company;


import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.io.File;

/* "Se citeste dintr-un fisier (pe fiecare rand sunt numere < 3 cifre - fisierul poate avea si un milion de row-uri).
 Fisierul trebuie procesat astfel incat fiecare numar sufera cateva modificari
 (daca e mai mic de 100 este incrementat cu 1, daca e mai mare de 100 e decrementat cu 1).
 Noile valori trebuie salvate intr-un alt fisier. As vrea sa folositi Producer and Consumer."
 */


public class ProducerConsumerMain {

    public static void main(String[] args) {

        String fileSavingPath = "D:/IntellijProjects/JavaTask3/src/com/company/ProducerConsumerIN.txt";
        File savingFile = new File(fileSavingPath);
        if(!savingFile.exists())
        {
            System.err.println("Input file not found");
            System.exit(2);
        }

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1000000);
        Thread producer = new Thread(new Producer(queue, savingFile));
        Thread consumer = new Thread(new Consumer(queue));

        producer.start();
        consumer.start();
    }
}
