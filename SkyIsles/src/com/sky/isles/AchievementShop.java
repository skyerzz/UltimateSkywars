package com.sky.isles;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AchievementShop {
	private Main main;
	public AchievementShop(Main main){
		this.main = main;	
	}
	Shop shop;
	String prefix;
	YamlConfiguration playerConfig;
	
	public void initialise(){
		shop = main.shop;
	}
	
	public void buyShopWindowAchievements(Player player, UUID uuid, ItemStack clicked){
		playerConfig = main.getPlayerConfig(player);		
		if(clicked == null){
			//System.out.println("CLICKED NULL");
		}
		else if(clicked.getItemMeta() == null){
			//System.out.println("CLICKED.getItemMeta NULL");
		}
		else if(clicked.getItemMeta().getDisplayName() == null){
			//System.out.println("CLICKED.getItemMeta.getDisplayName NULL");
		}
		else if(clicked.getType() == null){
			//System.out.println("CLICKED.getType NULL");
		}
		else if (clicked.getType() == Material.ARROW && clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cBack")){          
	        shop.showShopWindowMain(player); 
	    }
		else if (clicked.getType() == Material.COAL_BLOCK){}
		else if (clicked.getType() == Material.DIAMOND_BLOCK){}
		else if (clicked.getType() == Material.COAL){}
		else if (clicked.getType() == Material.DIAMOND){}
		else{
			player.closeInventory();
			player.sendMessage(prefix + ChatColor.RED + "Something went wrong! ErrorCode: G1-001");
		}
	}
	
	public void showShopWindowAchievements(Player player){
		playerConfig = main.getPlayerConfig(player);
//TIERED ACHIEVEMENTDATA
		int kills = playerConfig.getInt("player.common.kills");
		int plays = playerConfig.getInt("player.common.plays");
		int wins = playerConfig.getInt("player.common.wins");
		boolean kills1 = playerConfig.getBoolean("player.achievements.Kills_1");
		boolean kills2 = playerConfig.getBoolean("player.achievements.Kills_2");
		boolean kills3 = playerConfig.getBoolean("player.achievements.Kills_3");
		boolean kills4 = playerConfig.getBoolean("player.achievements.Kills_4");
		boolean kills5 = playerConfig.getBoolean("player.achievements.Kills_5");
		boolean plays1 = playerConfig.getBoolean("player.achievements.Plays_1");
		boolean plays2 = playerConfig.getBoolean("player.achievements.Plays_2");
		boolean plays3 = playerConfig.getBoolean("player.achievements.Plays_3");
		boolean plays4 = playerConfig.getBoolean("player.achievements.Plays_4");
		boolean plays5 = playerConfig.getBoolean("player.achievements.Plays_5");
		boolean wins1 = playerConfig.getBoolean("player.achievements.Wins_1");
		boolean wins2 = playerConfig.getBoolean("player.achievements.Wins_2");
		boolean wins3 = playerConfig.getBoolean("player.achievements.Wins_3");
		boolean wins4 = playerConfig.getBoolean("player.achievements.Wins_4");
		boolean wins5 = playerConfig.getBoolean("player.achievements.Wins_5");
//NONTIERED ACHIEVEMENTSDATA
		int achievementPoints = playerConfig.getInt("player.common.achievementpoints");
		boolean powersuitHelmet = playerConfig.getBoolean("player.achievements.PowersuitHelmet");
		int powersuitHelmetsFound = playerConfig.getInt("player.itemstats.AX100Helmet");
		boolean powersuitChestPlate = playerConfig.getBoolean("player.achievements.PowersuitChestPlate");
		int powersuitChestPlatesFound = playerConfig.getInt("player.itemstats.AX100ChestPlate");
		boolean powersuitLeggings = playerConfig.getBoolean("player.achievements.PowersuitLeggings");
		int powersuitLeggingssFound = playerConfig.getInt("player.itemstats.AX100Leggings");
		boolean powersuitBoots = playerConfig.getBoolean("player.achievements.PowersuitBoots");
		int powersuitBootssFound = playerConfig.getInt("player.itemstats.AX100Boots");
		boolean busted = playerConfig.getBoolean("player.achievements.Busted");
		int bustersFound = playerConfig.getInt("player.itemstats.Buster");
		boolean flying101 = playerConfig.getBoolean("player.achievements.Flying_101");
		int flyGuidesFound = playerConfig.getInt("player.itemstats.FlyGuide");
		boolean fishing = playerConfig.getBoolean("player.achievements.Fishing");
		int blubsFound = playerConfig.getInt("player.itemstats.Blub");
		boolean upgrade = playerConfig.getBoolean("player.achievements.Upgrading");
		int upgradesFound = playerConfig.getInt("player.itemstats.Upgrade");
		boolean enchant = playerConfig.getBoolean("player.achievements.Enchanted");
		int enchantsFound = playerConfig.getInt("player.itemstats.Enchant");
		boolean party = playerConfig.getBoolean("player.achievements.Party");
		int partysFound = playerConfig.getInt("player.itemstats.Party");
		boolean noms = playerConfig.getBoolean("player.achievements.Noms");
		int nomsFound = playerConfig.getInt("player.itemstats.Cookie");
		boolean DIY = playerConfig.getBoolean("player.achievements.DIY");
		int DIYsFound = playerConfig.getInt("player.itemstats.DIY");
		boolean boomBox = playerConfig.getBoolean("player.achievements.BoomBox");
		int boomBoxsFound = playerConfig.getInt("player.itemstats.BoomBox");
		boolean apple = playerConfig.getBoolean("player.achievements.Apple");
		int applesFound = playerConfig.getInt("player.itemstats.Gapple");
		boolean zombie = playerConfig.getBoolean("player.achievements.Zombie");
		int zombiesFound = playerConfig.getInt("player.itemstats.Zombie");
		boolean thor = playerConfig.getBoolean("player.achievements.Thor");
		int thorsFound = playerConfig.getInt("player.itemstats.Thor");
		Inventory skywarsAchievements = Bukkit.createInventory(null, 54, "Skywars Achievements");
			ItemStack skywarsCageBack = new ItemStack(Material.ARROW, 1); {
		          ItemMeta MetaskywarsCageBack = skywarsCageBack.getItemMeta();
		          ArrayList<String> ListskywarsCageBack = new ArrayList<String>();
		          MetaskywarsCageBack.setDisplayName("§cBack");
		          MetaskywarsCageBack.setLore(ListskywarsCageBack);
		          skywarsCageBack.setItemMeta(MetaskywarsCageBack);
		      skywarsAchievements.setItem(45, skywarsCageBack);
			}
			ItemStack skywarsAchPoints = new ItemStack(Material.DIAMOND, 1); {
		          ItemMeta MetaskywarsAchPoints = skywarsAchPoints.getItemMeta();
		          ArrayList<String> ListskywarsAchPoints = new ArrayList<String>();
		          MetaskywarsAchPoints.setDisplayName("§eAchievement Points: " + ChatColor.GOLD + achievementPoints);
		          MetaskywarsAchPoints.setLore(ListskywarsAchPoints);
		          skywarsAchPoints.setItemMeta(MetaskywarsAchPoints);
		      skywarsAchievements.setItem(49, skywarsAchPoints);
			}
//NON-TIERED ACHIEVEMENTS
			ItemStack skywarsAchPowerHelmet;
			if(powersuitHelmet){
				skywarsAchPowerHelmet = new ItemStack(Material.DIAMOND, 1);
				ItemMeta MetaskywarsAchPowerHelmet = skywarsAchPowerHelmet.getItemMeta();
				MetaskywarsAchPowerHelmet.setDisplayName("§aPowersuit Helmet");
				ArrayList<String> ListskywarsAchPowerHelmet = new ArrayList<String>();		          
		        ListskywarsAchPowerHelmet.add(" ");
		        ListskywarsAchPowerHelmet.add("§aTotal Helmets found: §6" + powersuitHelmetsFound);
		        ListskywarsAchPowerHelmet.add(" ");
		        ListskywarsAchPowerHelmet.add(ChatColor.GRAY + "Achievement points:§a 10");
		        MetaskywarsAchPowerHelmet.setLore(ListskywarsAchPowerHelmet);
		        skywarsAchPowerHelmet.setItemMeta(MetaskywarsAchPowerHelmet);
			}else{
				skywarsAchPowerHelmet = new ItemStack(Material.COAL, 1);
				ItemMeta MetaskywarsAchPowerHelmet = skywarsAchPowerHelmet.getItemMeta();
				MetaskywarsAchPowerHelmet.setDisplayName("§cPowersuit Helmet");
				ArrayList<String> ListskywarsAchPowerHelmet = new ArrayList<String>();		          
		        ListskywarsAchPowerHelmet.add(" ");
		        ListskywarsAchPowerHelmet.add("§aTotal Helmets found: §6" + powersuitHelmetsFound);
		        ListskywarsAchPowerHelmet.add(" ");
		        ListskywarsAchPowerHelmet.add(ChatColor.GRAY + "Achievement points:§c 10");
		        MetaskywarsAchPowerHelmet.setLore(ListskywarsAchPowerHelmet);
		        skywarsAchPowerHelmet.setItemMeta(MetaskywarsAchPowerHelmet);
			}   
		    skywarsAchievements.setItem(5, skywarsAchPowerHelmet);
		    
			ItemStack skywarsAchPowerChestPlate;
			if(powersuitChestPlate){
				skywarsAchPowerChestPlate = new ItemStack(Material.DIAMOND, 1);
				ItemMeta MetaskywarsAchPowerChestPlate = skywarsAchPowerChestPlate.getItemMeta();
				MetaskywarsAchPowerChestPlate.setDisplayName("§aPowersuit ChestPlate");
				ArrayList<String> ListskywarsAchPowerChestPlate = new ArrayList<String>();		          
		        ListskywarsAchPowerChestPlate.add(" ");
		        ListskywarsAchPowerChestPlate.add("§aTotal ChestPlates found: §6" + powersuitChestPlatesFound);
		        ListskywarsAchPowerChestPlate.add(" ");
		        ListskywarsAchPowerChestPlate.add(ChatColor.GRAY + "Achievement points:§a 10");
		        MetaskywarsAchPowerChestPlate.setLore(ListskywarsAchPowerChestPlate);
		        skywarsAchPowerChestPlate.setItemMeta(MetaskywarsAchPowerChestPlate);
			}else{
				skywarsAchPowerChestPlate = new ItemStack(Material.COAL, 1);
				ItemMeta MetaskywarsAchPowerChestPlate = skywarsAchPowerChestPlate.getItemMeta();
				MetaskywarsAchPowerChestPlate.setDisplayName("§cPowersuit ChestPlate");
				ArrayList<String> ListskywarsAchPowerChestPlate = new ArrayList<String>();		          
		        ListskywarsAchPowerChestPlate.add(" ");
		        ListskywarsAchPowerChestPlate.add("§aTotal ChestPlates found: §6" + powersuitChestPlatesFound);
		        ListskywarsAchPowerChestPlate.add(" ");
		        ListskywarsAchPowerChestPlate.add(ChatColor.GRAY + "Achievement points:§c 10");
		        MetaskywarsAchPowerChestPlate.setLore(ListskywarsAchPowerChestPlate);
		        skywarsAchPowerChestPlate.setItemMeta(MetaskywarsAchPowerChestPlate);
			}   
		    skywarsAchievements.setItem(6, skywarsAchPowerChestPlate);
		    
			ItemStack skywarsAchPowerLeggings;
			if(powersuitLeggings){
				skywarsAchPowerLeggings = new ItemStack(Material.DIAMOND, 1);
				ItemMeta MetaskywarsAchPowerLeggings = skywarsAchPowerLeggings.getItemMeta();
				MetaskywarsAchPowerLeggings.setDisplayName("§aPowersuit Leggings");
				ArrayList<String> ListskywarsAchPowerLeggings = new ArrayList<String>();		          
		        ListskywarsAchPowerLeggings.add(" ");
		        ListskywarsAchPowerLeggings.add("§aTotal Leggings found: §6" + powersuitLeggingssFound);
		        ListskywarsAchPowerLeggings.add(" ");
		        ListskywarsAchPowerLeggings.add(ChatColor.GRAY + "Achievement points:§a 10");
		        MetaskywarsAchPowerLeggings.setLore(ListskywarsAchPowerLeggings);
		        skywarsAchPowerLeggings.setItemMeta(MetaskywarsAchPowerLeggings);
			}else{
				skywarsAchPowerLeggings = new ItemStack(Material.COAL, 1);
				ItemMeta MetaskywarsAchPowerLeggings = skywarsAchPowerLeggings.getItemMeta();
				MetaskywarsAchPowerLeggings.setDisplayName("§cPowersuit Leggings");
				ArrayList<String> ListskywarsAchPowerLeggings = new ArrayList<String>();		          
		        ListskywarsAchPowerLeggings.add(" ");
		        ListskywarsAchPowerLeggings.add("§aTotal Leggings found: §6" + powersuitLeggingssFound);
		        ListskywarsAchPowerLeggings.add(" ");
		        ListskywarsAchPowerLeggings.add(ChatColor.GRAY + "Achievement points:§c 10");
		        MetaskywarsAchPowerLeggings.setLore(ListskywarsAchPowerLeggings);
		        skywarsAchPowerLeggings.setItemMeta(MetaskywarsAchPowerLeggings);
			}  
		    skywarsAchievements.setItem(7, skywarsAchPowerLeggings);
		    
			ItemStack skywarsAchPowerBoots;
			if(powersuitBoots){
				skywarsAchPowerBoots = new ItemStack(Material.DIAMOND, 1);
				ItemMeta MetaskywarsAchPowerBoots = skywarsAchPowerBoots.getItemMeta();
				MetaskywarsAchPowerBoots.setDisplayName("§aPowersuit Boots");
				ArrayList<String> ListskywarsAchPowerBoots = new ArrayList<String>();		          
		        ListskywarsAchPowerBoots.add(" ");
		        ListskywarsAchPowerBoots.add("§aTotal Boots found: §6" + powersuitBootssFound);
		        ListskywarsAchPowerBoots.add(" ");
		        ListskywarsAchPowerBoots.add(ChatColor.GRAY + "Achievement points:§a 10");
		        MetaskywarsAchPowerBoots.setLore(ListskywarsAchPowerBoots);
		        skywarsAchPowerBoots.setItemMeta(MetaskywarsAchPowerBoots);
			}else{
			skywarsAchPowerBoots = new ItemStack(Material.COAL, 1);
				ItemMeta MetaskywarsAchPowerBoots = skywarsAchPowerBoots.getItemMeta();
				MetaskywarsAchPowerBoots.setDisplayName("§cPowersuit Boots");
				ArrayList<String> ListskywarsAchPowerBoots = new ArrayList<String>();		          
		        ListskywarsAchPowerBoots.add(" ");
		        ListskywarsAchPowerBoots.add("§aTotal Boots found: §6" + powersuitBootssFound);
		        ListskywarsAchPowerBoots.add(" ");
		        ListskywarsAchPowerBoots.add(ChatColor.GRAY + "Achievement points:§c 10");
		        MetaskywarsAchPowerBoots.setLore(ListskywarsAchPowerBoots);
		        skywarsAchPowerBoots.setItemMeta(MetaskywarsAchPowerBoots);
			}   
		    skywarsAchievements.setItem(8, skywarsAchPowerBoots);
		    ItemStack skywarsAchBuster;
			if(busted){
				skywarsAchBuster = new ItemStack(Material.DIAMOND, 1);
				ItemMeta MetaskywarsAchBuster = skywarsAchBuster.getItemMeta();
				MetaskywarsAchBuster.setDisplayName("§aBusted!");
				ArrayList<String> ListskywarsAchBuster = new ArrayList<String>();		          
		        ListskywarsAchBuster.add(" ");
		        ListskywarsAchBuster.add("§aTotal Busters found: §6" + bustersFound);
		        ListskywarsAchBuster.add(" ");
		        ListskywarsAchBuster.add(ChatColor.GRAY + "Achievement points:§a 10");
		        MetaskywarsAchBuster.setLore(ListskywarsAchBuster);
		        skywarsAchBuster.setItemMeta(MetaskywarsAchBuster);
			}else{
			skywarsAchBuster = new ItemStack(Material.COAL, 1);
				ItemMeta MetaskywarsAchBuster = skywarsAchBuster.getItemMeta();
				MetaskywarsAchBuster.setDisplayName("§cBusted!");
				ArrayList<String> ListskywarsAchBuster = new ArrayList<String>();		          
		        ListskywarsAchBuster.add(" ");
		        ListskywarsAchBuster.add("§aTotal Busters found: §6" + bustersFound);
		        ListskywarsAchBuster.add(" ");
		        ListskywarsAchBuster.add(ChatColor.GRAY + "Achievement points:§c 10");
		        MetaskywarsAchBuster.setLore(ListskywarsAchBuster);
		        skywarsAchBuster.setItemMeta(MetaskywarsAchBuster);
			}   
		    skywarsAchievements.setItem(14, skywarsAchBuster);
		    ItemStack skywarsAchFlyGuide;
			if(flying101){
				skywarsAchFlyGuide = new ItemStack(Material.DIAMOND, 1);
				ItemMeta MetaskywarsAchFlyGuide = skywarsAchFlyGuide.getItemMeta();
				MetaskywarsAchFlyGuide.setDisplayName("§aFlying 101");
				ArrayList<String> ListskywarsAchFlyGuide = new ArrayList<String>();		          
		        ListskywarsAchFlyGuide.add(" ");
		        ListskywarsAchFlyGuide.add("§aTotal FlyGuides found: §6" + flyGuidesFound);
		        ListskywarsAchFlyGuide.add(" ");
		        ListskywarsAchFlyGuide.add(ChatColor.GRAY + "Achievement points:§a 10");
		        MetaskywarsAchFlyGuide.setLore(ListskywarsAchFlyGuide);
		        skywarsAchFlyGuide.setItemMeta(MetaskywarsAchFlyGuide);
			}else{
			skywarsAchFlyGuide = new ItemStack(Material.COAL, 1);
				ItemMeta MetaskywarsAchFlyGuide = skywarsAchFlyGuide.getItemMeta();
				MetaskywarsAchFlyGuide.setDisplayName("§cFlying 101");
				ArrayList<String> ListskywarsAchFlyGuide = new ArrayList<String>();		          
		        ListskywarsAchFlyGuide.add(" ");
		        ListskywarsAchFlyGuide.add("§aTotal FlyGuides found: §6" + flyGuidesFound);
		        ListskywarsAchFlyGuide.add(" ");
		        ListskywarsAchFlyGuide.add(ChatColor.GRAY + "Achievement points:§c 10");
		        MetaskywarsAchFlyGuide.setLore(ListskywarsAchFlyGuide);
		        skywarsAchFlyGuide.setItemMeta(MetaskywarsAchFlyGuide);
			}   
		    skywarsAchievements.setItem(15, skywarsAchFlyGuide);
		    ItemStack skywarsAchFishing;
			if(fishing){
				skywarsAchFishing = new ItemStack(Material.DIAMOND, 1);
				ItemMeta MetaskywarsAchFishing = skywarsAchFishing.getItemMeta();
				MetaskywarsAchFishing.setDisplayName("§aGone Fishing");
				ArrayList<String> ListskywarsAchFishing = new ArrayList<String>();		          
		        ListskywarsAchFishing.add(" ");
		        ListskywarsAchFishing.add("§aTotal times gone fishing: §6" + blubsFound);
		        ListskywarsAchFishing.add(" ");
		        ListskywarsAchFishing.add(ChatColor.GRAY + "Achievement points:§a 15");
		        MetaskywarsAchFishing.setLore(ListskywarsAchFishing);
		        skywarsAchFishing.setItemMeta(MetaskywarsAchFishing);
			}else{
			skywarsAchFishing = new ItemStack(Material.COAL, 1);
				ItemMeta MetaskywarsAchFishing = skywarsAchFishing.getItemMeta();
				MetaskywarsAchFishing.setDisplayName("§cGone Fishing");
				ArrayList<String> ListskywarsAchFishing = new ArrayList<String>();		          
		        ListskywarsAchFishing.add(" ");
		        ListskywarsAchFishing.add("§aTotal times gone fishing: §6" + blubsFound);
		        ListskywarsAchFishing.add(" ");
		        ListskywarsAchFishing.add(ChatColor.GRAY + "Achievement points:§c 15");
		        MetaskywarsAchFishing.setLore(ListskywarsAchFishing);
		        skywarsAchFishing.setItemMeta(MetaskywarsAchFishing);
			}   
		    skywarsAchievements.setItem(16, skywarsAchFishing);
		    ItemStack skywarsAchUpgrade;
			if(upgrade){
				skywarsAchUpgrade = new ItemStack(Material.DIAMOND, 1);
				ItemMeta MetaskywarsAchUpgrade = skywarsAchUpgrade.getItemMeta();
				MetaskywarsAchUpgrade.setDisplayName("§aUpgrading...");
				ArrayList<String> ListskywarsAchUpgrade = new ArrayList<String>();		          
		        ListskywarsAchUpgrade.add(" ");
		        ListskywarsAchUpgrade.add("§aTotal upgrades found: §6" + upgradesFound);
		        ListskywarsAchUpgrade.add(" ");
		        ListskywarsAchUpgrade.add(ChatColor.GRAY + "Achievement points:§a 10");
		        MetaskywarsAchUpgrade.setLore(ListskywarsAchUpgrade);
		        skywarsAchUpgrade.setItemMeta(MetaskywarsAchUpgrade);
			}else{
			skywarsAchUpgrade = new ItemStack(Material.COAL, 1);
				ItemMeta MetaskywarsAchUpgrade = skywarsAchUpgrade.getItemMeta();
				MetaskywarsAchUpgrade.setDisplayName("§cUpgrading...");
				ArrayList<String> ListskywarsAchUpgrade = new ArrayList<String>();		          
		        ListskywarsAchUpgrade.add(" ");
		        ListskywarsAchUpgrade.add("§aTotal Upgrades found: §6" + upgradesFound);
		        ListskywarsAchUpgrade.add(" ");
		        ListskywarsAchUpgrade.add(ChatColor.GRAY + "Achievement points:§c 10");
		        MetaskywarsAchUpgrade.setLore(ListskywarsAchUpgrade);
		        skywarsAchUpgrade.setItemMeta(MetaskywarsAchUpgrade);
			}   
		    skywarsAchievements.setItem(17, skywarsAchUpgrade);
		    ItemStack skywarsAchEnchant;
			if(enchant){
				skywarsAchEnchant = new ItemStack(Material.DIAMOND, 1);
				ItemMeta MetaskywarsAchEnchant = skywarsAchEnchant.getItemMeta();
				MetaskywarsAchEnchant.setDisplayName("§aA magical feeling");
				ArrayList<String> ListskywarsAchEnchant = new ArrayList<String>();		          
		        ListskywarsAchEnchant.add(" ");
		        ListskywarsAchEnchant.add("§aTotal feelings: §6" + enchantsFound);
		        ListskywarsAchEnchant.add(" ");
		        ListskywarsAchEnchant.add(ChatColor.GRAY + "Achievement points:§a 10");
		        MetaskywarsAchEnchant.setLore(ListskywarsAchEnchant);
		        skywarsAchEnchant.setItemMeta(MetaskywarsAchEnchant);
			}else{
			skywarsAchEnchant = new ItemStack(Material.COAL, 1);
				ItemMeta MetaskywarsAchEnchant = skywarsAchEnchant.getItemMeta();
				MetaskywarsAchEnchant.setDisplayName("§cA magical feeling");
				ArrayList<String> ListskywarsAchEnchant = new ArrayList<String>();		          
		        ListskywarsAchEnchant.add(" ");
		        ListskywarsAchEnchant.add("§aTotal feelings: §6" + enchantsFound);
		        ListskywarsAchEnchant.add(" ");
		        ListskywarsAchEnchant.add(ChatColor.GRAY + "Achievement points:§c 10");
		        MetaskywarsAchEnchant.setLore(ListskywarsAchEnchant);
		        skywarsAchEnchant.setItemMeta(MetaskywarsAchEnchant);
			}
		    skywarsAchievements.setItem(23, skywarsAchEnchant);
			ItemStack skywarsAchParty;
			if(party){
				skywarsAchParty = new ItemStack(Material.DIAMOND, 1);
				ItemMeta MetaskywarsAchParty = skywarsAchParty.getItemMeta();
				MetaskywarsAchParty.setDisplayName("§aLet's Party!");
				ArrayList<String> ListskywarsAchParty = new ArrayList<String>();		          
		        ListskywarsAchParty.add(" ");
		        ListskywarsAchParty.add("§aTotal parties attended: §6" + partysFound);
		        ListskywarsAchParty.add(" ");
		        ListskywarsAchParty.add(ChatColor.GRAY + "Achievement points:§a 10");
		        MetaskywarsAchParty.setLore(ListskywarsAchParty);
		        skywarsAchParty.setItemMeta(MetaskywarsAchParty);
			}else{
			skywarsAchParty = new ItemStack(Material.COAL, 1);
				ItemMeta MetaskywarsAchParty = skywarsAchParty.getItemMeta();
				MetaskywarsAchParty.setDisplayName("§cLet's Party!");
				ArrayList<String> ListskywarsAchParty = new ArrayList<String>();		          
		        ListskywarsAchParty.add(" ");
		        ListskywarsAchParty.add("§aTotal parties attended: §6" + partysFound);
		        ListskywarsAchParty.add(" ");
		        ListskywarsAchParty.add(ChatColor.GRAY + "Achievement points:§c 10");
		        MetaskywarsAchParty.setLore(ListskywarsAchParty);
		        skywarsAchParty.setItemMeta(MetaskywarsAchParty);
			}
		    skywarsAchievements.setItem(24, skywarsAchParty);
		    ItemStack skywarsAchNoms;
			if(noms){
				skywarsAchNoms = new ItemStack(Material.DIAMOND, 1);
				ItemMeta MetaskywarsAchNoms = skywarsAchNoms.getItemMeta();
				MetaskywarsAchNoms.setDisplayName("§aOmnomnomnom!");
				ArrayList<String> ListskywarsAchNoms = new ArrayList<String>();		          
		        ListskywarsAchNoms.add(" ");
		        ListskywarsAchNoms.add("§aTotal Omnomnomnoms: §6" + nomsFound);
		        ListskywarsAchNoms.add(" ");
		        ListskywarsAchNoms.add(ChatColor.GRAY + "Achievement points:§a 10");
		        MetaskywarsAchNoms.setLore(ListskywarsAchNoms);
		        skywarsAchNoms.setItemMeta(MetaskywarsAchNoms);
			}else{
			skywarsAchNoms = new ItemStack(Material.COAL, 1);
				ItemMeta MetaskywarsAchNoms = skywarsAchNoms.getItemMeta();
				MetaskywarsAchNoms.setDisplayName("§cOmnomnomnom!");
				ArrayList<String> ListskywarsAchNoms = new ArrayList<String>();		          
		        ListskywarsAchNoms.add(" ");
		        ListskywarsAchNoms.add("§aTotal Omnomnomnoms: §6" + nomsFound);
		        ListskywarsAchNoms.add(" ");
		        ListskywarsAchNoms.add(ChatColor.GRAY + "Achievement points:§c 10");
		        MetaskywarsAchNoms.setLore(ListskywarsAchNoms);
		        skywarsAchNoms.setItemMeta(MetaskywarsAchNoms);
			}
		    skywarsAchievements.setItem(25, skywarsAchNoms);
		    ItemStack skywarsAchDIY;
			if(DIY){
				skywarsAchDIY = new ItemStack(Material.DIAMOND, 1);
				ItemMeta MetaskywarsAchDIY = skywarsAchDIY.getItemMeta();
				MetaskywarsAchDIY.setDisplayName("§aDIY kit");
				ArrayList<String> ListskywarsAchDIY = new ArrayList<String>();		          
		        ListskywarsAchDIY.add(" ");
		        ListskywarsAchDIY.add("§aTotal DIY kits found: §6" + DIYsFound);
		        ListskywarsAchDIY.add(" ");
		        ListskywarsAchDIY.add(ChatColor.GRAY + "Achievement points:§a 10");
		        MetaskywarsAchDIY.setLore(ListskywarsAchDIY);
		        skywarsAchDIY.setItemMeta(MetaskywarsAchDIY);
			}else{
			skywarsAchDIY = new ItemStack(Material.COAL, 1);
				ItemMeta MetaskywarsAchDIY = skywarsAchDIY.getItemMeta();
				MetaskywarsAchDIY.setDisplayName("§cDIY kit");
				ArrayList<String> ListskywarsAchDIY = new ArrayList<String>();		          
		        ListskywarsAchDIY.add(" ");
		        ListskywarsAchDIY.add("§aTotal DIY kits found: §6" + DIYsFound);
		        ListskywarsAchDIY.add(" ");
		        ListskywarsAchDIY.add(ChatColor.GRAY + "Achievement points:§c 10");
		        MetaskywarsAchDIY.setLore(ListskywarsAchDIY);
		        skywarsAchDIY.setItemMeta(MetaskywarsAchDIY);
			}
		    skywarsAchievements.setItem(26, skywarsAchDIY);
		    ItemStack skywarsAchBoomBox;
			if(boomBox){
				skywarsAchBoomBox = new ItemStack(Material.DIAMOND, 1);
				ItemMeta MetaskywarsAchBoomBox = skywarsAchBoomBox.getItemMeta();
				MetaskywarsAchBoomBox.setDisplayName("§aTssssssssss....");
				ArrayList<String> ListskywarsAchBoomBox = new ArrayList<String>();		          
		        ListskywarsAchBoomBox.add(" ");
		        ListskywarsAchBoomBox.add("§aTotal BoomBoxes found: §6" + boomBoxsFound);
		        ListskywarsAchBoomBox.add(" ");
		        ListskywarsAchBoomBox.add(ChatColor.GRAY + "Achievement points:§a 10");
		        MetaskywarsAchBoomBox.setLore(ListskywarsAchBoomBox);
		        skywarsAchBoomBox.setItemMeta(MetaskywarsAchBoomBox);
			}else{
			skywarsAchBoomBox = new ItemStack(Material.COAL, 1);
				ItemMeta MetaskywarsAchBoomBox = skywarsAchBoomBox.getItemMeta();
				MetaskywarsAchBoomBox.setDisplayName("§cTssssssssss....");
				ArrayList<String> ListskywarsAchBoomBox = new ArrayList<String>();		          
		        ListskywarsAchBoomBox.add(" ");
		        ListskywarsAchBoomBox.add("§aTotal BoomBoxes found: §6" + boomBoxsFound);
		        ListskywarsAchBoomBox.add(" ");
		        ListskywarsAchBoomBox.add(ChatColor.GRAY + "Achievement points:§c 10");
		        MetaskywarsAchBoomBox.setLore(ListskywarsAchBoomBox);
		        skywarsAchBoomBox.setItemMeta(MetaskywarsAchBoomBox);
			}
		    skywarsAchievements.setItem(32, skywarsAchBoomBox);
		    ItemStack skywarsAchApple;
			if(apple){
				skywarsAchApple = new ItemStack(Material.DIAMOND, 1);
				ItemMeta MetaskywarsAchApple = skywarsAchApple.getItemMeta();
				MetaskywarsAchApple.setDisplayName("§aAn apple a day...");
				ArrayList<String> ListskywarsAchApple = new ArrayList<String>();		          
		        ListskywarsAchApple.add(" ");
		        ListskywarsAchApple.add("§aTotal GodApples found: §6" + applesFound);
		        ListskywarsAchApple.add(" ");
		        ListskywarsAchApple.add(ChatColor.GRAY + "Achievement points:§a 10");
		        MetaskywarsAchApple.setLore(ListskywarsAchApple);
		        skywarsAchApple.setItemMeta(MetaskywarsAchApple);
			}else{
			skywarsAchApple = new ItemStack(Material.COAL, 1);
				ItemMeta MetaskywarsAchApple = skywarsAchApple.getItemMeta();
				MetaskywarsAchApple.setDisplayName("§cAn apple a day...");
				ArrayList<String> ListskywarsAchApple = new ArrayList<String>();		          
		        ListskywarsAchApple.add(" ");
		        ListskywarsAchApple.add("§aTotal GodApples found: §6" + applesFound);
		        ListskywarsAchApple.add(" ");
		        ListskywarsAchApple.add(ChatColor.GRAY + "Achievement points:§c 10");
		        MetaskywarsAchApple.setLore(ListskywarsAchApple);
		        skywarsAchApple.setItemMeta(MetaskywarsAchApple);
			}
		    skywarsAchievements.setItem(33, skywarsAchApple);
		    ItemStack skywarsAchZombie;
			if(zombie){
				skywarsAchZombie = new ItemStack(Material.DIAMOND, 1);
				ItemMeta MetaskywarsAchZombie = skywarsAchZombie.getItemMeta();
				MetaskywarsAchZombie.setDisplayName("§aZombie?!?");
				ArrayList<String> ListskywarsAchZombie = new ArrayList<String>();		          
		        ListskywarsAchZombie.add(" ");
		        ListskywarsAchZombie.add("§aTotal Zombie Slashers found: §6" + zombiesFound);
		        ListskywarsAchZombie.add(" ");
		        ListskywarsAchZombie.add(ChatColor.GRAY + "Achievement points:§a 10");
		        MetaskywarsAchZombie.setLore(ListskywarsAchZombie);
		        skywarsAchZombie.setItemMeta(MetaskywarsAchZombie);
			}else{
			skywarsAchZombie = new ItemStack(Material.COAL, 1);
				ItemMeta MetaskywarsAchZombie = skywarsAchZombie.getItemMeta();
				MetaskywarsAchZombie.setDisplayName("§cZombie?!?");
				ArrayList<String> ListskywarsAchZombie = new ArrayList<String>();		          
		        ListskywarsAchZombie.add(" ");
		        ListskywarsAchZombie.add("§aTotal Zombie Slashers found: §6" + zombiesFound);
		        ListskywarsAchZombie.add(" ");
		        ListskywarsAchZombie.add(ChatColor.GRAY + "Achievement points:§c 10");
		        MetaskywarsAchZombie.setLore(ListskywarsAchZombie);
		        skywarsAchZombie.setItemMeta(MetaskywarsAchZombie);
			}
		    skywarsAchievements.setItem(34, skywarsAchZombie);
		    ItemStack skywarsAchThor;
			if(thor){
				skywarsAchThor = new ItemStack(Material.DIAMOND, 1);
				ItemMeta MetaskywarsAchThor = skywarsAchThor.getItemMeta();
				MetaskywarsAchThor.setDisplayName("§aPuny god.");
				ArrayList<String> ListskywarsAchThor = new ArrayList<String>();		          
		        ListskywarsAchThor.add(" ");
		        ListskywarsAchThor.add("§aTotal Hammers of Thor found: §6" + thorsFound);
		        ListskywarsAchThor.add(" ");
		        ListskywarsAchThor.add(ChatColor.GRAY + "Achievement points:§a 10");
		        MetaskywarsAchThor.setLore(ListskywarsAchThor);
		        skywarsAchThor.setItemMeta(MetaskywarsAchThor);
			}else{
			skywarsAchThor = new ItemStack(Material.COAL, 1);
				ItemMeta MetaskywarsAchThor = skywarsAchThor.getItemMeta();
				MetaskywarsAchThor.setDisplayName("§cPuny god.");
				ArrayList<String> ListskywarsAchThor = new ArrayList<String>();		          
		        ListskywarsAchThor.add(" ");
		        ListskywarsAchThor.add("§aTotal Hammers of Thor found: §6" + thorsFound);
		        ListskywarsAchThor.add(" ");
		        ListskywarsAchThor.add(ChatColor.GRAY + "Achievement points:§c 10");
		        MetaskywarsAchThor.setLore(ListskywarsAchThor);
		        skywarsAchThor.setItemMeta(MetaskywarsAchThor);
			}
		    skywarsAchievements.setItem(35, skywarsAchThor);
		    
		    
			
//TIERED ACHIEVEMENTS
		    ItemStack skywarsAchKills1;
			if(kills1){
				skywarsAchKills1 = new ItemStack(Material.DIAMOND_BLOCK, 1);
				ItemMeta MetaskywarsAchKills1 = skywarsAchKills1.getItemMeta();
				MetaskywarsAchKills1.setDisplayName("§aKiller 1");
				ArrayList<String> ListskywarsAchKills1 = new ArrayList<String>();		          
		        ListskywarsAchKills1.add(" ");
		        ListskywarsAchKills1.add("§aKill 5.000 people");
		        ListskywarsAchKills1.add(" ");
		        ListskywarsAchKills1.add(ChatColor.GRAY + "Achievement points:§a 5");
		        MetaskywarsAchKills1.setLore(ListskywarsAchKills1);
		        skywarsAchKills1.setItemMeta(MetaskywarsAchKills1);
			}else{
			skywarsAchKills1 = new ItemStack(Material.COAL_BLOCK, 1);
				ItemMeta MetaskywarsAchKills1 = skywarsAchKills1.getItemMeta();
				MetaskywarsAchKills1.setDisplayName("§cKiller 1");
				ArrayList<String> ListskywarsAchKills1 = new ArrayList<String>();		          
		        ListskywarsAchKills1.add(" ");
		        ListskywarsAchKills1.add(ChatColor.GRAY + "People killed:§6 " + kills + ChatColor.GRAY + "/5000");
		        ListskywarsAchKills1.add(" ");
		        ListskywarsAchKills1.add(ChatColor.GRAY + "Achievement points:§c 5");
		        MetaskywarsAchKills1.setLore(ListskywarsAchKills1);
		        skywarsAchKills1.setItemMeta(MetaskywarsAchKills1);
			}
		    skywarsAchievements.setItem(36, skywarsAchKills1);
		    ItemStack skywarsAchKills2;
		    if(kills2){
				skywarsAchKills2 = new ItemStack(Material.DIAMOND_BLOCK, 1);
				ItemMeta MetaskywarsAchKills2 = skywarsAchKills2.getItemMeta();
				MetaskywarsAchKills2.setDisplayName("§aKiller 2");
				ArrayList<String> ListskywarsAchKills2 = new ArrayList<String>();		          
		        ListskywarsAchKills2.add(" ");
		        ListskywarsAchKills2.add("§aKill 10.000 people");
		        ListskywarsAchKills2.add(" ");
		        ListskywarsAchKills2.add(ChatColor.GRAY + "Achievement points:§a 10");
		        MetaskywarsAchKills2.setLore(ListskywarsAchKills2);
		        skywarsAchKills2.setItemMeta(MetaskywarsAchKills2);
			}else{
			skywarsAchKills2 = new ItemStack(Material.COAL_BLOCK, 1);
				ItemMeta MetaskywarsAchKills2 = skywarsAchKills2.getItemMeta();
				MetaskywarsAchKills2.setDisplayName("§cKiller 2");
				ArrayList<String> ListskywarsAchKills2 = new ArrayList<String>();		          
		        ListskywarsAchKills2.add(" ");
		        ListskywarsAchKills2.add(ChatColor.GRAY + "People killed:§6 " + kills + ChatColor.GRAY + "/10000");
		        ListskywarsAchKills2.add(" ");
		        ListskywarsAchKills2.add(ChatColor.GRAY + "Achievement points:§c 10");
		        MetaskywarsAchKills2.setLore(ListskywarsAchKills2);
		        skywarsAchKills2.setItemMeta(MetaskywarsAchKills2);
			}
		    skywarsAchievements.setItem(27, skywarsAchKills2);
		    ItemStack skywarsAchKills3;
		    if(kills3){
				skywarsAchKills3 = new ItemStack(Material.DIAMOND_BLOCK, 1);
				ItemMeta MetaskywarsAchKills3 = skywarsAchKills3.getItemMeta();
				MetaskywarsAchKills3.setDisplayName("§aKiller 3");
				ArrayList<String> ListskywarsAchKills3 = new ArrayList<String>();		          
		        ListskywarsAchKills3.add(" ");
		        ListskywarsAchKills3.add("§aKill 15.000 people");
		        ListskywarsAchKills3.add(" ");
		        ListskywarsAchKills3.add(ChatColor.GRAY + "Achievement points:§a 15");
		        MetaskywarsAchKills3.setLore(ListskywarsAchKills3);
		        skywarsAchKills3.setItemMeta(MetaskywarsAchKills3);
			}else{
			skywarsAchKills3 = new ItemStack(Material.COAL_BLOCK, 1);
				ItemMeta MetaskywarsAchKills3 = skywarsAchKills3.getItemMeta();
				MetaskywarsAchKills3.setDisplayName("§cKiller 3");
				ArrayList<String> ListskywarsAchKills3 = new ArrayList<String>();		          
		        ListskywarsAchKills3.add(" ");
		        ListskywarsAchKills3.add(ChatColor.GRAY + "People killed:§6 " + kills + ChatColor.GRAY + "/15000");
		        ListskywarsAchKills3.add(" ");
		        ListskywarsAchKills3.add(ChatColor.GRAY + "Achievement points:§c 15");
		        MetaskywarsAchKills3.setLore(ListskywarsAchKills3);
		        skywarsAchKills3.setItemMeta(MetaskywarsAchKills3);
			}
		    skywarsAchievements.setItem(18, skywarsAchKills3);
		    ItemStack skywarsAchKills4;
		    if(kills4){
				skywarsAchKills4 = new ItemStack(Material.DIAMOND_BLOCK, 1);
				ItemMeta MetaskywarsAchKills4 = skywarsAchKills4.getItemMeta();
				MetaskywarsAchKills4.setDisplayName("§aKiller 4");
				ArrayList<String> ListskywarsAchKills4 = new ArrayList<String>();		          
		        ListskywarsAchKills4.add(" ");
		        ListskywarsAchKills4.add("§aKill 20.000 people");
		        ListskywarsAchKills4.add(" ");
		        ListskywarsAchKills4.add(ChatColor.GRAY + "Achievement points:§a 20");
		        MetaskywarsAchKills4.setLore(ListskywarsAchKills4);
		        skywarsAchKills4.setItemMeta(MetaskywarsAchKills4);
			}else{
			skywarsAchKills4 = new ItemStack(Material.COAL_BLOCK, 1);
				ItemMeta MetaskywarsAchKills4 = skywarsAchKills4.getItemMeta();
				MetaskywarsAchKills4.setDisplayName("§cKiller 4");
				ArrayList<String> ListskywarsAchKills4 = new ArrayList<String>();		          
		        ListskywarsAchKills4.add(" ");
		        ListskywarsAchKills4.add(ChatColor.GRAY + "People killed:§6 " + kills + ChatColor.GRAY + "/20000");
		        ListskywarsAchKills4.add(" ");
		        ListskywarsAchKills4.add(ChatColor.GRAY + "Achievement points:§c 20");
		        MetaskywarsAchKills4.setLore(ListskywarsAchKills4);
		        skywarsAchKills4.setItemMeta(MetaskywarsAchKills4);
			}
		    skywarsAchievements.setItem(9, skywarsAchKills4);
		    ItemStack skywarsAchKills5;
		    if(kills5){
				skywarsAchKills5 = new ItemStack(Material.DIAMOND_BLOCK, 1);
				ItemMeta MetaskywarsAchKills5 = skywarsAchKills5.getItemMeta();
				MetaskywarsAchKills5.setDisplayName("§aKiller 5");
				ArrayList<String> ListskywarsAchKills5 = new ArrayList<String>();		          
		        ListskywarsAchKills5.add(" ");
		        ListskywarsAchKills5.add("§aKill 25.000 people");
		        ListskywarsAchKills5.add(" ");
		        ListskywarsAchKills5.add(ChatColor.GRAY + "Achievement points:§a 20");
		        MetaskywarsAchKills5.setLore(ListskywarsAchKills5);
		        skywarsAchKills5.setItemMeta(MetaskywarsAchKills5);
			}else{
			skywarsAchKills5 = new ItemStack(Material.COAL_BLOCK, 1);
				ItemMeta MetaskywarsAchKills5 = skywarsAchKills5.getItemMeta();
				MetaskywarsAchKills5.setDisplayName("§cKiller 5");
				ArrayList<String> ListskywarsAchKills5 = new ArrayList<String>();		          
		        ListskywarsAchKills5.add(" ");
		        ListskywarsAchKills5.add(ChatColor.GRAY + "People killed:§6 " + kills + ChatColor.GRAY + "/25000");
		        ListskywarsAchKills5.add(" ");
		        ListskywarsAchKills5.add(ChatColor.GRAY + "Achievement points:§c 25");
		        MetaskywarsAchKills5.setLore(ListskywarsAchKills5);
		        skywarsAchKills5.setItemMeta(MetaskywarsAchKills5);
			}
		    skywarsAchievements.setItem(0, skywarsAchKills5);		    
		    ItemStack skywarsAchWins1;
			if(wins1){
				skywarsAchWins1 = new ItemStack(Material.DIAMOND_BLOCK, 1);
				ItemMeta MetaskywarsAchWins1 = skywarsAchWins1.getItemMeta();
				MetaskywarsAchWins1.setDisplayName("§aChampion 1");
				ArrayList<String> ListskywarsAchWins1 = new ArrayList<String>();		          
		        ListskywarsAchWins1.add(" ");
		        ListskywarsAchWins1.add("§aWin 1.000 games");
		        ListskywarsAchWins1.add(" ");
		        ListskywarsAchWins1.add(ChatColor.GRAY + "Achievement points:§a 5");
		        MetaskywarsAchWins1.setLore(ListskywarsAchWins1);
		        skywarsAchWins1.setItemMeta(MetaskywarsAchWins1);
			}else{
			skywarsAchWins1 = new ItemStack(Material.COAL_BLOCK, 1);
				ItemMeta MetaskywarsAchWins1 = skywarsAchWins1.getItemMeta();
				MetaskywarsAchWins1.setDisplayName("§cChampion 1");
				ArrayList<String> ListskywarsAchWins1 = new ArrayList<String>();		          
		        ListskywarsAchWins1.add(" ");
		        ListskywarsAchWins1.add(ChatColor.GRAY + "Games won:§6 " + wins + ChatColor.GRAY + "/1000");
		        ListskywarsAchWins1.add(" ");
		        ListskywarsAchWins1.add(ChatColor.GRAY + "Achievement points:§c 5");
		        MetaskywarsAchWins1.setLore(ListskywarsAchWins1);
		        skywarsAchWins1.setItemMeta(MetaskywarsAchWins1);
			}
		    skywarsAchievements.setItem(37, skywarsAchWins1);
		    ItemStack skywarsAchWins2;
		    if(wins2){
				skywarsAchWins2 = new ItemStack(Material.DIAMOND_BLOCK, 1);
				ItemMeta MetaskywarsAchWins2 = skywarsAchWins2.getItemMeta();
				MetaskywarsAchWins2.setDisplayName("§aChampion 2");
				ArrayList<String> ListskywarsAchWins2 = new ArrayList<String>();		          
		        ListskywarsAchWins2.add(" ");
		        ListskywarsAchWins2.add("§aWin 2.500 games");
		        ListskywarsAchWins2.add(" ");
		        ListskywarsAchWins2.add(ChatColor.GRAY + "Achievement points:§a 10");
		        MetaskywarsAchWins2.setLore(ListskywarsAchWins2);
		        skywarsAchWins2.setItemMeta(MetaskywarsAchWins2);
			}else{
			skywarsAchWins2 = new ItemStack(Material.COAL_BLOCK, 1);
				ItemMeta MetaskywarsAchWins2 = skywarsAchWins2.getItemMeta();
				MetaskywarsAchWins2.setDisplayName("§cChampion 2");
				ArrayList<String> ListskywarsAchWins2 = new ArrayList<String>();		          
		        ListskywarsAchWins2.add(" ");
		        ListskywarsAchWins2.add(ChatColor.GRAY + "Games won:§6 " + wins + ChatColor.GRAY + "/2500");
		        ListskywarsAchWins2.add(" ");
		        ListskywarsAchWins2.add(ChatColor.GRAY + "Achievement points:§c 10");
		        MetaskywarsAchWins2.setLore(ListskywarsAchWins2);
		        skywarsAchWins2.setItemMeta(MetaskywarsAchWins2);
			}
		    skywarsAchievements.setItem(28, skywarsAchWins2);
		    ItemStack skywarsAchWins3;
		    if(wins3){
				skywarsAchWins3 = new ItemStack(Material.DIAMOND_BLOCK, 1);
				ItemMeta MetaskywarsAchWins3 = skywarsAchWins3.getItemMeta();
				MetaskywarsAchWins3.setDisplayName("§aChampion 3");
				ArrayList<String> ListskywarsAchWins3 = new ArrayList<String>();		          
		        ListskywarsAchWins3.add(" ");
		        ListskywarsAchWins3.add("§aWin 5.000 games");
		        ListskywarsAchWins3.add(" ");
		        ListskywarsAchWins3.add(ChatColor.GRAY + "Achievement points:§a 15");
		        MetaskywarsAchWins3.setLore(ListskywarsAchWins3);
		        skywarsAchWins3.setItemMeta(MetaskywarsAchWins3);
			}else{
			skywarsAchWins3 = new ItemStack(Material.COAL_BLOCK, 1);
				ItemMeta MetaskywarsAchWins3 = skywarsAchWins3.getItemMeta();
				MetaskywarsAchWins3.setDisplayName("§cChampion 3");
				ArrayList<String> ListskywarsAchWins3 = new ArrayList<String>();		          
		        ListskywarsAchWins3.add(" ");
		        ListskywarsAchWins3.add(ChatColor.GRAY + "Games won:§6 " + wins + ChatColor.GRAY + "/5000");
		        ListskywarsAchWins3.add(" ");
		        ListskywarsAchWins3.add(ChatColor.GRAY + "Achievement points:§c 15");
		        MetaskywarsAchWins3.setLore(ListskywarsAchWins3);
		        skywarsAchWins3.setItemMeta(MetaskywarsAchWins3);
			}
		    skywarsAchievements.setItem(19, skywarsAchWins3);
		    ItemStack skywarsAchWins4;
		    if(wins4){
				skywarsAchWins4 = new ItemStack(Material.DIAMOND_BLOCK, 1);
				ItemMeta MetaskywarsAchWins4 = skywarsAchWins4.getItemMeta();
				MetaskywarsAchWins4.setDisplayName("§aChampion 4");
				ArrayList<String> ListskywarsAchWins4 = new ArrayList<String>();		          
		        ListskywarsAchWins4.add(" ");
		        ListskywarsAchWins4.add("§aWin 7.500 games");
		        ListskywarsAchWins4.add(" ");
		        ListskywarsAchWins4.add(ChatColor.GRAY + "Achievement points:§a 20");
		        MetaskywarsAchWins4.setLore(ListskywarsAchWins4);
		        skywarsAchWins4.setItemMeta(MetaskywarsAchWins4);
			}else{
			skywarsAchWins4 = new ItemStack(Material.COAL_BLOCK, 1);
				ItemMeta MetaskywarsAchWins4 = skywarsAchWins4.getItemMeta();
				MetaskywarsAchWins4.setDisplayName("§cChampion 4");
				ArrayList<String> ListskywarsAchWins4 = new ArrayList<String>();		          
		        ListskywarsAchWins4.add(" ");
		        ListskywarsAchWins4.add(ChatColor.GRAY + "Games won:§6 " + wins + ChatColor.GRAY + "/7500");
		        ListskywarsAchWins4.add(" ");
		        ListskywarsAchWins4.add(ChatColor.GRAY + "Achievement points:§c 20");
		        MetaskywarsAchWins4.setLore(ListskywarsAchWins4);
		        skywarsAchWins4.setItemMeta(MetaskywarsAchWins4);
			}
		    skywarsAchievements.setItem(10, skywarsAchWins4);
		    ItemStack skywarsAchWins5;
		    if(wins5){
				skywarsAchWins5 = new ItemStack(Material.DIAMOND_BLOCK, 1);
				ItemMeta MetaskywarsAchWins5 = skywarsAchWins5.getItemMeta();
				MetaskywarsAchWins5.setDisplayName("§aChampion 5");
				ArrayList<String> ListskywarsAchWins5 = new ArrayList<String>();		          
		        ListskywarsAchWins5.add(" ");
		        ListskywarsAchWins5.add("§aWin 10.000 games");
		        ListskywarsAchWins5.add(" ");
		        ListskywarsAchWins5.add(ChatColor.GRAY + "Achievement points:§a 25");
		        MetaskywarsAchWins5.setLore(ListskywarsAchWins5);
		        skywarsAchWins5.setItemMeta(MetaskywarsAchWins5);
			}else{
			skywarsAchWins5 = new ItemStack(Material.COAL_BLOCK, 1);
				ItemMeta MetaskywarsAchWins5 = skywarsAchWins5.getItemMeta();
				MetaskywarsAchWins5.setDisplayName("§cChampion 5");
				ArrayList<String> ListskywarsAchWins5 = new ArrayList<String>();		          
		        ListskywarsAchWins5.add(" ");
		        ListskywarsAchWins5.add(ChatColor.GRAY + "Games won:§6 " + wins + ChatColor.GRAY + "/10000");
		        ListskywarsAchWins5.add(" ");
		        ListskywarsAchWins5.add(ChatColor.GRAY + "Achievement points:§c 25");
		        MetaskywarsAchWins5.setLore(ListskywarsAchWins5);
		        skywarsAchWins5.setItemMeta(MetaskywarsAchWins5);
			}
		    skywarsAchievements.setItem(1, skywarsAchWins5);
		    
		    ItemStack skywarsAchPlays1;
			if(plays1){
				skywarsAchPlays1 = new ItemStack(Material.DIAMOND_BLOCK, 1);
				ItemMeta MetaskywarsAchPlays1 = skywarsAchPlays1.getItemMeta();
				MetaskywarsAchPlays1.setDisplayName("§aAddicted 1");
				ArrayList<String> ListskywarsAchPlays1 = new ArrayList<String>();		          
		        ListskywarsAchPlays1.add(" ");
		        ListskywarsAchPlays1.add("§aPlay 5.000 games");
		        ListskywarsAchPlays1.add(" ");
		        ListskywarsAchPlays1.add(ChatColor.GRAY + "Achievement points:§a 5");
		        MetaskywarsAchPlays1.setLore(ListskywarsAchPlays1);
		        skywarsAchPlays1.setItemMeta(MetaskywarsAchPlays1);
			}else{
			skywarsAchPlays1 = new ItemStack(Material.COAL_BLOCK, 1);
				ItemMeta MetaskywarsAchPlays1 = skywarsAchPlays1.getItemMeta();
				MetaskywarsAchPlays1.setDisplayName("§cAddicted 1");
				ArrayList<String> ListskywarsAchPlays1 = new ArrayList<String>();		          
		        ListskywarsAchPlays1.add(" ");
		        ListskywarsAchPlays1.add(ChatColor.GRAY + "Games played:§6 " + plays + ChatColor.GRAY + "/5000");
		        ListskywarsAchPlays1.add(" ");
		        ListskywarsAchPlays1.add(ChatColor.GRAY + "Achievement points:§c 5");
		        MetaskywarsAchPlays1.setLore(ListskywarsAchPlays1);
		        skywarsAchPlays1.setItemMeta(MetaskywarsAchPlays1);
			}
		    skywarsAchievements.setItem(38, skywarsAchPlays1);
		    ItemStack skywarsAchPlays2;
		    if(plays2){
				skywarsAchPlays2 = new ItemStack(Material.DIAMOND_BLOCK, 1);
				ItemMeta MetaskywarsAchPlays2 = skywarsAchPlays2.getItemMeta();
				MetaskywarsAchPlays2.setDisplayName("§aAddicted 2");
				ArrayList<String> ListskywarsAchPlays2 = new ArrayList<String>();		          
		        ListskywarsAchPlays2.add(" ");
		        ListskywarsAchPlays2.add("§aPlay 10.000 games");
		        ListskywarsAchPlays2.add(" ");
		        ListskywarsAchPlays2.add(ChatColor.GRAY + "Achievement points:§a 10");
		        MetaskywarsAchPlays2.setLore(ListskywarsAchPlays2);
		        skywarsAchPlays2.setItemMeta(MetaskywarsAchPlays2);
			}else{
			skywarsAchPlays2 = new ItemStack(Material.COAL_BLOCK, 1);
				ItemMeta MetaskywarsAchPlays2 = skywarsAchPlays2.getItemMeta();
				MetaskywarsAchPlays2.setDisplayName("§cAddicted 2");
				ArrayList<String> ListskywarsAchPlays2 = new ArrayList<String>();		          
		        ListskywarsAchPlays2.add(" ");
		        ListskywarsAchPlays2.add(ChatColor.GRAY + "Games played:§6 " + plays + ChatColor.GRAY + "/10000");
		        ListskywarsAchPlays2.add(" ");
		        ListskywarsAchPlays2.add(ChatColor.GRAY + "Achievement points:§c 10");
		        MetaskywarsAchPlays2.setLore(ListskywarsAchPlays2);
		        skywarsAchPlays2.setItemMeta(MetaskywarsAchPlays2);
			}
		    skywarsAchievements.setItem(29, skywarsAchPlays2);
		    ItemStack skywarsAchPlays3;
		    if(plays3){
				skywarsAchPlays3 = new ItemStack(Material.DIAMOND_BLOCK, 1);
				ItemMeta MetaskywarsAchPlays3 = skywarsAchPlays3.getItemMeta();
				MetaskywarsAchPlays3.setDisplayName("§aAddicted 3");
				ArrayList<String> ListskywarsAchPlays3 = new ArrayList<String>();		          
		        ListskywarsAchPlays3.add(" ");
		        ListskywarsAchPlays3.add("§aPlay 15.000 games");
		        ListskywarsAchPlays3.add(" ");
		        ListskywarsAchPlays3.add(ChatColor.GRAY + "Achievement points:§a 15");
		        MetaskywarsAchPlays3.setLore(ListskywarsAchPlays3);
		        skywarsAchPlays3.setItemMeta(MetaskywarsAchPlays3);
			}else{
			skywarsAchPlays3 = new ItemStack(Material.COAL_BLOCK, 1);
				ItemMeta MetaskywarsAchPlays3 = skywarsAchPlays3.getItemMeta();
				MetaskywarsAchPlays3.setDisplayName("§cAddicted 3");
				ArrayList<String> ListskywarsAchPlays3 = new ArrayList<String>();		          
		        ListskywarsAchPlays3.add(" ");
		        ListskywarsAchPlays3.add(ChatColor.GRAY + "Games played:§6 " + plays + ChatColor.GRAY + "/15000");
		        ListskywarsAchPlays3.add(" ");
		        ListskywarsAchPlays3.add(ChatColor.GRAY + "Achievement points:§c 15");
		        MetaskywarsAchPlays3.setLore(ListskywarsAchPlays3);
		        skywarsAchPlays3.setItemMeta(MetaskywarsAchPlays3);
			}
		    skywarsAchievements.setItem(20, skywarsAchPlays3);
		    ItemStack skywarsAchPlays4;
		    if(plays4){
				skywarsAchPlays4 = new ItemStack(Material.DIAMOND_BLOCK, 1);
				ItemMeta MetaskywarsAchPlays4 = skywarsAchPlays4.getItemMeta();
				MetaskywarsAchPlays4.setDisplayName("§aAddicted 4");
				ArrayList<String> ListskywarsAchPlays4 = new ArrayList<String>();		          
		        ListskywarsAchPlays4.add(" ");
		        ListskywarsAchPlays4.add("§aPlay 20.000 games");
		        ListskywarsAchPlays4.add(" ");
		        ListskywarsAchPlays4.add(ChatColor.GRAY + "Achievement points:§a 20");
		        MetaskywarsAchPlays4.setLore(ListskywarsAchPlays4);
		        skywarsAchPlays4.setItemMeta(MetaskywarsAchPlays4);
			}else{
			skywarsAchPlays4 = new ItemStack(Material.COAL_BLOCK, 1);
				ItemMeta MetaskywarsAchPlays4 = skywarsAchPlays4.getItemMeta();
				MetaskywarsAchPlays4.setDisplayName("§cAddicted 4");
				ArrayList<String> ListskywarsAchPlays4 = new ArrayList<String>();		          
		        ListskywarsAchPlays4.add(" ");
		        ListskywarsAchPlays4.add(ChatColor.GRAY + "Games played:§6 " + plays + ChatColor.GRAY + "/20000");
		        ListskywarsAchPlays4.add(" ");
		        ListskywarsAchPlays4.add(ChatColor.GRAY + "Achievement points:§c 20");
		        MetaskywarsAchPlays4.setLore(ListskywarsAchPlays4);
		        skywarsAchPlays4.setItemMeta(MetaskywarsAchPlays4);
			}
		    skywarsAchievements.setItem(11, skywarsAchPlays4);
		    ItemStack skywarsAchPlays5;
		    if(plays5){
				skywarsAchPlays5 = new ItemStack(Material.DIAMOND_BLOCK, 1);
				ItemMeta MetaskywarsAchPlays5 = skywarsAchPlays5.getItemMeta();
				MetaskywarsAchPlays5.setDisplayName("§aAddicted 5");
				ArrayList<String> ListskywarsAchPlays5 = new ArrayList<String>();		          
		        ListskywarsAchPlays5.add(" ");
		        ListskywarsAchPlays5.add("§aPlay 25.000 games");
		        ListskywarsAchPlays5.add(" ");
		        ListskywarsAchPlays5.add(ChatColor.GRAY + "Achievement points:§a 25");
		        MetaskywarsAchPlays5.setLore(ListskywarsAchPlays5);
		        skywarsAchPlays5.setItemMeta(MetaskywarsAchPlays5);
			}else{
			skywarsAchPlays5 = new ItemStack(Material.COAL_BLOCK, 1);
				ItemMeta MetaskywarsAchPlays5 = skywarsAchPlays5.getItemMeta();
				MetaskywarsAchPlays5.setDisplayName("§cAddicted 5");
				ArrayList<String> ListskywarsAchPlays5 = new ArrayList<String>();		          
		        ListskywarsAchPlays5.add(" ");
		        ListskywarsAchPlays5.add(ChatColor.GRAY + "Games played:§6 " + plays + ChatColor.GRAY + "/25000");
		        ListskywarsAchPlays5.add(" ");
		        ListskywarsAchPlays5.add(ChatColor.GRAY + "Achievement points:§c 25");
		        MetaskywarsAchPlays5.setLore(ListskywarsAchPlays5);
		        skywarsAchPlays5.setItemMeta(MetaskywarsAchPlays5);
			}
		    skywarsAchievements.setItem(2, skywarsAchPlays5);
		    
		    
			player.openInventory(skywarsAchievements);
	}

}
