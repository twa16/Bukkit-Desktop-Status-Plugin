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

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author Manuel Gauto
 */
public class UDPRecieverThread implements Runnable{
    static boolean go=true;

    public static void stop(){
        go=false;
    }

    public void run() {
        try {



            DatagramSocket dsocket = new DatagramSocket(25500);


            byte[] buffer = new byte[2048];


            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);


            while (go) {

                dsocket.receive(packet);


                String msg = new String(buffer, 0, packet.getLength());

                Processor.process(msg, packet.getAddress().getHostAddress());


                packet.setLength(buffer.length);
            }
        } catch (Exception e) {
            System.err.println("Outside Loop");
            e.printStackTrace();
        }
    }
}


