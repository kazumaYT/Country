package xyz.hiziki.country.command;


import org.bukkit.plugin.java.JavaPlugin;
import xyz.hiziki.country.Main;
import xyz.hiziki.country.command.country.CountryCommandExecutor;
import xyz.hiziki.country.command.country.CountryTabCompleter;
import xyz.hiziki.country.command.money.MoneyCommandExecutor;
import xyz.hiziki.country.command.money.MoneyTabComparator;

public class CommandManager
{
    private final JavaPlugin plugin = Main.plugin;

    public CommandManager()
    {
        plugin.getCommand("country").setExecutor(new CountryCommandExecutor());
        plugin.getCommand("country").setTabCompleter(new CountryTabCompleter());

        plugin.getCommand("money").setExecutor(new MoneyCommandExecutor());
        plugin.getCommand("money").setTabCompleter(new MoneyTabComparator());
    }
}
