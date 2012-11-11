package facebook;
import java.util.*;


public class JaccardSim {
	public static double sim(String s1,String s2)
	{		
		HashMap<String,Integer> h1=Extract.Unique(s1);
		HashMap<String,Integer> h2=Extract.Unique(s2);
		HashSet<String> hs=Extract.Intersect(h1, h2);
		if(hs.isEmpty())
			return 0;
		double up=hs.size();
		double down=h1.size()+h2.size()-hs.size();
		return up/down;
		
	}

}