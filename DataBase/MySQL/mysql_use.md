###  Using MySQL

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
     ***WHERE*** filter condition ***after*** FROM ***before*** ORDER BY

     ```c
     select <columns> from <table_name> where <filter condition>;
     //Operator
     = equal, <> not equal, != not equal, < less than, <= less than or equal, > greater than >= greater than or equal, BETWEEN n AND m: n <= values <= m, IS (NOT) NULL: check if the value is null or not
     ```

     Filter Combination:  

     ```c  
     Logic Operator:  //AND Satisfy all the filter conditions  select <columns> from <table_name> where <filter condition1> and <filter condition2>;
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

     Use **Wildcards**:   Select unknown value and Match the whole string
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
     **Regular Expression**: Match the substring        
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
        ^ head of the file, $ tail of the file
        select <columns> from <table_name> where <col1> regexp "^[0-9\\.]";//Start with number
        select <columns> from <table_name> where <col1> regexp "[0-9\\.]$";//End with number
        
        //Check expression
        select "String" regexp "[0-9]"//Check if "String" contains number, return 0(not matching) or 1(matching)
     ```

   7. **Calculated Field**  
       Calculated filed is not inside database, it is created when select statement is executed.    
        Concatenate:  
        ```c
        Concat()
        select Concat(col1, '(', col2, ')') from <table_name> where <fc>//Select multiple columns and 
        //concatenate them together
        
        RTrim()
        select Concat(RTrim(col1), "(", RTrim(col2), ")") from <table_name> where <fc>//Remove the space 
        //at the end of each value.
        ```
        Alias: Illegal to use the same name as one of the columns.
        ```c
        AS
        select Concat(RTrim(col1), "(", RTrim(col2), ")") as new_col from <table_name> where <fc>//Give an 
        //alias new_col to the new concatenated column.
        //Arithmetic Calculation: + - * /
        select col1, col2, col1 + col2 as sum_col from <table_name> where <fc>
        ```

   8. **Function**  
       * Text Function
          ```c
          select col1, Function(col1) as new_col1 from <table_name>
          Length(str)//Length of String str
          Locate(substr, str)//Return 1 if str contain substr, else return 0
          Upper(str) //Transfer all the letter in the string to be upper case
          Lower(str) //Transfer all the letter in the string to be lower case
          Left(str, n)//Return n left characters of str
          Right(str, n)//Return n right characters of str
          Rtrim(str)//Remove the space at right;
          Ltrim(str)//Remove the space at left;
          Substring(str, i, len)//i start index from 1 to length(str), len the length of substring
          Soundex(str)//Sound value
          ```
       * Date and Time Function  
           ```c
           Format of date: yyyy-mm-dd
           AddDate(date, n)//Add n days to date
           AddTime(time, n)//Add n seconds to time
           CurDate();//Return current date
           CurTime();//Return current time
           Now() = CurDate() + CurTime()
           Date(time)//Return date part of time: yyyy-mm-dd
           DateDiff(d1, d2)//Return d1 - d2
           Year(time)//Return year part of the time
           Month(time)//Return month part of the time
           Day(time)//Return the day part of time
           DayOfWeek(date)//Return the week day of date
           Time(time)//Return the time part: hh:mm:ss
           Hour(time)//Return hour part of the time
           Minute(time)//Return minute part of the time
           Second(time)//Return the second part of the time
           select <colmns> from <table_name> where date(date_col) between "yyyy-mm-dd1" and "yyyy-mm-dd2"
           //Select the record with date_col between two dates
           select <colmns> from <table_name> where year(date_col) = yyyy and month(date_col) = mm;
           //Select a specific month;
           ```
        * Value Function
             ```c
             Cos(x)//Cosine value. if x = pi cos(x) = -1
             Sin(x)//Since value. if x = pi/2 sin(x) = 1
             Tan(x)
             Abs(x)//Absolute value
             Sqrt(x)//Return square root of x. eg. x = 4 return 2
             Exp(x)//Return e ^ x
             Log(x)//Return ln(x)
             Mod(a, b)// Return a % b
             Pi()//Return pi
             Rand()//Return a random number
             ```

       * Aggregate Function: Return a statistical value  

         ```c
         Avg(col)//Return average value of one specific column. It will ignore NULL value;
         select avg(col1) as avg_col from <table_name> where <fc_name>;
         Count(col)//Count the number of return rows, ignoring NULL
         Count(*)//Count the number of rows including NULL
         select count(col1) as count_col from <table_name> where <fc_name>;
         Max(col)//Return the max value of one specific column among all the selected record, ignoring NULL
         select max(col) as max_value from <table_name> where <fc_name>;
         //Max can return the max value of date and string as well
         Min(col)//Return the min value of one specific column among all the selected record, ignoring NULL
         select min(col) as min_value from <table_name> where <fc_name>;
         Sum(col)//Return total sum of the one specific column among all select records, ignoring null
         select sum(col) as total_sum from <table_name> where <fc_name>;
         Distinct//Just consider distinct value, the default is ALL value
         select avg(distinct col) as avg_value from <table_name> where <fc_name>;
         Distinct can be used to count(distinct col) but not count(distinct *)
         
         ```

         

       

   9. **Group Data**
      * Create group: **Group by**
           * Group by can contain any number of columns. It can make embeded group. The group is built based on
              all the appointed columns not the single one.
              *  All the columns in the select except for the aggregate function should also appear in group by clause.
              *  All the Null value will be assigned to the same group.
              *  Group by must appear after where but before order by
              *  Group by cannot have aggreate function.
              ```c
               select col1, count(col2) 
               from table 
               where fc 
               group by col1;//Group the data from the table based on
               //different value of col1
              ```

       * Filter Group: **Having**: including some groups and excluding other groups 
            * The target of WHERE is row record, while HAVING is to deal with each group.
            * Actually all the conditin in where clause can also in HAVING
            * Where filters rows before grouping, having filters groups after grouping
              ```c
               select col1, count(col2) 
               from table 
               where fc1 
               group by col1 
               having fc2;//Group the data from the
               //table based on different value of col1 and rule out all the groups not satisfying filter 
               //condition2
              ```
       * Difference between ORDER BY and GROUP BY:
          * order by's output are ordered, group by's output are group rows but not in order.
            Clause order	 
            **select -> from -> where -> group by -> having -> order by -> limit**

     10. **Subquery**  

        * Use subquery as filter:  
          ```c
          select col1, col2 
          from table1 
          where col1 in (select col1 
          			   from table2
                         where fc1);//Select record 
          //based on the result from the subquery. The order is from inside query to outside query.
          ```
          In most cases the return column of inside query is only one column.   
          Keep the number of column in WHERE the same as the number of column in internal query.
        * Use subquery as calculated field:
          ```c
          select col1, col2, (select col3 from table1 whre fc2) as new_col 
          from table1 
          where fc1;//The result
           //of the subquery as a return field. For each row of the result, the subquery will execute one time.
           //When one column's name of two tables are the same, we should use the full name rather than 
           //partial name.
          ```

