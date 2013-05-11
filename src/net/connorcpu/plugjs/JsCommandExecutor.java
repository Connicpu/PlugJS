/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.connorcpu.plugjs;

import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/**
 *
 * @author Connor
 */
public class JsCommandExecutor extends Command {
    
    JsCommand executor;
    
    public JsCommandExecutor(String name, String description, String usage, List<String> aliases, JsCommand command) {
        super(name, description, usage, aliases);
        
        executor = command;
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        return executor.execute(sender, label, args);
    }
    
    public JsCommand getExecutor() {
        return executor;
    }
}
