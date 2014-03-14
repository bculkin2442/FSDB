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

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * A interface for documents representable as a list of strings with a
 * identifying MIME type.
 *
 * @author Benjamin
 */
public interface Document {

  /**
   * Get the MIME type of this document. May be a wildcard MIME type like
   * <pre>text/*</pre>.
   *
   * @return The MIME type of this document
   */
  String getMIMEType();

  /**
   * Get the title of this document
   *
   * @return The title of this document
   */
  String getTitle();

  /**
   * Get a description of the content of this document
   *
   * @return A description of the content of this document
   */
  String getDescription();

  /**
   * Get the content of this document as a list of strings.
   *
   * @return The content of this document as a list of strings
   */
  List<String> getContent();

  /**
   * Get the size of this document in characters.
   *
   * @return The size of this document in characters
   */
  int getSize();

  /**
   * Get any metadata associated with this document.
   *
   * @return The metadata associated with this document.
   */
  Map<String, String> getMetadata();
}
