package twitter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;



import com.thoughtworks.xstream.XStream;

public class TwitterAddNode {
	
	public static void AddNodes(String input, String target)throws Exception
	{
		Scanner SC=new Scanner(new FileReader(input));
		File file = new File(target);
		if (!file.exists()) {
			file.createNewFile();
		}
		
		FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		final BufferedWriter bw = new BufferedWriter(fw);
		String header="<?xml version=\"1.0\" ?>"
				+"\n<graphml xmlns=\"http://graphml.graphdrawing.org/xmlns\">"
			    +"<key id=\"followersCount\" for=\"node\" attr.name=\"followersCount\" attr.type=\"int\"></key>"
			    +"<key id=\"location\" for=\"node\" attr.name=\"location\" attr.type=\"string\"></key>"
			    +"<key id=\"description\" for=\"node\" attr.name=\"description\" attr.type=\"string\"></key>"
			    +"<key id=\"friendsCount\" for=\"node\" attr.name=\"friendsCount\" attr.type=\"int\"></key>"
			    +"<key id=\"screenName\" for=\"node\" attr.name=\"screenName\" attr.type=\"int\"></key>"
			    +"<key id=\"favouritesCount\" for=\"node\" attr.name=\"favouritesCount\" attr.type=\"int\"></key>"
			    +"<key id=\"name\" for=\"node\" attr.name=\"name\" attr.type=\"string\"></key>"
			    +"<key id=\"url\" for=\"node\" attr.name=\"url\" attr.type=\"string\"></key>"
			    +"<key id=\"createdAt\" for=\"node\" attr.name=\"createdAt\" attr.type=\"string\"></key>"
			    +"<key id=\"gender\" for=\"node\" attr.name=\"gender\" attr.type=\"string\"></key>"
			    +"<graph id=\"G\" edgedefault=\"directed\">";
					
		bw.write(header);
		bw.newLine();
		
		TwitterNode T1;
		
		String tmp=" ";
		XStream xstream = new XStream(); 
		
		xstream.alias("node", TwitterNode.class);
		xstream.useAttributeFor(TwitterNode.class, "ID");
		
		xstream.aliasField("id", TwitterNode.class, "ID");	
		xstream.aliasField("data key=\"followersCount\"", TwitterNode.class, "followersCount");	
		xstream.aliasField("data key=\"location\"", TwitterNode.class, "location");
		xstream.aliasField("data key=\"description\"", TwitterNode.class, "description");
		xstream.aliasField("data key=\"friendsCount\"", TwitterNode.class, "friendsCount");
		xstream.aliasField("data key=\"screenName\"", TwitterNode.class, "screenName");
		xstream.aliasField("data key=\"favouritesCount\"", TwitterNode.class, "favouritesCount");
		xstream.aliasField("data key=\"name\"", TwitterNode.class, "name");
		xstream.aliasField("data key=\"url\"", TwitterNode.class, "url");
		xstream.aliasField("data key=\"createdAt\"", TwitterNode.class, "createdAt");
		xstream.aliasField("data key=\"gender\"", TwitterNode.class, "gender");
		
		
		//while(SC.hasNext())
		for(int i=0;i<100;i++)
		{
			tmp=SC.nextLine();
			String content[]=tmp.split(" ");
			T1=new TwitterNode(content[0]);
			T1.SetScreen_name(content[1]);
			
			String xml = xstream.toXML(T1).replace("/data key=\"followersCount\"", "/data").replace("/data key=\"location\"", "/data").replace("/data key=\"description\"", "/data").replace("/data key=\"friendsCount\"", "/data").replace("/data key=\"screenName\"", "/data").replace("/data key=\"favouritesCount\"", "/data").replace("/data key=\"name\"", "/data").replace("/data key=\"url\"", "/data").replace("/data key=\"createdAt\"", "/data").replace("/data key=\"gender\"", "/data");
			
			bw.write(xml);
		
			bw.newLine();
		}
		
		SC.close();
		bw.close();
		
	}
	
	
	public static void main(String args[])throws Exception
	{
		AddNodes(args[0],args[1]);
	}

}

