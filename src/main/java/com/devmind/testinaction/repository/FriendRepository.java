package com.devmind.testinaction.repository;

import com.devmind.testinaction.model.Friend;

import java.util.List;

public interface FriendRepository {
    List<Friend> findAll();
}
