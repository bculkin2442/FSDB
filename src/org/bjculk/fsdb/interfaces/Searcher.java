/*
 * The MIT License
 *
 * Copyright 2014 Benjamin Culkin.
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
 * Class for searching through documents in a backing store.
 *
 * @author Benjamin
 */
public interface Searcher {

  /**
   * Create a set of search results seeded with a particular set of documents
   *
   * @param docs The set of documents to use as the results
   * @return A set of search results containing only those documents
   */
  SearchResults seeded(List<Document> docs);

  /**
   * Search for all documents containing a specific keyword
   *
   * @param keyword The keyword to search for
   * @return A set of search results containing all documents with that keyword
   */
  SearchResults keywordSearch(String keyword);

  /**
   * Search for all documents whose title matches the given regex
   *
   * @param regex The regex to use for matching titles
   * @return A set of search results containing all documents whose title
   * matches the given regex.
   */
  SearchResults titleRegexSearch(String regex);

  /**
   * Search for all documents that have the given metadata key present on them,
   * regardless of value
   *
   * @param key The metadata key to search for
   * @return A set of search results containing all documents that have the
   * given metadata key present on them
   */
  SearchResults metadataPresenceSearch(String key);

  /**
   * Search for all documents that have the given metadata key with the given
   * value present on them.
   *
   * @param key The metadata key to search for
   * @param value The value the given metadata key must have. Can be a regex.
   * @return A set of search results containing all documents that have the
   * given metadata key with the given value set on them.
   */
  SearchResults metadataValueSearch(String key, String value);

  /**
   * The set intersection, or only the results in common, of the two given sets
   * of search results.
   *
   * @param lhs The first set of search results
   * @param rhs The second set of search results
   * @return A set of search results containing results held only in both given
   * sets of search results.
   */
  SearchResults and(SearchResults lhs, SearchResults rhs);

  /**
   * The set union, or all results in both, of the two given search results sets
   * of
   *
   * @param lhs The first set of search results
   * @param rhs The second set of search results
   * @return A set of search results containing results held in either one of
   * the given sets of search results
   */
  SearchResults or(SearchResults lhs, SearchResults rhs);

  /**
   * The set difference, or all results in one but not the other, of the two
   * given sets of search results
   *
   * @param lhs The first set of search results
   * @param rhs The second set of all search results
   * @return A set of search results containing all the results in the first
   * given set that are not also in the second given set.
   */
  SearchResults not(SearchResults lhs, SearchResults rhs);
}
