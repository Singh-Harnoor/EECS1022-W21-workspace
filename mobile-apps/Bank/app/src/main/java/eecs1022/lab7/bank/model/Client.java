package eecs1022.lab7.bank.model;

public class Client {
    private String name;
    private double amount;
    private String status;
    private String[] statement;

    public Client(String name, double amount){
        this.name = name;
        this.amount = amount;
        this.statement = new String[1];
        if(this.amount < 0){
            this.status = "Error: Non-Positive Initial Balance";
        }
        else{
            this.status = this.name + ": $" + String.format("%,.2f",this.amount);
            this.statement[0] = this.status;
        }
    }

    public String getStatus(){
        this.status = this.name + ": $" + String.format("%,.2f",this.amount);
        return this.status;
    }

    public String[] getStatement(){
        return this.statement;
    }

    public String getName(){
        return this.name;
    }

    public double getAmount(){
        return this.amount;
    }


    public void deposit(double amount){
        this.amount += amount;
        this.status = this.name + ": $" + String.format("%,.2f", this.amount);
        String[] temp = new String[this.statement.length + 1];
        temp[0] = this.status;
        for (int i = 1; i < this.statement.length; i++){
            temp[i] = this.statement[i];
        }
        temp[this.statement.length] = "Transaction DEPOSIT: $" + String.format("%,.2f", amount);
        this.statement = temp;

    }

    public void withdraw(double amount){
        this.amount = this.amount - amount;
        this.status = this.name + ": $" + String.format("%,.2f", this.amount);
        String[] temp = new String[this.statement.length + 1];
        temp[0] = this.status;
        for (int i = 1; i < this.statement.length; i++){
            temp[i] = this.statement[i];
        }
        temp[this.statement.length] = "Transaction WITHDRAW: $" + String.format("%,.2f", amount);
        this.statement = temp;
    }

}
