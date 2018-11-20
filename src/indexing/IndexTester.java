package indexing;

import java.io.File;
import java.io.FileNotFoundException;

public class IndexTester {

	public static void main(String [] args) throws FileNotFoundException {
		
		
		IndexBuilder i = new IndexBuilder();
		File f = new File(args[0]);
		i.index(f);
		
		/*
		PageTopicPair p1 = new PageTopicPair("79", "Exponential sums", "");
		PageTopicPair p2 = new PageTopicPair("113", "Subtraction", "");
		System.out.println("Final: "+p2.compareTo(p1));
		PageTopicPair p3 = new PageTopicPair(, "Subtraction", "floating-point");
		System.out.println("Final2: "+p2.compareTo(p3));
		*/
		
	}
	
	
}


/*;
		String cst = this.getSubTopic();
		String rst = rhs.getSubTopic();
		if(cst.equals("") && (!rst.equals(""))) {
			return 1;
		}
		else
		*/
