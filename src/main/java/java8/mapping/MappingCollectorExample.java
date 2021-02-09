package java8.mapping;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.toSet;
/*
* Example of using Collectors.mapping()
*
* */
public class MappingCollectorExample {

    public void mapping() {
        Map<Department, Set<String>> namesByDepartment = getEmployees().stream()
                .collect(groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getSecondName, toSet())));
    }

    private List<Employee> getEmployees() {
        Department it = Department.builder().name("IT").postalCode("35-051").priority(1).build();
        Department finance = Department.builder().name("FINANCE").postalCode("35-051").priority(1).build();
        Department accounting = Department.builder().name("ACCOUNTING").postalCode("35-051").priority(1).build();
        return  List.of(Employee.builder().department(it).secondName("Mazurek").salary(12.0).build(),
                Employee.builder().department(it).secondName("Szewczyk").salary(120.0).build(),
                Employee.builder().department(accounting).secondName("Miasko").salary(14.0).build(),
                Employee.builder().department(finance).secondName("Kozak").salary(8.0).build(),
                Employee.builder().department(finance).secondName("Niewiadomska").salary(18.0).build());
    }
}
