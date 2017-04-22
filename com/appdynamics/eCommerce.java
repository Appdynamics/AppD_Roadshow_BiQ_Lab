/*    */ package com.appdynamics;
/*    */ 
/*    */ import java.util.concurrent.ExecutorService;
/*    */ import java.util.concurrent.Executors;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class eCommerce
/*    */ {
/*    */   public static void main(String[] args)
/*    */   {
/* 13 */     boolean running = true;
/*    */     
/* 15 */     ExecutorService executor = Executors.newFixedThreadPool(100);
/*    */     
/* 17 */     while (running) {
/* 18 */       eCommerceThread eCommerceThread = new eCommerceThread();
/* 19 */       executor.execute(eCommerceThread);
/*    */       try
/*    */       {
/* 22 */         TimeUnit.MILLISECONDS.sleep(500L);
/*    */       } catch (InterruptedException e) {
/* 24 */         e.printStackTrace();
/*    */       }
/*    */     }
/*    */     
/* 28 */     executor.shutdown();
/* 29 */     while (!executor.isTerminated()) {}
/*    */   }
/*    */ }


/* Location:              /Users/michael.englert/Downloads/home/ubuntu/SampleApplication/BiQLevel1.jar!/com/appdynamics/eCommerce.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */