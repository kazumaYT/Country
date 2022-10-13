package xyz.hiziki.country.command.country.subcommand.info;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import xyz.hiziki.country.Main;
import xyz.hiziki.country.util.Prefix;

public class InfoCountry
{
    private final YamlConfiguration countries = Main.countries;

    public InfoCountry(Player p, String[] args)
    {
        for (String country : countries.getStringList("countries."))
        {
            if (country.equals(args[2]))
            {
                new Prefix(p, countries.getString("countries." + country + ".info" ));
            }
        }
    }
}
