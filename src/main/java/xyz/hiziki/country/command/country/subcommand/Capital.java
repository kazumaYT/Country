package xyz.hiziki.country.command.country.subcommand;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.hiziki.country.Main;
import xyz.hiziki.country.util.Prefix;

public class Capital
{
    private final JavaPlugin plugin = Main.plugin;

    private final YamlConfiguration countries = Main.countries;

    private final YamlConfiguration players = Main.players;

    public Capital(Player p)
    {
        String playerCountry = players.getString("players." + p.getUniqueId() + ".country");


        new Prefix(p,  playerCountry + "の首都へテレポートしました。");
    }
}
