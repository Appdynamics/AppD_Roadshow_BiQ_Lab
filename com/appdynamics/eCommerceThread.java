package com.appdynamics;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class eCommerceThread implements Runnable {
  private static final Logger log = Logger.getLogger(eCommerceThread.class.getName());
  private String sessionID;

  public static int randInt(int min, int max) {
    Random rand = new Random();
    int randomNum = rand.nextInt(max - min + 1) + min;
    return randomNum;
  }

  public String getSessionID() {
    return this.sessionID;
  }

  public void run()
  {
    RandomCustomer randomCustomer = new RandomCustomer();
    String customerType = randomCustomer.customerType;
    String customerEmail = randomCustomer.customerEmail;
    String productType = randomCustomer.productType;
    String productCategory = randomCustomer.productCategory;
    String productName = randomCustomer.productName;
    Integer productPrice = randomCustomer.productPrice;

    this.sessionID = ("Session" + randInt(1, 1000000));

    boolean nextStep = homePage();
    int price;
    if (nextStep) {
      nextStep = logIn();

      if (nextStep) {
        nextStep = addToCart();

        if (nextStep) {
          nextStep = checkOut(customerType, customerEmail, productType, productCategory, productName, productPrice);
          if (nextStep) {
            nextStep = submitPayment();
            if (nextStep) {
              confirmation();
            }
          }
        }
      }
    }
  }

  public boolean homePage()
  {
    processTransaction();

    int rand = randInt(1, 100);
    if (rand <= 95) {
      normalTransaction();
    } else if ((rand > 95) && (rand <= 98)) {
      slowTransaction();
    } else if (rand > 98) {
      errorTransaction("Random Error!");
    }

    rand = randInt(1, 100);
    if (rand <= 85) {
      return true;
    }
    return false;
  }


  public boolean logIn()
  {
    processTransaction();

    int rand = randInt(1, 100);
    if (rand <= 95) {
      normalTransaction();
    } else if ((rand > 95) && (rand <= 98)) {
      slowTransaction();
    } else if (rand > 98) {
      errorTransaction("Random Error!");
    }

    rand = randInt(1, 100);
    if (rand <= 44) {
      return true;
    }
    return false;
  }


  public boolean addToCart()
  {
    processTransaction();

    int rand = randInt(1, 100);
    if (rand <= 95) {
      normalTransaction();
    } else if ((rand > 95) && (rand <= 98)) {
      slowTransaction();
    } else if (rand > 98) {
      errorTransaction("Random Error!");
    }

    rand = randInt(1, 100);
    if (rand <= 50) {
      return true;
    }
    return false;
  }

  public boolean checkOut(String customerType, String customerEmail, String productType, String productCategory, String productName, Integer itemPrice) {
    processTransaction();

    if (((customerType.equals("Platinum")) && (productName.equals("Lord of the Rings Trilogy"))) || ((customerType.equals("Gold")) && (productName.equals("Sacred Hoops")))) {
      errorTransaction("Invalid SKU!");
    }
    else
    {
      int rand = randInt(1, 100);
      if (rand <= 95) {
        normalTransaction();
      } else if ((rand > 95) && (rand <= 98)) {
        slowTransaction();
      } else if (rand > 98) {
        errorTransaction("Random Error!");
      }
    }

    rand = randInt(1, 100);
    if (rand <= 55) {
      return true;
    }
    return false;
  }

  public boolean submitPayment(){
    processTransaction();
    int rand = randInt(1, 100);
    if (rand <= 95) {
      normalTransaction();
    } else if ((rand > 95) && (rand <= 98)) {
      slowTransaction();
    } else if (rand > 98) {
      errorTransaction("Random Error!");
    }

    rand = randInt(1, 100);
    if (rand <= 57) {
      return true;
    }
    return false;

  }

  public void confirmation(){
    processTransaction();
    int rand = randInt(1, 100);
    if (rand <= 95) {
      normalTransaction();
    } else if ((rand > 95) && (rand <= 98)) {
      slowTransaction();
    } else if (rand > 98) {
      errorTransaction("Random Error!");
    }
  }

  public void processTransaction() {
    try {
      TimeUnit.MILLISECONDS.sleep(randInt(100, 200));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void normalTransaction() {
    try { TimeUnit.MILLISECONDS.sleep(randInt(800, 1000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void slowTransaction() {
    try {
      TimeUnit.MILLISECONDS.sleep(randInt(3000, 4000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void errorTransaction(String errorMsg) {
    try {
      throw new RuntimeException(errorMsg);
    } catch (RuntimeException ex) {
      log.log(Level.SEVERE, ex.toString(), ex);
    }
  }
}
