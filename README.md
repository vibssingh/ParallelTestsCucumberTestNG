# ParallelTestsCucumberTestNG
This framework execute the Cucumber Tests using parallely. This framework also generates Extent Report.

Cucumber tests can be exectued in parallel using TestNG and Maven test execution plugins.

TestNG run  the scenarios in parallelly. 

We can use the Maven Surefire plugin to run feature files in parallel.

1. Add the plugin in the pom file. Update the configurations as required  
```
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>3.0.0-M7</version>
    <configuration>
        <parallel>methods</parallel>
        <useUnlimitedThreads>true</useUnlimitedThreads>
    </configuration>
</plugin>
```

2. Add the DataProvider as true in Runner class.
```
@Override
@DataProvider(parallel = true)
public Object[][] scenarios() {
   return super.scenarios();
}
```    
    
    
3. Run the following cmd in terminal to run the feature files in parallel  
```mvn clean test```

