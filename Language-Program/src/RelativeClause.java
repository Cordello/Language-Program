import java.util.Queue;

public class RelativeClause extends Modifier {
	
	public void ReadIn(Queue<String> word) {
		
		//Key is a relative pronoun
		setKey(word.poll());
		
		//Read in the subject, if there is one
		Argument sub = Argument.castArg(word);
		sub.ReadIn(word);
		if (sub instanceof InfinitivePhrase)
		{
			//WEIRD, infinitive as the subject of a relative clause sounds strange sometimes
		}
		setSubject(sub);
		
		//Read in the predicate, there must be one
		if (word.peek() == "adv or verb")
		{
			Predicate pred = new Predicate();
			pred.ReadIn(word);
			setPredicate(pred);
		}
		else
		{
			//ERROR, you need at least something
		}
	}
}
