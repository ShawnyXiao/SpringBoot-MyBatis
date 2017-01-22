package com.shawn.util;

import com.shawn.web.exception.ParameterIllegalException;

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
     * @param defaultValue default page, if pageString == null
     * @return parsed page
     */
    public static int parsePage(String pageString, int defaultValue) {
        return parseParameter(pageString, defaultValue);
    }

    /**
     * Parse size of per page from String to int.
     *
     * @param perPageString origin
     * @param defaultValue  default size of per page, if perPageString == null
     * @return parsed size of per page
     */
    public static int parsePerPage(String perPageString, int defaultValue) {
        return parsePage(perPageString, defaultValue);
    }

    /**
     * A helper method, parsing parameter about pagination.
     * If the string is null, return the default value.
     * If the string is not a number or the number < 1,
     * throw a parameter illegal exception.
     *
     * @param parameterString origin
     * @param defaultValue default value, if parameterString == null
     * @return parsed parameter
     */
    private static int parseParameter(String parameterString, int defaultValue) {
        if (parameterString == null) {
            return defaultValue;
        }

        int parameter;
        try {
            parameter = Integer.parseInt(parameterString);
        } catch (Exception e) {
            throw new ParameterIllegalException();
        }
        if (parameter < 1) {
            throw new ParameterIllegalException();
        }
        return parameter;
    }

}
