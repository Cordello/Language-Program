import java.util.Queue;

public class InfinitivePhrase extends Argument {
	
	//only if infinitive is transitive
	private Argument directOb;
	
	public void setDirectOb(Argument dirOb) {
		directOb = dirOb;
	}
	
	
	public boolean ReadIn(Queue<String> word) {
		
		//Head is an infinitive
		setHead(word.poll());
				
		//If the infinitive is strictly transitive, it requires a direct object
		if(getHead() == "transitive and NOT intransitive")
		{
			Argument dirOb = Argument.castArg(word);
			if (dirOb.ReadIn(word) == false) //false means EmptyArgument
			{
				//ERROR, need a direct object
			}
			else if(dirOb instanceof InfinitivePhrase)
			{
				//WEIRD, an infinitive on an infinitive is odd
			}
					
			setDirectOb(dirOb);
		}
				
		//If the infinitive could be either transitive or intransitive, direct object possible but not required
		else if(getHead() == "transitive and intransitive")
		{
			Argument dirOb = Argument.castArg(word);
			dirOb.ReadIn(word);
			setDirectOb(dirOb);
		}
				
		//If infinitive is intransitive, there must be no direct object
		else 
		{
			Argument dirOb = Argument.castArg(word);
			if (dirOb.ReadIn(word))
			{
				//ERROR must have no direct object
			}
		}
				
		//Read in any modifiers, if they exist
		while (word.peek() == "prep or rel pro")
		{
			if (word.peek() == "prep")
			{
				PrepositionalPhrase prep = new PrepositionalPhrase();
				prep.ReadIn(word);
				setMod(prep);
			}
			else if (word.peek() == "rel pro")
			{
				RelativeClause rel = new RelativeClause();
				rel.ReadIn(word);
				setMod(rel);
			}
		}
		//should resolve whether (other) modifiers mod gerund(head), Arg of DO, or Args of modifiers
		//no fucking clue how
				
		//Not an empty object
		return true;
	}
}
