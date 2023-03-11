FROM adoptopenjdk/openjdk11:ubi
VOLUME /main-app
ADD build/libs/msvc-users-0.0.1-SNAPSHOT.jar msvc-users.jar
EXPOSE 8010
ENTRYPOINT ["java", "-jar","/msvc-users.jar"]
#ENTRYPOINT ["wait-for-it.sh", "db:3306", "--", "java", "-jar", "/msvc-users.jar"]
