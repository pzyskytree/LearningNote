

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
    $ ls //list visible  files default order alphabetic order
    $ ls -l//list all the files,their creation time and rwx right.
    $ ls -a//list all files (including hidden ones)
    $ ls -t//list files sorted by change date
    $ ls -R//list contents recursively
    $ ls <folder>//list all the files in the folder
    
    $ passwd // Change your password minimum six characters
    
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

 4. **File and Directory**  
    File Types:
    * Ordinary File: ascii text, executable, picture
    * Directory: .bashrc, myfile
    * Special File: /dev/lp0 /dev/null  

    File Name: Letter, Number, @, _, if dot at the beginning, it is a hidden files.  
    Directory Structure:
    ```c
    /bin //Binary executable file for all users;
    /sbin //Binary executable file for administrator
    /lib //libraries shared code
    /boot //kernel image and files needed for boot loader(LILO, GRUB)
    /dev //hardware of system, device references
    /etc //system-wide configuration files
    /home //home directory for users
    /root //home directory for root
    /tmp //temporary files, last for couple of minutes or hours.
    /sys //driver and system file information, kernel status
    /proc //kernel and process information, kernel data structure
    /var //data that are changed when system is running normally. Like log files
    /usr //user program that system needs
    /opt //software from external provider
    /mnt //mount point for other not-standard file system like windows
    /media //mount point for media
    /lost+found //when system crash all the files without name will be placed in the folder.
    ```
    Command::
    ```c
    $ pwd //Curent working directory full path /home/pan
    
    $ cd dir_name //Change directory
    $ cd (~)// go to home directory
    $ cd .. //go to up directory
    $ cd -//go to previous directory
    
    $ mkdir <dir_names>//Create one or more new directories
    $ rmdir <dir_names>//Remove directories, each directory must be empty.
    $ mkdir -p <dir1/dir2/dir3> //Create all the directories simultaneously
    $ rmdir -p <dir1/dir2/dir3> //Remove mutiple directories simultaneously
    
    $ touch file//Create a new file or updates the modification time of a file.
    
    $ cp -i <source> <target>// -i ask for overwrite or not(interactive copy), 
    //create a new inode and inode information.
    $ cp -R <source_directory> <target_directory> //Copy files from source to target recursively.
    $ cp .bashrc .bashrc.old //Copy a file to another file.
    $ cp .bashrc .bashrc.old test//Copy multiple files into one folder test
    
    $ mv -i <source> <target>//Move a source file into target recursively, -i interactive move. (cp + rm)
    //Source can be file or directory. If target is directory just move the file, but if target is a file
    // it is to rename the file. mv will retain the inode number and inode
    
    $ rm -i <file_name>//Remove a file
    $ rm -ir <folder>//Remove all the files inside a folder recursively.
    
    $ cat <file1> <file2> //list all the files' content, only for files not directory
    $ cat <file1> <file2> ... > new_file // Concatenate all the contents of the files into one new_file.
    
    $ more file //Terminate automatically at the end.
    $ less file//read the content of file one page at a time. Terminate manually by press <q>.
    //it can scroll forward to any position
    //Use <space> for next page and <b> for previous page <q> to quit reading.
    
    $ od <file_name> //View the file byte by byte octal in format(Octal Dump)
    $ od -h/-x <file_name> //Hexadecimal display.
    $ od -o <file_name> //Octal display
    $ od -d <file_name>//Decimal display
    $ strings <file_name> //Show all the strings inside a binary file.
    ```
    Mount: 
    * Root file system is mounted by kernel itself.
    * Root file system contains empty directories as mount point for other file system.
    * Other file system like /dev/hda5 can be mounted on /var and its directory /log is currently be /var/log
    * /root, /bin, /sbin, /lib, /etc, /dev cannot be seperate file system.
    ```c
    # mount [-t type] [-o options] device mountpoint//type: file system type like ext2 vfat.
    # mount /dev/hda5 /usr
    # umount device|mountpoint //umount it takes the file system out of the unified file system. 
    //Only if the system is no long in use. No file or program running on this file system.
    # umount /dev/hda5
    # umount /usr
    $ cat /etc/fstab //List all known file system on the system.
    ```
    Inode and File reference: 

    An **inode** is a data structure on a filesystem on Linux and other Unix-like operating systems that stores all the information about a file except its name and its actual data.  
    Each inode stores the attributes and disk block location(s) of the object's data.Filesystem object attributes may include metadata (times of last change,access, modification), as well as owner and permission data.    

    ***Hard Link***: 
    * Associate another file with the an existing inode. They have the same content but not with same name.  
    * Cannot create for folder or across file system. 
    * The file is not removed until all hard links to the file are removed
    ```c
    ln file1 file2//Hard link
    //Create a new file file2 pointing to the same inode as file1. It can have different name but share 
    // the inode and inode number. They are the same file with different name. Data can be deleted when 
    //all the hard links are removed
    ```
    ***Soft Link***
    * Like a short cuts to files or diretories. Same content different name.
    * Can link to directory and across file system
    * Useless once remove the file.
    ```c
    ln -s file1 file2//Soft link
    //Soft link allows to create a new file with different inode and inode number, it is a shortcut of the 
    //existing file. Once the existing file is deleted, it becomes useless.
    ```
    ```c
    //Different between hard link and soft link. hard_test has the same attribute as test date, all of these
    //information are stored in inode.
    ln test hard_test  //Build a hard link
    ln -s test soft_test//Build a soft link
    2239162 -rw-rw-r-- 2 pan pan 40 May 18 17:25 hard_test
    2236084 lrwxrwxrwx 1 pan pan  4 May 18 18:06 soft_test -> test
    2239162 -rw-rw-r-- 2 pan pan 40 May 18 17:25 test
    ```

