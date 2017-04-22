/*     */ package com.appdynamics;
/*     */ 
/*     */ import java.util.Random;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class eCommerceThread
/*     */   implements Runnable
/*     */ {
/*  13 */   private static final Logger log = Logger.getLogger(eCommerceThread.class.getName());
/*     */   private String sessionID;
/*     */   
/*  16 */   public static int randInt(int min, int max) { Random rand = new Random();
/*  17 */     int randomNum = rand.nextInt(max - min + 1) + min;
/*  18 */     return randomNum;
/*     */   }
/*     */   
/*     */   public String getSessionID() {
/*  22 */     return this.sessionID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void run()
/*     */   {
/*  37 */     RandomCustomer randomCustomer = new RandomCustomer();
/*  38 */     String customerType = randomCustomer.customerType;
/*  39 */     String customerEmail = randomCustomer.customerEmail;
/*  40 */     String productType = randomCustomer.productType;
/*  41 */     String productCategory = randomCustomer.productCategory;
/*  42 */     String productName = randomCustomer.productName;
/*  43 */     Integer productPrice = randomCustomer.productPrice;
/*     */     
/*     */ 
/*  46 */     this.sessionID = ("Session" + randInt(1, 1000000));
/*     */     
/*     */ 
/*  49 */     boolean nextStep = homePage();
/*     */     int price;
/*  51 */     if (nextStep) {
/*  52 */       nextStep = logIn();
/*     */       
/*  54 */       if (nextStep) {
/*  55 */         nextStep = addToCart();
/*     */         
/*  57 */         if (nextStep) {
/*  58 */           price = checkOut(customerType, customerEmail, productType, productCategory, productName, productPrice);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean homePage()
/*     */   {
/*  67 */     processTransaction();
/*     */     
/*     */ 
/*     */ 
/*  71 */     int rand = randInt(1, 100);
/*  72 */     if (rand <= 95) {
/*  73 */       normalTransaction();
/*  74 */     } else if ((rand > 95) && (rand <= 98)) {
/*  75 */       slowTransaction();
/*  76 */     } else if (rand > 98) {
/*  77 */       errorTransaction("Random Error!");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  82 */     rand = randInt(1, 100);
/*  83 */     if (rand <= 85) {
/*  84 */       return true;
/*     */     }
/*  86 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean logIn()
/*     */   {
/*  92 */     processTransaction();
/*     */     
/*     */ 
/*     */ 
/*  96 */     int rand = randInt(1, 100);
/*  97 */     if (rand <= 95) {
/*  98 */       normalTransaction();
/*  99 */     } else if ((rand > 95) && (rand <= 98)) {
/* 100 */       slowTransaction();
/* 101 */     } else if (rand > 98) {
/* 102 */       errorTransaction("Random Error!");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 108 */     rand = randInt(1, 100);
/* 109 */     if (rand <= 75) {
/* 110 */       return true;
/*     */     }
/* 112 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean addToCart()
/*     */   {
/* 118 */     processTransaction();
/*     */     
/*     */ 
/*     */ 
/* 122 */     int rand = randInt(1, 100);
/* 123 */     if (rand <= 95) {
/* 124 */       normalTransaction();
/* 125 */     } else if ((rand > 95) && (rand <= 98)) {
/* 126 */       slowTransaction();
/* 127 */     } else if (rand > 98) {
/* 128 */       errorTransaction("Random Error!");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 133 */     rand = randInt(1, 100);
/* 134 */     if (rand <= 30) {
/* 135 */       return true;
/*     */     }
/* 137 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public int checkOut(String customerType, String customerEmail, String productType, String productCategory, String productName, Integer itemPrice)
/*     */   {
/* 143 */     processTransaction();
/*     */     
/*     */ 
/*     */ 
/* 147 */     if (((customerType.equals("Platinum")) && (productName.equals("Lord of the Rings Trilogy"))) || ((customerType.equals("Gold")) && (productName.equals("Sacred Hoops")))) {
/* 148 */       errorTransaction("Invalid SKU!");
/*     */     }
/*     */     else
/*     */     {
/* 152 */       int rand = randInt(1, 100);
/* 153 */       if (rand <= 95) {
/* 154 */         normalTransaction();
/* 155 */       } else if ((rand > 95) && (rand <= 98)) {
/* 156 */         slowTransaction();
/* 157 */       } else if (rand > 98) {
/* 158 */         errorTransaction("Random Error!");
/*     */       }
/*     */     }
/*     */     
/* 162 */     return itemPrice.intValue();
/*     */   }
/*     */   
/*     */   public void processTransaction() {
/*     */     try {
/* 167 */       TimeUnit.MILLISECONDS.sleep(randInt(100, 200));
/*     */     } catch (InterruptedException e) {
/* 169 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public void normalTransaction() {
/* 174 */     try { TimeUnit.MILLISECONDS.sleep(randInt(800, 1000));
/*     */     } catch (InterruptedException e) {
/* 176 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public void slowTransaction() {
/*     */     try {
/* 182 */       TimeUnit.MILLISECONDS.sleep(randInt(3000, 4000));
/*     */     } catch (InterruptedException e) {
/* 184 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public void errorTransaction(String errorMsg) {
/*     */     try {
/* 190 */       throw new RuntimeException(errorMsg);
/*     */     } catch (RuntimeException ex) {
/* 192 */       log.log(Level.SEVERE, ex.toString(), ex);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/michael.englert/Downloads/home/ubuntu/SampleApplication/BiQLevel1.jar!/com/appdynamics/eCommerceThread.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */