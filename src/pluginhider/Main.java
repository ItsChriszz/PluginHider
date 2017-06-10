package pluginhider;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {


public void onEnable() {
	saveDefaultConfig();
}

public void onDisable() {
	reloadConfig();
}

@Override
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if(cmd.getName().equals("?")) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(!p.hasPermission("plugins.view")) {
            	Player player = p.getPlayer();
    			player.sendMessage(
    					ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.no-permission")));
            }
            if(p.hasPermission("plugins.view")) {
            	p.performCommand("plugins");
            }
            	if (cmd.getName().equalsIgnoreCase("PlReload")) {
            		if(p.hasPermission("pluginhider.reload")) {
            			reloadConfig();
            			sender.sendMessage(
            					ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.reload-config")));
            		}
            	}
        }
    }
	return true;
}
}
