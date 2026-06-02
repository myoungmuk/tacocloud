package tacos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tacoOrder")
public class TacoOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private Date placedAt = new Date();

    @DBRef
    private User user;

    private List<Taco> tacos = new ArrayList<>();

    @NotBlank(message = "Delivery name is required")
    private String deliveryName;

    @NotBlank(message = "Street is required")
    private String deliveryStreet;

    @NotBlank(message = "City is required")
    private String deliveryCity;

    @NotBlank(message = "State is required")
    private String deliveryState;

    @NotBlank(message = "Zip code is required")
    private String deliveryZip;

    @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])/[0-9]{2}$", message = "Must be formatted MM/YY")
    private String ccExpiration;

    @Pattern(regexp = "[0-9]{3}", message = "Invalid CVV")
    private String ccCVV;

    public TacoOrder() {
    }

    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public Date getPlacedAt() { return placedAt; }
    public void setPlacedAt(Date placedAt) { this.placedAt = placedAt; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public List<Taco> getTacos() { return tacos; }
    public void setTacos(List<Taco> tacos) { this.tacos = tacos; }
    public String getDeliveryName() { return deliveryName; }
    public void setDeliveryName(String deliveryName) { this.deliveryName = deliveryName; }
    public String getDeliveryStreet() { return deliveryStreet; }
    public void setDeliveryStreet(String deliveryStreet) { this.deliveryStreet = deliveryStreet; }
    public String getDeliveryCity() { return deliveryCity; }
    public void setDeliveryCity(String deliveryCity) { this.deliveryCity = deliveryCity; }
    public String getDeliveryState() { return deliveryState; }
    public void setDeliveryState(String deliveryState) { this.deliveryState = deliveryState; }
    public String getDeliveryZip() { return deliveryZip; }
    public void setDeliveryZip(String deliveryZip) { this.deliveryZip = deliveryZip; }
    public String getCcNumber() { return ccNumber; }
    public void setCcNumber(String ccNumber) { this.ccNumber = ccNumber; }
    public String getCcExpiration() { return ccExpiration; }
    public void setCcExpiration(String ccExpiration) { this.ccExpiration = ccExpiration; }
    public String getCcCVV() { return ccCVV; }
    public void setCcCVV(String ccCVV) { this.ccCVV = ccCVV; }
}
