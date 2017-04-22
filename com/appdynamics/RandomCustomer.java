/*     */ package com.appdynamics;
/*     */ 
/*     */ import java.util.Random;
/*     */ 
/*     */ public class RandomCustomer {
/*     */   public String customerType;
/*     */   public String customerEmail;
/*     */   public String productType;
/*     */   
/*     */   public static int randInt(int min, int max) {
/*  11 */     Random rand = new Random();
/*  12 */     int randomNum = rand.nextInt(max - min + 1) + min;
/*  13 */     return randomNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String productCategory;
/*     */   
/*     */ 
/*     */   public String productName;
/*     */   
/*     */ 
/*     */   public Integer productPrice;
/*     */   
/*     */   public RandomCustomer()
/*     */   {
/*  28 */     int rand = randInt(1, 100);
/*  29 */     if (rand <= 5) {
/*  30 */       this.customerType = "Platinum";
/*  31 */       this.customerEmail = "bsmith@foo.com";
/*  32 */     } else if ((rand > 5) && (rand <= 10)) {
/*  33 */       this.customerType = "Platinum";
/*  34 */       this.customerEmail = "arod@foo.com";
/*  35 */     } else if ((rand > 10) && (rand <= 15)) {
/*  36 */       this.customerType = "Platinum";
/*  37 */       this.customerEmail = "tclark@foo.com";
/*  38 */     } else if ((rand > 15) && (rand <= 20)) {
/*  39 */       this.customerType = "Platinum";
/*  40 */       this.customerEmail = "fclancy@foo.com";
/*  41 */     } else if ((rand > 20) && (rand <= 25)) {
/*  42 */       this.customerType = "Gold";
/*  43 */       this.customerEmail = "manderson@foo.com";
/*  44 */     } else if ((rand > 25) && (rand <= 30)) {
/*  45 */       this.customerType = "Gold";
/*  46 */       this.customerEmail = "kjane@foo.com";
/*  47 */     } else if ((rand > 30) && (rand <= 40)) {
/*  48 */       this.customerType = "Gold";
/*  49 */       this.customerEmail = "lherbs@foo.com";
/*  50 */     } else if ((rand > 40) && (rand <= 50)) {
/*  51 */       this.customerType = "Gold";
/*  52 */       this.customerEmail = "mryan@foo.com";
/*  53 */     } else if ((rand > 50) && (rand <= 60)) {
/*  54 */       this.customerType = "Silver";
/*  55 */       this.customerEmail = "ebradford@foo.com";
/*  56 */     } else if ((rand > 6) && (rand <= 70)) {
/*  57 */       this.customerType = "Silver";
/*  58 */       this.customerEmail = "fthompson@foo.com";
/*  59 */     } else if ((rand > 70) && (rand <= 80)) {
/*  60 */       this.customerType = "Silver";
/*  61 */       this.customerEmail = "rjohnson@foo.com";
/*  62 */     } else if (rand > 80) {
/*  63 */       this.customerType = "Silver";
/*  64 */       this.customerEmail = "tcleary@foo.com";
/*     */     }
/*     */     
/*     */ 
/*  68 */     rand = randInt(1, 100);
/*  69 */     if (this.customerType.equals("Platinum")) {
/*  70 */       if (rand <= 40) {
/*  71 */         this.productType = "Book";
/*  72 */         this.productCategory = "Fiction";
/*  73 */         this.productName = "Lord of the Rings Trilogy";
/*  74 */         this.productPrice = Integer.valueOf(35);
/*  75 */       } else if ((rand > 40) && (rand <= 60)) {
/*  76 */         this.productType = "Book";
/*  77 */         this.productCategory = "Non-Fiction";
/*  78 */         this.productName = "Freakonomics";
/*  79 */         this.productPrice = Integer.valueOf(12);
/*  80 */       } else if ((rand > 60) && (rand <= 80)) {
/*  81 */         this.productType = "Book";
/*  82 */         this.productCategory = "Fiction";
/*  83 */         this.productName = "Personal";
/*  84 */         this.productPrice = Integer.valueOf(14);
/*  85 */       } else if (rand > 80) {
/*  86 */         this.productType = "Music";
/*  87 */         this.productCategory = "Rock";
/*  88 */         this.productName = "Dark Side of the Moon";
/*  89 */         this.productPrice = Integer.valueOf(0);
/*     */       }
/*  91 */     } else if (this.customerType.equals("Gold")) {
/*  92 */       if (rand <= 50) {
/*  93 */         this.productType = "Book";
/*  94 */         this.productCategory = "Non-Fiction";
/*  95 */         this.productName = "Sacred Hoops";
/*  96 */         this.productPrice = Integer.valueOf(11);
/*  97 */       } else if ((rand > 50) && (rand <= 75)) {
/*  98 */         this.productType = "Book";
/*  99 */         this.productCategory = "Fiction";
/* 100 */         this.productName = "The Fist of God";
/* 101 */         this.productPrice = Integer.valueOf(12);
/* 102 */       } else if ((rand > 75) && (rand <= 90)) {
/* 103 */         this.productType = "Music";
/* 104 */         this.productCategory = "Rock";
/* 105 */         this.productName = "Ride the Lightning";
/* 106 */         this.productPrice = Integer.valueOf(9);
/* 107 */       } else if (rand > 90) {
/* 108 */         this.productType = "Music";
/* 109 */         this.productCategory = "Jazz";
/* 110 */         this.productName = "Karma";
/* 111 */         this.productPrice = Integer.valueOf(12);
/*     */       }
/* 113 */     } else if (this.customerType.equals("Silver")) {
/* 114 */       if (rand <= 30) {
/* 115 */         this.productType = "Music";
/* 116 */         this.productCategory = "Jazz";
/* 117 */         this.productName = "Ascension";
/* 118 */         this.productPrice = Integer.valueOf(5);
/* 119 */       } else if ((rand > 30) && (rand <= 60)) {
/* 120 */         this.productType = "Book";
/* 121 */         this.productCategory = "Fiction";
/* 122 */         this.productName = "Farewell to Arms";
/* 123 */         this.productPrice = Integer.valueOf(4);
/* 124 */       } else if ((rand > 60) && (rand <= 80)) {
/* 125 */         this.productType = "Book";
/* 126 */         this.productCategory = "Fiction";
/* 127 */         this.productName = "The Tourist";
/* 128 */         this.productPrice = Integer.valueOf(5);
/* 129 */       } else if (rand > 80) {
/* 130 */         this.productType = "Music";
/* 131 */         this.productCategory = "Rock";
/* 132 */         this.productName = "Green River";
/* 133 */         this.productPrice = Integer.valueOf(6);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/michael.englert/Downloads/home/ubuntu/SampleApplication/BiQLevel1.jar!/com/appdynamics/RandomCustomer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */