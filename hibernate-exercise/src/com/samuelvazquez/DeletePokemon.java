package com.samuelvazquez;

import com.samuelvazquez.entity.Pokemon;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeletePokemon {
    public static void main(String[] args) {
        SessionFactory factory =
                new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Pokemon.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            String pokemonId = "9";
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\nGetting Pokemon with id: " + pokemonId);
            Pokemon myPokemon = session.get(Pokemon.class,pokemonId);

            System.out.println("Deleting Pokemon id = " + pokemonId);
            session.createQuery("delete from Pokemon where id>=7").executeUpdate();


            session.getTransaction().commit();
            System.out.println("Done!");

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
