package xyz.hiziki.country.command.country;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.hiziki.country.Main;
import xyz.hiziki.country.command.country.subcommand.Capital;
import xyz.hiziki.country.command.country.subcommand.NonCommand;
import xyz.hiziki.country.command.country.subcommand.chunk.ChunkAdd;
import xyz.hiziki.country.command.country.subcommand.chunk.ChunkDelete;
import xyz.hiziki.country.command.country.subcommand.edit.EditCapital;
import xyz.hiziki.country.command.country.subcommand.edit.EditColor;
import xyz.hiziki.country.command.country.subcommand.edit.EditInfo;
import xyz.hiziki.country.command.country.subcommand.edit.EditRename;
import xyz.hiziki.country.command.country.subcommand.info.InfoCommand;
import xyz.hiziki.country.command.country.subcommand.info.InfoCountry;
import xyz.hiziki.country.command.country.subcommand.info.InfoPlayer;
import xyz.hiziki.country.command.country.subcommand.invite.InviteAccept;
import xyz.hiziki.country.command.country.subcommand.invite.InviteDeny;
import xyz.hiziki.country.command.country.subcommand.invite.InviteList;
import xyz.hiziki.country.command.country.subcommand.join.JoinCancel;
import xyz.hiziki.country.command.country.subcommand.join.JoinRequest;
import xyz.hiziki.country.command.country.subcommand.member.MemberCancel;
import xyz.hiziki.country.command.country.subcommand.member.MemberInvite;
import xyz.hiziki.country.command.country.subcommand.member.MemberKick;
import xyz.hiziki.country.command.country.subcommand.other.Create;
import xyz.hiziki.country.command.country.subcommand.other.Delete;
import xyz.hiziki.country.command.country.subcommand.other.Secession;
import xyz.hiziki.country.command.country.subcommand.request.RequestAccept;
import xyz.hiziki.country.command.country.subcommand.request.RequestList;
import xyz.hiziki.country.command.country.subcommand.role.RoleAdd;
import xyz.hiziki.country.command.country.subcommand.role.RoleDelete;
import xyz.hiziki.country.command.country.subcommand.war.WarDeclare;
import xyz.hiziki.country.command.country.subcommand.war.WarJustification;
import xyz.hiziki.country.command.country.subcommand.war.WarSurrender;
import xyz.hiziki.country.util.Prefix;

public class CountryCommandExecutor implements CommandExecutor
{
    private final JavaPlugin plugin = Main.plugin;

    @SuppressWarnings("NullableProblems")
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (!(sender instanceof Player))
        {
            plugin.getLogger().info("コマンドを実行できるのはプレイヤーのみです。");
        }
        else
        {
            Player p = (Player) sender;

            if (args.length == 0)
            {
                new Prefix(p, ChatColor.RED +
                        "サブコマンドが設定されていません。「/country info」でコマンド一覧が確認ができます。");
            }
            else // 「/country create hi-kun fascism」
            {
                switch (args[0])
                {
                    case "create":
                        new Create(p, args[1]);
                        break;

                    case "delete":
                        new Delete(p, args[1]);
                        break;

                    case "secession":
                        new Secession(p, args[1]);
                        break;

                    case "capital":
                        new Capital(p);
                        break;

                    case "chunk":
                        chunkCommandExecutor(p, args);
                        break;

                    case "edit":
                        editCommandExecutor(p, args);
                        break;

                    case "info":
                        infoCommandExecutor(p, args);
                        break;

                    case "invite":
                        inviteCommandExecutor(p, args);
                        break;

                    case "join":
                        joinCommandExecutor(p, args);
                        break;

                    case "member":
                        memberCommandExecutor(p, args);
                        break;

                    case "request":
                        requestCommandExecutor(p, args);
                        break;

                    case "role":
                        roleCommandExecutor(p, args);
                        break;

                    case "war":
                        warCommandExecutor(p, args);
                        break;

                    default:
                        new NonCommand(p, args);
                        break;
                }
            }
        }
        return true;
    }

    private void chunkCommandExecutor(Player p, String[] args) // /c chunk add
    {
        switch (args[1])
        {
            case "add":
                new ChunkAdd(p);
                break;

            case "delete":
                new ChunkDelete(p);
                break;

            default:
                new NonCommand(p, args);
                break;
        }
    }

    private void editCommandExecutor(Player p, String[] args)
    {
        switch (args[1])
        {
            case "capital":
                new EditCapital(p, args);
                break;

            case "color":
                new EditColor(p);
                break;

            case "info":
                new EditInfo(p, args);
                break;

            case "rename":
                new EditRename(p, args);
                break;

            default:
                new NonCommand(p, args);
                break;
        }
    }

    private void infoCommandExecutor(Player p, String[] args)
    {
        switch (args[1])
        {
            case "country":
                new InfoCountry(p, args);
                break;

            case "player":
                new InfoPlayer(p, args);
                break;

            case "command":
                new InfoCommand(p, args);
                break;

            default:
                new NonCommand(p, args);
                break;
        }
    }

    private void inviteCommandExecutor(Player p, String[] args)
    {
        switch (args[1])
        {
            case "accept":
                new InviteAccept(p, args);
                break;

            case "deny":
                new InviteDeny(p, args);
                break;

            case "list":
                new InviteList(p, args);
                break;

            default:
                new NonCommand(p, args);
                break;
        }
    }

    private void joinCommandExecutor(Player p, String[] args)
    {
        switch (args[1])
        {
            case "cancel":
                new JoinCancel(p, args);
                break;

            case "request":
                new JoinRequest(p, args);
                break;

            default:
                new NonCommand(p, args);
                break;
        }
    }

    private void memberCommandExecutor(Player p, String[] args)
    {
        switch (args[1])
        {
            case "cancel":
                new MemberCancel(p, args);
                break;

            case "invite":
                new MemberInvite(p, args);
                break;

            case "kick":
                new MemberKick(p, args);
                break;

            default:
                new NonCommand(p, args);
                break;
        }
    }

    private void requestCommandExecutor(Player p, String[] args)
    {
        switch (args[1])
        {
            case "accept":
                new RequestAccept(p, args);
                break;

            case "list":
                new RequestList(p, args);
                break;

            default:
                new NonCommand(p, args);
                break;
        }
    }

    private void roleCommandExecutor(Player p, String[] args)
    {
        switch (args[1])
        {
            case "add":
                new RoleAdd(p, args);
                break;

            case "delete":
                new RoleDelete(p, args);
                break;

            default:
                new NonCommand(p, args);
                break;
        }
    }

    private void warCommandExecutor(Player p, String[] args)
    {
        switch (args[1])
        {
            case "declare":
                new WarDeclare(p, args);
                break;

            case "justification":
                new WarJustification(p, args);
                break;


            case "surrender":
                new WarSurrender(p, args);
                break;

            default:
                new NonCommand(p, args);
                break;
        }
    }
}