# Selenium/TestNG/Selenoid Demo Framework

## Description
Test framework demo with Selenium and TestNG in conjunction with Selenoid with local and containerized tests execution.
No need in local driver binaries downloading as framework doing it on itself depending on locally installed browser version.

As application under test was chosen open-source OrangeHRM: https://www.orangehrm.com  
Containers with OrangeHRM were provided by Bitnami: https://bitnami.com/ https://github.com/bitnami  

Allure framework helps to provide reports.
Additionally, some REST API test planned.

## Requirements
- Java 8
- Maven 3
- Docker

## Setup

`cd {project_dir}/docker`  
`docker-compose -f orangehrm.yml up`  
`docker-compose -f selenoid.yml up`    

OrangeHRM should be set up first as selenoid's docker compose external network depends on it.
  
## Execute
Execution environment depends on properties set in `{project_dir}/src/test/resources/application.properties`

Local execution:  
`remote.driver=true` - local execution  
`browser.type=chrome` - required browser  
`application.host=http://localhost`  
`application.port=8080`  
`browser.binary.folder.path=~/.m2/repository/webdriver` - set your folder for driver binaries storage

By default, AUT accessible on http:/localhost:8080

Container execution:  
`remote.driver=false` - execution in selenoid container  
`browser.type=chrome` - required browser
`remote.browser.version` - set required browser version dependent on available pulled image  
`application.host=http://orangehrm`  
`application.port=80`  

By default, Selenoid UI (test execution process via VNC) accessible on http:/localhost:9090

Before container execution specific browser version images should be downloaded.
Download [Selenoid Configuratoin Manager](https://github.com/aerokube/cm/releases/tag/1.7.1).
Use `{project_dir}/docker/browsers.json` for pulling required browser images as described in
[Selenoid Doc](https://aerokube.com/selenoid/latest/#_syncing_browser_images_from_existing_file) (CM way)
Copy `${project_dir}/docker/browsers.json` to `${project_dir}docker/volumes/selenoid-vol` directory.
Test execution:  
`mvn clean test`  

Execute on a specific browser from CLI:  
`mvn -Dbrowser.type=chrome clean test`

Debug:  
`mvn -Dmaven.surefire.debug clean test` + remote debugger  

Test results:  
Open `{project_dir}/target/allure-report/index.html` to see allure test report.  
Check out `{project_dir}/docker/volumes/logs` and `{project_dir}/docker/volumes/video` for test artifacts in case container execution.    
