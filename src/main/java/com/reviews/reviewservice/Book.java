package com.reviews.reviewservice;

import java.util.List;
import java.util.UUID;

public record Book(UUID id, List<Review> reviews) {
}
