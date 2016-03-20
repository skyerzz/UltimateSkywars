package com.sky.isles;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.block.CraftChest;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;

import com.sky.isles.Shop;

import net.minecraft.server.v1_8_R3.Entity;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.TileEntityChest;

public class Main extends JavaPlugin implements Listener{
	Shop shop = new Shop(this);
	Chests chests = new Chests(this);
	Achievements achievements = new Achievements(this);
	AchievementShop achShop = new AchievementShop(this);
	Cages cages = new Cages(this);
	initStats init = new initStats(this);
	Kits kits = new Kits(this);
	static Plugin plugin = null;
	BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
	String prefix, spawn,lobby;
	YamlConfiguration config, playerConfig, customConfig;
	File file2;
	File file3;
	String copyPos1, copyPos2, copyToPos, copyToPos2;
	int players = 0, maxPlayers, startOnPlayers = 5, coinsOnKill = 25, coinsOnWin = 100, currentPlaytimeSeconds = 0, currentPlaytimeMinutes = 0;
	private HashMap<Player, Integer> inGame = new HashMap<Player, Integer>();	 //doubles as current kills hashmap
	private HashMap<Player, Integer> cCoins = new HashMap<Player, Integer>();
	private HashMap<Player, Integer> alive = new HashMap<Player, Integer>();
	private HashMap<String, Integer> chestsFound = new HashMap<String, Integer>();
	private HashMap<Player, Integer> islands =  new HashMap<Player, Integer>();
	boolean gameRunning = false;
	boolean gameStarting = false;
	boolean gameCancelled = false;
	boolean gameStopping = false;
	
	
	
	/*
	TODO: common
	add titles
	timelimit + draw
	*/
	
	/*	
	TODO: bugs
	*/
	
	/*
	todo kits/cages/perks/deathmessages
	todo: kits
	
	
	todo: cages
	(post release) villager: barriers all around with villagers on the sides
	
	todo: perks
	not right now...
	*/
	
	/*
	FIXED BUGS:
	9.8A- falling out of the world doesnt trigger while ingame
	9.8A- achievements did not trigger on stacks of items
	9.7A- die twice - falldamage + killed
	9.7A- logging out doesnt check if ingame/alive/gamerunning
	9.7A- scoreboard lists kills + coins twice
	9.7A- cages do not reset on leave
	9.7A- players do not get coins
	9.6A- the cages do not reset correctly > prison cage (not center block) -> get config coords for removing cages
	9.5A- start keeps on going > keeps resetting cages
	9.5A-Cages shop not working - stops after glass, no other if statements executed
	9.4A-clicking emerald in shop gives error
	9.4A-armor doesnt get cleared
	9.4A-end always throws off cliff
	9.4A-you can join before a game ends
	9.3A-random nullpointer on playerinteract
	9.3A-metadata from copying blocks
	*/
	
	/*
	DONE: kits
	default (wood pick+shovel+axe)
	miner (stone pick eff V)
	rusher(gold sword sharp 2)
	builder (16 wood)
	archer (bow, 10 arrows)
	cannoneer (4 tnt, water bucket, 8 redstone)
	armorer (full gold armor)
	
	DONE: deathmessages
	REKT by
	erased by
	sent to oblivion by
	destroyed by
	humiliated by
	default (killed by)
	slaughtered by
	
	DONE: cages
	default
	slimeblock
		trees: logs on bottom, leaves on edges
	- oak
	- birch
	- jungle
	- spruce
	- acacia
	- darkoak
	prison cage: iron blocks bottom, edges of ironbars
	spawner
	nether brick: purple glass sides
	diamond : blue glass sides
	gold : yellow glass sides
	iron : white glass sides
	emerald : green glass sides
	coal: black glass sides
	barrier
	ice
	
	DONE: perks
	*/
	
	/*
	DONE:
	9.6A-hashmap for occupied islands
	9.6A- leave game command
	chestspawns in config normalize
	9.6A- ingameway to set spawnpoints for islands + chests for those islands.
	9.6A- make in-game points for copying arena + setting lobby
	killshop command (5 radius)	
	help command
	make kit changing device in stating of game
	give kits when game starts, not before
	fall event also awards killer
	create stats in shop
	create achievements in shop
	create spawnshop command
	make shop for cages, kits, finisher messages, perks
	create DEBUG command
	set death to gm3, drop their inventory, but dont actually let them die.
	if player leaves game, put the message in
	make player leaving the server work
	set falldamage to none in the first 5 seconds
	set blocks unbreakable untill cages fall
	broadcast if a legendary chest is opened for the first time
	refill chests
	create playtime in scoreboard
	set chest names
	admin command to spawn a legendary chest on your location
	make a cage the player spawns in
	create end-function with winner announced
	make config contain total players, spawn coords for each player, players on which it should start DONT FORGET THE COORDS ARE HALFS
	create join command
	create seperate function for mid-chests -> just use rare/epic/legendaries, with resp. 60%-30%-10% chance?
	make random-ess chests in a function, containing coords the chest should spawn, the chest number.
	create force-reset command -> force stop automatically resets.
	create force start command
	create force stop command
	scoreboard containing current players left, current kills, current coins earnt.
	sign interact function
	create lobby command
	create coin manipulation command
	create stats command
	put in stats (player.yml): kills, wins, plays, losses, total coins ever earnt,
	kill function, get killer, put coins+ kills+ deaths to yml
	create countdown + start function
	reset function which takes the begin and endblock of x,y,z and will copy that whole thing over to the given coords for the arena. Build in a check to see if both areas are the same size.
	*/
	
	@Override
	public void onEnable() {
		getLogger().info("Let go of your earthly tether.");
		getLogger().info("Enter the void.");
		getLogger().info("~Guru Laghima");
		plugin = this;
		this.getServer().getPluginManager().registerEvents(this, this);
		reload();
		File path = new File(getDataFolder() + "/players");
		  if(!path.exists()){
			  path.mkdirs();
		  }
		for(Player player: Bukkit.getOnlinePlayers()){
			init.initStat(player);
		}
		timer();
	}
	
	@Override
	