​      

11. Joint Table

   1.   Relation Table

      It isn't suitable to store the same message into one table for many times. It is better to separate them into different tables.

      ***Foreign Key:***  A primary key in other table which define the relationship between two tables.

      * Save time and space.
      * Once we need to update the data, we can only change one table.
      * There is no duplicate data, so it remains the consistency of data.
      * Great scalability, it can sustain the increasing workload.

   2. Create Joint Table

      ```c
      Cartesian Product: 
      //If there is no where clause as restriction, the result will be the cartesian 
      //product between table1 and table2, the total row number is the product of
      //the their row number.
      select vend_name, prod_name, prod_price 
      from products, vendors  
      order by vend_name, prod_name;
      
      //Equijoin
      select vend_name, prod_name,prod_price 
      from products, vendors 
      where vendors.vend_id = products.vend_id 
      order by vend_name, prod_name;
      //vendors.vend_id = products.vend_id build connection during the process of query
      //Inner Join
      select vend_name, prod_name, prod_price
      from vendors inner join products on
      vendors.vend_id = products.vend_id 
      order by vend_name, prod_name;
      //From clause build the join relationship. The filter condition is after on.
      
      //Multiple tables join
      select prod_name, vend_name, prod_price, quantity 
      from orderitems, products,vendors 
      where products.vend_id = vendors.vend_id and orderitems.prod_id = 
      products.prod_id;
      ```

   3. Create Advanced Joint Table

      * Use Table Alias: Shorten the length of  SQL

        ```c
        //Table alias can be used in different clauses
        select c.cust_name, c.cust_contact 
        from customers as c, orders as o, orderitems as oi 
        where c.cust_id = o.cust_id and oi.order_num = o.order_num 
        and prod_id = "TNT2";
        ```

      * Self-Joint

        ```c
        //Joint between the same table. Make a cartesian product in the same table
        // and pick the rows that satisfy the filter requirment. It is used to 
        // substitute the subquery.
        select p1.prod_id, p1.prod_name 
        from products as p1, products as p2
        where p1.vend_id = p2.vend_id and p2.prod_id = "DTNTR";
        ```

      * Natural-Joint

        ```c
        //The columns with same name try to merge them together. If they have the 
        //same values, then join them into one record in the result. It will drop one
        //column of the duplicate value, while inner joint will not. Natual joint is 
        //special case of inner joint.
        select c.*, o.order_num, o.order_date, oi.prod_id, oi.quantity,oi.item_price 
        from customers as c, orders as o, orderitems as oi 
        where c.cust_id = o.cust_id and oi.order_num = o.order_num 
        and prod_id = 'FB';
        
        select c.*, o.order_num, o.order_date 
        from customers as c, orders as o 
        where c.cust_id = o.cust_id;
        
        ```

        

      * Outer-joint

        ```c
        //Out-joint will also return the not matching rows.
        select customers.cust_id, orders.order_num 
        from customers left outer join orders on customers.cust_id = orders.cust_id;
        //Left outer joint, the right orders.order_num may be NULL. All the rows in 
        //customers will be matched.  
        
        select customers.cust_id, orders.order_num 
        from customers right outer join orders on customers.cust_id = orders.cust_id;
        //Right outer joint, the left value may be NULL.All the right rows in orders
        // will be matched.
        
        ```

        

      *  Joint with Aggregate Function

           ```c
           //Using Count to count the number of orders for each customer.
           select customers.cust_name, customers.cust_id, count(orders.order_num) as num_ord 
           from customers inner join orders on customers.cust_id = orders.cust_id 
           group by customers.cust_id ;
           //Left outer joint, there will be one count with value of zero. Since the 
           //Order_num is null.
           select customers.cust_name, customers.cust_id, count(orders.order_num) as num_ord 
           from customers left outer join orders on customers.cust_id = orders.cust_id 
           group by customers.cust_id ;

           ```

