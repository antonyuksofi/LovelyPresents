package ua.com.lovelypresents.model;

/**
 * Created by Sofiia on 14.09.2017.
 */
public class Product {

    //private int id;
    private String name;
    private String code;

    public Product() {
    }

    public Product(int id, String name, String code) {
        //this.id = id;
        this.name = name;
        this.code = code;
    }

    public Product(String name, String code) {
        this.name = name;
        this.code = code;
    }

    /*public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Product{" +
                //"id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
