package com.kinokarten.Helpers;

import com.kinokarten.Interfaces.KinoRunnable;

public class RunnableHelper {
    
    /** 
     * @param runnable
     * @param objects
     */
    public static void runUntilCancelledByRunnable(KinoRunnable runnable, Object[] objects){
        boolean abbruch = false;
        while(!abbruch){
            abbruch = runnable.run(objects);            
        }

    }
}
