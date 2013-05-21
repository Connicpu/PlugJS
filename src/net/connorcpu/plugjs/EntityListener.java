/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.connorcpu.plugjs;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.Invocable;
import javax.script.ScriptException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;

/**
 *
 * @author Connor
 */
public class EntityListener implements Listener {
    PlugJS plugin;
    public EntityListener(PlugJS plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    
    void RaiseEvent(String event, EntityEvent arg) {
        Object handler = plugin.js.get("entity");
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
    public void CreatureSpawn(CreatureSpawnEvent event) {
        RaiseEvent("creatureSpawn", event);
    }
    
    @EventHandler
    public void CreeperPower(CreeperPowerEvent event) {
        RaiseEvent("creeperPower", event);
    }
    
    @EventHandler
    public void BreakDoor(EntityBreakDoorEvent event) {
        RaiseEvent("breakDoor", event);
    }
    
    @EventHandler
    public void ChangeBlock(EntityChangeBlockEvent event) {
        RaiseEvent("changeBlock", event);
    }
    
    @EventHandler
    public void Combust(EntityCombustEvent event) {
        RaiseEvent("combust", event);
    }
    
    @EventHandler
    public void CreatePortal(EntityCreatePortalEvent event) {
        RaiseEvent("createPortal", event);
    }
    
    @EventHandler
    public void Damage(EntityDamageEvent event) {
        RaiseEvent("damage", event);
    }
    
    @EventHandler
    public void DamageByBlock(EntityDamageByBlockEvent event) {
        RaiseEvent("damageByBlock", event);
    }
    
    @EventHandler
    public void DamageByEntity(EntityDamageByEntityEvent event) {
        RaiseEvent("damageByEntity", event);
    }
    
    @EventHandler
    public void Death(EntityDeathEvent event) {
        RaiseEvent("death", event);
    }
    
    @EventHandler
    public void Explode(EntityExplodeEvent event) {
        RaiseEvent("explode", event);
    }
    
    @EventHandler
    public void Interact(EntityInteractEvent event) {
        RaiseEvent("interact", event);
    }
    
    @EventHandler
    public void PortalEnter(EntityPortalEnterEvent event) {
        RaiseEvent("portalEnter", event);
    }
    
    @EventHandler
    public void RegainHealth(EntityRegainHealthEvent event) {
        RaiseEvent("regainHealth", event);
    }
    
    @EventHandler
    public void ShootBow(EntityShootBowEvent event) {
        RaiseEvent("shootBow", event);
    }
    
    @EventHandler
    public void Tame(EntityTameEvent event) {
        RaiseEvent("tame", event);
    }
    
    @EventHandler
    public void Target(EntityTargetEvent event) {
        RaiseEvent("target", event);
    }
    
    @EventHandler
    public void TargetLivingEntity(EntityTargetLivingEntityEvent event) {
        RaiseEvent("targetLivingEntity", event);
    }
    
    @EventHandler
    public void Teleport(EntityTeleportEvent event) {
        RaiseEvent("teleport", event);
    }
    
    @EventHandler
    public void ExpBottle(ExpBottleEvent event) {
        RaiseEvent("expBottle", event);
    }
    
    @EventHandler
    public void ExplosionPrime(ExplosionPrimeEvent event) {
        RaiseEvent("explosionPrime", event);
    }
    
    @EventHandler
    public void FoodLevelChange(FoodLevelChangeEvent event) {
        RaiseEvent("foodLevelChange", event);
    }
    
    @EventHandler
    public void ItemDespawn(ItemDespawnEvent event) {
        RaiseEvent("itemDespawn", event);
    }
    
    @EventHandler
    public void ItemSpawn(ItemSpawnEvent event) {
        RaiseEvent("itemSpawn", event);
    }
    
    @EventHandler
    public void PigZap(PigZapEvent event) {
        RaiseEvent("pigZap", event);
    }
    
    @EventHandler
    public void PotionSplash(PotionSplashEvent event) {
        RaiseEvent("potionSplash", event);
    }
    
    @EventHandler
    public void ProjectileHit(ProjectileHitEvent event) {
        RaiseEvent("projectileHit", event);
    }
    
    @EventHandler
    public void ProjectileLaunch(ProjectileLaunchEvent event) {
        RaiseEvent("projectileLaunch", event);
    }
    
    @EventHandler
    public void SheepDye(SheepDyeWoolEvent event) {
        RaiseEvent("sheepDye", event);
    }
    
    @EventHandler
    public void SheepRegrow(SheepRegrowWoolEvent event) {
        RaiseEvent("sheepRegrow", event);
    }
    
    @EventHandler
    public void SlimeSplit(SlimeSplitEvent event) {
        RaiseEvent("slimeSplit", event);
    }
}
