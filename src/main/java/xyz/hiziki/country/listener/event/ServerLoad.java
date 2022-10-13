package xyz.hiziki.country.listener.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerLoadEvent;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.hiziki.country.Main;
import xyz.hiziki.country.scheduler.CountryChunk;

public class ServerLoad implements Listener
{
    private final JavaPlugin plugin = Main.plugin;

    @EventHandler
    public void onServerLoad(ServerLoadEvent e)
    {
        //国侵入感知
        new CountryChunk().runTaskTimer(plugin, 20, 20);

        //国エフェクト
        new CountryChunk().runTaskTimer(plugin, 20, 20);
    }
}
