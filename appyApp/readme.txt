Setup DB schema in MySQL (local dev only)
	1. Create schema by name: appy_poc
	2. Create a root user with password: password
------------------------------------------------
To set up the DB connection
------------------------------------------------
Step1:
	Add the below code to the ${catalina.base}/conf/server.xml file under the <GlobalNamingResources> tag. This will configure
	a global data source which can by configured to be a looked up as a JNDI by application
	
		<!-- Added for appyApp. Also added mysql-connector-java-5.1.26.jar to the ${catalina.base}/lib folder -->
	    <Resource name="jdbc/AppyAppDataBase" <!-- this name is referred in the context.xml file -->
	      global="jdbc/AppyAppDataBase"
	      auth="Container"
	      type="javax.sql.DataSource"
	      driverClassName="com.mysql.jdbc.Driver"
	      url="jdbc:mysql://localhost:3306/appy_poc"
	      username="root"
	      password="password"
	       
	      maxActive="100"
	      maxIdle="20"
	      minIdle="5"
	      maxWait="10000"/>
Step2:
	Add the below code to the ${catalina.base}/conf/context.xml file under the <Context> tag.
		<!-- Added below to configure Datasource in tomcat for AppyApp -->
	    <ResourceLink name="jdbc/AppyAppDBJNDI" <!-- This is the JNDI name that we use in the Datasource configuration of Spring bean -->
	                    global="jdbc/AppyAppDataBase" <!-- should match the above added name in the server.xml -->
	                    auth="Container"
	                    type="javax.sql.DataSource" />

NOTE:If you are using embedded Tomcat in Eclipse, do the same steps mentioned above to the internal Server's server.xml, context.xml files

------------------------------------------------
Adding an external conf location to Tomcat classpath
------------------------------------------------
Edit the ${catalina.base}/conf/catalina.properties file's common.loader property value by
adding ${catalina.home}/conf/<foldername>. All the files in that folder will be added to Tomcat's classpath during server
startup.
NOTE: If using embedded tomcat in eclipse then add the above to the Servers catalina.properties file
	
