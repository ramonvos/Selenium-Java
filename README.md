# Selenium-Java


## Setup
Cloning the repository:

git clone https://github.com/ramonvos/Selenium-Java.git

## Architecture
    

     webdriver/                       # Folder used to configuration TestBase Hooks
        TestBase.java          
                 

     selenium/                        # Folder used to keep useful methods for common test operations
        SeleniumHelpers.java           
        ValidationResult.java
        WaitForElement.java

      pages/                          # Folder contains elements instance and steps definitions
        <files>Page.java 
    

      tests/                          # Folder contains all tests that application
        TEST_<files>.java
        
      logger/                         # Folder contains advanced html logger using Extent Reports implementation
        Reporter.java
        
      contants/                       # Folder contains parameters and credencials to login in app (Constants data)
        Constants.java
        
      
      
      
## Advanced Logger.html (ExtentReports)

After running the tests, the reporter is generated in the:
Ramonvos-SeleniumWebdriverFramework\output\Reporter-test [currentDateTime].html

## Logger Samples:
![](https://uploaddeimagens.com.br/images/001/560/678/full/Imagem_100.png)
![](https://uploaddeimagens.com.br/images/001/560/679/full/Imagem_111.png)
![](https://uploaddeimagens.com.br/images/001/560/681/full/Imagem_121.png)
![](https://uploaddeimagens.com.br/images/001/560/683/full/Imagem_131.png)
