package dblp;
import java.util.*;
import java.io.*;

import javax.xml.XMLConstants;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class TransformSax {
	


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
		File file = new File("C:/dblpfile.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		final BufferedWriter bw = new BufferedWriter(fw);
		
		
			
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
		SAXParser saxParser = factory.newSAXParser();
		DefaultHandler handler = new DefaultHandler() {
		long count=0;
		boolean bArticle = false;
		boolean bwww = false;	
		boolean binproceedings = false;
		boolean bincollection  = false;
		boolean bphdthesis  = false;
		boolean bmastersthesis  = false;
		
		boolean bAuthor = false;
		boolean bEditor = false;
		boolean bTitle = false;
		boolean bYear = false;
		boolean bJournal = false;
	 
		public void startElement(String uri, String localName,String qName, 
	                Attributes attributes) throws SAXException {
	 
			//System.out.println("Start Element :" + qName);
			
			if (qName.equalsIgnoreCase("Article")) {
				bArticle = true;
			}
			
			if (qName.equalsIgnoreCase("www")) {
				bwww = true;
			}
			
			if (qName.equalsIgnoreCase("inproceedings")) {
				binproceedings = true;
			}
			
			if (qName.equalsIgnoreCase("incollection")) {
				bincollection = true;
			}
			
			if (qName.equalsIgnoreCase("phdthesis")) {
				bphdthesis = true;
			}
			
			if (qName.equalsIgnoreCase("mastersthesis")) {
				bmastersthesis = true;
			}
			
			if (qName.equalsIgnoreCase("author")) {
				bAuthor = true;
			}
	 
			if (qName.equalsIgnoreCase("editor")) {
				bEditor = true;
			}
			
			if (qName.equalsIgnoreCase("title")) {
				bTitle = true;
			}
	 
			if (qName.equalsIgnoreCase("year")) {
				bYear = true;
			}
	 
			if (qName.equalsIgnoreCase("journal")) {
				bJournal = true;
			}
	 
		}
	 
		public void endElement(String uri, String localName,
			String qName) throws SAXException {
	 
			//System.out.println("End Element :" + qName);
	 
		}
	 
		public void characters(char ch[], int start, int length) throws SAXException {
			
			
			if (bArticle) {
				try
				{
					bw.write(System.getProperty("line.separator")+count+"\t");
				}
				catch(Exception e) 
				{
					e.printStackTrace();
				}
				count++;
				bArticle = false;
			}
			
			if (bwww) {
				try
				{
					bw.write(System.getProperty("line.separator")+count+"\t");
				}
				catch(Exception e) 
				{
					e.printStackTrace();
				}
				count++;
				bwww = false;
			}
			
			if (binproceedings) {
				try
				{
					bw.write(System.getProperty("line.separator")+count+"\t");
				}
				catch(Exception e) 
				{
					e.printStackTrace();
				}
				count++;
				binproceedings = false;
			}
			
			if (bincollection) {
				try
				{
					bw.write(System.getProperty("line.separator")+count+"\t");
				}
				catch(Exception e) 
				{
					e.printStackTrace();
				}
				count++;
				bincollection = false;
			}
			
			if (bphdthesis) {
				try
				{
					bw.write(System.getProperty("line.separator")+count+"\t");
				}
				catch(Exception e) 
				{
					e.printStackTrace();
				}
				count++;
				bphdthesis = false;
			}
			
			if (bmastersthesis) {
				try
				{
					bw.write(System.getProperty("line.separator")+count+"\t");
				}
				catch(Exception e) 
				{
					e.printStackTrace();
				}
				count++;
				bmastersthesis = false;
			}
			
	 
			if (bAuthor) {
				//System.out.println("author : " + new String(ch, start, length));
				try
				{
					bw.write(new String(ch, start, length)+", ");
				}
				catch(Exception e) 
				{
					e.printStackTrace();
				}
				bAuthor = false;
			}
			
			if (bEditor) {
				//System.out.println("author : " + new String(ch, start, length));
				try
				{
					bw.write(new String(ch, start, length)+", ");
				}
				catch(Exception e) 
				{
					e.printStackTrace();
				}
				bEditor = false;
			}
	 
			if (bTitle) {
				//System.out.println("title : " + new String(ch, start, length));
				try
				{
					bw.write(new String(ch, start, length)+" ");
				}
				catch(Exception e) 
				{
					e.printStackTrace();
				}
				bTitle = false;
			}
	 
			if (bYear) {
				//System.out.println("year : " + new String(ch, start, length));
				try
				{
					bw.write(new String(ch, start, length)+" ");
				}
				catch(Exception e) 
				{
					e.printStackTrace();
				}
				bYear = false;
			}
	 
			if (bJournal) {
				//System.out.println("journal : " + new String(ch, start, length));
				try
				{
					bw.write(new String(ch, start, length)+" ");
				}
				catch(Exception e) 
				{
					e.printStackTrace();
				}
				bJournal = false;
			}
			
			
	 
		}
	 
	     };
	 
	       saxParser.parse("c:\\dblp.xml", handler);
	       
	       bw.close();

	}
}
