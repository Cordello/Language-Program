
public abstract class RelativeClause extends Modifier
{
	private String key; // preposition, relative pronoun, or subordinating conjunction
	// needs something to represent either a argument (prep), predicate (relative clause), or both (relative clause or subordinate clause)

	/*
	
	has
	a relative pronoun
	a sentence //subject could be the relative pronoun, must be a statement
	//should not have an infinitive phrase as subject
	
	*/
	
	public abstract void ReadIn();

	public String getKey() {
		return key;
	}

	public void setKey(String s) {
		key = s;
	}
}
