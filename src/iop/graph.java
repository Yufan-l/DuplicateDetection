package iop;
import java.util.*;
import java.io.*;



public class graph {
	

	
	public static void graph_generate()throws IOException
	{
		
		ArrayList<String[]>records=new ArrayList<String[]>();
		String source="C:/Users/yliu0/Desktop/fz.arff";
		rf.readfiles(source, records);
		
		HashMap<Integer,ArrayList<Integer> > components=new HashMap<Integer,ArrayList<Integer> >();
		HashMap <Integer,Integer>reference=new HashMap<Integer,Integer>();
		
		
		for(int i=0;i<records.size();i++)
		{
			ArrayList<Integer> tmp=new ArrayList<Integer>();
			tmp.add(i);
			reference.put(i, i);
			components.put(i, tmp);
		}
		
		for (int i=0;i<records.size();i++)
		{
			for(int j=i+1;j<records.size();j++)
			{
				if(reference.get(i)==reference.get(j))
				continue;
				
				else if(measure.similarity_overlap(records.get(i),records.get(j))>0.6)
				{
					int small=Math.min(reference.get(i),reference.get(j));
					int large=Math.max(reference.get(i),reference.get(j));
					for(int k=0;k<components.get(large).size();k++)
					{
						components.get(small).add(components.get(large).get(k));
						reference.put(k,small);
					}
					
				}

			}
		}
		
		for(int i=0;i<components.size();i++)
		{
	
			System.out.println(components.get(i));
		}
		
		
	}
	
	public static void main(String []args) throws IOException
	{
		graph_generate();
	}
	

}
