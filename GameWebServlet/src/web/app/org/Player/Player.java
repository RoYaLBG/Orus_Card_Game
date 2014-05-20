package web.app.org.Player;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import web.app.org.Cards.BattleCards;
import web.app.org.Cards.Cards;
import web.app.org.Cards.MagicCards;
import web.app.org.Field.Field;


public class Player {
	
	private List<Cards> deck = new ArrayList<Cards>();
	private List<Cards> hand = new ArrayList<Cards>();
	private Field field;
	
	public Player(Field _field) {
		this.initCards();
		this.field = _field;
	}

	public String drawCard() {
		if(this.hand.size() < 5) {
			long seed = System.nanoTime();
			Collections.shuffle(deck, new Random(seed));
			String ret = "{\"id\":"+deck.get(0).getId()+",\"url\":\""+ deck.get(0).getImgUrl() + "\"}";
			this.addToHand(deck.get(0));
			this.removeCard(0);
			return ret;
		}
		return "{\"error\":\"hand is full\"}";
	}
	
	private void initCards() {
		String[] effects = new String[] {"fire", "battle", "metal", "water", "fire", "battle", "metal", "water", "battle", "metal", "water" };
		for (int i = 0; i < 9; i++) {
			deck.add(new MagicCards((i+8), effects[i], 0));
			deck.add(new BattleCards(i, "", 1000+(i*i*100)));
		}
	}
	
	private void removeCard(int num) {
		this.deck.remove(num);
	}
	
	private void addToHand(Cards card) {
		this.hand.add(card);
	}
	
	private void removeFromHand(int id) {
		Iterator<Cards> c = this.hand.iterator();
		while (c.hasNext()) {
			Cards s = c.next();
			if (s.getId() == id) {
				c.remove();
			}
		}
	}
	
	private Cards getCardInHand(int id) {
		for (Cards c: this.hand) {
			if (c.getId() == id) {
				return c;
			}
		}
		return null;
	}
	
	public String setOnField(PrintWriter out, int id) {
		if(this.getCardInHand(id) == null) return "{\"error\":\"no such card\"}";
		if(this.hand.size() > 0) {
			int freeField = this.field.getFreeField(this.getCardInHand(id).getType(), out);
			if(freeField == 0) {
				this.setOnField(out, id);
			}
			String ret = "{\"id\":"+id+",\"url\":\""+ this.getCardInHand(id).getImgUrl() + "\",\"type\":\""+ this.getCardInHand(id).getType() + "\",\"freeField\":\""+ freeField + "\"}";
			this.field.populateField(this.getCardInHand(id).getType(), id, this.getCardInHand(id));
			this.removeFromHand(id);
			return ret;
		}
		return "{\"error\":\"no hand\"}";
	}
	

	
}
