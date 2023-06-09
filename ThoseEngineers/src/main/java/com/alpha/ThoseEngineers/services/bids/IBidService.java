package com.alpha.ThoseEngineers.services.bids;

import com.alpha.ThoseEngineers.dto.bids.BidResponseBody;
import com.alpha.ThoseEngineers.dto.bids.CreateBidRequestBody;
import com.alpha.ThoseEngineers.modules.bids.Bid;

import java.util.List;

public interface IBidService {
    public BidResponseBody create(CreateBidRequestBody bidRequestBody);
    public List<BidResponseBody> read();
    public BidResponseBody readById(Integer id);
    public String delete(Integer id);

    public String update(CreateBidRequestBody bidRequestBody);
}
