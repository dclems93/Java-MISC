# Design Patterns : Mercedes Webapp

This was the final assignment for the Design Patterns course. It was done as a group with a few other students. The Mercedes Webapp is a JSP application that implements several different design patterns that we learned over the course of the semester into one large web application, including the factory design, singleton, proxy, and decorator. 

The application allows users to create an account, which will be stored on a database and allow them to log back in at a later time. Users can then view the different models of car that are available in the inventory of 3 different Mercedes locations, one in Bloomington, one in Chicago, and one in NYC. 

Each Mercedes store location has a different selection of cars available each with different features like Navigation or Bluetooth. 

There are three different models of car offered total, the Model One, Two, and Three. Each car implements a Mercedes interface and inherits a makeCar and makePayment method that will return the cost of the car.

There is also a Decorator abstarct class that implements the Mercedes interface as well. Bluetooth and Navigation extend this abstract class to allow the cars to have more features. Because of the implementation of abstract classes and interfaces, creating a car can be achieved and adding features like bluetooth or navigation are simple. Requesting the price of that car will return the base cost of the car plus all of the features that have been added to it.