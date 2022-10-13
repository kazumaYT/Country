package xyz.hiziki.country.command.money;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class MoneyTabComparator implements TabCompleter
{
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args)
    {
        List<String> list = new ArrayList<>();


        return list;
    }
}
