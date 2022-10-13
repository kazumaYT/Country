package xyz.hiziki.country.command.country.subcommand;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import xyz.hiziki.country.util.Prefix;

public class NonCommand
{
    public NonCommand(Player p, String[] args)
    {
        new Prefix(p, ChatColor.RED + "不明なコマンドです。 「/country info」でコマンドの詳細が確認ができます。");
    }
}
