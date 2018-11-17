package indexing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class IndexBuilder {

	/*
	public IndexBuilder() {
	}
	
	private TreeMap<String, TreeSet<Integer>> indexTree = new TreeMap<String, TreeSet<Integer>>();
	
	private void fillTree(File f) throws FileNotFoundException {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(f);
		while(s.hasNextLine()) {
			String current = s.nextLine().trim();
			//PageTopicPair p = parse(current);
			
			String [] arr = parse(current);
			Integer page = Integer.parseInt(arr[0]);
			String topic = arr[1];
			
			if (indexTree.containsKey(topic)){
				TreeSet<Integer> tSet = indexTree.remove(topic);
				tSet.add(page);
				indexTree.put(topic, tSet);
			}
			else {
			//System.out.println("Topic: "+ p.getTopic()+" Page: "+p.getPage());
			TreeSet<Integer> t = new TreeSet<Integer>();
			t.add(page);
			indexTree.put(topic, t);
			}
		}
	}
	
	private static String [] parse(String s) {
		
		//Integer page; String topic = "";
		
		String[] strArr = s.split(": ", 0);
		System.out.println(strArr[0]);
		//System.out.println(strArr[1]);
		//page = Integer.parseInt(strArr[0]);
		//topic = strArr[1];
	
		//PageTopicPair p = new PageTopicPair(page, topic);
		return strArr;
	}
	
	private void printIndex() {

		Set<Map.Entry<String, TreeSet<Integer>>> set = indexTree.entrySet();

		// Get an iterator
		Iterator<Map.Entry<String, TreeSet<Integer>>> it = set.iterator();

		// Display elements
		while(it.hasNext()) {
			Map.Entry<String, TreeSet<Integer>> me = (Map.Entry<String, TreeSet<Integer>>)it.next();
			System.out.print("Key is: "+me.getKey() + " & ");
			System.out.println("Value is: "+me.getValue());
		} 
	}
	
	public void index(File f) throws FileNotFoundException {
		this.fillTree(f);
		this.printIndex();
	}
	*/

	public IndexBuilder() {
	}
	
	private TreeSet<PageTopicPair> indexTree = new TreeSet<PageTopicPair>();
	
	private void fillTree(File f) throws FileNotFoundException {
		Scanner s = new Scanner(f);
		while(s.hasNextLine()) {
			String current = s.nextLine().trim();
			PageTopicPair p = parse(current);
			//System.out.println(p==null);
			//System.out.println("Topic: "+ p.getTopic()+" SubTopic: "+p.getSubTopic()+" Page: "+p.getPage());
			indexTree.add(p);
		}
	}
	
	private static PageTopicPair parse(String s) {
		
		Integer page; String topic; String subTopic = "";
		
		String[] strArr = s.split(": ", 0);
		//System.out.println(strArr[0]);
		//System.out.println(strArr[1]);
		page = Integer.parseInt(strArr[0]);
		
		String[] strArr2 = strArr[1].split("/", 0);
		//System.out.println(strArr2[0]);
		//System.out.println(strArr2[1]);
		//System.out.println(strArr2.length);
		topic = strArr2[0].trim();
		if(strArr2.length>1)
			subTopic = strArr2[1].trim();
	
		PageTopicPair p = new PageTopicPair(page, topic, subTopic);
		return p;
	}
	
	private void printIndex() {
		Iterator<PageTopicPair> itr = indexTree.iterator();
		while(itr.hasNext()) {
			PageTopicPair p = itr.next();
			System.out.println("Topic: "+p.getTopic()+" Page: "+p.getPage()+" Subtopic: "+p.getSubTopic());
		}
	}
	
	public void index(File f) throws FileNotFoundException {
		this.fillTree(f);
		this.printIndex();
	}
}
