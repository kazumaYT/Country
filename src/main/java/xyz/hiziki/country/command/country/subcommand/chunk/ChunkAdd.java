package xyz.hiziki.country.command.country.subcommand.chunk;

import org.bukkit.Chunk;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import xyz.hiziki.country.Main;
import xyz.hiziki.country.util.Prefix;

public class ChunkAdd
{

    private final YamlConfiguration countries = Main.countries;

    private final YamlConfiguration players = Main.players;

    public ChunkAdd(Player p)
    {
        if (players.getString("players." + p.getUniqueId() + ".country") != null)
        {
            if (players.getString("players." + p.getUniqueId() + ".country") != null)
            {
                String playerCountry = players.getString("players." + p.getUniqueId() + ".country");

                Chunk chunk = p.getLocation().getChunk();

                countries.set("countries." + playerCountry + ".chunk", chunk);

                new Prefix(p, "チャンクを自国領に設定しました。");
            }
        }
    }
}
