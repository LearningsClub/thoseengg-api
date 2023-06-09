package com.alpha.ThoseEngineers.services.bids;

import com.alpha.ThoseEngineers.dto.bids.BidResponseBody;
import com.alpha.ThoseEngineers.dto.bids.CreateBidRequestBody;
import com.alpha.ThoseEngineers.modules.bids.Bid;
import com.alpha.ThoseEngineers.modules.bids.Frequency;
import com.alpha.ThoseEngineers.modules.jobs.data.Job;
import com.alpha.ThoseEngineers.modules.jobs.technicals.Domain;
import com.alpha.ThoseEngineers.modules.jobs.technicals.Framework;
import com.alpha.ThoseEngineers.modules.jobs.technicals.Language;
import com.alpha.ThoseEngineers.modules.users.User;
import com.alpha.ThoseEngineers.repositories.bids.BidRepository;
import com.alpha.ThoseEngineers.repositories.jobs.data.JobRepository;
import com.alpha.ThoseEngineers.repositories.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

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
        newBid.setFrequency(Frequency.Total);

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

    @Override
    public List<BidResponseBody> read() {
        List<Bid> bidList= bidRepository.getAllBids();
        List<BidResponseBody> responseBodyList=new ArrayList<>();
        for(Bid bid:bidList){
            BidResponseBody responseBody=new BidResponseBody();

            responseBody.setId(bid.getId());
            responseBody.setSuggestions(bid.getSuggestions());
            responseBody.setBiddingAmount(bid.getBiddingAmount());
            responseBody.setFrequency(bid.getFrequency());
            responseBody.setNegotiable(bid.isNegotiable());
            responseBody.setRelevantExperience(bid.getRelevantExperience());
            responseBody.setDeadline(bid.getDeadline());
            responseBody.setCreatedAt(bid.getCreatedAt());
            responseBody.setUpdatedAt(bid.getUpdatedAt());

            User user=bid.getUser();
            user.setBid(null);
            user.setJobList(null);
            responseBody.setUser(user);

            Job job=bid.getJob();
            job.setBid(null);
            job.setUser(null);
            job.setLanguage(null);
            job.setDomain(null);
            job.setFramework(null);
            job.setFile(null);
            responseBody.setJob(job);


            responseBodyList.add(responseBody);
        }
        return responseBodyList;
    }

    @Override
    public BidResponseBody readById(Integer id) {

        Bid bid=bidRepository.getReferenceById(id);
        BidResponseBody responseBody=new BidResponseBody();

        responseBody.setId(bid.getId());
        responseBody.setBiddingAmount(bid.getBiddingAmount());
        responseBody.setFrequency(bid.getFrequency());
        responseBody.setRelevantExperience(bid.getRelevantExperience());
        responseBody.setDeadline(bid.getDeadline());
        responseBody.setNegotiable(bid.isNegotiable());
        responseBody.setSuggestions(bid.getSuggestions());
        responseBody.setCreatedAt(bid.getCreatedAt());
        responseBody.setUpdatedAt(bid.getUpdatedAt());

        User user=bid.getUser();
        user.setBid(null);
        user.setJobList(null);
        responseBody.setUser(user);

        Job job=bid.getJob();
        job.setBid(null);
        job.setUser(null);
        job.setLanguage(null);
        job.setDomain(null);
        job.setFramework(null);
        job.setFile(null);
        responseBody.setJob(job);

        return responseBody;
    }

    @Override
    public String delete(Integer id) {
        Optional<Bid> bid=bidRepository.findById(id);
        if(bid.isEmpty())
            return "Bid not present!";
        bidRepository.delete(bid.get());
        return "Deleted Successfully!";
    }

    @Override
    public String update(CreateBidRequestBody bidRequestBody) {
        return null;
    }


}
