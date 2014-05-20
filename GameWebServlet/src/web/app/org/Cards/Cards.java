package web.app.org.Cards;

public abstract class Cards {
	protected int id;
	protected int attack;
	protected String effect;
	protected String type;
	
	public Cards (int idd, String eff, int att) {
		this.id = idd;
		this.effect = eff;
		this.attack = att;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getAttack() {
		return this.attack;
	}
	
	public String getEffect() {
		return this.effect;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getImgUrl() {
		return "D:\\\\SoftUni\\\\SoftUni_Java\\\\WebApp\\\\cards\\\\card-"+this.getId()+".png";
	}
}