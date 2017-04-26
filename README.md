Business iQ Hands-On Lab
======
# 1. Accessing the Lab
## 1.1. Controller
* [Controller URL]
* Credentials will be provided during the Lab Session

## 1.2. Accessing the Lab Application

You can either run the Application via Docker on your local machine or use an already provisioned instance.

What's in it?
* Sample Application
* Java Application Agent
* Analytics Agent

### 1.2.1. Pre-Provisioned instance

* Linux/MacOS
  * [Download SSH Key](biq_lab.pem)
  * Change Permissions ```chmod 400 biq_lab.pem```
  * Login ```ssh -i biq_lab.pem -p <PORT> root@<IP>```(Port and IP will be provided during the Lab Session)
* Windows
  * [Download Putty](http://www.putty.org/)
  * [Download SSH Key](biq_lab.ppk)
  * Provide Connection Details within  ```Session``` (Port and IP will be provided during the Lab Session)
  * Import SSH Key in ```Connection -> SSH -> Auth -> Private Key File for Authentication:```
  * Login as root

### 1.2.2. Build your own (Optional)

**Docker is a Pre-Requisite do perform these steps**

* Clone this repository ```$ git clone https://github.com/michaelenglert/AppD_Summit_BiQ_Lab```
* Change into Docker directory ```cd AppD_Summit_BiQ_Lab/Docker```
* Create Image ```./run.sh```
  * The script will prompt for your AppDynamics Portal Credentials (Two-Factor Authentication is **not supported**)
* Run the container ```docker run -d -e APPDYNAMICS_AGENT_APPLICATION_NAME=<YOUR APPLICATION> --name <NAME> michi/biqlab```
* Open a console ```docker exec -ti <NAME> /bin/bash```

# 2. Setup Analytics

## 2.1. Configure the Analytics Agent

* Edit the Properties File ```vi /analytics-agent/conf/analytics-agent.properties```
  * ad.controller.url=[Controller URL] **(New in 4.3)**
  * http.event.endpoint=[Events URL]
  * http.event.name=customer1 **(New in 4.3)**
  * http.event.accountName=customer1_bacabe1d-9659-4250-857f-5818619da483
  * http.event.accessKey=H16h53cur3
* Start the Analytics Agent ```nohup /analytics-agent/bin/analytics-agent.sh start &```

## 2.2. Enable Analytics in the Controller UI

* Login to the [Controller URL]
* Navigate to ```Analytics -> Configuration -> Transaction Analytics```
* Select ```<YOUR APPLICATION>``` under the ```Configure Analytics for Application``` Dropdown
* Click on the checkbox ```Enable Analytics Data Collection for <YOUR APPLICATION>```
* Wait 1-2 minutes
* Navigate to ```Analytics -> Searches```
* Click the ```Add``` Button and Select any of the available options
* You should now see Transactions in the UI
* **Ask your Instructor if this does not happen**

# 3. Enhance your Transactions with more Data

## 3.1. Get the Session ID

* Look at the [Main Business Logic]
  * Find the getter Method returning the Session ID as a String
  * Find a Method which is executed within every Transaction (homePage, logIn,...)
* Configure the Method Invocation Data Collector
  * Navigate to ```Analytics -> Configuration -> Transaction Analytics```
  * Select ```<YOUR APPLICATION>``` under the ```Configure Analytics for Application``` Dropdown
  * Add a new Data Collector under ```Method Invocation Data Collectors```
  * Give it a Name like **SessionID**
  * Make sure ```Transaction Analytics``` is checked
  * Define the Class Name ```com.appdynamics.eCommerceThread```
  * Define the Method Name ```processTransaction```
  * Add a Collector under ```Specify the Data to Collect from this Method Invocation```
    * Give it a Name **This is how the Field will be named within the UI**
    * Select ```Invoked Object```
    * Select ```Use Getter Chain``` and type in ```getSessionID()```
    * Hit ```Save``` and make sure to apply the Collector to all your Business Transactions
* Wait 1-2 minutes
* You should now see your new Field within the Analytics UI
* **Ask your Instructor if this does not happen**

## 3.2. Get Data from Checkout

* Look at the [Main Business Logic]
  * Find the ```checkOut``` Method
* Add a new Data Collector as before to get additional Data
* **Hints**
  * Use the ```Method Parameter``` Option instead of ```Invoked Object```before
  * You can stick to ```toString()``` No need to specify a custom getter Chain
  * You can add multiple Parameters within one Data Collector
  * Make sure to apply this Data Collector only to your ```Checkout``` Business Transaction

# 4. Exploring your Data


[Main Business Logic]: /com/appdynamics/eCommerceThread.java
[controller url]: https://appd-ga.appd.duckdns.org
[events url]: https://events.appd.duckdns.org
