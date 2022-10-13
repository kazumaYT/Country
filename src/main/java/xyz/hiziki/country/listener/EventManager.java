package xyz.hiziki.country.listener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.hiziki.country.Main;
import xyz.hiziki.country.listener.event.ServerLoad;

public class EventManager
{
    private final JavaPlugin plugin = Main.plugin;

    public EventManager()
    {
        //サーバー起動時
        Bukkit.getPluginManager().registerEvents(new ServerLoad(), plugin);





    }
}
