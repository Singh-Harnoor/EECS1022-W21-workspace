package eecs1022.lab8.tictactoe.model;

public class Game {
    private String playerX;
    private String playerO;
    private String whoPlays;
    private String status;
    private char[][] board;
    private String winner;

    ////
    //
    /// Status PDF
    public Game(String playerX, String playerO ){
        this.playerX = playerX;
        this.playerO = playerO;
        this.whoPlays = playerX;
        this.status = this.whoPlays + "'s turn to play...";
        this.board = new char[][]{
                {'_', '_', '_'},
                {'_', '_', '_'},
                {'_', '_', '_'}
        };
        this.winner = "No";
    }

    public String getCurrentPlayer(){
        return this.whoPlays;
    }

    public String getStatus(){
        return this.status;
    }

    public char[][] getBoard(){
        return this.board;
    }

    public void setWhoPlays(char who){
        if (who == 'o'){
            this.whoPlays = playerO;
        }
        else if (who == 'x'){
            this.whoPlays = playerX;
        }
        this.status =  this.whoPlays + "'s turn to play...";
    }

    public void move(int row, int column){
        if (!this.winner.equals("No")){
            if(this.winner.equals("Tie")){
                this.status = "Error: game is already over with a tie.";
            }
            else{
                this.status = "Error: game is already over with a winner.";
            }
        }
        else if (row < 0 || row > 3){
            this.status = "Error: row "+ row +" is invalid.";
        }
        else if (column < 0 || column > 3){
            this.status = "Error: col "+ column +" is invalid.";
        }
        else if (this.board[row-1][column-1] == 'o' || this.board[row-1][column-1] == 'x') {
            this.status = "Error: slot @ ("+row+ ", " +column+ ") is already occupied.";
        }
        else{
            if (this.whoPlays.equals(playerX)){
                this.board[row-1][column-1] = 'x';
            }
            else if (this.whoPlays.equals(this.playerO)){
                this.board[row-1][column-1] = 'o';
            }
            if (this.whoPlays.equals(this.playerX)){
                this.whoPlays = this.playerO;
            }
            else{
                this.whoPlays = this.playerX;
            }
            this.status = this.whoPlays + "'s turn to play...";
            this.evaluateWinner();
            if (!this.winner.equals("No")){
                this.whoPlays = null;
                if (!this.winner.equals("Tie")){
                    this.status = "Game is over with " + this.winner+ " being the winner.";
                }
                else{
                    this.status = "Game is over with a tie between " +this.playerX+ " and "+this.playerO+".";
                }

            }
        }

    }

    // Helper Method
    public void evaluateWinner(){
        boolean xRow = false;
        boolean oRow = false;
        for (int i = 0; i < 3; i++){
            boolean xEachRow = true;
            for (int j = 0; j < 3 && xEachRow; j++){
                if (this.board[i][j] != 'x'){
                    xEachRow = false;
                }
            }
            xRow = xEachRow || xRow;

        }

        for (int i = 0; i < 3; i++) {
            boolean oEachRow = true;
            for (int j = 0; j < 3 && oEachRow; j++) {
                if (this.board[i][j] != 'o') {
                    oEachRow = false;
                }
            }
            oRow = oEachRow || oRow;
        }


        boolean xCol = false;
        boolean oCol = false;

        for (int i = 0; i < 3; i++){
            boolean xEachCol = true;
            for (int j = 0; j < 3 && xEachCol; j++){
                if(this.board[j][i] != 'x'){
                    xEachCol = false;
                }

            }

            xCol = xEachCol || xCol;

        }

        for (int i = 0; i < 3; i++){
            boolean oEachCol = true;
            for (int j = 0; j < 3 && oEachCol; j++) {
                if (this.board[j][i] != 'o') {
                    oEachCol = false;
                }
            }
            oCol = oEachCol || oCol;

        }




        boolean xFirstDia = true;
        boolean oFirstDia = true;

        for(int i = 0; i < 3 && xFirstDia; i++){
            for (int j = 0; j < 3 && xFirstDia ; j++){
                if (i==j){
                    if (this.board[i][j] != 'x'){
                        xFirstDia = false;
                    }
                }
            }
        }

        for(int i = 0; i < 3 && oFirstDia; i++){
            for (int j = 0; j < 3 && oFirstDia ; j++){
                if (i==j){
                    if (this.board[i][j] != 'o'){
                        oFirstDia = false;
                    }

                }
            }
        }

        boolean xSecDia = true;
        boolean oSecDia = true;
        for(int i = 0; i < 3 && xSecDia; i++){
            for (int j = 0; j < 3 && xSecDia ; j++){
                if ((i == 0 && j == 2) || (i == 1 && j == 1) || (i == 2 && j == 0)){
                    if (this.board[i][j] != 'x'){
                        xSecDia = false;
                    }
                }
            }
        }

        for(int i = 0; i < 3 && oSecDia; i++){
            for (int j = 0; j < 3 && oSecDia ; j++){
                if ((i == 0 && j == 2) || (i == 1 && j == 1) || (i == 2 && j == 0)){
                    if (this.board[i][j] != 'x'){
                        oSecDia = false;
                    }
                }
            }
        }

        boolean xWin = xCol || xRow || xFirstDia || xSecDia;
        boolean oWin = oCol || oRow || oFirstDia || oSecDia;

        boolean vacancy = false;
        for (int i = 0; i < 3 && (!vacancy); i++){
            for (int j = 0; j < 3 && (!vacancy); j++){
                if (this.board[i][j] == '_') {
                    vacancy = true;
                }
            }
        }

        boolean tie = (!vacancy) && (!xWin) && (!oWin);

        if (tie){
            this.winner = "Tie";
        }
        else if(!xWin && !oWin){
            this.winner = "No";
        }
        else {
            if(xWin){
                this.winner = this.playerX;
            }
            else if (oWin){
                this.winner = this.playerO;
            }
        }
    }

}
