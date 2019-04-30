package edu.smith.cs.csc212.fp;

import java.util.Random;

public class Enemy {
	String name;
	int hp;
	static int max_hp;
	static int defense_value;
	static int damage_value;
	
//	?
	int currency_reward;
	int exp_reward;
	
	
	public Enemy(String name,
			int hp,
			int max_hp,
			int defense_value,
			int damage_value,
			int currency_reward,
			int exp_reward) {
		this.name = name;
		this.hp = hp;
		Enemy.max_hp = max_hp;
		Enemy.defense_value = defense_value;
		Enemy.damage_value = damage_value;
		this.currency_reward = currency_reward;
		this.exp_reward = exp_reward;
		}
	
	
	 static Random rand = new Random();
	
	
	public static void roll_random_enemy(Enemy enemy){
		make_human(enemy);
		System.out.println(enemy.name + enemy.hp + enemy.defense_value);
		
		
//		weighted random roll to make a "type" of enemy
//		call make that specific type method (which will have varied values within reason.)
		
		
	}
	
	public static void make_human(Enemy enemy) {
		enemy.name = "Human";
		Enemy.max_hp = rand.nextInt(10 + 5);
		enemy.hp = max_hp;
		Enemy.defense_value = rand.nextInt(1);
		Enemy.damage_value =  rand.nextInt(2 + 1);
		enemy.currency_reward =  rand.nextInt(10 + 2);
		enemy.exp_reward = (Enemy.max_hp + Enemy.defense_value + Enemy.damage_value) * 2;
		}
	
	public void make_wolf(Enemy enemy) {
		enemy.name = "Wolf";
//		enemy.hp =
//		enemy.max_hp =
//		enemy.defense_value =
//		enemy.damage_value =
//		enemy.currency_reward = 
//		enemy.exp_reward = 
		
	}
	
	public void make_bear(Enemy enemy) {
		enemy.name = "Bear";
//		enemy.hp =
//		enemy.max_hp =
//		enemy.defense_value =
//		enemy.damage_value =
//		enemy.currency_reward = 
//		enemy.exp_reward = 
		
	}

}
