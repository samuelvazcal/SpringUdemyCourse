package com.samuelvazquez.entity;

import javax.persistence.*;

@Entity
@Table(name = "pokemon")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private String id;

    @Column(name="name")
    private String name;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "weight")
    private double weight;

    public Pokemon() {

    }

    public Pokemon(String name, String nickname, double weigth) {
        this.name = name;
        this.nickname = nickname;
        this.weight = weigth;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public double getWeight() {
        return weight;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", weigth=" + weight +
                '}';
    }
}
