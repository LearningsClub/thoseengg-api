package com.alpha.ThoseEngineers.services.bids;

import com.alpha.ThoseEngineers.dto.bids.BidResponseBody;
import com.alpha.ThoseEngineers.dto.bids.CreateBidRequestBody;

public interface IBidService {
    public BidResponseBody create(CreateBidRequestBody bidRequestBody);
}
