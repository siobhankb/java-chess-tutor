/* 
* Name:        Siobhan Boylan
*
* Course:      CS-12, Fall 2022
*
* Date:        11/14/22
* 
* Filename:    chessTutorSB.java
* 
* Purpose:     client class that calculates daily and compounded earnings of the king's wiley chess tutor
*              --> I know I did not meet all the criteria. It's been a rough week.
*              --> I will read your feedback and make revisions before the next assignment.
*/


// new class: chessTutorSB
public class chessTutorSB {

    // main method:
    public static void main (String [] args) {
    
        int day;
        int total;
        
        char option;
        String menu = "\n------------------------------\n" +
                      "Chess Tutoring Income Options:\n" + 
                      "------------------------------\n" +
                      "Daily Earnings on Day n          [D]\n" +
                      "Total Earnings through Day n     [T]\n" +
                      "History of Earnings up to Day n  [H]\n" +
                      "Quit                             [Q]\n" +
                      "Enter Option > ";
                      
        // priming read
        option = utilsSB.readChar(menu, false);
        
        // loop until terminating char(s) NOT encouontered
        while ((option != 'Q') && (option != 'q')) {
        
            switch (option) {
                case 'D':
                case 'd':
                    showDailyEarnings();
                    break;
                    
                case 'T':
                case 't':
                    showTotalEarnings();
                    break;
                
                case 'H':
                case 'h':
                    showHistoryEarnings();
                    break;
                
                // no Q/q case needed, switch will not reach it!
                
                default:
                    System.out.println("Unrecognized option " + option + ", please try again\n");
                    break;
                    
            }
            
            // update read
            option = utilsSB.readChar(menu, false);
            
        }
        
        // quit confirmation message
        System.out.println("\nThanks for using Chess Tutor. Goodbye!");
        
        }
        
    
    
    // ----> methods <----
    
    
    
    // display daily earnings on day 'n'
    private static void showDailyEarnings() {
        int day;
        double dailyEarnings;
        
        day = getValidDay();
        dailyEarnings = Math.pow(2, day-1) / 100.0;
        System.out.printf("\n==> Daily earnings on Day %d will be: $%,.2f\n\n", day, dailyEarnings);
    }
    
    // display total earnings through day 'n'
    private static void showTotalEarnings() {
        int day;
        double dailyEarnings;
        double totalEarnings = 0;
        
        day = getValidDay();
        
        // for loop
        for (int i=1; i<=day; i++) {
            dailyEarnings = Math.pow(2, i-1) / 100.0;
            totalEarnings += dailyEarnings;
        }
        // end for-loop
        
        // display total earnings up to specified day
        System.out.printf("\n==> Total earnings through Day %d will be: $%,.2f\n\n", day, totalEarnings);

        
    }
    
    // display daily history of earnings and total earnings through day 'n'
    private static void showHistoryEarnings() {
    
        int day;
        double dailyEarnings;
        double totalEarnings = 0;
        // 1,000,000
        final double MILLION = 1000000f;
        // 1,000,000,000
        final double BILLION = 1000000000f;
        String msg = "";
        //
        day = getValidDay();
        System.out.printf("\n==> Daily earnings history through Day %d\n\n", day);
        System.out.printf("\n%3s%35s%35s\n", "Day", "Daily Earnings [$]", "Total Earnings [$]");
        
        // for loop
        for (int i=1; i<=day; i++) {
            //System.out.print(i);
            dailyEarnings = Math.pow(2, i-1) / 100.0;
            totalEarnings += dailyEarnings;
            if (totalEarnings >= MILLION && totalEarnings <= MILLION + dailyEarnings) {
                msg = String.format(" <== Day %d I'm a MILLIONAIRE!", i);
            }
            else if (totalEarnings >= BILLION && totalEarnings <= BILLION + dailyEarnings){
                msg = String.format(" <==== Day %d I'm a BILLIONAIRE!", i);
            }
            else {
                msg = "";
            }
            
            System.out.printf("%2d%,35.2f%,35.2f%s\n", i, dailyEarnings, totalEarnings, msg);
            // System.out.print("totalEarnings on day " + i + " = " + totalEarnings + "\n");
        }
        // end for-loop
        
        //System.out.printf("==> Daily earnings from Day 1 to Day %d: $%,.2f\n\n", day, historyEarnings);

    }
    
    // prompts for valid day number in range 1-64
    private static int getValidDay() {
        final int firstDay = 1;
        final int lastDay = 64;
        int day;
        
        day = utilsSB.readInt("\nEnter chess teaching day " + firstDay + "-" + lastDay + ": ", false);
        while (day <= firstDay || day > lastDay) {
            System.out.println("\n\nERROR: day must be " + firstDay + "-" + lastDay + ", please re-enter");
            day = utilsSB.readInt("Enter chess teaching day 1-64: ", false);
        }
        return day;
    }
    
        
}