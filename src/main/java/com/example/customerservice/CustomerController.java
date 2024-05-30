package com.example.customerservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @GetMapping("/customer")
    public ResponseEntity<?> getCustomer(@RequestParam String documentType, @RequestParam String documentNumber) {
        if (!documentType.equals("C") && !documentType.equals("P")) {
            return new ResponseEntity<>("Tipo de documento no válido", HttpStatus.BAD_REQUEST);
        }
        if (documentNumber == null || documentNumber.isEmpty()) {
            return new ResponseEntity<>("Número de documento es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (documentType.equals("C") && documentNumber.equals("23445322")) {
            Customer customer = new Customer();
            customer.setFirstName("Juan");
            customer.setSecondName("Carlos");
            customer.setFirstSurname("Pérez");
            customer.setSecondSurname("Rodríguez");
            customer.setPhone("555-1234");
            customer.setAddress("Calle 123");
            customer.setCity("Bogotá");

            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
        return new ResponseEntity<>("Cliente no encontrado", HttpStatus.NOT_FOUND);
    }
}
