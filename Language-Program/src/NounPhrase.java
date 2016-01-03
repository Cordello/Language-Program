import java.util.Queue;

public class NounPhrase extends Argument {
	
	private String determiner;
	private String adverb;
	private String adjective;
	
	public void setDeterminer(String det) {
		
		determiner = det;
	}
	
	public void setAdverb(String adv) {
		
		if (adverb.isEmpty()) adverb = adv;
		else adverb = adverb + " " + adv;
	}
	
	public void setAdjective(String adj) {
		
		if (adjective.isEmpty()) adjective = adj;
		else adjective = adjective + " " + adj;
	}
	
	//head must be nouns
	public void setHead(String s) {
		
		if (head.isEmpty()) head = s;
		else head = head + " " + s;
	}
	
	public void setMod(Modifier m) {
		
		
	}
	
	public void ReadIn(Queue<String> word) {
		
		if (word.peek() == "det")
		{
			setDeterminer(word.poll());
		}
		else
		{
			while (word.peek() == "adv")
			{
				setAdverb(word.poll());
			}
			//needs ERROR if adv and no adj
			while (word.peek() == "adj")
			{
				setAdjective(word.poll());
			}
			//needs ERROR if no det and noun not plural
			//needs ERROR if pronoun has pre-modifiers
			while (word.peek() == "noun")
			{
				setHead(word.poll());
			}
		}
		
		//done with main, start on modifiers
		//special if NounPhrase == pronoun (probably no mods)
		while (word.peek() == "prep or rel pro")
		{
			if (word.peek() == "prep")
			{
				//Read in prepositional phrase
			}
			else if (word.peek() == "rel pro")
			{
				//Read in relative phrase
			}
			//should resolve whether other modifiers mod NounPhrase or Args of the modifiers
		}
	}
}
