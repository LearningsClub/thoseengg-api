package com.alpha.ThoseEngineers.services.bids;

import com.alpha.ThoseEngineers.dto.bids.BidResponseBody;
import com.alpha.ThoseEngineers.dto.bids.CreateBidRequestBody;
import com.alpha.ThoseEngineers.modules.bids.Bid;
import com.alpha.ThoseEngineers.modules.bids.Duration;
import com.alpha.ThoseEngineers.modules.jobs.data.Job;
import com.alpha.ThoseEngineers.modules.users.User;
import com.alpha.ThoseEngineers.repositories.bids.BidRepository;
import com.alpha.ThoseEngineers.repositories.jobs.data.JobRepository;
import com.alpha.ThoseEngineers.repositories.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BidService implements IBidService{

    @Autowired
    public UserRepository userRepository;
    @Autowired
    public BidRepository bidRepository;
    @Autowired
    public JobRepository jobRepository;
    @Override
    public BidResponseBody create(CreateBidRequestBody bidRequestBody) {
        Bid newBid=new Bid();

        BidResponseBody responseBody=new BidResponseBody();
        newBid.setBiddingAmount(bidRequestBody.getBiddingAmount());
        newBid.setDeadline(bidRequestBody.getDeadline());
        newBid.setNegotiable(true);
        newBid.setRelevantExperience(bidRequestBody.getRelevantExperience());
        newBid.setSuggestions(bidRequestBody.getSuggestions());
        newBid.setDuration(Duration.Total);

        User user=new User();
        user.setId(userRepository.getUserId(bidRequestBody.getUserRequestBody().getName(),bidRequestBody.getUserRequestBody().getMobNo(),bidRequestBody.getUserRequestBody().getEmailId()));
        newBid.setUser(user);

        Job job= new Job();
        job.setId(jobRepository.getJobId(bidRequestBody.getJobRequestBody().getTitle()));
        newBid.setJob(job);

        bidRepository.saveAndFlush(newBid);

        responseBody.setBiddingAmount(bidRequestBody.getBiddingAmount());
        responseBody.setDeadline(bidRequestBody.getDeadline());
        responseBody.setNegotiable(true);
        responseBody.setRelevantExperience(bidRequestBody.getRelevantExperience());
        responseBody.setSuggestions(bidRequestBody.getSuggestions());
        responseBody.setJob(job);
        responseBody.setUser(user);



        return responseBody;
    }
}
