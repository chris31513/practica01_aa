all:
	javac src/Adoc.java
	javac -cp src/core.jar:. src/Principal.java
	java -cp src/core.jar:. src/Principal
clean:
	rm *.class