5. **File and Directory Permission**

    File Permission are assigned to:

    * The owner of the file: user

    * The member of the group

    * All other users

    Permission can only be changed by **owner** and **root**

    ```c
    ls -l
    drwxrwxr-x 2 pan pan 4096 May 15 11:44 C
    drwxr-xr-x 2 pan pan 4096 May 12 22:36 Desktop
    drwxr-xr-x 2 pan pan 4096 May 12 22:36 Documents
    drwxr-xr-x 3 pan pan 4096 May 19 16:43 Downloads
    //d: File type, d: directory. rwx: Permission. 2,3:link counter. pan: user. pan: group. 
    //4096: size. May 12 : Modification time. C : Name
    rwx    rwx    rwx
    user  group  others
    R://Readable: 
      //Regular File: Readable, you can use cat, more, less
      //Directory: Contents of the directory can be listeds, you can use ls
    W://Writable
      //Regular File: Writable, you can midify it with vi, gedit
      //Directory: You can add or delete files or modify the name of the file inside the  
      //directory even though you don't have the right to write the file.
    X://Executable
      //Regular File: Allow user to execute the file like a program like (shell script)
      //Directory: Allow user to use it as working directory, you can use cd(Change       
      //Directory)
    ```

    Change Permission:

    ```c
    chmod <MODE> <FILES>
    //Symbolic 
    chmod <who operator what> <file_names>
    //who: u user, g group, o others, a all
    //operator: + add, - delete, = set equal to
    //what: r read, w write, x executable
    chmod a=rwx test
    chmod u+x,go-rw test
    //Octal Number
    chmod 777 test
    //R = 4, W = 2, X = 1
    //600 :(rw-------): For Private File
    //700 :(rwx------): For Private Directory
    //644 :(rw-r--r--): For Files you want to be readable to others
    //755 :(rwx-r-xr-x): For Directory you want to be readable and executable to others
    //666 :(rw-rw-rw-): For public file
    //777 :(rwxrwxrwx): For public directory
    
    umask//Change the default permission of the new created file and directory
    //For file the default is 666 and directory is 777, it will subtract the umask
    touch test
    ls -l test
    //-rw-rw-rw- 1 pan pan 0 May 19 17:20 test
    rm test
    umask 022
    touch test
    ls -l test
    //-rw-r--r-- 1 pan pan 0 May 19 17:22 test
    
    mkdir test
    ls -ld test
    //drwxr-xr-x 2 pan pan 4096 May 19 17:23 test
    ```

    

 6. **Linux Document**

    * MAN

      ```c
      man command_name//Read the manual page of command which consists of
      //Name: The name of command and one-line description
      //Synopsis: The syntax of the command
      //Description: Explanation of how the command works
      //Options: The options used by command
      //Files: Files uesed by command
      //Bugs: Known error
      //See also: Other related command
      man passwd
        
      man -k <key-word> = apropos <key-word>
      //List all the commands whose title contains key word
      
      man n <command>//The collection of manual pages is divided into 9 sections
      //1: Executable or shell commands
      //2: System Call
      //3: Library Call
      //4: Specail Files
      //5: File Format and Conventions
      //6: Games
      //7: Miscellaneous 
      //8: System administration command
      //9: Kernel routines
      man 5 passwd
      man 2 fork
      ```

      

    * INFO: Similar to man

      ```c
      info command_name
      //info works with entities named nodes.
      //The main difference between info and man is nodes can contain hyperlinks to //other pages.
      //Command:
      //N: Next Node, P: Previous Node, U: Go to up node, B: Go to top of the node
      //E: to the end of the node, S: Search for a string in the current node.
      ```

      

    * --help

      ```c
      <command_name> --help
      <command_name> --help | less //read the content of help using less command
      ```

    * HOWTO Documents: Describe the detail a certain aspect of configuring or using linux

 7. Editing File

    ```c
    //Determine the type of file
    file <file_name>
    file Public
    //Public: direx`ctory
    file hard_test
    //hard_test: ASCII text
    //Non-text files can be edited by a hex editor or the program that created them.
    ```

    Vi Editor: Default editor in UNIX, Full screen model,

    Vi in Linux is ***Vim***(Vi improved)

    Vi modes:

    * Command Mode (Simple One Letter Mode)
    * Edit Mode(insert text)
    * ex mode (execute complicated commands)

    ```c
    vi <file_name>//If the file does not exist, it will create a new file.
    // All the content of the file will be stored in buffer.
    //The started mode is command mode.
    Command Mode:
    <left-arrow>,h//One Character left
    <right-arrow>,l//One Charcter right
    b,B//One word left
    w,W//One word right
    ^ //Begining of one line
    $ //End of one line
    ()//Last or next sentence
    {}//Lat or next Paragraph
    <up-arrow>,k//One line up
    <down-arrow>,j//One line down
    1G //Go to the first line of the file
    G //Go to the last line of the file.
    <ctrl-u>,<ctrl-d>// one half page up or down
    <ctrl-b>,<ctrl-f>// one page back or forward.
    
    Edit text in command mode:
    x//Delete single character under current cursor
    X//Delete single character left of cursor.
    u//Undo last change
    .//Repeat last command
    J//Join two lines together.
     
    / //Serch for pattern
    n // Repeat the previous search
    
    dd //Cut a whole line into buffer
    yy //Copy a whole line into buffer
    dw //Cut a word from the current cursor to a space.
    p //paste the content of buffer here. Under the current line
    P //paste the content of buffer here. Above the current line
    3dd,8yy//Cut and copy multiple lines into buffer.
    
    ZZ //save and exit.
    ```

    ```c
    Edit Mode:IiAa //From command mode to edit mode
    ESC//exit edit mode
    I//Insert text at the beginning of the current line.
    i//Insert text before the current cursor
    a//Append text after the current cursor
    A//Append text at the end of line.
    ```

    ```c
    ex Mode: :
    : 1,$s /old/new/g //Replacec old pattern with new pattern
    1, $ //Search from the first line to the last line. . $ current line to the last
         // % the entire file.
    s //search and replace 
    g //Global Replace
    :set all//Display all setting
    :set autoindent//Sets autoindent on 
    :set tabstop=4//Set tab to 4 character jumps.
    
    :w :w! //save in ex mode
    :q :q! //quit without saving
    :wq  //save and exit in ex mode.
    :x //save and exit in ex mode
    ```

    

![VI Cheat Sheat](http://www.nathael.org/Data/vi-vim-cheat-sheet.svg)

![](../img/vi.png )

8. Shell Basic  

  Shell is a command line user interface to Linux: interact with operation system: bash, ksh, csh

  Shell allows you to type command after which it interpret it and executes the corresponding program.

*  Metacharacters: special meaning: eg < > | ; ! * ? $ \ `  '  " ~ [] () {}
* Reserve words: words shell interprets as special commands.  : case do done if elif else esac while
* default shell is bash

