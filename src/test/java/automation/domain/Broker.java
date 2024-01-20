package automation.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class Broker {

    private String name;
    private String address;
    private int numberOfProperties;
    private List<String> phoneNumbers;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Broker broker = (Broker) o;
        return numberOfProperties == broker.numberOfProperties && Objects.equals(name, broker.name) && Objects.equals(address, broker.address) && Objects.equals(phoneNumbers, broker.phoneNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, numberOfProperties, phoneNumbers);
    }
}