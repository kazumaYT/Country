package xyz.hiziki.country.command.country.subcommand.edit;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import xyz.hiziki.country.Main;

public class EditCapital
{
    private final YamlConfiguration countries = Main.countries;

    private final YamlConfiguration permissions = Main.permissions;

    public EditCapital(Player p, String[] args)
    {
        for (String country : countries.getStringList("countries"))
        {
        }
    }
}
