package com.samuelvazquez;

import com.samuelvazquez.entity.Pokemon;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdatePokemon {
    public static void main(String[] args) {
        SessionFactory factory =
                new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Pokemon.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            String pokemonId = "6";
            session.beginTransaction();

            System.out.println("\nGetting student with id: " + pokemonId);
            Pokemon myPokemon = session.get(Pokemon.class,pokemonId);

            System.out.println("Updating Pokemon...");
            myPokemon.setName("Gloom");
            myPokemon.setWeight(8.6);

            session.getTransaction().commit();

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
