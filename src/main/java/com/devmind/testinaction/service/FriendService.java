package com.devmind.testinaction.service;

import com.devmind.testinaction.model.Friend;

/**
 * @author devmind
 */
public interface FriendService {

    /**
     * Compute friend age from his birth year
     */
    double computeFriendAgeAverage();

    /**
     * Compute friend age from his birth year
     */
    int computeFriendAge(Friend friend);
}
