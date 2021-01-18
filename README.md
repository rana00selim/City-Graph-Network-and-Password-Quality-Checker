# Project-3.3
___________________________________________________________________________________________________________________________________________
.**************A) Password checker.**************
Write a program that reads in a string password from the command line and checks whether the password is a "good" one.
Your program must also read a dictionary of words from a file (see words.txt) and mostly used password dictionary from a second file.
A "good" password means that it  

  (i) is at least 5 characters long,  
  (ii) is not a word in the english dictionary or mostly used password dictionary,  
  (iii) is not a word in the dictionary followed/prefixed by a digit 0-9 (e.g., hello5, 5hello),  

•	Your searches must be performed in constant time, regardless of dictionary sizes. I.e. O(1)  complexity. 

___________________________________________________________________________________________________________________________________________
.**************B) City Graph Network.**************

In this project you will model the distances between cities of a country. 
Our weighted graph will represent this by edge-weights equal to the number of co-occurences. 

 City is an object with name.  The graph vertices are Cities.
 
A)	createCitiesFile(E,V) //creates the cities.txt randomly

B)	createCityGraph(‘cities.txt’) // loads cities.txt and returns a graph

C)	printCloseCities(tocity) //distance is less than 100km

D)	printFartherCities(tocity) // distance is higher than 500km 

E)	isconnected(city1, city2): User gives two cities, your program searches and prints whether these two cities are connected.

F)	pathTo(city1, city2): User gives two cities, your program searches and prints the path from city1 to city2 with least number of hopes. **Empty

G)	NumberofCityGroups: Print the number of city (connected component) groups.

H)	MinimumDistance(city1, city2): User gives two cities, your program searches and prints the path minimum distance path from city1 to city2 and the path length in km. **Empty



