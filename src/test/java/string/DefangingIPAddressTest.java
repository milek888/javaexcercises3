package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefangingIPAddressTest {

    @Test
    void defangIPaddr() {
        String actualResult = DefangingIPAddress.defangIPaddr("1.1.1.1");
        System.out.println("------------");
    }
}