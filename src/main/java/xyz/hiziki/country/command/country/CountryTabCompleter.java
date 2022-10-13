package xyz.hiziki.country.command.country;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import xyz.hiziki.country.Main;

import java.util.ArrayList;
import java.util.List;

public class CountryTabCompleter implements TabCompleter
{
    private final YamlConfiguration countries = Main.countries;

    private final YamlConfiguration players = Main.players;

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args)
    {
        List<String> list = new ArrayList<>();

        if (sender instanceof Player)
        {
            switch (args.length)
            {
                case 1: //サブコマンドの数が1だったら
                    singleCommand(list);
                    break;

                case 2: //サブコマンドの数が2だったら
                    doubleCommand(list, args);
                    break;

                case 3: //サブコマンドの数が3だったら
                    tripleCommand(list, args, sender);
                    break;

                case 4: //サブコマンドの数が4だったら
                    quadrupleCommand(list, args, sender);
                    break;
            }
        }
        return list;
    }

    private void singleCommand(List<String> list) //サブコマンドの数が1だったら
    {
        list.add("create");
        list.add("delete");
        list.add("secession");
        list.add("capital");

        list.add("chunk");
        list.add("edit");
        list.add("info");
        list.add("invite");
        list.add("join");
        list.add("member");
        list.add("role");
        list.add("war");
    }

    private void doubleCommand(List<String> list, String[] args) //サブコマンドの数が2だったら
    {
        switch (args[0])
        {
            case "chunk":
            case "role":
                list.add("add");
                list.add("delete");
                break;

            case "edit":
                list.add("capital");
                list.add("color");
                list.add("info");
                list.add("rename");
                break;

            case "info":
                list.add("country");
                list.add("player");
                list.add("command");
                break;

            case "invite":
                list.add("accept");
                list.add("deny");
                list.add("list");
                break;

            case "join":
                list.add("cancel");
                list.add("request");
                break;
                
            case "member":
                list.add("cancel");
                list.add("invite");
                list.add("kick");
                break;

            case "request":
                list.add("accept");
                list.add("list");
                break;

            case "war":
                list.add("declare");
                list.add("justification");
                list.add("surrender");
                break;
        }
    }

    private void tripleCommand(List<String> list, String[] args, CommandSender sender) //サブコマンドの数が3だったら
    {
        Player p = (Player) sender;
        String playerCountry = players.getString("players." + p.getUniqueId() + ".country");

        switch (args[0])
        {
            case "edit":
                if ("color".equals(args[1]))
                {
                    list.add("aqua");
                    list.add("black");
                    list.add("blue");
                    list.add("dark_aqua");
                    list.add("dark_blue");
                    list.add("dark_gray");
                    list.add("dark_green");
                    list.add("dark_purple");
                    list.add("dark_red");
                    list.add("gold");
                    list.add("gray");
                    list.add("green");
                    list.add("light_purple");
                    list.add("red");
                    list.add("white");
                    list.add("yellow");
                }
                break;
            case "info":
                switch (args[1])
                {
                    case "country":
                        list.addAll(countries.getStringList("countries."));
                        break;

                    case "player":
                        list.addAll(players.getStringList("players."));
                        break;

                    case "command":
                        list.add("create");
                        list.add("delete");
                        list.add("secession");
                        list.add("capital");
                        list.add("chunk");
                        list.add("edit");
                        list.add("info");
                        list.add("invite");
                        list.add("join");
                        list.add("member");
                        list.add("role");
                        list.add("war");
                        break;
                }
                break;

            case "invite":
                switch (args[1])
                {
                    case "accept":
                    case "deny":
                        list.addAll(players.getStringList("players." + p.getUniqueId() + ".invite"));
                        break;
                }
                break;

            case "join":
                switch (args[1])
                {
                    case "cancel":
                        list.addAll(players.getStringList("players." + p.getUniqueId() + "request"));
                        break;

                    case "request":
                        list.addAll(countries.getStringList("countries."));
                        break;
                }
                break;

            case "member":


                switch (args[1])
                {
                    case "cancel":
                        list.addAll(countries.getStringList("countries." + playerCountry + ".inviteMember"));
                        break;

                    case "invite":
                        list.addAll(players.getStringList("nonCountryPlayers."));
                        break;

                    case "kick":
                        list.addAll(countries.getStringList("countries." + playerCountry + ".member"));
                        break;
                }
                break;

            case "role":
                switch (args[1])
                {
                    case "add":
                    case "delete":
                        list.add("chunk_add");
                        list.add("chunk_delete");

                        list.add("member_invite");
                        list.add("member_cancel");
                        list.add("member_kick");

                        list.add("edit_rename");
                        list.add("edit_capital");
                        list.add("edit_info");
                        list.add("edit_change");

                        list.add("request_list");
                        list.add("request_player");

                        list.add("role_add");
                        list.add("role_delete");

                        list.add("war_justification");
                        list.add("war_surrender");

                        list.add("chunk");
                        list.add("member");
                        list.add("edit");
                        list.add("request");
                        list.add("role");
                        list.add("war");
                        break;
                }
                break;

            case "war":
                switch (args[1])
                {
                    case "declare":
                        list.addAll(countries.getStringList("countries." + playerCountry + "justification"));

                    case "justification":
                        list.addAll(countries.getStringList("countries."));
                        break;

                    case "surrender":
                        list.addAll(countries.getStringList("countries." + playerCountry + "war"));
                        break;

                }
                break;
        }
    }

    private void quadrupleCommand(List<String> list, String[] args, CommandSender sender)
    {
        Player p = (Player) sender;
        String playerCountry = players.getString("players." + p.getUniqueId() + ".country");

        if (args[0].equals("role"))
        {
            if ("add".equals(args[1]) || "delete".equals(args[1]))
            {
                list.addAll(countries.getStringList("countries." + playerCountry + ".member"));
            }
        }
    }
}
