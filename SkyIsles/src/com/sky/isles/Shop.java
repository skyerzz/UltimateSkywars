package com.sky.isles;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.sky.isles.Main;

public class Shop {
	private Main main;
	public Shop(Main main){
	this.main = main;
	}
	public Shop(AchievementShop achShop){
		this.achShop = achShop;
		}
	AchievementShop achShop;
	String prefix;
	File file2;
	YamlConfiguration playerConfig, config;
	
	public void initialize(){
		achShop = main.achShop;
	}
	
	public void buyShopWindowMain(Player player, UUID uuid, ItemStack clicked){
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
	        player.closeInventory(); 
	    }
		else if (clicked.getType() == Material.WOOD_SWORD && clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aKits")){          
	        showShopWindowKits(player);
	    }
		else if (clicked.getType() == Material.IRON_FENCE && clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aCages")){
			showShopWindowCages(player);
	    }
		else if (clicked.getType() == Material.ENDER_PEARL && clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aPerks")){          
	        player.closeInventory();
	        player.sendMessage(prefix + ChatColor.RED + "this feature is coming soon!");
			//showShopWindowPerks(player);
	    }		
		else if (clicked.getType() == Material.BONE && clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aDeathMessages")){          
	        showShopWindowDeathMessage(player);
	    }
		else if (clicked.getType() == Material.EMERALD){}
		else if (clicked.getType() == Material.SKULL_ITEM && clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aStats")){
			showShopWindowStats(player);
	    }
	    else{
	    	player.closeInventory();
	    	player.sendMessage(prefix + ChatColor.RED + "Something went wrong! ErrorCode: F1-001");
	    }
	           
	}
	
	public void showShopWindowMain(Player player){
		playerConfig = main.getPlayerConfig(player);
		Inventory skywarsMain = Bukkit.createInventory(null, 54, "Skywars Shop");
		  ItemStack skywarsMainBack = new ItemStack(Material.ARROW, 1); {
		          ItemMeta MetaskywarsMainBack = skywarsMainBack.getItemMeta();
		          ArrayList<String> ListskywarsMainBack = new ArrayList<String>();
		          MetaskywarsMainBack.setDisplayName("§cBack");
		          MetaskywarsMainBack.setLore(ListskywarsMainBack);
		          skywarsMainBack.setItemMeta(MetaskywarsMainBack);
		      skywarsMain.setItem(45, skywarsMainBack);
			  }
			  ItemStack skywarsMainKit = new ItemStack(Material.WOOD_SWORD, 1); {
		          ItemMeta MetaskywarsMainKit = skywarsMainKit.getItemMeta();
		          ArrayList<String> ListskywarsMainKit = new ArrayList<String>();
		          MetaskywarsMainKit.setDisplayName("§aKits");
		          ListskywarsMainKit.add("");
		          ListskywarsMainKit.add(ChatColor.GRAY + "Click to shop for Kits!");
		          MetaskywarsMainKit.setLore(ListskywarsMainKit);
		          skywarsMainKit.setItemMeta(MetaskywarsMainKit);
		      skywarsMain.setItem(11, skywarsMainKit);
		      }
			  ItemStack skywarsMainCage = new ItemStack(Material.IRON_FENCE, 1); {
		          ItemMeta MetaskywarsMainCage = skywarsMainCage.getItemMeta();
		          ArrayList<String> ListskywarsMainCage = new ArrayList<String>();
		          MetaskywarsMainCage.setDisplayName("§aCages");
		          ListskywarsMainCage.add("");
		          ListskywarsMainCage.add(ChatColor.GRAY + "Click to shop for cages!");
		          MetaskywarsMainCage.setLore(ListskywarsMainCage);
		          skywarsMainCage.setItemMeta(MetaskywarsMainCage);
		      skywarsMain.setItem(13, skywarsMainCage);
		      }
			  ItemStack skywarsMainPerks = new ItemStack(Material.ENDER_PEARL, 1); {
		          ItemMeta MetaskywarsMainPerks = skywarsMainPerks.getItemMeta();
		          ArrayList<String> ListskywarsMainPerks = new ArrayList<String>();
		          MetaskywarsMainPerks.setDisplayName("§aPerks");
		          ListskywarsMainPerks.add("");
		          ListskywarsMainPerks.add(ChatColor.GRAY + "Click to shop for Perks!");
		          ListskywarsMainPerks.add(ChatColor.RED + "Coming Soon!");
		          MetaskywarsMainPerks.setLore(ListskywarsMainPerks);
		          skywarsMainPerks.setItemMeta(MetaskywarsMainPerks);
		      skywarsMain.setItem(15, skywarsMainPerks);
		      }
			  ItemStack skywarsMainDeathMessage = new ItemStack(Material.BONE, 1); {
		          ItemMeta MetaskywarsMainDeathMessage = skywarsMainDeathMessage.getItemMeta();
		          ArrayList<String> ListskywarsMainDeathMessage = new ArrayList<String>();
		          MetaskywarsMainDeathMessage.setDisplayName("§aDeathMessages");
		          ListskywarsMainDeathMessage.add("");
		          ListskywarsMainDeathMessage.add(ChatColor.GRAY + "Click to shop for DeathMessages!");
		          MetaskywarsMainDeathMessage.setLore(ListskywarsMainDeathMessage);
		          skywarsMainDeathMessage.setItemMeta(MetaskywarsMainDeathMessage);
		      skywarsMain.setItem(31, skywarsMainDeathMessage);
		      }			  
			  ItemStack skywarsMainPlayer = new ItemStack(Material.SKULL_ITEM, 1); {
				  skywarsMainPlayer.setDurability((short)3);
		          ArrayList<String> ListskywarsMainPlayer = new ArrayList<String>();		          
		          SkullMeta sm = (SkullMeta) skywarsMainPlayer.getItemMeta();
                  sm.setOwner(player.getName());                  
                  sm.setDisplayName("§aStats");
                  ListskywarsMainPlayer.add(ChatColor.GRAY + "Click to see your stats!");
		          sm.setLore(ListskywarsMainPlayer);
		          skywarsMainPlayer.setItemMeta(sm);
		      skywarsMain.setItem(49, skywarsMainPlayer);
		      }
			  player.openInventory(skywarsMain);
		  
	}
	
	public void buyShopWindowKits(Player player, UUID uuid, ItemStack clicked){
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
		else if (clicked.getType() == Material.EMERALD){}
		else if (clicked.getType() == Material.ARROW && clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cBack")){          
	        showShopWindowMain(player); 
	    }
		else if(clicked.getType() == Material.WOOD_PICKAXE && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§adefault"))){
			String currentKit = playerConfig.getString("player.common.kit");
			if(currentKit.equalsIgnoreCase("default")){
				player.sendMessage(prefix + "§cYou already have this kit selected!");
			}
			else{
				playerConfig.set("player.common.kit", "default");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowKits(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}			
		}
		else if(clicked.getType() == Material.STONE_PICKAXE && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cMiner") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aMiner"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentKit = playerConfig.getString("player.common.kit");
			boolean hasMiner = playerConfig.getBoolean("player.kit.miner");
			if(currentKit.equalsIgnoreCase("miner")){
				player.sendMessage(prefix + "§cYou already have this kit selected!");
			}
			else if(hasMiner == true){
				playerConfig.set("player.common.kit", "miner");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowKits(player);					
			}
			else if(coins>=50000){
				coins -= 50000;
				playerConfig.set("player.common.kit", "miner");
				playerConfig.set("player.kits.miner", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowKits(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}
		else if(clicked.getType() == Material.GOLD_SWORD && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cRusher") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aRusher"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentKit = playerConfig.getString("player.common.kit");
			boolean hasRusher = playerConfig.getBoolean("player.kit.rusher");
			if(currentKit.equalsIgnoreCase("rusher")){
				player.sendMessage(prefix + "§cYou already have this kit selected!");
			}
			else if(hasRusher == true){
				playerConfig.set("player.common.kit", "rusher");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowKits(player);					
			}
			else if(coins>=50000){
				coins -= 50000;
				playerConfig.set("player.common.kit", "rusher");
				playerConfig.set("player.kits.rusher", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowKits(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}
		else if(clicked.getType() == Material.WOOD && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cBuilder") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aBuilder"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentKit = playerConfig.getString("player.common.kit");
			boolean hasBuilder = playerConfig.getBoolean("player.kit.builder");
			if(currentKit.equalsIgnoreCase("builder")){
				player.sendMessage(prefix + "§cYou already have this kit selected!");
			}
			else if(hasBuilder == true){
				playerConfig.set("player.common.kit", "builder");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowKits(player);					
			}
			else if(coins>=50000){
				coins -= 50000;
				playerConfig.set("player.common.kit", "builder");
				playerConfig.set("player.kits.builder", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowKits(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}
		else if(clicked.getType() == Material.BOW && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cArcher") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aArcher"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentKit = playerConfig.getString("player.common.kit");
			boolean hasArcher = playerConfig.getBoolean("player.kit.archer");
			if(currentKit.equalsIgnoreCase("archer")){
				player.sendMessage(prefix + "§cYou already have this kit selected!");
			}
			else if(hasArcher == true){
				playerConfig.set("player.common.kit", "archer");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowKits(player);					
			}
			else if(coins>=50000){
				coins -= 50000;
				playerConfig.set("player.common.kit", "archer");
				playerConfig.set("player.kits.archer", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowKits(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}
		else if(clicked.getType() == Material.TNT && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cCannoneer") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aCannoneer"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentKit = playerConfig.getString("player.common.kit");
			boolean hasCannoneer = playerConfig.getBoolean("player.kit.cannoneer");
			if(currentKit.equalsIgnoreCase("cannoneer")){
				player.sendMessage(prefix + "§cYou already have this kit selected!");
			}
			else if(hasCannoneer == true){
				playerConfig.set("player.common.kit", "cannoneer");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowKits(player);					
			}
			else if(coins>=50000){
				coins -= 50000;
				playerConfig.set("player.common.kit", "cannoneer");
				playerConfig.set("player.kits.cannoneer", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowKits(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}
		else if(clicked.getType() == Material.GOLD_CHESTPLATE && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cArmorer") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aArmorer"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentKit = playerConfig.getString("player.common.kit");
			boolean hasCannoneer = playerConfig.getBoolean("player.kit.armorer");
			if(currentKit.equalsIgnoreCase("armorer")){
				player.sendMessage(prefix + "§cYou already have this kit selected!");
			}
			else if(hasCannoneer == true){
				playerConfig.set("player.common.kit", "armorer");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowKits(player);					
			}
			else if(coins>=50000){
				coins -= 50000;
				playerConfig.set("player.common.kit", "armorer");
				playerConfig.set("player.kits.armorer", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowKits(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}
	    else{
	    	player.closeInventory();
	    	player.sendMessage(prefix + ChatColor.RED + "Something went wrong! ErrorCode: F3-001");
	    }       
	}
	
	public void showShopWindowKits(Player player){
		playerConfig = main.getPlayerConfig(player);
		boolean hasMiner = playerConfig.getBoolean("player.kits.miner");
		boolean hasRusher = playerConfig.getBoolean("player.kits.rusher");	
		boolean hasBuilder = playerConfig.getBoolean("player.kits.builder");
		boolean hasArcher = playerConfig.getBoolean("player.kits.archer");
		boolean hasCannoneer = playerConfig.getBoolean("player.kits.cannoneer");
		boolean hasArmorer = playerConfig.getBoolean("player.kits.armorer");	
		String currentKit = playerConfig.getString("player.common.kit");
		int coins = playerConfig.getInt("player.common.coins");
		Inventory skywarsKits = Bukkit.createInventory(null, 54, "Skywars Kits Shop");
			ItemStack skywarsTriggerBack = new ItemStack(Material.ARROW, 1); {
		          ItemMeta MetaskywarsTriggerBack = skywarsTriggerBack.getItemMeta();
		          ArrayList<String> ListskywarsTriggerBack = new ArrayList<String>();
		          MetaskywarsTriggerBack.setDisplayName("§cBack");
		          MetaskywarsTriggerBack.setLore(ListskywarsTriggerBack);
		          skywarsTriggerBack.setItemMeta(MetaskywarsTriggerBack);
		      skywarsKits.setItem(45, skywarsTriggerBack);
			  }
			ItemStack skywarsKitDefault = new ItemStack(Material.WOOD_PICKAXE, 1); {
		          ItemMeta MetaskywarsKitDefault = skywarsKitDefault.getItemMeta();
		          ArrayList<String> ListSkywarsKitDefault = new ArrayList<String>();
		          MetaskywarsKitDefault.setDisplayName("§aDefault");
		          ListSkywarsKitDefault.add("");
		          ListSkywarsKitDefault.add(ChatColor.GRAY + "wooden pickaxe");
		          ListSkywarsKitDefault.add(ChatColor.GRAY + "wooden shovel");
		          ListSkywarsKitDefault.add(ChatColor.GRAY + "wooden axe");
		          ListSkywarsKitDefault.add("");
		          if(currentKit.equalsIgnoreCase("default")){
		        	  ListSkywarsKitDefault.add("§aCurrently selected!");
		          }else{
		        	  ListSkywarsKitDefault.add("§aClick to select!");
		          }
		          MetaskywarsKitDefault.setLore(ListSkywarsKitDefault);
		          skywarsKitDefault.setItemMeta(MetaskywarsKitDefault);
		      skywarsKits.setItem(11, skywarsKitDefault);
		      }
			  ItemStack skywarsKitMiner = new ItemStack(Material.STONE_PICKAXE, 1); {
				  skywarsKitMiner.addUnsafeEnchantment(Enchantment.DIG_SPEED, 5);
		          ItemMeta MetaskywarsKitMiner = skywarsKitMiner.getItemMeta();
		          ArrayList<String> ListSkywarsKitMiner = new ArrayList<String>();
		          if(hasMiner == false){
		        	  MetaskywarsKitMiner.setDisplayName("§cMiner");
		          }else{
		        	  MetaskywarsKitMiner.setDisplayName("§aMiner");
		          }
		          ListSkywarsKitMiner.add("");
		          ListSkywarsKitMiner.add(ChatColor.GRAY + "stone pickaxe + Efficiency 5");
		          ListSkywarsKitMiner.add("");
		          if(hasMiner == false){
		        	  ListSkywarsKitMiner.add("§7Cost:§6 50.000 Coins");
		          }
		          else if(currentKit.equalsIgnoreCase("miner")){
		        	  ListSkywarsKitMiner.add("§aCurrently selected!");
		          }else{
		        	  ListSkywarsKitMiner.add("§aClick to select!");
		          }
		          MetaskywarsKitMiner.setLore(ListSkywarsKitMiner);
		          skywarsKitMiner.setItemMeta(MetaskywarsKitMiner);
		      skywarsKits.setItem(12, skywarsKitMiner);
		      }
			  ItemStack skywarsKitRusher = new ItemStack(Material.GOLD_SWORD, 1); {
				  skywarsKitRusher.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
		          ItemMeta MetaskywarsKitRusher = skywarsKitRusher.getItemMeta();
		          ArrayList<String> ListSkywarsKitRusher = new ArrayList<String>();
		          if(hasRusher == false){
		        	  MetaskywarsKitRusher.setDisplayName("§cRusher");
		          }else{
		        	  MetaskywarsKitRusher.setDisplayName("§aRusher");
		          }
		          ListSkywarsKitRusher.add("");
		          ListSkywarsKitRusher.add(ChatColor.GRAY + "golden sword + sharpness 2");
		          ListSkywarsKitRusher.add("");
		          if(hasRusher == false){
		        	  ListSkywarsKitRusher.add("§7Cost:§6 50.000 Coins");
		          }
		          else if(currentKit.equalsIgnoreCase("rusher")){
		        	  ListSkywarsKitRusher.add("§aCurrently selected!");
		          }else{
		        	  ListSkywarsKitRusher.add("§aClick to select!");
		          }
		          MetaskywarsKitRusher.setLore(ListSkywarsKitRusher);
		          skywarsKitRusher.setItemMeta(MetaskywarsKitRusher);
		      skywarsKits.setItem(13, skywarsKitRusher);
		      }
			  ItemStack skywarsKitBuilder = new ItemStack(Material.WOOD, 1); {
		          ItemMeta MetaskywarsKitBuilder = skywarsKitBuilder.getItemMeta();
		          ArrayList<String> ListSkywarsKitBuilder = new ArrayList<String>();
		          if(hasBuilder == false){
		        	  MetaskywarsKitBuilder.setDisplayName("§cBuilder");
		          }else{
		        	  MetaskywarsKitBuilder.setDisplayName("§aBuilder");
		          }
		          ListSkywarsKitBuilder.add("");
		          ListSkywarsKitBuilder.add(ChatColor.GRAY + "16 x wood planks");
		          ListSkywarsKitBuilder.add("");
		          if(hasBuilder == false){
		        	  ListSkywarsKitBuilder.add("§7Cost:§6 50.000 Coins");
		          }
		          else if(currentKit.equalsIgnoreCase("builder")){
		        	  ListSkywarsKitBuilder.add("§aCurrently selected!");
		          }else{
		        	  ListSkywarsKitBuilder.add("§aClick to select!");
		          }
		          MetaskywarsKitBuilder.setLore(ListSkywarsKitBuilder);
		          skywarsKitBuilder.setItemMeta(MetaskywarsKitBuilder);
		      skywarsKits.setItem(14, skywarsKitBuilder);
		      }
			  ItemStack skywarsKitArcher = new ItemStack(Material.BOW, 1); {
		          ItemMeta MetaskywarsKitArcher = skywarsKitArcher.getItemMeta();
		          ArrayList<String> ListSkywarsKitArcher = new ArrayList<String>();
		          if(hasArcher == false){
		        	  MetaskywarsKitArcher.setDisplayName("§cArcher");
		          }else{
		        	  MetaskywarsKitArcher.setDisplayName("§aArcher");
		          }
		          ListSkywarsKitArcher.add("");
		          ListSkywarsKitArcher.add(ChatColor.GRAY + "bow");
		          ListSkywarsKitArcher.add(ChatColor.GRAY + "10 x arrows");
		          ListSkywarsKitArcher.add("");
		          if(hasArcher == false){
		        	  ListSkywarsKitArcher.add("§7Cost:§6 50.000 Coins");
		          }
		          else if(currentKit.equalsIgnoreCase("archer")){
		        	  ListSkywarsKitArcher.add("§aCurrently selected!");
		          }else{
		        	  ListSkywarsKitArcher.add("§aClick to select!");
		          }
		          MetaskywarsKitArcher.setLore(ListSkywarsKitArcher);
		          skywarsKitArcher.setItemMeta(MetaskywarsKitArcher);
		      skywarsKits.setItem(15, skywarsKitArcher);
		      }
			  ItemStack skywarsKitCannoneer = new ItemStack(Material.TNT, 1); {
		          ItemMeta MetaskywarsKitCannoneer = skywarsKitCannoneer.getItemMeta();
		          ArrayList<String> ListSkywarsKitCannoneer = new ArrayList<String>();
		          if(hasCannoneer == false){
		        	  MetaskywarsKitCannoneer.setDisplayName("§cCannoneer");
		          }else{
		        	  MetaskywarsKitCannoneer.setDisplayName("§aCannoneer");
		          }
		          ListSkywarsKitCannoneer.add("");
		          ListSkywarsKitCannoneer.add(ChatColor.GRAY + "4 x TNT");
		          ListSkywarsKitCannoneer.add(ChatColor.GRAY + "8 x redstone");
		          ListSkywarsKitCannoneer.add(ChatColor.GRAY + "water bucket");
		          ListSkywarsKitCannoneer.add("");
		          if(hasCannoneer == false){
		        	  ListSkywarsKitCannoneer.add("§7Cost:§6 50.000 Coins");
		          }
		          else if(currentKit.equalsIgnoreCase("cannoneer")){
		        	  ListSkywarsKitCannoneer.add("§aCurrently selected!");
		          }else{
		        	  ListSkywarsKitCannoneer.add("§aClick to select!");
		          }
		          MetaskywarsKitCannoneer.setLore(ListSkywarsKitCannoneer);
		          skywarsKitCannoneer.setItemMeta(MetaskywarsKitCannoneer);
		      skywarsKits.setItem(20, skywarsKitCannoneer);
			  }
			  ItemStack skywarsKitArmorer = new ItemStack(Material.GOLD_CHESTPLATE, 1); {
		          ItemMeta MetaskywarsKitArmorer = skywarsKitArmorer.getItemMeta();
		          ArrayList<String> ListSkywarsKitArmorer = new ArrayList<String>();
		          if(hasArmorer == false){
		        	  MetaskywarsKitArmorer.setDisplayName("§cArmorer");
		          }else{
		        	  MetaskywarsKitArmorer.setDisplayName("§aArmorer");
		          }
		          ListSkywarsKitArmorer.add("");
		          ListSkywarsKitArmorer.add(ChatColor.GRAY + "set of golden armor");
		          ListSkywarsKitArmorer.add("");
		          if(hasArmorer == false){
		        	  ListSkywarsKitArmorer.add("§7Cost:§6 50.000 Coins");
		          }
		          else if(currentKit.equalsIgnoreCase("armorer")){
		        	  ListSkywarsKitArmorer.add("§aCurrently selected!");
		          }else{
		        	  ListSkywarsKitArmorer.add("§aClick to select!");
		          }
		          MetaskywarsKitArmorer.setLore(ListSkywarsKitArmorer);
		          skywarsKitArmorer.setItemMeta(MetaskywarsKitArmorer);
		      skywarsKits.setItem(21, skywarsKitArmorer);
			  }
			  ItemStack skywarsTriggerCoins = new ItemStack(Material.EMERALD, 1); {
		          ItemMeta MetaskywarsTriggerCoins = skywarsTriggerCoins.getItemMeta();
		          ArrayList<String> ListskywarsTriggerCoins = new ArrayList<String>();
		          MetaskywarsTriggerCoins.setDisplayName("§aCoins: §6" + coins);
		          MetaskywarsTriggerCoins.setLore(ListskywarsTriggerCoins);
		          skywarsTriggerCoins.setItemMeta(MetaskywarsTriggerCoins);
		      skywarsKits.setItem(49, skywarsTriggerCoins);
		      }
	          player.openInventory(skywarsKits);
	}

	public void buyShopWindowKitsIngame(Player player, UUID uuid, ItemStack clicked){
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
		else if (clicked.getType() == Material.EMERALD){}
		else if (clicked.getType() == Material.ARROW && clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cBack")){          
	        player.closeInventory();
	    }
		else if(clicked.getType() == Material.WOOD_PICKAXE && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§adefault"))){
			String currentKit = playerConfig.getString("player.common.kit");
			if(currentKit.equalsIgnoreCase("default")){
				player.sendMessage(prefix + "§cYou already have this kit selected!");
			}
			else{
				playerConfig.set("player.common.kit", "default");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowKitsIngame(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}			
		}
		else if(clicked.getType() == Material.STONE_PICKAXE && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cMiner") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aMiner"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentKit = playerConfig.getString("player.common.kit");
			boolean hasMiner = playerConfig.getBoolean("player.kit.miner");
			if(currentKit.equalsIgnoreCase("miner")){
				player.sendMessage(prefix + "§cYou already have this kit selected!");
			}
			else if(hasMiner == true){
				playerConfig.set("player.common.kit", "miner");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowKitsIngame(player);					
			}
			else if(coins>=50000){
				coins -= 50000;
				playerConfig.set("player.common.kit", "miner");
				playerConfig.set("player.kits.miner", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowKitsIngame(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}
		else if(clicked.getType() == Material.GOLD_SWORD && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cRusher") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aRusher"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentKit = playerConfig.getString("player.common.kit");
			boolean hasRusher = playerConfig.getBoolean("player.kit.rusher");
			if(currentKit.equalsIgnoreCase("rusher")){
				player.sendMessage(prefix + "§cYou already have this kit selected!");
			}
			else if(hasRusher == true){
				playerConfig.set("player.common.kit", "rusher");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowKitsIngame(player);					
			}
			else if(coins>=50000){
				coins -= 50000;
				playerConfig.set("player.common.kit", "rusher");
				playerConfig.set("player.kits.rusher", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowKitsIngame(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}
		else if(clicked.getType() == Material.WOOD && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cBuilder") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aBuilder"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentKit = playerConfig.getString("player.common.kit");
			boolean hasBuilder = playerConfig.getBoolean("player.kit.builder");
			if(currentKit.equalsIgnoreCase("builder")){
				player.sendMessage(prefix + "§cYou already have this kit selected!");
			}
			else if(hasBuilder == true){
				playerConfig.set("player.common.kit", "builder");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowKitsIngame(player);					
			}
			else if(coins>=50000){
				coins -= 50000;
				playerConfig.set("player.common.kit", "builder");
				playerConfig.set("player.kits.builder", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowKitsIngame(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}
		else if(clicked.getType() == Material.BOW && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cArcher") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aArcher"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentKit = playerConfig.getString("player.common.kit");
			boolean hasArcher = playerConfig.getBoolean("player.kit.archer");
			if(currentKit.equalsIgnoreCase("archer")){
				player.sendMessage(prefix + "§cYou already have this kit selected!");
			}
			else if(hasArcher == true){
				playerConfig.set("player.common.kit", "archer");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowKitsIngame(player);					
			}
			else if(coins>=50000){
				coins -= 50000;
				playerConfig.set("player.common.kit", "archer");
				playerConfig.set("player.kits.archer", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowKitsIngame(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}
		else if(clicked.getType() == Material.TNT && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cCannoneer") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aCannoneer"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentKit = playerConfig.getString("player.common.kit");
			boolean hasCannoneer = playerConfig.getBoolean("player.kit.cannoneer");
			if(currentKit.equalsIgnoreCase("cannoneer")){
				player.sendMessage(prefix + "§cYou already have this kit selected!");
			}
			else if(hasCannoneer == true){
				playerConfig.set("player.common.kit", "cannoneer");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowKitsIngame(player);					
			}
			else if(coins>=50000){
				coins -= 50000;
				playerConfig.set("player.common.kit", "cannoneer");
				playerConfig.set("player.kits.cannoneer", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowKitsIngame(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}
		else if(clicked.getType() == Material.GOLD_CHESTPLATE && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cArmorer") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aArmorer"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentKit = playerConfig.getString("player.common.kit");
			boolean hasCannoneer = playerConfig.getBoolean("player.kit.armorer");
			if(currentKit.equalsIgnoreCase("armorer")){
				player.sendMessage(prefix + "§cYou already have this kit selected!");
			}
			else if(hasCannoneer == true){
				playerConfig.set("player.common.kit", "armorer");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowKitsIngame(player);					
			}
			else if(coins>=50000){
				coins -= 50000;
				playerConfig.set("player.common.kit", "armorer");
				playerConfig.set("player.kits.armorer", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowKitsIngame(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}
	    else{
	    	player.closeInventory();
	    	player.sendMessage(prefix + ChatColor.RED + "Something went wrong! ErrorCode: F5-001");
	    }       
	}
	
	public void showShopWindowKitsIngame(Player player){
		playerConfig = main.getPlayerConfig(player);
		boolean hasMiner = playerConfig.getBoolean("player.kits.miner");
		boolean hasRusher = playerConfig.getBoolean("player.kits.rusher");	
		boolean hasBuilder = playerConfig.getBoolean("player.kits.builder");
		boolean hasArcher = playerConfig.getBoolean("player.kits.archer");
		boolean hasCannoneer = playerConfig.getBoolean("player.kits.cannoneer");
		boolean hasArmorer = playerConfig.getBoolean("player.kits.armorer");	
		String currentKit = playerConfig.getString("player.common.kit");
		int coins = playerConfig.getInt("player.common.coins");
		Inventory skywarsKits = Bukkit.createInventory(null, 54, "Skywars Kits Shop - INGAME");	
		ItemStack skywarsTriggerBack = new ItemStack(Material.ARROW, 1); {
	          ItemMeta MetaskywarsTriggerBack = skywarsTriggerBack.getItemMeta();
	          ArrayList<String> ListskywarsTriggerBack = new ArrayList<String>();
	          MetaskywarsTriggerBack.setDisplayName("§cBack");
	          MetaskywarsTriggerBack.setLore(ListskywarsTriggerBack);
	          skywarsTriggerBack.setItemMeta(MetaskywarsTriggerBack);
	      skywarsKits.setItem(45, skywarsTriggerBack);
		  }
			ItemStack skywarsKitDefault = new ItemStack(Material.WOOD_PICKAXE, 1); {
		          ItemMeta MetaskywarsKitDefault = skywarsKitDefault.getItemMeta();
		          ArrayList<String> ListSkywarsKitDefault = new ArrayList<String>();
		          MetaskywarsKitDefault.setDisplayName("§aDefault");
		          ListSkywarsKitDefault.add("");
		          ListSkywarsKitDefault.add(ChatColor.GRAY + "wooden pickaxe");
		          ListSkywarsKitDefault.add(ChatColor.GRAY + "wooden shovel");
		          ListSkywarsKitDefault.add(ChatColor.GRAY + "wooden axe");
		          ListSkywarsKitDefault.add("");
		          if(currentKit.equalsIgnoreCase("default")){
		        	  ListSkywarsKitDefault.add("§aCurrently selected!");
		          }else{
		        	  ListSkywarsKitDefault.add("§aClick to select!");
		          }
		          MetaskywarsKitDefault.setLore(ListSkywarsKitDefault);
		          skywarsKitDefault.setItemMeta(MetaskywarsKitDefault);
		      skywarsKits.setItem(11, skywarsKitDefault);
		      }
			  ItemStack skywarsKitMiner = new ItemStack(Material.STONE_PICKAXE, 1); {
				  skywarsKitMiner.addUnsafeEnchantment(Enchantment.DIG_SPEED, 5);
		          ItemMeta MetaskywarsKitMiner = skywarsKitMiner.getItemMeta();
		          ArrayList<String> ListSkywarsKitMiner = new ArrayList<String>();
		          if(hasMiner == false){
		        	  MetaskywarsKitMiner.setDisplayName("§cMiner");
		          }else{
		        	  MetaskywarsKitMiner.setDisplayName("§aMiner");
		          }
		          ListSkywarsKitMiner.add("");
		          ListSkywarsKitMiner.add(ChatColor.GRAY + "stone pickaxe + Efficiency 5");
		          ListSkywarsKitMiner.add("");
		          if(hasMiner == false){
		        	  ListSkywarsKitMiner.add("§7Cost:§6 50.000 Coins");
		          }
		          else if(currentKit.equalsIgnoreCase("miner")){
		        	  ListSkywarsKitMiner.add("§aCurrently selected!");
		          }else{
		        	  ListSkywarsKitMiner.add("§aClick to select!");
		          }
		          MetaskywarsKitMiner.setLore(ListSkywarsKitMiner);
		          skywarsKitMiner.setItemMeta(MetaskywarsKitMiner);
		      skywarsKits.setItem(12, skywarsKitMiner);
		      }
			  ItemStack skywarsKitRusher = new ItemStack(Material.GOLD_SWORD, 1); {
				  skywarsKitRusher.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
		          ItemMeta MetaskywarsKitRusher = skywarsKitRusher.getItemMeta();
		          ArrayList<String> ListSkywarsKitRusher = new ArrayList<String>();
		          if(hasRusher == false){
		        	  MetaskywarsKitRusher.setDisplayName("§cRusher");
		          }else{
		        	  MetaskywarsKitRusher.setDisplayName("§aRusher");
		          }
		          ListSkywarsKitRusher.add("");
		          ListSkywarsKitRusher.add(ChatColor.GRAY + "golden sword + sharpness 2");
		          ListSkywarsKitRusher.add("");
		          if(hasRusher == false){
		        	  ListSkywarsKitRusher.add("§7Cost:§6 50.000 Coins");
		          }
		          else if(currentKit.equalsIgnoreCase("rusher")){
		        	  ListSkywarsKitRusher.add("§aCurrently selected!");
		          }else{
		        	  ListSkywarsKitRusher.add("§aClick to select!");
		          }
		          MetaskywarsKitRusher.setLore(ListSkywarsKitRusher);
		          skywarsKitRusher.setItemMeta(MetaskywarsKitRusher);
		      skywarsKits.setItem(13, skywarsKitRusher);
		      }
			  ItemStack skywarsKitBuilder = new ItemStack(Material.WOOD, 1); {
		          ItemMeta MetaskywarsKitBuilder = skywarsKitBuilder.getItemMeta();
		          ArrayList<String> ListSkywarsKitBuilder = new ArrayList<String>();
		          if(hasBuilder == false){
		        	  MetaskywarsKitBuilder.setDisplayName("§cBuilder");
		          }else{
		        	  MetaskywarsKitBuilder.setDisplayName("§aBuilder");
		          }
		          ListSkywarsKitBuilder.add("");
		          ListSkywarsKitBuilder.add(ChatColor.GRAY + "16 x wood planks");
		          ListSkywarsKitBuilder.add("");
		          if(hasBuilder == false){
		        	  ListSkywarsKitBuilder.add("§7Cost:§6 50.000 Coins");
		          }
		          else if(currentKit.equalsIgnoreCase("builder")){
		        	  ListSkywarsKitBuilder.add("§aCurrently selected!");
		          }else{
		        	  ListSkywarsKitBuilder.add("§aClick to select!");
		          }
		          MetaskywarsKitBuilder.setLore(ListSkywarsKitBuilder);
		          skywarsKitBuilder.setItemMeta(MetaskywarsKitBuilder);
		      skywarsKits.setItem(14, skywarsKitBuilder);
		      }
			  ItemStack skywarsKitArcher = new ItemStack(Material.BOW, 1); {
		          ItemMeta MetaskywarsKitArcher = skywarsKitArcher.getItemMeta();
		          ArrayList<String> ListSkywarsKitArcher = new ArrayList<String>();
		          if(hasArcher == false){
		        	  MetaskywarsKitArcher.setDisplayName("§cArcher");
		          }else{
		        	  MetaskywarsKitArcher.setDisplayName("§aArcher");
		          }
		          ListSkywarsKitArcher.add("");
		          ListSkywarsKitArcher.add(ChatColor.GRAY + "bow");
		          ListSkywarsKitArcher.add(ChatColor.GRAY + "10 x arrows");
		          ListSkywarsKitArcher.add("");
		          if(hasArcher == false){
		        	  ListSkywarsKitArcher.add("§7Cost:§6 50.000 Coins");
		          }
		          else if(currentKit.equalsIgnoreCase("archer")){
		        	  ListSkywarsKitArcher.add("§aCurrently selected!");
		          }else{
		        	  ListSkywarsKitArcher.add("§aClick to select!");
		          }
		          MetaskywarsKitArcher.setLore(ListSkywarsKitArcher);
		          skywarsKitArcher.setItemMeta(MetaskywarsKitArcher);
		      skywarsKits.setItem(15, skywarsKitArcher);
		      }
			  ItemStack skywarsKitCannoneer = new ItemStack(Material.TNT, 1); {
		          ItemMeta MetaskywarsKitCannoneer = skywarsKitCannoneer.getItemMeta();
		          ArrayList<String> ListSkywarsKitCannoneer = new ArrayList<String>();
		          if(hasCannoneer == false){
		        	  MetaskywarsKitCannoneer.setDisplayName("§cCannoneer");
		          }else{
		        	  MetaskywarsKitCannoneer.setDisplayName("§aCannoneer");
		          }
		          ListSkywarsKitCannoneer.add("");
		          ListSkywarsKitCannoneer.add(ChatColor.GRAY + "4 x TNT");
		          ListSkywarsKitCannoneer.add(ChatColor.GRAY + "8 x redstone");
		          ListSkywarsKitCannoneer.add(ChatColor.GRAY + "water bucket");
		          ListSkywarsKitCannoneer.add("");
		          if(hasCannoneer == false){
		        	  ListSkywarsKitCannoneer.add("§7Cost:§6 50.000 Coins");
		          }
		          else if(currentKit.equalsIgnoreCase("cannoneer")){
		        	  ListSkywarsKitCannoneer.add("§aCurrently selected!");
		          }else{
		        	  ListSkywarsKitCannoneer.add("§aClick to select!");
		          }
		          MetaskywarsKitCannoneer.setLore(ListSkywarsKitCannoneer);
		          skywarsKitCannoneer.setItemMeta(MetaskywarsKitCannoneer);
		      skywarsKits.setItem(20, skywarsKitCannoneer);
			  }
			  ItemStack skywarsKitArmorer = new ItemStack(Material.GOLD_CHESTPLATE, 1); {
		          ItemMeta MetaskywarsKitArmorer = skywarsKitArmorer.getItemMeta();
		          ArrayList<String> ListSkywarsKitArmorer = new ArrayList<String>();
		          if(hasArmorer == false){
		        	  MetaskywarsKitArmorer.setDisplayName("§cArmorer");
		          }else{
		        	  MetaskywarsKitArmorer.setDisplayName("§aArmorer");
		          }
		          ListSkywarsKitArmorer.add("");
		          ListSkywarsKitArmorer.add(ChatColor.GRAY + "set of golden armor");
		          ListSkywarsKitArmorer.add("");
		          if(hasArmorer == false){
		        	  ListSkywarsKitArmorer.add("§7Cost:§6 50.000 Coins");
		          }
		          else if(currentKit.equalsIgnoreCase("armorer")){
		        	  ListSkywarsKitArmorer.add("§aCurrently selected!");
		          }else{
		        	  ListSkywarsKitArmorer.add("§aClick to select!");
		          }
		          MetaskywarsKitArmorer.setLore(ListSkywarsKitArmorer);
		          skywarsKitArmorer.setItemMeta(MetaskywarsKitArmorer);
		      skywarsKits.setItem(21, skywarsKitArmorer);
			  }
			  ItemStack skywarsTriggerCoins = new ItemStack(Material.EMERALD, 1); {
		          ItemMeta MetaskywarsTriggerCoins = skywarsTriggerCoins.getItemMeta();
		          ArrayList<String> ListskywarsTriggerCoins = new ArrayList<String>();
		          MetaskywarsTriggerCoins.setDisplayName("§aCoins: §6" + coins);
		          MetaskywarsTriggerCoins.setLore(ListskywarsTriggerCoins);
		          skywarsTriggerCoins.setItemMeta(MetaskywarsTriggerCoins);
		      skywarsKits.setItem(49, skywarsTriggerCoins);
		      }
	          player.openInventory(skywarsKits);
	}
	
	public void buyShopWindowDeathMessage(Player player, UUID uuid, ItemStack clicked){	
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
		else if (clicked.getType() == Material.EMERALD){}
		else if (clicked.getType() == Material.ARROW && clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cBack")){          
	        showShopWindowMain(player); 
	    }
		else if(clicked.getType() == Material.PAPER && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aKilled"))){
			String currentDeathMessage = playerConfig.getString("player.common.deathmessage");
			if(currentDeathMessage.equalsIgnoreCase("killed")){
				player.sendMessage(prefix + "§cYou already have this deathmessage selected!");
			}
			else{
				playerConfig.set("player.common.deathmessage", "killed");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowDeathMessage(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}			
		}
		else if(clicked.getType() == Material.PAPER && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cSlaughtered") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aSlaughtered"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentDeathMessage = playerConfig.getString("player.common.deathmessage");
			boolean hasSlaughtered = playerConfig.getBoolean("player.deathmessage.slaughtered");
			if(currentDeathMessage.equalsIgnoreCase("slaughtered")){
				player.sendMessage(prefix + "§cYou already have this deathmessage selected!");
			}
			else if(hasSlaughtered == true){
				playerConfig.set("player.common.deathmessage", "slaughtered");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowDeathMessage(player);					
			}
			else if(coins>=100000){
				coins -= 100000;
				playerConfig.set("player.common.deathmessage", "slaughtered");
				playerConfig.set("player.deathmessages.slaughtered", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowDeathMessage(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}
		else if(clicked.getType() == Material.PAPER && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cDestroyed") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aDestroyed"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentDeathMessage = playerConfig.getString("player.common.deathmessage");
			boolean hasDestroyed = playerConfig.getBoolean("player.deathmessage.destroyed");
			if(currentDeathMessage.equalsIgnoreCase("destroyed")){
				player.sendMessage(prefix + "§cYou already have this deathmessage selected!");
			}
			else if(hasDestroyed == true){
				playerConfig.set("player.common.deathmessage", "destroyed");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowDeathMessage(player);					
			}
			else if(coins>=100000){
				coins -= 100000;
				playerConfig.set("player.common.deathmessage", "destroyed");
				playerConfig.set("player.deathmessages.destroyed", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowDeathMessage(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}
		else if(clicked.getType() == Material.PAPER && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cHumiliated") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aHumiliated"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentDeathMessage = playerConfig.getString("player.common.deathmessage");
			boolean hasHumiliated = playerConfig.getBoolean("player.deathmessage.humiliated");
			if(currentDeathMessage.equalsIgnoreCase("humiliated")){
				player.sendMessage(prefix + "§cYou already have this deathmessage selected!");
			}
			else if(hasHumiliated == true){
				playerConfig.set("player.common.deathmessage", "humiliated");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowDeathMessage(player);					
			}
			else if(coins>=100000){
				coins -= 100000;
				playerConfig.set("player.common.deathmessage", "humiliated");
				playerConfig.set("player.deathmessages.humiliated", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowDeathMessage(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}
		else if(clicked.getType() == Material.PAPER && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cErased") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aErased"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentDeathMessage = playerConfig.getString("player.common.deathmessage");
			boolean hasErased = playerConfig.getBoolean("player.deathmessage.erased");
			if(currentDeathMessage.equalsIgnoreCase("erased")){
				player.sendMessage(prefix + "§cYou already have this deathmessage selected!");
			}
			else if(hasErased == true){
				playerConfig.set("player.common.deathmessage", "erased");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowDeathMessage(player);					
			}
			else if(coins>=100000){
				coins -= 100000;
				playerConfig.set("player.common.deathmessage", "erased");
				playerConfig.set("player.deathmessages.erased", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowDeathMessage(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}
		else if(clicked.getType() == Material.PAPER && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cOblivion") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aOblivion"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentDeathMessage = playerConfig.getString("player.common.deathmessage");
			boolean hasOblivion = playerConfig.getBoolean("player.deathmessage.oblivion");
			if(currentDeathMessage.equalsIgnoreCase("sent to oblivion")){
				player.sendMessage(prefix + "§cYou already have this deathmessage selected!");
			}
			else if(hasOblivion == true){
				playerConfig.set("player.common.deathmessage", "oblivion");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowDeathMessage(player);					
			}
			else if(coins>=200000){
				coins -= 200000;
				playerConfig.set("player.common.deathmessage", "sent to oblivion");
				playerConfig.set("player.deathmessages.oblivion", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowDeathMessage(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}
		else if(clicked.getType() == Material.PAPER && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cREKT") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aREKT"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentDeathMessage = playerConfig.getString("player.common.deathmessage");
			boolean hasREKT = playerConfig.getBoolean("player.deathmessage.rekt");
			if(currentDeathMessage.equalsIgnoreCase("REKT")){
				player.sendMessage(prefix + "§cYou already have this deathmessage selected!");
			}
			else if(hasREKT == true){
				playerConfig.set("player.common.deathmessage", "REKT");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowDeathMessage(player);					
			}
			else if(coins>=250000){
				coins -= 250000;
				playerConfig.set("player.common.deathmessage", "REKT");
				playerConfig.set("player.deathmessages.rekt", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowDeathMessage(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}
	    else{
	    	player.closeInventory();
	    	player.sendMessage(ChatColor.RED + "Something went wrong! ErrorCode: F7-001");
	    }       
	}
	
	public void showShopWindowDeathMessage(Player player){
		playerConfig = main.getPlayerConfig(player);
		boolean hasSlaughtered = playerConfig.getBoolean("player.deathmessages.slaughtered");
		boolean hasDestroyed = playerConfig.getBoolean("player.deathmessages.destroyed");
		boolean hasHumiliated = playerConfig.getBoolean("player.deathmessages.humiliated");
		boolean hasErased = playerConfig.getBoolean("player.deathmessages.humiliated");
		boolean hasOblivion = playerConfig.getBoolean("player.deathmessages.oblivion");
		boolean hasRekt = playerConfig.getBoolean("player.deathmessages.rekt");
		String currentDeathMessage = playerConfig.getString("player.common.deathmessage");
		int coins = playerConfig.getInt("player.common.coins");
		Inventory skywarsDeathMessages = Bukkit.createInventory(null, 54, "Skywars DeathMessages Shop");
			ItemStack skywarsDeathMessageBack = new ItemStack(Material.ARROW, 1); {
		          ItemMeta MetaskywarsDeathMessageBack = skywarsDeathMessageBack.getItemMeta();
		          ArrayList<String> ListskywarsDeathMessageBack = new ArrayList<String>();
		          MetaskywarsDeathMessageBack.setDisplayName("§cBack");
		          MetaskywarsDeathMessageBack.setLore(ListskywarsDeathMessageBack);
		          skywarsDeathMessageBack.setItemMeta(MetaskywarsDeathMessageBack);
		      skywarsDeathMessages.setItem(45, skywarsDeathMessageBack);
			  }
			ItemStack skywarsDeathMessageKilled = new ItemStack(Material.PAPER, 1); {
		          ItemMeta MetaskywarsDeathMessageKilled = skywarsDeathMessageKilled.getItemMeta();
		          ArrayList<String> ListSkywarsDeathMessageKilled = new ArrayList<String>();
		          MetaskywarsDeathMessageKilled.setDisplayName("§aKilled");
		          ListSkywarsDeathMessageKilled.add("");
		          ListSkywarsDeathMessageKilled.add(ChatColor.GRAY + "will change your kill messages to");
		          ListSkywarsDeathMessageKilled.add(ChatColor.GRAY + "\"was killed by\"");
		          ListSkywarsDeathMessageKilled.add("");
		          if(currentDeathMessage.equalsIgnoreCase("killed")){
		        	  ListSkywarsDeathMessageKilled.add("§aCurrently selected!");
		        	  skywarsDeathMessageKilled.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		          }else{
		        	  ListSkywarsDeathMessageKilled.add("§aClick to select!");
		          }
		          MetaskywarsDeathMessageKilled.setLore(ListSkywarsDeathMessageKilled);
		          skywarsDeathMessageKilled.setItemMeta(MetaskywarsDeathMessageKilled);
		      skywarsDeathMessages.setItem(11, skywarsDeathMessageKilled);
		      }
			  ItemStack skywarsDeathMessageSlaughtered = new ItemStack(Material.PAPER, 1); {
		          ItemMeta MetaskywarsDeathMessageSlaughtered = skywarsDeathMessageSlaughtered.getItemMeta();
		          ArrayList<String> ListSkywarsDeathMessageSlaughtered = new ArrayList<String>();
		          if(hasSlaughtered == false){
		        	  MetaskywarsDeathMessageSlaughtered.setDisplayName("§cSlaughtered");
		          }else{
		        	  MetaskywarsDeathMessageSlaughtered.setDisplayName("§aSlaughtered");
		          }
		          ListSkywarsDeathMessageSlaughtered.add("");
		          ListSkywarsDeathMessageSlaughtered.add(ChatColor.GRAY + "will change your kill messages to");
		          ListSkywarsDeathMessageSlaughtered.add(ChatColor.GRAY + "\"was slaughtered by\"");
		          ListSkywarsDeathMessageSlaughtered.add("");
		          if(hasSlaughtered == false){
		        	  ListSkywarsDeathMessageSlaughtered.add("§7Cost:§6 100.000 Coins");
		          }
		          else if(currentDeathMessage.equalsIgnoreCase("slaughtered")){
		        	  ListSkywarsDeathMessageSlaughtered.add("§aCurrently selected!");
		        	  skywarsDeathMessageSlaughtered.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		          }else{
		        	  ListSkywarsDeathMessageSlaughtered.add("§aClick to select!");
		          }
		          MetaskywarsDeathMessageSlaughtered.setLore(ListSkywarsDeathMessageSlaughtered);
		          skywarsDeathMessageSlaughtered.setItemMeta(MetaskywarsDeathMessageSlaughtered);
		      skywarsDeathMessages.setItem(12, skywarsDeathMessageSlaughtered);
		      }
			  ItemStack skywarsDeathMessageDestroyed = new ItemStack(Material.PAPER, 1); {
		          ItemMeta MetaskywarsDeathMessageDestroyed = skywarsDeathMessageDestroyed.getItemMeta();
		          ArrayList<String> ListSkywarsDeathMessageDestroyed = new ArrayList<String>();
		          if(hasDestroyed == false){
		        	  MetaskywarsDeathMessageDestroyed.setDisplayName("§cDestroyed");
		          }else{
		        	  MetaskywarsDeathMessageDestroyed.setDisplayName("§aDestroyed");
		          }
		          ListSkywarsDeathMessageDestroyed.add("");
		          ListSkywarsDeathMessageDestroyed.add(ChatColor.GRAY + "will change your kill messages to");
		          ListSkywarsDeathMessageDestroyed.add(ChatColor.GRAY + "\"was Destroyed by\"");
		          ListSkywarsDeathMessageDestroyed.add("");
		          if(hasDestroyed == false){
		        	  ListSkywarsDeathMessageDestroyed.add("§7Cost:§6 100.000 Coins");
		          }
		          else if(currentDeathMessage.equalsIgnoreCase("Destroyed")){
		        	  ListSkywarsDeathMessageDestroyed.add("§aCurrently selected!");
		        	  skywarsDeathMessageDestroyed.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		          }else{
		        	  ListSkywarsDeathMessageDestroyed.add("§aClick to select!");
		          }
		          MetaskywarsDeathMessageDestroyed.setLore(ListSkywarsDeathMessageDestroyed);
		          skywarsDeathMessageDestroyed.setItemMeta(MetaskywarsDeathMessageDestroyed);
		      skywarsDeathMessages.setItem(13, skywarsDeathMessageDestroyed);
		      }
			  ItemStack skywarsDeathMessageHumiliated = new ItemStack(Material.PAPER, 1); {
		          ItemMeta MetaskywarsDeathMessageHumiliated = skywarsDeathMessageHumiliated.getItemMeta();
		          ArrayList<String> ListSkywarsDeathMessageHumiliated = new ArrayList<String>();
		          if(hasHumiliated == false){
		        	  MetaskywarsDeathMessageHumiliated.setDisplayName("§cHumiliated");
		          }else{
		        	  MetaskywarsDeathMessageHumiliated.setDisplayName("§aHumiliated");
		          }
		          ListSkywarsDeathMessageHumiliated.add("");
		          ListSkywarsDeathMessageHumiliated.add(ChatColor.GRAY + "will change your kill messages to");
		          ListSkywarsDeathMessageHumiliated.add(ChatColor.GRAY + "\"was Humiliated by\"");
		          ListSkywarsDeathMessageHumiliated.add("");
		          if(hasHumiliated == false){
		        	  ListSkywarsDeathMessageHumiliated.add("§7Cost:§6 100.000 Coins");
		          }
		          else if(currentDeathMessage.equalsIgnoreCase("Humiliated")){
		        	  ListSkywarsDeathMessageHumiliated.add("§aCurrently selected!");
		        	  skywarsDeathMessageHumiliated.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		          }else{
		        	  ListSkywarsDeathMessageHumiliated.add("§aClick to select!");
		          }
		          MetaskywarsDeathMessageHumiliated.setLore(ListSkywarsDeathMessageHumiliated);
		          skywarsDeathMessageHumiliated.setItemMeta(MetaskywarsDeathMessageHumiliated);
		      skywarsDeathMessages.setItem(14, skywarsDeathMessageHumiliated);
		      }
			  ItemStack skywarsDeathMessageErased = new ItemStack(Material.PAPER, 1); {
		          ItemMeta MetaskywarsDeathMessageErased = skywarsDeathMessageErased.getItemMeta();
		          ArrayList<String> ListSkywarsDeathMessageErased = new ArrayList<String>();
		          if(hasErased == false){
		        	  MetaskywarsDeathMessageErased.setDisplayName("§cErased");
		          }else{
		        	  MetaskywarsDeathMessageErased.setDisplayName("§aErased");
		          }
		          ListSkywarsDeathMessageErased.add("");
		          ListSkywarsDeathMessageErased.add(ChatColor.GRAY + "will change your kill messages to");
		          ListSkywarsDeathMessageErased.add(ChatColor.GRAY + "\"was Erased by\"");
		          ListSkywarsDeathMessageErased.add("");
		          if(hasErased == false){
		        	  ListSkywarsDeathMessageErased.add("§7Cost:§6 100.000 Coins");
		          }
		          else if(currentDeathMessage.equalsIgnoreCase("Erased")){
		        	  ListSkywarsDeathMessageErased.add("§aCurrently selected!");
		        	  skywarsDeathMessageErased.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		          }else{
		        	  ListSkywarsDeathMessageErased.add("§aClick to select!");
		          }
		          MetaskywarsDeathMessageErased.setLore(ListSkywarsDeathMessageErased);
		          skywarsDeathMessageErased.setItemMeta(MetaskywarsDeathMessageErased);
		      skywarsDeathMessages.setItem(15, skywarsDeathMessageErased);
		      }
			  ItemStack skywarsDeathMessageOblivion = new ItemStack(Material.PAPER, 1); {
		          ItemMeta MetaskywarsDeathMessageOblivion = skywarsDeathMessageOblivion.getItemMeta();
		          ArrayList<String> ListSkywarsDeathMessageOblivion = new ArrayList<String>();
		          if(hasOblivion == false){
		        	  MetaskywarsDeathMessageOblivion.setDisplayName("§cOblivion");
		          }else{
		        	  MetaskywarsDeathMessageOblivion.setDisplayName("§aOblivion");
		          }
		          ListSkywarsDeathMessageOblivion.add("");
		          ListSkywarsDeathMessageOblivion.add(ChatColor.GRAY + "will change your kill messages to");
		          ListSkywarsDeathMessageOblivion.add(ChatColor.GRAY + "\"was sent to Oblivion by\"");
		          ListSkywarsDeathMessageOblivion.add("");
		          if(hasOblivion == false){
		        	  ListSkywarsDeathMessageOblivion.add("§7Cost:§6 200.000 Coins");
		          }
		          else if(currentDeathMessage.equalsIgnoreCase("sent to oblivion")){
		        	  ListSkywarsDeathMessageOblivion.add("§aCurrently selected!");
		        	  skywarsDeathMessageOblivion.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		          }else{
		        	  ListSkywarsDeathMessageOblivion.add("§aClick to select!");
		          }
		          MetaskywarsDeathMessageOblivion.setLore(ListSkywarsDeathMessageOblivion);
		          skywarsDeathMessageOblivion.setItemMeta(MetaskywarsDeathMessageOblivion);
		      skywarsDeathMessages.setItem(20, skywarsDeathMessageOblivion);
		      }
			  ItemStack skywarsDeathMessageRekt = new ItemStack(Material.PAPER, 1); {
		          ItemMeta MetaskywarsDeathMessageRekt = skywarsDeathMessageRekt.getItemMeta();
		          ArrayList<String> ListSkywarsDeathMessageRekt = new ArrayList<String>();
		          if(hasRekt == false){
		        	  MetaskywarsDeathMessageRekt.setDisplayName("§cREKT");
		          }else{
		        	  MetaskywarsDeathMessageRekt.setDisplayName("§aREKT");
		          }
		          ListSkywarsDeathMessageRekt.add("");
		          ListSkywarsDeathMessageRekt.add(ChatColor.GRAY + "will change your kill messages to");
		          ListSkywarsDeathMessageRekt.add(ChatColor.GRAY + "\"was sent to REKT by\"");
		          ListSkywarsDeathMessageRekt.add("");
		          if(hasRekt == false){
		        	  ListSkywarsDeathMessageRekt.add("§7Cost:§6 250.000 Coins");
		          }
		          else if(currentDeathMessage.equalsIgnoreCase("Rekt")){
		        	  ListSkywarsDeathMessageRekt.add("§aCurrently selected!");
		        	  skywarsDeathMessageRekt.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		          }else{
		        	  ListSkywarsDeathMessageRekt.add("§aClick to select!");
		          }
		          MetaskywarsDeathMessageRekt.setLore(ListSkywarsDeathMessageRekt);
		          skywarsDeathMessageRekt.setItemMeta(MetaskywarsDeathMessageRekt);
		      skywarsDeathMessages.setItem(21, skywarsDeathMessageRekt);
		      }
			  ItemStack skywarsTriggerCoins = new ItemStack(Material.EMERALD, 1); {
		          ItemMeta MetaskywarsTriggerCoins = skywarsTriggerCoins.getItemMeta();
		          ArrayList<String> ListskywarsTriggerCoins = new ArrayList<String>();
		          MetaskywarsTriggerCoins.setDisplayName("§aCoins: §6" + coins);
		          MetaskywarsTriggerCoins.setLore(ListskywarsTriggerCoins);
		          skywarsTriggerCoins.setItemMeta(MetaskywarsTriggerCoins);
		      skywarsDeathMessages.setItem(49, skywarsTriggerCoins);
		      }
	          player.openInventory(skywarsDeathMessages);
	}

	public void buyShopWindowCages(Player player, UUID uuid, ItemStack clicked){
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
		else if (clicked.getType() == Material.EMERALD){}
		else if (clicked.getType() == Material.ARROW && clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cBack")){          
	        showShopWindowMain(player); 
	    }
		else if (clicked.getType() == Material.ARROW && clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cNext Page")){
	        showShopWindowCagesPage2(player); 
	    }
		else if(clicked.getType() == Material.GLASS && clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aGlass")){
			String currentCage = playerConfig.getString("player.common.cage");
			if(currentCage.equalsIgnoreCase("glass")){
				player.sendMessage(prefix + "§cYou already have this cage selected!");
			}
			else{
				playerConfig.set("player.common.cage", "glass");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowCages(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}			
		}
		else if(clicked.getType() == Material.SLIME_BLOCK && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cSlime Cage") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aSlime Cage"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentCage = playerConfig.getString("player.common.cage");
			boolean hasSlime = playerConfig.getBoolean("player.cages.slime");
			if(currentCage.equalsIgnoreCase("slime_block")){
				player.sendMessage(prefix + "§cYou already have this cage selected!");
			}
			else if(hasSlime == true){
				playerConfig.set("player.common.cage", "slime_block");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowCages(player);					
			}
			else if(coins>=100000){
				coins -= 100000;
				playerConfig.set("player.common.cage", "slime_block");
				playerConfig.set("player.cages.slime", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowCages(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}
		else if(clicked.getType() == Material.MOB_SPAWNER && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cSpawner Cage") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aSpawner Cage"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentCage = playerConfig.getString("player.common.cage");
			boolean hasSpawner = playerConfig.getBoolean("player.cages.spawner");
			if(currentCage.equalsIgnoreCase("mob_spawner")){
				player.sendMessage(prefix + "§cYou already have this cage selected!");
			}
			else if(hasSpawner == true){
				playerConfig.set("player.common.cage", "mob_spawner");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowCages(player);					
			}
			else if(coins>=100000){
				coins -= 100000;
				playerConfig.set("player.common.cage", "mob_spawner");
				playerConfig.set("player.cages.spawner", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowCages(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}
		else if(clicked.getType() == Material.BARRIER && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cInvisible Cage") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aInvisible Cage"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentCage = playerConfig.getString("player.common.cage");
			boolean hasBarrier = playerConfig.getBoolean("player.cages.barrier");
			if(currentCage.equalsIgnoreCase("barrier")){
				player.sendMessage(prefix + "§cYou already have this cage selected!");
			}
			else if(hasBarrier == true){
				playerConfig.set("player.common.cage", "barrier");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowCages(player);					
			}
			else if(coins>=500000){
				coins -= 500000;
				playerConfig.set("player.common.cage", "barrier");
				playerConfig.set("player.cages.barrier", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowCages(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}
		else if(clicked.getType() == Material.PACKED_ICE && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cIce Cage") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aIce Cage"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentCage = playerConfig.getString("player.common.cage");
			boolean hasIce = playerConfig.getBoolean("player.cages.ice");
			if(currentCage.equalsIgnoreCase("packed_ice")){
				player.sendMessage(prefix + "§cYou already have this cage selected!");
			}
			else if(hasIce == true){
				playerConfig.set("player.common.cage", "packed_ice");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowCages(player);					
			}
			else if(coins>=100000){
				coins -= 100000;
				playerConfig.set("player.common.cage", "packed_ice");
				playerConfig.set("player.cages.ice", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowCages(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}
		else if(clicked.getType() == Material.COAL_BLOCK && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cCoal Cage") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aCoal Cage"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentCage = playerConfig.getString("player.common.cage");
			boolean hasCoal = playerConfig.getBoolean("player.cages.coal");
			if(currentCage.equalsIgnoreCase("coal")){
				player.sendMessage(prefix + "§cYou already have this cage selected!");
			}
			else if(hasCoal == true){
				playerConfig.set("player.common.cage", "coal");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowCages(player);					
			}
			else if(coins>=30000){
				coins -= 30000;
				playerConfig.set("player.common.cage", "coal");
				playerConfig.set("player.cages.coal", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowCages(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}
		else if(clicked.getType() == Material.GOLD_BLOCK && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cGold Cage") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aGold Cage"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentCage = playerConfig.getString("player.common.cage");
			boolean hasgold = playerConfig.getBoolean("player.cages.gold");
			if(currentCage.equalsIgnoreCase("gold")){
				player.sendMessage(prefix + "§cYou already have this cage selected!");
			}
			else if(hasgold == true){
				playerConfig.set("player.common.cage", "gold");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowCages(player);					
			}
			else if(coins>=50000){
				coins -= 50000;
				playerConfig.set("player.common.cage", "gold");
				playerConfig.set("player.cages.gold", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowCages(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}
		else if(clicked.getType() == Material.IRON_BLOCK && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cIron Cage") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aIron Cage"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentCage = playerConfig.getString("player.common.cage");
			boolean hasiron = playerConfig.getBoolean("player.cages.iron");
			if(currentCage.equalsIgnoreCase("iron")){
				player.sendMessage(prefix + "§cYou already have this cage selected!");
			}
			else if(hasiron == true){
				playerConfig.set("player.common.cage", "iron");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowCages(player);					
			}
			else if(coins>=75000){
				coins -= 75000;
				playerConfig.set("player.common.cage", "iron");
				playerConfig.set("player.cages.iron", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowCages(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}
		else if(clicked.getType() == Material.DIAMOND_BLOCK && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cDiamond Cage") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aDiamond Cage"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentCage = playerConfig.getString("player.common.cage");
			boolean hasdiamond = playerConfig.getBoolean("player.cages.diamond");
			if(currentCage.equalsIgnoreCase("diamond")){
				player.sendMessage(prefix + "§cYou already have this cage selected!");
			}
			else if(hasdiamond == true){
				playerConfig.set("player.common.cage", "diamond");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowCages(player);					
			}
			else if(coins>=100000){
				coins -= 100000;
				playerConfig.set("player.common.cage", "diamond");
				playerConfig.set("player.cages.diamond", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowCages(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}
		else if(clicked.getType() == Material.EMERALD_BLOCK && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cEmerald Cage") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aEmerald Cage"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentCage = playerConfig.getString("player.common.cage");
			boolean hasemerald = playerConfig.getBoolean("player.cages.emerald");
			if(currentCage.equalsIgnoreCase("emerald")){
				player.sendMessage(prefix + "§cYou already have this cage selected!");
			}
			else if(hasemerald == true){
				playerConfig.set("player.common.cage", "emerald");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowCages(player);					
			}
			else if(coins>=150000){
				coins -= 150000;
				playerConfig.set("player.common.cage", "emerald");
				playerConfig.set("player.cages.emerald", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowCages(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}
		else if(clicked.getType() == Material.LOG && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cOak Cage") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aOak Cage"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentCage = playerConfig.getString("player.common.cage");
			boolean hasoak = playerConfig.getBoolean("player.cages.oak");
			if(currentCage.equalsIgnoreCase("oak")){
				player.sendMessage(prefix + "§cYou already have this cage selected!");
			}
			else if(hasoak == true){
				playerConfig.set("player.common.cage", "oak");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowCages(player);					
			}
			else if(coins>=80000){
				coins -= 80000;
				playerConfig.set("player.common.cage", "oak");
				playerConfig.set("player.cages.oak", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowCages(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}
		else if(clicked.getType() == Material.LOG && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cSpruce Cage") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aSpruce Cage"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentCage = playerConfig.getString("player.common.cage");
			boolean hasspruce = playerConfig.getBoolean("player.cages.spruce");
			if(currentCage.equalsIgnoreCase("spruce")){
				player.sendMessage(prefix + "§cYou already have this cage selected!");
			}
			else if(hasspruce == true){
				playerConfig.set("player.common.cage", "spruce");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowCages(player);					
			}
			else if(coins>=80000){
				coins -= 80000;
				playerConfig.set("player.common.cage", "spruce");
				playerConfig.set("player.cages.spruce", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowCages(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}
		else if(clicked.getType() == Material.LOG && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cBirch Cage") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aBirch Cage"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentCage = playerConfig.getString("player.common.cage");
			boolean hasbirch = playerConfig.getBoolean("player.cages.birch");
			if(currentCage.equalsIgnoreCase("birch")){
				player.sendMessage(prefix + "§cYou already have this cage selected!");
			}
			else if(hasbirch == true){
				playerConfig.set("player.common.cage", "birch");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowCages(player);					
			}
			else if(coins>=80000){
				coins -= 80000;
				playerConfig.set("player.common.cage", "birch");
				playerConfig.set("player.cages.birch", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowCages(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}
		else if(clicked.getType() == Material.LOG && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cJungle Cage") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aJungle Cage"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentCage = playerConfig.getString("player.common.cage");
			boolean hasjungle = playerConfig.getBoolean("player.cages.jungle");
			if(currentCage.equalsIgnoreCase("jungle")){
				player.sendMessage(prefix + "§cYou already have this cage selected!");
			}
			else if(hasjungle == true){
				playerConfig.set("player.common.cage", "jungle");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowCages(player);					
			}
			else if(coins>=80000){
				coins -= 80000;
				playerConfig.set("player.common.cage", "jungle");
				playerConfig.set("player.cages.jungle", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowCages(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}
		else if(clicked.getType() == Material.LOG_2 && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cAcacia Cage") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aAcacia Cage"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentCage = playerConfig.getString("player.common.cage");
			boolean hasacacia = playerConfig.getBoolean("player.cages.acacia");
			if(currentCage.equalsIgnoreCase("acacia")){
				player.sendMessage(prefix + "§cYou already have this cage selected!");
			}
			else if(hasacacia == true){
				playerConfig.set("player.common.cage", "acacia");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowCages(player);					
			}
			else if(coins>=80000){
				coins -= 80000;
				playerConfig.set("player.common.cage", "acacia");
				playerConfig.set("player.cages.acacia", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowCages(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}		
		else{
	    	player.closeInventory();
	    	player.sendMessage(prefix + ChatColor.RED + "Something went wrong! ErrorCode: F9-001");
	    }
		
		
	}
	
	public void showShopWindowCages(Player player){
		playerConfig = main.getPlayerConfig(player);
		boolean hasSlime = playerConfig.getBoolean("player.cages.slime");	
		boolean hasSpawner = playerConfig.getBoolean("player.cages.spawner");
		boolean hasBarrier = playerConfig.getBoolean("player.cages.barrier");
		boolean hasIce = playerConfig.getBoolean("player.cages.ice");
		boolean hasCoal = playerConfig.getBoolean("player.cages.coal");
		boolean hasGold = playerConfig.getBoolean("player.cages.gold");
		boolean hasIron = playerConfig.getBoolean("player.cages.iron");
		boolean hasDiamond = playerConfig.getBoolean("player.cages.diamond");
		boolean hasEmerald = playerConfig.getBoolean("player.cages.emerald");
		boolean hasOak = playerConfig.getBoolean("player.cages.oak");
		boolean hasSpruce = playerConfig.getBoolean("player.cages.spruce");
		boolean hasBirch = playerConfig.getBoolean("player.cages.birch");
		boolean hasJungle = playerConfig.getBoolean("player.cages.jungle");
		boolean hasAcacia = playerConfig.getBoolean("player.cages.acacia");
		String currentCage = playerConfig.getString("player.common.cage");
		int coins = playerConfig.getInt("player.common.coins");
		Inventory skywarsCages = Bukkit.createInventory(null, 54, "Skywars Cage Shop Page 1");
			ItemStack skywarsCageBack = new ItemStack(Material.ARROW, 1); {
		          ItemMeta MetaskywarsCageBack = skywarsCageBack.getItemMeta();
		          ArrayList<String> ListskywarsCageBack = new ArrayList<String>();
		          MetaskywarsCageBack.setDisplayName("§cBack");
		          MetaskywarsCageBack.setLore(ListskywarsCageBack);
		          skywarsCageBack.setItemMeta(MetaskywarsCageBack);
		      skywarsCages.setItem(45, skywarsCageBack);
			  }
			ItemStack skywarsCageNextPage = new ItemStack(Material.ARROW, 1); {
		          ItemMeta MetaskywarsCageNextPage = skywarsCageNextPage.getItemMeta();
		          ArrayList<String> ListskywarsCageNextPage = new ArrayList<String>();
		          MetaskywarsCageNextPage.setDisplayName("§cNext Page");
		          MetaskywarsCageNextPage.setLore(ListskywarsCageNextPage);
		          skywarsCageNextPage.setItemMeta(MetaskywarsCageNextPage);
		      skywarsCages.setItem(42, skywarsCageNextPage);
			  }
			ItemStack skywarsCageDefault = new ItemStack(Material.GLASS, 1); {
		          ItemMeta MetaskywarsCageDefault = skywarsCageDefault.getItemMeta();
		          ArrayList<String> ListSkywarsCageDefault = new ArrayList<String>();
		          MetaskywarsCageDefault.setDisplayName("§aGlass");
		          ListSkywarsCageDefault.add("");
		          if(currentCage.equalsIgnoreCase("glass")){
		        	  ListSkywarsCageDefault.add("§aCurrently selected!");
			          MetaskywarsCageDefault.setLore(ListSkywarsCageDefault);
			          skywarsCageDefault.setItemMeta(MetaskywarsCageDefault);
		        	  skywarsCageDefault.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		          }else{
			          MetaskywarsCageDefault.setLore(ListSkywarsCageDefault);
			          skywarsCageDefault.setItemMeta(MetaskywarsCageDefault);
		        	  ListSkywarsCageDefault.add("§aClick to select!");
		          }
		      skywarsCages.setItem(11, skywarsCageDefault);
		      }
			ItemStack skywarsCageSlime = new ItemStack(Material.SLIME_BLOCK, 1); {
		          ItemMeta MetaskywarsCageSlime = skywarsCageSlime.getItemMeta();
		          ArrayList<String> ListSkywarsCageSlime = new ArrayList<String>();
		          if(hasSlime == false){
		        	  MetaskywarsCageSlime.setDisplayName("§cSlime Cage");
		          }else{
		        	  MetaskywarsCageSlime.setDisplayName("§aSlime Cage");
		          }
		          ListSkywarsCageSlime.add("");
		          if(hasSlime == false){
		        	  ListSkywarsCageSlime.add("§7Cost:§6 100.000 Coins");
		          }
		          else if(currentCage.equalsIgnoreCase("slime_block")){
		        	  ListSkywarsCageSlime.add("§aCurrently selected!");
		        	  skywarsCageSlime.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		          }else{
		        	  ListSkywarsCageSlime.add("§aClick to select!");
		          }
		          MetaskywarsCageSlime.setLore(ListSkywarsCageSlime);
		          skywarsCageSlime.setItemMeta(MetaskywarsCageSlime);
		      skywarsCages.setItem(12, skywarsCageSlime);
		    }
			ItemStack skywarsCageSpawner = new ItemStack(Material.MOB_SPAWNER, 1); {
		          ItemMeta MetaskywarsCageSpawner = skywarsCageSpawner.getItemMeta();
		          ArrayList<String> ListSkywarsCageSpawner = new ArrayList<String>();
		          if(hasSpawner == false){
		        	  MetaskywarsCageSpawner.setDisplayName("§cSpawner Cage");
		          }else{
		        	  MetaskywarsCageSpawner.setDisplayName("§aSpawner Cage");
		          }
		          ListSkywarsCageSpawner.add("");
		          if(hasSpawner == false){
		        	  ListSkywarsCageSpawner.add("§7Cost:§6 100.000 Coins");
		          }
		          else if(currentCage.equalsIgnoreCase("mob_spawner")){
		        	  ListSkywarsCageSpawner.add("§aCurrently selected!");
		        	  skywarsCageSpawner.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		          }else{
		        	  ListSkywarsCageSpawner.add("§aClick to select!");
		          }
		          MetaskywarsCageSpawner.setLore(ListSkywarsCageSpawner);
		          skywarsCageSpawner.setItemMeta(MetaskywarsCageSpawner);
		      skywarsCages.setItem(13, skywarsCageSpawner);
		    }
			ItemStack skywarsCageBarrier = new ItemStack(Material.BARRIER, 1); {
		          ItemMeta MetaskywarsCageBarrier = skywarsCageBarrier.getItemMeta();
		          ArrayList<String> ListSkywarsCageBarrier = new ArrayList<String>();
		          if(hasBarrier == false){
		        	  MetaskywarsCageBarrier.setDisplayName("§cInvisible Cage");
		          }else{
		        	  MetaskywarsCageBarrier.setDisplayName("§aInvisible Cage");
		          }
		          ListSkywarsCageBarrier.add("");
		          if(hasBarrier == false){
		        	  ListSkywarsCageBarrier.add("§7Cost:§6 500.000 Coins");
		          }
		          else if(currentCage.equalsIgnoreCase("barrier")){
		        	  ListSkywarsCageBarrier.add("§aCurrently selected!");
		        	  skywarsCageBarrier.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		          }else{
		        	  ListSkywarsCageBarrier.add("§aClick to select!");
		          }
		          MetaskywarsCageBarrier.setLore(ListSkywarsCageBarrier);
		          skywarsCageBarrier.setItemMeta(MetaskywarsCageBarrier);
		      skywarsCages.setItem(14, skywarsCageBarrier);
		    }
			ItemStack skywarsCageIce = new ItemStack(Material.PACKED_ICE, 1); {
		          ItemMeta MetaskywarsCageIce = skywarsCageIce.getItemMeta();
		          ArrayList<String> ListSkywarsCageIce = new ArrayList<String>();
		          if(hasIce == false){
		        	  MetaskywarsCageIce.setDisplayName("§cIce Cage");
		          }else{
		        	  MetaskywarsCageIce.setDisplayName("§aIce Cage");
		          }
		          ListSkywarsCageIce.add("");
		          if(hasIce == false){
		        	  ListSkywarsCageIce.add("§7Cost:§6 100.000 Coins");
		          }
		          else if(currentCage.equalsIgnoreCase("packed_ice")){
		        	  ListSkywarsCageIce.add("§aCurrently selected!");
		        	  skywarsCageIce.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		          }else{
		        	  ListSkywarsCageIce.add("§aClick to select!");
		          }
		          MetaskywarsCageIce.setLore(ListSkywarsCageIce);
		          skywarsCageIce.setItemMeta(MetaskywarsCageIce);
		      skywarsCages.setItem(15, skywarsCageIce);
		    }
			ItemStack skywarsCageCoal = new ItemStack(Material.COAL_BLOCK, 1); {
		          ItemMeta MetaskywarsCageCoal = skywarsCageCoal.getItemMeta();
		          ArrayList<String> ListSkywarsCageCoal = new ArrayList<String>();
		          if(hasCoal == false){
		        	  MetaskywarsCageCoal.setDisplayName("§cCoal Cage");
		          }else{
		        	  MetaskywarsCageCoal.setDisplayName("§aCoal Cage");
		          }
		          ListSkywarsCageCoal.add("");
		          if(hasCoal == false){
		        	  ListSkywarsCageCoal.add("§7Cost:§6 30.000 Coins");
		          }
		          else if(currentCage.equalsIgnoreCase("coal")){
		        	  ListSkywarsCageCoal.add("§aCurrently selected!");
		        	  skywarsCageCoal.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		          }else{
		        	  ListSkywarsCageCoal.add("§aClick to select!");
		          }
		          MetaskywarsCageCoal.setLore(ListSkywarsCageCoal);
		          skywarsCageCoal.setItemMeta(MetaskywarsCageCoal);
		      skywarsCages.setItem(20, skywarsCageCoal);
		    }
			ItemStack skywarsCagegold = new ItemStack(Material.GOLD_BLOCK, 1); {
		          ItemMeta MetaskywarsCagegold = skywarsCagegold.getItemMeta();
		          ArrayList<String> ListSkywarsCagegold = new ArrayList<String>();
		          if(hasGold == false){
		        	  MetaskywarsCagegold.setDisplayName("§cGold Cage");
		          }else{
		        	  MetaskywarsCagegold.setDisplayName("§aGold Cage");
		          }
		          ListSkywarsCagegold.add("");
		          if(hasGold == false){
		        	  ListSkywarsCagegold.add("§7Cost:§6 50.000 Coins");
		          }
		          else if(currentCage.equalsIgnoreCase("gold")){
		        	  ListSkywarsCagegold.add("§aCurrently selected!");
		        	  skywarsCagegold.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		          }else{
		        	  ListSkywarsCagegold.add("§aClick to select!");
		          }
		          MetaskywarsCagegold.setLore(ListSkywarsCagegold);
		          skywarsCagegold.setItemMeta(MetaskywarsCagegold);
		      skywarsCages.setItem(21, skywarsCagegold);
		    }
			ItemStack skywarsCageiron = new ItemStack(Material.IRON_BLOCK, 1); {
		          ItemMeta MetaskywarsCageiron = skywarsCageiron.getItemMeta();
		          ArrayList<String> ListSkywarsCageiron = new ArrayList<String>();
		          if(hasIron == false){
		        	  MetaskywarsCageiron.setDisplayName("§cIron Cage");
		          }else{
		        	  MetaskywarsCageiron.setDisplayName("§aIron Cage");
		          }
		          ListSkywarsCageiron.add("");
		          if(hasIron == false){
		        	  ListSkywarsCageiron.add("§7Cost:§6 75.000 Coins");
		          }
		          else if(currentCage.equalsIgnoreCase("iron")){
		        	  ListSkywarsCageiron.add("§aCurrently selected!");
		        	  skywarsCageiron.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		          }else{
		        	  ListSkywarsCageiron.add("§aClick to select!");
		          }
		          MetaskywarsCageiron.setLore(ListSkywarsCageiron);
		          skywarsCageiron.setItemMeta(MetaskywarsCageiron);
		      skywarsCages.setItem(22, skywarsCageiron);
		    }
			ItemStack skywarsCagediamond = new ItemStack(Material.DIAMOND_BLOCK, 1); {
		          ItemMeta MetaskywarsCagediamond = skywarsCagediamond.getItemMeta();
		          ArrayList<String> ListSkywarsCagediamond = new ArrayList<String>();
		          if(hasDiamond == false){
		        	  MetaskywarsCagediamond.setDisplayName("§cDiamond Cage");
		          }else{
		        	  MetaskywarsCagediamond.setDisplayName("§aDiamond Cage");
		          }
		          ListSkywarsCagediamond.add("");
		          if(hasDiamond == false){
		        	  ListSkywarsCagediamond.add("§7Cost:§6 100.000 Coins");
		          }
		          else if(currentCage.equalsIgnoreCase("diamond")){
		        	  ListSkywarsCagediamond.add("§aCurrently selected!");
		        	  skywarsCagediamond.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		          }else{
		        	  ListSkywarsCagediamond.add("§aClick to select!");
		          }
		          MetaskywarsCagediamond.setLore(ListSkywarsCagediamond);
		          skywarsCagediamond.setItemMeta(MetaskywarsCagediamond);
		      skywarsCages.setItem(23, skywarsCagediamond);
		    }
			ItemStack skywarsCageemerald = new ItemStack(Material.EMERALD_BLOCK, 1); {
		          ItemMeta MetaskywarsCageemerald = skywarsCageemerald.getItemMeta();
		          ArrayList<String> ListSkywarsCageemerald = new ArrayList<String>();
		          if(hasEmerald == false){
		        	  MetaskywarsCageemerald.setDisplayName("§cEmerald Cage");
		          }else{
		        	  MetaskywarsCageemerald.setDisplayName("§aEmerald Cage");
		          }
		          ListSkywarsCageemerald.add("");
		          if(hasEmerald == false){
		        	  ListSkywarsCageemerald.add("§7Cost:§6 150.000 Coins");
		          }
		          else if(currentCage.equalsIgnoreCase("emerald")){
		        	  ListSkywarsCageemerald.add("§aCurrently selected!");
		        	  skywarsCageemerald.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		          }else{
		        	  ListSkywarsCageemerald.add("§aClick to select!");
		          }
		          MetaskywarsCageemerald.setLore(ListSkywarsCageemerald);
		          skywarsCageemerald.setItemMeta(MetaskywarsCageemerald);
		      skywarsCages.setItem(24, skywarsCageemerald);
		    }
			ItemStack skywarsCageoak = new ItemStack(Material.LOG, 1, (short) 0); {
		          ItemMeta MetaskywarsCageoak = skywarsCageoak.getItemMeta();
		          ArrayList<String> ListSkywarsCageoak = new ArrayList<String>();
		          if(hasOak == false){
		        	  MetaskywarsCageoak.setDisplayName("§cOak Cage");
		          }else{
		        	  MetaskywarsCageoak.setDisplayName("§aOak Cage");
		          }
		          ListSkywarsCageoak.add("");
		          if(hasOak == false){
		        	  ListSkywarsCageoak.add("§7Cost:§6 80.000 Coins");
		          }
		          else if(currentCage.equalsIgnoreCase("oak")){
		        	  ListSkywarsCageoak.add("§aCurrently selected!");
		        	  skywarsCageoak.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		          }else{
		        	  ListSkywarsCageoak.add("§aClick to select!");
		          }
		          MetaskywarsCageoak.setLore(ListSkywarsCageoak);
		          skywarsCageoak.setItemMeta(MetaskywarsCageoak);
		      skywarsCages.setItem(29, skywarsCageoak);
		    }
			ItemStack skywarsCagespruce = new ItemStack(Material.LOG, 1, (short) 1); {
		          ItemMeta MetaskywarsCagespruce = skywarsCagespruce.getItemMeta();
		          ArrayList<String> ListSkywarsCagespruce = new ArrayList<String>();
		          if(hasSpruce == false){
		        	  MetaskywarsCagespruce.setDisplayName("§cSpruce Cage");
		          }else{
		        	  MetaskywarsCagespruce.setDisplayName("§aSpruce Cage");
		          }
		          ListSkywarsCagespruce.add("");
		          if(hasSpruce == false){
		        	  ListSkywarsCagespruce.add("§7Cost:§6 80.000 Coins");
		          }
		          else if(currentCage.equalsIgnoreCase("spruce")){
		        	  ListSkywarsCagespruce.add("§aCurrently selected!");
		        	  skywarsCagespruce.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		          }else{
		        	  ListSkywarsCagespruce.add("§aClick to select!");
		          }
		          MetaskywarsCagespruce.setLore(ListSkywarsCagespruce);
		          skywarsCagespruce.setItemMeta(MetaskywarsCagespruce);
		      skywarsCages.setItem(30, skywarsCagespruce);
		    }
			ItemStack skywarsCagebirch = new ItemStack(Material.LOG, 1, (short) 2); {
		          ItemMeta MetaskywarsCagebirch = skywarsCagebirch.getItemMeta();
		          ArrayList<String> ListSkywarsCagebirch = new ArrayList<String>();
		          if(hasBirch == false){
		        	  MetaskywarsCagebirch.setDisplayName("§cBirch Cage");
		          }else{
		        	  MetaskywarsCagebirch.setDisplayName("§aBirch Cage");
		          }
		          ListSkywarsCagebirch.add("");
		          if(hasBirch == false){
		        	  ListSkywarsCagebirch.add("§7Cost:§6 80.000 Coins");
		          }
		          else if(currentCage.equalsIgnoreCase("birch")){
		        	  ListSkywarsCagebirch.add("§aCurrently selected!");
		        	  skywarsCagebirch.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		          }else{
		        	  ListSkywarsCagebirch.add("§aClick to select!");
		          }
		          MetaskywarsCagebirch.setLore(ListSkywarsCagebirch);
		          skywarsCagebirch.setItemMeta(MetaskywarsCagebirch);
		      skywarsCages.setItem(31, skywarsCagebirch);
		    }
			ItemStack skywarsCagejungle = new ItemStack(Material.LOG, 1, (short) 3); {
		          ItemMeta MetaskywarsCagejungle = skywarsCagejungle.getItemMeta();
		          ArrayList<String> ListSkywarsCagejungle = new ArrayList<String>();
		          if(hasJungle == false){
		        	  MetaskywarsCagejungle.setDisplayName("§cJungle Cage");
		          }else{
		        	  MetaskywarsCagejungle.setDisplayName("§aJungle Cage");
		          }
		          ListSkywarsCagejungle.add("");
		          if(hasJungle == false){
		        	  ListSkywarsCagejungle.add("§7Cost:§6 80.000 Coins");
		          }
		          else if(currentCage.equalsIgnoreCase("jungle")){
		        	  ListSkywarsCagejungle.add("§aCurrently selected!");
		        	  skywarsCagejungle.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		          }else{
		        	  ListSkywarsCagejungle.add("§aClick to select!");
		          }
		          MetaskywarsCagejungle.setLore(ListSkywarsCagejungle);
		          skywarsCagejungle.setItemMeta(MetaskywarsCagejungle);
		      skywarsCages.setItem(32, skywarsCagejungle);
		    }
			ItemStack skywarsCageacacia = new ItemStack(Material.LOG_2, 1, (short) 0); {
		          ItemMeta MetaskywarsCageacacia = skywarsCageacacia.getItemMeta();
		          ArrayList<String> ListSkywarsCageacacia = new ArrayList<String>();
		          if(hasAcacia == false){
		        	  MetaskywarsCageacacia.setDisplayName("§cAcacia Cage");
		          }else{
		        	  MetaskywarsCageacacia.setDisplayName("§aAcacia Cage");
		          }
		          ListSkywarsCageacacia.add("");
		          if(hasAcacia == false){
		        	  ListSkywarsCageacacia.add("§7Cost:§6 80.000 Coins");
		          }
		          else if(currentCage.equalsIgnoreCase("acacia")){
		        	  ListSkywarsCageacacia.add("§aCurrently selected!");
		        	  skywarsCageacacia.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		          }else{
		        	  ListSkywarsCageacacia.add("§aClick to select!");
		          }
		          MetaskywarsCageacacia.setLore(ListSkywarsCageacacia);
		          skywarsCageacacia.setItemMeta(MetaskywarsCageacacia);
		      skywarsCages.setItem(33, skywarsCageacacia);
		    }			
			ItemStack skywarsCageCoins = new ItemStack(Material.EMERALD, 1); {
		          ItemMeta MetaskywarsCageCoins = skywarsCageCoins.getItemMeta();
		          ArrayList<String> ListskywarsCageCoins = new ArrayList<String>();
		          MetaskywarsCageCoins.setDisplayName("§aCoins: §6" + coins);
		          MetaskywarsCageCoins.setLore(ListskywarsCageCoins);
		          skywarsCageCoins.setItemMeta(MetaskywarsCageCoins);
		      skywarsCages.setItem(49, skywarsCageCoins);
		      }
	          player.openInventory(skywarsCages);
	}
	
	public void buyShopWindowCagesPage2(Player player, UUID uuid, ItemStack clicked){
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
		else if (clicked.getType() == Material.EMERALD){}
		else if (clicked.getType() == Material.ARROW && clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cBack")){          
	        showShopWindowMain(player); 
	    }
		else if (clicked.getType() == Material.ARROW && clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cPrevious Page")){          
	        showShopWindowCages(player); 
	    }
		else if(clicked.getType() == Material.LOG_2 && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cDarkOak Cage") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aDarkOak Cage"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentCage = playerConfig.getString("player.common.cage");
			boolean hasdarkoak = playerConfig.getBoolean("player.cages.darkoak");
			if(currentCage.equalsIgnoreCase("darkoak")){
				player.sendMessage(prefix + "§cYou already have this cage selected!");
			}
			else if(hasdarkoak == true){
				playerConfig.set("player.common.cage", "darkoak");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowCagesPage2(player);					
			}
			else if(coins>=80000){
				coins -= 80000;
				playerConfig.set("player.common.cage", "darkoak");
				playerConfig.set("player.cages.darkoak", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowCagesPage2(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}
		else if(clicked.getType() == Material.NETHER_BRICK && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cNetherbrick Cage") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aNetherbrick Cage"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentCage = playerConfig.getString("player.common.cage");
			boolean hasNetherbrick = playerConfig.getBoolean("player.cages.nether");
			if(currentCage.equalsIgnoreCase("nether")){
				player.sendMessage(prefix + "§cYou already have this cage selected!");
			}
			else if(hasNetherbrick == true){
				playerConfig.set("player.common.cage", "nether");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowCagesPage2(player);					
			}
			else if(coins>=100000){
				coins -= 100000;
				playerConfig.set("player.common.cage", "nether");
				playerConfig.set("player.cages.nether", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowCagesPage2(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}
		else if(clicked.getType() == Material.IRON_FENCE && (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cPrison Cage") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aPrison Cage"))){
			int coins = playerConfig.getInt("player.common.coins");
			String currentCage = playerConfig.getString("player.common.cage");
			boolean hasPrison = playerConfig.getBoolean("player.cages.prison");
			if(currentCage.equalsIgnoreCase("prison")){
				player.sendMessage(prefix + "§cYou already have this cage selected!");
			}
			else if(hasPrison == true){
				playerConfig.set("player.common.cage", "prison");
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);	
				showShopWindowCagesPage2(player);					
			}
			else if(coins>=250000){
				coins -= 250000;
				playerConfig.set("player.common.cage", "prison");
				playerConfig.set("player.cages.prison", true);
				playerConfig.set("player.common.coins", coins);
				main.playerConfig = playerConfig;
				main.savePlayerConfig(player);
				showShopWindowCagesPage2(player);
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 2.3F);		
			}
			else{
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 2.0F, 0.5F);					
				player.sendMessage(prefix + "§cyou don't have enough coins to buy that!");
			}
		}
		else{
	    	player.closeInventory();
	    	player.sendMessage(prefix + ChatColor.RED + "Something went wrong! ErrorCode: F11-001");
	    }
	}
	
	public void showShopWindowCagesPage2(Player player){
		playerConfig = main.getPlayerConfig(player);		
		boolean hasDarkoak = playerConfig.getBoolean("player.cages.darkoak");
		boolean hasNetherbrick = playerConfig.getBoolean("player.cages.nether");
		boolean hasPrison = playerConfig.getBoolean("player.cages.prison");
		String currentCage = playerConfig.getString("player.common.cage");
		int coins = playerConfig.getInt("player.common.coins");
		Inventory skywarsCagesPage2 = Bukkit.createInventory(null, 54, "Skywars Cage Shop Page 2");
			ItemStack skywarsCageBack = new ItemStack(Material.ARROW, 1); {
		          ItemMeta MetaskywarsCageBack = skywarsCageBack.getItemMeta();
		          ArrayList<String> ListskywarsCageBack = new ArrayList<String>();
		          MetaskywarsCageBack.setDisplayName("§cBack");
		          MetaskywarsCageBack.setLore(ListskywarsCageBack);
		          skywarsCageBack.setItemMeta(MetaskywarsCageBack);
		      skywarsCagesPage2.setItem(45, skywarsCageBack);
			  }
			ItemStack skywarsCagePreviousPage = new ItemStack(Material.ARROW, 1); {
		          ItemMeta MetaskywarsCagePreviousPage = skywarsCagePreviousPage.getItemMeta();
		          ArrayList<String> ListskywarsCagePreviousPage = new ArrayList<String>();
		          MetaskywarsCagePreviousPage.setDisplayName("§cPrevious Page");
		          MetaskywarsCagePreviousPage.setLore(ListskywarsCagePreviousPage);
		          skywarsCagePreviousPage.setItemMeta(MetaskywarsCagePreviousPage);
		      skywarsCagesPage2.setItem(38, skywarsCagePreviousPage);
			  }
			ItemStack skywarsCagedarkoak = new ItemStack(Material.LOG_2, 1, (short) 1); {
		          ItemMeta MetaskywarsCagedarkoak = skywarsCagedarkoak.getItemMeta();
		          ArrayList<String> ListSkywarsCagedarkoak = new ArrayList<String>();
		          if(hasDarkoak == false){
		        	  MetaskywarsCagedarkoak.setDisplayName("§cDarkoak Cage");
		          }else{
		        	  MetaskywarsCagedarkoak.setDisplayName("§aDarkoak Cage");
		          }
		          ListSkywarsCagedarkoak.add("");
		          if(hasDarkoak == false){
		        	  ListSkywarsCagedarkoak.add("§7Cost:§6 80.000 Coins");
		          }
		          else if(currentCage.equalsIgnoreCase("darkoak")){
		        	  ListSkywarsCagedarkoak.add("§aCurrently selected!");
		        	  skywarsCagedarkoak.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		          }else{
		        	  ListSkywarsCagedarkoak.add("§aClick to select!");
		          }
		          MetaskywarsCagedarkoak.setLore(ListSkywarsCagedarkoak);
		          skywarsCagedarkoak.setItemMeta(MetaskywarsCagedarkoak);
		      skywarsCagesPage2.setItem(11, skywarsCagedarkoak);
		    }
			ItemStack skywarsCagenetherbrick = new ItemStack(Material.NETHER_BRICK, 1); {
		          ItemMeta MetaskywarsCagenetherbrick = skywarsCagenetherbrick.getItemMeta();
		          ArrayList<String> ListSkywarsCagenetherbrick = new ArrayList<String>();
		          if(hasNetherbrick == false){
		        	  MetaskywarsCagenetherbrick.setDisplayName("§cNetherbrick Cage");
		          }else{
		        	  MetaskywarsCagenetherbrick.setDisplayName("§aNetherbrick Cage");
		          }
		          ListSkywarsCagenetherbrick.add("");
		          if(hasNetherbrick == false){
		        	  ListSkywarsCagenetherbrick.add("§7Cost:§6 100.000 Coins");
		          }
		          else if(currentCage.equalsIgnoreCase("nether")){
		        	  ListSkywarsCagenetherbrick.add("§aCurrently selected!");
		        	  skywarsCagenetherbrick.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		          }else{
		        	  ListSkywarsCagenetherbrick.add("§aClick to select!");
		          }
		          MetaskywarsCagenetherbrick.setLore(ListSkywarsCagenetherbrick);
		          skywarsCagenetherbrick.setItemMeta(MetaskywarsCagenetherbrick);
		      skywarsCagesPage2.setItem(12, skywarsCagenetherbrick);
		    }
			ItemStack skywarsCageprison = new ItemStack(Material.IRON_FENCE, 1); {
		          ItemMeta MetaskywarsCageprison = skywarsCageprison.getItemMeta();
		          ArrayList<String> ListSkywarsCageprison = new ArrayList<String>();
		          if(hasPrison == false){
		        	  MetaskywarsCageprison.setDisplayName("§cPrison Cage");
		          }else{
		        	  MetaskywarsCageprison.setDisplayName("§aPrison Cage");
		          }
		          ListSkywarsCageprison.add("");
		          if(hasPrison == false){
		        	  ListSkywarsCageprison.add("§7Cost:§6 250.000 Coins");
		          }
		          else if(currentCage.equalsIgnoreCase("prison")){
		        	  ListSkywarsCageprison.add("§aCurrently selected!");
		        	  skywarsCageprison.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		          }else{
		        	  ListSkywarsCageprison.add("§aClick to select!");
		          }
		          MetaskywarsCageprison.setLore(ListSkywarsCageprison);
		          skywarsCageprison.setItemMeta(MetaskywarsCageprison);
		      skywarsCagesPage2.setItem(13, skywarsCageprison);
		    }
			ItemStack skywarsCageCoins = new ItemStack(Material.EMERALD, 1); {
		          ItemMeta MetaskywarsCageCoins = skywarsCageCoins.getItemMeta();
		          ArrayList<String> ListskywarsCageCoins = new ArrayList<String>();
		          MetaskywarsCageCoins.setDisplayName("§aCoins: §6" + coins);
		          MetaskywarsCageCoins.setLore(ListskywarsCageCoins);
		          skywarsCageCoins.setItemMeta(MetaskywarsCageCoins);
		      skywarsCagesPage2.setItem(49, skywarsCageCoins);
		      }
			player.openInventory(skywarsCagesPage2);
	}

	public void buyShopWindowStats(Player player, UUID uuid, ItemStack clicked){
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
		else if (clicked.getType() == Material.EMERALD){}
		else if (clicked.getType() == Material.ARROW && clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cBack")){          
	        showShopWindowMain(player); 
	    }
		else if (clicked.getType() == Material.WOOD_SWORD){}
		else if (clicked.getType() == Material.BONE){}
		else if (clicked.getType() == Material.MINECART){}
		else if (clicked.getType() == Material.EXPLOSIVE_MINECART){}
		else if (clicked.getType() == Material.STORAGE_MINECART){}
		else if (clicked.getType() == Material.WOOD_AXE){}
		else if (clicked.getType() == Material.DIAMOND){
			achShop.showShopWindowAchievements(player);
		}
		else if (clicked.getType() == Material.GLASS){}
		else{
			player.closeInventory();
			player.sendMessage(prefix + ChatColor.RED + "Something went wrong! ErrorCode: F13-001");
		}
	}
	
	public void showShopWindowStats(Player player){
		playerConfig = main.getPlayerConfig(player);
		int coins = playerConfig.getInt("player.common.coins");
		int kills = playerConfig.getInt("player.common.kills");
		int deaths = playerConfig.getInt("player.common.deaths");
		int plays = playerConfig.getInt("player.common.plays");
		int losses = playerConfig.getInt("player.common.losses");
		int wins = playerConfig.getInt("player.common.wins");
		int achievementPoints = playerConfig.getInt("player.common.achievementpoints");
		String currentKit = playerConfig.getString("player.common.kit");
		String currentCage = playerConfig.getString("player.common.cage");
		Inventory skywarsStats = Bukkit.createInventory(null, 54, "Skywars Stats");
			ItemStack skywarsCageBack = new ItemStack(Material.ARROW, 1); {
		          ItemMeta MetaskywarsCageBack = skywarsCageBack.getItemMeta();
		          ArrayList<String> ListskywarsCageBack = new ArrayList<String>();
		          MetaskywarsCageBack.setDisplayName("§cBack");
		          MetaskywarsCageBack.setLore(ListskywarsCageBack);
		          skywarsCageBack.setItemMeta(MetaskywarsCageBack);
		      skywarsStats.setItem(45, skywarsCageBack);
			  }
			ItemStack skywarsTriggerCoins = new ItemStack(Material.EMERALD, 1); {
		          ItemMeta MetaskywarsTriggerCoins = skywarsTriggerCoins.getItemMeta();
		          ArrayList<String> ListskywarsTriggerCoins = new ArrayList<String>();
		          MetaskywarsTriggerCoins.setDisplayName("§aCoins: §6" + coins);
		          MetaskywarsTriggerCoins.setLore(ListskywarsTriggerCoins);
		          skywarsTriggerCoins.setItemMeta(MetaskywarsTriggerCoins);
		      skywarsStats.setItem(49, skywarsTriggerCoins);
		      }
			ItemStack skywarsStatKills = new ItemStack(Material.WOOD_SWORD, 1); {
		          ItemMeta MetaskywarsStatKills = skywarsStatKills.getItemMeta();
		          ArrayList<String> ListskywarsStatKills = new ArrayList<String>();
		          MetaskywarsStatKills.setDisplayName("§aKills: §6" + kills);
		          MetaskywarsStatKills.setLore(ListskywarsStatKills);
		          skywarsStatKills.setItemMeta(MetaskywarsStatKills);
		      skywarsStats.setItem(11, skywarsStatKills);
		      }
			ItemStack skywarsStatDeaths = new ItemStack(Material.BONE, 1); {
		          ItemMeta MetaskywarsStatDeaths = skywarsStatDeaths.getItemMeta();
		          ArrayList<String> ListskywarsStatDeaths = new ArrayList<String>();
		          MetaskywarsStatDeaths.setDisplayName("§aDeaths: §6" + deaths);
		          MetaskywarsStatDeaths.setLore(ListskywarsStatDeaths);
		          skywarsStatDeaths.setItemMeta(MetaskywarsStatDeaths);
		      skywarsStats.setItem(12, skywarsStatDeaths);
		      }
			ItemStack skywarsStatPlays = new ItemStack(Material.MINECART, 1); {
		          ItemMeta MetaskywarsStatPlays = skywarsStatPlays.getItemMeta();
		          ArrayList<String> ListskywarsStatPlays = new ArrayList<String>();
		          MetaskywarsStatPlays.setDisplayName("§aTotal games played: §6" + plays);
		          MetaskywarsStatPlays.setLore(ListskywarsStatPlays);
		          skywarsStatPlays.setItemMeta(MetaskywarsStatPlays);
		      skywarsStats.setItem(13, skywarsStatPlays);
		      }
			ItemStack skywarsStatLosses = new ItemStack(Material.EXPLOSIVE_MINECART, 1); {
		          ItemMeta MetaskywarsStatLosses = skywarsStatLosses.getItemMeta();
		          ArrayList<String> ListskywarsStatLosses = new ArrayList<String>();
		          MetaskywarsStatLosses.setDisplayName("§aGames lost: §6" + losses);
		          MetaskywarsStatLosses.setLore(ListskywarsStatLosses);
		          skywarsStatLosses.setItemMeta(MetaskywarsStatLosses);
		      skywarsStats.setItem(14, skywarsStatLosses);
		      }
			ItemStack skywarsStatWins = new ItemStack(Material.STORAGE_MINECART, 1); {
		          ItemMeta MetaskywarsStatWins = skywarsStatWins.getItemMeta();
		          ArrayList<String> ListskywarsStatWins = new ArrayList<String>();
		          MetaskywarsStatWins.setDisplayName("§aGames won: §6" + wins);
		          MetaskywarsStatWins.setLore(ListskywarsStatWins);
		          skywarsStatWins.setItemMeta(MetaskywarsStatWins);
		      skywarsStats.setItem(15, skywarsStatWins);
		      }
			ItemStack skywarsStatKit = new ItemStack(Material.WOOD_AXE, 1); {
		          ItemMeta MetaskywarsStatKit = skywarsStatKit.getItemMeta();
		          ArrayList<String> ListskywarsStatKit = new ArrayList<String>();
		          MetaskywarsStatKit.setDisplayName("§aCurrent Kit: §6" + currentKit);
		          MetaskywarsStatKit.setLore(ListskywarsStatKit);
		          skywarsStatKit.setItemMeta(MetaskywarsStatKit);
		      skywarsStats.setItem(29, skywarsStatKit);
		      }
			ItemStack skywarsStatAchievements = new ItemStack(Material.DIAMOND, 1); {
		          ItemMeta MetaskywarsStatAchievements = skywarsStatAchievements.getItemMeta();
		          ArrayList<String> ListskywarsStatAchievements = new ArrayList<String>();
		          MetaskywarsStatAchievements.setDisplayName("§aAchievement points: §6" + achievementPoints);
		          ListskywarsStatAchievements.add(" ");
		          ListskywarsStatAchievements.add(ChatColor.YELLOW + "Click to see achievements!");
		          MetaskywarsStatAchievements.setLore(ListskywarsStatAchievements);
		          skywarsStatAchievements.setItemMeta(MetaskywarsStatAchievements);
		      skywarsStats.setItem(31, skywarsStatAchievements);
		      }
			ItemStack skywarsStatCage = new ItemStack(Material.GLASS, 1); {
		          ItemMeta MetaskywarsStatCage = skywarsStatCage.getItemMeta();
		          ArrayList<String> ListskywarsStatCage = new ArrayList<String>();
		          MetaskywarsStatCage.setDisplayName("§aCurrent Cage: §6" + currentCage);
		          MetaskywarsStatCage.setLore(ListskywarsStatCage);
		          skywarsStatCage.setItemMeta(MetaskywarsStatCage);
		      skywarsStats.setItem(33, skywarsStatCage);
		      }
			player.openInventory(skywarsStats);
	}

	}