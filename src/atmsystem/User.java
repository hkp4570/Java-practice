package atmsystem;

public class User {
   private String name;
   private String password;
   private Float balance;

   public User(String name, String password, Float balance){
       this.name = name;
       this.password = password;
       this.balance = balance;
   }

    public String getName() {
        return name;
    }
    public void setName(String name) {
       this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }
}
