package facebook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class normalization {
	
	public static void ItemNumber(String loc) throws Exception
	{
		Scanner SC=new Scanner(new FileReader("C:/train1.txt"));	
		TreeMap<String,Integer> ts=new TreeMap<String,Integer>();
		while(SC.hasNext())
		{
			String tmp=SC.nextLine();
			String content[]=tmp.split(" \\| ");
			System.out.println(content[0]);
			if(!ts.containsKey(content[0]))
			{
				ts.put(content[0], 0);
			}
			else
				ts.put(content[0], ts.get(content[0])+1);
			if(!ts.containsKey(content[1]))
			{
				ts.put(content[1], 0);
			}
			else
				ts.put(content[1], ts.get(content[1])+1);
			
		}
		
		//System.out.println(ts);	

		SC.close();
	}
	
	public static boolean isNumeric(String str)
	{
	    for (char c : str.toCharArray())
	    {
	        if (!Character.isDigit(c)) return false;
	    }
	    return true;
	}
	
	public static ArrayList<String> GetItem(String loc) throws Exception
	{
		Scanner SC=new Scanner(new FileReader(loc));
		HashSet<String> ts=new HashSet<String>();
		ArrayList<String>rs=new ArrayList<String>();
	
		while(SC.hasNext())
		{
			String tmp=SC.nextLine();
			String content[]=tmp.split(" \\| ");
			ts.add(content[0].trim());
			ts.add(content[1].trim());

		}
		rs.addAll(ts);
		System.out.println(rs.size());
		//System.out.println(count);
		SC.close();
		return rs;
	}
	
	public static ArrayList<String> GetItemNoNum(String loc) throws Exception
	{
		File file1 = new File(loc+"_numbers.txt");
		if (!file1.exists()) {
			file1.createNewFile();
		}
		FileWriter fw1 = new FileWriter(file1.getAbsoluteFile(),true);
		final BufferedWriter bw1 = new BufferedWriter(fw1);
		
		Scanner SC=new Scanner(new FileReader(loc));
		HashSet<String> ts=new HashSet<String>();
		ArrayList<String>rs=new ArrayList<String>();
		
		TreeSet<String> num=new TreeSet<String>();
		
	
		while(SC.hasNext())
		{
			String tmp=SC.nextLine();
			String content[]=tmp.split(" \\| ");
			if(!isNumeric(content[0].trim()))
				ts.add(content[0].trim());
			else
			{
				num.add(content[0].trim());
			}
			if(!isNumeric(content[1].trim()))
				ts.add(content[1].trim());
			else
			{
				num.add(content[1].trim());
			}
	
		}
		rs.addAll(ts);
		System.out.println(rs.size());
		//System.out.println(count);
		for(String s1:num)
		{
			bw1.write(s1);
			bw1.newLine();
		}
		SC.close();
		bw1.close();
		return rs;
	}
	
	public static TreeMap<Integer,ArrayList<String> > Indexing(String loc) throws Exception
	{
		Scanner SC=new Scanner(new FileReader(loc));
		HashMap<String,Integer> ts=new HashMap<String, Integer>();
		TreeMap<Integer,ArrayList<String> > rs=new TreeMap<Integer,ArrayList<String> >();
		//int count=0;
		while(SC.hasNext())
		{
			String tmp=SC.nextLine();
			String content[]=tmp.split(" ");
			for(String s1:content)
			{
				if (!ts.containsKey(s1))
					ts.put(s1, 1);
				else
					ts.put(s1, ts.get(s1)+1);
			}

		}
		//rs.addAll(ts);
		System.out.println(rs.size());
		//System.out.println(count);
		SC.close();
		return rs;
	}
	
	
	public static void main(String args[])throws Exception
	{
		//ArrayList <String>A3=GetItem("C:/train1.txt");
		ArrayList <String>A1=GetItemNoNum("C:/train1.txt");

		//HashSet <String>A2=new HashSet <String>();
		
		
		String output="C:/Duplicate1";
		File file = new File(output+"_ED.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		final BufferedWriter bw = new BufferedWriter(fw);
		
		File file1 = new File(output+"_IsSubString.txt");
		if (!file1.exists()) {
			file1.createNewFile();
		}
		FileWriter fw1 = new FileWriter(file1.getAbsoluteFile(),true);
		final BufferedWriter bw1 = new BufferedWriter(fw1);
		
		File file2 = new File(output+"_jaccard.txt");
		if (!file2.exists()) {
			file2.createNewFile();
		}
		FileWriter fw2 = new FileWriter(file2.getAbsoluteFile(),true);
		final BufferedWriter bw2 = new BufferedWriter(fw2);
		
		long startTime = System.currentTimeMillis();
		
		for(String s1: A1)
		{	
			for(String s2: A1)
			{
				/*if (s1.length()<=7 && s2.length()<=7)
					continue;
				int dis=EditDistance.ED(s1,s2);
				if(dis<=7)
				{
					//System.out.println(s1+"----"+s2);
					bw.write(s1+"----"+s2+"----"+dis);
					bw.newLine();
				}*/
				if(s1.length()<s2.length())
				{
					if(s2.contains(s1))
						bw1.write(s1+"----"+s2 );
				}
				
				if(s1.length()>s2.length())
				{
					if(s1.contains(s2))
					{
						bw1.write(s2+"----"+s1 );
						bw1.newLine();
					}
				}
				
				double JS=JaccardSim.sim(s1, s2);
				if(JS>0.8)
				{
					bw2.write(s1+"----"+s2+"----"+JS);
					bw2.newLine();
				}
				
				/*double CS=CosineSim.sim(s1, s2);
				if(CS>0.8)
				{
					bw1.write(s1+"----"+s2+"----"+CS);
					bw1.newLine();
				}*/
				
				
				
				
			}
			
		}

		//System.out.println("length left :" + (A1.size()-A2.size()));
		long duration = System.currentTimeMillis() - startTime;
		System.out.println("Program executed for " + duration + " milliseconds");
		bw.write("Program executed for " + duration + " milliseconds");
		bw.close(); 
		bw1.close();
		bw2.close();
	}
}
