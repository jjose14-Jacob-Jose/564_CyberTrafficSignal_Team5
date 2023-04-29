# 564_CyberTrafficSignal_Team5

------------------------------------------

## Development Environment Setup:
1. Java Development Kit.
2. Maven 
3. Eclipse
---------------
## To execute:
In project-directory execute following commands.
1. Import the project folder to Eclipse.
2. Go to Application.Java file
3. Execute file by clicking on "Run Java Application"
4. If you want to test how the application behaves for different test data, refer below section
----------------------------------
## Input Value file: inputData.txt:
###### The text file 'inputData.txt' at location 'src/main/resources/inputData.txt' has input data  
 The data is in the following format. Each row represents a round. 

###### (Following are integer values)
North-Bound Incoming Vehicles, North-Bound OutGoing Vehicles, 
South-Bound Incoming Vehicles, South-Bound OutGoing Vehicles, 
East-Bound Incoming Vehicles, Ease-Bound OutGoing Vehicles, 
West-Bound Incoming Vehicles, West-Bound OutGoing Vehicles,
Webster's Critical Flow constant value for North-South direction,
Webster's Critical Flow constant value for East-West direction,
###### (Following are boolean values)
Boolean Value for emergency vehicle presence in North side,  
Boolean Value for emergency vehicle presence in South side,  
Boolean Value for emergency vehicle presence in East side,  
Boolean Value for emergency vehicle presence in West side

##### Example
10,30,20,30,55,0,65,0,1000,1250,false,true,false,false
- North-bound Incoming vehicles: 10
- North-bound Outgoing vehicles: 30
- South-bound Incoming vehicles: 20
- South-bound Outgoing vehicles: 30
- East-bound Incoming vehicles: 55
- East-bound Outgoing vehicles: 0
- West-bound Incoming vehicles: 65
- West-bound Outgoing vehicles: 0
- Webster's Critical Flow constant value for North-South direction: 1000
- Webster's Critical Flow constant value for East-West direction: 1250
- North-bound Emergency presence: false 
- South-bound Emergency presence: true 
- East-bound Emergency presence: false 
- West-bound Emergency presence: false 
