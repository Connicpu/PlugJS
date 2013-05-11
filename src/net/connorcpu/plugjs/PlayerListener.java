/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.connorcpu.plugjs;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.Invocable;
import javax.script.ScriptException;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;

/**
 *
 * @author Connor
 */
public class PlayerListener implements Listener {
    PlugJS plugin;
    public PlayerListener(PlugJS plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    
    void RaiseEvent(String event, Event arg) {
        Object handler = plugin.js.get("player");
        if (handler == null) return;
        Invocable jsI = (Invocable) plugin.js;
        try {
            jsI.invokeMethod(handler, event, arg);
        } catch (ScriptException ex) {
            Logger.getLogger(BlockListener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
        }
    }
    
    @EventHandler
    public void Death(PlayerDeathEvent event) {
        RaiseEvent("death", event);
    }
    
    @EventHandler
    public void Animation(PlayerAnimationEvent event) {
        RaiseEvent("animation", event);
    }
    
    @EventHandler
    public void BedEnter(PlayerBedEnterEvent event) {
        RaiseEvent("bedEnter", event);
    }
    
    @EventHandler
    public void BedLeave(PlayerBedLeaveEvent event) {
        RaiseEvent("bedLeave", event);
    }
    
    @EventHandler
    public void BucketEmpty(PlayerBucketEmptyEvent event) {
        RaiseEvent("bucketEmpty", event);
    }
    
    @EventHandler
    public void BucketFill(PlayerBucketFillEvent event) {
        RaiseEvent("bucketFill", event);
    }
    
    @EventHandler
    public void ChangedWorld(PlayerChangedWorldEvent event) {
        RaiseEvent("changedWorld", event);
    }
    
    @EventHandler
    public void Chat(AsyncPlayerChatEvent event) {
        RaiseEvent("chat", event);
    }
    
    @EventHandler
    public void PreCommand(PlayerCommandPreprocessEvent event) {
        RaiseEvent("command", event);
    }
    
    @EventHandler
    public void DropItem(PlayerDropItemEvent event) {
        RaiseEvent("dropItem", event);
    }
    
    @EventHandler
    public void EggThrow(PlayerEggThrowEvent event) {
        RaiseEvent("eggThrow", event);
    }
    
    @EventHandler
    public void ExpChange(PlayerExpChangeEvent event) {
        RaiseEvent("expChange", event);
    }
    
    @EventHandler
    public void Fish(PlayerFishEvent event) {
        RaiseEvent("fish", event);
    }
    
    @EventHandler
    public void GameMode(PlayerGameModeChangeEvent event) {
        RaiseEvent("gamemode", event);
    }
    
    @EventHandler
    public void Interact(PlayerInteractEvent event) {
        RaiseEvent("interact", event);
    }
    
    @EventHandler
    public void InteractEntity(PlayerInteractEntityEvent event) {
        RaiseEvent("interactEntity", event);
    }
    
    @EventHandler
    public void ItemHeld(PlayerItemHeldEvent event) {
        RaiseEvent("itemHeld", event);
    }
    
    @EventHandler
    public void Join(PlayerJoinEvent event) {
        RaiseEvent("join", event);
    }
    
    @EventHandler
    public void Kick(PlayerKickEvent event) {
        RaiseEvent("kick", event);
    }
    
    @EventHandler
    public void LevelChange(PlayerLevelChangeEvent event) {
        RaiseEvent("levelChange", event);
    }
    
    @EventHandler
    public void Login(PlayerLoginEvent event) {
        RaiseEvent("login", event);
    }
    
    @EventHandler
    public void Move(PlayerMoveEvent event) {
        RaiseEvent("move", event);
    }
    
    @EventHandler
    public void PickupItem(PlayerPickupItemEvent event) {
        RaiseEvent("pickupItem", event);
    }
    
    @EventHandler
    public void Portal(PlayerPortalEvent event) {
        RaiseEvent("portal", event);
    }
    
    @EventHandler
    public void PreLogin(AsyncPlayerPreLoginEvent event) {
        RaiseEvent("preLogin", event);
    }
    
    @EventHandler
    public void Quit(PlayerQuitEvent event) {
        RaiseEvent("quit", event);
    }
    
    @EventHandler
    public void Respawn(PlayerRespawnEvent event) {
        RaiseEvent("respawn", event);
    }
    
    @EventHandler
    public void ShearEntity(PlayerShearEntityEvent event) {
        RaiseEvent("shear", event);
    }
    
    @EventHandler
    public void Teleport(PlayerTeleportEvent event) {
        RaiseEvent("teleport", event);
    }
    
    @EventHandler
    public void Sneak(PlayerToggleSneakEvent event) {
        RaiseEvent("sneak", event);
    }
    
    @EventHandler
    public void Sprint(PlayerToggleSprintEvent event) {
        RaiseEvent("sprint", event);
    }
    
    @EventHandler
    public void Velocity(PlayerVelocityEvent event) {
        RaiseEvent("velocity", event);
    }
}
