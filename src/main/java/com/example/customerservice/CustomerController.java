package com.example.customerservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CustomerController {

    @GetMapping("/customers")
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
        if (documentType.equals("C") && documentNumber.equals("11111111")) {
            Customer customer = new Customer();
            customer.setFirstName("Jhenny");
            customer.setSecondName("Juliana");
            customer.setFirstSurname("Pérez");
            customer.setSecondSurname("Aponte");
            customer.setPhone("444-55112");
            customer.setAddress("Av siempre viva");
            customer.setCity("Cali");

            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
        return new ResponseEntity<>("Cliente no encontrado", HttpStatus.NOT_FOUND);
    }
}
