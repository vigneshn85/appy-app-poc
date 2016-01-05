
Setup:
1. To make the context root Create a file named ROOT.xml in $CATALINA_HOME/conf/Catalina/<servername>/ and add the following

<Context docBase="appyApp-0.0.1-SNAPSHOT" path="/appyApp" />

Note: The above thing works in Tomcat 6. Check if we are using a different version of Tomcat. To investigate, we can use the maven tomcat plugin
(http://tomcat.apache.org/maven-plugin-trunk/tomcat7-maven-plugin/usage.html)


