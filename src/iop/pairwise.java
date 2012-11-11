package iop;

import java.util.*;
import java.io.*;

public class pairwise {
	public static void pw()throws IOException
	{
		ArrayList<String[]>records=new ArrayList<String[]>();
		String source="C:/Users/yliu0/Desktop/fz.arff";
		rf.readfiles(source, records);
		
		ArrayList<int[]>duplicate_pair=new ArrayList<int[]>();
		
		for (int i=0;i<records.size();i++)
		{
			for(int j=i+1;j<records.size();j++)
			{
				if(measure.similarity_overlap(records.get(i),records.get(j))>0.8)
				{
					int pair[]=new int[2];
					pair[0]=i;
					pair[1]=j;
					duplicate_pair.add(pair);
				}
			}
		}
		
		for(int i=0;i<duplicate_pair.size();i++)
		{
			System.out.println(duplicate_pair.get(i)[0]+" "+duplicate_pair.get(i)[1]);
		}
		
		
		
	}
	
	public static void main(String args[])throws IOException
	{
		pw();
	}
}
