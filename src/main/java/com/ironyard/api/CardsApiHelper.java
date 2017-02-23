package com.ironyard.api;

import com.ironyard.dto.CardsDeck;
import com.ironyard.dto.Shuffle;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wailm.yousif on 2/22/17.
 */

public class CardsApiHelper
{
    private RestTemplate restTemplate;

    public CardsApiHelper()
    {
        restTemplate = new RestTemplate();
    }

    private HttpEntity getHeaders()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity headersEntity = new HttpEntity(headers);
        return headersEntity;
    }

    public Shuffle invokeShuffle(Integer deck_count)
    {
        String url = "https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=" + deck_count.toString();
        return (Shuffle)(restTemplate.exchange(url, HttpMethod.GET, getHeaders(), Shuffle.class)).getBody();
    }

    public CardsDeck invokeDrawCard(String deck_id, Integer count)
    {
        String url = "https://deckofcardsapi.com/api/deck/" + deck_id + "/draw/?count=" + count.toString();
        return (CardsDeck) (restTemplate.exchange(url, HttpMethod.GET, getHeaders(), CardsDeck.class)).getBody();
    }

    public Shuffle invokeReshuffle(String deck_id)
    {
        String url = "https://deckofcardsapi.com/api/deck/" + deck_id + "/shuffle/";
        return (Shuffle)(restTemplate.exchange(url, HttpMethod.GET, getHeaders(), Shuffle.class)).getBody();
    }

    public Shuffle invokeBrandNewDeck()
    {
        String url = "https://deckofcardsapi.com/api/deck/new/";
        return (Shuffle)(restTemplate.exchange(url, HttpMethod.GET, getHeaders(), Shuffle.class)).getBody();
    }

    public Shuffle invokePartialDeck(String cardsCodes)
    {
        String url = "https://deckofcardsapi.com/api/deck/new/shuffle/?cards=";
        /*
        if (cardsCodes.size() != 0)
        {
            for (String cardCode: cardsCodes)
            {
                url = url + cardCode + ",";
            }
            url = url.substring(0, url.length() - 1);
        }
        */
        url = url + cardsCodes;
        return (Shuffle)(restTemplate.exchange(url, HttpMethod.GET, getHeaders(), Shuffle.class)).getBody();
    }
}