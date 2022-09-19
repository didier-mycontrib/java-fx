set JAVA_HOME=C:\Program Files\Java\jdk-11.0.12
set PATH=%JAVA_HOME%\bin;%PATH%
REM java -version
REM java -cp myJavaFx8App\target\myJavaFx8App-0.0.1-SNAPSHOT.jar my_java_fx_app.MyJavaFx8App

mvn clean javafx:run
REM mvn clean package
pause