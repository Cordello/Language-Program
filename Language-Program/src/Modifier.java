import java.util.Queue;

public abstract class Modifier {
	
	private String key; // preposition, relative pronoun, or subordinating conjunction
	private Argument subject; //could be equal to key in relative clause
	private Predicate predicate; //none in prepositional phrase
	
	public abstract void ReadIn(Queue<String> word);

	public String getKey() {
		return key;
	}

	public void setKey(String s) {
		key = s;
	}

	public Argument getSubject() {
		return subject;
	}

	public void setSubject(Argument sub) {
		subject = sub;
	}

	public Predicate getPredicate() {
		return predicate;
	}

	public void setPredicate(Predicate pred) {
		predicate = pred;
	}
}
