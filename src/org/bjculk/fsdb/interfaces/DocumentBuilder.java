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

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Build a document in an easy to use way
 *
 * @author Benjamin
 */
public interface DocumentBuilder {

  /**
   * Set the title of the current document in production
   *
   * @param title The title to use for the current document
   * @return this, for chaining purposes
   */
  DocumentBuilder setTitle(String title);

  /**
   * Set the MIME type of the current document in production
   *
   * @param mimeType The MIME type to use for the current document
   * @return this, for chaining purposes
   */
  DocumentBuilder setMIMEType(String mimeType);

  /**
   * Set the description of the current document in production
   *
   * @param description The description to use for the cuurrent document
   * @return this, for chaining purposes
   */
  DocumentBuilder setDescription(String description);

  /**
   * Add a metadata property to the current document in production
   *
   * @param key The key of the metadata property being added to the current
   * document
   * @param value The value of the metadata property being added to the current
   * document
   * @return this, for chaining purposes
   */
  DocumentBuilder setMetadata(String key, String value);

  /**
   * Add a large number of metadata properties to the current document in
   * production
   *
   * @param metadata A bulk map of metadata properties to add
   * @return this, for chaining purposes
   */
  DocumentBuilder setBulkMetadata(Map<String, String> metadata);

  /**
   * Create a document using the current settings
   *
   * @param is The source for the content of the document
   * @return The newly formed document
   */
  Document getDocument(InputStream is);

  /**
   * Create a list of documents that belong to a single series.
   *
   * Example: Take a series of documents "Tales of Fantasy" that has four
   * volumes. This method will produce a list of documents with titles in the
   * vein of "Tales of Fantasy Volume x", where x is the volume number
   * (One-based). It will also add a metadata property "volume" to each one with
   * the value set as the volume number (One-based).
   *
   * @param isl The list of documents that form the set of volumes
   * @return A list of documents, one for each volume
   */
  List<Document> getDocumentVolumes(List<InputStream> isl);

  /**
   * Switch the current document in production to a new one
   */
  void clear();
}
