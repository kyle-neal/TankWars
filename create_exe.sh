#!/bin/sh

cd src/
rm -f TankWars.jar
jar cvfm TankWars.jar manifest.txt Driver.class */*.class */*/*.class
java -jar TankWars.jar
