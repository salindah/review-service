package com.reviews.reviewservice;

import java.util.UUID;

public record Review(UUID bookId, String review, String author) {
}
