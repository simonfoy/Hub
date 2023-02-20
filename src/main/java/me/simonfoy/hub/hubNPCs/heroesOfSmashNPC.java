package me.simonfoy.hub.hubNPCs;

import me.simonfoy.hub.Hub;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class heroesOfSmashNPC implements Listener {

    private Hub hub;

    public heroesOfSmashNPC(Hub hub) {
        this.hub = hub;
        Bukkit.getPluginManager().registerEvents(this, hub);

        Bukkit.getScheduler().runTaskLater(hub, this::spawnHeroesOfSmashNPC, 20L);
    }
    public void spawnHeroesOfSmashNPC() {
        Location spawnLocation = new Location(Bukkit.getWorlds().get(0), 0.5, 1, -6.5, 0, 0);
        Villager villager = (Villager) spawnLocation.getWorld().spawnEntity(spawnLocation, EntityType.VILLAGER);
        villager.setCustomName(ChatColor.YELLOW + "Heroes Of Smash NPC");
        villager.setCustomNameVisible(true);
        villager.setCanPickupItems(false);

        villager.setAI(false);
        villager.setSilent(true);
        villager.setInvulnerable(true);

    }

    @EventHandler
    public void onEntityClick(PlayerInteractEntityEvent e) {
        if (e.getRightClicked() instanceof Villager) {
            Villager villager = (Villager) e.getRightClicked();
            if (villager.getCustomName() != null && villager.getCustomName().contains("Heroes Of Smash NPC")) {
                e.setCancelled(true);

                Inventory menu = Bukkit.createInventory(null, 36, "Heroes Of Smash Menu");
                ItemStack item = new ItemStack(Material.BARRIER);
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName(ChatColor.RED + "Close");
                item.setItemMeta(meta);
                menu.setItem(31, item);
                e.getPlayer().openInventory(menu);

            }
        }
    }
}
