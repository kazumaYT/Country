package xyz.hiziki.country.command.country.subcommand.chunk;

import org.bukkit.Chunk;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import xyz.hiziki.country.Main;

public class ChunkDelete
{
    private final YamlConfiguration countries = Main.countries;

    private final YamlConfiguration players = Main.players;

    public ChunkDelete(Player p)
    {

        if (players.getString("players." + p.getUniqueId() + ".country") != null)
        {
            Chunk chunk = p.getLocation().getChunk();
            String playerCountry = players.getString("players." + p.getUniqueId() + ".country");

            countries.set("countries." + playerCountry + ".chunk", chunk);
        }
    }
}
