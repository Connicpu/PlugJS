/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.connorcpu.plugjs;

import java.io.File;

/**
 *
 * @author Connor
 */
public class ScriptManager {
    public static Object loadScript(String file) {
        File scriptDir = new File("./scripts/");
        if (!scriptDir.exists()) {
            scriptDir.mkdir();
        }
        
        
        
        return null;
    }
}
