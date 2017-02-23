package com.ironyard.controller.rest;

import com.ironyard.api.CardsApiHelper;
import com.ironyard.dto.CardsDeck;
import com.ironyard.dto.Shuffle;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wailm.yousif on 2/22/17.
 */

@RestController
public class RestCardsController
{
    @RequestMapping(path = "/rest/cards/shuffle", method = RequestMethod.GET)
    public Shuffle shuffle(@RequestParam(required = false) Integer deck_count) throws Exception
    {
        if (deck_count == null)
            deck_count = 1;

        return (new CardsApiHelper()).invokeShuffle(deck_count);
    }

    @RequestMapping(path = "/rest/cards/drawcard", method = RequestMethod.GET)
    public CardsDeck drawCard(
                              @RequestParam(required = false) String deck_id,
                              @RequestParam(required = false) Integer deck_count
                              ) throws Exception
    {
        if (deck_id == null)
            deck_id = "new";
        if (deck_count == null)
            deck_count = 2;

        return (new CardsApiHelper()).invokeDrawCard(deck_id, deck_count);
    }

    @RequestMapping(path = "/rest/cards/reshuffle", method = RequestMethod.GET)
    public Shuffle reshuffle(@RequestParam String deck_id) throws Exception
    {
        return (new CardsApiHelper()).invokeReshuffle(deck_id);
    }

    @RequestMapping(path = "/rest/cards/newdeck", method = RequestMethod.GET)
    public Shuffle createNewDeck() throws Exception
    {
        return (new CardsApiHelper()).invokeBrandNewDeck();
    }

    @RequestMapping(path = "/rest/cards/partialdeck", method = RequestMethod.GET)
    public Shuffle createPartialDeck(String cardsCodes) throws Exception
    {
        return (new CardsApiHelper()).invokePartialDeck(cardsCodes);
    }
}