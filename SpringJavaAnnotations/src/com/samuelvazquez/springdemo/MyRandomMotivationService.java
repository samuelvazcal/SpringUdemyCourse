package com.samuelvazquez.springdemo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class MyRandomMotivationService implements MotivationService{

    private String fileName = "motivation-data.txt";
    private List<String> motivations = new ArrayList<>();

    private Random myRandom = new Random();

    public MyRandomMotivationService() {
//        File file = new File(fileName);
//
//        System.out.println("Reading info from file: " + file);
//        System.out.println("File exists?: " + file.exists());
//
//        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
//            String tempLine;
//            while((tempLine = br.readLine()) != null) {
//                motivations.add(tempLine);
//            }
//        } catch(IOException e) {
//            e.printStackTrace();
//        }

        System.out.println(">>MyRandomMotivationService: inside default constructor");
    }

    @Override
    public String getFortune() {
        int index = myRandom.nextInt(motivations.size());
        return motivations.get(index);
    }

    @PostConstruct
    public void loadMotivationFile() {
        System.out.println(">>MyRandomMotivationService: inside init method loadMotivationFile ");

        File file = new File(fileName);

        System.out.println("Reading info from file: " + file);
        System.out.println("File exists?: " + file.exists());

        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String tempLine;
            while((tempLine = br.readLine()) != null) {
                motivations.add(tempLine);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
