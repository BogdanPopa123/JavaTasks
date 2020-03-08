package com.company;
import java.io.FileWriter;
import java.util.*;
import java.io.File;
import java.io.IOException;

public class Main
{

    public static void main(String[] args)
    {
	Scanner S = new Scanner(System.in);
	int i, j, isnew=1, poz=1;
	String v[] = new String[5];
	String name;
	v[0]=S.nextLine();
	for(i=1; i<5; i++)
	{
		isnew=1;
		name=S.nextLine();
		for(j=0; j<i; j++)
		{
			if(name.equalsIgnoreCase(v[j]))
			{
				isnew=0;
			}
		}
		if(isnew==1)
		{
			v[poz]=name;
			poz++;
		}
	}
	String fileName, fileSavingPath;
	for(i=0; i<poz; i++)
	{
		fileName ="NumeCu" + v[i].charAt(0);
		fileSavingPath = "D:/Intellij/src/com/company/" + fileName;
		try
		{
			FileWriter fileWriter = new FileWriter(fileSavingPath);
			fileWriter.write(v[i]);
			fileWriter.close();
		}catch(IOException e)
		{
			System.out.println("EROARE");
			e.printStackTrace();
		}
	}
    }
}
