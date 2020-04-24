package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] vector = new int[150];
        int i=0, newnumber, aux;
        boolean test=false;

        while(test!=true)
        {
            newnumber=scanner.nextInt();
            for(int j=0; j<i; j++)
            {
                if(newnumber==vector[j])
                {
                    test=true;
                }
            }
            if(test==false)
            {
                vector[i]=newnumber;
                i++;
            }
        }
        for(int j=0; j<i-1; j++)
        {
            for(int k=j+1; k<i; k++)
            {
                if(vector[j]>vector[k])
                {
                    aux=vector[j];
                    vector[j]=vector[k];
                    vector[k]=aux;
                }
            }
        }

        String fileSavingPath = "D:/JavaTask2/src/com/company/SortedArray/" ;
        File saveFile = new File(fileSavingPath);
        if (! saveFile.exists()) {
            saveFile.mkdirs();
        }

        try (FileWriter fileWriter = new FileWriter(saveFile + "output.txt")) {
            for (int j = 0; j < i; j++) {
                try {
                    fileWriter.write("" + vector[j]);
                    if (j != i - 1) {
                        fileWriter.write(", ");
                    }
                } catch (IOException e) {
                    System.out.println("EROARE");
                    e.printStackTrace();
                }
            }

            fileWriter.write(".");
        } catch(IOException e) {
            System.out.println("EROARE 2");
            e.printStackTrace();
        }

    }
}