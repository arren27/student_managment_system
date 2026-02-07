import java.util.Scanner;
public class INCAL{
    public static void main(String []args){

        Scanner sc= new Scanner(System.in);
        while(true){

        
        System.out.println("enter number a=" );
        int a = sc.nextInt();
        System.out.println("enter number b=" );
        int b = sc.nextInt();
        System.out.println("enter char");
        char choice=sc.next().charAt(0);
		switch(choice){
			case '+':
				System.out.println("the sum is:"+(a+b));
                break;
            case '-':
                System.out.println("the sub is:"+(a-b));
                break;
               case '*':

                System.out.println("the multi is:"+(a*b));
                break;
                case '/':
                    System.out.println("THE DIV IS:"+(a/b));
                    break;
                    default: 
                    System.out.println("chooose a valid operation");


        
        } 

          
        }    
    }
}
