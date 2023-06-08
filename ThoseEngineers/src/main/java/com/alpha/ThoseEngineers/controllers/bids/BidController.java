package com.alpha.ThoseEngineers.controllers.bids;
import com.alpha.ThoseEngineers.dto.bids.BidResponseBody;
import com.alpha.ThoseEngineers.dto.bids.CreateBidRequestBody;
import com.alpha.ThoseEngineers.services.bids.IBidService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BidController {
    @Autowired
    public IBidService bidService;

    private static final Logger log = LoggerFactory.getLogger(BidController.class);
    @PostMapping(value = "/bids")
    public @ResponseBody BidResponseBody create(@RequestBody CreateBidRequestBody bidRequestBody){
        log.info("Inside PostBid Method");
        return bidService.create(bidRequestBody);
    }

}
