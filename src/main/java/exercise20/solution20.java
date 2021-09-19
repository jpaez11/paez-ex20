/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Jorge Paez
 *
 * Pseudocode:
 * A program that will ask for an order amount, state that user lives in (If Wisconsin,
 * then it prompts a question for what county, if Dunn or Eau Claire additional tax. If
 * Illinois only 8% sales tax).
 *
 */

package exercise20;
import java.util.*;
//Wisconsin residents must be changed 5% sales tax with an additional county-level charge. For Wisconsin residents, prompt for the county of residence.
//For Eau Claire county residents, add an additional 0.005 tax.
//For Dunn county residents, add an additional 0.004 tax.
//Illinois residents must be charged 8% sales tax with no additional county-level charge.
//All other states are not charged tax.
public class solution20 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); //user input
        int amnt;
        double totalAmount = 0, taxes = 0;

        //prompting user input
        System.out.print("What's order amount? \n");
        amnt = s.nextInt();
        System.out.print("What state do you live in? \n");
        String state = s.next();

        //if, else, else if conditions for tax cases
        if(state.equals("Wisconsin")){ //if state is wisconsin
            System.out.print("What county do you live in? \n");  //shows county
            String county = s.next();

            if(county.equals("Eau Claire")){ //1st county case
                taxes = (amnt*5.005)/100;
                totalAmount = taxes + amnt;
            }
            else if(county.equals("Dunn")){ //2nd county case
                taxes = (amnt*5.004)/100;
                totalAmount = taxes + amnt;
            }
            else{ //if eau claire or dunn aren't entered
                System.out.println("Please enter a valid county.");
            }
        }
        else if(state.equals("Illinois")){ //2nd state case
            taxes = (amnt*8)/100;
            totalAmount = taxes + amnt;
        }
        else{ //any other state
            taxes = 0.0;
            totalAmount = amnt;
        }
        //outputs
        System.out.println("The taxes are  $"+String.format("%.2f",taxes));
        System.out.println("The total amount is  $"+String.format("%.2f",totalAmount));
    }
}