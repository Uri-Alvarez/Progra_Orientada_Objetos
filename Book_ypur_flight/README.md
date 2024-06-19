# Book your flight

# Video:
https://youtu.be/VBHJRi97uPE

# Instructions:
Complete the book your flight code made in class such that you have the following classes:
a) Domestic Flight
	- The Id of a domestic flight must be of the form: NA-xxxx were x stands for a number
	- The flight map must look as follows and must contain 28 rows:
		A |OOO| |OOO|
		   ....
		- |123| |456|
	- Ticket Price must round between $300 and $500 dolars
	- Luggage allowance must be 10% of the ticket price

b) International Flight
	- The Id of a domestic flight must be of the form: [Origin][Destination]-xxxx were x stands for a number
	- The flight map must look as follows and must contain 28 rows:
		A |OOO| |OOO| |OOO|
		  ....
		- |123| |456| |789|
	- Ticket Price must round between $1000 and $2000 dolars
	- Luggage allowance must be 20% of the ticket price
		
c) Private Flight
	- The Id of a domestic flight must be of the form: PR-xx were x stands for a number
	- The flight map must look as follows and must contain 28 rows:
		A |OO| |OO|
		  ....
		- |12| |34|
	- Ticket Price must round between $3000 and $5000 dolars
	- Luggage allowance must be 25% of the ticket price

Asume that all flight leave from mexico city airport that is, the origin of all flight is CDMX.
Add a new float field to the Destinations enum, called "distance" such that it represents the distance from
mexico citys airport to the destination (the distance can be invented).

- The flight time is then define as follows:
	-if the distance if between 10kn and 30kn the flight duration is 3h
	-if the distance if between 30kn and 60kn the flight duration is 6h
	-if the distance if between 60km and 100km  the flight duration is 10h

d) Create a user class (ass well as the interface) that holds the user data:
	- User Full Name must not conteiner special characters or numbers (#$%&/)
	- Password must contain one special characters one capital letter and must be over 10 digital and must not contain more than 2 sequence of digits
	- Email must be of the form: myemail@gmail.com
	- PhoneNumber must start with +52 and must have only number and must not have more or less than 10 digits
	- country should be Mexico
	
	use regex no verify the above params are valid. Throw a "UserExecption" explaining the reason why the value
	is invalid (Create the exception class UserExecption).
	
e) Create a Class, as well as the interface, for a class named flightManager that will:
	1. Allows to create a new User provided its details:
		Full Name, email, phone, etc.
		Use:
			try {
				new User(...)
			}catch(){
				...
			} 
		to handle the errors. If an error ocurres ask for the user
		information again.
		
	2. Display the flight dashboard with the following info 
		| FLIGHT-ID | ORIGIN | DESTINATION | PRICE |
		|	... 	|		 |			   |	   |
		+------------------------------------------+
		Must show at least 10 diferent flights to diferent locations
		a. 4 National Flight, 
		b. 3 International Flights 
		c. 3 private flights
		
	3. Allow the user to select and buy a ticket as follows:
		1) The user is show the flight dashboard
		2) the user decides to buy a ticket for flight ORDS-XXXX
		3) the user provides the flight_id
		4) the user is shown the flight_map
		5) the user selects the sit by providing the sit number. Ex: A-05 (Verify the format using regex)
		6) the user is asked for is details: FullName, PhoneNumber, Email, Country, compare with your exisiting users verify or trow exception
		7) the user is given its tickets id: RE-XXXX
	4. Allow the user to retrieve it's flight details given the ticket-Id:
		1) the user gives the flight id: ORDS-XXXX
		2) the website returns the flight information all the information in the Ticket class @Ticket

	At time 0 there must be 10 list flights, see 1, and 5 diferent users
	
For all the above classes consider adding error handling logic, try catch and custom exceptions
