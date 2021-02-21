package string;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * 1108. Defanging an IP Address
 * https://leetcode.com/problems/defanging-an-ip-address/
 * */
public class DefangingIPAddress {

    public static String defangIPaddr(String address) {
        return Stream.of(address.split("\\."))
                .collect(Collectors.joining("[.]"));
    }
}
