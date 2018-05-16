### A learning note of git command  
1. **Git Install**:    
Linux: [make apt-get work](https://askubuntu.com/questions/15433/unable-to-lock-the-administration-directory-var-lib-dpkg-is-another-process)   
    ```c
    sudo rm /var/lib/apt/lists/lock
    sudo rm /var/cache/apt/archives/lock
    sudo rm /var/lib/dpkg/lock
    ```
    ```c
    sudo apt-get install git
    ```
2. **Create Repository**
   1. _Create a empty folder_  
       ```c
       mkdir learngit
       cd learngit
       pwd
       ```  
   2. _Initialize_   
       ```c
       git init
       ```  
   		Create .git directory.
   3. _Add file into buffer area_  
       ```c
       git add <files>
       git add file1.txt file2.txt
       ```  
   4. _Commit your change_  
       ```c
       git commit -m "<Comment>"
       git commit -m "Add two files"
       ```  
3. **Git Time Machine**  
   1. _Check repository status_  
       ```c
       git status
       ```
   2. _Version Trace back_    
   Display the log of commitment  
       ```c
       git log
       ```  
       HEAD: Current Version
       Trace back to last version  
       ```c
       git reset --hard HEAD^
       git reset --hard HEAD^^ 
       git reset --hard HEAD~100  
       git reset --hard <commit_id> 
       ```   
       Record of every command  
       ```c
       git reflog
       ```  
   3. _Working Directory and Stage_  
       Directory in computer: eg /learngit/  
       Repository(版本库): .git  
       ![repository](https://cdn.liaoxuefeng.com/cdn/files/attachments/001384907702917346729e9afbf4127b6dfbae9207af016000/0)  
       stage: 暂存区, HEAD: pointer to the master  
       ```c
       git add //Add file from directory to stage
       git commit //Add file from stage to Branch
       ```  
    4. _Manage Modification_  
        ```c
        git diff //Work Directory vs Stage
        git diff --cached // Stage vs Branch
        git diff HEAD -- // Work Directory vs Branch
        ```
    5. *Repeal Modification*  
       Retrovate the modification in work directory  
         ```c
         git checkout -- <file>// Copy the file from stage to work directory
         git checkout HEAD <file> // Copyt the file from branch to work directory
         ```
       Retrovate the modification in Stage
        ```c
        git reset HEAD <file>  
        ```
    6. _Delete File_  
       ```c
       git rm <file>
       ```
 4. **GitHub**  
    1. Create SSH key
        ```c
        shh-keygen -t rsa -C "youremail@example.com	//Generate id_rsa id_rsa.pub
        ```
    2. Add tele-repository
       ```c
       git remote add origin youremail@example.com/abc.gi //Correlate github with your local repository
       ```
    3. Push local repository to github
        ```c
		git push origin master
        ```
    4. Clone from github
    	```c
        git clone youremail@example.com/abc.git 
        ```
  5. **Branch Management**
  	 1. Create and Merge branch
  	 	HEAD points to the current branch
        ```c
        git branch// List all the branches
        ```
  	 	```c
        git checkout -b <new_branch> //Create and move to the new branch
        ```
        ```c
        git branch <new_branch> // Create new branch
        git checkout branch // Move to the new branch
        ```
        ```c
        git merge dev //Merge to the current branch in Fast-Forward model
        ```
		```c
        git branch -d <branch>//Delete an existing branch
        ```
     2. Solve conflict
     	Can not merge directly, solve the conflict and go into a new node.
        ```c
        git log --graph//Show commit graph
        ```
     3. Branch Management Strategy
        ```c
        git merge --no-ff -m "merge with no-ff" dev //no fast-forward 
        // Not move the pointer but create a new commit node to merge
        ```
   6
    
       














