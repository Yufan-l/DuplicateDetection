package iop;

import java.util.*;
import java.io.*;

public class measure {
	
	public static int minimun(int a, int b, int c)
	{
		int min=a;
		if (b<min)
			min=b;
		if (c<min)
			min=c;
		return min;
	}
	
	
	public static int EditDistance(String a, String b)
	{
		int m=a.length()+1;
		int n=b.length()+1;
		int[][]d=new int[m][n];
		for (int i=1;i<m;i++)
		{
			d[i][0]=i;
		}
		for (int i=1;i<n;i++)
		{
			d[0][i]=i;
		}
		
		for (int i=1;i<m;i++)
		{
			for (int j=1;j<n;j++)
			{
				if (a.charAt(i-1)==b.charAt(j-1))
				{
					d[i][j]=d[i-1][j-1];
				}
				else
				{
					d[i][j]=minimun(
							d[i-1][j]+1,
							d[i][j-1]+1,
							d[i-1][j-1]+1
							);
				}
			}
	
		}
		
		
		return d[m-1][n-1];
	}
	
	public static int EditDistance_k(String a, String b)
	{
		return 0;
	}
	
	
	public static double similarity_jaccard(String[]a, String[]b)
	{
		double sim=0.0;
		int union=a.length+b.length;
		int intersect=0;
		for(int i=0;i<a.length;i++)
		{
			if(EditDistance(a[i],b[i])<6)
			{
				intersect++;
			}
			
		}
		sim=intersect/union;
		return sim;
		
	}
	
	public static double similarity_overlap(String[]a, String[]b)
	{
		double sim=0.0;
		double v[]=new double[a.length];
        double w[]={0.15,0.15,0.15,0.8,0.15,0};
		for(int i=0;i<a.length;i++)
		{
			if(i==3)
			{
				if(EditDistance(Normalization.PhoneNormalization(a[i]),Normalization.PhoneNormalization(b[i]))<1)
					v[i]=1.0;
				continue;
			}
			
			if(EditDistance(a[i],b[i])<6)
			{
				v[i]=1.0;
			}
			
		}
	    for(int i=0;i<a.length;i++)
	    {
	    	sim+=v[i]*w[i];
	    }
		return sim;
		
	}

	public static void main(String args[])
	{
		String a="310/276-0615";
		String b="310/276-7605";
		String[] c={"bistro", "3400 las vegas blvd. s", "las vegas", "702/791-7111", "continental"};
		String[] d={"mikado", "3400 las vegas blvd. s", "las vegas", "702/791-7111", "asian"};
		int k=EditDistance(a, b);
		System.out.println(k);
		double kk=similarity_overlap(c,d);
		System.out.println(kk); 
	}
	

}
