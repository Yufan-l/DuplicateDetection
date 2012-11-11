package facebook;



public class EditDistance {
	
	public static int minimun(int a, int b, int c)
	{
		int min=a;
		if (b<min)
			min=b;
		if (c<min)
			min=c;
		return min;
	}
	
	public static int ED(String a, String b)
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
}