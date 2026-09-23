weight= input('WHAT IS YOUR WEIGHT(POUNDS)? ')
weight2 = float(weight)/ 2.2
print ('YOUR WEIGHT IN KGS: ' + str(weight2) )
course = ''' 
 THIS IS MY PROGRAM
 I AM JUST LEARNING PYTHON
 MY NAME IS SHEMA
 ''' #printing a multi line string
print (course)

course1= 'python for beginners'
print(course1[0]) #returns character in course1 in that index "p"
print(course1[-1])# returns characters starting from the end. "s"
print(course1[0:3]) #returns characters from 0,1,2 and excludes 3
print(course1[0:]) #returns all characters from 0 to the end of the string
print (course1[:5]) #here python assumes 0 as the start index and returns 0,1,2,3,4

print (course1[:]) #returns all the characters
#if another = course[:] , this means that this variable is a copy of course1

#FORMATTED STRINGS
#a formated string is one that is prefixed with an f
first = 'Shema'
last = 'Kevine'
message = first + ' [' + last + '] ' + 'is a coder.'
print(message) # this returns Shema [Kevine] is a coder.
msg = f'{first} [{last}] is a coder.' #this is a formatted string
print(msg) # this returns Shema [Kevine] is a coder.

print(len(course)) #len function returns the length of  a string
print(message.upper()) #all charactcers to upper case
print(message.lower()) #all characters to lower case
print(message.find('n')) #returns index of the first occurance of that character
print(message.find('Shema')) #returns the index of that word, but its first character hence 0
print(message.replace('Kevine','Starrrr')) #replaces that word or character
print ('Shema' in message) #in-operator that returns a boolean to determine if that variable contains that word or character

#AURITHMETICS 
print(10+3) #addition
print(10-3) #subtraction
print(10*3) #multiplication
print(10/3) #returns floating point number 3.3333333333
print(10//3) #returns an integer 3
print(10%3) #return remainder hence 1
print(10**3) # exponent operator that returns 10 power 3 hence 1000
x=10
x= x+3 #is the same as x+=3
#BODMAS
#parenthesis,exponentiation,division,multiplication,addition,subtraction

x = 4.6
y = -5.0
print(round(x)) #operator function that rounds off the value of x
print(abs(y)) #function that returns the positive representaion of a number if its negative










































