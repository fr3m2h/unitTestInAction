package com.devmind.testinaction.service;

import static org.junit.jupiter.api.Assertions.*;
import com.devmind.testinaction.model.Friend;
import com.devmind.testinaction.repository.FriendRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class FriendServiceImplTest {
    @Mock // 2.
    private FriendRepository friendRepository;
    private FriendService friendService;

    @BeforeEach
    void init() { // 3.
        friendService = new FriendServiceImpl(friendRepository);
    }

    @Test
    void testComputeFriendAge() {
        LocalDate birthday = LocalDate.parse("2003-04-02");
        // Arrange
        Friend friend = new Friend("Martin", birthday);

        // Act
        int age = friendService.computeFriendAge(friend);

        // Assert
        assertEquals(21, age); // Assuming the current year is 2024
    }

    @Test
    void testComputeFriendAgeWithNull() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> friendService.computeFriendAge(null));
    }

    @Test
    void testComputeFriendAgeAverage() {
        // Arrange
        List<Friend> myFriends = List.of(
                new Friend("Elodie", LocalDate.of(1999, 1, 1)),
                new Friend("Charles", LocalDate.of(2001, 1, 1))
        );
        Mockito.when(friendRepository.findAll()).thenReturn(myFriends); // 4.

        // Act
        double average = friendService.computeFriendAgeAverage(); // 5.

        // Assert
        Assertions.assertThat(average).isEqualTo(24.0);
    }

    @Test
    void testComputeFriendAgeAverageWithEmptyList() {
        // Arrange
        Mockito.when(friendRepository.findAll()).thenReturn(Collections.emptyList());

        // Act
        double averageAge = friendService.computeFriendAgeAverage();

        // Assert
        assertEquals(0., averageAge);
    }

}