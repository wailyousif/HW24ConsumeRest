package com.ironyard.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by wailm.yousif on 2/22/17.
 */

@Entity
public class Card
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_seq")
    @SequenceGenerator(name="card_seq", sequenceName = "card_seq", allocationSize = 50, initialValue = 50)
    @JsonIgnore
    private long id;

    String image;
    String value;
    String suit;
    String code;

    @ManyToOne
    @JsonIgnore
    CardsDeck cardsDeck;

    @Override
    public String toString() {
        return "Card{" +
                "image='" + image + '\'' +
                ", value='" + value + '\'' +
                ", suit='" + suit + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CardsDeck getCardsDeck() {
        return cardsDeck;
    }

    public void setCardsDeck(CardsDeck cardsDeck) {
        this.cardsDeck = cardsDeck;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}