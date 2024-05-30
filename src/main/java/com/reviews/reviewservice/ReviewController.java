package com.reviews.reviewservice;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsEntityFetcher;
import com.netflix.graphql.dgs.DgsQuery;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@DgsComponent
public class ReviewController {

    @DgsEntityFetcher(name = "Book")
    public Book book(Map<String, Object> values) {
        return new Book(UUID.fromString((String) values.get("id")), null);
    }

    @DgsData(parentType = "Book")
    public List<Review> reviews() {
        System.out.println("Fetched reviews");
        return List.of(
                new Review(UUID.randomUUID(), "Very Good",  "James"),
                new Review(UUID.randomUUID(), "Great Book",  "Peter")
        );
    }

    @DgsQuery
    public List<Review> allReviews() {
        System.out.println("Books were fetched");
        return List.of(
                new Review(UUID.randomUUID(), "Very Good",  "James"),
                new Review(UUID.randomUUID(), "Great Book",  "Peter"),
                new Review(UUID.randomUUID(), "Not too good",  "Jane")
        );
    }
}
