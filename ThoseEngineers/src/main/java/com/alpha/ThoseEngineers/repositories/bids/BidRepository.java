package com.alpha.ThoseEngineers.repositories.bids;


import com.alpha.ThoseEngineers.modules.bids.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BidRepository extends JpaRepository<Bid,Integer>{
    @Query(value = "SELECT * FROM bids",nativeQuery = true)
    public List<Bid> getAllBids();
}
