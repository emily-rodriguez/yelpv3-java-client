/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.montealegreluis.yelpv3.jsonparser;

import com.montealegreluis.yelpv3.search.SearchCategories;
import com.montealegreluis.yelpv3.search.SearchCategory;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchCategoryParser {
    private static final SearchCategories categories = new SearchCategories();

    public static SearchCategories all() {
        if (categories.isEmpty()) populate();
        return categories;
    }

    private static void populate() {
        JSONArray jsonCategories = new JSONArray(readCategories());
        for (int i = 0; i < jsonCategories.length(); i++)
            categories.add(parseSearchCategory(jsonCategories.getJSONObject(i)));
    }

    private static String readCategories() {
        ClassLoader classLoader = SearchCategoryParser.class.getClassLoader();
        InputStream stream = classLoader.getResourceAsStream("categories.json");
        Scanner scanner = new Scanner(stream).useDelimiter("\\A");
        return scanner.hasNext() ? scanner.next() : "";
    }

    private static SearchCategory parseSearchCategory(JSONObject category) {
        List<String> countries = null;
        List<String> parents = extract(category.getJSONArray("parents"));

        if (!category.isNull("country_whitelist"))
            countries = extract(category.getJSONArray("country_whitelist"));

        return new SearchCategory(
            category.getString("alias"),
            category.getString("title"),
            parents,
            countries
        );
    }

    private static List<String> extract(JSONArray jsonArray) {
        List<String> items = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) items.add(jsonArray.getString(i));
        return items;
    }
}