	public void onDisable() {
		
	 }
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		init.initStat(player);
		player.sendMessage(prefix + ChatColor.GOLD + "Welcome to Skywars");
	    
	}
	
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent event){
		if(inGame.containsKey(event.getPlayer())){
			Player player = event.getPlayer();
			if(gameStarting){
				dropCage(player);
			}
			if(alive.containsKey(event.getPlayer())){
			playerDies(player);
			}
			toLobby(player);
			player.setGameMode(GameMode.ADVENTURE);
			inGame.remove(player);
			
			if(player.getLastDamageCause() instanceof EntityDamageByEntityEvent){
				Player p2 = (Player) ((EntityDamageByEntityEvent) player.getLastDamageCause()).getDamager();
				for(Player p3: inGame.keySet()){
					p3.sendMessage(prefix + ChatColor.DARK_AQUA + player.getName() + ChatColor.YELLOW + " left the server trying to escape " + ChatColor.DARK_AQUA + p2.getName());
				}
				playerConfig = getPlayerConfig(p2);
				int kills = playerConfig.getInt("player..common.kills");
				kills++;
				playerConfig.set("player..common.deaths", kills);
				int coins = playerConfig.getInt("player..common.coins");
				coins+=coinsOnKill;
				playerConfig.set("player.common.coins", coins);
				cCoins.replace(p2, cCoins.get(p2) + coinsOnKill);
				inGame.replace(p2, inGame.get(p2)+1);
			}
			else{
				for(Player p2: inGame.keySet()){
					p2.sendMessage(prefix + ChatColor.DARK_AQUA + player.getName() + ChatColor.YELLOW + " Has left the game!");
				}
			}
		}
	}
	
	@EventHandler
	public void onPlayerKill(EntityDamageByEntityEvent event){
		if(event.getEntityType() == EntityType.PLAYER && inGame.containsKey((Player) event.getEntity())){
			Player playerDied = (Player) event.getEntity();
			if(playerDied.getHealth() - event.getDamage() <=0){
				event.setCancelled(true);
				if(alive.containsKey(playerDied)){
				playerDies(playerDied);
				}
				Player playerKiller = (Player) event.getDamager();
				if(playerKiller != null){
					giveKill(playerKiller);
					String killmessage = playerConfig.getString("player.common.deathmessage");
					for(Player player: inGame.keySet()){
						player.sendMessage(prefix + ChatColor.DARK_AQUA +  "" + playerDied.getName() + ChatColor.YELLOW + " was " +  killmessage + " by "+ ChatColor.DARK_AQUA + playerKiller.getName());
					}
				}
				updateScoreboard();
				if(players == 1){
					for(Player player: alive.keySet()){
						gameEnd(player);
					}
				}
			}
		}
		else if(event.getEntityType() == EntityType.VILLAGER){
			Villager villager = (Villager) event.getEntity();
			if(villager.getName().equalsIgnoreCase("§cSkywars Shop")){
				event.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event){
		Player player = event.getPlayer();
		if(inGame.containsKey(player) && gameRunning == false){
			event.setCancelled(true);
		}
	}
	
	public void playerDies(Player player){
		player.damage(0);
		playerConfig = getPlayerConfig(player);
		players--;
		int deaths = playerConfig.getInt("player.common.deaths");
		deaths++;
		playerConfig.set("player.common.deaths", deaths);
		savePlayerConfig(player);
		alive.remove(player);
		if(gameRunning==false){
			player.getInventory().clear();
			player.getInventory().setHelmet(new ItemStack(Material.AIR, 1));
			player.getInventory().setChestplate(new ItemStack(Material.AIR, 1));
			player.getInventory().setLeggings(new ItemStack(Material.AIR, 1));
			player.getInventory().setBoots(new ItemStack(Material.AIR, 1));
		}
		ItemStack[] items = player.getInventory().getContents();
		for(int i = 0; i < items.length; i++){
		    ItemStack is = items[i];
		    if(is != null && is.getAmount() > 0)
		    {
		        player.getWorld().dropItemNaturally(player.getLocation(), is);
		    }
		}
		player.getInventory().clear();
		player.setGameMode(GameMode.SPECTATOR);
		updateScoreboard();
		
	}
	
	public void giveKill(Player player){		
		playerConfig = getPlayerConfig(player);
		int kills = playerConfig.getInt("player.common.kills");
		kills++;
		playerConfig.set("player.common.kills", kills);					
		int coins = playerConfig.getInt("player.common.coins");
		coins+=coinsOnKill;
		playerConfig.set("player.common.coins", coins);
		cCoins.replace(player, cCoins.get(player) + coinsOnKill);
		inGame.replace(player, inGame.get(player)+1);
		achievements.testAchievementStat(player);
		savePlayerConfig(player);
		player.sendMessage(ChatColor.GOLD + "(+" + coinsOnKill + " coins!)");
	}
	
	@EventHandler
	public void onFallDamage(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        Player player = (Player) event.getEntity();
        if (event.getCause() == DamageCause.FALL && (currentPlaytimeMinutes == 0 && currentPlaytimeSeconds <= 5) && inGame.containsKey(player)) {
        	event.setCancelled(true);
        }
        else if(event.getCause() == DamageCause.VOID){
    		event.setCancelled(true);
    		playerDies(player);
	        	if(player.getLastDamageCause()!=null){
	        		if(player.getLastDamageCause().getCause() == DamageCause.ENTITY_ATTACK){
	        			Player p2 = (Player) ((EntityDamageByEntityEvent) player.getLastDamageCause()).getDamager();
	        			player.teleport(p2);
		    			for(Player p3: inGame.keySet()){
							p3.sendMessage(prefix + ChatColor.DARK_AQUA + player.getName() + ChatColor.YELLOW + " Was thrown into the void by " + ChatColor.DARK_AQUA + p2.getName());
						}	    			
		    			giveKill(p2);
	        		}
	        		else{
	        			for(Player p3: inGame.keySet()){
							p3.sendMessage(prefix + ChatColor.DARK_AQUA + player.getName() + ChatColor.YELLOW + " Fell into the void.");
						}
	        			toLobby(player);
	        		}
				}
		}
        else if(inGame.containsKey(player) && alive.containsKey(player) && event.getCause() != DamageCause.ENTITY_ATTACK){
        	if(player.getHealth() - event.getDamage() <=-1){
        		event.setCancelled(true);
        		playerDies(player);
        		if(player.getLastDamageCause()!=null){	        		
	        	    if(player.getLastDamageCause().getCause() == DamageCause.ENTITY_ATTACK){
		    			Player p2 = (Player) ((EntityDamageByEntityEvent) player.getLastDamageCause()).getDamager();
		    			for(Player p3: inGame.keySet()){
							p3.sendMessage(prefix + ChatColor.DARK_AQUA + player.getName() + ChatColor.YELLOW + " Was thrown off a cliff by " + ChatColor.DARK_AQUA + p2.getName());
						}	    			
		    			giveKill(p2);
	        		}
	        		else{
	        			for(Player p3: inGame.keySet()){
							p3.sendMessage(prefix + ChatColor.DARK_AQUA + player.getName() + ChatColor.YELLOW + " tripped and died");
						}
	        		}
	        	}
        	}
        }
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        UUID uuid = player.getUniqueId(); 
        ItemStack clicked = event.getCurrentItem(); 
        Inventory inventory = event.getInventory();
        if(inventory.getName().equalsIgnoreCase("Skywars Shop")){
        	event.setCancelled(true);
        	shop.buyShopWindowMain(player, uuid, clicked);
        }
        else if(inventory.getName().equalsIgnoreCase("Skywars Kits Shop")){
        	event.setCancelled(true);
        	shop.buyShopWindowKits(player, uuid, clicked);
        }
        else if(inventory.getName().equalsIgnoreCase("Skywars Kits Shop - INGAME")){
        	event.setCancelled(true);
        	shop.buyShopWindowKitsIngame(player, uuid, clicked);
        }
        else if(inventory.getName().equalsIgnoreCase("Skywars DeathMessages Shop")){
        	event.setCancelled(true);
        	shop.buyShopWindowDeathMessage(player, uuid, clicked);
        }
        else if(inventory.getName().equalsIgnoreCase("Skywars Cage Shop Page 1")){
        	event.setCancelled(true);
        	shop.buyShopWindowCages(player, uuid, clicked);
        }
        else if(inventory.getName().equalsIgnoreCase("Skywars Cage Shop Page 2")){
        	event.setCancelled(true);
        	shop.buyShopWindowCagesPage2(player, uuid, clicked);
        }
        else if(inventory.getName().equalsIgnoreCase("Skywars Stats")){
        	event.setCancelled(true);
        	shop.buyShopWindowStats(player, uuid, clicked);
        }
        else if(inventory.getName().equalsIgnoreCase("Skywars Achievements")){
        	event.setCancelled(true);
        	achShop.buyShopWindowAchievements(player, uuid, clicked);
        }
	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){
	   Player player = event.getPlayer();
	   	  if(player.getItemInHand().getType() == null){
	   		  return;
	      }
	   	  else if(player.getItemInHand().getItemMeta()== null){
	   		  return;
	   	  }
	   	  else if(player.getItemInHand().getType().equals(Material.BOW) && player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Kit Selector")){
	    	  shop.showShopWindowKitsIngame(player);
	      }
	}
	
	@EventHandler
	public void onEntityInteract(PlayerInteractEntityEvent event) {
	      Player player = event.getPlayer();
	      if (event.getRightClicked() instanceof Villager) {
	          Villager villager = (Villager)event.getRightClicked();
	          if(ChatColor.stripColor(villager.getCustomName()).equalsIgnoreCase("Skywars Shop")) {
	             event.setCancelled(true);//cancel the trading
	             shop.showShopWindowMain(player);//opens shop GUI
	          }
	      }
	 }
	
	@EventHandler	
	public void blockInteract(PlayerInteractEvent event) {
	      if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {
	      	Player player = event.getPlayer();
	      	Block block = event.getClickedBlock();
	      	
	              if(block.getType() == Material.SIGN || block.getType() == Material.SIGN_POST || block.getType() == Material.WALL_SIGN) {
	                    Sign sign = (Sign) event.getClickedBlock().getState();
	                    if(sign.getLine(1).toLowerCase().contains("skywars")) {
	                    	if(sign.getLine(0).toLowerCase().contains("play")){
	                    		if(player.hasPermission("SkyWars.join")){
	                    		joinPlayerGame(player);
	                    		}
	                    		else{
	                    			player.sendMessage(prefix + ChatColor.RED + "You don't have the permission to join a game!");
	                    		}
	                    	}//line 0 == PLAY
	                    }//line 1 == SkyWars
	              }
	              else if(block.getType() == Material.CHEST && alive.containsKey(player)){
						Chest chest = (Chest) block.getState();
						CraftChest BukkitChest = (CraftChest) chest;
						String location = chest.getX() + "" + chest.getY() + "" + chest.getZ() + "";
						  TileEntityChest NMSChest = BukkitChest.getTileEntity();
						  if(NMSChest.getName().equalsIgnoreCase("§6Legendary!") && !chestsFound.containsKey(location)){
							  chestsFound.put(location, 1);
							  achievements.testAchievementItem(chest, player);							  
							  for(Player player2: inGame.keySet()){								  
								  player2.sendMessage(prefix + ChatColor.DARK_AQUA + player.getName() + ChatColor.YELLOW + " found a legendary chest!");
							  }
							  
						  }
						  else if(NMSChest.getName().equalsIgnoreCase("§5Epic") && !chestsFound.containsKey(location)){
							  chestsFound.put(location, 1);
							  achievements.testAchievementItem(chest, player);  
						  }
	              }
	      }
	  }
	
	public void getConfigValues(){
		File file = new File(getDataFolder(), "config.yml");
	    if (!file.exists()) {
	        getLogger().info("config.yml not found, creating!");
	        saveDefaultConfig();
	    } else {
	        getLogger().info("config.yml found, loading!");
	    }
	    config = YamlConfiguration.loadConfiguration(file);
	    String prefixtemp = config.getString("prefix");
	    startOnPlayers = config.getInt("startonplayercount");
	    if(prefixtemp != null){
	    	prefix = prefixtemp.replaceAll("&" , "§") + "§r ";
	    }
	    copyPos1 = config.getString("copyloc1");
	    copyPos2 = config.getString("copyloc2");
	    copyToPos = config.getString("copytoloc1");
	    copyToPos2 = config.getString("copytoloc2");
	    lobby = config.getString("lobby");
	    coinsOnKill = config.getInt("coinsonkill");
	    coinsOnWin = config.getInt("coinsonwin");
	    maxPlayers = config.getInt("maxplayers");	    
	}
	
	public void getCustomConfigValues(){
		File file = new File(getDataFolder(), "customconfig.yml");
	    if (!file.exists()) {
	        getLogger().info("customconfig.yml not found, creating!");
	        try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    } else {
	        getLogger().info("customconfig.yml found, loading!");
	    }
	    customConfig = YamlConfiguration.loadConfiguration(file);
	    String prefixtemp = customConfig.getString("prefix");
	    if(prefixtemp != null){
	    	prefix = prefixtemp.replaceAll("&" , "§") + "§r ";
	    }
	    String tempcopyloc1 = customConfig.getString("copyloc1");
	    if(tempcopyloc1 != null){
	    	copyPos1 = tempcopyloc1;
	    }
	    String tempcopyloc2 = customConfig.getString("copyloc2");
	    if(tempcopyloc2 != null){
	    	copyPos2 = tempcopyloc2;
	    }
	    String tempcopytoloc1 = customConfig.getString("copytoloc1");
	    if(tempcopytoloc1 != null){
	    	copyToPos = tempcopytoloc1;
	    }
	    String tempcopytoloc2 = customConfig.getString("copytoloc2");
	    if(tempcopytoloc2 != null){
	    	copyToPos2 = tempcopytoloc2;
	    }
	    String templobby = customConfig.getString("lobby");
	    if(templobby != null){
	    	lobby = templobby;
	    }
	    String tempmax = customConfig.getString("maxplayers");
	    if(tempmax != null){
	    	maxPlayers = Integer.parseInt(tempmax);
	    }
	    String tempplayers = customConfig.getString("startonplayers");
	    if(tempplayers != null){
	    	startOnPlayers = Integer.parseInt(tempplayers);
	    }
	    String tempcoinsonkill = customConfig.getString("coinsonkill");
	    if(tempcoinsonkill != null){
	    	coinsOnKill = Integer.parseInt(tempcoinsonkill);
	    }
	    String tempcoinsonwin = customConfig.getString("coinsonwin");
	    if(tempcoinsonwin != null){
	    	coinsOnWin = Integer.parseInt(tempcoinsonwin);
	    }
	    String useConfigIslands = customConfig.getString("useconfigislands");
		if(useConfigIslands == null){
			customConfig.set("useconfigislands", true);
			saveCustomConfig();
			reload();
		}
	    if(customConfig.getBoolean("useconfigislands")==true){
			setCustomConfigIslands();
	    }
	    
	}
	
	public void saveCustomConfig(){
		File file = new File(getDataFolder(), "customconfig.yml");
		try {
			customConfig.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		customConfig = YamlConfiguration.loadConfiguration(file);
	}
	
	public void reload(){
		getConfigValues();	    
	    getCustomConfigValues();
	    shop.prefix = prefix;
	    shop.config = config;
	    cages.customConfig = customConfig;
	    achShop.prefix = prefix;	    
	    shop.initialize();
	    achShop.initialise();
	}
	
	public void savePlayerConfig(OfflinePlayer player){
		UUID uuid = player.getUniqueId();
		File file = new File(getDataFolder() + "/players", uuid + "stats.yml");
		try {
			playerConfig.save(file);				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public YamlConfiguration getPlayerConfig(OfflinePlayer player){
		 UUID uuid = player.getUniqueId();
		  file3 = new File(getDataFolder() + "/players", uuid + "stats.yml");
		    if (!file3.exists()) {
		        getLogger().info("couldnt find a statsfile for player " + player.getName() + ", creating one!");
		        try {
					file3.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
		    }
		    YamlConfiguration configOfPlayer = YamlConfiguration.loadConfiguration(file3);		    
		return configOfPlayer;
		
	}
	
	@SuppressWarnings("deprecation")
	public void copyBlocks(){
		  int x,y,z,x1,y1,z1,tox,toy,toz,tox1,toy1,toz1,c=0;
		  setTemplate();
		  String[] Pos1Arr = copyPos1.split(",");
		  String[] Pos2Arr = copyPos2.split(",");
		  String[] toPosArr = copyToPos.split(",");
		  String[] toPos2Arr = copyToPos2.split(",");
		  x = Integer.parseInt(Pos1Arr[0]);
		  y = Integer.parseInt(Pos1Arr[1]);
		  z = Integer.parseInt(Pos1Arr[2]);
		  x1 = Integer.parseInt(Pos2Arr[0]);
		  y1 = Integer.parseInt(Pos2Arr[1]);
		  z1 = Integer.parseInt(Pos2Arr[2]);
		  tox = Integer.parseInt(toPosArr[0]);
		  toy = Integer.parseInt(toPosArr[1]);
		  toz = Integer.parseInt(toPosArr[2]);
		  tox1 = Integer.parseInt(toPos2Arr[0]);
		  toy1 = Integer.parseInt(toPos2Arr[1]);
		  toz1 = Integer.parseInt(toPos2Arr[2]);
		  if( ((x1-x)==(tox1-tox)) && ((y1-y)==(toy1-toy)) && ((z1-z)==(toz1-toz)) ){
			  int i=0,j=0,k=0;
			  Material current, toBlock;
			  byte data=0;
			  long time = System.currentTimeMillis();;
			  for(i=0;x1>=x;x++){
				  y = Integer.parseInt(Pos1Arr[1]);
				  for(j=0;y1>=y;y++){
					  z = Integer.parseInt(Pos1Arr[2]);
					  for(k=0;z1>=z;z++){
						  Location Loc1 = new Location(Bukkit.getWorld("world"), x, y, z);
						  Location toLoc = new Location(Bukkit.getWorld("world"), tox+i, toy+j, toz+k);
						  current = Loc1.getBlock().getType();
						  data = Loc1.getBlock().getData();
						  toBlock = toLoc.getBlock().getType();						  
						  if(current != toBlock){
							  toLoc.getBlock().setType(current);
							  if(toLoc.getBlock().getData()!=data){
								  toLoc.getBlock().setData(data);
								  }
							  c++;
						  }
						  if(toLoc.getBlock().getData()!=data){
							  toLoc.getBlock().setData(data);
							  c++;
						  }
				  		  k++;
					  }
					  j++;
			  	  }
				  i++;
			  }
			  long time2 = System.currentTimeMillis();
			  getLogger().info("Done! Took " + (time2-time) + " milliseconds for " + c + " blocks!");
		  }else{ 
			  Bukkit.getServer().broadcastMessage(prefix + ChatColor.RED + "Something went wrong! ErrorCode: A1-001: The coords in the config.yml are not the same size!");
		  }
	}
	
	public void startGame(){
		currentPlaytimeSeconds = 0;
		currentPlaytimeMinutes = 0;
		  new BukkitRunnable(){				  
			  public int Countdown = 15;				  
			  
			  
			@Override
			public void run() {	
					if(Countdown == 15){
						gameCancelled = false;
						gameStopping = false;
					}
					if(Countdown > 0){							
						for(Player player: inGame.keySet()){
						player.sendMessage(prefix + "§eGame starts in §c" + Integer.toString(Countdown));
							if(Countdown<6 || Countdown == 10){
								player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 10.3F);
							}
						}
						Countdown -= 1;
					}			  	
					else if(Countdown == 0){
						Countdown -=1;
						spawnChests();
						spawnMidChests();
						for(Player player: inGame.keySet()){
							dropCage(player);
							player.sendMessage(prefix + "§eThe game has started!");
							player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.0F, 16.5F);
							player.setHealth(20);
							player.setFoodLevel(20);
							player.closeInventory();
							kits.getKit(player);
						}
						gameRunning = true;
						this.cancel();
						gameStarting = false;
					}
				    if(gameCancelled == true){
				    	gameCancelled = false;
				    	gameRunning = false;
				    	this.cancel();
				    }
				}	
			
			  
		  }.runTaskTimer(plugin, 0L, 20L);
	  }

	public void removeItems(){
		int tox,toy,toz,tox1,toy1,toz1;			
		String[] toPosArr = copyToPos.split(",");
		String[] toPos2Arr = copyToPos2.split(",");
		tox = Integer.parseInt(toPosArr[0]);
		toy = Integer.parseInt(toPosArr[1]);
		toz = Integer.parseInt(toPosArr[2]);
		tox1 = Integer.parseInt(toPos2Arr[0]);
		toy1 = Integer.parseInt(toPos2Arr[1]);
		toz1 = Integer.parseInt(toPos2Arr[2]);
		int dX = (tox1- tox)/2;
		int dY = (toy1 - toy)/2;
		int dZ = (toz1 - toz)/2;
		Location loc = new Location(Bukkit.getWorld("world"), dX+tox, dY+toy, dZ+toz);;	
	    for (org.bukkit.entity.Entity entity : loc.getWorld().getNearbyEntities(loc, dX+5, dY+5, dZ+5))  {
	        if (entity instanceof Item) {
	            entity.remove();
	        }
	    }
	}
	
	public void resetGame(){
		copyBlocks();
		currentPlaytimeSeconds = 0;
		currentPlaytimeMinutes = 0;
		players = 0;
		gameStopping = false;
		gameStarting = false;
		gameRunning = false;
		for(Player player: inGame.keySet()){
			player.setGameMode(GameMode.ADVENTURE);
			player.setHealth(20);
			player.setFoodLevel(20);
			toLobby(player);
			playerConfig = getPlayerConfig(player);
			int plays = playerConfig.getInt("player.common.plays");
			plays++;
			playerConfig.set("player.common.plays", plays);
			int losses = playerConfig.getInt("player.common.losses");
			losses++;
			playerConfig.set("player.common.losses", losses);
			achievements.testAchievementStat(player);
			savePlayerConfig(player);
			player.getInventory().clear();
			player.getInventory().setHelmet(new ItemStack(Material.AIR, 1));
			player.getInventory().setChestplate(new ItemStack(Material.AIR, 1));
			player.getInventory().setLeggings(new ItemStack(Material.AIR, 1));
			player.getInventory().setBoots(new ItemStack(Material.AIR, 1));
			org.bukkit.scoreboard.Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
			player.setScoreboard(board);
		}
		alive.clear();
		inGame.clear();
		cCoins.clear();
		chestsFound.clear();
		islands.clear();
		removeItems();
	}
	
	public void spawnLegendaryChest(Player player){
		Location loc = player.getLocation();
		int x = loc.getBlockX();
		int y = loc.getBlockY();
		int z = loc.getBlockZ();
		loc.getBlock().setType(Material.CHEST);
		chests.fillChestLegendary(x, y, z);
	}
	
	@SuppressWarnings("deprecation")
	public void spawnMidChests(){
		int x,y,z,face;
		String r = null;
		String testIsland = config.getString("game.island.mid");
		if(testIsland!=null){		
		for(int j=1;;j++){
			String configCoords = config.getString("game.island.mid.chests." + j);
			if(configCoords == null){
				break;
			}
			String [] coords = configCoords.split(",");
			x = Integer.parseInt(coords[0]);
			y = Integer.parseInt(coords[1]);
			z = Integer.parseInt(coords[2]);
			if(coords.length > 3){
			r = coords[3];
			}
			switch(r){
			case "north":
				face=2;
				break;
			case "east":
				face=5;
				break;
			case "south":
				face=3;
				break;
			case "west":
				face=4;
				break;
			default:
				face=2;
			}
			Location Loc1 = new Location(Bukkit.getWorld("world"), x, y, z);
			Loc1.getBlock().setType(Material.CHEST);
			Loc1.getBlock().setData((byte) face);
			typeChestMid(x,y,z);
		}
		}
	}
	
	public void typeChestMid(int x, int y, int z){
		Random rand = new Random();
		int lootType = rand.nextInt((100 - 1) + 1) + 1;
		if(lootType>=90){
			chests.fillChestLegendary(x,y,z);
		}
		else if(lootType >= 60){
			chests.fillChestEpic(x,y,z);
		}
		else{
			chests.fillChestRare(x,y,z);
		}
	}
	
	@SuppressWarnings("deprecation")
	public void spawnChests(){
		int i=1, x,y,z,face;
		String r = null;
		while(true){
			String testIsland = customConfig.getString("game.island." + i);
			if(testIsland==null){
				break;
			}
			for(int j=1;;j++){
				String configCoords = customConfig.getString("game.island." + i + ".chests." + j);
				if(configCoords == null){
					break;
				}
				String [] coords = configCoords.split(",");
				x = Integer.parseInt(coords[0]);
				y = Integer.parseInt(coords[1]);
				z = Integer.parseInt(coords[2]);
				if(coords.length > 3){
				r = coords[3];
				}
				switch(r){
				default:
				case "north":
					face=2;
					break;
				case "east":
					face=5;
					break;
				case "south":
					face=3;
					break;
				case "west":
					face=4;				
				}
				Location Loc1 = new Location(Bukkit.getWorld("world"), x, y, z);
				Loc1.getBlock().setType(Material.CHEST);
				Loc1.getBlock().setData((byte) face);				
				typeChest(x,y,z);
			}
			i++;
		}
	}
	
	public void typeChest(int x, int y, int z){
		Random rand = new Random();
		int lootType = rand.nextInt((100 - 1) + 1) + 1;
		if(lootType==100){
			chests.fillChestLegendary(x,y,z);
		}
		else if(lootType >= 95){
			chests.fillChestEpic(x,y,z);
		}
		else if(lootType >= 65){
			chests.fillChestRare(x,y,z);
		}
		else{
			chests.fillChestCommon(x,y,z);
		}
	}
	
	public void joinPlayerGame(Player player){
		if(gameRunning == false){
    		if(!inGame.containsKey(player) && players<maxPlayers){    			
    			inGame.put(player, 0);
        		cCoins.put(player, 0);
        		alive.put(player, 1);
        		for(Player p2: inGame.keySet()){
    				p2.sendMessage(prefix + ChatColor.DARK_AQUA + player.getName() + ChatColor.YELLOW + " Joined the game!");
    			}
        		players++; //count our current players
        		updateScoreboard();
        		player.setGameMode(GameMode.SURVIVAL);
        		int i;
        		for(i=1;i<=maxPlayers;i++){
        			if(islands.containsValue(i)){
        				continue;
        			}
        			islands.put(player, i);
        			break;
        		}
        		
    	        spawn = customConfig.getString("game.island."+ i + ".spawnlocation");
        		if(spawn == null){
          			Bukkit.getServer().broadcastMessage(prefix + ChatColor.RED + "The config isnt set up correctly!");
          			Bukkit.getServer().broadcastMessage(prefix + ChatColor.RED + "Could not find a spawnpoint for island " + i);
            	}
          		else{//teleport player to arena
      			  double x,y,z, maxX, minX, maxY, minY, maxZ, minZ;
      			  float r,q;
      			  String[] RespawnArr = spawn.split(",");
      			  x = Integer.parseInt(RespawnArr[0]) +0.5;
      			  y = Integer.parseInt(RespawnArr[1]);
      			  z = Integer.parseInt(RespawnArr[2]) +0.5;
      			  r = (float) Float.parseFloat(RespawnArr[3]);
      			  q = (float) Float.parseFloat(RespawnArr[4]);
      			  String[] toPosArr = copyToPos.split(",");
      			  String[] toPos2Arr = copyToPos2.split(",");
      			  minX = Integer.parseInt(toPosArr[0]);
      			  minY = Integer.parseInt(toPosArr[1]);
      			  minZ = Integer.parseInt(toPosArr[2]);
      			  maxX = Integer.parseInt(toPos2Arr[0]);
      			  maxY = Integer.parseInt(toPos2Arr[1]);
      			  maxZ = Integer.parseInt(toPos2Arr[2]);	
      			  if( (x>maxX||x<minX) || (y>maxY||y<minY) || (z>maxZ||z<minZ) ){
      				  Bukkit.broadcastMessage(prefix + ChatColor.RED + "The config isn't set up correctly!");
      				Bukkit.broadcastMessage(prefix + ChatColor.RED + "The spawnpoint for island " + players + " is not within the playing field!");
      				  return;
      			  }
      			  cages.getPlayerCageType(player, (int) x, (int) y, (int)z);
      			  Location Resp = new Location(Bukkit.getWorld("world"), x, y, z, r, q);      			  
      			  player.teleport(Resp);
      			  player.setHealth(20);
      			  player.setFoodLevel(20);
      			  player.setSaturation(20);
      			  player.getInventory().clear();
      			  player.getInventory().setHelmet(new ItemStack(Material.AIR, 1));
    			  player.getInventory().setChestplate(new ItemStack(Material.AIR, 1));
    		      player.getInventory().setLeggings(new ItemStack(Material.AIR, 1));
    			  player.getInventory().setBoots(new ItemStack(Material.AIR, 1));
      			  ItemStack skywarsKitSelector = new ItemStack(Material.BOW, 1);
  		          ItemMeta MetaskywarsKitSelector = skywarsKitSelector.getItemMeta();
  		          MetaskywarsKitSelector.setDisplayName("§6Kit Selector");
  		          skywarsKitSelector.setItemMeta(MetaskywarsKitSelector);
  		          player.getInventory().addItem(skywarsKitSelector);  		      
          		 }
    		} 
    		else{ //player is in inGames hashmap already
    			player.sendMessage(prefix + ChatColor.RED + " You're already in the game, or the game is full!");
    		}
		}
		else{//gamerunning != false
			player.sendMessage(prefix + ChatColor.RED + " The game has already started, try again when it ends!");
		}
	}
	
	public void dropCage(Player player){
		 int q = islands.get(player);
		 String qa = customConfig.getString("game.island." + q + ".spawnlocation");
		 String[] loc = qa.split(",");
		 int x = Integer.parseInt(loc[0]);
		 int y = Integer.parseInt(loc[1]);
		 int z = Integer.parseInt(loc[2]);
		Location low = new Location(Bukkit.getWorld("world"), x, y-1, z);
		low.getBlock().setType(Material.AIR);
		for(int i=0; i<5; i++){
			low.setX(x+1);
			low.getBlock().setType(Material.AIR);
			low.setZ(z+1);
			low.getBlock().setType(Material.AIR);
			low.setZ(z-1);
			low.getBlock().setType(Material.AIR);
			low.setZ(z);
			low.setX(x-1);
			low.getBlock().setType(Material.AIR);
			low.setZ(z+1);
			low.getBlock().setType(Material.AIR);
			low.setZ(z-1);
			low.getBlock().setType(Material.AIR);
			low.setX(x);
			low.getBlock().setType(Material.AIR);
			low.setZ(z+1);
			low.getBlock().setType(Material.AIR);
			low.setX(x);
			low.setZ(z);
			low.setY(y+i);
		}
		islands.remove(player);
	}
	
	public void gameEnd(Player player){
		gameStopping = true;
		for(Player p2: inGame.keySet()){
		  p2.sendMessage(" ");
		  p2.sendMessage(prefix + "§6" + "===========================");	
		  p2.sendMessage(prefix + ChatColor.DARK_AQUA + player.getName() + " §ehas won the game!");
		  p2.sendMessage(prefix + "§6" + "===========================");
		  p2.sendMessage(" ");
		}
		for(Player p2: alive.keySet()){
			p2.sendMessage(prefix + ChatColor.GOLD + "(+" + coinsOnWin + " coins!)");
		}
		playerConfig = getPlayerConfig(player);
		int plays = playerConfig.getInt("player.common.plays");
		plays++;
		playerConfig.set("player.common.plays", plays);
		int coins = playerConfig.getInt("player.common.coins");
		coins+=coinsOnWin;
		playerConfig.set("player.common.coins", coins);
		int wins = playerConfig.getInt("player.common.wins");
		wins++;
		playerConfig.set("player.common.wins", wins);
		savePlayerConfig(player);
		achievements.testAchievementStat(player);
		org.bukkit.scoreboard.Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();		
		
		  new BukkitRunnable(){
			  public int Loops = 0;
			  
			@Override
			public void run() {		
				    if(Loops < 5){
				    	final Location loc = player.getEyeLocation();
				    	final Firework f = loc.getWorld().spawn(loc, Firework.class);
			            FireworkMeta meta = f.getFireworkMeta();		            
			            meta.setPower(3);
			            meta.addEffect(FireworkEffect.builder().flicker(true).with(Type.BALL).trail(true).withColor(Color.RED).build());
			            f.setFireworkMeta(meta);										 
					}			  	
					else if(Loops > 8){
						player.setScoreboard(board);
						player.getInventory().clear();
						player.getInventory().setHelmet(new ItemStack(Material.AIR, 1));
						player.getInventory().setChestplate(new ItemStack(Material.AIR, 1));
						player.getInventory().setLeggings(new ItemStack(Material.AIR, 1));
						player.getInventory().setBoots(new ItemStack(Material.AIR, 1));
						player.setGameMode(GameMode.ADVENTURE);
						inGame.remove(player);
						toLobby(player);
						resetGame();
						this.cancel();
					}
				    Loops++;	
				}			  
		  }.runTaskTimer(plugin, 0L, 20L);	
	  }
	
	public void toLobby(Player player){
		  if(lobby == null){
			  getServer().broadcastMessage(prefix + ChatColor.RED + " The config file is not set up correctly! Look at the respawn code in your config again!");  
		  }
		  else{
			  double x,y,z;
			  float r,q;
			  String[] lobbyArr = lobby.split(",");
			  x = Integer.parseInt(lobbyArr[0]) + 0.5;
			  y = Integer.parseInt(lobbyArr[1]);
			  z = Integer.parseInt(lobbyArr[2]) + 0.5;
			  r = (float) Float.parseFloat(lobbyArr[3]);
			  q = (float) Float.parseFloat(lobbyArr[4]);
			  Location lobbyS = new Location(Bukkit.getWorld("world"), x, y, z, r, q);
			  player.teleport(lobbyS);
		  }
	 }
	
	public void updateScoreboard(){

		for(Player player : inGame.keySet()){
		  org.bukkit.scoreboard.Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		  final Objective o = board.registerNewObjective("§4SkyWars", "dummy");
		    o.setDisplaySlot(DisplaySlot.SIDEBAR);
		    Score scoreTop, scoreTime, score2, score3, score4, score6, score8;
		    scoreTop = o.getScore("          ");
		    scoreTop.setScore(12);
		    scoreTime = o.getScore("§eTime:§6 " + String.format("%02d", currentPlaytimeMinutes) + ":" + String.format("%02d", currentPlaytimeSeconds));
		    scoreTime.setScore(11);
			score2 = o.getScore("       ");
			score2.setScore(9);
			score3 = o.getScore("§ePlayers left: §6" + players);
			score3.setScore(8);
			score4 = o.getScore("      ");
			score4.setScore(7);
			score6 = o.getScore("    ");
			score6.setScore(5);
			score8 = o.getScore("   ");
			score8.setScore(3);
					Score score5 = o.getScore("§eKills:§6 " + inGame.get(player));
					score5.setScore(6);
					Score score7 = o.getScore("§eCoins:§6 " + cCoins.get(player));
					score7.setScore(4);
					player.setScoreboard(board);
			}
	}
	
	public void setTemplate(){
		 int x,y,z,x1,y1,z1;
		  String[] Pos1Arr = copyPos1.split(",");
		  String[] Pos2Arr = copyPos2.split(",");
		  x = Integer.parseInt(Pos1Arr[0]);
		  y = Integer.parseInt(Pos1Arr[1]);
		  z = Integer.parseInt(Pos1Arr[2]);
		  x1 = Integer.parseInt(Pos2Arr[0]);
		  y1 = Integer.parseInt(Pos2Arr[1]);
		  z1 = Integer.parseInt(Pos2Arr[2]);
		  if(x>x1){
			  int q = x;
			  x = x1;
			  x1 = q;
		  }
		  if(y>y1){
			  int q=y;
			  y=y1;
			  y1=q;
		  }
		  if(z>z1){
			  int q=z;
			  z=z1;
			  z1=q;
		  }
		  String loc1 = new String(x + "," + y + "," + z);
		  String loc2 = new String(x1+ "," + y1 + "," + z1);
		  customConfig.set("copyloc1", loc1);
		  customConfig.set("copyloc2", loc2);
		  saveCustomConfig();
		  reload();
		  
	}
	
	public void timer(){
		  new BukkitRunnable() {		            	
	      		
	      	@Override
	          public void run(){
	      		if(players >= startOnPlayers && gameStarting == false && gameRunning == false){
	      			gameStarting = true;
	      			startGame();
	      			
	      		}
	      		if(gameRunning == true){
	      			currentPlaytimeSeconds++;
	      			if(currentPlaytimeSeconds >= 60){
	      				currentPlaytimeSeconds = 0;
	      				currentPlaytimeMinutes++;
	      			}
	      			updateScoreboard();
	      		}
	      		if((currentPlaytimeMinutes == 5 && currentPlaytimeSeconds == 0) ||
	      		   (currentPlaytimeMinutes == 10 && currentPlaytimeSeconds == 0) ||
	      		   (currentPlaytimeMinutes == 15 && currentPlaytimeSeconds == 0)
	      		   ){
	      			for(Player player: inGame.keySet()){
	      				player.sendMessage(prefix + ChatColor.RED + "Chests have refilled!");
	      				player.playSound(player.getLocation(), Sound.CHEST_OPEN, 1, 1);
	      			}
	      			chestsFound.clear();
	      			spawnChests();
	      			spawnMidChests();
	      		}
	      		if(players==1 && gameRunning == true && gameStopping == false){
	      			for(Player player: alive.keySet()){
	      				gameEnd(player);
	      			}
	      		}
	      	}
	      	
	      }.runTaskTimer(plugin ,0L ,20L); 
			  
		  }
	
	public void setCustomConfigIslands(){
		for(int i =1;;i++){
			if(config.getString("game.island." + i + ".chests.1")==null){
				break;
			}
			customConfig.set("game.island." + i + ".spawnlocation", config.getString("game.island." + i + ".spawnlocation"));
			for(int j = 1;;j++){
				String island = config.getString("game.island." + i + ".chests." + j);
				if(island == null){
					break;
				}
				String island2 = customConfig.getString("game.island." + i + ".chests." + j);
				if(island2 == null){
					customConfig.set("game.island." + i + ".chests." + j, island);
				}
			}
		}
		for(int j = 1;;j++){
			String island = config.getString("game.island.mid.chests." + j);
			if(island == null){
				break;
			}
			String island2 = customConfig.getString("game.island.mid.chests." + j);
			if(island2 == null){
				customConfig.set("game.island.mid.chests." + j, island);
			}
		}
		saveCustomConfig();
		
	}
	
	public void checkChestsIslands(int island, int chest){
		while(true){
			String string = customConfig.getString("game.island." + island + ".chests." + (chest+1));
			if(string==null){
				break;			
			}
			customConfig.set("game.island." + island + ".chests." + chest, string);
			customConfig.set("game.island." + island + ".chests." + (chest+1), null);
			chest++;
		}
	}
	
	public void checkIslands(int island){
		while(true){
			String string = customConfig.getString("game.island." + (island+1) + ".spawnlocation");
			if(string==null){
				break;			
			}
			customConfig.set("game.island." + (island) + ".spawnlocation", customConfig.getString("game.island." + (island+1) + ".spawnlocation"));
			int chest = 1;
			while(true){
				String string2 = customConfig.getString("game.island." + (island+1) + ".chests." + chest);
				if(string2 == null){
					break;
				}
				customConfig.set("game.island." + (island) + ".chests." + chest, string2);
				chest++;
			}
			customConfig.set("game.island." + (island+1), null);
			island++;
		}
	}
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		  if(cmd.getName().equalsIgnoreCase("SkyWars") || cmd.getName().equalsIgnoreCase("skywars")){
			  if(sender instanceof Player){
				  Player player = (Player) sender;
				  if(args.length > 0){
//RELOAD command
					  if(args[0].equalsIgnoreCase("reload")){
						  if(player.hasPermission("SkyWars.reload")){
							  reload();
							  player.sendMessage(prefix + "§aconfig reloaded!");
						  }						 
						  else{
							  player.sendMessage(prefix + ChatColor.RED +  "You do not have permission to reload this plugin!");
						  }
					  }
//ISLAND command
					  else if(args[0].equalsIgnoreCase("island")){
						  if(player.hasPermission("SkyWars.island")){
							  if(args.length > 1){
								  player.sendMessage(prefix + ChatColor.GOLD + "stats for island " + args[1]);
								  player.sendMessage(prefix + ChatColor.YELLOW + "spawnpoint: " + customConfig.getString("game.island." + args[1] + ".spawnlocation"));
								  for(int i = 1;;i++){
									  String string = customConfig.getString("game.island." + args[1] + ".chests." + i);
									  if(string==null){
										  break;
									  }
									  player.sendMessage(prefix + ChatColor.YELLOW + "chest " + i + " " + string);
								  }
							  }
							  else{
								  player.sendMessage(prefix + ChatColor.RED + "Wrong syntax! Use /skywars set help for help!");
							  }
						  }
						  else{
							  player.sendMessage(prefix + ChatColor.RED + "You do not have permission to do this!"); 
						  }
					  }
//SET command
					  else if(args[0].equalsIgnoreCase("set")){
						  if(args.length > 4){							  
								  if(args[1].equalsIgnoreCase("templatepoint1")){
									  if(player.hasPermission("SkyWars.set.template")){
									  customConfig.set("useconfigislands", false);
									  String copyloc1 = new String(args[2] + "," + args[3] + "," + args[4]);
									  customConfig.set("copyloc1", copyloc1);
									  saveCustomConfig();
									  reload();
									  setTemplate();
									  player.sendMessage(prefix + ChatColor.GREEN + "Changed the first template point to: " + args[2] + " " + args[3] + " " + args[4]);
									  }
									  else{
										  player.sendMessage(prefix + ChatColor.RED + "You do not have permission to do this!");
									  }
								  }
								  else if(args[1].equalsIgnoreCase("templatepoint2")){
									  if(player.hasPermission("SkyWars.set.template")){
									  String copyloc2 = new String(args[2] + "," + args[3] + "," + args[4]);
									  customConfig.set("copyloc2", copyloc2);
									  customConfig.set("useconfigislands", false);
									  saveCustomConfig();
									  reload();
									  setTemplate();
									  player.sendMessage(prefix + ChatColor.GREEN + "Changed the second template point to: " + args[2] + " " + args[3] + " " + args[4]);
									  }
									  else{
										  player.sendMessage(prefix + ChatColor.RED + "You do not have permission to do this!");
									  }
								  }
								  else if(args[1].equalsIgnoreCase("arena")){
									  if(player.hasPermission("SkyWars.set.arena")){
									  customConfig.set("useconfigislands", false);
									  String copytoloc1 = new String(args[2] + "," + args[3] + "," + args[4]);
									  int x,y,z,x1,y1,z1;
									  setTemplate();
									  String[] Pos1Arr = copyPos1.split(",");
									  String[] Pos2Arr = copyPos2.split(",");
									  x = Integer.parseInt(Pos1Arr[0]);
									  y = Integer.parseInt(Pos1Arr[1]);
									  z = Integer.parseInt(Pos1Arr[2]);
									  x1 = Integer.parseInt(Pos2Arr[0]);
									  y1 = Integer.parseInt(Pos2Arr[1]);
									  z1 = Integer.parseInt(Pos2Arr[2]);
									  int dx = x1-x;
									  int dy = y1-y;
									  int dz = z1-z;
									  int newdx = Integer.parseInt(args[2])+dx, newdy = Integer.parseInt(args[3])+dy, newdz = Integer.parseInt(args[4])+dz;
									  String copytoloc2 = new String(newdx + "," + newdy + "," + newdz);
									  customConfig.set("copytoloc1", copytoloc1);
									  customConfig.set("copytoloc2", copytoloc2);
									  saveCustomConfig();
									  reload();									 
									  player.sendMessage(prefix + ChatColor.YELLOW + "Set the arena from block" + ChatColor.GOLD + args[2] + "," + args[3] + "," + args[4] + ChatColor.YELLOW +  " to block " + ChatColor.GOLD + newdx + "," + newdy + "," + newdz );
									  }
									  else{
										  player.sendMessage(prefix + ChatColor.RED + "You do not have permission to do this!");
									  }
								  }
								  else if(args[1].equalsIgnoreCase("island")){
									  
								  }
								  else{
									  player.sendMessage(prefix + ChatColor.RED + "Wrong syntax! Use /skywars set help for help!");
								  }
						  }
						  if(args.length > 3){
							  if(args[1].equalsIgnoreCase("island")){
								  if(player.hasPermission("SkyWars.set.island")){
									  if(args[3].equalsIgnoreCase("spawnpoint") || args[3].equalsIgnoreCase("spawn")){
										  customConfig.set("useconfigislands", false);
										  Location loc = player.getLocation();
										  int x = (int) loc.getX();
										  int y = (int) loc.getY();
										  int z = (int) loc.getZ();
										  String string = new String(x + "," + y + "," + z);
										  customConfig.set("game.island." + args[2] + ".spawnlocation", string);
										  saveCustomConfig();
										  player.sendMessage(prefix + ChatColor.GREEN + "set the spawnpoint for island " + args[2] + " to: " + string);
										  reload();
									  }
									  else if(args[3].equalsIgnoreCase("chest")){
										  customConfig.set("useconfigislands", false);
										  Location loc = player.getLocation();
										  int x = (int) loc.getX();
										  int y = (int) loc.getY();
										  int z = (int) loc.getZ();
										  String string;
										  if(args.length>4){
											  string = new String(x + "," + y + "," + z + "," + args[4]);
										  }else{
											  string = new String(x + "," + y + "," + z + ",east");
										  }
										  for(int i = 1;;i++){
											  String temp = customConfig.getString("game.island." + args[2] + ".chests." + i);
											  if(temp==null){
												  customConfig.set("game.island." + args[2] + ".chests." + i, string);
												  saveCustomConfig();
												  reload();
												  player.sendMessage(prefix + ChatColor.GREEN + "set chest " + i + " at coords " + string + " for island: " + args[2]);
												  break;
											  }
											  
										  }
									  }
									  else{
										  player.sendMessage(prefix + ChatColor.RED + "Wrong syntax! Use /skywars set help for help!");
									  }
								  }
								  else{
									  player.sendMessage(prefix + ChatColor.RED + "You do not have permission to do this!");
								  }
							  }
							  else{
								  player.sendMessage(prefix + ChatColor.RED + "Wrong syntax! Use /skywars set help for help!");
							  }
						  }
						  else if(args.length > 2){
							  if(args[1].equalsIgnoreCase("prefix")){
								  if(player.hasPermission("SkyWars.set.prefix")){
									  customConfig.set("prefix", args[2]);
									  saveCustomConfig();
									  reload();
									  player.sendMessage(prefix + ChatColor.GREEN + "Updated prefix!");
								  }
								  else{
									  player.sendMessage(prefix + ChatColor.RED + "You do not have permission to do this!");
								  }
							  }
							  else if(args[1].equalsIgnoreCase("coinsonwin")){
								  if(player.hasPermission("SkyWars.set.coinsonwin")){
									  customConfig.set("coinsonwin", args[2]);
									  saveCustomConfig();
									  reload();
									  player.sendMessage(prefix + ChatColor.GREEN + "Updated coins on win to " + ChatColor.GOLD + args[2]);
								  }
								  else{
									  player.sendMessage(prefix + ChatColor.RED + "You do not have permission to do this!");
								  } 
							  }
							  else if(args[1].equalsIgnoreCase("coinsonkill")){
								  if(player.hasPermission("SkyWars.set.coinsonkill")){
									  customConfig.set("coinsonkill", args[2]);
									  saveCustomConfig();
									  reload();
									  player.sendMessage(prefix + ChatColor.GREEN + "Updated coins on kill to " + ChatColor.GOLD + args[2]);
								  }
								  else{
									  player.sendMessage(prefix + ChatColor.RED + "You do not have permission to do this!");
								  } 
							  }
							  else if(args[1].equalsIgnoreCase("maxplayers")){
								  if(player.hasPermission("SkyWars.set.maxplayers")){
									  customConfig.set("maxplayers", args[2]);
									  saveCustomConfig();
									  reload();
									  player.sendMessage(prefix + ChatColor.GREEN + "Updated maxplayers to " + ChatColor.GOLD + args[2]);
								  }
								  else{
									  player.sendMessage(prefix + ChatColor.RED + "You do not have permission to do this!");
								  }
							  }
							  else if(args[1].equalsIgnoreCase("startonplayers")){
								  if(player.hasPermission("SkyWars.set.startonplayers")){
									  customConfig.set("startonplayers", args[2]);
									  saveCustomConfig();
									  reload();
									  player.sendMessage(prefix + ChatColor.GREEN + "The game will now automatically start on " + ChatColor.GOLD + args[2] + ChatColor.GREEN + " players.");
								  }
								  else{
									  player.sendMessage(prefix + ChatColor.RED + "You do not have permission to do this!");
								  }
							  }
							  else{
								  player.sendMessage(prefix + ChatColor.RED + "Wrong syntax! Use /skywars set help for help!");
							  }
						  }
						  else if(args.length > 1){
							  if(args[1].equalsIgnoreCase("help")){
								  player.sendMessage(ChatColor.GOLD + "--=====SkyWars Set Help=====--");
								  player.sendMessage(ChatColor.YELLOW + "/SkyWars set arena [x] [y] [z]:" + ChatColor.WHITE + " Will set the lowest corner of the arena to x,y,z");
								  player.sendMessage(ChatColor.YELLOW + "/SkyWars set coinsonkill [#]:" + ChatColor.WHITE + " Set the coins for a kill.");
								  player.sendMessage(ChatColor.YELLOW + "/SkyWars set coinsonwin [#]:" + ChatColor.WHITE + " Set the coins for a win.");
								  player.sendMessage(ChatColor.YELLOW + "/SkyWars set help:" + ChatColor.WHITE + " This command.");
								  player.sendMessage(ChatColor.YELLOW + "/SkyWars set lobby:" + ChatColor.WHITE + " Set the spawnpoint of the lobby to your position");
								  player.sendMessage(ChatColor.YELLOW + "/SkyWars set maxplayers [#]:" + ChatColor.WHITE + " Set the maximum players.");
								  player.sendMessage(ChatColor.YELLOW + "/SkyWars set prefix [prefix]:" + ChatColor.WHITE + " Set the plugin prefix.");
								  player.sendMessage(ChatColor.YELLOW + "/SkyWars set startonplayers [#]:" + ChatColor.WHITE + " Set the amount of palyers the game will automatically start.");
								  player.sendMessage(ChatColor.YELLOW + "/SkyWars set templatePoint1 [x] [y] [z]:" + ChatColor.WHITE + " Set the first  template point to x,y,z");
								  player.sendMessage(ChatColor.YELLOW + "/SkyWars set templatePoint2 [x] [y] [z]:" + ChatColor.WHITE + " Set the second template point to x,y,z");
								  player.sendMessage(ChatColor.GOLD + "--===========================--");
							  
							  }
							  else if(args[1].equalsIgnoreCase("lobby")){
								  if(player.hasPermission("SkyWars.set.lobby")){
									  Location loc = player.getLocation();
									  int x = (int) loc.getX();
									  int y = (int) loc.getY();
									  int z = (int) loc.getZ();
									  int yaw = (int) loc.getYaw();
									  int pitch = (int) loc.getPitch();
									  String string = new String(x + "," + y + "," + z + "," + yaw + "," + pitch);
									  customConfig.set("lobby", string);
									  saveCustomConfig();
									  reload();
									  player.sendMessage(prefix + ChatColor.GREEN + " Set the lobby to your position!");
								  }
								  else{
									  player.sendMessage(prefix + ChatColor.RED + "You do not have permission to do this!");									  
								  }
							  }
							  else{
								  player.sendMessage(prefix + ChatColor.RED + "Wrong syntax! Use /skywars set help for help!");
							  }
						  }
						  else{
							  player.sendMessage(prefix + ChatColor.RED + "Wrong syntax! Use /skywars set help for help!");
						  }
					  }
//REMOVE command
					  else if(args[0].equalsIgnoreCase("remove")){
						  if(args.length > 4){
							  if(args[1].equalsIgnoreCase("island")){
								  if(player.hasPermission("SkyWars.island")){
									  if(args[3].equalsIgnoreCase("chest")){
										  customConfig.set("game.island." + args[2] + ".chests." + args[4], null);
										  checkChestsIslands(Integer.parseInt(args[2]), Integer.parseInt(args[4]));
										  customConfig.set("useconfigislands", false);
										  saveCustomConfig();
										  reload();
										  player.sendMessage(prefix + ChatColor.GREEN + " removed chest #" + args[4] + " for island " + args[2]);
									  }
								  }
								  else{
									  player.sendMessage(prefix + ChatColor.RED + "You do not have permission to do this!");
								  }
							  }
							  else{
								  player.sendMessage(prefix + ChatColor.RED + "Wrong syntax! Use /skywars remove help for help!");
							  }
						  }
						  else if(args.length > 3){
							  if(args[1].equalsIgnoreCase("island")){
								  if(args[3].equalsIgnoreCase("all")){
									  if(player.hasPermission("SkyWars.island")){
										  customConfig.set("game.island." + args[2], null);
										  checkIslands(Integer.parseInt(args[2]));
										  saveCustomConfig();
										  reload();
										  player.sendMessage(prefix + ChatColor.GREEN + " removed island " + args[2]);
									  }
									  else{
										  player.sendMessage(prefix + ChatColor.RED + "You do not have permission to do this!");
									  }
								  }
								  else{
									  player.sendMessage(prefix + ChatColor.RED + "Wrong syntax! Use /skywars remove help for help!");
								  }
							  }
							  else{
								  player.sendMessage(prefix + ChatColor.RED + "Wrong syntax! Use /skywars remove help for help!");
							  }
						  }
						  else if(args.length > 1){
							  if(args[1].equalsIgnoreCase("help")){
								  player.sendMessage(ChatColor.GOLD + "--=====SkyWars Remove Help=====--");
								  player.sendMessage(ChatColor.YELLOW + "/SkyWars remove arena:" + ChatColor.WHITE + " Puts the default config's arena position back.");
								  player.sendMessage(ChatColor.YELLOW + "/SkyWars remove coinsonkill [#]:" + ChatColor.WHITE + " Set the coins for a kill back to the default config's value.");
								  player.sendMessage(ChatColor.YELLOW + "/SkyWars remove coinsonwin [#]:" + ChatColor.WHITE + " Set the coins for a win back to the default config's value.");
								  player.sendMessage(ChatColor.YELLOW + "/SkyWars remove help:" + ChatColor.WHITE + " This command.");
								  player.sendMessage(ChatColor.YELLOW + "/SkyWars remove maxplayers:" + ChatColor.WHITE + " Puts the default config's maximum playercount back.");
								  player.sendMessage(ChatColor.YELLOW + "/SkyWars remove lobby:" + ChatColor.WHITE + " Puts the default config's value for start on playercount back.");
								  player.sendMessage(ChatColor.YELLOW + "/SkyWars remove startonplayers:" + ChatColor.WHITE + " Puts the default config's amount of players for auto-starting games back.");
								  player.sendMessage(ChatColor.YELLOW + "/SkyWars remove templatePoint1:" + ChatColor.WHITE + " Puts the default config's first templatepoint back.");
								  player.sendMessage(ChatColor.YELLOW + "/SkyWars remove templatePoint2:" + ChatColor.WHITE + " Puts the default config's second templatepoint back.");
								  player.sendMessage(ChatColor.GOLD + "--===========================--");
							  }
							  else if(args[1].equalsIgnoreCase("startonplayers")){
								  if(player.hasPermission("SkyWars.remove.startonplayers")){
									  String temp = customConfig.getString("startonplayers");
									  if(temp!=null){
										  customConfig.set("startonplayers", null);
										  saveCustomConfig();
										  reload();
										  player.sendMessage(prefix + ChatColor.GREEN + "changed startonplayers to the default config value.");
									  }
									  else{
										  player.sendMessage(prefix + ChatColor.RED + "There hasnt been a custom value set up through the game!");
									  }
								  }
								  else{
									  player.sendMessage(prefix + ChatColor.RED + "You do not have permission to do this!");
								  }
							  }
							  else if(args[1].equalsIgnoreCase("coinsonwin")){
								  if(player.hasPermission("SkyWars.remove.coinsonwin")){
									  String temp = customConfig.getString("coinsonwin");
									  if(temp!=null){
										  customConfig.set("coinsonwin", null);
										  saveCustomConfig();
										  reload();
										  player.sendMessage(prefix + ChatColor.GREEN + "changed the coins on win to the default config value.");
									  }
									  else{
										  player.sendMessage(prefix + ChatColor.RED + "There hasnt been a custom value set up through the game!");
									  }
								  }
								  else{
									  player.sendMessage(prefix + ChatColor.RED + "You do not have permission to do this!");
								  }
							  }
							  else if(args[1].equalsIgnoreCase("coinsonkill")){
								  if(player.hasPermission("SkyWars.remove.coinsonkill")){
									  String temp = customConfig.getString("coinsonkill");
									  if(temp!=null){
										  customConfig.set("coinsonkill", null);
										  saveCustomConfig();
										  reload();
										  player.sendMessage(prefix + ChatColor.GREEN + "changed the coins on kill to the default config value.");
									  }
									  else{
										  player.sendMessage(prefix + ChatColor.RED + "There hasnt been a custom value set up through the game!");
									  }
								  }
								  else{
									  player.sendMessage(prefix + ChatColor.RED + "You do not have permission to do this!");
								  }
							  }
							  else if(args[1].equalsIgnoreCase("maxplayers")){
								  if(player.hasPermission("SkyWars.remove.maxplayers")){
									  String temp = customConfig.getString("maxplayers");
									  if(temp!=null){
										  customConfig.set("maxplayers", null);
										  saveCustomConfig();
										  reload();
										  player.sendMessage(prefix + ChatColor.GREEN + "changed the max players to the default config value.");
									  }
									  else{
										  player.sendMessage(prefix + ChatColor.RED + "There hasnt been a custom value set up through the game!");
									  }
								  }
								  else{
									  player.sendMessage(prefix + ChatColor.RED + "You do not have permission to do this!");
								  }
							  }
							  else if(args[1].equalsIgnoreCase("prefix")){
								  if(player.hasPermission("SkyWars.remove.prefix")){
									  String temp = customConfig.getString("prefix");
									  if(temp!=null){
										  customConfig.set("prefix", null);
										  saveCustomConfig();
										  reload();
										  player.sendMessage(prefix + ChatColor.GREEN + "changed prefix to the default config value.");
									  }
									  else{
										  player.sendMessage(prefix + ChatColor.RED + "There hasnt been a custom prefix set up through the game!");
									  }
								  }
								  else{
									  player.sendMessage(prefix + ChatColor.RED + "You do not have permission to do this!");
								  }
							  }
							  else if(args[1].equalsIgnoreCase("arena")){
								  if(player.hasPermission("SkyWars.remove.arena")){
									  String temp = customConfig.getString("copytoloc1");
									  if(temp!=null){
										  customConfig.set("copytoloc1", null);
										  customConfig.set("copytoloc2", null);
										  saveCustomConfig();
										  reload();
										  player.sendMessage(prefix + ChatColor.GREEN + "changed lobby spawnpoint to the default config value.");
									  }
									  else{
										  player.sendMessage(prefix + ChatColor.RED + "There hasnt been a custom lobby spawnpoint set up through the game!");
									  } 
								  }
								  else{
									  player.sendMessage(prefix + ChatColor.RED + "You do not have permission to do this!");
								  }
							  }
							  else if(args[1].equalsIgnoreCase("lobby")){
								  if(player.hasPermission("SkyWars.remove.lobby")){
									  String temp = customConfig.getString("lobby");
									  if(temp!=null){
										  customConfig.set("lobby", null);
										  saveCustomConfig();
										  reload();
										  player.sendMessage(prefix + ChatColor.GREEN + "changed lobby spawnpoint to the default config value.");
									  }
									  else{
										  player.sendMessage(prefix + ChatColor.RED + "There hasnt been a custom lobby spawnpoint set up through the game!");
									  }
								  }
								  else{
									  player.sendMessage(prefix + ChatColor.RED + "You do not have permission to do this!");
								  }
							  }
							  else if(args[1].equalsIgnoreCase("templatepoint1")){
								  if(player.hasPermission("SkyWars.remove.template")){
									 String temp = customConfig.getString("copyloc1");
									 if(temp!=null){
										 customConfig.set("copyloc1", null);
										 saveCustomConfig();
										 reload();
										 player.sendMessage(prefix + ChatColor.GREEN + "changed template point 1 to the default config value.");
									 }
									 else{
										 player.sendMessage(prefix + ChatColor.RED + "There hasnt been a custom templatepoint1 set up through the game!");
									 }
								  }
								  else{
									  player.sendMessage(prefix + ChatColor.RED + "You do not have permission to do this!");
								  }
							  }
							  else if(args[1].equalsIgnoreCase("templatepoint2")){
								  if(player.hasPermission("SkyWars.remove.template")){
									  	 String temp = customConfig.getString("copyloc2");
									  	 if(temp!=null){
											 customConfig.set("copyloc2", null);
											 saveCustomConfig();
											 reload();
											 player.sendMessage(prefix + ChatColor.GREEN + "changed template point 2 to the default config value.");
										 }
										 else{
											 player.sendMessage(prefix + ChatColor.RED + "There hasnt been a custom templatepoint2 set up through the game!");
										 }  
								  }
								  else{
									 player.sendMessage(prefix + ChatColor.RED + "You do not have permission to do this!"); 
								  }
							  }
						  }
						  else{
							  player.sendMessage(prefix + ChatColor.RED + "Wrong syntax! Use /skywars remove help for help!");
						  }
					  }
//START command
					  else if(args[0].equalsIgnoreCase("start")){
						  if(player.hasPermission("SkyWars.start")){
							  if(gameStarting == false && gameRunning == false){
								gameStarting = true;
					      		startGame();
							  }else{
								  player.sendMessage(prefix + ChatColor.RED + "A game has already started!");
							  }
						  }else{
							player.sendMessage(prefix + ChatColor.RED + "You do not have permission to start skywars!");  
						  }
					  }
//JOIN/PLAY command
					  else if(args[0].equalsIgnoreCase("join") || args[0].equalsIgnoreCase("play")){
						  if(player.hasPermission("SkyWars.join")){
							  joinPlayerGame(player);
						  }
						  else{
							  player.sendMessage(prefix + ChatColor.RED + "You do not have permission to join a skywars game!");
						  }
					  }
//LEAVE command
					  else if(args[0].equalsIgnoreCase("leave")){
						  if(inGame.containsKey(player)){
							  if(alive.containsKey(player)){
								  playerDies(player);
								  if(player.getLastDamageCause()!=null){
						        		if(player.getLastDamageCause().getCause() == DamageCause.ENTITY_ATTACK){
							    			Player p2 = (Player) ((EntityDamageByEntityEvent) player.getLastDamageCause()).getDamager();
							    			for(Player p3: inGame.keySet()){
												p3.sendMessage(prefix + ChatColor.DARK_AQUA + player.getName() + ChatColor.YELLOW + " Tripped and died while chased by " + ChatColor.DARK_AQUA + p2.getName());
											}	    			
							    			giveKill(p2);
						        		}
						        		else{
						        			for(Player p3: inGame.keySet()){
												p3.sendMessage(prefix + ChatColor.DARK_AQUA + player.getName() + ChatColor.YELLOW + " couldn't handle the pressure!");
											}
						        		}
								  }
								  else{
					        			for(Player p3: inGame.keySet()){
											p3.sendMessage(prefix + ChatColor.DARK_AQUA + player.getName() + ChatColor.YELLOW + " couldn't handle the pressure!");
										}
					        		}
							  }
							playerConfig = getPlayerConfig(player);
							int plays = playerConfig.getInt("player.common.plays");
							plays++;
							playerConfig.set("player.common.plays", plays);
							int wins = playerConfig.getInt("player.common.wins");
							wins++;
							playerConfig.set("player.common.wins", wins);
							savePlayerConfig(player);
							achievements.testAchievementStat(player);
							org.bukkit.scoreboard.Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
							player.setScoreboard(board);
							player.getInventory().clear();
							player.getInventory().setHelmet(new ItemStack(Material.AIR, 1));
							player.getInventory().setChestplate(new ItemStack(Material.AIR, 1));
							player.getInventory().setLeggings(new ItemStack(Material.AIR, 1));
							player.getInventory().setBoots(new ItemStack(Material.AIR, 1));
							player.setGameMode(GameMode.ADVENTURE);
							inGame.remove(player);
							cCoins.remove(player);
							if(gameStarting){
								dropCage(player);
							}
							toLobby(player);
							  
						  }
						  else{
							  player.sendMessage(prefix + ChatColor.RED + "You are not in a game!");
						  }
					  }
//STOP/QUIT command
					  else if(args[0].equalsIgnoreCase("quit") || args[0].equalsIgnoreCase("stop")){
						  if(player.hasPermission("SkyWars.quit")){
							  if(args.length > 1){
								  if(args[1].equalsIgnoreCase("win")){
									  player.sendMessage(prefix + "§cAn admin has stopped this game!");
									  for(Player p2: inGame.keySet()){
									  p2.sendMessage(prefix + "§cAn admin has stopped this game!");
									  }									  
									  if(args.length > 2){
										  for(Player p2: inGame.keySet()){
										  p2.sendMessage(" ");
										  p2.sendMessage(prefix + "§6" + "===========================");	
										  p2.sendMessage(prefix + "§9" + args[2] + " §ehas won the game!");
										  p2.sendMessage(prefix + "§6" + "===========================");
										  p2.sendMessage(" ");
										  }
										  player.sendMessage(" ");
										  player.sendMessage(prefix + "§6" + "===========================");	
										  player.sendMessage(prefix + "§9" + args[2] + " §ehas won the game!");
										  player.sendMessage(prefix + "§6" + "===========================");
										  player.sendMessage(" ");
										  gameRunning = false;
										  resetGame();
									  }else{
										  Player p2 = player;
										  int score2 = 0;
										  for(Player pTemp: inGame.keySet()){
											  int score = inGame.get(player);
											  if(score > score2){
											  p2 = pTemp;
											  }											  
										  }
										  gameEnd(p2);
									  }
								  }else{
									  player.sendMessage(prefix + "§cWrong syntax! Use \"/SkyWars help\" for help!");
								  }
							  }else{
								  for(Player p2: inGame.keySet()){
								  p2.sendMessage(prefix + "§cAn admin has stopped this game!");
								  }
								  player.sendMessage(prefix + "§cAn admin has stopped this game!");
								  resetGame();
							  }
							  gameCancelled = true;
						  }else{
							 player.sendMessage(prefix + "§cYou do not have permission to stop a game!");
						  }
					  }
//VERSION command
					  else if(args[0].equalsIgnoreCase("version")){
						  player.sendMessage(prefix + "§aSkyWars is currently on version §6" + getDescription().getVersion());
					  }
//LOBBY
					  else if(args[0].equalsIgnoreCase("lobby")){
						  if(player.hasPermission("SkyWars.lobby")){
							  toLobby(player);
						  }else{
							  player.sendMessage(prefix + ChatColor.RED + "You dont have permission to use the lobby command!");
						  }
					  }
//usedefaultconfigfile
					  else if(args[0].equalsIgnoreCase("useconfigfile")){
						  if(player.hasPermission("SkyWars.config")){
							  customConfig.set("useconfigislands", true);
						  }
						  else{
							  player.sendMessage(prefix + ChatColor.RED + "You dont have permission to use the lobby command!");
						  }
					  }
//HELP command
					  else if(args[0].equalsIgnoreCase("help")){
						  player.sendMessage(prefix + ChatColor.GOLD + "--=====SkyWars Help=====--");
						  player.sendMessage(prefix + ChatColor.YELLOW + "/SkyWars chest:" + ChatColor.WHITE + " cheats in a legendary chest for you.");
						  player.sendMessage(prefix + ChatColor.YELLOW + "/SkyWars coins:" + ChatColor.WHITE + " use\"/skywars coins help\" for more info.");
						  player.sendMessage(prefix + ChatColor.YELLOW + "/SkyWars debug:" + ChatColor.WHITE + " Don't use this command!");
						  player.sendMessage(prefix + ChatColor.YELLOW + "/SkyWars help:" + ChatColor.WHITE + " This command.");
						  player.sendMessage(prefix + ChatColor.YELLOW + "/SkyWars island #:" + ChatColor.WHITE + " lists the spawnpoint and chests for island #.");
						  player.sendMessage(prefix + ChatColor.YELLOW + "/SkyWars join:" + ChatColor.WHITE + " joins the game.");
						  player.sendMessage(prefix + ChatColor.YELLOW + "/SkyWars killshop:" + ChatColor.WHITE + " Kills all SkyWars villager shops in a radius of 5 blocks.");
						  player.sendMessage(prefix + ChatColor.YELLOW + "/SkyWars lobby:" + ChatColor.WHITE + " teleports you to the lobby");
						  player.sendMessage(prefix + ChatColor.YELLOW + "/SkyWars reload:" + ChatColor.WHITE + " reload the plugin.");
						  player.sendMessage(prefix + ChatColor.YELLOW + "/SkyWars reset:" + ChatColor.WHITE + " resets the arena.");
						  player.sendMessage(prefix + ChatColor.YELLOW + "/SkyWars set:" + ChatColor.WHITE + " used to configure the plugin through in-game. use \"skywars set help\" for more info.");
						  player.sendMessage(prefix + ChatColor.YELLOW + "/SkyWars spawnshop:" + ChatColor.WHITE + " Spawns a villager shop on your position.");
						  player.sendMessage(prefix + ChatColor.YELLOW + "/SkyWars start:" + ChatColor.WHITE + " forces the game to start.");
						  player.sendMessage(prefix + ChatColor.YELLOW + "/SkyWars stats <player>:" + ChatColor.WHITE + " Gets the common stats of <player>.");
						  player.sendMessage(prefix + ChatColor.YELLOW + "/SkyWars stop [win] <player>:" + ChatColor.WHITE + " forces the game to stop, [win] <player> to force a certain player to win.");
						  player.sendMessage(prefix + ChatColor.YELLOW + "/SkyWars useconfigfile:" + ChatColor.WHITE + " uses your config.yml instead of the in-game customized one.");
						  player.sendMessage(prefix + ChatColor.YELLOW + "/SkyWars version:" + ChatColor.WHITE + " Get the current version of the plugin.");
						  player.sendMessage(prefix + ChatColor.GOLD + "--======================--");
					  
					  }
//RESET command
					  else if(args[0].equalsIgnoreCase("reset")){
						  if(player.hasPermission("SkyWars.reset")){
						  resetGame();
						  }
						  else{
							  player.sendMessage(prefix + ChatColor.RED + "You dont have permission to reset the game!");
						  }
					  }
//CHEST command
					  else if(args[0].equalsIgnoreCase("chest")){
						  if(player.hasPermission("SkyWars.spawnchest")){
							  if(inGame.containsKey(player)){
							  for(Player p2: inGame.keySet()){
							  p2.sendMessage(prefix + ChatColor.DARK_AQUA + player.getName() + ChatColor.RED + " Is a big cheater, and spawned a legendary chest!");
							  }
							  spawnLegendaryChest(player);
							  }
							  else{
								  player.sendMessage(prefix + ChatColor.RED + "You are not in a game!");
							  }
						  }
						  else{
							  player.sendMessage(prefix + ChatColor.RED + "You are not allowed to spawn chests!");
						  }
					  }
//DEBUG commands
					  else if(args[0].equalsIgnoreCase("debug")){
						  if(args.length > 1){
							  if(args[1].equalsIgnoreCase("force")){
								  player.sendMessage("running | started | cancelled | stopping " + gameRunning + " | " +  gameStarting + " | " + gameCancelled + " | " + gameStopping);
								  for(Player p2: inGame.keySet()){
									  player.sendMessage("inGame:" + p2 + " value:" + inGame.get(p2));									  
								  }
								  for(Player p2: alive.keySet()){
									  player.sendMessage("alive:" + p2 + " value:" + alive.get(p2));
								  }
								  for(Player p2: cCoins.keySet()){
									  player.sendMessage("cCoins:" + p2 + " value:" + cCoins.get(p2));
								  }
								  for(String chest: chestsFound.keySet()){
									  player.sendMessage("found chest:" + chest);
								  }
								  player.sendMessage("players:" + players + " maxPlayers:" + maxPlayers + " startonplayers" + startOnPlayers);
								  player.sendMessage("coinsonkill:" + coinsOnKill + " Coinsonwin:" + coinsOnWin);
								  player.sendMessage("copy from pos1:" +  copyPos1 + " copy from pos2:" + copyPos2);
								  player.sendMessage("copy to pos1:" + copyToPos +  " copy to pos2:" + copyToPos2);
							  }
						  }
						  else{
							  File file = new File(getDataFolder(), "doNotTouch.yml");
							  if (!file.exists()) {
							        try {
										file.createNewFile();
									} catch (IOException e) {
										e.printStackTrace();
									}
							    }
							    YamlConfiguration configDoNotTouch = YamlConfiguration.loadConfiguration(file);
							  int bugs = configDoNotTouch.getInt("bugcounter");
							  player.sendMessage(prefix + ChatColor.RED + "you have just created bug #" + ChatColor.GOLD + ++bugs);
							  configDoNotTouch.set("bugcounter", bugs);
							  try {
								configDoNotTouch.save(file);
							} catch (IOException e) {
								e.printStackTrace();
							}
						  }
					  }
					  
//STATS command
					  else if(args[0].equals("stats")){
						  if(args.length > 1){
							  if(player.hasPermission("SkyWars.stats")){
								  OfflinePlayer p2 = Bukkit.getOfflinePlayer(args[1]);
								  playerConfig = getPlayerConfig(p2);
								  String temp = playerConfig.getString("player.common.coins");
								  if(temp!=null){
									  int coins = playerConfig.getInt("player.common.coins");
									  int wins = playerConfig.getInt("player.common.wins");
									  int deaths = playerConfig.getInt("player.common.deaths");
									  int plays = playerConfig.getInt("player.common.plays");
									  int losses = playerConfig.getInt("player.common.losses");
									  int kills = playerConfig.getInt("player.common.kills");
									  player.sendMessage(prefix + "§eStats for §b" + p2.getName() + "§e:");
									  player.sendMessage(prefix + "§eCoins:§6 " + coins);
									  player.sendMessage(prefix + "§ePlays:§6 " + plays);
									  player.sendMessage(prefix + "§eWins:§6 " + wins);
									  player.sendMessage(prefix + "§eLosses:§6 " + losses);
									  player.sendMessage(prefix + "§eKills:§6 " + kills);
									  player.sendMessage(prefix + "§eDeaths:§6 " + deaths);
								  }
								  else{
									  player.sendMessage(prefix + ChatColor.RED + "Could not find stats for player: §b" + args[2]);
								  }
							  }
							  else{
								  player.sendMessage(prefix + ChatColor.RED + "You do not have permission to view other people's stats!");
							  }
						  }
						  else{
							  playerConfig = getPlayerConfig(player);
							  int coins = playerConfig.getInt("player.common.coins");
							  int wins = playerConfig.getInt("player.common.wins");
							  int plays = playerConfig.getInt("player.common.plays");
							  int deaths = playerConfig.getInt("player.common.deaths");
							  int losses = playerConfig.getInt("player.common.losses");
							  int kills = playerConfig.getInt("player.common.kills");
							  player.sendMessage(prefix + "§eStats for §b" + player.getName() + "§e:");
							  player.sendMessage(prefix + "§eCoins:§6 " + coins);
							  player.sendMessage(prefix + "§ePlays:§6 " + plays);
							  player.sendMessage(prefix + "§eWins:§6 " + wins);
							  player.sendMessage(prefix + "§eLosses:§6 " + losses);
							  player.sendMessage(prefix + "§eKills:§6 " + kills);
							  player.sendMessage(prefix + "§eDeaths:§6 " + deaths);
						  }
					  }
//SPAWNSHOP command
					  else if(args[0].equalsIgnoreCase("spawnshop")){
						  if(player.hasPermission("SkyWars.spawnshop")){
							  final Location loc = player.getLocation();
							  final Villager villager = loc.getWorld().spawn(loc, Villager.class); 
							  Entity nmsEntity = ((CraftEntity) villager).getHandle();
							    NBTTagCompound tag = nmsEntity.getNBTTag();
							    if (tag == null) {
							        tag = new NBTTagCompound();
							    }
							    nmsEntity.c(tag);
							    tag.setInt("NoAI", 1);
							    tag.setInt("Silent", 1);
							    nmsEntity.f(tag);							    
							    villager.setCustomName("§cSkywars Shop");
							    villager.setCustomNameVisible(true);
						  }
						  else{
							  player.sendMessage(prefix + ChatColor.RED + "You do not have permission to do this!");
						  }
					  }
//KILLSHOP
					  else if(args[0].equalsIgnoreCase("killshop")){
						  if(player.hasPermission("SkyWars.killshop")){
						  for(org.bukkit.entity.Entity e : player.getNearbyEntities(5, 5, 5)){
							  if(e.getType() == EntityType.VILLAGER){
								  if(e.getName().equalsIgnoreCase("§cSkywars Shop")){
									  e.remove();
									  player.sendMessage(prefix + ChatColor.RED + "Removed a Skywars Shop Villager!");
								  }
							  }
					  		}
						  }
						  else{
							  player.sendMessage(prefix + ChatColor.RED + "You do not have permission to do this!");
						  }
					  }
//COINS command
					 else if(args[0].equalsIgnoreCase("coins")){
						  if(args.length > 1){
							  if(args[1].equalsIgnoreCase("help")){
								  player.sendMessage(prefix + ChatColor.GOLD + "--=====SkyWars Coins Help=====--");
								  player.sendMessage(prefix + ChatColor.YELLOW + "/SkyWars coins:" + ChatColor.WHITE + " This command.");
								  player.sendMessage(prefix + ChatColor.YELLOW + "/SkyWars coins add [#] [player]:" + ChatColor.WHITE + " Adds # coins to [player]. Leave empty to add to yourself.");
								  player.sendMessage(prefix + ChatColor.YELLOW + "/SkyWars coins set [#] [player]:" + ChatColor.WHITE + " Adds # coins to [player]. Leave empty to add to yourself.");
								  player.sendMessage(prefix + ChatColor.YELLOW + "/SkyWars coins tricks:" + ChatColor.WHITE + " Display a list of tricks you can use.");
								  player.sendMessage(prefix + ChatColor.GOLD + "--============================--");
							  }
							  else if(args[1].equals("tricks")){
								  player.sendMessage(prefix + ChatColor.GOLD + "--=====SkyWars Tricks=====--");
								  player.sendMessage(prefix + ChatColor.WHITE + "To subtract coins from someone, use the add command with a negative number.");
								  player.sendMessage(prefix + ChatColor.WHITE + "------------------------------");
								  player.sendMessage(prefix + ChatColor.WHITE + "You can use the following substitutes for [player] to adress groups:");
								  player.sendMessage(prefix + ChatColor.WHITE + "\"*online\" to adress all online players.");
								  player.sendMessage(prefix + ChatColor.WHITE + "\"*ingame\" to adress all in-game players.");
								  player.sendMessage(prefix + ChatColor.GOLD + "--========================--");
							   }
							  else if(player.hasPermission("SkyWars.coins")){
								  if(args.length > 2){
									  if(args[1].equalsIgnoreCase("add")){
										  if(args[2].length() > 9){
											  player.sendMessage(prefix + ChatColor.RED + "Number too big!");
										  }
										  else if(args.length > 3){
											  if(args[3].equalsIgnoreCase("*online")){
												  for(Player p2: Bukkit.getOnlinePlayers()){
													  playerConfig = getPlayerConfig(p2);
													  int coins = playerConfig.getInt("player.common.coins");
													  coins += Integer.parseInt(args[2]);
													  playerConfig.set("player.common.coins", coins);
													  savePlayerConfig(p2);
												  }
												  player.sendMessage(prefix + ChatColor.GREEN + "added " + ChatColor.GOLD + args[2] + ChatColor.GREEN + " coins for all online players");
											  }
											  else if(args[3].equalsIgnoreCase("*ingame")){
												  for(Player p2: inGame.keySet()){
													  playerConfig = getPlayerConfig(p2);
													  int coins = playerConfig.getInt("player..common.coins");
													  coins += Integer.parseInt(args[2]);
													  playerConfig.set("player.common.coins", coins);
													  savePlayerConfig(p2);
												  }
												  player.sendMessage(prefix + ChatColor.GREEN + "added " + ChatColor.GOLD + args[2] + ChatColor.GREEN + " coins for all ingame players");
											  }
											  else{
												  OfflinePlayer p2 = Bukkit.getOfflinePlayer(args[3]);
												  init.initStat(p2);
												  playerConfig = getPlayerConfig(p2);
												  int coins = playerConfig.getInt("player.common.coins");
												  coins += Integer.parseInt(args[2]);
												  playerConfig.set("player.common.coins", coins);
												  savePlayerConfig(p2);
												  player.sendMessage(prefix + ChatColor.GREEN + "added " + ChatColor.GOLD + args[2] + ChatColor.GREEN + " coins to player" + args[3]);
											  }
										  }
										  else{
											  playerConfig = getPlayerConfig(player);
											  int coins = playerConfig.getInt("player.common.coins");
											  coins += Integer.parseInt(args[2]);
											  playerConfig.set("player.common.coins", coins);
											  savePlayerConfig(player);
											  player.sendMessage(prefix + ChatColor.GREEN + "Set your coins to " + ChatColor.GOLD + coins);
										  }
									  }
									  else if(args[1].equalsIgnoreCase("set")){
										  if(args[2].length() > 9){
											  player.sendMessage(prefix + ChatColor.RED + "Number too big!");
										  }
										  else if(args.length > 3){
											  if(args[3].equalsIgnoreCase("*online")){
												  for(Player p2: Bukkit.getOnlinePlayers()){
													  playerConfig = getPlayerConfig(p2);
													  playerConfig.set("player.common.coins", Integer.parseInt(args[2]));
													  savePlayerConfig(p2);
												  }
												  player.sendMessage(prefix + ChatColor.GREEN + "set coins of all online players to " + ChatColor.GOLD + args[2]);
												 }
											  else if(args[3].equalsIgnoreCase("*ingame")){
												  for(Player p2: inGame.keySet()){
													  playerConfig = getPlayerConfig(p2);
													  playerConfig.set("player.common.coins", Integer.parseInt(args[2]));
													  savePlayerConfig(p2);
												  }
												  player.sendMessage(prefix + ChatColor.GREEN + "Set coins for all ingame players to " + ChatColor.GOLD + args[2]);
											  }
											  else{
												  OfflinePlayer p2 = Bukkit.getOfflinePlayer(args[3]);
												  init.initStat(p2);
												  playerConfig = getPlayerConfig(p2);
												  playerConfig.set("player.common.coins", Integer.parseInt(args[2]));
												  savePlayerConfig(p2);
												  player.sendMessage(prefix + ChatColor.GREEN + "Set coins for player " + ChatColor.DARK_AQUA + args[3] + ChatColor.GREEN + " to " + ChatColor.GOLD + args[2]);
											  }
										  }
										  else{
											  playerConfig = getPlayerConfig(player);
											  playerConfig.set("player.common.coins", Integer.parseInt(args[2]));
											  savePlayerConfig(player);
											  player.sendMessage(prefix + ChatColor.GREEN + "Set your coins to " + ChatColor.GOLD + args[2]);
										  }
									  }
									  else{
										  player.sendMessage(prefix + ChatColor.RED + "Wrong syntax! Use \"/SkyWars coins help\" for help!");  
									  }
								  }
								  else{
									player.sendMessage(prefix + ChatColor.RED + "Wrong syntax! Use \"/SkyWars coins help\" for help!");  
								  }
							  }							  
							  else{
								  player.sendMessage(prefix + ChatColor.RED + "You do not have permission to manipulate coins!");  
								  }
						  }
						  else{
							  player.sendMessage(prefix + ChatColor.RED + "Wrong syntax! Use \"/SkyWars coins help\" for help!");  
						  }
					  }
					  else{//no args[0] matched
						  player.sendMessage(prefix + ChatColor.RED + "Wrong syntax! use \"/SkyWars help\" for help!");
					  }
				  }
				  else{//args.length !>0
					  player.sendMessage(prefix + ChatColor.RED + "Wrong syntax! use \"/SkyWars help\" for help!");
				  }
			  }
			  else{//console sent the command
				  getLogger().info("SkyWars is not compatible trough the console!");
			  }
		  }//end of SkyWars command
		return false;
	}//end of command
	

}