package dblp;
import java.util.*;
import java.io.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Transform {
	
	private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
	 
	    Node nValue = (Node) nlList.item(0);
	 
		return nValue.getNodeValue();
	  }

	public static void main(String args[])throws Exception
	{
//		Scanner SC=new Scanner(new FileReader(""));
//		String tmp="";
//		while(SC.hasNext())
//		{
//			tmp=SC.nextLine();
//
//			if (tmp.equals("@data"))
//			{
//				break;
//			}
//			
//		}
		
		
		
	
		File fXmlFile = new File("C:/file.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
		
		File file = new File("C:/dblpfile.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		
		
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		NodeList nList = doc.getElementsByTagName("article");
		System.out.println("-----------------------");
		long count=0;
		
		for (int temp = 0; temp < nList.getLength(); temp++) 
		{
 
		   Node nNode = nList.item(temp);
		   if (nNode.getNodeType() == Node.ELEMENT_NODE) 
		   {
 
		      Element eElement = (Element) nNode;
		      
		      System.out.println("author : " + getTagValue("author", eElement));
		      System.out.println("title : " + getTagValue("title", eElement));
	          System.out.println("year : " + getTagValue("year", eElement));
	          System.out.println("journal : " +getTagValue("journal", eElement));
		     // System.out.println("month : " + getTagValue("month", eElement));
		      System.out.println();
		      String tmp=getTagValue("author", eElement)+" "+getTagValue("title", eElement)+" "+getTagValue("year", eElement)+" "+getTagValue("journal", eElement);
		      bw.write(count+" "+tmp+System.getProperty("line.separator") );
		      count++;
		   }						
		}	
		
		NodeList nList2 = doc.getElementsByTagName("www");
		System.out.println("-----------------------");
 
		for (int temp = 0; temp < nList2.getLength(); temp++) 
		{
 
		   Node nNode = nList2.item(temp);
		   if (nNode.getNodeType() == Node.ELEMENT_NODE) 
		   {
 
		      Element eElement = (Element) nNode;
 
		      System.out.println("author : " + getTagValue("author", eElement));
		      System.out.println("title : " + getTagValue("title", eElement));
	          System.out.println("year : " + getTagValue("year", eElement));
	          String tmp=getTagValue("author", eElement)+" "+getTagValue("title", eElement)+" "+getTagValue("year", eElement);
		    //  System.out.println("month : " + getTagValue("month", eElement));
	          bw.write(count+" "+tmp+System.getProperty("line.separator") );
		      count++;
		   }						
		}
		bw.close();

	}
}
