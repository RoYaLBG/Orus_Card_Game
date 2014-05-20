package web.app.org.Cards;

public class MagicCards extends Cards {
	protected int id;
	protected String effect;
	protected String type = "magic";
	
	public MagicCards(int idd, String eff, int att) {
		super(idd, eff, att);
	}
	
	public String getType() {
		return this.type;
	}
}