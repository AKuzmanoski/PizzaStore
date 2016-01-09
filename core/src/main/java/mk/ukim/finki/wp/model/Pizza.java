package mk.ukim.finki.wp.model;

import javax.persistence.*;

/**
 * Created by User on 12/3/2015.
 */
@Entity
@Table(name = "pizzas")
public class Pizza extends BaseEntity {
    private String type;

    public Pizza(String type) {
        this.type = type;
    }

    public Pizza() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return getType();
    }
}
