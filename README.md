# jmeter-internal-queue

#### Why do you need Queueing in JMeter scenario
If you have a Producer Consumer kind of usecase
* You have one producer threadgroup 
* You have multiple consumer threadgroups that want to service the same producer

#### How its implemented
Inside Java code we have a simple singleton class with a ConcurrentLinkedDeque private object. We can put String objects and retrieve them from multiple threads.
Script in the jmeter directory is a sample implementation.

#### How to use the Jmeter script
For using the Jmeter script, you will need to :

* Add the java project's `<Project>/target/classes` directory path in "user.classpath" variable inside jmeter.properties file
OR
* Run the mvn package target and copy the compiled jar inside `<Jmeter_Home>/lib/ext` directory.
(You might have to restart the jmeter instance)

>**Note:** The ConcurrentQueueSingleton class being singleton, is a single copy for the jmeter instance. If you run a script multiple times from a gui, without using `clear()` method call, you will see that message count in the queue will keep on increasing. Please keep a close eye on the jmeter gc, since the queue is unbounded.

>**Note:** Additionally, If you want to be safe and not run out of memory on your jmeter script, you can implemant a LinkedBlockingDeque (bounded/blocking) inside the singleton object.  More details on bounded queue can be found here: https://www.baeldung.com/java-blocking-queue
