package tn.esprit.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dari.repositories.SubscriptionRepository;
import tn.esprit.dari.entities.Subscription;

import java.util.List;
import java.util.Optional;


@Service
public class SubscriptionImpl implements ISubscription {

    @Autowired
    SubscriptionRepository SubRep ;



    @Override
    public List<Subscription> AllSubs() {

        List<Subscription> subs = (List<Subscription>) SubRep.findAll();
        for(Subscription sub  : subs ){
            System.out.println("subscriptions    : " + sub);

        }
        return subs;
    }

    @Override
    public Optional<Subscription> getSub(int id) {
        return SubRep.findById(id);
    }

    @Override
    public Subscription Add(Subscription S) {
        return SubRep.save(S);
    }


   /* @Override
    public Subscription Add(Subscription S) {
        return SubRep.save(S);
    }*/

    @Override
    public Subscription Modify(Subscription S) {


        Subscription sub =SubRep.findById(S.getId_sub()).orElse(null);
        sub.setTitle(S.getTitle());
        sub.setPrice(S.getPrice());
        sub.setDescription(S.getDescription());
        return SubRep.save(sub);
    }

    @Override
    public void DeleteSub(int  id) {
        SubRep.deleteById(id);
    }
}
