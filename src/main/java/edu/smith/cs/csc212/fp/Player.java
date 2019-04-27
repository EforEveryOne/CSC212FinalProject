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
	
	
//	These points can be spent to increase strength or endurance.
	public void spend_points(Player player) {

		System.out.println("______________________");
		System.out.println("|SPENDING STAT POINTS|");
		System.out.println("Endurance: " + player.endurance + ". ");
		System.out.println("Strength: " + player.strength + ". ");
		
		if (player.stat_points > 0) {
			System.out.println("Unspent points: " + player.stat_points + ". ");
			
//		would be cool to add speed which increases chances of getting a second action in a row sort of thing.	
			
		}
	}
	
//	don't think this is needed... can just call level_up even for initial creation?
	public void calculate_stats(Player player) {	
		player.max_hp = player.endurance * 2 + player.level;
//		heal them up to new full hp.
		player.hp = player.max_hp;
		
//		plus w/e weapon the use?
		player.damage_value = player.strength / 2 + player.level;
		}
	
	public void level_up_check(Player player) {
		if (player.current_exp >= player.next_level_exp) {
			
//			Crossover xp is the remainder of what is left after using enough to level up once.
			int crossover_xp = player.current_exp - player.next_level_exp;
//			Level increase.
			player.level += 1;
//			Stat points to be spent
			player.stat_points += 2;
			
			calculate_stats(player);
			
//			player.current_exp += player.next_level_exp;
			player.next_level_exp += (int) Math.pow(player.current_exp, 1.1);
			player.current_exp += crossover_xp;
//			Final step to handle crossover xp.
			level_up_check(player);
			}
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
