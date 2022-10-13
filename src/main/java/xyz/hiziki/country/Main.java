package xyz.hiziki.country;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.hiziki.country.command.CommandManager;
import xyz.hiziki.country.listener.EventManager;
import xyz.hiziki.country.util.SaveFile;

import java.io.File;

public class Main extends JavaPlugin
{
    public static JavaPlugin plugin;

    public static File countryFile;
    public static File playerFile;

    public static YamlConfiguration countries;
    public static YamlConfiguration players;

    @Override
    public void onEnable()
    {
        // プラグイン起動時の処理

        plugin = this;

        countryFile = new File(getDataFolder(), "Countries.yml");
        playerFile = new File(getDataFolder(), "Players.yml");

        countries = YamlConfiguration.loadConfiguration(countryFile);
        players = YamlConfiguration.loadConfiguration(playerFile);

        new CommandManager();

        new EventManager();

        getLogger().info("プラグインは正常に起動しました。");
    }

    @Override
    public void onDisable()
    {
        // プラグイン停止時の処理

        new SaveFile().saveAllFile();

        getLogger().info("プラグインは正常に停止しました。");
    }
}
