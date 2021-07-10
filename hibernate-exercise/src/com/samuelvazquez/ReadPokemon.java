package com.samuelvazquez;

import com.samuelvazquez.entity.Pokemon;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadPokemon {
    public static void main(String[] args) {
        SessionFactory factory =
                new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Pokemon.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try{
            System.out.println("Adding new Pokemon");
            Pokemon tempPokemon = new Pokemon("Pikachu","Barry",6.0);
            session.beginTransaction();

            session.save(tempPokemon);

            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("This is the info for this Pokemon");
            Pokemon pokemon = session.get(Pokemon.class,tempPokemon.getId());

            System.out.println("Info: " + pokemon);
            session.getTransaction().commit();

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
