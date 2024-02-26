package com.kinokarten.Helpers;

import com.kinokarten.Interfaces.KinoRunnable;

public class RunnableHelper {
    public static void runUntilCancelledByRunnable(KinoRunnable runnable, Object[] objects){
        boolean abbruch = false;
        while(!abbruch){
            abbruch = runnable.run(objects);            
        }

    }
}
