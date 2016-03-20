package com.sky.isles;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.craftbukkit.v1_8_R3.block.CraftChest;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.minecraft.server.v1_8_R3.TileEntityChest;


public class Chests {
	@SuppressWarnings("unused")
	private Main main;
	public Chests(Main main){
	this.main = main;
	}
	
	
	public void fillChestLegendary(int x, int y, int z){
		Location chestLoc = new Location(Bukkit.getWorld("world"), x, y, z);
		Chest chest = (Chest) chestLoc.getBlock().getState();
		Random rand = new Random();
		int emptySlots = 0;
		CraftChest BukkitChest = (CraftChest) chest;
		  // Get the Vanilla net.minecraft.server Chest out of it
		  TileEntityChest NMSChest = BukkitChest.getTileEntity();
		  // Now use the method "a" to set the Title
		  NMSChest.a("§6Legendary!");
		for(ItemStack stack: chest.getBlockInventory().getContents()){
			if(stack == null){
				emptySlots++;
			}
		}
			int template = rand.nextInt((15-1)+1)+1;
			switch(template){
			case 0:
			case 1:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.DIAMOND_SWORD, 1);
						stack.addEnchantment(Enchantment.DAMAGE_ALL, 3);
						ItemMeta Name = stack.getItemMeta();
				          Name.setDisplayName("§6Buster");
				          stack.setItemMeta(Name);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				break;			
			case 2:				
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.FEATHER, 1);
						stack.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
						ItemMeta Name = stack.getItemMeta();
				          Name.setDisplayName("§6Fly Guide");
				          stack.setItemMeta(Name);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				break;
			case 3:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.RAW_FISH, 1);
						stack.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
						stack.setDurability((short) 3);
						 ItemMeta Name = stack.getItemMeta();
				          Name.setDisplayName("§6Blub");
				          stack.setItemMeta(Name);
						chest.getBlockInventory().setItem(spot, stack);
						emptySlots--;
						break;
					}
				}
				break;
			case 4:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.DIAMOND_HELMET, 1);
						stack.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
						stack.addEnchantment(Enchantment.THORNS, 1);
						ItemMeta Name = stack.getItemMeta();
				          Name.setDisplayName("§6AX100 Helmet");
				          stack.setItemMeta(Name);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				break;
			case 5:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
						stack.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS,3);
						stack.addEnchantment(Enchantment.PROTECTION_FIRE, 3);
						ItemMeta Name = stack.getItemMeta();
				          Name.setDisplayName("§6AX100 Chestplate");
				          stack.setItemMeta(Name);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				break;
			case 6:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
						stack.addEnchantment(Enchantment.PROTECTION_FIRE, 2);
						stack.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
						ItemMeta Name = stack.getItemMeta();
				          Name.setDisplayName("§6AX100 Leggings");
				          stack.setItemMeta(Name);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				break;
			case 7:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.DIAMOND_BOOTS, 1);
						stack.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
						stack.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 5);
						ItemMeta Name = stack.getItemMeta();
				          Name.setDisplayName("§6AX100 Boots");
				          stack.setItemMeta(Name);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				break;
			case 8:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.DIAMOND_SWORD, 1);
						stack.addEnchantment(Enchantment.DAMAGE_ALL, 5);
						ItemMeta Name = stack.getItemMeta();
				          Name.setDisplayName("§6The Upgrade");
				          stack.setItemMeta(Name);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				break;
			case 9:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.ENCHANTMENT_TABLE, 1);
						ItemMeta Name = stack.getItemMeta();
				          Name.setDisplayName("§6Enchanting Time!");
				          stack.setItemMeta(Name);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						int number = rand.nextInt((64-32)+32)+32;
						ItemStack stack = new ItemStack(Material.EXP_BOTTLE, number);
						ItemMeta Name = stack.getItemMeta();
				          Name.setDisplayName("§6Enchanting Time!");
				          stack.setItemMeta(Name);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						int number = rand.nextInt((64-32)+32)+32;
						ItemStack stack = new ItemStack(Material.INK_SACK, number, (short) 4);
						ItemMeta Name = stack.getItemMeta();
				          Name.setDisplayName("§6Enchanting Time!");
				          stack.setItemMeta(Name);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				break;
			case 10:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.CAKE, 1);
						ItemMeta Name = stack.getItemMeta();
				          Name.setDisplayName("§6Celebration Time!");
				          stack.setItemMeta(Name);
						stack.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 6);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				break;
			case 11:
					for(int i=0;i<27;i++){
					if(chest.getBlockInventory().getItem(i)==null){
						ItemStack stack = new ItemStack(Material.COOKIE, 64);
						ItemMeta Name = stack.getItemMeta();
				        Name.setDisplayName("§6COOKIES");
				        stack.setItemMeta(Name);
						chest.getBlockInventory().setItem(i, stack);						
					}
					}
				break;
			case 12:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.DIAMOND_SWORD, 1);
						stack.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD, 10);
						ItemMeta Name = stack.getItemMeta();
				        Name.setDisplayName("§6Zombie Slasher");
				        stack.setItemMeta(Name);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				break;
			case 13:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.GOLDEN_APPLE, 1);
						stack.setDurability((short) 1);
						ItemMeta Name = stack.getItemMeta();
				        Name.setDisplayName("§6NomNom Food");
				        stack.setItemMeta(Name);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				break;
			case 14:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.TNT, 64);
						ItemMeta Name = stack.getItemMeta();
				        Name.setDisplayName("§6Boombox");
				        stack.setItemMeta(Name);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.FLINT_AND_STEEL, 1);
						ItemMeta Name = stack.getItemMeta();
				          Name.setDisplayName("§6Boombox on-switch");
				          stack.setItemMeta(Name);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				break;
			case 15:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.DIAMOND, 32);
						ItemMeta Name = stack.getItemMeta();
				        Name.setDisplayName("§6DIY-kit");
				        stack.setItemMeta(Name);
						chest.getBlockInventory().setItem(spot, stack);
						emptySlots--;
						break;
					}
				}
			}
		
	}
	
	public void fillChestEpic(int x, int y, int z){
		Location chestLoc = new Location(Bukkit.getWorld("world"), x, y, z);
		Chest chest = (Chest) chestLoc.getBlock().getState();
		Random rand = new Random();
		int emptySlots = 0;
		CraftChest BukkitChest = (CraftChest) chest;
		  // Get the Vanilla net.minecraft.server Chest out of it
		  TileEntityChest NMSChest = BukkitChest.getTileEntity();
		  // Now use the method "a" to set the Title
		  NMSChest.a("§5Epic");
		for(ItemStack stack: chest.getBlockInventory().getContents()){
			if(stack == null){
				emptySlots++;
			}
		}
		for(int i=0; i<2; i++){
			int template = rand.nextInt((15-1)+1)+1;
			switch(template){
			case 0:
			case 1:
				while(emptySlots>0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.DIAMOND_PICKAXE, 1);
						chest.getBlockInventory().setItem(spot, stack);
						emptySlots--;
						break;
					}
				}
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.DIAMOND_AXE, 1);
						chest.getBlockInventory().setItem(spot, stack);
						emptySlots--;
						break;
					}
				}
				break;			
			case 2:				
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.DIAMOND_SWORD, 1);
						chest.getBlockInventory().setItem(spot, stack);
						emptySlots--;
						break;
					}
				}
				break;
			case 3:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						int number = rand.nextInt(64-32)+64;
						ItemStack stack = new ItemStack(Material.WOOD, number);
						chest.getBlockInventory().setItem(spot, stack);
						emptySlots--;
						break;
					}
				}
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.DIAMOND, 3);
						chest.getBlockInventory().setItem(spot, stack);
						emptySlots--;
						break;
					}
				}
				break;
			case 4:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.DIAMOND_BOOTS, 1);
						chest.getBlockInventory().setItem(spot, stack);
						emptySlots--;
						break;
					}
				}
				break;
			case 5:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.DIAMOND_HELMET, 1);
						stack.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 3);
						chest.getBlockInventory().setItem(spot, stack);
						emptySlots--;
						break;
					}
				}
				break;
			case 6:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						int number = rand.nextInt(64-32)+64;
						ItemStack stack = new ItemStack(Material.ARROW, number);
						chest.getBlockInventory().setItem(spot, stack);
						emptySlots--;
						break;
					}
				}
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.BOW, 1);
						stack.addEnchantment(Enchantment.ARROW_FIRE, 1);
						stack.addEnchantment(Enchantment.ARROW_DAMAGE, 3);
						chest.getBlockInventory().setItem(spot, stack);
						emptySlots--;
						break;
					}
				}
				break;
			case 7:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.IRON_BOOTS, 1);
						stack.addEnchantment(Enchantment.PROTECTION_FALL, 3);
						chest.getBlockInventory().setItem(spot, stack);
						emptySlots--;
						break;
					}
				}
				break;
			case 8:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.GOLDEN_APPLE, 3);
						chest.getBlockInventory().setItem(spot, stack);
						emptySlots--;
						break;
					}
				}
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						int number = rand.nextInt(64-32)+64;
						ItemStack stack = new ItemStack(Material.WOOD, number);
						chest.getBlockInventory().setItem(spot, stack);
						emptySlots--;
						break;
					}
				}
				break;
			case 9:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						int number = rand.nextInt(64-32)+64;
						ItemStack stack = new ItemStack(Material.WOOD, number);
						chest.getBlockInventory().setItem(spot, stack);
						emptySlots--;
						break;
					}
				}
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						int number = rand.nextInt(64-32)+64;
						ItemStack stack = new ItemStack(Material.WOOD, number);
						chest.getBlockInventory().setItem(spot, stack);
						emptySlots--;
						break;
					}
				}
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						int number = rand.nextInt(64-32)+64;
						ItemStack stack = new ItemStack(Material.STONE, number);
						chest.getBlockInventory().setItem(spot, stack);
						emptySlots--;
						break;
					}
				}
				break;
			case 10:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						int number = rand.nextInt(64-32)+64;
						ItemStack stack = new ItemStack(Material.EGG, number);
						chest.getBlockInventory().setItem(spot, stack);
						emptySlots--;
						break;
					}
				}
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						int number = rand.nextInt(64-32)+64;
						ItemStack stack = new ItemStack(Material.EGG, number);
						chest.getBlockInventory().setItem(spot, stack);
						emptySlots--;
						break;
					}
				}
				break;
			case 11:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.IRON_SWORD, 1);
						stack.addEnchantment(Enchantment.DAMAGE_ALL, 3);
						chest.getBlockInventory().setItem(spot, stack);
						emptySlots--;
						break;
					}
				}
				break;
			case 12:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.GOLD_SWORD, 1);
						ItemMeta Name = stack.getItemMeta();
				        Name.setDisplayName("§6Thor's Hammer");
						stack.setDurability((short) 30);
						stack.addUnsafeEnchantment(Enchantment.KNOCKBACK, 10);
						chest.getBlockInventory().setItem(spot, stack);
						emptySlots--;
						break;
					}
				}
				break;
			case 13:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.IRON_SWORD, 1);
						stack.addEnchantment(Enchantment.DAMAGE_ALL, 3);
						chest.getBlockInventory().setItem(spot, stack);
						emptySlots--;
						break;
					}
				}
				break;
			case 14:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						int number = rand.nextInt(16-10)+20;
						ItemStack stack = new ItemStack(Material.COOKED_BEEF, number);
						chest.getBlockInventory().setItem(spot, stack);
						emptySlots--;
						break;
					}
				}
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						int number = rand.nextInt(64-32)+64;
						ItemStack stack = new ItemStack(Material.STONE, number);
						chest.getBlockInventory().setItem(spot, stack);
						emptySlots--;
						break;
					}
				}
				break;
			case 15:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.DIAMOND_SWORD, 1);
						stack.addEnchantment(Enchantment.DAMAGE_ALL, 1);
						chest.getBlockInventory().setItem(spot, stack);
						emptySlots--;
						break;
					}
				}
			}
		}

	}

	public void fillChestRare(int x, int y, int z){
		Location chestLoc = new Location(Bukkit.getWorld("world"), x, y, z);
		Chest chest = (Chest) chestLoc.getBlock().getState();		
		Random rand = new Random();
		int emptySlots = 0;
		CraftChest BukkitChest = (CraftChest) chest;
		  // Get the Vanilla net.minecraft.server Chest out of it
		  TileEntityChest NMSChest = BukkitChest.getTileEntity();
		  // Now use the method "a" to set the Title
		  NMSChest.a("§9Rare");
		for(ItemStack stack: chest.getBlockInventory().getContents()){
			if(stack == null){
				emptySlots++;
			}
		}
		for(int i=0; i<2; i++){
			int template = rand.nextInt((15-1)+1)+1;
			switch(template){
			case 0:
			case 1:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.IRON_PICKAXE, 1);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.STONE_SPADE, 1);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				break;			
			case 2:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.IRON_SWORD, 1);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						int number = rand.nextInt((12-6)+6)+6;
						ItemStack stack = new ItemStack(Material.COOKED_BEEF, number);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				break;
			case 3:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.WOOD_SWORD, 1);
						stack.addEnchantment(Enchantment.KNOCKBACK, 1);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				break;
			case 4:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.IRON_SWORD, 1);
						stack.addEnchantment(Enchantment.DAMAGE_ALL, 1);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				break;
			case 5:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.IRON_SWORD, 1);
						stack.addEnchantment(Enchantment.DAMAGE_ALL, 1);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				break;
			case 6:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.GOLDEN_APPLE, 2);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.IRON_LEGGINGS, 1);
						stack.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				break;
			case 7:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.IRON_BOOTS, 1);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
						stack.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				break;
			case 8:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						int number = rand.nextInt(16-8)+8+8;
						ItemStack stack = new ItemStack(Material.EGG, number);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						int number = rand.nextInt(16-8)+8+8;
						ItemStack stack = new ItemStack(Material.EGG, number);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				break;
			case 9:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						int number = rand.nextInt(14-1)+1+1;
						ItemStack stack = new ItemStack(Material.COOKED_BEEF, number);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						int number = rand.nextInt(32-16)+16+16;
						ItemStack stack = new ItemStack(Material.WOOD, number);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				break;
			case 10:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						int number = rand.nextInt(16-8)+8+8;
						ItemStack stack = new ItemStack(Material.WOOD, number);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						int number = rand.nextInt(16-8)+8+8;
						ItemStack stack = new ItemStack(Material.WOOD, number);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				break;
			case 11:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.IRON_HELMET, 1);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.IRON_BOOTS, 1);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				break;
			case 12:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.IRON_SWORD, 1);
						stack.addEnchantment(Enchantment.DAMAGE_ALL, 1);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				break;
			case 13:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						int number = rand.nextInt(40-24)+24+24;
						ItemStack stack = new ItemStack(Material.WOOD, number);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						int number = rand.nextInt(12-8)+8+8;
						ItemStack stack = new ItemStack(Material.COOKED_BEEF, number);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				break;
			case 14:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						ItemStack stack = new ItemStack(Material.BOW, 1);
						stack.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						int number = rand.nextInt(32-16)+32;
						ItemStack stack = new ItemStack(Material.ARROW, number);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
				break;
			case 15:
				while(emptySlots > 0){
					int spot = rand.nextInt(27); 
					if(chest.getBlockInventory().getItem(spot)==null){
						int number = rand.nextInt(40-24)+24+24;
						ItemStack stack = new ItemStack(Material.SNOW_BALL, number);
						chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
						break;
					}
				}
			}
		}
	}

	public void fillChestCommon(int x, int y, int z){
		Location chestLoc = new Location(Bukkit.getWorld("world"), x, y, z);
		Chest chest = (Chest) chestLoc.getBlock().getState();
		Random rand = new Random();
		int emptySlots = 0;
		CraftChest BukkitChest = (CraftChest) chest;
		  // Get the Vanilla net.minecraft.server Chest out of it
		  TileEntityChest NMSChest = BukkitChest.getTileEntity();
		  // Now use the method "a" to set the Title
		  NMSChest.a("§aCommon");
		for(ItemStack stack: chest.getBlockInventory().getContents()){
			if(stack == null){
				emptySlots++;
			}
		}
		for(int i=0;i<2;i++){
		int template = rand.nextInt((15 - 1) + 1) + 1;
		switch(template){
		case 15:
			while(emptySlots > 0){
				int spot = rand.nextInt(27); 
				if(chest.getBlockInventory().getItem(spot)==null){
					ItemStack stack = new ItemStack(Material.STONE_PICKAXE, 1);
					chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
					break;
				}
			}
			while(emptySlots > 0){
				int spot = rand.nextInt(27); 
				if(chest.getBlockInventory().getItem(spot)==null){
					int amount = rand.nextInt(16-1)+1; 
					ItemStack stack = new ItemStack(Material.STONE, amount);
					chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
					break;
				}
			}
			break;
		case 14:
			while(emptySlots > 0){
				int spot = rand.nextInt(27); 
				if(chest.getBlockInventory().getItem(spot)==null){
					ItemStack stack = new ItemStack(Material.WOOD_SWORD, 1);
					chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
					break;
				}
			}			
			while(emptySlots > 0){
				int spot = rand.nextInt(27); 
				if(chest.getBlockInventory().getItem(spot)==null){
					int amount = rand.nextInt(16-1)+1; 
					ItemStack stack = new ItemStack(Material.STONE, amount);
					chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
					break;
				}
			}
			while(emptySlots > 0){
				int spot = rand.nextInt(27); 
				if(chest.getBlockInventory().getItem(spot)==null){
					int amount = rand.nextInt(8-1)+1; 
					ItemStack stack = new ItemStack(Material.COOKED_BEEF, amount);
					chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
					break;
				}
			}
			break;
		case 13:
			while(emptySlots > 0){
				int spot = rand.nextInt(27); 
				if(chest.getBlockInventory().getItem(spot)==null){
					ItemStack stack = new ItemStack(Material.IRON_SWORD, 1);
					chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
					break;
				}
			}
			while(emptySlots > 0){
				int spot = rand.nextInt(27); 
				if(chest.getBlockInventory().getItem(spot)==null){
					ItemStack stack = new ItemStack(Material.APPLE, 1);
					chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
					break;
				}
			}
			break;
		case 12:
			while(emptySlots > 0){
				int spot = rand.nextInt(27); 
				if(chest.getBlockInventory().getItem(spot)==null){
					ItemStack stack = new ItemStack(Material.BOW, 1);
					chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
					break;
				}
			}
			while(emptySlots > 0){
				int spot = rand.nextInt(27); 
				if(chest.getBlockInventory().getItem(spot)==null){
					int amount = rand.nextInt(20-10)+10; 
					ItemStack stack = new ItemStack(Material.ARROW, amount);
					chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
					break;
				}
			}			
			break;
		case 11:
			while(emptySlots > 0){
				int spot = rand.nextInt(27); 
				if(chest.getBlockInventory().getItem(spot)==null){
					ItemStack stack = new ItemStack(Material.STONE_SWORD, 1);
					chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
					break;
				}
			}
			while(emptySlots > 0){
				int spot = rand.nextInt(27); 
				if(chest.getBlockInventory().getItem(spot)==null){
					int amount = rand.nextInt(8-1)+1; 
					ItemStack stack = new ItemStack(Material.COOKED_BEEF, amount);
					chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
					break;
				}
			}
			break;
		case 10:
			while(emptySlots > 0){
				int spot = rand.nextInt(27); 
				if(chest.getBlockInventory().getItem(spot)==null){
					int amount = rand.nextInt(32-1)+1; 
					ItemStack stack = new ItemStack(Material.STONE, amount);
					chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
					break;
				}
			}
			while(emptySlots > 0){
				int spot = rand.nextInt(27); 
				if(chest.getBlockInventory().getItem(spot)==null){
					int amount = rand.nextInt(32-1)+1; 
					ItemStack stack = new ItemStack(Material.STONE, amount);
					chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
					break;
				}
			}
			break;
		case 9:
			while(emptySlots > 0){
				int spot = rand.nextInt(27); 
				if(chest.getBlockInventory().getItem(spot)==null){
					ItemStack stack = new ItemStack(Material.WOOD_SWORD, 1);
					stack.addEnchantment(Enchantment.DAMAGE_ALL, 1);
					chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
					break;
				}
			}
			while(emptySlots > 0){
				int spot = rand.nextInt(27); 
				if(chest.getBlockInventory().getItem(spot)==null){
					int amount = rand.nextInt(16-1)+1; 
					ItemStack stack = new ItemStack(Material.STONE, amount);
					chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
					break;
				}
			}
			break;
		case 8:
			while(emptySlots > 0){
				int spot = rand.nextInt(27); 
				if(chest.getBlockInventory().getItem(spot)==null){
					ItemStack stack = new ItemStack(Material.GOLDEN_APPLE, 1);
					chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
					break;
				}
			}
			break;
		case 7:
			while(emptySlots > 0){
				int spot = rand.nextInt(27); 
				if(chest.getBlockInventory().getItem(spot)==null){
					int amount = rand.nextInt(10-1)+1; 
					ItemStack stack = new ItemStack(Material.EGG, amount);
					chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
					break;
				}
			}
			while(emptySlots > 0){
				int spot = rand.nextInt(27); 
				if(chest.getBlockInventory().getItem(spot)==null){
					int amount = rand.nextInt(10-1)+1; 
					ItemStack stack = new ItemStack(Material.SNOW_BALL, amount);
					chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
					break;
				}
			}
			break;
		case 6:
			while(emptySlots > 0){
				int spot = rand.nextInt(27); 
				if(chest.getBlockInventory().getItem(spot)==null){
					int amount = rand.nextInt(32-1)+1; 
					ItemStack stack = new ItemStack(Material.STONE, amount);
					chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
					break;
				}
			}
			break;
		case 5:
			while(emptySlots > 0){
				int spot = rand.nextInt(27); 
				if(chest.getBlockInventory().getItem(spot)==null){
					ItemStack stack = new ItemStack(Material.WOOD_SWORD, 1);
					chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
					break;
				}
			}
			while(emptySlots > 0){
				int spot = rand.nextInt(27); 
				if(chest.getBlockInventory().getItem(spot)==null){
					int amount = rand.nextInt(16-1)+1; 
					ItemStack stack = new ItemStack(Material.STONE, amount);
					chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
					break;
				}
			}
			break;
		case 4:
			while(emptySlots > 0){
				int spot = rand.nextInt(27); 
				if(chest.getBlockInventory().getItem(spot)==null){
					ItemStack stack = new ItemStack(Material.STONE_PICKAXE, 1);
					chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
					break;
				}
			}
			while(emptySlots > 0){
				int spot = rand.nextInt(27); 
				if(chest.getBlockInventory().getItem(spot)==null){
					ItemStack stack = new ItemStack(Material.IRON_AXE, 1);
					chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
					break;
				}
			}
			break;
		case 3:
			while(emptySlots > 0){
				int spot = rand.nextInt(27); 
				if(chest.getBlockInventory().getItem(spot)==null){
					ItemStack stack = new ItemStack(Material.LEATHER_BOOTS, 1);
					chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
					break;
				}
			}
			while(emptySlots > 0){
				int spot = rand.nextInt(27); 
				if(chest.getBlockInventory().getItem(spot)==null){
					ItemStack stack = new ItemStack(Material.LEATHER_HELMET, 1);
					chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
					break;
				}
			}
			break;
		case 2:
			while(emptySlots > 0){
				int spot = rand.nextInt(27); 
				if(chest.getBlockInventory().getItem(spot)==null){
					ItemStack stack = new ItemStack(Material.IRON_LEGGINGS, 1);
					chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
					break;
				}
			}
			while(emptySlots > 0){
				int spot = rand.nextInt(27); 
				if(chest.getBlockInventory().getItem(spot)==null){
					int amount = rand.nextInt(16-1)+1; 
					ItemStack stack = new ItemStack(Material.STONE, amount);
					chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
					break;
				}
			}
			break;
		case 1:
			while(emptySlots > 0){
				int spot = rand.nextInt(27); 
				if(chest.getBlockInventory().getItem(spot)==null){
					ItemStack stack = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
					chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
					break;
				}
			}
			while(emptySlots > 0){
				int spot = rand.nextInt(27); 
				if(chest.getBlockInventory().getItem(spot)==null){
					ItemStack stack = new ItemStack(Material.WOOD_SWORD, 1);
					chest.getBlockInventory().setItem(spot, stack);
					emptySlots--;
					break;
				}
			}
		}
		}
	}
		
}
