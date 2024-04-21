/**
 * This is a Console Base App (I/O File Handel & Date Time API)
 * @author Arghyadip Karmakar (E-MAIL-> codewitharghya0@gmail.com)
 * Creation Date-> 21/04/2024
 * No Copyrighted....
 * Features-> File Create, File Metadata, Write & Read File, Delete a File
 * Condition, Switch Case, Do-While loop e.t.c used
 * JUST FOR FUN........ SELF LEARNING.........USABLE FOR FUTURE ADVANCE JAVA PROJECTS...
 * YOUR SUGGESSTION WILL BE VALUABLE FOR ME....
 **/

import java.util.Scanner;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
public class FileApp {
    /**
     * dateTimeShow() -> This is a static method which is called in main method to show current date and time
     * it used java Time API and show date+time in a special custom format
     */
    public static void dateTimeShow(){
        LocalDateTime dt = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatted = dt.format(format);
        System.out.println("Current Date & Time -> " + formatted);
    }
    /**
     * main method is calling static method and performing all other operations
     * switch case is using here to perform different operations as per user input
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("                        <<<< WELCOME TO FILE MANAGEMENT CONSOLE APP >>>>                       ");
         dateTimeShow();
        String choice;
        do{
            System.out.println("Enter your Choice : -> " +
                    " A) Create a new File, B) Write in a file , C) Read a File, D) Metadata of FIle,  E)Delete a file, F)Exit ");
            String select = sc.nextLine();
            switch (select){
                case "A":
                    System.out.println("You have opted for new File Creation....");
                    System.out.println("Enter a file Name that you want to create, example- demo.txt");
                    String fileName = sc.nextLine();
                    try{
                        File myObj = new File(fileName);
                        myObj.createNewFile();
                        System.out.println("File is created Successfully ..." + myObj.getName());

                    }catch(IOException ex){
                        System.out.println("Something went Wrong........, File can't be created try again..." + ex);
                        ex.printStackTrace();
                    }
                    break;
                case "B":
                    System.out.println("You have opted for Write some text/String in a file which is already created . ");
                    System.out.println("Enter the filename where you want to write some text : ");
                    String fileName1 = sc.next();
                    sc.nextLine();
                    System.out.println("Enter value / text that you want to insert in the file");
                    String text = sc.nextLine();
                    try{
                        FileWriter myObj1 = new FileWriter(fileName1);
                        myObj1.write(text);
                        myObj1.close();
                        System.out.println("Data Inserted Successfully...");
                    }catch(IOException ex){
                        System.out.println("Something went wrong..... " + ex);
                        ex.printStackTrace();
                    }
                    break;
                case "C":
                    System.out.println("You have opted for read a file : ");
                    System.out.println("Enter the filename what you want to read : ");
                    String fileName2 = sc.nextLine();
                   try{
                       File myObj3 = new File(fileName2);
                       Scanner myReader = new Scanner(myObj3);
                       while(myReader.hasNextLine()){
                           String data = myReader.nextLine();

                           System.out.println("Data -> " + data);
                       }
                   }catch(FileNotFoundException ex){
                       System.out.println("File not found . " + ex);
                       ex.printStackTrace();
                   }

                    break;

                case "D":
                    System.out.println("You have opted for get Metadata details of a file");
                    System.out.println("Enter filename to get it's metadata information : ");
                    String meta = sc.nextLine();
                    File myObj3 = new File(meta);
                    if(myObj3.exists()){
                        System.out.println("Metadata : -");
                        System.out.println("FileName -> " + myObj3.getName());
                        System.out.println("File Size -> " + myObj3.length());
                        System.out.println("Absolute Path -> " + myObj3.getAbsolutePath());
                        System.out.println("Readable -> " + myObj3.canRead());
                        System.out.println("Writable -> " + myObj3.canWrite());

                    }else{
                        System.out.println("File not found / Metadata Does Not exists...");
                    }
                    break;

                case "E":
                    System.out.println("You have Opted for Delete a file");
                    System.out.println("Enter file name which you want to delete ");
                    String delFIle = sc.nextLine();
                    File newName = new File(delFIle);
                    if(newName.delete()){
                        System.out.println(newName.getName() + " deleted Successfully....");
                    }else{
                        System.out.println("Something went wrong...");
                    }


                    break;

                case "F":
                    System.out.println("PLEASE PROVIDE FEEDBACK...");
                    System.out.println("Enter any number between 0 - 5 to rate this console app.....");
                    int rate = sc.nextInt();
                    if(rate==0 ){
                        System.out.println("I WILL TRY TO IMPROVE THIS APP, THANKS FOR YOUR RATE....");
                    } else if (rate>=1 && rate<=3) {
                        System.out.println("I AM HAPPY, YOU LIKE THIS CONSOLE APP, THANKS FOR YOUR RATE....");
                    } else if (rate>=4 && rate==5) {
                        System.out.println("THANKS FOR YOUR RATING.... I AM VERY HAPPY TO KNOW THAT YOU LIKE THIS APP");
                    }else{
                        System.out.println("INVALID || Please Enter any number between 0-5 for rating.......");
                    }
                    System.out.println("THANKS || BYE || ");

                    System.exit(0); //System.exit() method used for exit from JVM with status code, 0 in this case
                    break;
            }
            System.out.println("Are you sure to exit from this app ? Y/N");
            choice = sc.nextLine();
        }while(!choice.equalsIgnoreCase("Y"));


    }
}
