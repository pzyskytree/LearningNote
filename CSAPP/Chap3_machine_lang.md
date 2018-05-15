## Machine-Level Representation of Programs

**_Historical Perspective_**
   * 8086 (1978, 29K transistors) 16-bit  
   * 8088 24-bit  
   * i386 (1985, 275K transistors) 32-bit, IA32  
   * Pentium 4E (2004, 125M transistors) 64-bit, x86-64 
___
***Program Encoding***      
  gcc : GCC compiler or cc in Linux:
  
```
gcc -O1 -o hello hello.c // O1 level one optimization 
// The higher optimization level leads to faster  the program, 
//but also hard to understand the generated machine code
```
   1. C preprocessor expands source code with include file
   2. Compliler generate assembly-code version of source file hello.s
   3. Assembler converts assembly code into binary object-code hello.o
   4. Linker merge the hello.o and generate executable file hello  
  **ISA**: (instruction Set Architecture): processor state, the format of instruction effect of   instruction on state.  
   **Virtual Address** large byte array.  
   Visible processor state for IA32 Machine code:
       * PC (programmer  counter) %eip 
       * Interger register file: 8 32-bit (date or address)
       * Condition code register: status information: if or while implementation
       * Floating Point register  
	```
	   gcc -O1 -S hello.c// Compile hello.c to hello.s assembly code  
	   gcc -O1 -c hello.c // Compile and assemble to code to hello.o binary object file
	```  
        Disassembler : Convert binary object file hello.o to assembly code  
	 ```
	    objdump -d hello.o
	 ```  
	 IA32 instruction length from 1 to 15 bytes. 
	 Unique starting point for each instruction.  
	 ```
	    gcc -O1 -o main hello.o main.c // Link hello.o with main.c
	 ```  
	 After link, inside the excutable file the address shifted to another range 
	 
___

***Data Format***  
word: 16-bit, double-word: 32-bit, quad word: 64-bit  
byte:b,  word: w, double-word: l  
IA32 not support 64 bit in hardware  
Floating point: float(4-bit): s, double(8-bit): l, long double(10/12-bit): t  
___

***Access information***  
Eight Register:  32-bit  
General Register    
```
    1. %eax(32-bit),  %ax(low 16-bit),  %ah(high 8-bit), %al(low 8-bit) 
    2. %ecx(32-bit),  %cx(low 16-bit),  %ch(high 8-bit), %cl(low 8-bit)
    3. %edx(32-bit),  %dx(low 16-bit),  %dh(high 8-bit), %dl(low 8-bit)
    4. %ebx(32-bit),  %bx(low 16-bit),  %bh(high 8-bit), %bl(low 8-bit)
    5. %esi(32-bit),  %si(low 16-bit)
    6. %edi(32-bit),  %di(low 16-bit)  
```
 Special Register  
 ```c
    1. %esp(32-bit),  %sp(low 16-bit) //Stack Pointer
    2. %ebp(32-bit),  %bp(low 16-bit) //Frame Pointer
```
  1. Oprand Specifier  
     1. Immediate: constant value  
	```c
	   $-123, $0x1F// Format
	   -123, 0x1F//Value
	```
     2. Register: content of one of the register  
	```c
	%eax//Register Format
	R[%eax] // Value inside the register, Value 
	//Viewing set of register as an array R indexed by identifier
	```
     3. Memory: Effective Address  
     
        ```c
	    //Absolute
	    Imm//Format 
	    M[Imm]//Value
	    //Indirect
	    (Ea)//Format
	    M[R[Ea]]//Value
	    //Base + displacement
	    Imm(Ea)//Format
	    M[Imm+R[Ea]]//Value
	  ```
  2.  Data Movement Instruction
     1. mov  // Copy from source to destination
	 Source Immediate number stored in Mmeory or Register. Destination: Location, Register or Memory Address
	 Cannot be two Memory Addresses at the same time.  
	   ```c
	   movb S, D // Move byte S to D
	   movw S, D// Move word S to D
	   movl S, D // Move double word S to D
	   ```
     2. movs // Move with sign extension  
	   ```c
	   movsbw  S, D// Move byte S to word D
	   movsbl S, D//Move byte S to double word D
	   movswl S, D// Move word S to double word D
	   ```
     3. movz// Move with zero extension  
	  ```c
	   movzbw  S, D// Move byte S to word D
	   movzbl S, D//Move byte S to double word D
	   movzwl S, D// Move word S to double word D
	   ```
     4. pushl S // Stack grows downward such that the top element has the lowest memory  address  
	   ```c
	   R[%esp] <- R[%esp] - 4
	   M[R[%esp]] <- S
	   pushl %ebp == subl $4, %esp; movl %ebp, (%esp)
	   ```
     5. popl D  
	   ```c
	   D <- M[R[%esp]]
	   R[%esp] <- R[%esp] + 4
	   pop %eax == movl (%esp), %eax; addl $4, %esp
	   ```  
      Pointer in C is simply address in assmebly code. Deference pointer is using register indirect reference. 
   Local variable store in register not in memory since regiester is faster.
  



