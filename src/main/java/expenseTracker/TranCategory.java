package expenseTracker;
//import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="trancategory")
public class TranCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String 	category_name;
    private String category_type;
    public TranCategory() {
    }


    public TranCategory(String category_name, String category_type) {

        this.setCategory_name(category_name);
        this.setCategory_type(category_type);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }


    public String getCategory_type() {
        return category_type;
    }

    public void setCategory_type(String category_type) {
        this.category_type = category_type;
    }



}
