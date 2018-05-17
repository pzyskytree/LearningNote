### Java Install Note 
1. Install JRE(Java Runtime Environment)/JDK(Java Development Kit)
	* Use Default JRE/JDK  
      Update Package Index
      ```c
      sudo apt-get update
      ```
      ```c
      sudo apt-get install default-jre//Install JRE
      sudo apt-get install default-jdk//Install JDK
      ```
	* Use Oracle JDK
      ```c
      sudo add-apt-repository ppa:webupd8team/java//Add Oracle's PPA
      sudo apt-get update
      sudo apt-get install oracle-java-8-installer//Install Oracle's JDK
      ```
2. Managing Java
	```c
    sudo update-alternatives --config java
    ```
3. Setting Java Evironment
	```c
    sudo update-alternatives --config java// Remember the Java Installation Location
    sudo nano /etc/environment
    //Add to the /etc/environment
    JAVA_HOME="/usr/lib/jvm/java-8-oracle"
    source /etc/environment //Reload it
    echo $JAVA_HOME //Check if java is installed successfully
    ```
    