```c
//Basic Wildcard Expansion
//? any single character, * match any String 
ls ?ne?
ls n*
//. hidden file not include in wildcard match but .* can match
//Advanced WildCard Expansion
//[, ], -,!
ls ne[stw]//nes,net,new
ls test[1-4]//test1, test2, test3, test4
ls [!tn]*//not start with t or n
```

* File Descriptor
  * STDIN < 0: key board
  * STDOUT > 1: terminal session
  * STDERR 2> 2: terminal session

```c
//Input redirction
cat //keyboard as input
cat < test //test as input file

//Output redirction
ls //Terminal session
ls > ls.out //ls.out as output Overwrite
ls >> ls.out //Append
cat > new_file //Write the content type from keyboard to the newfile
cat >> new_file//Append the new File

//Error redirection
cat file
//Output: cat: file: No such file or directory
cat file 2> error.file
cat error.file
//Output: cat: file: No such file or directory
cat file 2>> error.file //Append
cat file 2> /dev/null //Throw the error message away

//Combination
cat < test > test.out 2> test.err
cat < test > test.out 2>&1 // Write both error and output message to test.out
cat < test 2>&1 > test.out //write error to the screen, output message to the test.out
```

```c
//Pipes |
command1 | command2
//The standard output of command1 is standard input of command2
ls -l | wc -l// Count how many files in the current directory
//Filters
command1 | filter | command2
ls | grep .out | wc -l //Count how many files's name ending with .out
//filter standard input stadard output
//Common Filter
grep //Match Pattern
ls | grep .out | wc -l
sed //String substitution
ls | sed s/test/train/ | cat //substitue all the file name containing test to train
```

![](../img/filter.png)

```c
//Split output
tee //send the data to both standard output and a file
ls | tee ls.save | wc -l//capture the snapshot of information going through a pipe;
// Store the mid-result into a file.

//Command Substitution
//Use the output of a command as the argument for another command
rm -i `ls *.out` //Use `` or $()to encompass the result of one command
rm -i $(ls *.err)
echo there are $(ps ax | wc -l) processes running//Count the number of running processes
ps//generate the detail of running process
    
//Command Group
//;
date;pwd//Multiple commands separated by ;
{ echo Print date: ; date ; cat test ; } | lpr
( echo Print date: ; date ; cat test ) | lpr
```

Shell Variable

