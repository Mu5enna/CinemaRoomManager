import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scnObj = new Scanner(System.in);
        int income=0;
        int curInc = 0, soldTic=0;
        System.out.println("Enter the number of rows: ");
        int row = scnObj.nextInt();
        System.out.println("Enter the number of columns: ");
        int col = scnObj.nextInt();
        char[][] seatList = new char[row][col];
        for (char[] tempRow:seatList){
            Arrays.fill(tempRow,'S');
        }
        if (row * col > 60) {
            int tempRow=row/2;
            income+=(tempRow)*col*10;
            income+=(row-tempRow)*col*8;
        }
        else{
            income+=col * row * 10;
        }
        boolean check=true;
        while(check){
            System.out.println("\nChoose the operation you want to perform..."+
                    "\n1 - Buy Ticket"+
                    "\n2 - Show Seats"+
                    "\n3 - Statics"+
                    "\n4 - Exit\n");
            int op=scnObj.nextInt();
            switch (op){
                case 1:
                    System.out.println("\nEnter the row and column of the seat in given order to buy.");
                    int seatRow = scnObj.nextInt();
                    int seatCol = scnObj.nextInt();
                    if(seatRow>row||seatCol>col||seatRow<1||seatCol<1){
                        System.out.println("There is no such seat. Please choose a valid one.");
                    }
                    else {
                        int price;
                        if (row*col>60){
                            if (seatRow<=row/2){
                                price=10;
                            }
                            else{
                                price=8;
                            }
                        }
                        else{
                            price=10;
                        }
                        if(seatList[seatRow-1][seatCol-1]=='B'){
                            System.out.println("Chosen seat is already taken!");
                        }
                        else{
                            seatList[seatRow-1][seatCol-1]='B';
                            System.out.print("\nYour payment is $"+price);
                            curInc += price;
                            soldTic++;
                        }
                    }
                    break;
                case 2:
                    System.out.println("\nCinema:");
                    System.out.print(" ");
                    for (int i=1; i<=col;i++){
                        System.out.print(" "+i);
                    }
                    for (int i=1;i<=row;i++){
                        System.out.print("\n"+i+" ");
                        for (int j=0;j<col;j++){
                            System.out.print(seatList[i-1][j]+" ");
                        }
                    }
                    break;
                case 3:
                    System.out.println(soldTic+" tickets sold in total.\n"+
                            (float) (100*soldTic)/(row*col)+"% of tickets sold\n"+
                            "Current income is $"+curInc+
                            "\nPossible income is $"+income);
                    break;
                case 4:
                    System.out.println("Closing system...");
                    check=false;
                    break;
                default:
                    System.out.println("Invalid input, please choose a valid option...");
                    break;
            }
        }
    }
}