Business iQ Hands-On Lab
======
# Accessing the Lab
## Controller
* [Controller UI](https://appd-ga.appd.duckdns.org)
* Credentials will be provided during the Lab Session

## Login to the Lab Application

You can either run the Application via Docker on your local machine or use an already provisioned instance.

What's in it?
* Sample Application
* Java Application Agent
* Analytics Agent

### Pre-Provisioned instance

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

### Build your own

* Clone this repository ```$ git clone https://github.com/michaelenglert/AppD_Summit_BiQ_Lab```
* Change into Docker directory ```cd AppD_Summit_BiQ_Lab/Docker```
* Create Image ```./run.sh```
  * The script will prompt for your AppDynamics Portal Credentials (Two-Factor Authentication is **not supported**)
* Run the container ```docker run -d --name <NAME> michi/biqlab```
* Open a console ```docker exec -ti <NAME> /bin/bash```

## Configure the Analytics Agent

* Edit the Properties File ```vi /analytics-agent/conf/analytics-agent.properties```
  * ad.controller.url=https://appd-ga.appd.duckdns.org **(New in 4.3)**
  * http.event.endpoint=https://events.appd.duckdns.org
  * http.event.name=customer1 **(New in 4.3)**
  * http.event.accountName=customer1_bacabe1d-9659-4250-857f-5818619da483
  * http.event.accessKey=H16h53cur3
* Start the Analytics Agent ```nohup /analytics-agent/bin/analytics-agent.sh start &```


### Test

* [Main Business Logic](/com/appdynamics/eCommerceThread.java)
