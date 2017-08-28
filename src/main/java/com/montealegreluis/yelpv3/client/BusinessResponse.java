/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.montealegreluis.yelpv3.client;

import com.montealegreluis.yelpv3.businesses.BusinessDetails;

/**
 * Response sent by Yelp's Business API
 *
 * @link https://www.yelp.com/developers/documentation/v3/business
 */
public class BusinessResponse extends Response {
    public static BusinessResponse fromOriginalResponse(String jsonResponse) {
        return new BusinessResponse(jsonResponse);
    }

    public BusinessDetails business() {
        return parser.business(jsonResponse);
    }

    private BusinessResponse(String jsonResponse) {
        super(jsonResponse);
    }
}
