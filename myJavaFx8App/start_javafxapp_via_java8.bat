set JAVA_HOME=C:\Program Files\Java\java-se-8u41-ri
REM mvn error with java this 8: InvalidAlgorithmParameterException: the trustAnchors parameter must be non-empty
set MVN_HOME=C:\Prog\apache-maven-3.8.4
set PATH=%JAVA_HOME%\bin;%MVN_HOME%\bin;%PATH%
REM java -version
REM java -cp myJavaFx8App\target\myJavaFx8App-0.0.1-SNAPSHOT.jar my_java_fx_app.MyJavaFx8App

REM mvn clean javafx:run
mvn clean package
pause