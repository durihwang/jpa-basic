package hellojpa;

import java.util.Objects;
import javax.persistence.Embeddable;

// 값이 단순하지 않다면 일대다 관계를 이용하여야 한다.
@Embeddable
public class Address {

    String city;
    String street;
    String zipcode;

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public Address() {

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    // 값 타입 비교 시에는 equals를 오버라이딩 해서 구현해주어야 한다.
    // equals의 기본은 == 비교이기 때문이다.
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return Objects.equals(city, address.city) && Objects.equals(street,
            address.street) && Objects.equals(zipcode, address.zipcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, zipcode);
    }
}
