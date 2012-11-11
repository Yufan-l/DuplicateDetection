package facebook;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Indexing {
	
	
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
	
	public static void ind(String loc, HashMap<String, ArrayList<String> > hm )throws Exception
	{
		HashSet<HashSet<String> >unique=new HashSet<HashSet<String> >();
		File file1 = new File("C:/SubSequence.txt");
		if (!file1.exists()) {
			file1.createNewFile();
		}
		FileWriter fw1 = new FileWriter(file1.getAbsoluteFile(),true);
		final BufferedWriter bw1 = new BufferedWriter(fw1);
		
		Scanner SC=new Scanner(new FileReader(loc));	
		while(SC.hasNext())
		{
			String tmp=SC.nextLine();
			if (normalization.isNumeric(tmp))
				continue;
			String content[]=tmp.split(" ");
			for(String s1:content)
			{
				ArrayList <String>A1=hm.get(s1);
				for(String tmp2:A1)
				{   
					if(tmp.length()==tmp2.length())
						continue;
					String longStr=" ";
					String shortStr=" ";
					if(tmp.length()>tmp2.length())
					{
						longStr=tmp;
						shortStr=tmp2;
					}
					else
					{
						longStr=tmp2;
						shortStr=tmp;
					}
					HashSet<String> pair=new HashSet<String>();
					pair.add(tmp);
					pair.add(tmp2);
					if(unique.contains(pair))
						continue;
					if(longStr.contains(shortStr))
					{
						bw1.write(longStr+"----"+shortStr+"----"+(longStr.length()-shortStr.length()));
						bw1.newLine();
					}
					else
					{
						//HashSet<String>unique= 
					}
					/*double JS=JaccardSim.sim(tmp, tmp2);
					if(JS>=0.2 && JS<1)
					{
					//	unique.add(pair);
						bw1.write(tmp+"----"+tmp2+"----"+JS);
						bw1.newLine();
					}*/
				}
			}
			
			
		}
			
		
		SC.close();
		bw1.close();
	}
	
	public static void main(String args[])throws Exception
	{
		long startTime = System.currentTimeMillis();
		HashMap<String, ArrayList<String> >hm=indexing("H:/train/CombinedAll.txt");
		ind("H:/train/CombinedAll.txt",hm);
		
		long duration = System.currentTimeMillis() - startTime;
		System.out.println("Program executed for " + duration + " milliseconds");
	}

}

