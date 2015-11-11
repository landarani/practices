# practices
A common repository to share my practices in java

* net.shahram.practice.upload is a simple upload controller using spring mvc
* source: http://www.codejava.net/frameworks/spring/spring-mvc-file-upload-tutorial-with-eclipse-ide  

# deploy it
mvn install

mvn install -f net.shahram.practice.upload/pom.xml

mvn jetty:run -f net.shahram.practice.upload/pom.xml

# run it
open http://&lt;host-name&gt;:8080/ and ejoy your uploads :)

