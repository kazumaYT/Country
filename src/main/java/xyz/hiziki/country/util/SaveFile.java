package xyz.hiziki.country.util;

import org.bukkit.configuration.file.YamlConfiguration;
import xyz.hiziki.country.Main;

import java.io.File;
import java.io.IOException;

public class SaveFile
{
    private final YamlConfiguration countries = Main.countries;

    private final YamlConfiguration players = Main.players;

    private final File countryFile = Main.countryFile;
    private final File playerFile = Main.playerFile;

    public void saveAllFile()
    {
        playerFile();
        countryFile();
    }

    public void playerFile() //プレイヤーに関するファイル
    {
        try
        {
            players.save(playerFile);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void countryFile() //国に関するファイル
    {
        try
        {
            countries.save(countryFile);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
