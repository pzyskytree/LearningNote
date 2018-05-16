### Using MySQL

1. **Connect MySQL**
 	```c
    mysql -u root -p
    mysql -u root -p <database_name> < <file_name>.sql
    ```
2. **Use Database**
    ```c
    use <database name>;
    ```
3. **List Database and Table**
	```c
    show databases;//Display all the databases
    show tables; //List all the tables in the database
    show columns from <table name>;//Display all the columns in one table
    show status;//Display the status of server
    show grants;//Display the authority of user
    show errors;//Display the error messasge
    show warnings;//Display the warning message
    show create database <db_name>;//Display the command to create a database;
    show create table <table_name>;//Display the command to create a table;
    help show//Show all the command about show
    ```
 4. **Select data**
 	```c
    select <column_name> from <table_name>; //Select a single column value of 
    //all record from table without order.
    select col1,col2,col3 from <table_name>;//Select multiple columns;
    select * from <table_name>;//Select all the columns; 
    select distinct <columns> from <table_name>//Remove the duplicate, remain the unique one
    //apply to all the columns in the <columns>
    select <columns> from <table_name> limit n;//Return number of records no more than n;
    select <columns> from <table_name> limit m, n;//m start index(starts from 0), 
    //n number of record;
    select <columns> from <table_name> limit n offset m;
    select <table_name>.<column_name> from <database_name>.<table_name>;//Full name;
    ```
  5. **Sort**  
  	Clause: Select, From etc
      ```c
	  select <columns> from <table_name> order by <col1>(asc);//Sort the records based on 
      //col1's value,col1 can not belong to <columns>
      select <columns> from <table_name> order by <col1>, <col2>;//Sort the records firstly 
      //based on col1's value if col1 is the same use col2.
      select <columns> from <table_name> order by <col1> desc;//Sort in descending order 
      select <columns> from <table_name> order by <col1> desc, <col2>;//Sort col1 in 
      //descending order but for col2 still ascending order, for multiple columns, we must
      //add desc after each of them
      ```
      >ORDER BY clause must be ***after*** FROM clause and LIMIT clause must ***after*** ORDER BY clause;
  6. **Filter Data**  
  	WHERE filter condition ***after*** FROM ***before*** ORDER BY
    	```c
        select <columns> from <table_name> where <filter condition>;
        //Operator
        = equal, <> not equal, != not equal, < less than, <= less than or equal, > greater than
        >= greater than or equal, BETWEEN n AND m: n <= values <= m, IS (NOT) NULL: check if 
        the value is null or not
    	```
        Filter Combination:
        ```c
        Logic Operator:
        //AND Satisfy all the filter conditions
        select <columns> from <table_name> where <filter condition1> and <filter condition2>;
        
        //OR Satisfy only one of the condition
        select <columns> from <table_name> where <filter condition1> or <filter condition2>;
        
        //And has a higher priority than or
        select <columns> from <table_name> where <fc1> or <fc2> and <fc3>;//It will firstly pick
        //the records satisfying fc3 and fc2 simultaneously and merge the result with the record
        //satisfying fc1, you can use parentheses.
        
        //IN in a range of condtion similar to OR
        select <columns> from <table_name> where <target> in (v1, v2, v3);
        
        //NOT
        select <columns> from <table_name> where <target> not in (v1, v2, v3);//Pick up the 
        //records not satisfying filter condition
        ```
        Use **Wildcards**: Select unknown value
        ```c
        LIKE //A Predicate to use wildcards to match not value matching
        //% wildcard represents any character in any amount but % will not match NULL
        select <columns> from <table_name> where <col1> like "my%";//Find the records with col1's value 
        //started by "my"
        
        //_ underscore wildcard match a single character
        select <columns> from <table_name> where <col1> like "my_";//Find the records with col1's value
        //started by "my" in length 3;
        ```
        ***Tips***: Do not put the wildcard filter at the beginning. It will make the searching process slow.  
        **Regular Expression**        
        ```c
        REGEXP//Regular Expression
        //Basic Character
        select <columns> from <table_name> where <col1> regexp "1000";//Select all the records with value
        //in col1 having 1000 as substring
        
        //| or match
        select <columns> from <table_name> where <col1> regexp "1000|2000";
        
        //[123] Range of value, [^123] not in the range of 1,2,3; . any one character
        select <columns> from <table_name> where <col1> regexp "[123]000";//match 1000, 2000, or 3000
        //It is not the same as 1|2|3000 which is 1 or 2 or 3000
        select <columns> from <table_name> where <col1> regexp ".000";//.000 is any 4 characters ends with 000 
        
        //[0-9a-zA-Z] From 0 t0 9 a to z and A to Z
        select <columns> from <table_name> where <col1> regexp "[0-9]000"
        
        //Special Character Escaping: \\. represent "."
        select <columns> from <table_name> where <col1> regexp "\\."
        \\f change page, \\n new line, \\r enter, \\t tab, \\\ \
        
        //Multiple characters match
        * zero or mutiple, + 1 or multiple = {1,}, ? zeor or one={0,1}, {n} match n characters,
        {n,} at least n match {n, m} n to m matches;
        select <columns> from <table_name> where <col1> regexp "\\([0-9] sticks?\\)";//sticks or stick
        select <columns> from <table_name> where <col1> regexp "[0-9]{4}";//4 numbers
        
        //Locator
        ```
       
    
    
