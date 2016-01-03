import java.util.Queue;

public abstract class Argument {
	
	protected String head;
	protected Modifier mod;
	
	public abstract void setHead(String s);
	public abstract void setMod(Modifier m);
	public abstract void ReadIn(Queue<String> word);
}
