package xyz.hiziki.country.util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Prefix
{
    public Prefix(Player p, String msg)
    {
        p.sendMessage(ChatColor.AQUA + "[" + ChatColor.GREEN + "国プラグイン" + ChatColor.AQUA + "]" + msg);
    }
}
