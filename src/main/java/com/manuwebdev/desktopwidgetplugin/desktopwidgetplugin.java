/*
 *  The MIT License
 *
 *  Copyright 2011 Manuel Gauto <manuelg@manuwebdev.com>.
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */
package com.manuwebdev.desktopwidgetplugin;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Manuel Gauto
 */
public class desktopwidgetplugin extends JavaPlugin {

    /**
     * @param args the command line arguments
     */
    public static final Logger log = Logger.getLogger("Minecraft");
    public static final String VERSION="0.5a-stable";

    public static void main(String[] args) {
        //Do Nothing
        //This is here for netbeans for internal testing.
    }

    public void onEnable() {
        Thread t = new Thread(new UDPRecieverThread());
        t.start();
        PluginDescriptionFile pdf = this.getDescription();
        log.log(Level.INFO,"["+pdf.getName()+"] Version "+pdf.getVersion()+" Enabled!");
    }

    public void onDisable() {
        UDPRecieverThread.stop();
        log.info("Bukkit Desktop Widget Interface Disabled!");
    }
}
