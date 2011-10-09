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

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 *
 * @author Manuel Gauto
 */
public class Processor {
    public static void process(String message,String host){
        Player[] players;
        
        //desktopwidgetplugin.log.log(Level.INFO,"Packet Recieved");
        if(message.equals(Requests.IP_REQUEST)){
            reply(host,Requests.IP_REQUEST+"="+Bukkit.getServer().getIp());
        }
        if(message.equals(Requests.VERSION_REQUEST)){
            reply(host,Requests.VERSION_REQUEST+"="+Bukkit.getServer().getVersion());
        }
        if(message.equals(Requests.RAM)){
            reply(host,Requests.RAM+"="+ServerStats.getFreeRam());
        }
        if(message.equals(Requests.RAMMAX)){
            reply(host,Requests.RAMMAX+"="+ServerStats.getMaxRam());
        }
        if(message.equals(Requests.MAXPLAYERS_REQUEST)){
            reply(host,Requests.MAXPLAYERS_REQUEST+"="+Bukkit.getServer().getMaxPlayers());
            //desktopwidgetplugin.log.log(Level.SEVERE,String.valueOf(Bukkit.getServer().getMaxPlayers()));
        }
        if(message.equals(Requests.ACK)){
            reply(host,Requests.ACK);
        }

        if(message.equals(Requests.PLAYERS_REQUEST)){
            players=Bukkit.getServer().getOnlinePlayers();
            //desktopwidgetplugin.log.log(Level.INFO, String.valueOf(players.length));
            reply(host,Requests.PLAYERS_REQUEST+"="+String.valueOf(players.length));
        }
    }
    public static void reply(String host, String message){
        try {
                    //desktopwidgetplugin.log.log(Level.INFO, "Sending packet to: {0}", host);
                    byte[] messagebytes = message.getBytes();
                    InetAddress address = null;
                    try {
                        address = InetAddress.getByName(host);
                    } catch (UnknownHostException ex) {
                        System.err.println(ex.getMessage());
                    }
                    DatagramPacket packet = new DatagramPacket(messagebytes, messagebytes.length, address, 25501);
                    DatagramSocket dsocket = new DatagramSocket();
                    try {
                        dsocket.send(packet);
                    } catch (IOException ex) {
                        System.err.println(ex.getMessage());
                    }
                    dsocket.close();
                    }catch (SocketException ex) {
                        System.err.println(ex.getMessage());
                    }
    }
}
