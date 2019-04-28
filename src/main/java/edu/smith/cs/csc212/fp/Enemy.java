package edu.smith.cs.csc212.fp;

public class Enemy {
	String name;
	int hp;
	int max_hp;
	int defense_value;
	int damage_value;
	
//	?
	int currency_reward;
	
	
	public Enemy(String name,
			int hp,
			int max_hp,
			int defense_value,
			int damage_value,
			int currency_reward) {
		this.name = name;
		this.hp = hp;
		this.max_hp = max_hp;
		this.defense_value = defense_value;
		this.damage_value = damage_value;
		this.currency_reward = currency_reward;
		}
	
	
	public void create_random_enemy(){
		
//		weighted random roll to make a "type" of enemy
//		call make that specific type method (which will have varied values within reason.)
		
		
	}
	
	public void make_human() {
		
	}
	
	public void make_bear() {
		
	}

}
