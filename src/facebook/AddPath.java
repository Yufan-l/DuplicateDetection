package facebook;
import java.io.FileReader;
import java.util.*;

public class AddPath {
	public static void main(String []args) throws Exception
	{
		HashSet<String> hs1=new HashSet<String>();
		//HashSet<String> hs2=new HashSet<String>();
		Scanner SC1=new Scanner(new FileReader("C:/CombinedAll.txt"));
		Scanner SC2=new Scanner(new FileReader("C:/paths.txt"));
		while(SC1.hasNext())
		{
			String tmp=" ";
			tmp=SC1.nextLine().trim();
			hs1.add(tmp);
		}
		
		
		//while(SC2.hasNext())
		for(int i=0;i<10;i++)
		{
			String tmp=" ";
			tmp=SC2.nextLine().trim();
			String content[]=tmp.split(" \\| ");
			for(String s1:content)
			{
				if(!hs1.contains(s1.trim()))
					System.out.println(s1);
			}
			
		}
		SC1.close();
		SC2.close();
		
		
	}

}
