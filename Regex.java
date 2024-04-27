//Java regex tools for password matching
//importing required pacckage and class from java.util package
import java.util.regex.*;
import java.util.Scanner;
public class Main{
    public static void regexMatcher(String reg, String pass){
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(pass);
        boolean result = matcher.matches();
        if(result){
            System.out.println("Regex Result Matched.....");
        }else{
            System.out.println("Regex rule did not matched.... Try Again with the proper rule...");
        }

    }

        public static void main(String[] args){
            String select;
            do{
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter the Regex rules: ");
                String reg = sc.nextLine();
                System.out.println("Enter the password which you want to check : ");
                String pass = sc.nextLine();
                regexMatcher(reg,pass);
                System.out.println("Would you want to continue ?  Type Y/N");
                select = sc.nextLine();
            }while(select.equalsIgnoreCase("Y"));

    }
}
