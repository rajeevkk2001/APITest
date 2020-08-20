package Tests;
import CoreFucntions.CapitalSearch;

import java.util.Scanner;

public class CountryAPITest  {


    public static void main(String[] args) throws Exception {
        int selection=0;
        while (true) {
            System.out.println("*********** COUNTRY API Test *********");
            System.out.println("Please select a choice \n 1: for search Capital by Country Code \n 2: for Search Capital by Country Name\n 0: to exit the test\n");
           try {
               Scanner scanner = new Scanner(System.in);
               System.out.print(">>>");
               selection = Integer.valueOf(scanner.next());
               if (selection == 0) {
                   System.out.println(" Thank you...Country API Test is completed");
                   break;
               }
           }catch (NumberFormatException e ){
               System.out.println(" Invalid selection");
           }
            switch (selection) {
                case 1:
                    System.out.println("Your choice is 1");
                    CapitalSearch.getCapital_CountryCode();
                    break;
                case 2:
                    System.out.println("Your choice is 2");
                    CapitalSearch.getCapital_CountryName();
                    break;
                default:
                    System.out.println("Selection is invalid. Please enter 0 ,1 or 2");
                    break;
            }

        }

    }


}