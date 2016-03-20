package com.sky.isles;

import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;

public class initStats {
	private Main main;
	public initStats(Main main){
	this.main = main;
	}
	YamlConfiguration playerConfig;
	
	
	public void initStat(OfflinePlayer player){
		String temp;
	    playerConfig = main.getPlayerConfig(player);		   
//COMMON 
      temp = playerConfig.getString("player.common.name");
	  if(temp == null || temp!=player.getName()){
		  playerConfig.set("player.common.name", player.getName());
	  }
	  temp = playerConfig.getString("player.common.coins");
	  if(temp == null){
		  playerConfig.set("player.common.coins", 0);
	  }
	  temp = playerConfig.getString("player.common.kills");
	  if(temp == null){
		  playerConfig.set("player.common.kills", 0);
	  }
	  temp = playerConfig.getString("player.common.deaths");
	  if(temp == null){
		  playerConfig.set("player.common.deaths", 0);
	  }
	  temp = playerConfig.getString("player.common.plays");
	  if(temp == null){
		  playerConfig.set("player.common.plays", 0);
	  }
	  temp = playerConfig.getString("player.common.wins");
	  if(temp == null){
		  playerConfig.set("player.common.wins", 0);
	  }
	  temp = playerConfig.getString("player.common.losses");
	  if(temp == null){
		  playerConfig.set("player.common.losses", 0);
	  }
	  temp = playerConfig.getString("player.common.achievementpoints");
	  if(temp == null){
		  playerConfig.set("player.common.achievementpoints", 0);
	  }
	  temp = playerConfig.getString("player.common.kit");
	  if(temp == null){
		  playerConfig.set("player.common.kit", "default");
	  }
	  temp = playerConfig.getString("player.common.cage");
	  if(temp == null){
		  playerConfig.set("player.common.cage", "glass");
	  }
	  temp = playerConfig.getString("player.common.deathmessage");
	  if(temp == null){
		  playerConfig.set("player.common.deathmessage", "killed");
	  }
//KITS
	  temp = playerConfig.getString("player.kits.miner");
	  if(temp == null){
		  playerConfig.set("player.kits.miner", false);
	  }
	  temp = playerConfig.getString("player.kits.rusher");
	  if(temp == null){
		  playerConfig.set("player.kits.rusher", false);
	  }
	  temp = playerConfig.getString("player.kits.builder");
	  if(temp == null){
		  playerConfig.set("player.kits.builder", false);
	  }
	  temp = playerConfig.getString("player.kits.archer");
	  if(temp == null){
		  playerConfig.set("player.kits.archer", false);
	  }
	  temp = playerConfig.getString("player.kits.cannoneer");
	  if(temp == null){
		  playerConfig.set("player.kits.cannoneer", false);
	  }
	  temp = playerConfig.getString("player.kits.armorer");
	  if(temp == null){
		  playerConfig.set("player.kits.armorer", false);
	  }
//CAGES
	  temp = playerConfig.getString("player.cages.slime");
	  if(temp == null){
		  playerConfig.set("player.cages.slime", false);
	  }
	  temp = playerConfig.getString("player.cages.spawner");
	  if(temp == null){
		  playerConfig.set("player.cages.spawner", false);
	  }
	  temp = playerConfig.getString("player.cages.barrier");
	  if(temp == null){
		  playerConfig.set("player.cages.barrier", false);
	  }
	  temp = playerConfig.getString("player.cages.ice");
	  if(temp == null){
		  playerConfig.set("player.cages.ice", false);
	  }
	  temp = playerConfig.getString("player.cages.coal");
	  if(temp == null){
		  playerConfig.set("player.cages.coal", false);
	  }
	  temp = playerConfig.getString("player.cages.gold");
	  if(temp == null){
		  playerConfig.set("player.cages.gold", false);
	  }
	  temp = playerConfig.getString("player.cages.iron");
	  if(temp == null){
		  playerConfig.set("player.cages.iron", false);
	  }
	  temp = playerConfig.getString("player.cages.diamond");
	  if(temp == null){
		  playerConfig.set("player.cages.diamond", false);
	  }
	  temp = playerConfig.getString("player.cages.emerald");
	  if(temp == null){
		  playerConfig.set("player.cages.emerald", false);
	  }
	  temp = playerConfig.getString("player.cages.oak");
	  if(temp == null){
		  playerConfig.set("player.cages.oak", false);
	  }
	  temp = playerConfig.getString("player.cages.spruce");
	  if(temp == null){
		  playerConfig.set("player.cages.spruce", false);
	  }
	  temp = playerConfig.getString("player.cages.birch");
	  if(temp == null){
		  playerConfig.set("player.cages.birch", false);
	  }
	  temp = playerConfig.getString("player.cages.jungle");
	  if(temp == null){
		  playerConfig.set("player.cages.jungle", false);
	  }
	  temp = playerConfig.getString("player.cages.acacia");
	  if(temp == null){
		  playerConfig.set("player.cages.acacia", false);
	  }
	  temp = playerConfig.getString("player.cages.darkoak");
	  if(temp == null){
		  playerConfig.set("player.cages.darkoak", false);
	  }
	  temp = playerConfig.getString("player.cages.nether");
	  if(temp == null){
		  playerConfig.set("player.cages.nether", false);
	  }
	  temp = playerConfig.getString("player.cages.prison");
	  if(temp == null){
		  playerConfig.set("player.cages.prison", false);
	  }
//DEATHMESSAGES
	  temp = playerConfig.getString("player.deathmessages.slaughtered");
	  if(temp == null){
		  playerConfig.set("player.deathmessages.slaughtered", false);
	  }
	  temp = playerConfig.getString("player.deathmessages.destroyed");
	  if(temp == null){
		  playerConfig.set("player.deathmessages.destroyed", false);
	  }
	  temp = playerConfig.getString("player.deathmessages.humiliated");
	  if(temp == null){
		  playerConfig.set("player.deathmessages.humiliated", false);
	  }
	  temp = playerConfig.getString("player.deathmessages.erased");
	  if(temp == null){
		  playerConfig.set("player.deathmessages.erased", false);
	  }
	  temp = playerConfig.getString("player.deathmessages.oblivion");
	  if(temp == null){
		  playerConfig.set("player.deathmessages.oblivion", false);
	  }
	  temp = playerConfig.getString("player.deathmessages.rekt");
	  if(temp == null){
		  playerConfig.set("player.deathmessages.rekt", false);
	  }
//ITEMSTATS
	  temp = playerConfig.getString("player.itemstats.AX100Helmet");
	  if(temp == null){
		  playerConfig.set("player.itemstats.AX100Helmet", 0);
	  }
	  temp = playerConfig.getString("player.itemstats.AX100ChestPlate");
	  if(temp == null){
		  playerConfig.set("player.itemstats.AX100ChestPlate", 0);
	  }
	  temp = playerConfig.getString("player.itemstats.AX100Leggings");
	  if(temp == null){
		  playerConfig.set("player.itemstats.AX100Leggings", 0);
	  }
	  temp = playerConfig.getString("player.itemstats.AX100Boots");
	  if(temp == null){
		  playerConfig.set("player.itemstats.AX100Boots", 0);
	  }
	  temp = playerConfig.getString("player.itemstats.Buster");
	  if(temp == null){
		  playerConfig.set("player.itemstats.Buster", 0);
	  }
	  temp = playerConfig.getString("player.itemstats.FlyGuide");
	  if(temp == null){
		  playerConfig.set("player.itemstats.FlyGuide", 0);
	  }
	  temp = playerConfig.getString("player.itemstats.Blub");
	  if(temp == null){
		  playerConfig.set("player.itemstats.Blub", 0);
	  }
	  temp = playerConfig.getString("player.itemstats.Upgrade");
	  if(temp == null){
		  playerConfig.set("player.itemstats.Upgrade", 0);
	  }
	  temp = playerConfig.getString("player.itemstats.Enchant");
	  if(temp == null){
		  playerConfig.set("player.itemstats.Enchant", 0);
	  }
	  temp = playerConfig.getString("player.itemstats.Party");
	  if(temp == null){
		  playerConfig.set("player.itemstats.Party", 0);
	  }
	  temp = playerConfig.getString("player.itemstats.Cookie");
	  if(temp == null){
		  playerConfig.set("player.itemstats.Cookie", 0);
	  }  
	  temp = playerConfig.getString("player.itemstats.Thor");
	  if(temp == null){
		  playerConfig.set("player.itemstats.Thor", 0);
	  }
	  temp = playerConfig.getString("player.itemstats.DIY");
	  if(temp == null){
		  playerConfig.set("player.itemstats.DIY", 0);
	  }
	  temp = playerConfig.getString("player.itemstats.BoomBox");
	  if(temp == null){
		  playerConfig.set("player.itemstats.BoomBox", 0);
	  }
	  temp = playerConfig.getString("player.itemstats.Gapple");
	  if(temp == null){
		  playerConfig.set("player.itemstats.Gapple", 0);
	  }
	  temp = playerConfig.getString("player.itemstats.Zombie");
	  if(temp == null){
		  playerConfig.set("player.itemstats.Zombie", 0);
	  }
//ACHIEVEMENTS
	  //NONTIERED
	  temp = playerConfig.getString("player.achievements.PowersuitHelmet");
	  if(temp == null){
		  playerConfig.set("player.achievements.PowersuitHelmet", false);
	  }
	  temp = playerConfig.getString("player.achievements.PowersuitChestPlate");
	  if(temp == null){
		  playerConfig.set("player.achievements.PowersuitChestPlate", false);
	  }
	  temp = playerConfig.getString("player.achievements.PowersuitLeggings");
	  if(temp == null){
		  playerConfig.set("player.achievements.PowersuitLeggings", false);
	  }
	  temp = playerConfig.getString("player.achievements.PowersuitBoots");
	  if(temp == null){
		  playerConfig.set("player.achievements.PowersuitBoots", false);
	  }
	  temp = playerConfig.getString("player.achievements.Busted");
	  if(temp == null){
		  playerConfig.set("player.achievements.busted", false);
	  }
	  temp = playerConfig.getString("player.achievements.Flying_101");
	  if(temp == null){
		  playerConfig.set("player.achievements.Flying_101", false);
	  }
	  temp = playerConfig.getString("player.achievements.Fishing");
	  if(temp == null){
		  playerConfig.set("player.achievements.Fishing", false);
	  }
	  temp = playerConfig.getString("player.achievements.Upgrading");
	  if(temp == null){
		  playerConfig.set("player.achievements.Upgrading", false);
	  }
	  temp = playerConfig.getString("player.achievements.Enchanted");
	  if(temp == null){
		  playerConfig.set("player.achievements.Enchanted", false);
	  }
	  temp = playerConfig.getString("player.achievements.Party");
	  if(temp == null){
		  playerConfig.set("player.achievements.Party", false);
	  }
	  temp = playerConfig.getString("player.achievements.Noms");
	  if(temp == null){
		  playerConfig.set("player.achievements.Noms", false);
	  }
	  temp = playerConfig.getString("player.achievements.Thor");
	  if(temp == null){
		  playerConfig.set("player.achievements.Thor", false);
	  }
	  temp = playerConfig.getString("player.achievements.DIY");
	  if(temp == null){
		  playerConfig.set("player.achievements.DIY", false);
	  }
	  temp = playerConfig.getString("player.achievements.BoomBox");
	  if(temp == null){
		  playerConfig.set("player.achievements.BoomBox", false);
	  }
	  temp = playerConfig.getString("player.achievements.Apple");
	  if(temp == null){
		  playerConfig.set("player.achievements.Apple", false);
	  }
	  temp = playerConfig.getString("player.achievements.Zombie");
	  if(temp == null){
		  playerConfig.set("player.achievements.Zombie", false);
	  }
	  //TIERED
	  temp = playerConfig.getString("player.achievements.Kills_1");
	  if(temp == null){
		  playerConfig.set("player.achievements.Kills_1", false);
	  }
	  temp = playerConfig.getString("player.achievements.Kills_2");
	  if(temp == null){
		  playerConfig.set("player.achievements.Kills_2", false);
	  }
	  temp = playerConfig.getString("player.achievements.Kills_3");
	  if(temp == null){
		  playerConfig.set("player.achievements.Kills_3", false);
	  }
	  temp = playerConfig.getString("player.achievements.Kills_4");
	  if(temp == null){
		  playerConfig.set("player.achievements.Kills_4", false);
	  }
	  temp = playerConfig.getString("player.achievements.Kills_5");
	  if(temp == null){
		  playerConfig.set("player.achievements.Kills_5", false);
	  }
	  temp = playerConfig.getString("player.achievements.Plays_1");
	  if(temp == null){
		  playerConfig.set("player.achievements.Plays_1", false);
	  }
	  temp = playerConfig.getString("player.achievements.Plays_2");
	  if(temp == null){
		  playerConfig.set("player.achievements.Plays_2", false);
	  }
	  temp = playerConfig.getString("player.achievements.Plays_3");
	  if(temp == null){
		  playerConfig.set("player.achievements.Plays_3", false);
	  }
	  temp = playerConfig.getString("player.achievements.Plays_4");
	  if(temp == null){
		  playerConfig.set("player.achievements.Plays_4", false);
	  }
	  temp = playerConfig.getString("player.achievements.Plays_5");
	  if(temp == null){
		  playerConfig.set("player.achievements.Plays_5", false);
	  }
	  temp = playerConfig.getString("player.achievements.Wins_1");
	  if(temp == null){
		  playerConfig.set("player.achievements.Wins_1", false);
	  }
	  temp = playerConfig.getString("player.achievements.Wins_2");
	  if(temp == null){
		  playerConfig.set("player.achievements.Wins_2", false);
	  }
	  temp = playerConfig.getString("player.achievements.Wins_3");
	  if(temp == null){
		  playerConfig.set("player.achievements.Wins_3", false);
	  }
	  temp = playerConfig.getString("player.achievements.Wins_4");
	  if(temp == null){
		  playerConfig.set("player.achievements.Wins_4", false);
	  }
	  temp = playerConfig.getString("player.achievements.Wins_5");
	  if(temp == null){
		  playerConfig.set("player.achievements.Wins_5", false);
	  }
	  
	  main.playerConfig = playerConfig;
	  main.savePlayerConfig(player);
	}
}
