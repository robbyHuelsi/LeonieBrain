package org.yakindu.scr;

import org.yakindu.scr.TimerService;
import org.yakindu.scr.defaultsm.DefaultSMStatemachine;
import org.yakindu.scr.*;
    
    public class Start {
      public static void main(String[] args) throws InterruptedException {
          // Create the state machine:
          DefaultSMStatemachine sm = new DefaultSMStatemachine();
          sm.setTimer(new TimerService());
          // Initialize the state machine:
          sm.init();
          // Enter the state machine and implicitly activate its "Idle" state:
          sm.enter();
          
          // Accept the call:
          //sm.getSCIUser().raiseNext();
          sm.runCycle();
          // Keep the phone conversation busy for a while:
//          for (int i = 0; i < 50; i++) {
//              Thread.sleep(200);
//              sm.runCycle();
//          }
          // Before hang-up, output the duration of the call:
          System.out.println("The phone call took seconds.");
          // Hang up the phone:
          sm.runCycle();
      }
    }