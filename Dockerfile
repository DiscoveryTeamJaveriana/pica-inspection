FROM openjdk:8-jdk-alpine
COPY target/pica-inspection-0.0.1-SNAPSHOT.jar pica-inspection.jar
ENTRYPOINT ["java", "-jar", "pica-inspection.jar"]