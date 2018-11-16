FROM gcr.io/distroless/java

ENTRYPOINT ["java","-cp","/app/resources:/app/classes:/app/libs/*","org.raccoons.backyards.TransformationJCase"]

