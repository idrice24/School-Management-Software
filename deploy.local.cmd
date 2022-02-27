@ECHO ON
@ECHO ***********************************************************************
@ECHO            ##           ##           ##         #     ########
@ECHO           ##  ##     ##  ##        ##  ##      ##     #
@ECHO          ##    ##  ##     ##     ##     ##  ##         ########
@ECHO         ##      ##         ## ##         ##
@ECHO ***********************************************************************
@ECHO OFF
timeout /t 5 /nobreak > NUL
call mvn clean
call mvn package
call mvn -B package --file pom.xml
call mvn spring-boot:run -X

