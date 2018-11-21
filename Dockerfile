FROM gcr.io/distroless/java

COPY build/libs /

ENTRYPOINT ["java","-cp","/jcase-0.1b1.jar","org.raccoons.backyards.TransformationJCase"]
#ENTRYPOINT ["java","-cp","/jcase/classes:/jcase/libs/*","org.raccoons.backyards.TransformationJCase"]
