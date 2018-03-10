/* 
 * To change this template, choose Tools | Templates 
 * and open the template in the editor. 
 */ 
//package tower.of.hanoi; 
import java.io.*; 
import java.util.Stack; 
import java.util.EmptyStackException; 
/** 
 * 
 * @author Shaik 
 */ 
public class NON { 

     
    public static int legalMove(Stack A, Stack B) 
    { 
        int a,b; 
        try { 
        a = Integer.parseInt(A.peek().toString()); 
        } 
        catch(EmptyStackException e){ 
        a = 0;     
        } 
        try { 
            b = Integer.parseInt(B.peek().toString()); 
        } 
        catch(EmptyStackException e){ 
        b = 0;     
        } 
        if(a==b) return 0; 
        if(a == 0)             // If peg A is empty, then pop from B and push the disk onto A 
    { 
        A.push(B.pop()); 
            return 2;           // Return 2 as move occurred from B to A 
    } 
        else if(b == 0)        // If peg B is empty, then pop from A and push the disk onto B 
        { 
        B.push(A.pop()); 
        return 1;           // Return 1 since move occurred from A to B 
    } 
         
        if(a<b) 
        { 
        B.push(A.pop()); 
        return 1;               // Return 1 since move occurred from A to B 
        } 
        else if(a > b)            // value of top disk of peg A is greater than the value of topmost disk of peg B 
        { 
        A.push(B.pop()); 
        return 2;               // Return 2 since move occurred from B to A 
        } 
        return -1; 
    } 
         
    /** 
     * @param args the command line arguments 
     */ 
    public static void main(String[] args) { 
        // TODO code application logic here 
        int stepNumber = 0; 
        int status = 0; 
        try { 
        Stack Source = new Stack(); 
        Stack Auxilary = new Stack(); 
        Stack Destination = new Stack(); 
         
        System.out.println("Enter the number of disks : "); 
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); 
        int n = Integer.parseInt(input.readLine()); 
        if(n<=0) 
        { 
            System.out.println("Sorry wrong input, negative numbers not allowed."); 
            System.exit(1); 
        } 
        for(int i=n; i>0; i--) 
            Source.push(i); 
        int m = n%2; 
        do { 
            if(m==1) 
            { 
                if((status = legalMove(Source,Destination)) == 1) 
                    System.out.println((++stepNumber) + ". Source --> Destination"); 
                else if (status == 2) 
                    System.out.println((++stepNumber) + ". Destination --> Source"); 
                 
                if((status = legalMove(Source,Auxilary)) == 1) 
                    System.out.println((++stepNumber) + ". Source --> Auxilary"); 
                else if(status == 2) 
                    System.out.println((++stepNumber) + ". Auxilary --> Source"); 
                else  
                    break; 
            } 
             
            else 
            { 
                if((status = legalMove(Source,Auxilary)) == 1)   
                    System.out.println((++stepNumber) + ". Source --> Auxilary"); 
                else if (status == 2) 
                    System.out.println((++stepNumber) + ". Auxilary --> Source"); 
                 
                if((status = legalMove(Source,Destination)) == 1) 
                    System.out.println((++stepNumber) + ". Source --> Destination"); 
                else if(status == 2) 
                    System.out.println((++stepNumber) + ". Destination --> Source"); 
                 
            } 
             
            if((status = legalMove(Auxilary,Destination)) == 1)  
                System.out.println((++stepNumber) + ". Auxilary --> Destination"); 
            else if(status == 2) 
                System.out.println((++stepNumber) + ". Destination --> Auxilary"); 
        }while(Destination.size()!=n); 
        System.out.println("X-----------------------X"); 
        }          

        catch (Exception e){ 
        } 
        } 
    }