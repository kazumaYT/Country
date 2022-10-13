package xyz.hiziki.country.scheduler;

import org.bukkit.*;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import xyz.hiziki.country.Main;

public class CountryChunkEffect extends BukkitRunnable
{
    private final YamlConfiguration countries = Main.countries;

    private final YamlConfiguration players = Main.players;

    public CountryChunkEffect()
    {
        run();
    }

    @Override
    public void run()
    {
        for (String country : countries.getStringList("countries."))
        {
            for (String countryChunk : countries.getStringList("countries." + country + ".chunk."))
            {
                for (Player player : Bukkit.getOnlinePlayers())
                {
//                    Chunk chunk =
//
//                    int minX = countryChunk.getX() * 16;
//                    int minZ = countryChunk.getZ() * 16;
//                    int minY = player.getLocation().getBlockY();
//
//                    Particle.DustOptions dustOptions = new Particle.DustOptions();

                }
            }
        }
    }
}

//countries:
//  hi-kun:
//      settings:
//        name:
//        capital:
//        info:
//        color
//      chunk:
//        チャンク1
//        チャンク2
//      member:
//        530e7910-3f00-11ed-b878-0242ac120002
//        5ae9d314-3f00-11ed-b878-0242ac120002
//      admin:
//        530e7910-3f00-11ed-b878-0242ac120002
