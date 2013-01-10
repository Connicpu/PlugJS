/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.connorcpu.plugjs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.Invocable;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Connor
 */
public class PlugJS extends JavaPlugin {
    public ScriptEngine js;
    HashMap<String, Object> persistence;
    Listener block;
    Listener enchantment;
    Listener entity;
    Listener inventory;
    Listener painting;
    Listener player;
    Listener server;
    Listener vehicle;
    Listener weather;
    Listener world;
    
    public void onEnable() {
        Reload(true);

        block = new BlockListener(this);
        enchantment = new EnchantmentListener(this);
        entity = new EntityListener(this);
        inventory = new InventoryListener(this);
        painting = new PaintingListener(this);
        player = new PlayerListener(this);
        server = new ServerListener(this);
        vehicle = new VehicleListener(this);
        weather = new WeatherListener(this);
        world = new WorldListener(this);
    }
    
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Reload(args.length > 0 && args[0].equalsIgnoreCase("-p"));
        sender.sendMessage("JavaScript has been reloaded");
        return true;
    }
    
    void Reload(boolean pers) {
        if (pers) persistence = new HashMap<String, Object>();
        try {
            ScriptEngineManager sem = new ScriptEngineManager();
            js = sem.getEngineByName("JavaScript");
            js.put("persistence", persistence);
            js.put("loader", new ScriptLoader());
            js.eval("function load(file){return loader.load(file);}function getServer(){return loader.getServer();}");
            js.eval(new FileReader(getConfig().getString("script")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PlugJS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ScriptException ex) {
            Logger.getLogger(PlugJS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public class ScriptLoader {
        public void Run(Object r) {
            Invocable inv = (Invocable) js;
            Runnable runnable = inv.getInterface(r, Runnable.class);
            new Thread(runnable).start();
        }
        public Object Interface(Object o, Class i) {
            Invocable inv = (Invocable) js;
            return inv.getInterface(o, i);
        }
        public Server getServer() {return PlugJS.this.getServer();}
        public Object load(String file) throws FileNotFoundException, ScriptException {
            return js.eval(new FileReader(file));
        }
    }
}