package me.simonfoy.hub;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ConnectListener implements Listener {

    @EventHandler
    public void setSpawnLocation(WorldLoadEvent e) {
        World world = Bukkit.getWorlds().get(0);
        Location spawnLocation = new Location(world, 0.5, 1, 0.5, -90, 0);
        e.getWorld().setSpawnLocation(spawnLocation);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        Inventory inventory = player.getInventory();
        World world = Bukkit.getWorlds().get(0);
        Location spawnLocation = new Location(world, 0.5, 1, 0.5, -90, 0);

        player.setGameMode(GameMode.ADVENTURE);
        inventory.clear();
        player.getInventory().setHeldItemSlot(0);
        player.teleport(spawnLocation);

        ItemStack gameMenu = new ItemStack(Material.COMPASS);
        ItemMeta gameMenuMeta = gameMenu.getItemMeta();
        gameMenuMeta.setDisplayName(ChatColor.YELLOW + "Game Menu");
        gameMenu.setItemMeta(gameMenuMeta);
        inventory.setItem(0, gameMenu);

        ItemStack lobbySelector = new ItemStack(Material.NETHER_STAR);
        ItemMeta lobbySelectorMeta = lobbySelector.getItemMeta();
        lobbySelectorMeta.setDisplayName(ChatColor.YELLOW + "Lobby Selector");
        lobbySelector.setItemMeta(lobbySelectorMeta);
        inventory.setItem(8, lobbySelector);
    }
}
