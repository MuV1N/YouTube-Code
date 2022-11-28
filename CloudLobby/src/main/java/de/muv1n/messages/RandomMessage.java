package de.muv1n.messages;

import de.muv1n.CloudLobby;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;
import java.util.logging.Level;

public class RandomMessage {

    public RandomMessage() {

        new BukkitRunnable(){
            @Override
            public void run(){

                int messageLenght = Messages.messages.length;
                int random = new Random().nextInt(messageLenght);

                for (Player player : Bukkit.getServer().getOnlinePlayers()){
                    player.sendMessage(Messages.messages[random]);
                    CloudLobby.getInstance().getLogger().log(Level.INFO, Messages.messages[random].toString());
                }

            }
        }.runTaskTimer(CloudLobby.getInstance(), 0, 60*20);

    }
}
