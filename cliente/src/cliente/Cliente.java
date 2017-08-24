/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author jmliani
 */
public class Cliente {
    
  
    public static void main(String[] args) {
        
    ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
    
        try {
            client cli = new client();
            long intevalPeriod = 1;
            //scheduleAtFixedRate(Runnable command,long initialDelay,long period,TimeUnit unit)
            service.scheduleAtFixedRate(cli, 0, intevalPeriod, TimeUnit.MINUTES);
        } catch (IOException ex) {
            
        }
    
    
        
    }
    
}
