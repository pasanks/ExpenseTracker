package expenseTracker;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

//    private String title;
//    private String content;
    private String 	category;
    private double amount;
    private String remarks;
    private String 	tran_date;

    public transaction() {
    }

    public transaction(String category, double amount,String remarks, String tran_date) {
        this.setCategory(category);
        this.setAmount(amount);
        this.setRemarks(remarks);
        this.setTranDate(tran_date);
    }

    public transaction(int id, String category, double amount,String remarks, String tran_date) {
        this.setId(id);
        this.setCategory(category);
        this.setAmount(amount);
        this.setRemarks(remarks);
        this.setTranDate(tran_date);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTranDate() {
        return tran_date;
    }

    public void setTranDate(String tran_date) {
        this.tran_date = tran_date;
    }

//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }

    public String testFunc(){
        return "dsfgh";
    }

    @Override
    public String toString() {
        return "transaction{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", amount='" + amount + '\'' +
                ", remarks='" + remarks + '\'' +
                ", tran_date='" + tran_date + '\'' +
                '}';


    }
}