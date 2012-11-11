package iop;

import java.util.*;
import java.io.*;

public class rf {
	
	public static void readfiles(String source, ArrayList<String[]>records  ) throws IOException
	{
		
		Scanner SC=new Scanner(new FileReader(source));
		String tmp="";
		while(SC.hasNext())
		{
			tmp=SC.nextLine();

			if (tmp.equals("@data"))
			{
				break;
			}
			
		}
		while(SC.hasNext())
		{
			String newline=SC.nextLine();
			String contents[]=newline.split(",");
//			for(int i=0;i<contents.length;i++)
//			{
//				System.out.println(contents[i]);
//			}
			records.add(contents);
		}
	}
	/*
	public static void main(String[]args)throws IOException
	{
		String source="C:/Users/yliu0/Desktop/fz.arff";
		ArrayList<String[]>records=new ArrayList<String[]>();
		
		readfiles(source,records);
		
	}
	*/

}
