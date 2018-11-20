//TODO: Check for correct formatting of the input string and propagate if error thrown
//TODO: Might just write a whole formatting function to take care of all of it and have it called

package indexing;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalArgumentException;
import java.util.Iterator;
import java.util.Scanner;
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
		//TODO: Close the scanner
		@SuppressWarnings("resource")
		Scanner s = new Scanner(f);
		while(s.hasNextLine()) {
			String current = s.nextLine().trim();
			PageTopicPair p;
			try {
				p = parse(current);
			}
			catch (IllegalArgumentException e) {
				continue;
			}
			//System.out.println(p==null);
			//System.out.println("Topic: "+ p.getTopic()+" SubTopic: "+p.getSubTopic()+" Page: "+p.getPage());
			indexTree.add(p);
		}
	}

	private static PageTopicPair parse(String s) throws IllegalArgumentException {
		
		String page = ""; String topic = ""; String subTopic = "";

		String[] strArr = s.split(": ", 0);
		if(strArr.length>2) {
			System.err.println("Unsupported Line: "+ s + "\nHeading or subheading text contained ':'");
			throw new IllegalArgumentException();
		}
		//System.out.println(strArr[0]);
		//System.out.println(strArr[1]);
		page = strArr[0].trim();

		String[] strArr2 = strArr[1].split("/", 0);
		if(strArr2.length>2) {
			System.err.println("Unsupported Line: "+ s + "\nHeading or subheading text contained '\'");
			throw new IllegalArgumentException();
		}
		//System.out.println(strArr2[0]);
		//System.out.println(strArr2[1]);
		//System.out.println(strArr2.length);
		topic = strArr2[0].trim();
		if(strArr2.length>1)
			subTopic = strArr2[1].trim();

		if(topic.equals("")) {
			System.err.println("Unsupported Line: "+ s + "\nNo topic'\'");
			throw new IllegalArgumentException();
		}
		
		PageTopicPair p = new PageTopicPair(page, topic, subTopic);
		return p;
	}

	private void printIndex() {
		Iterator<PageTopicPair> itr = indexTree.iterator();
		String currentTopic = "";
		String activeTopic = "";
		String currentSubTopic = "";
		String activeSubTopic = "";
		boolean notPrintFirst = false;
		while(itr.hasNext()) {
			PageTopicPair p = itr.next();
			currentTopic = p.getTopic();
			currentSubTopic = p.getSubTopic();
			String currentPage = p.getPage();
			if(!currentTopic.equals(activeTopic)) {
				if(notPrintFirst)
					System.out.println();
				notPrintFirst = true;
				System.out.print(currentTopic);
				activeTopic = currentTopic;
			}
			if((!currentSubTopic.equals(activeSubTopic))&&(!currentSubTopic.equals(""))){
				System.out.println();
				System.out.print("    "+currentSubTopic);
				activeSubTopic = currentSubTopic;
			}
			System.out.print(", "+currentPage);
		}
		System.out.println();
	}

	public void index(File f) throws FileNotFoundException {
		this.fillTree(f);
		this.printIndex();
	}
}
