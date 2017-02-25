# CareemHackathonIM

This module intends to manage the inventory.

The responsibility of this module are mainly the following:

a. Provide CRUD operations for Inventory dimensions : Car operators Information, Driver Information and Cars
   
   The data will be persisted in MongoDB. There will be three collections in the data base:
   
   i. CarOperatorCollection
      
      It has following fields:
             1.  Name
             2.  DOB
             3.  GovernmentProofID
             4.  BankAccountNumber
             5.  OperatorID
             6.  Address
             7.  City
             8.  Country
             
   ii. DriverCollection
   
    It has following fields:
             1.  Name
             2.  DOB
             3.  GovernmentProofID
             4.  driverID
             5.  Address
             6.  City
             7.  Country
             
   iii. CarCollection
   
    It has following fields:
            1. CarNumber
            2. CarID
            3. Model
            4. Manufacturer
            5. Make
            6. City
            7. Country
            8. DriverID
            9. OperatorID
            10. Country
  
  b. It will get the pings from devices kept in the car at every configured time interval. 
     The location of cars will be stored in SOLR via a kafka client. Kafka is used because the requests will be enormous and we need to        avoid failure due to time out . SOLR is used keeping in view that we need faster access to the enromous data that we have. Solr also      prvides geo sharding which should be used.
   
