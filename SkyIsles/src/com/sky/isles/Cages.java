package com.sky.isles;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Cages {
	private Main main;
	public Cages(Main main){
	this.main = main;
	}
	YamlConfiguration playerConfig, customConfig;
	
	public void getPlayerCageType(Player player, int x, int y, int z){
		playerConfig = main.getPlayerConfig(player);
		String cage = playerConfig.getString("player.common.cage");
		switch(cage){
		case "barrier":
		case "mob_spawner":
		case "slime_block":
		case "glass":
		case "packed_ice":
			setPlayerCageFull(player,x,y,z,cage);
			break;
		case "oak":
			setPlayerCageDiff(player, x, y, z, "log", (byte) 0, "leaves", (byte) 0);
			break;
		case "spruce":
			setPlayerCageDiff(player, x, y, z, "log", (byte) 1, "leaves", (byte) 1);
			break;
		case "birch":
			setPlayerCageDiff(player, x, y, z, "log", (byte) 2, "leaves", (byte) 2);
			break;
		case "jungle":
			setPlayerCageDiff(player, x, y, z, "log", (byte) 3, "leaves", (byte) 3);
			break;
		case "acacia":
			setPlayerCageDiff(player, x, y, z, "log_2", (byte) 0, "leaves_2", (byte) 0);
			break;
		case "darkoak":
			setPlayerCageDiff(player, x, y, z, "log_2", (byte) 1, "leaves_2", (byte) 1);
			break;
		case "prison":
			setPlayerCageDiff(player, x, y, z, "iron_block", (byte) 0, "iron_fence", (byte) 0);
			break;	
		case "nether":
			setPlayerCageDiff(player, x, y, z, "nether_brick", (byte) 0, "stained_glass", (byte) 10);
			break;
		case "iron":
			setPlayerCageDiff(player, x, y, z, "iron_block", (byte) 0, "stained_glass", (byte) 0);
			break;
		case "gold":
			setPlayerCageDiff(player, x, y, z, "gold_block", (byte) 0, "stained_glass", (byte) 4);
			break;
		case "coal":
			setPlayerCageDiff(player, x, y, z, "coal_block", (byte) 0, "stained_glass", (byte) 15);
			break;
		case "diamond":
			setPlayerCageDiff(player, x, y, z, "diamond_block", (byte) 0, "stained_glass", (byte) 11);
			break;
		case "emerald":
			setPlayerCageDiff(player, x, y, z, "emerald_block", (byte) 0, "stained_glass", (byte) 5);
			break;
		}
		
	}
	
	public void setPlayerCageFull(Player player, int x, int y, int z, String cage){
		Location low = new Location(Bukkit.getWorld("world"), x, y-1, z);
		Material mat = Material.getMaterial(cage.toUpperCase());
		low.getBlock().setType(mat);		
		for(int i=0; i<5; i++){
			low.setX(x+1);
			low.getBlock().setType(mat);
			low.setZ(z+1);
			low.getBlock().setType(mat);
			low.setZ(z-1);
			low.getBlock().setType(mat);
			low.setZ(z);
			low.setX(x-1);
			low.getBlock().setType(mat);
			low.setZ(z+1);
			low.getBlock().setType(mat);
			low.setZ(z-1);
			low.getBlock().setType(mat);
			low.setX(x);
			low.getBlock().setType(mat);
			low.setZ(z+1);
			low.getBlock().setType(mat);
			low.setX(x);
			low.setZ(z);
			low.setY(y+i);
		}		
	}
	
	@SuppressWarnings("deprecation")
	public void setPlayerCageDiff(Player player, int x, int y, int z, String cagefloor, byte metafloor, String cagewalls, byte metawalls){
		//TODO
		Location low = new Location(Bukkit.getWorld("world"), x, y-1, z);
		Material mat = Material.getMaterial(cagefloor.toUpperCase());
		byte current = metafloor;
		low.getBlock().setType(mat);
		low.getBlock().setData(current);
		for(int i=0; i<5; i++){
			low.setX(x+1);
			low.getBlock().setType(mat);
			low.getBlock().setData(current);
			low.setZ(z+1);
			low.getBlock().setType(mat);
			low.getBlock().setData(current);
			low.setZ(z-1);
			low.getBlock().setType(mat);
			low.getBlock().setData(current);
			low.setZ(z);
			low.setX(x-1);
			low.getBlock().setType(mat);
			low.getBlock().setData(current);
			low.setZ(z+1);
			low.getBlock().setType(mat);
			low.getBlock().setData(current);
			low.setZ(z-1);
			low.getBlock().setType(mat);
			low.getBlock().setData(current);
			low.setX(x);
			low.getBlock().setType(mat);
			low.getBlock().setData(current);
			low.setZ(z+1);
			low.getBlock().setType(mat);
			low.getBlock().setData(current);
			low.setX(x);
			low.setZ(z);
			low.setY(y+i);
			current = metawalls;
			mat = Material.getMaterial(cagewalls.toUpperCase());
		}		
	}
}
