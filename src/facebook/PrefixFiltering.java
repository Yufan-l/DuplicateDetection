package facebook;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import java.util.*;

public class PrefixFiltering {
	
	
	public static HashMap<String, ArrayList<String> > indexing(String loc)throws Exception
	{
		HashMap<String, ArrayList<String> > hm=new HashMap<String, ArrayList<String> >();
	
		Scanner SC=new Scanner(new FileReader(loc));	
		while(SC.hasNext())
		{
			String tmp=SC.nextLine();
			if (normalization.isNumeric(tmp))
				continue;
			String content[]=tmp.split(" ");
			for(String s1:content)
			{
				if(!hm.containsKey(s1))
				{	
					ArrayList <String>l1=new ArrayList <String>();
					l1.add(tmp);
					hm.put(s1, l1);
				}
				else
				{
					ArrayList <String>l2=hm.get(s1);
					l2.add(tmp);
					hm.put(s1, l2);
				}
			}
			
		}
		
		
		SC.close();
		return hm;
		
	}
	
	public static void PF(String loc, HashMap<String, ArrayList<String> > hm )throws Exception
	{
		int count=0;
		File file1 = new File("H:/train/SubSequence.txt");
		if (!file1.exists()) {
			file1.createNewFile();
		}
		FileWriter fw1 = new FileWriter(file1.getAbsoluteFile());
		final BufferedWriter bw1 = new BufferedWriter(fw1);
		
		Scanner SC=new Scanner(new FileReader(loc));	
		while(SC.hasNext())
		{
			String tmp=SC.nextLine();
			if (normalization.isNumeric(tmp))
				continue;
			String content[]=tmp.split(" ");
			HashMap<String,Integer> str=new HashMap<String,Integer>();
			int len=tmp.length();
			for(String s1:content)
			{
				ArrayList <String>A1=hm.get(s1);
				for(String tmp2:A1)
				{   
					if(len<=tmp2.length())
						continue;
					if(!str.containsKey(tmp2))
						str.put(tmp2,1);
					else
						str.put(tmp2,str.get(tmp2)+1);
				}
			}
			
			for(String s2:str.keySet())
			{
				String content1[]=s2.split(" ");
				if(content1.length==str.get(s2))
				{
					count++;
					bw1.write(tmp+"\t"+s2+"\t"+(content.length-content1.length));
					bw1.newLine();
				}
			}
			
			
		}
			
		System.out.println(count);
		SC.close();
		bw1.close();
	}
	
	public static void main(String args[])throws Exception
	{
		long startTime = System.currentTimeMillis();
		HashMap<String, ArrayList<String> >hm=indexing("H:/train/CombinedAll1_unified.txt");
		PF("H:/train/CombinedAll1_unified.txt",hm);	
		long duration = System.currentTimeMillis() - startTime;
		System.out.println("Program executed for " + duration + " milliseconds");
	}
	

}
