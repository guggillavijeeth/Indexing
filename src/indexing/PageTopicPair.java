package indexing;

public class PageTopicPair implements Comparable<PageTopicPair>{

	// implements Comparable<PageTopicPair>

	private String page;
	private String topic;
	private String subTopic;

	public PageTopicPair(String pageInput, String topicInput, String subTopicInput) {
		page = pageInput;
		topic = topicInput;
		subTopic = subTopicInput;
	}

	public String getPage(){
		return page;
	}

	public String getTopic() {
		return topic;
	}

	public String getSubTopic() {
		return subTopic;
	}

	/*
	@Override
	public int compareTo(PageTopicPair rhs) {

		int topicComparison = this.getTopic().compareTo(rhs.getTopic());
		//System.out.println(topicComparison);
		int subTopicComparison = this.getSubTopic().compareTo(rhs.getSubTopic());
		//System.out.println(subTopicComparison);
		int pageComparison = this.getPage().compareTo(rhs.getPage());
		//System.out.println(pageComparison);

		if(topicComparison > 0){
			return 1;
		}

		if(topicComparison == 0){
			if(this.subTopic.equals("")){
				if(pageComparison > 0){
					return 1;
				}
				else {
					return -1;
				}
			}
			else {
				if(subTopicComparison > 0)
					return 1;
				if(subTopicComparison == 0) {
					if(pageComparison > 0){
						return 1;
					}
					else {
						return -1;
					}
				}
				else
					return -1;
			}
		}
		return -1;
	}
	 */

	@Override
	public int compareTo(PageTopicPair rhs) {

		int topicComparison = this.getTopic().compareTo(rhs.getTopic());

		if(topicComparison > 0){
			return 1;
		}

		int subTopicComparison = this.getSubTopic().compareTo(rhs.getSubTopic());
		
		Integer page = Integer.parseInt(this.getPage().split("-",0)[0]);
		Integer rhsPage = Integer.parseInt(rhs.getPage().split("-", 0)[0]);
		
		int pageComparison = page.compareTo(rhsPage);

		if(topicComparison == 0){
			if((subTopicComparison == 0)){
				if(pageComparison > 0)
					return 1;
				else if (pageComparison == 0)
					return 0;
				else 
					return -1;
			}
			else {
				if(subTopicComparison > 0)
					return 1;
				else
					return -1;
			}
		}
		return -1;
	}
}

//((this.subTopic.equals(""))&&(rhs.subTopic.equals(""))) ||

/*if(subTopicComparison == 0) {
if(pageComparison > 0){
	return 1;
}
else {
	return -1;
}
}*/