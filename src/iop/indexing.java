package iop;
import java.util.*;
import java.io.*;

class Word implements Comparable<Word>
{
	private String content;
	private Integer count;
	
	Word(String content, Integer count)
	{
		this.content=content;
		this.count=count;
	}
	
	public Integer getCount()
	{
		return this.count;
	}
	public String getContent()
	{
		return this.content;
	}
	public int compareTo(Word cw)
	{
		 int number=((Word)cw).getCount();
		 return this.count-number;
	}
}


public class indexing  {
	
	public static HashMap<String, Integer> MakeIndex()throws IOException
	{
		HashMap<String, Integer>index=new HashMap<String, Integer>();
		ArrayList<String[]>records=new ArrayList<String[]>();
		String source="C:/Users/yliu0/Desktop/fz.arff";
		rf.readfiles(source, records);
		for(int i=0;i<records.size();i++)
		{
			for(int j=0;j<records.get(i).length;j++)
			{
				for(int k=0;k<records.get(i)[j].split("\\W+").length;k++)
				{
					if(!index.containsKey(records.get(i)[j].split("\\W+")[k]))
						index.put(records.get(i)[j].split("\\W+")[k], 1);
					else
						index.put(records.get(i)[j].split("\\W+")[k], index.get(records.get(i)[j].split("\\W+")[k])+1);
				}
			}
		}		
		
		return index;
	}
	
	public static ArrayList<String> SortIndex (HashMap<String, Integer> index)
	{
		ArrayList<String> SortedIndex=new ArrayList<String>();
		Word[] words=new Word[index.size()];
		int i=0;
		
		for(Map.Entry<String,Integer> et: index.entrySet())
		{
			 words[i]=new Word(et.getKey(),et.getValue());
			 i++;
		}
			
		Arrays.sort(words);
		for(int j=0;j<words.length;j++)
		{
			System.out.println(words[j].getContent()+" "+words[j].getCount());
		}
		return SortedIndex;
	}
	
	public static void main(String []args)throws IOException
	{
		//System.out.print();
		SortIndex(MakeIndex());
	}
	

}
