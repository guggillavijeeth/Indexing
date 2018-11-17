package indexing;

import java.io.File;
import java.io.FileNotFoundException;

public class IndexTester {

	public static void main(String [] args) throws FileNotFoundException {
		
		IndexBuilder i = new IndexBuilder();
		File f = new File("C:\\Users\\vijee\\Desktop\\index.txt");
		i.index(f);
		
		
		
		PageTopicPair p1 = new PageTopicPair(100, "Subtraction", "floating-point");
		PageTopicPair p2 = new PageTopicPair(178, "Subtraction", "");
		System.out.println("Final: "+p2.compareTo(p1));
		PageTopicPair p3 = new PageTopicPair(214, "Subtraction", "floating-point");
		System.out.println("Final2: "+p2.compareTo(p3));
		
		
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
