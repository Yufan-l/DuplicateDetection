package facebook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Merge {
	
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
	
	public static ArrayList<String> GetAllItems(String loc) throws Exception
	{
		HashSet<String> ts=new HashSet<String>();
		ArrayList<String>rs=new ArrayList<String>();
		
		String output="C:/CombinedAll1.txt";
		File file = new File(output);
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		final BufferedWriter bw = new BufferedWriter(fw);
		
		for(int i=1;i<16;i++)
		{
			Scanner SC=new Scanner(new FileReader(loc+i+".txt"));	
			while(SC.hasNext())
			{
				String tmp=SC.nextLine();
				String content[]=tmp.split(" \\| ");
				ts.add(content[0].trim());
				ts.add(content[1].trim());

			}
			
			System.out.println(ts.size());
			//System.out.println(count);
			SC.close();
		}
		
		Scanner SC=new Scanner(new FileReader("C:/paths.txt"));
		String tmp=" ";
		while(SC.hasNext())
		{
			
			tmp=SC.nextLine().trim();
			String content[]=tmp.split(" \\| ");
			for(String s1:content)
			{
				ts.add(s1.trim());
			}
		}
		
		for(String s1:ts)
		{
			rs.add(s1);
			bw.write(s1);
			bw.newLine();
		}
		SC.close();
		bw.close();
		return rs;
	}
	
	
	
	
	public static void main(String args[])throws Exception
	{
		//ArrayList <String>A3=GetItem("C:/train1.txt");
		

		//HashSet <String>A2=new HashSet <String>();
/*		int num=0;
		Scanner SC=new Scanner(new FileReader("C:/CombinedAll.txt"));	
		while(SC.hasNext())
		{
			String tmp=SC.nextLine();
			if (isNumeric(tmp))
				num++;
		}
		System.out.println(num);
		SC.close();*/
		long startTime = System.currentTimeMillis();	
		
		GetAllItems("H:/train/train");
		

		long duration = System.currentTimeMillis() - startTime;
		System.out.println("Program executed for " + duration + " milliseconds");
		

	}
}
