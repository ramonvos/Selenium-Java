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
        
      
      
      
Advanced Logger .html path:
Ramonvos-SeleniumWebdriverFramework\output\Reporter-test [currentDateTime].html

## Logger Samples:
![](https://uploaddeimagens.com.br/images/001/559/169/full/Imagem_13.png)
![](https://uploaddeimagens.com.br/images/001/559/172/full/Imagem_15.png)
![](https://uploaddeimagens.com.br/images/001/559/173/full/Imagem_17.png)
