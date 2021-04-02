package eecs1022.lab7.bank.model;

public class Bank {

    private String status;
    private Client[] clients;

    public Bank(){
        // Default constructor
        this.status = "Accounts: {}";
        clients = new Client[0];
        this.clients = new Client[0];
    }

    public String getStatus(){
        return this.status;
    }

    public String[] getStatement(String name){
        String st [] = new String[0];
        boolean present = false;
        for (int i = 0; i < this.clients.length; i++){
            if(clients[i].getName().equals(name)){
                st = this.clients[i].getStatement();
                present = true;
            }
        }
        if (present){
            return st;
        }
        else {
            this.status = "Error: From-Account "+name+" does not exist";
            return null;
        }

    }


    public void deposit(String name ,double amount){
        boolean present = false;
        for (int i = 0; i < this.clients.length; i++){
            if(this.clients[i].getName().equals(name)){
                if (amount > 0){
                    this.clients[i].deposit(amount);
                }
                present = true;
            }
        }
        if(!present){
            this.status = "Error: To-Account "+ name +" does not exist";
        }
        else if(amount <= 0){
            this.status = "Error: Non-Positive Amount";
        }
        else {
            this.status = "Accounts: {";
            for (int i = 0; i < this.clients.length; i++){
                this.status += clients[i].getStatus();
                if (i < this.clients.length - 1){
                    this.status += ", ";
                }
            }
            this.status += "}";
        }

    }

    public void withdraw(String name ,double amount){
        boolean present = false;
        boolean tooLarge = false;
        for (int i = 0; i < this.clients.length; i++){
            if(this.clients[i].getName().equals(name)){
                if (amount > 0){
                    if (amount > this.clients[i].getAmount()){
                        tooLarge = true;
                    }
                    else{
                        this.clients[i].withdraw(amount);
                    }

                }
                present = true;
            }
        }
        if(!present){
            this.status = "Error: From-Account "+ name +" does not exist";
        }
        else if(amount <= 0){
            this.status = "Error: Non-Positive Amount";
        }
        else if (tooLarge){
            this.status = "Error: Amount too large to withdraw";
        }
        else {
            this.status = "Accounts: {";
            for (int i = 0; i < this.clients.length; i++){
                this.status += clients[i].getStatus();
                if (i < this.clients.length - 1){
                    this.status += ", ";
                }
            }
            this.status += "}";
        }

    }


    public void transfer(String from, String to, double amount){
        boolean fromPresent = false;
        boolean toPresent = false;
        boolean tooLarge = false;
        for (int i = 0; i < this.clients.length; i++){
            if(this.clients[i].getName().equals(from)){
                if (amount < this.clients[i].getAmount() && amount > 0){
                    this.clients[i].withdraw(amount);
                }
                else if (amount >= this.clients[i].getAmount()) {
                    tooLarge = true;
                }

                fromPresent = true;
            }

        }
        for (int i = 0; i < this.clients.length; i++){
            if(this.clients[i].getName().equals(to)){
                if (amount > 0 && !tooLarge){
                    this.clients[i].deposit(amount);
                }

                toPresent = true;
            }

        }
        if (!fromPresent){
            this.status = "Error: From-Account "+from+" does not exist";
        }
        else if(!toPresent){
            this.status = "Error: To-Account "+to+" does not exist";
        }
        else if (amount <= 0){
            this.status = "Error: Non-Positive Amount";
        }
        else if (tooLarge){
            this.status = "Error: Amount too large to transfer";
        }
        else {
            this.status = this.status = "Accounts: {";
            for (int i = 0; i < this.clients.length; i++){
                this.status += clients[i].getStatus();
                if (i < this.clients.length - 1){
                    this.status += ", ";
                }
            }
            this.status += "}";
        }
    }

    public void addClient(String name, double amount){
        boolean exist = false;
        Client[] temp = new Client[this.clients.length+1];
        for (int i = 0; i < this.clients.length; i++){
            temp[i] = this.clients[i];
            if (this.clients.length >= 1 && this.clients[i].getName().equals(name)){
                exist = true;
            }
        }
        if(!exist && temp.length <= 6 && amount > 0){
            Client c = new Client(name, amount);
            temp[this.clients.length] = c;
            this.clients = temp;
            this.status = "Accounts: {";
            for (int i = 0; i < this.clients.length; i++){
                this.status += clients[i].getStatus();
                if (i < this.clients.length - 1){
                    this.status += ", ";
                }
            }
            this.status += "}";
        }
        else if (temp.length > 6){
            this.status = "Error: Maximum Number of Accounts Reached";
        }
        else if (exist) {
            this.status = "Error: Client "+name+" already exists";
        }
        else if (amount <= 0){
            this.status = "Error: Non-Positive Initial Balance";
        }


    }



}
