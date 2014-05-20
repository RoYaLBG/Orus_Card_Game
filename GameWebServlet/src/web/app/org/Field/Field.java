package web.app.org.Field;

import java.io.PrintWriter;
import java.util.Hashtable;

import web.app.org.Cards.Cards;

public class Field {

	private Hashtable<String, Integer> fields = new Hashtable<String, Integer>();
	private Hashtable<String, Cards> populatedFields = new Hashtable<String, Cards>();
	
	public Field() {
		for (int i = 1; i<= 5; i++) {
			this.fields.put("realplayer_battle_"+i, 1);
			this.fields.put("realplayer_magic_"+i, 1);
		}
	}
	
	public int getFreeField(String type, PrintWriter out) {
		for (int i = 1; i<= 5; i++) {
			if (this.isFieldFree(type, i)) {
				return i;
			}
		}
		return 0;
	}
	
	public boolean isFieldFree(String type, int id) {
		if(this.fields.get("realplayer_"+type+"_"+id) == 1) {
			return true;
		}
		return false;
	}
	
	public void populateField(String type, int id, Cards card) {
		this.fields.put("realplayer_"+type+"_"+id, 0);
		this.populatedFields.put("realplayer_"+type+"_"+id, card);
	}
	
	
	
	
	
	
}
