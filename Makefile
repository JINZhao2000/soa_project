build: clean
	mvn compile

run-sv:
	mvn exec:java -pl sv

run-pe:
	mvn exec:java -pl pe

run-ad:
	mvn exec:java -pl ad

run-ie:
	mvn exec:java -pl ie

run-app:
	mvn exec:java -pl app

clean:
	mvn clean