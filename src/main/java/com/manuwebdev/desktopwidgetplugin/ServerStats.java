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

/**
 *
 * @author Manuel Gauto
 */
public class ServerStats {
    static final Runtime runtime = Runtime.getRuntime ();
    public static int getMaxRam(){
        long MaxMemory=runtime.maxMemory()/1048576;
        return (int) MaxMemory;
    }
    public static int getFreeRam(){
        long FreeMemory=runtime.freeMemory()/1048576;
        return (int) FreeMemory;
    }
    public static int getProcessorNumber(){
        int ProcessorNumber=runtime.availableProcessors();
        return ProcessorNumber;
        
    }
}
