package facebook;
import java.util.*;

public class Extract {
	public static HashMap<String, Integer> Unique(String s1)
	{
		String content[]=s1.trim().split(" ");
		HashMap<String, Integer> h1=new HashMap<String, Integer>();
		for(int i=0;i<content.length;i++)
		{
			if (!h1.containsKey(content[i]))
				h1.put(content[i], 1);
			else
				h1.put(content[i], h1.get(content[i])+1);
	
		}
		return h1;
	}
	
	
	public static HashSet<String> Intersect(HashMap<String, Integer> h1, HashMap<String, Integer> h2)
	{
		
		HashSet<String> hs=new HashSet<String>();
		for(String key1:h1.keySet())
		{
			for(String key2:h2.keySet())
			{
				if(key1.equals(key2))
					hs.add(key1);
			}
		}
		
		return hs;
	}
	

}
