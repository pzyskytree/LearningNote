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
    * Associate another file with the an existing inode.They have the same content but not with same name.  
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
    * Can link to directory and acroos file system
    * Useless once remove the file.
    ```c
    ln -s file1 file2//Soft link
    //Soft link allows to create a new file with different inode and inode number, it is a shortcut of the 
    //existing file. Once the existing file is deleted, it becomes useless.
    ```
    ```c
    //Different between hard link and soft link. hard_test has the same attribute as test date, all of these
    //information are stored in inode.
    2239162 -rw-rw-r-- 2 pan pan 40 May 18 17:25 hard_test
    2236084 lrwxrwxrwx 1 pan pan  4 May 18 18:06 soft_test -> test
    2239162 -rw-rw-r-- 2 pan pan 40 May 18 17:25 test
    ```
    

