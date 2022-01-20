This program implements a system to manage a Dairy Factory (Fctory in genral). The program contains different classes as described below.

Employee Class with the following informations/attributes: 
Employee name , Employee Number, Hire date, Address that composed of (street, state,city,zip code).

ProductionWorker Class inherited from the Employee class with the following informations/attributes:
Shift (an integer) ,Hourly pay rate (a double),Number of hours per month.

ShiftSupervisor Class that represents a shift supervisor which is an employee whose supervises a shift. In addition to a basic
salary, the shift supervisor earns a monthly bonus when his or her shift meets production goals.
ShiftSupervisor Class is inherited from the Employee class with the following informations/attributes:
monthly salary , monthly production bonus that a shift supervisor has earned ,Number of products that produced by team that he/she supervised,
 Number of products must produced under his/her supervision.

TeamLeader Class that represents team leader which is a production worker who leads a small team. In addition to hourly
pay, team leaders earn a fixed monthly bonus. Team leaders are required to attend a minimum number of hours of training per month. 
TeamLeader Class has the following informations/attributes:
Monthly Bonus ,Required Training Hours ,Training Hours Attended.
