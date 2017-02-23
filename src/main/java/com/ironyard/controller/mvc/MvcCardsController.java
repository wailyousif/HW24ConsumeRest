package com.ironyard.controller.mvc;

import com.ironyard.api.CardsApiHelper;
import com.ironyard.dto.Card;
import com.ironyard.dto.CardsDeck;
import com.ironyard.repo.CardRepo;
import com.ironyard.repo.CardsDeckRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by wailm.yousif on 2/22/17.
 */

@Controller
public class MvcCardsController
{

    private static final String emptyString = "";

    @Autowired
    CardsDeckRepo cardsDeckRepo;

    @Autowired
    CardRepo cardRepo;

    @RequestMapping(path = "/mvc/cards/drawcard", method = RequestMethod.GET)
    public String drawCard(Model model,
                            @RequestParam(value = "page", required = false) Integer page,
                            @RequestParam(required = true) String deck_id,
                            @RequestParam(required = true) Integer deck_count
            ) throws Exception
    {
        if (deck_id == null || deck_id.equals(emptyString))
            deck_id = "new";
        if (deck_count == null)
            deck_count = 2;

        System.out.println("values:" + deck_id + deck_count);

        CardsDeck cardsDeck = (new CardsApiHelper()).invokeDrawCard(deck_id, deck_count);
        System.out.println("toString=" + cardsDeck.toString());

        //check if already exists in DB
        CardsDeck foundCardsDeck = cardsDeckRepo.findByDeckId(deck_id);
        if (foundCardsDeck != null)
            cardsDeck.setId(foundCardsDeck.getId());

        for (Card card: cardsDeck.getCards())
        {
            card.setCardsDeck(cardsDeck);
        }
        cardsDeckRepo.save(cardsDeck);

        setDisplay(model, cardsDeck, cardsDeck.getDeck_id(), deck_count, 0);
        return "/open/index";
    }


    @RequestMapping(path = "/mvc/cards/show", method = RequestMethod.GET)
    public String show(Model model,
                           @RequestParam(value = "page", required = false) Integer page,
                           @RequestParam(required = true) String deck_id,
                           @RequestParam(required = true) Integer deck_count
    )
    {
        System.out.println("values:" + page + deck_id + deck_count);

        CardsDeck cardsDeck = cardsDeckRepo.findByDeckId(deck_id);
        setDisplay(model, cardsDeck, deck_id, deck_count, page);
        return "/open/index";
    }


    private void setDisplay(Model model, CardsDeck cardsDeck, String deck_id, Integer deck_count,
                            Integer page)
    {
        model.addAttribute("deck_id", deck_id);
        model.addAttribute("deck_count", deck_count);
        Sort sort;
        Sort.Order order1 = new Sort.Order(Sort.Direction.ASC, "id");
        sort = new Sort(order1);
        PageRequest pr = new PageRequest(page, 3, sort);
        Page<Card> listOfCards = cardRepo.findByCardsDeck(cardsDeck, pr);
        model.addAttribute("listOfCards", listOfCards);
    }
}
