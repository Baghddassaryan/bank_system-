package models;

/**
 * Represents a postal address.
 */
public class Address {
    final private String country;
    final private String region;
    final private String city;
    final private String street;
    final private String house;

    public Address(String country, String region, String city, String street, String house) {
        this.country = country;
        this.region = region;
        this.city = city;
        this.street = street;
        this.house = house;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    @Override
    public String toString() {
        return street + " " + house + ", " + city + ", " + region + ", " + country;
    }
}