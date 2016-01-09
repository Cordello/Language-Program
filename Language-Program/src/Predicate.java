import java.util.Queue;

public class Predicate {

	private VerbPhrase verb;
	private Argument directOb;
	private Modifier mod;
	
	public void setVerb(VerbPhrase v) {
		verb = v;
	}
	
	public void setDirectOb(Argument dirOb) {
		directOb = dirOb;
	}
	
	public void setMod(Modifier m) {
		mod = m;
	}
	
	public void ReadIn(Queue<String> word) {
		
		VerbPhrase v = new VerbPhrase();
		v.ReadIn(word);
		setVerb(v);
		
		//If the verb is strictly transitive, it requires a direct object
		if(v.getVerb() == "transitive and NOT intransitive")
		{
			Argument dirOb = Argument.castArg(word);
			if (dirOb.ReadIn(word) == false) //false means EmptyArgument
			{
				//ERROR, need a direct object
			}
			
			setDirectOb(dirOb);
		}
				
		//If the verb could be either transitive or intransitive, direct object possible but not required
		else if(v.getVerb() == "transitive and intransitive")
		{
			Argument dirOb = Argument.castArg(word);
			dirOb.ReadIn(word);
			setDirectOb(dirOb);
		}
		
		//If verb is intransitive, there must be no direct object
		else 
		{
			Argument dirOb = Argument.castArg(word);
			if (dirOb.ReadIn(word))
			{
				//ERROR must have no direct object
			}
		}
		
		//Read in modifiers, if they exist
		if (word.peek() == "prep or sub conj")
		{
			if (word.peek() == "prep")
			{
				//Read in prepositional phrase
			}
			else if (word.peek() == "sub conj")
			{
				//Read in subordinate clause
			}
		}
	}
}
