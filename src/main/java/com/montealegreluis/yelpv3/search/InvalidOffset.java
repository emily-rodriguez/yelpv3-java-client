/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.montealegreluis.yelpv3.search;

/**
 * Exception thrown when an offset exceeds the maximum allowed value in Yelp, which is 1, 000
 */
public class InvalidOffset extends RuntimeException {
    public static InvalidOffset of(int value) {
        return new InvalidOffset(String.format(
            "The maximum offset allowed by Yelp is %d, %d found", Offset.MAX_OFFSET, value
        ));
    }

    private InvalidOffset(String message) {
        super(message);
    }
}
