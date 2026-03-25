#!/bin/bash
./gradlew bootRun --args="--spring.profiles.active=dev --DB_USER=dio.avenger --DB_PASSWORD=dio.avenger --DB_NAME=avengers" -Porg.gradle.jvmargs="-Xmx256m -Xms128m"