import java.util.Queue;

public class VerbPhrase {

	private String verb;
	private String tense; //must be past, present, or future
	//Except that's a dumb way to store this information
	private boolean perfect;
	private boolean continuous;
	
	public void setVerb(String v) {
		verb = v;
	}
	
	public void setTense(String t) {
		tense = t;
	}
	
	public void setPerfect(boolean p) {
		perfect = p;
	}
	
	public void setContinuous(boolean c) {
		continuous = c;
	}
	
	public void ReadIn(Queue<String> word) {
		
		/*
		
		past - first verb is in past
		present - first verb is in present
		future - first verb is will, next verb is infinitive without "to"
		
		perfect - next verb is "have" then next is past participle
		continuous - next verb is "be", then next is present participle
		
		Ex. "I will be running tomorrow" is future and continuous
		Ex. "By the end of the night, we had danced a hundred times" is past and perfect
		Ex. "By the time I found out, we had been dating for a year" past, perfect, and continuous
		Ex. "I have been juggling for two years." is present, perfect, and continuous
		
		*/
		
		String temp = word.poll();
		
		//check if future (or past or present)
		if (temp == "will" && word.peek() == "infinitive verb")
		{
			setTense("future");
			temp = word.poll();
		}
		else
		{
			if (temp == "past") setTense("past");
			else setTense("present");
		}
		
		//check if perfect
		if (temp == "have" && word.peek() == "past participle verb")
		{
			setPerfect(true);
			temp = word.poll();
		}
		
		//check if continuous
		if (temp == "be" && word.peek() == "present participle verb")
		{
			setContinuous(true);
			temp = word.poll();
		}
		
		setVerb(temp);
		
		//Needs a grammar error if the next word (peek) is a verb of incorrect form
		//I also hate the use of peek
	}
	
	public String getVerb() {
		return verb;
	}
}
