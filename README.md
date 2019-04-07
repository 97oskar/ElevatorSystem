<h4>Elevator Control System<h4> 

<h5>System architecture:<h5>

The system consist of the following components:
1) Elevator System - A class representing the elevator control system. It provides an interface needed to interact with the system:
    - pickup(Int floorNumber, Int direction) - forward the order to the distributor of orders;
    - step() - taking another step time, which corresponds to one elevator activity;
    - status() - returns the status of all elevators in the system;
    
    It stores:
    - information about the number of floors;
    - component responsible for the distribution of orders for lifts;
    - elevators;
    
2) Elevator - A class representing the elevator in the system. 
It consists of:
    - the state - interface which injects the way the elevator is taking the next step.;
    - id number;
    - current location;
    - the next direction;
    - collection of commands that are provided by the order distributor
     located in the system;

3) Elevator Status - A class that represents the status of the elevator. 
It consists of:
    - elevator id;
    - number of current floor;
    - number of the target floor
    
4) Stateful - an interface which injects the way the elevator is taking the next step.
5) Orderable - an interface that implements the method of executing
 the processes delivered by the distributor to the elevator
6) DistributingOrders - an interface that implements the order distribution 
process.

<h5>Short description<h5>

The system accepts the order which is forwarded to the distributor.
Distributor distributes commands to elevators based on the implemented algorithm. 
The command received by the elevator, sets a new state of the elevator, which determines its behavior in the next step.

Used patterns:
- Strategy Design Pattern;
- State Design Pattern;
- Command Design Pattern;

That architecture makes the system robust. There is a possibility to make new commands, 
states, and distribution algorithms without the need to change the implementation of 
Elevator System or Elevator. You can simply make a new class of Command, 
State or Distribution Algorithm and use it in the system.

<h5>Distribution algorithm<h5>

The algorithm selects a set of free elevators and a set of elevators that are going 
to the same direction that the order declares. After that, it chooses the nearest 
elevator from every set and compares their distances from the floor on which the order 
occurred. It chooses elevator which is closest to the order and give it a commend "move to order". 
If there are no elevators that are free, or that are going in the same direction, 
the algorithm chooses the nearest elevator in the whole system. 

<h5>How to run simulation<h5>

     In order to run simulation you must provide two arguments:
     - integer number of elevators
     - integer number of floors
     
     for example:
     5 12