package com.alpha.ThoseEngineers.controllers.bids;
import com.alpha.ThoseEngineers.dto.bids.BidResponseBody;
import com.alpha.ThoseEngineers.dto.bids.CreateBidRequestBody;
import com.alpha.ThoseEngineers.services.bids.BidService;
import com.alpha.ThoseEngineers.services.bids.IBidService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BidController {
    @Autowired
    public IBidService bidService;

    @PostMapping(value = "/bids")
    public @ResponseBody BidResponseBody create(@RequestBody CreateBidRequestBody bidRequestBody){
        return bidService.create(bidRequestBody);
    }

    @GetMapping(value = "/bids")
    public List<BidResponseBody> read(){
        return bidService.read();
    }

    @GetMapping(value = "/bids/{id}")
    public BidResponseBody readById(@PathVariable Integer id){
        return bidService.readById(id);
    }

    @DeleteMapping(value = "/bids/{id}")
    public String delete(@PathVariable Integer id){
        return bidService.delete(id);
    }


}
