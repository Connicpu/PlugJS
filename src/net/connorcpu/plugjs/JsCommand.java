/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.connorcpu.plugjs;

import org.bukkit.command.CommandSender;

/**
 *
 * @author Connor
 */
public interface JsCommand {
    public boolean execute(CommandSender sender, String commandLabel, String[] args);
    
    public Object getState();
}
