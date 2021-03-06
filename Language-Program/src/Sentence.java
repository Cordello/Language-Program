import java.util.Queue;

public abstract class Sentence {

	/*
	 
	can be
	a statement (declarative)
	a question (interrogative)
	a command (imperative)
	(moods)
	 
	*/
	
	private Argument subject; //imperative has no subject
	private Predicate predicate;
	
	public void setSubject (Argument sub) {
		
		subject = sub;
	}
	public void setPredicate (Predicate pred) {
		
		predicate = pred;
	}
	
	//different between moods
	public abstract void ReadIn(Queue<String> word);
	
}
