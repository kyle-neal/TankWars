gradle-build:
	gradle build

run:
	java -jar build/libs/TankWars.jar

clean-run:
	gradle build
	java -jar build/libs/TankWars.jar
