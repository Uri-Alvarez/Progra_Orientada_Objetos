# Homework 2

# Video:
https://youtu.be/eYZG4PvVJIQ

# Instructions
Your task is to develop a Java program for a bank organization that enables users to create an account via their phones. 
The program should utilize concepts like regular expressions, exception handling, interfaces, classes, and abstraction.

Instructions:

a) Account Creation Interface:

Define an interface named AccountInterface with the following abstract methods:
	1. void createAccount(String name, String email, String phoneNumber, double initialBalance) throws AccountCreationException
	2. String getAccountNumber()
	3. boolean set/getEmail(String email) throws AccountException
	4. boolean set/getPhoneNumber(String phoneNumber) throws AccountException
	5. boolean set/getName(String name) throws AccountException
	6. doble getBalance()
	7. doble withdraw(double amount) throws AccountException
	8. double transfer(double amount, String concept) throws AccountException
		Note*: this methods substract the amount of money from the account and stores the transaction for further consultance
	9. double String consultTransaction(String Id) throws AccountException

b) AccountException Class:
	Create a custom exception class named AccountException that extends Exception. 
	This exception should be thrown when account operations fails due to invalid an invalid Operation.

c) Create an Abstract Class AbstractAccount:
	Create an abstract class named AbstractAccount which implements the Account interface.
	Define concrete implementations of the following methods:
		1. boolean set/getEmail(String email) throws AccountException
		2. boolean set/getPhoneNumber(String phoneNumber) throws AccountException
		3. boolean set/getName(String name) throws AccountException
		4. doble getBalance()
		5. double String consultTransaction(String Id) throws AccountException
		6. String getAccountNumber()
		
		Note*: Use regular expressions to validate email and phone number formats.
		
	Add the following define class private parameters
		1. double accountLimit
		2. double openFee
		3. double maintainanceFee
		4. HashMap movements: {movementId, {type: "transactions" or "withdrawals", concept: "", amount: #}}
	
c) Account Class:
	Create classes PersonalAccount, SavingsAccount, and BusinnesAccount that extend AbstractAccount.
		1. Ensure the initial balance is a non-negative value.
		a) For PersonalAccount, 
			1. set a maximum withdrawal limit and enforce a minimum balance requirement.
				no maximum withdrawals
				max transference and withdrawal limit =  500$
				minimum balance = 1000$
				transactions concept can be anything
				openFee = 2$ and maintainanceFee = 10$
		b) For SavingsAccount, 
			1. enforce restrictions on the number of withdrawals and provide interest calculation mechanisms.
				maximum of 2 withdrawals
				no minimun balance
				max withdrawal of 500$
				no transaction are allowed
				account has an interest rate of 15%
				add a method to estimate the interest rate after n days: 
					double estimateInterest(int days);
				openFee = 0$ and maintainanceFee = 0$
		c) For BusinessAccount, 
			1. incorporate features like transaction categorization.
				no maximum withdrawals
				no transference and withdrawal limit
				minimum balance of 5000$
				transaction concept must belong to a busines category: "Payments", "Maintainance" (create an enum for this with at leat 10 busines categories)
				openFee = 100$ and maintainanceFee = 50$
		Consider: 
			1. When open an account the openFee and maintainanceFee are discount from the balance
			2. All transactions and withdrawals must be stored in the movements hash map
			3. The account number is a 18 long digit
			4. @Override the toString method to return the accound details

d) Main Class:
	Create a Main class with a main method to demonstrate the functionality of the account creation and operations.
		Inside the main method, prompt the user to enter their name, email, phone number, and initial balance.
		Use try-catch blocks to handle any exceptions thrown during account creation.
	
		If account creation is successful, print a success message along with the account details. Otherwise, catch and handle the AccountCreationException.
		
		Add examples that ilustrate the use of each kind of account
		
e) Submission Guidelines:

	Create a Java project with appropriate package structure.
	Include all necessary classes/interfaces in the project.
	Ensure your code follows Java coding conventions and is well-documented.

Note:
	Test your program thoroughly with various inputs to ensure it functions correctly.
	Use meaningful variable and method names to enhance code readability.
	Utilize abstraction to hide unnecessary implementation details from users of the Account class.
	Provide comments where necessary to explain your code logic.
