package com.appdynamics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;



public class eCommerce
{
  public static void main(String[] args)
  {
    boolean running = true;

    ExecutorService executor = Executors.newFixedThreadPool(100);

    while (running) {
      eCommerceThread eCommerceThread = new eCommerceThread();
      executor.execute(eCommerceThread);
      try
      {
        TimeUnit.MILLISECONDS.sleep(500L);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    executor.shutdown();
    while (!executor.isTerminated()) {}
  }
}
