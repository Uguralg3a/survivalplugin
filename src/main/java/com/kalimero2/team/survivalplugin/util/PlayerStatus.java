package com.kalimero2.team.survivalplugin.util;

import com.google.common.collect.ImmutableList;
import com.kalimero2.team.survivalplugin.SurvivalPlugin;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PlayerStatus{

    private NamespacedKey statusKey;

    public PlayerStatus(SurvivalPlugin plugin){
        statusKey = new NamespacedKey(plugin, "status");
    }

    public void setStatus(Player player, @Nullable String status){
        if(status == null){
            player.getPersistentDataContainer().remove(statusKey);
        }else {
            player.getPersistentDataContainer().set(statusKey, PersistentDataType.STRING, status);
        }
    }

    public String getStatus(Player player){
        return player.getPersistentDataContainer().get(statusKey, PersistentDataType.STRING);
    }

    public List<String> allowed(){
        return ImmutableList.of("AFK","Mining","Roleplay","Ork","PVP","Redstone","Building");
    }

    public boolean isAllowed(String status){
        return allowed().contains(status);
    }
}