```c
//Shell Variable
variable=value//no whitespace
var="hello";
var2=12;
//Reference variable
echo $var1
echo $var2
//export shell variable
//export the variable from parent to child process
//change making in child process does not affect the value in parent process
var=12
echo $var
//12
export var
bash
echo $var
//12
var=123
echo $var
//123
exit
//ex
echo $var
//12

//Standard Shell Variable
echo $$ //PID
//7350
echo $PATH //Path which is searched for executable: place to search for not built-in
//command
// /home/pan/bin:/home/pan/.local/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:
// /usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/snap/bin
echo $PS1 //Primary shell prompt: shown when the shell is able to accept command
// \[\e]0;\u@\h: \w\a\]${debian_chroot:+($debian_chroot)}\[\033[01;32m\]\u@\h\
// [\033[00m\]:\[\033[01;34m\]\w\[\033[00m\]\$
echo $PS2 //Secondary shell prompt: another line
// >
echo $PWD //Current working directory
// /home/pan
echo $HOME //Home directory of user
// /home/pan
echo $LANG //Language of user
// en_US.UTF-8

//Get return value from child process: echo $? 
whoami
// pan
echo $?
// 0 success
cat file
// cat: file: No such file or directory
echo $?
// 1 Failure
```

Quote Metacharacters or non-Metacharacter: \ ' "