12. Combined Query

     UNION: Get the Union result of multiple select result.

      ```c
     select vend_id, prod_id, prod_price 
     from products
     where prod_price <= 5
     union
     select vend_id, prod_id, prod_price
     from products
     where vend_id in (1001,1002);
     //The two query result must have the same columns expression and aggregate funtions 
     //in same order. It will only remain one of the duplicate record.
     //The effect of union is similar to or:
     select vend_id, prod_id, prod_price 
     from products 
     where prod_price <= 5 or vend_id in (1001,1002)
     
     //Retain all the duplicate rows.
     select vend_id, prod_id, prod_price 
     from products
     where prod_price <= 5
     union all
     select vend_id, prod_id, prod_price
     from products
     where vend_id in (1001,1002);
     
     select vend_id, prod_id, prod_price  
     from products 
     where prod_price <= 5 
     union 
     select vend_id, prod_id, prod_price 
     from products 
     where vend_id in (1001,1002) 
     order by vend_id, prod_price;
     //Order by must be in the last select and the entire query can only have one order by
      ```

13. Full-Text Search

    * Build an Index for the value in each column.

    ```c
    //create table with full text and index
    CREATE TABLE `productnotes` (
      `note_id` int(11) NOT NULL AUTO_INCREMENT,
      `prod_id` char(10) NOT NULL,
      `note_date` datetime NOT NULL,
      `note_text` text,
      PRIMARY KEY (`note_id`),
      FULLTEXT KEY `note_text` (`note_text`)
    ) ENGINE=MyISAM AUTO_INCREMENT=115 DEFAULT CHARSET=latin1
    //Build the index after importing all the data into the database;
    
    //Use Full text index Match() Against()
    //The result is sorted based on relevance and pattern's position and numbers.
    select col1
    from table
    where Match(col1) Against("Pattern");
    //eg
    select note_text
    from productnotes
    where Match(note_text) Against("rabbit");//Ignore cases 
    //Equivalent
    select note_text
    from productnotes 
    where note_text like "%rabbit%";
    //Display Rank of each record
    select note_text, match(note_text) against("rabbit") as rank 
    from productnotes;
    
    ```

    * Query Expansion

    ```c
    //Two times search, one is a basic full-text search and selet the useful words.
    //The other is to search based on the useful words and pattern. Approximate Search
    select col1
    from table
    where Match(col1) Against("Pattern" With Query Expansion);
    //eg
    select note_text 
    from productnotes 
    where match(note_text) against("anvils" with query expansion);
    ```

    * Boolean Text Query

    ```c
    //It can use for the column with out full text index but it is very slow
    //In Boolean Mode
     select col1
    from table
    where Match(col1) Against("Pattern" In Boolean Mode);
    //Operator:
    //+ must include
    select note_text 
    from productnotes 
    where match(note_text) against("+rabbit +bait" in boolean mode);
    //Include both words at the same time
    select note_text 
    from productnotes 
    where match(note_text) against("rabbit bait" in boolean mode);
    //Include either on the of the words;
    
    //- exlude * wildcard
    select note_text 
    from productnotes 
    where match(note_text) against("heavy -rope*" in boolean mode);
    //Include heavy exlude words with rope as prefix
    
    //> include increasing rank, < include but decreasing rank
    select note_text
    from productnotes
    where match(note_text) against(">rabbit <carrot" in boolean mode);
    
    //() use for combining words to expression
    select note_text 
    from productnotes 
    where match(note_text) against("+safe +(<combination)" in boolean mode);
    ```

    * Index does not contain the words with length less than 4
    * stop word: word list that are ignored when building the index
    * If a word occurs more than 50% of the record, it is a stop word
    * ignore the ' inside word: don't == dont
    * Full-Text can only be supported by MyISAM engine

14. Insert Data

    ```c
    //1: insert an entire row
    insert into <table>
    values();
    //eg: The value's order is consistent with the record inside table.
    insert into customers  
    values(NULL, "Pep E. LaPew", "100 Main Street", "Los Angeles" , "CA", "90046", "USA", NULL, NULL);
    //eg more safe: specify the name of column
    insert into customers(cust_name, cust_address, cust_city, cust_state, cust_zip, cust_country, cust_contact, cust_email)  
    values("Pep E. LaPew", "100 Main Street", "San Fransisco" , "CA", "90046", "USA", NULL, NULL);
    //If there is no column's name, we must specify all the value of each column. If we 
    //are given the column's name, we should specify the value in the name list.
    
    //Insert Multiple values
    insert into table()
    values (),(),();
    
    //Insert data from one table to another
    insert into table1(col1, col2)
    select col3, col4
    from table2;
    ```

    * Omitting Column: if the value can be null or specified the default value;
    * Low_priority: Lower the priority of the insert operation; Insert low_priority into

