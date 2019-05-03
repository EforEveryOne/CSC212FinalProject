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
		Random rand = new Random();
		int enemy_roll = rand.nextInt(100);
		
		
		if (enemy_roll >= 90) {
			make_bear(enemy);
			System.out.println("\nYou encountered a " + (enemy.name) + "! They don't look friendly! ");
			}
		else if (enemy_roll >= 60) {
			make_wolf(enemy);
			System.out.println("\nYou encountered a " + (enemy.name) + "! They don't look friendly! ");
			}
		else if (enemy_roll <= 59) {
			make_human(enemy);
			System.out.println("\nYou encountered a " + (enemy.name) + "! They don't look friendly! ");
			}
//		System.out.println(enemy.hp + " " + Enemy.defense_value);
		}
	
	public static void make_human(Enemy enemy) {
		enemy.name = "Human";
		Enemy.max_hp = rand.nextInt(10) + 7;
		enemy.hp = max_hp;
		Enemy.defense_value = rand.nextInt(2);
		Enemy.damage_value = rand.nextInt(2) + 1;
		enemy.currency_reward =  rand.nextInt(10) + 2;
		enemy.exp_reward = (Enemy.max_hp + Enemy.defense_value + Enemy.damage_value) * 2;
		}
	
	public static void make_wolf(Enemy enemy) {
		enemy.name = "Wolf";
		Enemy.max_hp = rand.nextInt(8) + 2;
		enemy.hp = max_hp;
		Enemy.defense_value = rand.nextInt(1);
		Enemy.damage_value = rand.nextInt(4) + 2;
		enemy.currency_reward =  rand.nextInt(3);
		enemy.exp_reward = (Enemy.max_hp + Enemy.defense_value + Enemy.damage_value) * 2;
		}
	
	public static void make_bear(Enemy enemy) {
		enemy.name = "Bear";
		Enemy.max_hp = rand.nextInt(60) + 40;
		enemy.hp = max_hp;
		Enemy.defense_value = rand.nextInt(10) + 5;
		Enemy.damage_value = rand.nextInt(20) + 10;
		enemy.currency_reward =  rand.nextInt(1000);
		enemy.exp_reward = (Enemy.max_hp + Enemy.defense_value + Enemy.damage_value) * 2;
		}
	}
