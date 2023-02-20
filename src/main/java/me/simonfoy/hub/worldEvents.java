package me.simonfoy.hub;

import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.weather.WeatherChangeEvent;

public class worldEvents implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onBlockInteract(PlayerInteractEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onFallDamage(EntityDamageEvent e) {
        if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onVoidDeath(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        Location location = player.getLocation();
        World world = Bukkit.getWorlds().get(0);
        Location spawnLocation = new Location(world, 0.5, 1, 0.5, -90, 0);

        if (location.getY() <= -64 ) {
            player.teleport(spawnLocation);
        }
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onItemPickup(PlayerPickupItemEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onPlayerPvP(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onHungerLoss(FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onMobSpawn(EntitySpawnEvent e) {
        if (e.getEntityType() != EntityType.VILLAGER) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onFireSpread(BlockSpreadEvent e) {
        if (e.getBlock().getType() == Material.FIRE) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockBurn(BlockBurnEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onDeathMessage(PlayerDeathEvent e) {
        e.setDeathMessage(null);
    }

    @EventHandler
    public void onLeafDecay(LeavesDecayEvent e) {
        e.setCancelled(true);
    }
}
