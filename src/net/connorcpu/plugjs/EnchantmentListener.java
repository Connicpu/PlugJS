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
import org.bukkit.event.enchantment.*;
import org.bukkit.event.inventory.InventoryEvent;

/**
 *
 * @author Connor
 */
public class EnchantmentListener implements Listener {
    PlugJS plugin;
    public EnchantmentListener(PlugJS plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    
    void RaiseEvent(String event, InventoryEvent arg) {
        Object handler = plugin.js.get("enchantment");
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
    public void Enchant(EnchantItemEvent event) {
        RaiseEvent("enchant", event);
    }
    @EventHandler
    public void Prepare(PrepareItemEnchantEvent event) {
        RaiseEvent("prepare", event);
    }
}
