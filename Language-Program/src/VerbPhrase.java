import java.util.Queue;

public class VerbPhrase {

	/*
	
	is it past, present, or future
	is it perfect
	is it continuous
	
	has
	a verb phrase //the will, have, be, and actual verb
	prepositional phrase
	subordinate clause
	
	*/
	private String verb;
	
	public void ReadIn(Queue<String> word) {
		
		/*
		
		past - first verb is in past
		present - first verb is in present
		future - first verb is will, next verb is infinitive without "to"
		
		perfect - next verb is "have" then next is past participle
		continuous - next verb is "be", then next is present participle
		
		*/
	}
	
	public String getVerb() {
		return verb;
	}
}
