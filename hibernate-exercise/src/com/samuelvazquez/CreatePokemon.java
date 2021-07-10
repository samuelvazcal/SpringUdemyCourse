package com.samuelvazquez;

import com.samuelvazquez.entity.Pokemon;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreatePokemon {
    public static void main(String[] args) {
        //Creates session factory
        SessionFactory factory =
                new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Pokemon.class).buildSessionFactory();
        //creates session
        Session session = factory.getCurrentSession();

        try {
            //use the session object to save new object
            System.out.println("Adding new Pokemon");
            Pokemon newPokemon1 = new Pokemon("Sandsherw","Gaia",12.0);
            Pokemon newPokemon2 = new Pokemon("Pidgey","Captain",1.8);
            Pokemon newPokemon3 = new Pokemon("Poliwag","Zeus",12.4);
            Pokemon newPokemon4 = new Pokemon("Growlithe","Cerberus",19.0);
            Pokemon newPokemon5 = new Pokemon("Dratini","Atenea",3.3);
            Pokemon newPokemon6 = new Pokemon("Oddish","Freya",5.4);
            //start transaction
            session.beginTransaction();
            //save the new object
            session.save(newPokemon2);
            session.save(newPokemon3);
            session.save(newPokemon4);
            session.save(newPokemon5);
            session.save(newPokemon6);
            //commit transaction
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
