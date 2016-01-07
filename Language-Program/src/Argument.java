import java.util.Queue;

public abstract class Argument {
	
	private String head;
	private Modifier mod;
	
	// make sure not to call setHead() more than once for GerundPhrases and InfinitivePhrases
	// we'll see
	public void setHead(String s) 
	{	
		if (head.isEmpty()) head = s;
		else head = head + " " + s;
	}
	
	public void setMod(Modifier m)
	{
		mod = m;
	}
	
	public abstract void ReadIn(Queue<String> word);
	
	public String getHead()
	{
		return head;
	}
	
}
