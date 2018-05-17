### Linux

1. **History**  
    1984: Richard Stallman GNU: GNU's Not Unix, Free Unix  
    Tools: 
    * GCC: GNU C Complier, 
    * GLIBC: GNU C Library, 
    * Emacs text editor 
    * Bash: (Bourne Again Shell) command interpreter and programming environment.  
    1991: Linus Torvalds first version of Linux
 2. **Using the System**  
	Linux is multiuser and multitasking.  
    Multiple users and run multiple tasks simultaneously independent of each other.  
    Root: Super-User Account  
    Log in:  
      * Console, 
      * serial terminal, 
      * Network connection: SSH,Telnet
    
    A single log in instance is called **session**  
 3. **Command**    
 	[user@host dir]$: Command Prompt   
    \#: root  
    \$: regular user
    
    ```c
    $ ls //list all the files
    $ ls -l //list all the files,their creation time and rwx right.
    $ ls <folder>//list all the files in the folder
    
    $ passswd // Change your password minimum six characters
    
    $ date //Shows the current date and time
    $ export TZ=EST// export time zone
    $ cal [Month] [year]//Shows a calendar
    $ cal 12 2013//Shows December 2013
    
    $ who //Shows who is logged in onto the system plus logged in time
    $ whoami//Shows your user name
    $ finger [user]//Shows information about target users
    
    $ clear//Clear the screen
    
    $ echo [message]//Write message to the your own screen
    $ write <user> [message]//Write message to other user's screen
    $ wall [message] //Place massage to all the logged-in user's screen
    $ mesg n //Disable message on your screen
    $ mesg y //Enable message
    
    <Ctrl-C>//Terminate current command
    <Ctrl-D>//End of transmission/input/file
    <Ctrl-R>//Search for commmand in history
    
    $ vlock //Lock you terminal
    ```
    
