all:
	javac src/Adoc.java
	javac -cp lib/core.jar:. src/Principal.java
	java -cp lib/core.jar:. src/Principal
clean:
	rm src/*.class
