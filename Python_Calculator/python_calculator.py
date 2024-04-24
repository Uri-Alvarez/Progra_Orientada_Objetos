# -*- coding: utf-8 -*-
"""Python_Calculator

Automatically generated by Colab.

Original file is located at
    https://colab.research.google.com/drive/1jA46c2u2Rwwz_GNQgPAoELhQCeQqdpfI
"""

# Amerike University
# Alvarez López Uri Yael.
# Object Oriented Programming
# Binary Calculator

import sympy as sp

#Menu function
def main():
    print("Calculator:")
    print("1. Addition")
    print("2. Subtraction")
    print("3. Multiplicator")
    print("4. Split")
    print("5. Square Root")
    print("6. Power")
    option = input("Choose an option: ")

    num1 = float(input("First Value: "))
    num2 = float(input("Second Value: "))

    if option == '1':
        print(add(num1, num2))
    elif option == '2':
        print(sub(num1, num2))
    elif option == '3':
        print(mult(num1, num2))
    elif option == '4':
        print(split(num1, num2))
    elif option == '5':
        print("Only the first value is valid for the square root")
        print(square(num1))
    elif option == '6':
        print("The first value will be your base and the second the power")
        print(power(num1, num2))
    else:
        print("Invalid option")

#addition function
def add(x, y):
    return x + y

#subtraction function
def sub(x, y):
    return x - y

#multiplication function
def mult(x, y):
    return x * y

#Split function
def split(x, y):
    return x / y

#mathematical power function
def power(x, y):
    return x ** y

#square root function
def square(x):
    return sp.sqrt(x)

#
main()