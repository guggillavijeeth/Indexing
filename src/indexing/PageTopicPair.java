package indexing;

public class PageTopicPair implements Comparable<PageTopicPair>{

	// implements Comparable<PageTopicPair>

	private Integer page;
	private String topic;
	private String subTopic;

	public PageTopicPair(Integer pageInput, String topicInput, String subTopicInput) {
		page = pageInput;
		topic = topicInput;
		subTopic = subTopicInput;
	}

	public Integer getPage(){
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
		int pageComparison = this.getPage().compareTo(rhs.getPage());

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