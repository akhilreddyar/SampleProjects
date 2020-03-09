import java.util.*;
class ok {
    public static void disp(char[][] a) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void addnum(char[][] a, int p, int k) {
        char status = ' ';
        if (k == 1)
            status = 'x';
        else if (k == 0)
            status = 'o';
        else
            status = ' ';
        switch (p) {
            case 1:
                a[0][0] = status;
                break;
            case 2:
                a[0][2] = status;
                break;
            case 3:
                a[0][4] = status;
                break;
            case 4:
                a[2][0] = status;
                break;
            case 5:
                a[2][2] = status;
                break;
            case 6:
                a[2][4] = status;
                break;
            case 7:
                a[4][0] = status;
                break;
            case 8:
                a[4][2] = status;
                break;
            case 9:
                a[4][4] = status;
                break;
            default:
                System.out.print("enter a valid number");
                break;
        }

    }
    public static int winner(char[][] a, int player) {
        for (int i = 0; i < 5; i += 2) {
            if (a[i][0] == a[i][2] && a[i][2] == a[i][4] && a[i][0] != ' ')
                return player;
        }
        for (int i = 0; i < 5; i += 2) {
            if (a[0][i] == a[2][i] && a[2][i] == a[4][i] && a[0][i] != ' ')
                return player;
        }

        if (a[0][0] == a[2][2] && a[2][2] == a[4][4] && a[0][0] != ' ')
            return player;
        return 0;
    }
    public static void resetboard(int[] a, char[][] a1) {
        for (int i = 1; i < 10; i++) {
            addnum(a1, i, 2);
        }
        for (int i = 0; i < 9; i++)
            a[i] = 0;
    }

    public static void main(String[] args) {
        int[] Boardstatus = new int[9];
        char[][] tictoc = {
            {' ', '|', ' ', '|', ' '},
            {'-', '-', '-', '-', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '-', '-', '-', '-'},
            {' ', '|', ' ', '|', ' '}
        };
        Scanner scan = new Scanner(System.in);
        int Position = 0, i = 1;
        int Player = 1;
        while (true) {
            if (i == 10|| winner(tictoc, Player) > 0) {
                System.out.println("Game Over/Tied Press 1 to Restart");
                int d = scan.nextInt();
                if (d != 1)
                    break;
                i = 1;
                resetboard(Boardstatus, tictoc);
            }
            if (i % 2 == 0)
                Player = 1;
            else
                Player = 0;
            System.out.println("Player " + (Player + 1) + " Turn");
            Position = scan.nextInt();
            if (Position <= 9) {
                if (Boardstatus[Position - 1] == 0) {
                    addnum(tictoc,Position, Player);
                    Boardstatus[Position - 1] = 1;
                    disp(tictoc);
                    if (winner(tictoc, Player) > 0) {
                        System.out.println("player " + (winner(tictoc, Player) + 1) + " wins");
                    }
                    i += 1;
                } else {
                    System.out.println("Its already taken Retry....");
                }
            } else
                System.out.println("Enter a valid number");
        }
    }
}
