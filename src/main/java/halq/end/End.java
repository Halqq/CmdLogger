package halq.end;

import halq.end.Utils.webhookUtil;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author halq
 * @apiNote simple cmd logger, made for send information from a player who executed some command
 * @since 27/08/2022
 */

public final class End extends JavaPlugin implements Listener {

    public void onEnable() {
        setEnabled(true);
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerCommandPreprocessEvent(PlayerCommandPreprocessEvent pcpe) {
        Player p = pcpe.getPlayer();
        Location loc = p.getLocation();
        String line =   "date/time : " + getDateString() + ", [ " + "Player Name: " + p.getName() + ", ip:(" + p.getAddress().getAddress().toString().substring(1) + "), World: " + p.getWorld().getName() + ",  Cord: X " + (int) loc.getX() + ", Y " + (int) loc.getY() + ", Z " + (int) loc.getZ() + " ],  Command: " + pcpe.getMessage();

        webhookUtil.main("``` " +
                "** NEW LOG LMAO **" +
                "\n" +
                line + " ```");

        getServer().getConsoleSender().sendMessage("New Cmd Log for" + "Discord WebHook : (your webhook)");
    }

    public String getDateString() {
        Date myDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd / HH:mm:ss");
        return sdf.format(myDate);
    }
}