15. Update and Delete data

    * Update : 1. Update specific rows, 2. Update all rows

    ```c
    update table
    set col1 = new_value
    where fc1.
    // eg
    update customers 
    set cust_email = "elmer@fudd.com" 
    where cust_id = 10005;
    //Without where, it will update all the rows in the table.
    update customers 
    set cust_email = "elmer@fudd.com", cust_name = "The Fudd"  
    where cust_id = 10005;
    //Update Multiple columns 
    //If one of the columns' update meets problem, the entire update will be canceled.
    update ignore table .. 
    //Ignore key word let the error be ignored and the update keeps working.
    
    update table
    set col1 = null;
    //Set one column to be NULL to delete this column.
    ```

    * Delete Data: 1. Delete specific rows 2. Delete all rows

    ```c
    //Delete is to delete the whole rows not one or some columns.
    delete from table
    where fc;
    //It only delete the content or record inside the table but not delete table.
    truncate table;//Delte all rows in the table;
    //eg
    delete from customers 
    where cust_id = 10006;
    ```

16. Create Table

    * Table's name
    * Columns' name and definition

    ```c
    CREATE TABLE `customers` (IF NOT EXISTS) (
      `cust_id` int(11) NOT NULL AUTO_INCREMENT,
      `cust_name` char(50) NOT NULL,
      `cust_address` char(50) DEFAULT NULL,
      `cust_city` char(50) DEFAULT NULL,
      `cust_state` char(5) DEFAULT NULL,
      `cust_zip` char(10) DEFAULT NULL,
      `cust_country` char(50) DEFAULT NULL,
      `cust_contact` char(50) DEFAULT NULL,
      `cust_email` char(255) DEFAULT NULL,
      `quantity`   int NOT NULL DEFAULT 1,
      PRIMARY KEY (`cust_id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=10009 DEFAULT CHARSET=latin1
    //The name of table must not exist.
    //IF NOT EXISTS only create the table when the name of table does not exist.
    
    //NULL allows not designating value when inserting new record.
    
    //Primary key can be multiple columns,and for each record the combination of
    //there columns are unique.
    //Primary key does not allow NULL value.
    
    //Auto_increment for each insert, it will increase by one automatically.
    //For each table there is only one auto_increment column and it has index.
    select last_insert_id() //Find the last id of inserted record.
    
    //Default 1 set the default value to one.(only allow constant as default value
    // not function value)
    
    //Engine type:
    InnoDB //Transaction Processing Engine not support full text
    MEMORY //Like MyISAM but store the data into memory
    MyISAM //Support full text bu not support transaction processing
    // The foreign key cannot cross different engines.
      
    ALTER TABLE// change the defination of table
    //eg
    alter table vendors
    add vend_phone char(20);
    alter table vendors
    drop column vend_phone;
    //Alter table : define foreign key.
    alter table orderitems
    add constraint fk_orderitems_orders
    foreign key (order_num) references orders(order_num);
    
    DROP TABLE <Table_name> //Delete table
    
    RENAME TABLE table1 To table2, table3 to table 4; //Rename Table
    ```

17. Use View

    View: Virtual Table  It consists of the result of a sql query.

    * Reuse the result of sql
    * Use part of table not the entire table
    * Protect the data
    * View doesn't contain data

    ```c
    CREATE VIEW viewname AS //Create new view
    SHOW CREATE VIEW viewname;
    DROP VIEW viewname; //delete view
    //Update view 
    Drop then create
    CRATE OR REPLACE VIEW
    //eg.
    create view productcustomers as
    select cust_name, cust_contact, prod_id
    from customers, orders, orderitems
    where customers.cust_id = orders.cust_id
    and orderitems.order_num = orders.order_num;
    
    select cust_name, cust_contact 
    from productcustomers 
    where prod_id = "TNT2";
    
    create view vendorlocation as 
    select concat(rtrim(vend_name), ' (', rtrim(vend_country), ')') as vend_title
    from vendors
    order by vend_name;
    
    //Use view as filter
    create view customeremaillist as
    select cust_id, cust_name, cust_email
    from customers
    where cust_email is not null;
    
    //Use function
    create view prodview as 
    select vend_id, count(prod_id) 
    from products 
    group by vend_id 
    having count(vend_id) > 2;
    
    //Update view
    //If there is group by, join, subquery, union aggregation function, distinct inside
    // view, it cannot be updated.
    //Otherwise, if we insert into some records into the table, the view will be update.
    ```

18. Procedure

    Multiple SQL sentences

    * Simple 
    * Safe
    * High-performance

    Use procedure

    ```c
    Delimiter # //Dfine delimiter
    //Create new procedure
    create procedure productpricing() 
    begin  
    	select avg(prod_price) as priceaverage 
    	from products; 
    end#
    // Call procedure
    call productpricing()#
    // Delete procedure
    Drop procedure if exists productpricing#
    
    //Variable storing the data temporarily
    @variable
    //Out: return varibale, in: passing in varibale, inout
    //Define 
    create procedure productpricing(
    	out pl decimal(8,2),
        out ph decimal(8,2),
        out pa decimal(8,2)
    )
    begin 
    	select min(prod_price)
        into pl
        from products;
    	select max(prod_price)
        into ph
        from products;
        select avg(prod_price)	
        into pa
        from products;
    end#
    ///Call the procedure
    call productpricing(@pricelow, @pricehigh, @priceaverage)#
    //Display the value of variable
    select @pricelow, @pricehigh, @priceaverage#
    
    //use input parameter
    create procedure ordertotal(
    	in number int,
        out total decimal(8,2)
    )
    begin
    	select sum(quantity * item_price)
        from orderitems
        where order_num = number
        into total;
    end#
    call ordertotal(20005, @total)#
    select @total#
    
    //Complicated procedure with local variable and if statement
    //Comment
    -- Name:ordertotal
    -- Parameter: onumber = order number
    --           taxable = 0 if not taxable 1 if taxable
    --           ototal = order total variable
    
    create procedure ordertotalwithtax(
    	in onumber int,
        in taxable boolean,
        out ototal decimal(8,2)
    )
    begin
    	declare total decimal(8,2);
    	declare taxrate int default 6;
    	
    	select sum(quantity * item_price)
        from orderitems
        where onumber = order_num
        into total;
    
        if taxable then
        	select total + (total/100*taxrate) into total;	
        end if;
    	
        select total into ototal;
    end#
    //Display the statement to create a procedure
    show create procedure procedure_name;
    
    ```

19. Cursor

    ```c
    //Create cursor: Use Declare
    create procedure processorder()
    begin
    	declare ordernumbers cursor
    	for
    	select order_num from orders;
    end#
    
    //Open/Close cursor
    open cursor_name;
    close cursor_name;
    
    //Use Cursor
    //Fetch
    create procedure processorder()
    begin
    	declare done boolean default 0;
    	declare o int;
    	
    	declare orderNum cursor
    	for
    	select order_num from orders;
    	
    	declare continue handler for sqlstate "02000" set done=1;
       
        open orderNum;
    	repeat
    		--Get values
    		fetch orderNum into o;
    	until done end repeat;
        close orderNum;	
    end#
    
    //Use cursor and call function
    create procedure processorders()
    begin
    	declare done boolean default 0;
    	declare o int;
    	declare t decimal(8,2);
    	
    	declare orderc cursor
    	for
    	select order_num from orders;
    	
    	declare continue handler for sqlstate "02000" set done=1;
    
    	create table if not exists ordertotals
    	(order_num int, total decimal(8,2));
    
    	open orderc;
    	repeat
    		fetch orderc into o;
    		call ordertotalwithtax(o, 1, t);
    		insert into ordertotals(order_num, total)
            values(o, t);
    	until done end repeat;
    	close orderc;
    end#		
    ```

20. Trigger

    Some operations will be executed automatically under certain circumstance.

    Create Trigger

    * Unique name in the same database
    * Related table
    * The activity the trigger is listening
    * When to execute

    ```c
    //create trigger:
    CREATE TRIGGER trigger_name
    trigger_time
    trigger_event ON tbl_name
    FOR EACH ROW
    trigger_stmt
    /*trigger_name：标识触发器名称，用户自行指定；
    trigger_time：标识触发时机，取值为 BEFORE 或 AFTER；
    trigger_event：标识触发事件，取值为 INSERT、UPDATE 或 DELETE；
    tbl_name：标识建立触发器的表名，即在哪张表上建立触发器；
    trigger_stmt：触发器程序体，可以是一句SQL语句，或者用 BEGIN 和 END 包含的多条语句。*/
    //eg
    CREATE TRIGGER newhero AFTER INSERT ON hero FOR EACH ROW SELECT "Add new Hero";
    //Only table support trigger, it is not suitable for view
    //A table can mostly have 6 trigger for update delete insert.
    
    DROP TRIGGER newhero;//Delete a trigger
    SHOW TRIGGERS;//Display all the triggers;
    
    //Insert Trigger
    create trigger newproducts 
    after insert on products
    for each row
    select new.order_num
    //Delete Trigger
    create trigger deleteorder 
    before delete on
    orders
    for each row
    begin
    	insert into archive_orders(order_num, order_date, cust_id)
        values(old.order_num, old.order_date, old.cust_id);
    end#
    //Update Trigger
    create trigger updatevendor
    before update on
    vendors
    for each row
    set new.vend_state = Upper(new.vend_state);
    ```

21. Transaction Management (InnoDB)

    Atomic: Whether all the operations are executed or none of them are executed

    * Transaction
    * Rollback
    * Commit
    * Savepoint

     ```c
    //Control Transaction Management
    start transaction;
    rollback;//Can only roll back upadte, delete, insert, but can not roll back create, 
    //drop, alter table, select;
    //eg
    mysql> select * from hero;
    /*+----+-------+--------+
    | id | name  | damage |
    +----+-------+--------+
    |  1 | teemo |     32 |
    +----+-------+--------+
    1 row in set (0.00 sec)*/
    mysql> start transaction;
    //Query OK, 0 rows affected (0.00 sec)
    mysql> delete from hero;
    //Query OK, 1 row affected (0.00 sec)
    mysql> select * from hero;
    //Empty set (0.00 sec)
    mysql> rollback;
    //Query OK, 0 rows affected (0.00 sec)
    mysql> select * from hero;
    /*+----+-------+--------+
    | id | name  | damage |
    +----+-------+--------+
    |  1 | teemo |     32 |
    +----+-------+--------+
    1 row in set (0.00 sec)*/
    
    
    //For common sql statement, it is autmatically commited
    commit
    mysql> select * from hero;
    /*+----+-------+
    | id | name  |
    +----+-------+
    |  1 | teemo |
    +----+-------+*/
    1 row in set (0.00 sec)
    mysql> start transaction;
    //Query OK, 0 rows affected (0.00 sec)
    mysql> insert into hero values(2, "garen");
    //Query OK, 1 row affected (0.00 sec)
    mysql> select * from hero;
    /*+----+-------+
    | id | name  |
    +----+-------+
    |  1 | teemo |
    |  2 | garen |
    +----+-------+
    2 rows in set (0.00 sec)*/
    mysql> commit;
    //Query OK, 0 rows affected (0.00 sec)
    mysql> select * from hero;
    /*+----+-------+
    | id | name  |
    +----+-------+
    |  1 | teemo |
    |  2 | garen |
    +----+-------+
    2 rows in set (0.00 sec)*/
    
    //savepoint 
    savepoint p1;
    rollback to p1;
    //eg
    mysql> start transaction;
    //Query OK, 0 rows affected (0.00 sec)
    mysql> delete from hero where id = 2;
    //Query OK, 1 row affected (0.02 sec)
    mysql> select * from hero;
    /*+----+-------+
    | id | name  |
    +----+-------+
    |  1 | teemo |
    +----+-------+
    1 row in set (0.00 sec)*/
    mysql> savepoint delete1; //Save a check point
    //Query OK, 0 rows affected (0.00 sec)
    mysql> insert into hero values(3, "garen");
    //Query OK, 1 row affected (0.00 sec)
    mysql> select * from hero;
    /*+----+-------+
    | id | name  |
    +----+-------+
    |  1 | teemo |
    |  3 | garen |
    +----+-------+
    2 rows in set (0.00 sec)*/
    mysql> rollback to delete1; //Roll back to the savepoint
    //Query OK, 0 rows affected (0.00 sec)
    mysql> select * from hero;
    /*+----+-------+
    | id | name  |
    +----+-------+
    |  1 | teemo |
    +----+-------+
    1 row in set (0.00 sec)*/
    mysql> commit;
    //Query OK, 0 rows affected (0.00 sec)
    mysql> select * from hero;
    /*+----+-------+
    | id | name  |
    +----+-------+
    |  1 | teemo |
    +----+-------+
    1 row in set (0.00 sec)*/
    //After commit or rollback the savepoint will be released automatically.
    
    set autocommit = 0;
    //eg
    mysql> set autocommit = 0;
    //Query OK, 0 rows affected (0.01 sec)
    mysql> select * from hero;
    /*+----+-------+
    | id | name  |
    +----+-------+
    |  1 | teemo |
    +----+-------+
    1 row in set (0.00 sec)*/
    mysql> insert into hero values(2,"gere");
    //Query OK, 1 row affected (0.00 sec)
    mysql> select * from hero;
    /*+----+-------+
    | id | name  |
    +----+-------+
    |  1 | teemo |
    |  2 | gere  |
    +----+-------+
    2 rows in set (0.00 sec)*/
    mysql> rollback;
    //Query OK, 0 rows affected (0.01 sec)
    mysql> select * from hero;
    /*+----+-------+
    | id | name  |
    +----+-------+
    |  1 | teemo |
    +----+-------+
    1 row in set (0.00 sec)*/ 
    mysql> insert into hero values(2, "garen");
    //Query OK, 1 row affected (0.00 sec)
    mysql> commit;
    //Query OK, 0 rows affected (0.00 sec)
    mysql> rollback;
    //Query OK, 0 rows affected (0.01 sec)
    mysql> select * from hero;
    /*+----+-------+
    | id | name  |
    +----+-------+
    |  1 | teemo |	
    |  2 | garen |
    +----+-------+
    2 rows in set (0.00 sec)*/
     ```

22. Global and Local

    ```c
    //Charset
    mysql> show character set; //Display all character sets
    /*+----------+---------------------------------+---------------------+--------+
    | Charset  | Description                     | Default collation   | Maxlen |
    +----------+---------------------------------+---------------------+--------+
    | big5     | Big5 Traditional Chinese        | big5_chinese_ci     |      2 |
    | dec8     | DEC West European               | dec8_swedish_ci     |      1 |
    | cp850    | DOS West European               | cp850_general_ci    |      1 |
    | hp8      | HP West European                | hp8_english_ci      |      1 |
    | koi8r    | KOI8-R Relcom Russian           | koi8r_general_ci    |      1 |
    | latin1   | cp1252 West European            | latin1_swedish_ci   |      1 |
    | latin2   | ISO 8859-2 Central European     | latin2_general_ci   |      1 |
    | swe7     | 7bit Swedish                    | swe7_swedish_ci     |      1 |
    | ascii    | US ASCII                        | ascii_general_ci    |      1 |
    | ujis     | EUC-JP Japanese                 | ujis_japanese_ci    |      3 |
    | sjis     | Shift-JIS Japanese              | sjis_japanese_ci    |      2 |
    | hebrew   | ISO 8859-8 Hebrew               | hebrew_general_ci   |      1 |
    | tis620   | TIS620 Thai                     | tis620_thai_ci      |      1 |
    | euckr    | EUC-KR Korean                   | euckr_korean_ci     |      2 |
    | koi8u    | KOI8-U Ukrainian                | koi8u_general_ci    |      1 |
    | gb2312   | GB2312 Simplified Chinese       | gb2312_chinese_ci   |      2 |
    | greek    | ISO 8859-7 Greek                | greek_general_ci    |      1 |
    | cp1250   | Windows Central European        | cp1250_general_ci   |      1 |
    | gbk      | GBK Simplified Chinese          | gbk_chinese_ci      |      2 |
    | latin5   | ISO 8859-9 Turkish              | latin5_turkish_ci   |      1 |
    | armscii8 | ARMSCII-8 Armenian              | armscii8_general_ci |      1 |
    | utf8     | UTF-8 Unicode                   | utf8_general_ci     |      3 |
    | ucs2     | UCS-2 Unicode                   | ucs2_general_ci     |      2 |
    | cp866    | DOS Russian                     | cp866_general_ci    |      1 |
    | keybcs2  | DOS Kamenicky Czech-Slovak      | keybcs2_general_ci  |      1 |
    | macce    | Mac Central European            | macce_general_ci    |      1 |
    | macroman | Mac West European               | macroman_general_ci |      1 |
    | cp852    | DOS Central European            | cp852_general_ci    |      1 |
    | latin7   | ISO 8859-13 Baltic              | latin7_general_ci   |      1 |
    | utf8mb4  | UTF-8 Unicode                   | utf8mb4_general_ci  |      4 |
    | cp1251   | Windows Cyrillic                | cp1251_general_ci   |      1 |
    | utf16    | UTF-16 Unicode                  | utf16_general_ci    |      4 |
    | utf16le  | UTF-16LE Unicode                | utf16le_general_ci  |      4 |
    | cp1256   | Windows Arabic                  | cp1256_general_ci   |      1 |
    | cp1257   | Windows Baltic                  | cp1257_general_ci   |      1 |
    | utf32    | UTF-32 Unicode                  | utf32_general_ci    |      4 |
    | binary   | Binary pseudo charset           | binary              |      1 |
    | geostd8  | GEOSTD8 Georgian                | geostd8_general_ci  |      1 |
    | cp932    | SJIS for Windows Japanese       | cp932_japanese_ci   |      2 |
    | eucjpms  | UJIS for Windows Japanese       | eucjpms_japanese_ci |      3 |
    | gb18030  | China National Standard GB18030 | gb18030_chinese_ci  |      4 |
    +----------+---------------------------------+---------------------+--------+
    41 rows in set (0.00 sec)*/
    
    //Collation for character sort in order by and group by
    mysql> show collation;
    /*+--------------------------+----------+-----+---------+----------+---------+
    | Collation                | Charset  | Id  | Default | Compiled | Sortlen |
    +--------------------------+----------+-----+---------+----------+---------+
    | big5_chinese_ci          | big5     |   1 | Yes     | Yes      |       1 |
    | big5_bin                 | big5     |  84 |         | Yes      |       1 |
    | dec8_swedish_ci          | dec8     |   3 | Yes     | Yes      |       1 |
    | dec8_bin                 | dec8     |  69 |         | Yes      |       1 |
    | cp850_general_ci         | cp850    |   4 | Yes     | Yes      |       1 |
    | cp850_bin                | cp850    |  80 |         | Yes      |       1 |
    | hp8_english_ci           | hp8      |   6 | Yes     | Yes      |       1 |
    | hp8_bin                  | hp8      |  72 |         | Yes      |       1 |
    | koi8r_general_ci         | koi8r    |   7 | Yes     | Yes      |       1 |
    | koi8r_bin                | koi8r    |  74 |         | Yes      |       1 |
    | latin1_german1_ci        | latin1   |   5 |         | Yes      |       1 |
    | latin1_swedish_ci        | latin1   |   8 | Yes     | Yes      |       1 |
    | latin1_danish_ci         | latin1   |  15 |         | Yes      |       1 |
    | latin1_german2_ci        | latin1   |  31 |         | Yes      |       2 |
    | latin1_bin               | latin1   |  47 |         | Yes      |       1 |
    | latin1_general_ci        | latin1   |  48 |         | Yes      |       1 |
    | latin1_general_cs        | latin1   |  49 |         | Yes      |       1 |
    | latin1_spanish_ci        | latin1   |  94 |         | Yes      |       1 |
    */
    
    mysql> show variables like 'character%'; //Check the character set;
    /*+--------------------------+----------------------------+
    | Variable_name            | Value                      |
    +--------------------------+----------------------------+
    | character_set_client     | utf8                       |
    | character_set_connection | utf8                       |
    | character_set_database   | latin1                     |
    | character_set_filesystem | binary                     |
    | character_set_results    | utf8                       |
    | character_set_server     | latin1                     |
    | character_set_system     | utf8                       |
    | character_sets_dir       | /usr/share/mysql/charsets/ |
    +--------------------------+----------------------------+
    8 rows in set (0.02 sec)*/
    
    mysql> show variables like 'collation%';
    /*+----------------------+-------------------+
    | Variable_name        | Value             |
    +----------------------+-------------------+
    | collation_connection | utf8_general_ci   |
    | collation_database   | latin1_swedish_ci |
    | collation_server     | latin1_swedish_ci |
    +----------------------+-------------------+
    3 rows in set (0.00 sec)
    */
    ```

23. Security

    * Visiting Control

      Not use root. It has the total control of the database

    * Manage User

      ```c
      //User information store in mysql database and user table
      USE mysql;
      select user from user;
      //eg
      mysql> select user from user;
      /*+------------------+
      | user             |
      +------------------+
      | debian-sys-maint |
      | mysql.session    |
      | mysql.sys        |
      | root             |
      +------------------+*/
      
      //Create User
      CREATE USER <user_name> IDENTIFIED BY <password>
      //eg
      mysql> create user alan identified by '12345';
      mysql> select User from user;
      /*+------------------+
      | User             |
      +------------------+
      | alan             |
      | debian-sys-maint |
      | mysql.session    |
      | mysql.sys        |
      | root             |
      +------------------+*/
      
      //Rename User
      RENAME USER <user-name> TO <new_user_name>;
      //eg
      mysql> rename user alan to pan;
      mysql> select user from user;
      /*+------------------+
      | user             |
      +------------------+
      | pan              |
      | debian-sys-maint |
      | mysql.session    |
      | mysql.sys        |
      | root             |
      +------------------+*/
      
      //Delete User
      DROP USER <user_name>;
      mysql> drop user pan;
      mysql> select user from user;
      /*+------------------+
      | user             |
      +------------------+
      | debian-sys-maint |
      | mysql.session    |
      | mysql.sys        |
      | root             |
      +------------------+*/
      
      //Set visiting authority
      SHOW GRANTS FOR <user_name>
      //eg
      mysql> show grants for alan;
      /*+----------------------------------+
      | Grants for alan@%                |
      +----------------------------------+
      | GRANT USAGE ON *.* TO 'alan'@'%' |
      +----------------------------------+
      1 row in set (0.00 sec)*/ //No Grants
      mysql> use test;
      //ERROR 1044 (42000): Access denied for user 'alan'@'%' to database 'test'
      
      //Grant Right
      GRANT <RIGHT> ON <DATABASE> TO <User>;
      mysql> grant select on test.* to alan;
      mysql> show grants for alan;
      +----------------------------------------+
      | Grants for alan@%                      |
      +----------------------------------------+
      | GRANT USAGE ON *.* TO 'alan'@'%'       |
      | GRANT SELECT ON `test`.* TO 'alan'@'%' |
      +----------------------------------------+
      2 rows in set (0.00 sec)
      //Revoke Right
      REVOKE <RIGHT> ON <DATABASE> FROM <USer>;
      mysql> revoke select on test.* from alan;
      //Query OK, 0 rows affected (0.00 sec)
      mysql> show grants for alan;
      /*+----------------------------------+
      | Grants for alan@%                |
      +----------------------------------+
      | GRANT USAGE ON *.* TO 'alan'@'%' |
      +----------------------------------+
      1 row in set (0.00 sec)*/
      mysql> grant insert, select on test.* to alan;
      //Query OK, 0 rows affected (0.00 sec)
      mysql> show grants for alan;
      /*+------------------------------------------------+
      | Grants for alan@%                              |
      +------------------------------------------------+
      | GRANT USAGE ON *.* TO 'alan'@'%'               |
      | GRANT SELECT, INSERT ON `test`.* TO 'alan'@'%' |
      +------------------------------------------------+
      2 rows in set (0.00 sec)*/
      //Right:
      ALL : All right, Alter, Create, Delete, Drop, Insert, Select, Update....;
      
      //Reset Password
      SET PASSWORD FOR <User> = Password(<password>);
      mysql> set password for alan = password('123');
      //Query OK, 0 rows affected, 1 warning (0.00 sec)
      mysql> set password = password('1234');//Change current user's password
      ```

24. Database Maintaining

    * Back-Up of Data

    * Database Maintaining

      ```c
      //Check table key
      ANALYZE TABLE <table_name>;
      mysql> analyze table products;
      /*+---------------+---------+----------+----------+
      | Table         | Op      | Msg_type | Msg_text |
      +---------------+---------+----------+----------+
      | test.products | analyze | status   | OK       |
      +---------------+---------+----------+----------+
      1 row in set (0.02 sec)*/
      CHECK TABLE <table_name>;
      check table orders;
      /*+-------------+-------+----------+----------+
      | Table       | Op    | Msg_type | Msg_text |
      +-------------+-------+----------+----------+
      | test.orders | check | status   | OK       |
      +-------------+-------+----------+----------+
      1 row in set (0.00 sec)*/
      ```

      

    

    