``` c
//Not interpret $ : \$
echo the amount is US\$5
// the amount is US$5

//'' quoting string
echo 'the amount is $amount'
the amount is $amount
// "" allows interpret of $ ` and \
echo "the amount is $amount"
the amount is 5
// \n \t \b    
```

Alias for command

```c
alias ll='ls -l'
ll //ll is an alias of ls -l
//total 76
//drwxrwxr-x 2 pan pan 4096 May 15 11:44 C
//drwxr-xr-x 2 pan pan 4096 May 12 22:36 Desktop
unalias ll //delete ll alias
ll
// ll: command not found
```
9. Working with processes

   Program is an executable file,  Process program being executed

   All processes are started by other processes

   The **init** process is started by kernel

   ```c
   PID; //Process ID
   echo $$ //PID of the shell process
   //Process can be terminated by itself or by signal from other processes
   
   pan@ubuntu:~$ echo $$
   2991
   pan@ubuntu:~$ bash //Start a new subshell and subprocess
   pan@ubuntu:~$ echo $$
   3003
   pan@ubuntu:~$ date
   Mon Jun 11 20:58:28 PDT 2018
   pan@ubuntu:~$ exit
   pan@ubuntu:~$ echo $$
   2991
   
   //Monitor processes
   ps //display processes started by current terminal
   ps aux //a : all processes attached to the terminal, u: all other processes, x: more 
   //columns;
   ps l //show pid ppid priority number nice vlaue
   pstree //shows process hierarchy
   
   //Control process : terminate kill stop/continue
   //1. from shell started it using job number
   //2. from anywhere use PID
   
   //1. Start process
   // Foreground process: Process needs interaction with terminal.
   //When foreground process is running you are not allow to type other command
   find / -name README
   // Background process &: Process that does not iteract with use, when it runs
   //you can still type other command to the shell
   find / -name README &
   
   <ctrl-z> //suspend process
   jobs //list background or suspended jobs
   fg %job_number//resume suspended task in foreground
   bg %job_number//resume suspended task in background
   kill %job_number 
   
   kill -signal PID //Control process from outside the shell that has started the 
   //process
   -1 hangup //Parent process dies
   -2 interrupt //<ctrl-c>
   -3 quit //<ctrl-\> core dump
   -9 kill //Hundle by linux kernel
   -15 terminate //regular timinate signal which is sent to process
   //eg	
   pan@ubuntu:~$ kill -1 3899 //Hangup
   pan@ubuntu:~$ kill -3 3913 //<ctrl-c>
   pan@ubuntu:~$ kill -2 3913
   pan@ubuntu:~$ kill -15 3913 //exit
   pan@ubuntu:~$ kill -9 3913 //killed 
   
   killall -signal name //kill all process by name
   
   nohup find / -name README &// allow process to continue even if you log off the 
   //system 
   
   //Process Priority
   +19 ~ +39 :Dynamic part
   -20 ~ 0 ~ +19 : User defined, negative only allowed for root
   0 : default
   -60 ~ -20 : Reserved for kernel threads
   CPU find the lowest priority number to run.
   Priority number based on:
   1. Nice value for process: the priority value of the process will not be lower than that
   2. If a process has a certain amount of time it increases its process number.
   3. After a process is idle for a while the process number decrease.
   Processes with the same nice value get the equal amount of CPU time.
   Proecsses with higher nice value get less CPU time.
   
   //nice start process iwht a user-definde nice vlaue
   nice -n 10 find / -name a
   nice find / -name a //Defau;t nice value 10
   ps l //Show all the process and nice value priority number
   renice <new-priority> <PID>
   //eg
   sudo renice 5 4204
   
   daemon : never ended process background process
   ```

10. Linux Utilities

  ```c
  find:
  find path expression; // Search the file in the directory recursively that matches
  // the boolean expression
  find <from where> <search for> <do something to it>
  //eg
  pan@ubuntu:~$ find . -name test//Find all the files' names are test
  pan@ubuntu:~$ find . -name '*test*'//Find all the files' names containing test
  pan@ubuntu:~$ find . -name '*test*' -exec ls -i {} \; // -exec ls is executed for 
  //each found file
  pan@ubuntu:~$ find . -name 'test' -ok ls -i {} \; //-ok ask for whether to execute 
  //ls or not
  pan@ubuntu:~$ find . -perm 777 -exec ls -l {} \; //Find all the file and directory 
  // with permission 777;
  pan@ubuntu:~$ find . -name "*test*" -type f -a -size +2 // -a and -o or, find
  // all the file with name containing test and size larger than 2 blocks (1024 bytes)
  pan@ubuntu:~$ find . -name "test" -o -name "code*"//Find file with name being test or start with code
  
  locate:
  locate <word>
  //eg
  an@ubuntu:~$ locate passwd //Locate file with path string contains passwd
  
  grep
  grep <options> <pattern> <file_names> //Search for pattern and write matching lines
  // to the terminal
  //eg
  pan@ubuntu:~$ grep Hello test*//Find all lines containing Hello in the file with 
  //name start with test
  pan@ubuntu:~$ grep -v Hello test* //-v reverse find all lines not containing Hello
  Regular Expression
  * 0 or more times of the preceding characer
  . any one character
  [a-f]
  ^ start with, end with $
  pan@ubuntu:~$ grep 'world!$' test
  pan@ubuntu:~$ grep -c . test //-c Count of lines
  //11
  pan@ubuntu:~$ grep -l . test // -l print name of files
  //test
  pan@ubuntu:~$ grep -n . test // -n number of matching lines
  /*1:Hello world!
  2:Hello world!
  3:Hello world!
  4:Hello world!
  5:Hello world!
  6:Hello world!
  7:Hello world!
  8:Hello world!
  9:Hello world!
  10:Hello world!
  11:Hello world!*/
  pan@ubuntu:~$ grep -i hello test //-i ignore cases
  /*Hello world!
  Hello world!
  Hello world!
  Hello world!
  Hello world!
  Hello world!
  Hello world!
  Hello world!
  Hello world!
  Hello world!
  Hello world!*/
  pan@ubuntu:~$ grep -w Hell test //-w whole word match
  pan@ubuntu:~$ grep Hell test
  /*Hello world!
  Hello world!
  Hello world!
  Hello world!
  Hello world!
  Hello world!
  Hello world!
  Hello world!
  Hello world!
  Hello world!
  Hello world!*/
  pan@ubuntu:~$ grep -f test test //use file test as input
  /*Hello world!
  Hello world!
  Hello world!
  Hello world!
  Hello world!
  Hello world!
  Hello world!
  Hello world!
  Hello world!
  Hello world!
  Hello world!*/
  
  fgrep //fix string no regular expression
  egrep // allow for multiple patterns
  pan@ubuntu:~$ egrep 'hel|Hel' test
  /*Hello world!
  Hello world!
  Hello world!
  Hello world!
  Hello world!
  Hello world!
  Hello world!
  Hello world!
  Hello world!
  Hello world!
  Hello world!*/
  pan@ubuntu:~$ egrep 'hel|Hel' test*
  /*test:Hello world!
  test:Hello world!
  test:Hello world!
  test:Hello world!
  test:Hello world!
  test:Hello world!
  test:Hello world!
  test:Hello world!
  test:Hello world!
  test:Hello world!
  test:Hello world!
  test.cp:hello world.
  test.cp:Hello world.
  grep: testDir: Is a directory
  test.soft:Hello world!
  test.soft:Hello world!
  test.soft:Hello world!
  test.soft:Hello world!
  test.soft:Hello world!
  test.soft:Hello world!
  test.soft:Hello world!
  test.soft:Hello world!
  test.soft:Hello world!
  test.soft:Hello world!
  test.soft:Hello world!*/
  
  cut// Pull column out of text files
  cut -f(field) -d(elimiter) file(s)
  pan@ubuntu:~$ cut -f 1,2,3 -d: /etc/passwd //The first three columns seperated by :
  /*root:x:0
  daemon:x:1
  bin:x:2
  sys:x:3
  sync:x:4
  games:x:5
  man:x:6
  lp:x:7
  mail:x:8
  news:x:9
  uucp:x:10
  proxy:x:13
  www-data:x:33
  backup:x:34
  list:x:38
  irc:x:39
  gnats:x:41
  nobody:x:65534
  systemd-timesync:x:100*/
  cut -c(character) files
  //eg
  pan@ubuntu:~$ ps | cut -c -3,4-10 // 1 - 3 columns and 4 to the 10
  /*  PID TTY 
   7326 pts/
   8126 pts/
   8288 pts/
   8289 pts/
   8290 pts/
   8294 pts/
   8295 pts/
   8296 pts/
   8432 pts/
   8433 pts/
   8434 pts/
   8724 pts/
   8725 pts*/
   
  sort //sort the lines in files
  sort -t(delimiter) -k(field) -options file
  //eg
  pan@ubuntu:~$ cat animals
  /*dog.2
  cat.4
  penguin.10
  bird.5 */
  pan@ubuntu:~$ sort animals
  /*bird.5 
  cat.4
  dog.2
  penguin.10*/
  pan@ubuntu:~$ sort -k1.2 animals//Sort based on the second character
  /*cat.4
  penguin.10
  bird.5 
  dog.2*/
  pan@ubuntu:~$ sort -t. -k2 animals //Based on the first character after .
  /*penguin.10
  dog.2
  cat.4
  bird.5 */
  pan@ubuntu:~$ sort -t. -n -k2 animals //Based on the real number not character
  /*dog.2
  cat.4
  bird.5 
  penguin.10*/
  
  head //View first a few lines of file
  head -lines files
  //eg
  pan@ubuntu:~$ cat animals
  /*dog.2
  cat.4
  penguin.10
  bird.5 */
  pan@ubuntu:~$ head -3 animals
  /*dog.2
  cat.4
  penguin.10*/
  pan@ubuntu:~$ ls -l
  /*total 344
  -rw-rw-r-- 1 pan pan     31 Jun 13 05:10 animals
  drwxrwxr-x 2 pan pan   4096 May 15 11:44 C
  drwxr-xr-x 2 pan pan   4096 Jun 11 19:53 Desktop
  drwxr-xr-x 2 pan pan   4096 May 12 22:36 Documents
  drwxr-xr-x 3 pan pan   4096 May 19 16:43 Downloads
  drwxrwxr-x 3 pan pan   4096 May 16 16:29 eclipse
  drwxrwxr-x 4 pan pan   4096 May 16 17:21 eclipse-workspace
  -rw-r--r-- 1 pan pan   8980 May 12 22:32 examples.desktop
  -rw-rw-r-- 1 pan pan      0 Jun 13 02:37 -exec
  drwxrwxr-x 2 pan pan   4096 May 18 14:43 Java
  -rw-rw-r-- 1 pan pan    182 May 25 19:35 ls.save
  drwxr-xr-x 2 pan pan   4096 May 12 22:36 Music
  drwxrwxr-x 2 pan pan   4096 May 16 12:50 mysql
  drw-rw-rw- 2 pan pan   4096 Jun 11 18:31 new
  -rw------- 1 pan pan 259856 Jun 12 01:26 nohup.out
  drwxr-xr-x 2 pan pan   4096 May 12 22:36 Pictures
  drwxr-xr-x 2 pan pan   4096 May 12 22:36 Public
  drwxr-xr-x 2 pan pan   4096 May 12 22:36 Templates
  -rw-rw-rw- 1 pan pan    143 Jun 11 20:23 test
  -rw-r--r-- 1 pan pan     26 Jun 11 18:12 test.cp
  drwxrwxr-x 2 pan pan   4096 Jun 11 18:13 testDir
  lrwxrwxrwx 1 pan pan      4 Jun 11 18:17 test.soft -> test
  drwxr-xr-x 2 pan pan   4096 May 12 22:36 Videos*/
  pan@ubuntu:~$ ls -l | head -3
  /*total 344
  -rw-rw-r-- 1 pan pan     31 Jun 13 05:10 animals
  drwxrwxr-x 2 pan pan   4096 May 15 11:44 C*/
  
  tail //Show last a few lines
  //eg
  pan@ubuntu:~$ cat animals 
  /*dog.2
  cat.4
  penguin.10
  bird.5 */
  pan@ubuntu:~$ tail -3 animals //Last 3 lines
  /*cat.4
  penguin.10
  bird.5 */
  pan@ubuntu:~$ tail -n +3 animals //Show the lines except the first three lines
  /*penguin.10
  bird.5 */
  pan@ubuntu:~$ tail -f animals //Monitor the change of file by other process
  /*dog.2
  cat.4
  penguin.10
  bird.5*/
  
  type //Path to a command: shell built-in
  pan@ubuntu:~$ type find locate grep cut sort head tail
  /*find is /usr/bin/find
  locate is /usr/bin/locate
  grep is aliased to `grep --color=auto'
  cut is /usr/bin/cut
  sort is hashed (/usr/bin/sort)
  head is hashed (/usr/bin/head)
  tail is hashed (/usr/bin/tail)*/
  which //Where the binary is located not shell built-in
  pan@ubuntu:~$ which find locate grep cut sort head tail
  /*/usr/bin/find
  /usr/bin/locate
  /bin/grep
  /usr/bin/cut
  /usr/bin/sort
  /usr/bin/head
  /usr/bin/tail*/
  //Difference between type and which
  pan@ubuntu:~$ type echo
  //echo is a shell builtin
  pan@ubuntu:~$ which echo
  //bin/echo
  
  whereis //binary source manual page of command
  pan@ubuntu:~$ whereis find locate grep cut sort head tail
  /*find: /usr/bin/find /usr/share/man/man1/find.1.gz /usr/share/info/find.info.gz
  locate: /usr/bin/locate /usr/share/man/man1/locate.1.gz
  grep: /bin/grep /usr/share/man/man1/grep.1.gz /usr/share/info/grep.info.gz
  cut: /usr/bin/cut /usr/share/man/man1/cut.1.gz
  sort: /usr/bin/sort /usr/share/man/man1/sort.1.gz
  head: /usr/bin/head /usr/share/man/man1/head.1.gz
  tail: /usr/bin/tail /usr/share/man/man1/tail.1.gz*/
  
  file //Find the type of file
  pan@ubuntu:~$ file /etc/passwd /bin/ls /home/pan
  /*/etc/passwd: ASCII text
  /bin/ls:     ELF 32-bit LSB executable, Intel 80386, version 1 (SYSV), dynamically linked, interpreter /lib/ld-linux.so.2, for GNU/Linux 2.6.32, BuildID[sha1]=5da723dfb25295d0356435f76f982e3fdca3a3d9, stripped
  /home/pan:   directory*/
  
  join //Merge the sorted content of two files
  pan@ubuntu:~$ cat test
  /*bird 13
  dog 1
  elephant 32
  monkey 4 
  penguin 10
  zebra 53*/
  pan@ubuntu:~$ cat temp
  /*bird 5
  cat 4
  dinasours 33
  dog 2
  penguin 10
  zebra 23 */
  pan@ubuntu:~$ join test temp //Seperated by space
  /*bird 13 5
  dog 1 2
  penguin 10 10
  zebra 53 23*/
  pan@ubuntu:~$ paste test temp//Paste together
  /*bird 13	bird 5
  dog 1	cat 4
  elephant 32	dinasours 33
  monkey 4 	dog 2
  penguin 10	penguin 10
  zebra 53	zebra 23 */
  
  gzip //Compress 
  pan@ubuntu:~$ ls -l examples.desktop 
  //-rw-r--r-- 1 pan pan 8980 May 12 22:32 examples.desktop
  pan@ubuntu:~$ gzip -v examples.desktop 
  //examples.desktop:	 56.2% -- replaced with examples.desktop.gz
  pan@ubuntu:~$ ls -l examples.desktop.gz //Small size
  //-rw-r--r-- 1 pan pan 3968 May 12 22:32 examples.desktop.gz
  zcat//View the content of zip file without unzip
  pan@ubuntu:~$ zcat examples.desktop.gz 
  /*[Desktop Entry]
  Version=1.0
  Type=Link
  Name=Examples
  Name[aa]=Ceelallo
  Name[ace]=Contoh
  Name[af]=Voorbeelde
  Name[am]=ምሳሌዎች
  Name[ht]=Egzanp
  Name[hu]=Minták
  أمثلة محتوى لأوبونتو
  X-Ubuntu-Gettext-Domain=example-content*/
  pan@ubuntu:~$ gunzip examples.desktop.gz//Unzip the zip file
  
  bzip2 //the original file will be deleted
  pan@ubuntu:~$ bzip2 -v examples.desktop 
  //examples.desktop:  2.444:1,  3.273 bits/byte, 59.09% saved, 8980 in, 3674 out.
  pan@ubuntu:~$ bzcat examples.desktop.bz2 //View the content without decompress
  pan@ubuntu:~$ bunzip2 examples.desktop.bz2//Decompress
  ```

11. Shell Script

   Shell Script:  Collection of commands in a text file.

   ```c
   invoke shell scripts
   //1. Bash : Start with a subshell, Script should be readable not need to be 
   //executable
   pan@ubuntu:~$ cat script1 
   /*date
   pwd */
   pan@ubuntu:~$ bash script1 
   /*Tue Jun 19 23:22:48 PDT 2018
   /home/pan*/
   pan@ubuntu:~$ ls -l script1 
   //-rw-rw-r-- 1 pan pan 10 Jun 19 23:21 script1
   
   //2. . or source: Start in the current shell, do not need to be executable
   pan@ubuntu:~$ . script1 
   /*Tue Jun 19 23:28:12 PDT 2018
   /home/pan*/
   pan@ubuntu:~$ source script1 
   /*Tue Jun 19 23:28:21 PDT 2018
   /home/pan*/
   pan@ubuntu:~$ ls -l script1 
   //-rw-rw-r-- 1 pan pan 10 Jun 19 23:21 script1
   
   //3. chmod 775 or u+x to make the file execuatble, and run it like a command in a 
   //subshell
   pan@ubuntu:~$ chmod u+x script1 
   pan@ubuntu:~$ ls -l script1 
   //-rwxrw-r-- 1 pan pan 10 Jun 19 23:21 script1
   pan@ubuntu:~$ ./script1 
   //Tue Jun 19 23:30:37 PDT 2018
   ///home/pan
   
   #!/bin/bash //make sure script run in bash
   
   
   //Pass positional parameter ${10}
   pan@ubuntu:~$ cat script1 
   /*#!/bin/bash
   echo first parameter $1
   echo second parameter $2
   echo number of parameter $#
   echo All parameters $@ //"$1" "$2"
   echo All parameters $* //"$1 $2" */
   pan@ubuntu:~$ . script1 ant bee
   /*first parameter ant
   second parameter bee
   number of parameter 2
   All parameters ant bee
   All parameters ant bee*/
   
   //<< END redirect fixed text into a command END: delimiter
   pan@ubuntu:~$ cat << END > cities
   /*> Atlanta
   > Chicago
   > END*/
   pan@ubuntu:~$ cat cities 
   /*Atlanta
   Chicago*/
   
   
   //Conditional Execution
   //1. test command
   test expression
   -f:file, -d:directory, -r:readable, -w:writable, -x:executable, -s:non-zero length 
   echo $? //return value
   //eg
   pan@ubuntu:~$ test -f script1 
   pan@ubuntu:~$ echo $?
   //0 // script1 is a file
   pan@ubuntu:~$ test -d script1 
   pan@ubuntu:~$ echo $?
   //1 // script1 is not a directory
   pan@ubuntu:~$ cat script1 
   /*#!/bin/bash
   test $1 -eq $2
   echo $?
   test $1 -le $2
   echo $?
   test $3 == $4
   echo $?
   test -n $3
   echo $? */
   pan@ubuntu:~$ . script1 2 4 'helo' 'hello'
   /*1
   0
   1
   0*/
   
   //2. && ||
   command1 && command2: if command1 succeed then do command2
   command1 || command2 : if command2 fail then do command2
   
   //3. if then statement
   if [command return 0]
   then
   commands
   else
   commands
   if
   //eg
   pan@ubuntu:~$ cat script1 
   /*#!/bin/bash
   if [ "$v" -eq 101 ]
   then
   echo value is equal to 101
   else
   echo value is not equal to 101
   fi */
   pan@ubuntu:~$ v=101
   pan@ubuntu:~$ . script1 
   //value is equal to 101
   pan@ubuntu:~$ bash script1 
   //script1: line 2: [: : integer expression expected
   //value is not equal to 101
   pan@ubuntu:~$ ./script1 
   //./script1: line 2: [: : integer expression expected
   //value is not equal to 101
   pan@ubuntu:~$ v=100
   pan@ubuntu:~$ . script1 
   //value is not equal to 101
   
   
   //Loop
   //set of command that is executed over and over
   //1. while command
   while [command return 0]
   do
   commands
   done
   //eg
   pan@ubuntu:~$ cat script1 
   /*#!/bin/bash
   while true
   do
   echo "it is now $(date)"
   echo "There are `ps aux | wc -l` processes"
   sleep 6
   done */
   pan@ubuntu:~$ . script1 
   /*it is now Wed Jun 20 00:25:38 PDT 2018
   There are 301 processes
   it is now Wed Jun 20 00:25:44 PDT 2018
   There are 301 processes
   it is now Wed Jun 20 00:25:50 PDT 2018
   There are 301 processes
   it is now Wed Jun 20 00:25:56 PDT 2018
   There are 301 processes
   it is now Wed Jun 20 00:26:02 PDT 2018
   There are 301 processes
   it is now Wed Jun 20 00:26:08 PDT 2018
   There are 301 processes*/
   
   //2. for
   for identifier in list
   do
   commands
   done
   //eg
   pan@ubuntu:~$ cat script1 
   /*#!/bin/bash
   for file in ./test*
   do
   cat $file
   sleep 3
   done*/
   pan@ubuntu:~$ . script1 
   /*bird.5
   dog.1
   elephant.32
   monkey.4 
   penguin.10
   zebra.23
   hello world.
   Hello world.*/
   
   //shift argument: deal with large number of parameter
   pan@ubuntu:~$ cat script1  //Use shift + while
   /*#!/bin/bash
   while [ $# -gt 0 ]
   do
   echo $1
   sleep 2
   shift
   done*/
   pan@ubuntu:~$ . script1 1 2 34 5 6 7 7 8
   /*1
   2
   34
   5
   6
   7
   7
   8*/
   pan@ubuntu:~$ cat script1 //Use for
   /*#!/bin/bash
   for p in $@
   do
   echo $p
   sleep 2
   shift
   done*/
   pan@ubuntu:~$ . script1 1 2 34 5 6 7 7 8
   /*1
   2
   34
   5
   6
   7
   7
   8*/
   
   //Uer interaction: read
   //eg
   pan@ubuntu:~$ cat script1 
   /*#!/bin/bash
   echo please enter the file name:
   read name
   if [ -f $name ]
   then
   rm $name
   else
   echo $name is not a file
   fi*/
   pan@ubuntu:~$ . script1 
   /*please enter the file name:
   test
   test is not a file*/
   pan@ubuntu:~$ . script1 
   /*please enter the file name:
   test1*/
   
   //let or $(()): arithmetic expression
   pan@ubuntu:~$ let x=4*4
   pan@ubuntu:~$ echo $x
   //16
   pan@ubuntu:~$ echo $((3 + 4))
   //7
   ```

   