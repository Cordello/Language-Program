import java.util.Queue;

public class Statement extends Sentence {
	
	public void ReadIn(Queue<String> word) {
		
		if (word.peek() == "det, adv, adj, or noun")
		{
			NounPhrase nPh = new NounPhrase();
			nPh.ReadIn(word);
			setSubject(nPh);
		}
		else if (word.peek() == "present participle")
		{
			GerundPhrase gerund = new GerundPhrase();
			gerund.ReadIn(word);
			setSubject(gerund);
		}
		else if (word.peek() == "to")
		{
			//kind of weird as a subject
			InfinitivePhrase inf = new InfinitivePhrase();
			inf.ReadIn(word);
			setSubject(inf);
		}
		//could also be a relative clause, which would make it a noun clause
		
		
		//once that's done, start on the verbs
		if (word.peek() == "adv or verb")
		{
			Predicate pred = new Predicate();
			pred.ReadIn(word);
			setPredicate(pred);
		}
		
		//if not, ERROR because you need a damn verb
	}

}
