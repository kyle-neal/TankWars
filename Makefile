JAVA_HOME ?= /usr/lib/jvm/java-17-openjdk-amd64
export JAVA_HOME

.PHONY: build run clean-run

build:
	gradle build

run:
	java -jar build/libs/TankWars.jar

clean-run:
	gradle build
	java -jar build/libs/TankWars.jar
