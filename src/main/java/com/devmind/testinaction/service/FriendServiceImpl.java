package com.devmind.testinaction.service;

import com.devmind.testinaction.model.Friend;
import com.devmind.testinaction.repository.FriendRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author devmind
 */
public class FriendServiceImpl implements FriendService {

    private final FriendRepository friendRepository;

    public FriendServiceImpl(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }


    @Override
    public int computeFriendAge(Friend friend) {
        if (friend == null) {
            throw new IllegalArgumentException("Friend is required");
        }
        return LocalDate.now().getYear() - friend.getBirthday().getYear();
    }

    @Override
    public double computeFriendAgeAverage() {
        List<Friend> friends = friendRepository.findAll();
        if (friends.isEmpty()){
            return 0.;
        }
        return friends.stream().collect(Collectors.averagingInt(this::computeFriendAge));
    }
}
