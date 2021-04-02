package eecs1022.lab7.bank.model;

public class Transaction {

    private String type;
    private double amount;
    private String status;

    public Transaction(String type, double amount){
        this.type = type;
        this.amount = amount;
        if (this.amount < 0){
            this.status = "Error: Non-Positive Amount";
        }
        else{
            this.status = "Transaction "+ type +": $" + String.format("%.2f", this.amount);
        }
    }

    public String getStatus(){
        return this.status;
    }


}
