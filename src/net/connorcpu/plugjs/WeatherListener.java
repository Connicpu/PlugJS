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
import org.bukkit.event.weather.*;

/**
 *
 * @author Connor
 */
public class WeatherListener implements Listener {
    PlugJS plugin;
    public WeatherListener(PlugJS plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    
    void RaiseEvent(String event, Event arg) {
        Object handler = plugin.js.get("weather");
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
    public void Lightning(LightningStrikeEvent event) {
        RaiseEvent("lightning", event);
    }
    
    @EventHandler
    public void Thunder(ThunderChangeEvent event) {
        RaiseEvent("thunder", event);
    }
    
    @EventHandler
    public void Weather(WeatherChangeEvent event) {
        RaiseEvent("weather", event);
    }
}
