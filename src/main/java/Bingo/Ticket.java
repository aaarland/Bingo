package main.java.Bingo;
import java.security.spec.ECField;
import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;


public class Ticket {
    /**
     * row and col of the ticket is 5 in Bingo
     */
    private int col = 5, row = 5;
    private int ticketNumber;
    private int[][] ticketNumberValues;
    private Set<Integer> usedNumbers;
    private long seed;
    private Random rand;
    public Ticket(long seed) throws Exception{
        this.seed = seed + 10000;
        rand = new Random(this.seed);
        ticketNumber = rand.nextInt(500);
        System.out.println(ticketNumber);
        usedNumbers = new HashSet<>(row * col);
        ticketNumberValues = new int[col][row];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(i == row/2 && j == col/2){
                    ticketNumberValues[i][j] = 0;
                }else{
                    ticketNumberValues[i][j] = getNumber(j);
                }
            }
        }
    }

    public boolean result(){
        return Results.isWinner(this);
    }

    public int getCols(){
        return col;
    }
    public int getRows(){
        return row;
    }

    public boolean markNumber(int num){
        if(!usedNumbers.contains(num)) return false;
        for(int i = 0; i < this.row; i++){
            for(int j = 0; j < this.col; j++){
                if(ticketNumberValues[i][j] == num) ticketNumberValues[i][j] = 0;
            }
        }
        return true;
    }

    public int getNumber(int row, int col){
        return ticketNumberValues[row][col];
    }
    private int getNumber(int col) throws Exception {
        Letters letter = Letters.values()[col];

        int number = 0;
        switch (letter){
            case B:
                number = addNumber(1);
                break;
            case I:
                number = addNumber(16);
                break;
            case N:
                number = addNumber(31);
                break;
            case G:
                number = addNumber(46);
                break;
            case O:
                number = addNumber(61);
                break;
            default:
                throw new Exception("No letter selected");
        }
        return number;
    }

    private int addNumber(int value){
        int number;
        do {
            number = rand.nextInt(14) + value;
        }while (usedNumbers.contains(number));
        usedNumbers.add(number);

        return number;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(ticketNumberValues[i][j] == 0){
                    sb.append("X");
                }else {
                    sb.append(ticketNumberValues[i][j]);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return ticketNumber == ticket.ticketNumber && seed == ticket.seed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketNumber, seed);
    }
}
