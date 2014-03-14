/*
 * The MIT License
 *
 * Copyright 2014 Benjamin.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.bjculk.fsdb.interfaces;

import java.util.List;

/**
 * A set of search results, backed by possibly multiple document stores.
 *
 * @author Benjamin
 */
public interface SearchResults {

  /**
   * Get all the search results for this search
   *
   * @return All of the search results for this search
   */
  List<SearchResult> getSearchResults();

  /**
   * Get a paginated version of the search results, dependant on the setting of
   * the results per page
   *
   * @param page The page of results to retrieve
   * @return All of the results on the specified page
   */
  List<SearchResult> getPagedResults(int page);

  /**
   * Set the order to sort search results by
   *
   * @param rso The order to sort search results by
   */
  void setSortOrder(ResultSortOrder rso);

  /**
   * Get the current order to sort search results by
   *
   * @return The current search result sort order
   */
  ResultSortOrder getResultSortOrder();

  /**
   * Set the piece of data to sort search results by
   *
   * @param rsd The piece of data to sort the results by
   */
  void setSortData(ResultSortData rsd);

  /**
   * Get the piece of data results are being sorted by
   *
   * @return The piece of data results are being sorted by
   */
  ResultSortData getResultSortData();

  /**
   * Set the number of results per page for pagination
   *
   * @param resultsPerPage The number of results per page when paginating
   */
  void setResultsPerPage(int resultsPerPage);

  /**
   * Get the number of results per page when paginating
   *
   * @return The number of results per page when paginating
   */
  int getResultsPerPage();

  /**
   * Get the query that this set of search results represents
   *
   * @return The query that this set of search results represents
   */
  String getQuery();
}
