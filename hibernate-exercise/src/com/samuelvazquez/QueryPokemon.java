package com.samuelvazquez;

import com.samuelvazquez.entity.Pokemon;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryPokemon {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory =
                new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Pokemon.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            List<Pokemon> pokemonList = session.createQuery("from Pokemon").getResultList();
            displayPokemonTeam(pokemonList);

            pokemonList = session.createQuery("from Pokemon p where p.nickname = 'Gaia'").getResultList();

            System.out.println("Pokemon who nickname is Gaia");
            displayPokemonTeam(pokemonList);

            pokemonList = session.createQuery("from Pokemon p where p.id = 1 or p.weight > 10.0").getResultList();
            System.out.println("Pokemon who id is 1 or weight is greater than 10 kg");
            displayPokemonTeam(pokemonList);


            pokemonList = session.createQuery("from Pokemon p where p.nickname like '%s%'").getResultList();
            System.out.println("Pokemon who nickname contains s");
            displayPokemonTeam(pokemonList);

            //commit a transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }

    }

    private static void displayPokemonTeam(List<Pokemon> pokemonList) {
        for(Pokemon tempPokemon: pokemonList) {
            System.out.println(tempPokemon);
        }
    }
}


