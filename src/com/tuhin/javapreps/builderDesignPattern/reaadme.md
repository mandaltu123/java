Reference : http://www.newthinktank.com/2012/09/builder-design-pattern-tutorial/#comment-114298

You use the builder design pattern when you want to have many classes help in the creation of an object. By having
different classes build the object you can then easily create many different types of objects without being forced to
rewrite code.

This pattern allows a client object to construct a complex object by specifying only its type and content, being
shielded from the details related to the objects representation. This way the construction process can be used to
create different representations. The logic of this process is isolated form the actual steps used in creating the
complex object, so the process can be used again to create a different object form the same set of simple objects as
the first one.


RobotPlan.java          [This is the interface that will be returned from the builder]
Robot.java              [The concrete Robot class based on the RobotPlan interface]
RobotBuilder.java       [Defines the methods needed for creating parts for the robot]
OldRobotBuilder.java    [The concrete builder class that assembles the parts of the finished Robot object]
RobotEngineer.java      [The director / engineer class creates a Robot using the builder interface that is defined                                  (OldRobotBuilder)]
TestRobotBuilder.java   [client to test whether we are getting correct robot or not ]