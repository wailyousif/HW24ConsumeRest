package com.ironyard.repo;

import com.ironyard.dto.CardsDeck;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by wailm.yousif on 2/22/17.
 */
public interface CardsDeckRepo extends PagingAndSortingRepository<CardsDeck, Long>
{
    @Query("select c from CardsDeck c where c.deck_id = :deckId")
    public CardsDeck findByDeckId(@Param("deckId") String deckId);
}
