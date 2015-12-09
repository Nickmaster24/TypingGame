package com.gmail.nickmaster24;

import java.io.Console;
import java.util.Timer;

/**
 * @author nickm_000
 * @since 12/9/2015.
 */
public class TimerTask implements Runnable {

    private ConsoleInputTask toTrigger;
    private String[] args;
    private long time;

    public TimerTask(ConsoleInputTask toTrigger, String[] args, long time){
        this.toTrigger = toTrigger;
        this.args = args;
        this.time = time;
    }

    public void run(){
        try {
            Thread.sleep(time);
        } catch( InterruptedException e ) {
            //We will just trigger early
        } finally {
            toTrigger.trigger(args);
        }
    }
}
