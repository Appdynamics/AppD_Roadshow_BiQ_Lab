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

### 1.2.2. Build your own

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

# Lab Parts

* [Main Business Logic](/com/appdynamics/eCommerceThread.java)

[controller url]: https://appd-ga.appd.duckdns.org
[events url]: https://events.appd.duckdns.org
