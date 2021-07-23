package com.samuelvazquez.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {
    public static void main(String[] args) {

        try {
            // create object mapper
            ObjectMapper mapper = new ObjectMapper();

            // read JSON file and ma/convert to Java POJO: data/sample-lite.json
            Student myStudent = mapper.readValue(new File("data/sample-full.json"),Student.class);
            // print first name and last name
            System.out.println("First name: " + myStudent.getFirstName());
            System.out.println("Last name: " + myStudent.getLastName());

            // print out address: street and city
            Address tempAddress = myStudent.getAddress();
            System.out.println("Street: " + tempAddress.getStreet());
            System.out.println("City: " + tempAddress.getCity());

            // print out languages
            for(String tempLang : myStudent.getLanguages()) {
                System.out.println(tempLang);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
