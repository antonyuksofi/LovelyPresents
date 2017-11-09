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
    private int userId;

    @Column(name = "product_id")
    private int productId;

    @Column(name = "image")
    private String image;

    @Column(name = "count")
    private int count;

    public CartItem() {}

    /*public CartItem(int userId, int productId, String image, int count) {
        this.userId = userId;
        this.productId = productId;
        this.image = image;
        this.count = count;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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
                ", userId=" + userId +
                ", productId=" + productId +
                ", image='" + image + '\'' +
                ", count=" + count +
                '}';
    }
}
