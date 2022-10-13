package xyz.hiziki.country.scheduler;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import xyz.hiziki.country.Main;
import xyz.hiziki.country.util.Prefix;

public class CountryChunk extends BukkitRunnable
{
    private final YamlConfiguration countries = Main.countries;

    private final YamlConfiguration players = Main.players;

    public CountryChunk()
    {
        run();
    }

    @Override
    public void run()
    {
        for (Player p : Bukkit.getOnlinePlayers())
        {
            for (String country : countries.getStringList("countries."))
            {
                if (!country.equals(players.getString("players.country.")))
                {
                    for (String countryChunk : countries.getStringList("countries." + country + ".chunk."))
                    {
                        if (p.getLocation().getChunk().toString().equals(countryChunk))
                        {
                            new Prefix(p, ChatColor.RED + country + "の領土に侵入しています。");
                        }
                    }
                }
            }
        }
    }
}
