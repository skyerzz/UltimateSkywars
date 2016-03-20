package com.sky.isles;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Chest;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Achievements {
	private Main main;
	public Achievements(Main main){
	this.main = main;
	}
	
	YamlConfiguration playerConfig;
	
	public void testAchievementStat(Player player){
		playerConfig = main.getPlayerConfig(player);
		int kills = playerConfig.getInt("player.common.kils");
		int plays = playerConfig.getInt("player.common.plays");
		int wins = playerConfig.getInt("player.common.wins");
		if(kills>=25000){
			kills_5(player);
		}
		else if(kills>=20000){
			kills_4(player);
		}
		else if(kills>=15000){
			kills_3(player);
		}
		else if(kills>=10000){
			kills_2(player);
		}
		else if(kills>=5000){
			kills_1(player);
		}
		if(plays>=25000){
			plays_5(player);
		}
		else if(plays>=20000){
			plays_4(player);
		}
		else if(plays>=15000){
			plays_3(player);
		}
		else if(plays>=10000){
			plays_2(player);
		}
		else if(plays>=5000){
			plays_1(player);
		}
		if(wins>=10000){
			wins_5(player);
		}
		else if(wins>=7500){
			wins_4(player);
		}
		else if(wins>=5000){
			wins_3(player);
		}
		else if(wins>=2500){
			wins_2(player);
		}
		else if(wins>=1000){
			wins_1(player);
		}
	}
//STAT ACHIEVEMENTS
	public void kills_1(Player player){
		playerConfig = main.getPlayerConfig(player);
		boolean kills1 = playerConfig.getBoolean("player.achievements.Kills_1");
		if(!kills1){
			displayStart(player);
			player.sendMessage(ChatColor.GOLD + "Killer 1");
			displayEnd(player);
			int achievementpoints = playerConfig.getInt("player.common.achievementpoints");
			achievementpoints +=5;
			playerConfig.set("player.common.achievementpoints", achievementpoints);
			player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 4.0F);
			playerConfig.set("player.achievements.Kills_1", true);
		}
		main.playerConfig = playerConfig;
		main.savePlayerConfig(player);
	}
	
	public void kills_2(Player player){
		playerConfig = main.getPlayerConfig(player);
		boolean kills2 = playerConfig.getBoolean("player.achievements.Kills_2");
		if(!kills2){
			displayStart(player);
			player.sendMessage(ChatColor.GOLD + "Killer 2");
			displayEnd(player);
			int achievementpoints = playerConfig.getInt("player.common.achievementpoints");
			achievementpoints +=10;
			playerConfig.set("player.common.achievementpoints", achievementpoints);
			player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 4.0F);
			playerConfig.set("player.achievements.Kills_2", true);
		}
		main.playerConfig = playerConfig;
		main.savePlayerConfig(player);
	}
	
	public void kills_3(Player player){
		playerConfig = main.getPlayerConfig(player);
		boolean kills3 = playerConfig.getBoolean("player.achievements.Kills_3");
		if(!kills3){
			displayStart(player);
			player.sendMessage(ChatColor.GOLD + "Killer 3");
			displayEnd(player);
			int achievementpoints = playerConfig.getInt("player.common.achievementpoints");
			achievementpoints +=15;
			playerConfig.set("player.common.achievementpoints", achievementpoints);
			player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 4.0F);
			playerConfig.set("player.achievements.Kills_3", true);
		}
		main.playerConfig = playerConfig;
		main.savePlayerConfig(player);
	}
	
	public void kills_4(Player player){
		playerConfig = main.getPlayerConfig(player);
		boolean kills4 = playerConfig.getBoolean("player.achievements.Kills_4");
		if(!kills4){
			displayStart(player);
			player.sendMessage(ChatColor.GOLD + "Killer 4");
			displayEnd(player);
			int achievementpoints = playerConfig.getInt("player.common.achievementpoints");
			achievementpoints +=20;
			playerConfig.set("player.common.achievementpoints", achievementpoints);
			player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 4.0F);
			playerConfig.set("player.achievements.Kills_4", true);
		}
		main.playerConfig = playerConfig;
		main.savePlayerConfig(player);
	}
	
	public void kills_5(Player player){
		playerConfig = main.getPlayerConfig(player);
		boolean kills5 = playerConfig.getBoolean("player.achievements.Kills_5");
		if(!kills5){
			displayStart(player);
			player.sendMessage(ChatColor.GOLD + "Killer 5");
			displayEnd(player);
			int achievementpoints = playerConfig.getInt("player.common.achievementpoints");
			achievementpoints +=25;
			playerConfig.set("player.common.achievementpoints", achievementpoints);
			player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 4.0F);
			playerConfig.set("player.achievements.Kills_5", true);
		}
		main.playerConfig = playerConfig;
		main.savePlayerConfig(player);
	}
	
	public void plays_1(Player player){
		playerConfig = main.getPlayerConfig(player);
		boolean plays1 = playerConfig.getBoolean("player.achievements.Plays_1");
		if(!plays1){
			displayStart(player);
			player.sendMessage(ChatColor.GOLD + "Addicted 1");
			displayEnd(player);
			int achievementpoints = playerConfig.getInt("player.common.achievementpoints");
			achievementpoints +=5;
			playerConfig.set("player.common.achievementpoints", achievementpoints);
			player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 4.0F);
			playerConfig.set("player.achievements.Plays_1", true);
		}
		main.playerConfig = playerConfig;
		main.savePlayerConfig(player);
	}
	
	public void plays_2(Player player){
		playerConfig = main.getPlayerConfig(player);
		boolean plays2 = playerConfig.getBoolean("player.achievements.Plays_2");
		if(!plays2){
			displayStart(player);
			player.sendMessage(ChatColor.GOLD + "Addicted 2");
			displayEnd(player);
			int achievementpoints = playerConfig.getInt("player.common.achievementpoints");
			achievementpoints +=10;
			playerConfig.set("player.common.achievementpoints", achievementpoints);
			player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 4.0F);
			playerConfig.set("player.achievements.Plays_2", true);
		}
		main.playerConfig = playerConfig;
		main.savePlayerConfig(player);
	}
	
	public void plays_3(Player player){
		playerConfig = main.getPlayerConfig(player);
		boolean plays3 = playerConfig.getBoolean("player.achievements.Plays_3");
		if(!plays3){
			displayStart(player);
			player.sendMessage(ChatColor.GOLD + "Addicted 3");
			displayEnd(player);
			int achievementpoints = playerConfig.getInt("player.common.achievementpoints");
			achievementpoints +=15;
			playerConfig.set("player.common.achievementpoints", achievementpoints);
			player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 4.0F);
			playerConfig.set("player.achievements.Plays_3", true);
		}
		main.playerConfig = playerConfig;
		main.savePlayerConfig(player);
	}
	
	public void plays_4(Player player){
		playerConfig = main.getPlayerConfig(player);
		boolean plays4 = playerConfig.getBoolean("player.achievements.Plays_4");
		if(!plays4){
			displayStart(player);
			player.sendMessage(ChatColor.GOLD + "Addicted 4");
			displayEnd(player);
			int achievementpoints = playerConfig.getInt("player.common.achievementpoints");
			achievementpoints +=20;
			playerConfig.set("player.common.achievementpoints", achievementpoints);
			player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 4.0F);
			playerConfig.set("player.achievements.Plays_4", true);
		}
		main.playerConfig = playerConfig;
		main.savePlayerConfig(player);
	}
	
	public void plays_5(Player player){
		playerConfig = main.getPlayerConfig(player);
		boolean plays5 = playerConfig.getBoolean("player.achievements.Plays_5");
		if(!plays5){
			displayStart(player);
			player.sendMessage(ChatColor.GOLD + "Addicted 5");
			displayEnd(player);
			int achievementpoints = playerConfig.getInt("player.common.achievementpoints");
			achievementpoints +=25;
			playerConfig.set("player.common.achievementpoints", achievementpoints);
			player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 4.0F);
			playerConfig.set("player.achievements.Plays_5", true);
		}
		main.playerConfig = playerConfig;
		main.savePlayerConfig(player);
	}
	
	public void wins_1(Player player){
		playerConfig = main.getPlayerConfig(player);
		boolean wins1 = playerConfig.getBoolean("player.achievements.Wins_1");
		if(!wins1){
			displayStart(player);
			player.sendMessage(ChatColor.GOLD + "Champion 1");
			displayEnd(player);
			int achievementpoints = playerConfig.getInt("player.common.achievementpoints");
			achievementpoints +=5;
			playerConfig.set("player.common.achievementpoints", achievementpoints);
			player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 4.0F);
			playerConfig.set("player.achievements.Wins_1", true);
		}
		main.playerConfig = playerConfig;
		main.savePlayerConfig(player);
	}
	
	public void wins_2(Player player){
		playerConfig = main.getPlayerConfig(player);
		boolean wins2 = playerConfig.getBoolean("player.achievements.Wins_2");
		if(!wins2){
			displayStart(player);
			player.sendMessage(ChatColor.GOLD + "Champion 2");
			displayEnd(player);
			int achievementpoints = playerConfig.getInt("player.common.achievementpoints");
			achievementpoints +=10;
			playerConfig.set("player.common.achievementpoints", achievementpoints);
			player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 4.0F);
			playerConfig.set("player.achievements.Wins_2", true);
		}
		main.playerConfig = playerConfig;
		main.savePlayerConfig(player);
	}
	
	public void wins_3(Player player){
		playerConfig = main.getPlayerConfig(player);
		boolean wins3 = playerConfig.getBoolean("player.achievements.Wins_3");
		if(!wins3){
			displayStart(player);
			player.sendMessage(ChatColor.GOLD + "Champion 3");
			displayEnd(player);
			int achievementpoints = playerConfig.getInt("player.common.achievementpoints");
			achievementpoints +=15;
			playerConfig.set("player.common.achievementpoints", achievementpoints);
			player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 4.0F);
			playerConfig.set("player.achievements.Wins_3", true);
		}
		main.playerConfig = playerConfig;
		main.savePlayerConfig(player);
	}
	
	public void wins_4(Player player){
		playerConfig = main.getPlayerConfig(player);
		boolean wins4 = playerConfig.getBoolean("player.achievements.Wins_4");
		if(!wins4){
			displayStart(player);
			player.sendMessage(ChatColor.GOLD + "Champion 4");
			displayEnd(player);
			int achievementpoints = playerConfig.getInt("player.common.achievementpoints");
			achievementpoints +=20;
			playerConfig.set("player.common.achievementpoints", achievementpoints);
			player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 4.0F);
			playerConfig.set("player.achievements.Wins_4", true);
		}
		main.playerConfig = playerConfig;
		main.savePlayerConfig(player);
	}
	
	public void wins_5(Player player){
		playerConfig = main.getPlayerConfig(player);
		boolean wins5 = playerConfig.getBoolean("player.achievements.Wins_5");
		if(!wins5){
			displayStart(player);
			player.sendMessage(ChatColor.GOLD + "Champion 5");
			displayEnd(player);
			int achievementpoints = playerConfig.getInt("player.common.achievementpoints");
			achievementpoints +=25;
			playerConfig.set("player.common.achievementpoints", achievementpoints);
			player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 4.0F);
			playerConfig.set("player.achievements.Wins_5", true);
		}
		main.playerConfig = playerConfig;
		main.savePlayerConfig(player);
	}
	
	public void testAchievementItem(Chest chest, Player player){
		ItemStack stack = new ItemStack(Material.DIAMOND_HELMET);
		stack.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
		stack.addEnchantment(Enchantment.THORNS, 1);
		ItemMeta Name = stack.getItemMeta();
	    Name.setDisplayName("§6AX100 Helmet");
	    stack.setItemMeta(Name);
		if(chest.getBlockInventory().containsAtLeast(stack, 1)){
		  AX100Helmet(player);		  
		}
		stack = new ItemStack(Material.DIAMOND_CHESTPLATE);
		stack.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS,3);
		stack.addEnchantment(Enchantment.PROTECTION_FIRE, 3);
		Name = stack.getItemMeta();
        Name.setDisplayName("§6AX100 Chestplate");
        stack.setItemMeta(Name);
		if(chest.getBlockInventory().containsAtLeast(stack, 1)){
		  AX100ChestPlate(player);		  
		}
		stack = new ItemStack(Material.DIAMOND_LEGGINGS);
		stack.addEnchantment(Enchantment.PROTECTION_FIRE, 2);
		stack.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		Name = stack.getItemMeta();
        Name.setDisplayName("§6AX100 Leggings");
        stack.setItemMeta(Name);
		if(chest.getBlockInventory().containsAtLeast(stack, 1)){
			  AX100Leggings(player);
		}
		stack = new ItemStack(Material.DIAMOND_BOOTS);
		stack.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		stack.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 5);
		Name = stack.getItemMeta();
        Name.setDisplayName("§6AX100 Boots");
        stack.setItemMeta(Name);
		if(chest.getBlockInventory().containsAtLeast(stack, 1)){
			  AX100Boots(player);
		}
		stack = new ItemStack(Material.DIAMOND_SWORD);
		stack.addEnchantment(Enchantment.DAMAGE_ALL, 3);
		Name = stack.getItemMeta();
        Name.setDisplayName("§6Buster");
        stack.setItemMeta(Name);
        if(chest.getBlockInventory().containsAtLeast(stack, 1)){
			  Buster(player);
		}
        stack = new ItemStack(Material.FEATHER);
		stack.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
		Name = stack.getItemMeta();
        Name.setDisplayName("§6Fly Guide");
        stack.setItemMeta(Name);
        if(chest.getBlockInventory().containsAtLeast(stack, 1)){
			  Flying_101(player);
		}
        stack = new ItemStack(Material.RAW_FISH);
		stack.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		stack.setDurability((short) 3);
		Name = stack.getItemMeta();
        Name.setDisplayName("§6Blub");
        stack.setItemMeta(Name);
        if(chest.getBlockInventory().containsAtLeast(stack, 1)){
			  Fishing(player);
		}
        stack = new ItemStack(Material.DIAMOND_SWORD);
		stack.addEnchantment(Enchantment.DAMAGE_ALL, 5);
		Name = stack.getItemMeta();
        Name.setDisplayName("§6The Upgrade");
        stack.setItemMeta(Name);
        if(chest.getBlockInventory().containsAtLeast(stack, 1)){
			  Upgrade(player);
		}
        stack = new ItemStack(Material.ENCHANTMENT_TABLE);
		Name = stack.getItemMeta();
        Name.setDisplayName("§6Enchanting Time!");
        stack.setItemMeta(Name);
        if(chest.getBlockInventory().containsAtLeast(stack, 1)){
			  Enchanted(player);
		}
        stack = new ItemStack(Material.CAKE, 1);
		Name = stack.getItemMeta();
        Name.setDisplayName("§6Celebration Time!");
        stack.setItemMeta(Name);
		stack.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 6);
		if(chest.getBlockInventory().containsAtLeast(stack, 1)){
			  Party(player);
		}
		stack = new ItemStack(Material.COOKIE);
		Name = stack.getItemMeta();
        Name.setDisplayName("§6COOKIES");
        stack.setItemMeta(Name);
        if(chest.getBlockInventory().containsAtLeast(stack, 1)){
			  Noms(player);
		}
        stack = new ItemStack(Material.GOLD_SWORD);
		Name = stack.getItemMeta();
        Name.setDisplayName("§6Thor's Hammer");
		stack.setDurability((short) 30);
		stack.addUnsafeEnchantment(Enchantment.KNOCKBACK, 10);
		if(chest.getBlockInventory().containsAtLeast(stack, 1)){
			  Thor(player);
		}
		stack = new ItemStack(Material.DIAMOND);
		Name = stack.getItemMeta();
        Name.setDisplayName("§6DIY-kit");
        stack.setItemMeta(Name);
        if(chest.getBlockInventory().containsAtLeast(stack, 1)){
        	DIY(player);
        }
        stack = new ItemStack(Material.TNT);
		Name = stack.getItemMeta();
        Name.setDisplayName("§6Boombox");
        stack.setItemMeta(Name);
        if(chest.getBlockInventory().containsAtLeast(stack, 1)){
        	BoomBox(player);
        }
        stack = new ItemStack(Material.GOLDEN_APPLE);
		stack.setDurability((short) 1);
		Name = stack.getItemMeta();
        Name.setDisplayName("§6NomNom Food");
        stack.setItemMeta(Name);
        if(chest.getBlockInventory().containsAtLeast(stack, 1)){
        	Apple(player);
        }
        stack = new ItemStack(Material.DIAMOND_SWORD);
		stack.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD, 10);
		Name = stack.getItemMeta();
        Name.setDisplayName("§6Zombie Slasher");
        stack.setItemMeta(Name);
        if(chest.getBlockInventory().containsAtLeast(stack, 1)){
        	Zombie(player);
        }
	}
	
	//LEGENDARY ITEMS
	public void displayStart(Player player){
		player.sendMessage(ChatColor.GREEN + "---==============---");
		player.sendMessage(ChatColor.GOLD + "Achievement Unlocked!");
	}
	
	public void displayEnd(Player player){
		player.sendMessage(ChatColor.GREEN + "---==============---");
	}
		
	public void AX100Helmet(Player player){
		playerConfig = main.getPlayerConfig(player);
		int AchAX100Helmet = playerConfig.getInt("player.itemstats.AX100Helmet");
		AchAX100Helmet++;
		playerConfig.set("player.itemstats.AX100Helmet", AchAX100Helmet);
		boolean powersuitHelmet = playerConfig.getBoolean("player.achievements.PowersuitHelmet");
		if(powersuitHelmet == false){
			displayStart(player);
			player.sendMessage(ChatColor.GOLD + "Powersuit Helmet");
			displayEnd(player);
			int achievementpoints = playerConfig.getInt("player.common.achievementpoints");
			achievementpoints +=10;
			playerConfig.set("player.common.achievementpoints", achievementpoints);
			player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 4.0F);
			playerConfig.set("player.achievements.PowersuitHelmet", true);
		}
		main.playerConfig = playerConfig;
		main.savePlayerConfig(player);
	}
	
	public void AX100ChestPlate(Player player){
		playerConfig = main.getPlayerConfig(player);
		int AchAX100ChestPlate = playerConfig.getInt("player.itemstats.AX100ChestPlate");
		AchAX100ChestPlate++;
		playerConfig.set("player.itemstats.AX100ChestPlate", AchAX100ChestPlate);
		boolean powersuitChestPlate = playerConfig.getBoolean("player.achievements.PowersuitChestPlate");
		if(powersuitChestPlate == false){
			displayStart(player);
			player.sendMessage(ChatColor.GOLD + "Powersuit ChestPlate");
			displayEnd(player);
			int achievementpoints = playerConfig.getInt("player.common.achievementpoints");
			achievementpoints +=10;
			playerConfig.set("player.common.achievementpoints", achievementpoints);
			player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 4.0F);
			playerConfig.set("player.achievements.PowersuitChestPlate", true);
		}
		main.playerConfig = playerConfig;
		main.savePlayerConfig(player);
	}
	
	public void AX100Leggings(Player player){
		playerConfig = main.getPlayerConfig(player);
		int AchAX100Leggings = playerConfig.getInt("player.itemstats.AX100Leggings");
		AchAX100Leggings++;
		playerConfig.set("player.itemstats.AX100Leggings", AchAX100Leggings);
		boolean powersuitLeggings = playerConfig.getBoolean("player.achievements.PowersuitLeggings");
		if(powersuitLeggings == false){
			displayStart(player);
			player.sendMessage(ChatColor.GOLD + "Powersuit Leggings");
			displayEnd(player);
			int achievementpoints = playerConfig.getInt("player.common.achievementpoints");
			achievementpoints +=10;
			playerConfig.set("player.common.achievementpoints", achievementpoints);
			player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 4.0F);
			playerConfig.set("player.achievements.PowersuitLeggings", true);
		}
		main.playerConfig = playerConfig;
		main.savePlayerConfig(player);
	}
	
	public void AX100Boots(Player player){
		playerConfig = main.getPlayerConfig(player);
		int AchAX100Boots = playerConfig.getInt("player.itemstats.AX100Boots");
		AchAX100Boots++;
		playerConfig.set("player.itemstats.AX100Boots", AchAX100Boots);
		boolean powersuitBoots = playerConfig.getBoolean("player.achievements.PowersuitBoots");
		if(powersuitBoots == false){
			displayStart(player);
			player.sendMessage(ChatColor.GOLD + "Powersuit Boots");
			displayEnd(player);
			int achievementpoints = playerConfig.getInt("player.common.achievementpoints");
			achievementpoints +=10;
			playerConfig.set("player.common.achievementpoints", achievementpoints);
			player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 4.0F);
			playerConfig.set("player.achievements.PowersuitBoots", true);
		}
		main.playerConfig = playerConfig;
		main.savePlayerConfig(player);
	}
	
	public void Buster(Player player){
		playerConfig = main.getPlayerConfig(player);
		int Buster = playerConfig.getInt("player.itemstats.Buster");
		Buster++;
		playerConfig.set("player.itemstats.Buster", Buster);
		boolean busted = playerConfig.getBoolean("player.achievements.Busted");
		if(busted == false){
			displayStart(player);
			player.sendMessage(ChatColor.GOLD + "Busted!");
			displayEnd(player);
			int achievementpoints = playerConfig.getInt("player.common.achievementpoints");
			achievementpoints +=10;
			playerConfig.set("player.common.achievementpoints", achievementpoints);
			player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 4.0F);
			playerConfig.set("player.achievements.Busted", true);
		}
		main.playerConfig = playerConfig;
		main.savePlayerConfig(player);
	}
	
	public void Flying_101(Player player){
		playerConfig = main.getPlayerConfig(player);
		int flyGuide = playerConfig.getInt("player.itemstats.FlyGuide");
		flyGuide++;
		playerConfig.set("player.itemstats.FlyGuide", flyGuide);
		boolean flying101 = playerConfig.getBoolean("player.achievements.Flying_101");
		if(flying101 == false){
			displayStart(player);
			player.sendMessage(ChatColor.GOLD + "Flying 101");
			displayEnd(player);
			int achievementpoints = playerConfig.getInt("player.common.achievementpoints");
			achievementpoints +=10;
			playerConfig.set("player.common.achievementpoints", achievementpoints);
			player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 4.0F);
			playerConfig.set("player.achievements.Flying_101", true);
		}
		main.playerConfig = playerConfig;
		main.savePlayerConfig(player);
	}
	
	public void Fishing(Player player){
		playerConfig = main.getPlayerConfig(player);
		int blub = playerConfig.getInt("player.itemstats.Blub");
		blub++;
		playerConfig.set("player.itemstats.Blub", blub);
		boolean Fishing = playerConfig.getBoolean("player.achievements.Fishing");
		if(Fishing == false){
			displayStart(player);
			player.sendMessage(ChatColor.GOLD + "Gone Fishing");
			displayEnd(player);
			int achievementpoints = playerConfig.getInt("player.common.achievementpoints");
			achievementpoints +=15;
			playerConfig.set("player.common.achievementpoints", achievementpoints);
			player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 4.0F);
			playerConfig.set("player.achievements.Fishing", true);
		}
		main.playerConfig = playerConfig;
		main.savePlayerConfig(player);
	}
	
	public void Upgrade(Player player){
		playerConfig = main.getPlayerConfig(player);
		int upgrade = playerConfig.getInt("player.itemstats.Upgrade");
		upgrade++;
		playerConfig.set("player.itemstats.Upgrade", upgrade);
		boolean upgrading = playerConfig.getBoolean("player.achievements.Upgrading");
		if(upgrading == false){
			displayStart(player);
			player.sendMessage(ChatColor.GOLD + "Upgrading...");
			displayEnd(player);
			int achievementpoints = playerConfig.getInt("player.common.achievementpoints");
			achievementpoints +=10;
			playerConfig.set("player.common.achievementpoints", achievementpoints);
			player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 4.0F);
			playerConfig.set("player.achievements.Upgrading", true);
		}
		main.playerConfig = playerConfig;
		main.savePlayerConfig(player);
	}
	
	public void Enchanted(Player player){
		playerConfig = main.getPlayerConfig(player);
		int enchant = playerConfig.getInt("player.itemstats.Enchant");
		enchant++;
		playerConfig.set("player.itemstats.Enchant", enchant);
		boolean enchanted = playerConfig.getBoolean("player.achievements.Enchanted");
		if(enchanted == false){
			displayStart(player);
			player.sendMessage(ChatColor.GOLD + "A magical feeling");
			displayEnd(player);
			int achievementpoints = playerConfig.getInt("player.common.achievementpoints");
			achievementpoints +=10;
			playerConfig.set("player.common.achievementpoints", achievementpoints);
			player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 4.0F);
			playerConfig.set("player.achievements.Enchanted", true);
		}
		main.playerConfig = playerConfig;
		main.savePlayerConfig(player);
	}
	
	public void Party(Player player){
		playerConfig = main.getPlayerConfig(player);
		int cake = playerConfig.getInt("player.itemstats.Party");
		cake++;
		playerConfig.set("player.itemstats.Party", cake);
		boolean party = playerConfig.getBoolean("player.achievements.Party");
		if(party == false){
			displayStart(player);
			player.sendMessage(ChatColor.GOLD + "Lets Party!");
			displayEnd(player);
			int achievementpoints = playerConfig.getInt("player.common.achievementpoints");
			achievementpoints +=10;
			playerConfig.set("player.common.achievementpoints", achievementpoints);
			player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 4.0F);
			playerConfig.set("player.achievements.Party", true);
		}
		main.playerConfig = playerConfig;
		main.savePlayerConfig(player);
	}
	
	public void Noms(Player player){
		playerConfig = main.getPlayerConfig(player);
		int cookie = playerConfig.getInt("player.itemstats.Cookie");
		cookie++;
		playerConfig.set("player.itemstats.Cookie", cookie);
		boolean noms = playerConfig.getBoolean("player.achievements.Noms");
		if(noms == false){
			displayStart(player);
			player.sendMessage(ChatColor.GOLD + "Omnomnomnom");
			displayEnd(player);
			int achievementpoints = playerConfig.getInt("player.common.achievementpoints");
			achievementpoints +=10;
			playerConfig.set("player.common.achievementpoints", achievementpoints);
			player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 4.0F);
			playerConfig.set("player.achievements.Noms", true);
		}
		main.playerConfig = playerConfig;
		main.savePlayerConfig(player);
	}
	
	public void DIY(Player player){
		playerConfig = main.getPlayerConfig(player);
		int DIYkit = playerConfig.getInt("player.itemstats.DIY");
		DIYkit++;
		playerConfig.set("player.itemstats.DIY", DIYkit);
		boolean noms = playerConfig.getBoolean("player.achievements.DIY");
		if(noms == false){
			displayStart(player);
			player.sendMessage(ChatColor.GOLD + player.getName() + "'s First Do It Yourself kit!");
			displayEnd(player);
			int achievementpoints = playerConfig.getInt("player.common.achievementpoints");
			achievementpoints +=10;
			playerConfig.set("player.common.achievementpoints", achievementpoints);
			player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 4.0F);
			playerConfig.set("player.achievements.DIY", true);
		}
		main.playerConfig = playerConfig;
		main.savePlayerConfig(player);
	}
	
	public void BoomBox(Player player){
		playerConfig = main.getPlayerConfig(player);
		int box = playerConfig.getInt("player.itemstats.BoomBox");
		box++;
		playerConfig.set("player.itemstats.BoomBox", box);
		boolean noms = playerConfig.getBoolean("player.achievements.BoomBox");
		if(noms == false){
			displayStart(player);
			player.sendMessage(ChatColor.GOLD + "Tssssssssss....");
			displayEnd(player);
			int achievementpoints = playerConfig.getInt("player.common.achievementpoints");
			achievementpoints +=10;
			playerConfig.set("player.common.achievementpoints", achievementpoints);
			player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 4.0F);
			playerConfig.set("player.achievements.BoomBox", true);
		}
		main.playerConfig = playerConfig;
		main.savePlayerConfig(player);
	}
	
	public void Apple(Player player){
		playerConfig = main.getPlayerConfig(player);
		int apple = playerConfig.getInt("player.itemstats.Gapple");
		apple++;
		playerConfig.set("player.itemstats.Gapple", apple);
		boolean noms = playerConfig.getBoolean("player.achievements.Apple");
		if(noms == false){
			displayStart(player);
			player.sendMessage(ChatColor.GOLD + "An apple a day...");
			displayEnd(player);
			int achievementpoints = playerConfig.getInt("player.common.achievementpoints");
			achievementpoints +=10;
			playerConfig.set("player.common.achievementpoints", achievementpoints);
			player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 4.0F);
			playerConfig.set("player.achievements.Apple", true);
		}
		main.playerConfig = playerConfig;
		main.savePlayerConfig(player);
	}
	
	public void Zombie(Player player){
		playerConfig = main.getPlayerConfig(player);
		int zombie = playerConfig.getInt("player.itemstats.Zombie");
		zombie++;
		playerConfig.set("player.itemstats.Gapple", zombie);
		boolean noms = playerConfig.getBoolean("player.achievements.Zombie");
		if(noms == false){
			displayStart(player);
			player.sendMessage(ChatColor.GOLD + "Zombies?!?");
			displayEnd(player);
			int achievementpoints = playerConfig.getInt("player.common.achievementpoints");
			achievementpoints +=10;
			playerConfig.set("player.common.achievementpoints", achievementpoints);
			player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 4.0F);
			playerConfig.set("player.achievements.Zombie", true);
		}
		main.playerConfig = playerConfig;
		main.savePlayerConfig(player);
	}
	
	//EPIC ITEMS
	public void Thor(Player player){
		playerConfig = main.getPlayerConfig(player);
		int thor = playerConfig.getInt("player.itemstats.Thor");
		thor++;
		playerConfig.set("player.itemstats.Thor", thor);
		boolean thora = playerConfig.getBoolean("player.achievements.Thor");
		if(thora == false){
			displayStart(player);
			player.sendMessage(ChatColor.GOLD + "Puny god.");
			displayEnd(player);
			int achievementpoints = playerConfig.getInt("player.common.achievementpoints");
			achievementpoints +=10;
			playerConfig.set("player.common.achievementpoints", achievementpoints);
			player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 4.0F);
			playerConfig.set("player.achievements.Thor", true);
		}
		main.playerConfig = playerConfig;
		main.savePlayerConfig(player);
	}

}
