package me.simonfoy.hub;

import me.simonfoy.hub.hubNPCs.bedwarsNPC;
import me.simonfoy.hub.hubNPCs.heroesOfSmashNPC;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Hub extends JavaPlugin {

    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new worldEvents(), this);

        Bukkit.getPluginManager().registerEvents(new ConnectListener(), this);

        Bukkit.getPluginManager().registerEvents(new bedwarsNPC(this), this);
        Bukkit.getPluginManager().registerEvents(new heroesOfSmashNPC(this), this);
    }
}
