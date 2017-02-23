package com.ironyard.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by wailm.yousif on 2/22/17.
 */

@Entity
public class CardsDeck
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cards_deck_seq")
    @SequenceGenerator(name="cards_deck_seq", sequenceName = "cards_deck_seq", allocationSize = 50, initialValue = 50)
    @JsonIgnore
    private long id;

    boolean success;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Card> cards;

    String deck_id;
    int remaining;

    @Override
    public String toString() {
        return "CardsDeck{" +
                "success=" + success +
                ", cards=" + cards +
                ", deck_id='" + deck_id + '\'' +
                ", remaining=" + remaining +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public String getDeck_id() {
        return deck_id;
    }

    public void setDeck_id(String deck_id) {
        this.deck_id = deck_id;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }
}