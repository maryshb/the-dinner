package thedinnerapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="trestaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String restaurantName;
    private String phone;
    private String address;
    double rating;


    public Restaurant() {

    }

    public Restaurant(int id, String restaurantName, String phone, String address, double rating) {
        this.id = id;
        this.restaurantName = restaurantName;
        this.phone = phone;
        this.address = address;
        this.rating = rating;
    }

    public int getId() { return id; }

    public String getRestaurantName() { return restaurantName; }

    public String getPhone() { return phone; }

    public String getAddress() { return address; }

    public double getRating() { return rating; }


    public void setId(int id) { this.id = id; }

    public void setRestaurantName(String restaurantName) { this.restaurantName = restaurantName; }

    public void setPhone(String phone) { this.phone = phone; }

    public void setAddress(String address) { this.address = address; }

    public void setRating(double rating) { this.rating = rating; }


    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", restaurantName='" + restaurantName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", rating=" + rating +
                '}';
    }

}
