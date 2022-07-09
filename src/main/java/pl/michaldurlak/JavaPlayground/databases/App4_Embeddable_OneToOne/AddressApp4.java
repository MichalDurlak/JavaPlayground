package pl.michaldurlak.JavaPlayground.databases.App4_Embeddable_OneToOne;

import javax.persistence.Embeddable;

// ta klasa jest wpisywana w inna tabele
@Embeddable
public class AddressApp4 {

    private String street;
    private String apartment;
    private String postalCode;
    private String city;


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
