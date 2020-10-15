# About project

This is a simple solution for solving the shortest path between the nodes in the graph.

Project based on the next stack of technologies: JavaFX, JDBC, JDK11, JUnit5, Maven.

I didn't find simple solution for creating executable jar file casue I don't well 
familiar with java package module system so for running this project you should use
javafx maven plugin.

#### Was developing and testing on:

- Linux mint 20.04
- OpenJDK11 

### Pre Requirements

You need to have been installed JDK11 and Maven on your machine,
Linux terminal or something the same.

### How to open project

- You should clone or download repository
- To perform the compilation process please 
run next command on your terminal inside project folder

```
mvn javafx:compile
```
- For running project and open app please enter command below
```
mvn javafx:run
```

### How to use App
Application build like a wizard 
and when you use it you go from one window to another.

When the program starts you can see the main window which looks like small square.
Inside the square you can see Label that tell you what to do and action button.
When you push the button and perform action, application push you
to the next window. All windows look the same.

List of all app windows:
- upload a pipeline system as CSV file:
System parses the file and save data inside the H2 embedded database, so you can find new database file inside the project folder.
- upload a set of points as CSV file:
System parses the file and save data in app memory
- select output directory: System save output directory
- save results in a file: System make necessary calculations and save them on the output file
- well done: System show window if file saved properly, and you can go to the home page.

### Be aware about system behavior

- System can save in database only new pipes, 
if pipe already present system will ignore it.
- Datasets should be in proper format
- When something goes wrong application shows a warning message
- POINT VALUE SHOULD BE BETWEEN 0 AND 32767

### Algorithm

There are two algorithms involve in calculation process:
- Depth First Search algorithm with complexity O(V+E) for checking are points connected
- Dijkstra algorithm with complexity O(V^2) for calculating shortest path between them

where V - vertex and E - edge

### Goodies

For quick testing and better understanding what type 
of dataset is valid please visit datasets folder inside the project folder.
Here you can find dataset samples like pipeline system dataset and set of points dataset.
