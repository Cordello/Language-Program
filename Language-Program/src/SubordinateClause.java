import java.util.Queue;

public class SubordinateClause extends Modifier{
	
	public void ReadIn(Queue<String> word) {
		
		//Key is a subordinating conjunction
		setKey(word.poll());
		
		//Read in the subject
		Argument sub = Argument.castArg(word);
		sub.ReadIn(word);
		setSubject(sub);
		
		//Read in the predicate
		if (word.peek() == "adv or verb")
		{
			Predicate pred = new Predicate();
			pred.ReadIn(word);
			setPredicate(pred);
		}
		else
		{
			//ERROR, you need a predicate
		}
	}
}
