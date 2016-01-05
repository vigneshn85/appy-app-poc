Setup DB schema in MySQL (local dev only)
	1. Create schema by name: appy_poc
	2. Create a root user with password: password

To set up the DB connection
	1. edit the catalina.properties file's common.loader property's value ${catalina.home}/conf/appyApp-config
		NOTE: If using embedded tomcat in eclipse then add the above to the Servers catalina.properties file
	
	2. Copy the files from the appyApp-config/local-config folder in the workspace to the ${catalina.base}/conf/appyApp-config
