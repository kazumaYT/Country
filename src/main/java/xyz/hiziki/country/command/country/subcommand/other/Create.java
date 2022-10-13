package xyz.hiziki.country.command.country.subcommand.other;

import org.bukkit.ChatColor;
import org.bukkit.WorldType;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import xyz.hiziki.country.Main;
import xyz.hiziki.country.util.Prefix;

public class Create
{
    private final YamlConfiguration countries = Main.countries;

    private final YamlConfiguration players = Main.players;

    @SuppressWarnings("deprecation")
    public Create(Player p, String countryName)
    {
        if (players.getString("players." + "country") != null)
        {
            new Prefix(p, "あなたは既に国に所属しています。");
        }
        else
        {
            if (p.getLevel() >= 50)
            {
                new Prefix(p, "国を作成するには50レベルが必要です。");
            }
            else
            {
                if (hasCountry(p))
                {
                    new Prefix(p, "このチャンクはすでに他国の領土です。" );
                }
                else
                {
                    if (p.getWorld().getWorldType() != WorldType.NORMAL)
                    {
                        new Prefix(p, "国を作成できるのはワールドのみです。");
                    }
                    else
                    {
                        //国設定
                        countries.set("countries." + countryName + ".settings.name", countryName);
                        countries.set("countries." + countryName + ".settings.capital", p.getLocation().toString());
                        countries.set("countries." + countryName + ".settings.info", "この国の説明は設定されていません。");
                        countries.set("countries." + countryName + ".settings.color", ChatColor.AQUA.toString());

                        //チャンク
                        countries.set("countries." + countryName + ".chunk", p.getLocation().getChunk().toString());

                        //メンバー
                        countries.set("countries." + countryName + ".member", p.getUniqueId().toString());

                        //プレイヤーの所属国設定
                        players.set("players.country", countryName);

                        new Prefix(p, "国の首都を"
                                + p.getLocation().getBlockX()
                                + p.getLocation().getBlockX()
                                + p.getLocation().getBlockX()
                                + "に設定しました。");

                        new Prefix(p, "国を作成しました。「/country info」で国の説明を設定することをお勧めします。");

                        new Prefix(p, "「/country info command」で国を管理するコマンド一覧を表示できます。");
                    }
                }
            }
        }
    }

    private boolean hasCountry(Player p)
    {
        if (players.getString("players.country.") == null)
        {
            for (String country : countries.getStringList("countries."))
            {
                for (String countryChunk : countries.getStringList("countries." + country + ".chunk."))
                {
                    if (p.getLocation().getChunk().toString().equals(countryChunk))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
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