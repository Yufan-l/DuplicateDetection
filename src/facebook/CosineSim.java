package facebook;
import java.util.*;


public class CosineSim {
	public static double sim(String s1,String s2)
	{		
		HashMap<String,Integer> h1=Extract.Unique(s1);
		HashMap<String,Integer> h2=Extract.Unique(s2);
		HashSet<String> hs=Extract.Intersect(h1, h2);
		if(hs.isEmpty())
			return 0;
		int magnitude1=0;
		int magnitude2=0;
		int dotProduct=0;
		for(int f:h1.values())
		{
			magnitude1+=(f*f);
		}
		for(int f:h2.values())
		{
			magnitude2+=(f*f);
		}
		for(String s:hs)
		{
			dotProduct+=(h1.get(s)*h2.get(s));
		}
		
		return dotProduct/(Math.sqrt(magnitude1)*Math.sqrt(magnitude2));
		
	}

}
