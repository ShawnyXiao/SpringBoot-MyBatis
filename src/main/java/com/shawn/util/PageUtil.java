package com.shawn.util;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * @author Xiaoyue Xiao
 */
public class PageUtil {

    /**
     * Calculate offset for LIMIT clause in SQL. If page < 1, it will return 0.
     *
     * @param page    page number
     * @param perPage size of per page
     * @return offset
     */
    public static int calculateOffset(int page, int perPage) {
        return calculateOffset(page, perPage, 0);
    }

    /**
     * Calculate offset for LIMIT clause in SQL. If page < 1, it will return defaultValue.
     *
     * @param page         page number
     * @param perPage      size of per page
     * @param defaultValue default return value, if page < 1
     * @return offset
     */
    public static int calculateOffset(int page, int perPage, int defaultValue) {
        return page < 1 ? defaultValue : (page - 1) * perPage;
    }

    /**
     * Calculate total number of pages.
     *
     * @param rowCount count of rows
     * @param perPage  size of per page
     * @return total number of pages
     */
    public static int calculateTotalPage(int rowCount, int perPage) {
        return (rowCount % perPage == 0) ? (rowCount / perPage) : (rowCount / perPage + 1);
    }

    /**
     * Parse page from String to int.
     *
     * @param pageString   origin
     * @param defaultValue default page, if errors happen or page < 1
     * @return parsed page
     */
    public static int parsePage(String pageString, int defaultValue) {
        int page = NumberUtils.toInt(pageString, defaultValue);
        return page < 1 ? defaultValue : page;
    }

    /**
     * Parse size of per page from String to int.
     *
     * @param perPageString origin
     * @param defaultValue  default size of per page, if errors happen or size < 1
     * @return parsed size of per page
     */
    public static int parsePerPage(String perPageString, int defaultValue) {
        int perPage = NumberUtils.toInt(perPageString, defaultValue);
        return perPage < 1 ? defaultValue : perPage;
    }

}
