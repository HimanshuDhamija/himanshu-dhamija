Setup:

Step 1: Download JAVA 8 and set JAVA_HOME

Step 2: Install Maven:

1. Download Maven from https://maven.apache.org/download.cgi
2. Copy downloaded ZIP to any location and extract the contents
3. Copy the path till /bin folder of the extracted contents
4. If you have a Windows 10 laptop - Go to start and type "edit the system environment variables"
else setup the environment variables according to your Windows version or OS.
5. Go to environment variables
6. Under the system variables section, edit the path variable.
7. Paste the Maven path copied at step - 3
8. Check the Maven version using mvn -v and make sure Maven is correctly installed
(Restart the command prompt and try again in case it doesn't work)


Step 3: Download Lombok plugin based on your IDE:
For IntelliJ - https://projectlombok.org/setup/intellij

Step 4: Install the allure reporting server based on your system
 - https://docs.qameta.io/allure/#_get_started

Step 5: Open the Command-line and go to the project directory
run command - mvn clean test   -Dtestng.dtd.http=true -DBASE_URI="https://petstore.swagger.io"
This command will execute all the tests

Step 6: After executing the tests, run - allure serve target/allure-results


Goals of the framework:
* Scalable and extensible
* Reusable RestAssured specifications
* Reusable RestAssured API requests
* Separation of API layer from Test layer
* POJOs for serialization and deserialization
* Singleton design pattern
* Lombok for reducing BoilerPlate code
* Builder pattern for setters in POJOs
* Robust reporting and logging using Allure
* Automate positive and negative scenarios
* Support parallel execution
* Data driven testing using TestNG dataprovider
* Automated access token renewal
* Maven command line execution
* Integration with GIT and Jenkins

The tools and technologies used in this framework are:
RestAssured - RestAssured is the most popular API automation library, it is open-source, has extensive community support 
		and varying range of APIs to make a tester's life easier
TestNG - Comes with many features like Data-Provider, good range of annotations and supports data-driven testing 
JAVA
Allure reports - it has good compatibility with RestAssured 
		along-with a Maven dependency of using a filter which will showcase request and response in the report.
		This is quite useful for debugging purposes.
Hamcrest matchers - Good and easily understandable assertions
Jackson API - for serialization and deserialization of JSON
Lombok - reducing BoilerPlate code