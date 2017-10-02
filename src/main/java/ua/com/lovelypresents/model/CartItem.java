package ua.com.lovelypresents.model;

import javax.persistence.*;

/**
 * Created by Sofiia on 29.09.2017.
 */
@Entity
@Table(name = "cartitems")
public class CartItem {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "product_id")
    private int product_id;

    @Column(name = "image")
    private String image;

    @Column(name = "count")
    private int count;

    public CartItem() {}

    /*public CartItem(int user_id, int product_id, String image, int count) {
        this.user_id = user_id;
        this.product_id = product_id;
        this.image = image;
        this.count = count;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", product_id=" + product_id +
                ", image='" + image + '\'' +
                ", count=" + count +
                '}';
    }
}
