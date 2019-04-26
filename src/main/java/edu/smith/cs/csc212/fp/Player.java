package edu.smith.cs.csc212.fp;

public class Player {
	
//	personal stuff
	String name;
	int age;
	
	int hp;
	int max_hp;
	
// 	stats
	int stat_points;
	int endurance;
	int strength;
	
	int defense_value;
	int damage_value;
	
//	level
	int level;
	int current_exp;
	int next_level_exp;
	
	int currency;

	
	
	
	public Player(String name,
			int hp,
			int age,
			int max_hp,
			int stat_points,
			int endurance,
			int strength, 
			int defense_value, 
			int damage_value,
			int level,
			int current_exp,
			int next_level_exp,
			int currency) {
		this.name = name;
		this.age = age;
		this.hp = hp;
		this.max_hp = max_hp;
		this.stat_points = stat_points;
		this.endurance = endurance;
		this.strength = strength;
		this.defense_value = defense_value;
		this.damage_value = damage_value;
		this.level = level;
		this.current_exp = current_exp;
		this.next_level_exp = next_level_exp;
		this.currency = currency;
		}
	
//	don't think this is needed... can just call level_up even for initial creation?
	public static void calculate_stats(String name, int endurance, int strength) {
		
		
		
		
		
//		Player player = new Player("TestName", 0, 10, 10, 5, 5, 0, 1, 1, 1, 100, 10, 0);
		
	}
	
//	These points can be spent to increase strength or endurance.
	public void spend_points(Player player) {
		System.out.println("urrently have: " + player.endurance + " ");
		
		if (player.stat_points > 0) {
			
			
		}
	}
	
	public void level_up_check(Player player) {
		if (player.current_exp >= player.next_level_exp) {
			int crossover_xp = 0;
			
			player.current_exp += player.next_level_exp;
			
			
		}
// recur at end to handle multiple level ups, though I don't think there will be any way to gain an abundance of xp.
		level_up_check(player);
	}
	
	public String print_details() {
		return ("\nPlayer Info: \nName: " + name + "."
				+ "\nAge: " + age + "."
				+ "\nHitpoints: " + hp + "/" + max_hp + "."
				+ "\nUnspent points: " + stat_points + "."
				+ "\nEndurance: " + endurance + "."
				+ "\nStength: " + strength + "."
				+ "\nArmor: " + defense_value + "."
				+ "\nDamage: " + damage_value + "."
				+ "\nLevel: " + level + "."
				+ "\nExperience: " + current_exp + "."
				+ "\nNext Level: " + next_level_exp + "."
				+ "\nPlaceholder for inventory/money: " + currency + ".");
		}
	
//	handle gold/items in player class or separate class?
//	think it makes sense to do in here because I could do the same thing for enemies.
//	if inventory is it's own class, does that mean it's "universal"?
//	would make it difficult to handle multiple inventories?
	
//	or just have a player inventory which extends/supers inventory?
	
	
	

}
