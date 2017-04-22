package com.appdynamics;

import java.util.Random;

public class RandomCustomer {
  public String customerType;
  public String customerEmail;
  public String productType;

  public static int randInt(int min, int max) {
    Random rand = new Random();
    int randomNum = rand.nextInt(max - min + 1) + min;
    return randomNum;
  }



  public String productCategory;


  public String productName;


  public Integer productPrice;

  public RandomCustomer()
  {
    int rand = randInt(1, 100);
    if (rand <= 5) {
      this.customerType = "Platinum";
      this.customerEmail = "bsmith@foo.com";
    } else if ((rand > 5) && (rand <= 10)) {
      this.customerType = "Platinum";
      this.customerEmail = "arod@foo.com";
    } else if ((rand > 10) && (rand <= 15)) {
      this.customerType = "Platinum";
      this.customerEmail = "tclark@foo.com";
    } else if ((rand > 15) && (rand <= 20)) {
      this.customerType = "Platinum";
      this.customerEmail = "fclancy@foo.com";
    } else if ((rand > 20) && (rand <= 25)) {
      this.customerType = "Gold";
      this.customerEmail = "manderson@foo.com";
    } else if ((rand > 25) && (rand <= 30)) {
      this.customerType = "Gold";
      this.customerEmail = "kjane@foo.com";
    } else if ((rand > 30) && (rand <= 40)) {
      this.customerType = "Gold";
      this.customerEmail = "lherbs@foo.com";
    } else if ((rand > 40) && (rand <= 50)) {
      this.customerType = "Gold";
      this.customerEmail = "mryan@foo.com";
    } else if ((rand > 50) && (rand <= 60)) {
      this.customerType = "Silver";
      this.customerEmail = "ebradford@foo.com";
    } else if ((rand > 6) && (rand <= 70)) {
      this.customerType = "Silver";
      this.customerEmail = "fthompson@foo.com";
    } else if ((rand > 70) && (rand <= 80)) {
      this.customerType = "Silver";
      this.customerEmail = "rjohnson@foo.com";
    } else if (rand > 80) {
      this.customerType = "Silver";
      this.customerEmail = "tcleary@foo.com";
    }


    rand = randInt(1, 100);
    if (this.customerType.equals("Platinum")) {
      if (rand <= 40) {
        this.productType = "Book";
        this.productCategory = "Fiction";
        this.productName = "Lord of the Rings Trilogy";
        this.productPrice = Integer.valueOf(35);
      } else if ((rand > 40) && (rand <= 60)) {
        this.productType = "Book";
        this.productCategory = "Non-Fiction";
        this.productName = "Freakonomics";
        this.productPrice = Integer.valueOf(12);
      } else if ((rand > 60) && (rand <= 80)) {
        this.productType = "Book";
        this.productCategory = "Fiction";
        this.productName = "Personal";
        this.productPrice = Integer.valueOf(14);
      } else if (rand > 80) {
        this.productType = "Music";
        this.productCategory = "Rock";
        this.productName = "Dark Side of the Moon";
        this.productPrice = Integer.valueOf(0);
      }
    } else if (this.customerType.equals("Gold")) {
      if (rand <= 50) {
        this.productType = "Book";
        this.productCategory = "Non-Fiction";
        this.productName = "Sacred Hoops";
        this.productPrice = Integer.valueOf(11);
      } else if ((rand > 50) && (rand <= 75)) {
        this.productType = "Book";
        this.productCategory = "Fiction";
        this.productName = "The Fist of God";
        this.productPrice = Integer.valueOf(12);
      } else if ((rand > 75) && (rand <= 90)) {
        this.productType = "Music";
        this.productCategory = "Rock";
        this.productName = "Ride the Lightning";
        this.productPrice = Integer.valueOf(9);
      } else if (rand > 90) {
        this.productType = "Music";
        this.productCategory = "Jazz";
        this.productName = "Karma";
        this.productPrice = Integer.valueOf(12);
      }
    } else if (this.customerType.equals("Silver")) {
      if (rand <= 30) {
        this.productType = "Music";
        this.productCategory = "Jazz";
        this.productName = "Ascension";
        this.productPrice = Integer.valueOf(5);
      } else if ((rand > 30) && (rand <= 60)) {
        this.productType = "Book";
        this.productCategory = "Fiction";
        this.productName = "Farewell to Arms";
        this.productPrice = Integer.valueOf(4);
      } else if ((rand > 60) && (rand <= 80)) {
        this.productType = "Book";
        this.productCategory = "Fiction";
        this.productName = "The Tourist";
        this.productPrice = Integer.valueOf(5);
      } else if (rand > 80) {
        this.productType = "Music";
        this.productCategory = "Rock";
        this.productName = "Green River";
        this.productPrice = Integer.valueOf(6);
      }
    }
  }
}
