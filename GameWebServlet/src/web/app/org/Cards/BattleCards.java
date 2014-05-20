package web.app.org.Cards;

public class BattleCards extends Cards {
	protected int id;
	protected int attack;
	protected String type = "battle";
	
	public BattleCards (int idd, String eff, int att) {
		super(idd, eff, att);
	}
	
	public String getType() {
		return this.type;
	}

}