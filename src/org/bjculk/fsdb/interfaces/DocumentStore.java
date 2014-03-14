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
 * A document store, backed in a implementation specific manner. Documents are
 * stored and looked up by title, therefore the title of any given document must
 * be unique
 *
 * @author Benjamin
 */
public interface DocumentStore {

  /**
   * Add a document to this document store.
   *
   * @param doc The document to add to the store
   * @return Whether the document was stored successfully.
   */
  boolean storeDocument(Document doc);

  /**
   * Store a list of documents in bulk to this store
   *
   * @param docs The documents to do bulk storage of in this store
   * @return Whether each document was stored successfully
   */
  List<Boolean> storeDocuments(List<Document> docs);

  /**
   * Remove a document from this store
   *
   * @param doc The title of the document to remove
   * @return Whether the document was successfully removed
   */
  boolean removeDocument(String doc);

  /**
   * Remove a list of documents in bulk from this store.
   *
   * @param docs The titles of each of the documents to do bulk removal of from
   * the store
   * @return Whether each document was removed successfully
   */
  List<Boolean> removeDocuments(List<String> docs);

  /**
   * Get a specific document by it's title
   *
   * @param doc The title of the document to retrieve
   * @return The document whose title matches the given one, or null if one
   * doesn't exist
   */
  Document getDocument(String doc);

  /**
   * Get multiple documents by their title
   *
   * @param doc The titles of each of the documents to get
   * @return A list of the documents
   */
  List<Document> getDocuments(List<String> doc);

  /**
   * Get all of the documents in this store
   *
   * @return A list of all the documents in this store
   */
  List<Document> getAllDocuments();

  /**
   * Get a searcher for searching through the documents
   *
   * @return A searcher keyed to this document store
   */
  Searcher getDocumentSearcher();

  /**
   * Flush the in-memory version of this document store to its backing store
   *
   * @return True if the flush was successful, false otherwise
   */
  boolean flush();

  /**
   * Refresh the in-memory contents of this store from its backing store.
   * WARNING: All changes since the last flush will be lost.
   *
   * @return True if the refresh succeeded, false otherwise
   */
  boolean refresh();

  /**
   * Clean all of the obsolete entries that may have accumulated in both this
   * store and its backing store
   *
   * @return Whether the cleaning succeeded.
   */
  boolean clean();
}
