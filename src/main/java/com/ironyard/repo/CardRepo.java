package com.ironyard.repo;

import com.ironyard.dto.Card;
import com.ironyard.dto.CardsDeck;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by wailm.yousif on 2/22/17.
 */
public interface CardRepo extends PagingAndSortingRepository<Card, Long>
{
    public Page<Card> findByCardsDeck(CardsDeck cardsDeck, Pageable pageable);
}
