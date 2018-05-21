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
          Rtrim()//Remove the space at right;
          Ltrim()//Remove the space at left;
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

11. Joint Table

   1. Relation Table

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

12.  Combined Query

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
     //Order by must be in the last select and the entire query can only have one order by.


      ```

  
