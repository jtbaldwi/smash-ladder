FROM java
COPY build/libs libs

WORKDIR libs
CMD ["java", "-jar", "smash-ladder.jar"]