package com.sky.isles;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Kits {
	private Main main;
	public Kits(Main main){
		this.main = main;	
	}
	YamlConfiguration playerConfig;
	
	public void getKit(Player player){
		playerConfig = main.getPlayerConfig(player);
		String currentKit = playerConfig.getString("player.common.kit").toLowerCase();
		player.getInventory().clear();
		switch(currentKit){
		case "default":
			kitDefault(player);
			break;
		case "miner":
			kitMiner(player);
			break;
		case "rusher":
			kitRusher(player);
			break;
		case "builder":
			kitBuilder(player);
			break;
		case "archer":
			kitArcher(player);
			break;
		case "cannoneer":
			kitCannoneer(player);
			break;
		case "armorer":
			kitArmorer(player);
			break;
		}		  
	}
	
	public void kitDefault(Player player){
		  player.getInventory().addItem(new ItemStack(Material.WOOD_PICKAXE, 1));
		  player.getInventory().addItem(new ItemStack(Material.WOOD_SPADE, 1));
		  player.getInventory().addItem(new ItemStack(Material.WOOD_AXE, 1));
	}
	
	public void kitMiner(Player player){
		ItemStack item = new ItemStack(Material.STONE_PICKAXE, 1);
		item.addUnsafeEnchantment(Enchantment.DIG_SPEED, 5);
		player.getInventory().addItem(item);
	}
	
	public void kitRusher(Player player){
		ItemStack item = new ItemStack(Material.GOLD_SWORD, 1);
		item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
		player.getInventory().addItem(item);
	}
	
	public void kitBuilder(Player player){
		ItemStack item = new ItemStack(Material.WOOD, 16);
		player.getInventory().addItem(item);
	}
	
	public void kitArcher(Player player){
		ItemStack item = new ItemStack(Material.BOW, 1);
		player.getInventory().addItem(item);
		item = new ItemStack(Material.ARROW, 10);
		player.getInventory().addItem(item);
	}
	
	public void kitCannoneer(Player player){
		ItemStack item = new ItemStack(Material.TNT, 4);
		player.getInventory().addItem(item);
		item = new ItemStack(Material.REDSTONE, 8);
		player.getInventory().addItem(item);
		item = new ItemStack(Material.WATER_BUCKET, 1);
		player.getInventory().addItem(item);
	}
	
	public void kitArmorer(Player player){
		ItemStack item = new ItemStack(Material.GOLD_HELMET, 1);
		player.getInventory().setHelmet(item);
		item = new ItemStack(Material.GOLD_CHESTPLATE, 1);
		player.getInventory().setChestplate(item);
		item = new ItemStack(Material.GOLD_LEGGINGS, 1);
		player.getInventory().setLeggings(item);
		item = new ItemStack(Material.GOLD_BOOTS, 1);
		player.getInventory().setBoots(item);
	}
}
