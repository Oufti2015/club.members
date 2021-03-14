package sst.club.members.model;

import lombok.Data;

@Data
public class PostalAddress {
    private String address;
    private String postCode;
    private String cityName;
    private String country;

    @Override
    public String toString() {
        return String.join(" ", address, postCode, cityName, country);
    }
}
