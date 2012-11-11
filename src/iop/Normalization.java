package iop;
import java.io.*;
import java.util.*;


public class Normalization {
	
	public static String NameNormalization(String name)
	{
		
		
		String result=name.replaceAll(" restaurant", "").replaceAll("restaurant ", "").replaceAll("\\(.*?\\)","");		
		return result;
	}
	
	public static String AddressNormalization(String address)
	{
		
		//String[]tokens=address.split("\\W+");
		//String[]norm=new String[4];
		
		/*
		for(int j=0;j<tokens.length;j++)
		{
			if (tokens[j].matches("(?i)street")||tokens[j].matches("(?i)st"))
			{
				norm[3]="ST";
				norm[2]=tokens[j-1];
			}
			if (tokens[j].matches("(?i)road")||tokens[j].matches("(?i)rd"))
			{
				norm[3]="RD";
				norm[2]=tokens[j-1];
			}
			
			if (tokens[j].matches("(?i)avenue")||tokens[j].matches("(?i)ave"))
			{
				norm[3]="AVE";
				norm[2]=tokens[j-1];
			}
			
			if (tokens[j].matches("(?i)plaza")||tokens[j].matches("(?i)plz"))
			{
				norm[3]="PLZ";
				norm[2]=tokens[j-1];
			}
			
			if (tokens[j].matches("(?i)drive")||tokens[j].matches("(?i)dr"))
			{
				norm[3]="DR";
				norm[2]=tokens[j-1];
			}
			
			if (tokens[j].matches("(?i)BOULEVARD")||tokens[j].matches("(?i)BLVD"))
			{
				norm[3]="BLVD";
				norm[2]=tokens[j-1];
			}
			
			if (tokens[j].matches("(?i)west")||tokens[j].matches("(?i)w")||tokens[j].matches("(?i)w."))
			{
				norm[1]="W";
			}
		
			if (tokens[j].matches("(?i)south")||tokens[j].matches("(?i)s")||tokens[j].matches("(?i)s."))
			{
				norm[1]="S";
			}
			
			if (tokens[j].matches("(?i)north")||tokens[j].matches("(?i)n")||tokens[j].matches("(?i)n."))
			{
				norm[1]="N";
			}
			
			if (tokens[j].matches("(?i)east")||tokens[j].matches("(?i)e")||tokens[j].matches("(?i)e."))
			{
				norm[1]="E";
			}
				
			
		}
		
		norm[0]=tokens[0];
		String result=new String();
		for(int i=0;i<4;i++)
		{
			if (norm[i]!=null)
			{
				result+=norm[i];
				if(i!=3)
				{
					result+=" ";
				}
			}		
		}
		
		*/
		
		String result=address.replace("(?)street", "ST");
		return result;
	}
	
	public static String PhoneNormalization(String phone)
	{
		
		char NewPhone[]=new char[12];

		String str = phone.replaceAll("\\D+",""); 
		
		if (str.length()!=10)
			return phone;

		else
		{
			for(int i=0;i<3;i++)
			{
				NewPhone[i]=str.charAt(i);
			}
			NewPhone[3]='-';
			for(int i=0;i<3;i++)
			{
				NewPhone[i+4]=str.charAt(i+3);
			}
			NewPhone[7]='-';
			for(int i=0;i<4;i++)
			{
				NewPhone[i+8]=str.charAt(i+6);
			}
			
			String result=new String(NewPhone);
			return result;
		}

	}
	
	
	public static void main(String []args) throws IOException
	{
		ArrayList<String[]>records=new ArrayList<String[]>();
		String source="C:/Users/yliu0/Desktop/fz.arff";
		rf.readfiles(source, records);
		String phone="(702)/7344-0410";
		String kk= PhoneNormalization(phone);
		System.out.println(kk);
		//System.out.println(AddressNormalization("386 3rd ave.  between 27th and 28th sts."));
		String str="test(sd) restaurant";
		String str1=str.replaceAll("\\(.*?\\)","").replaceAll(" restaurant", "");
		System.out.print(str1);
	
	}
	
	
	
}
