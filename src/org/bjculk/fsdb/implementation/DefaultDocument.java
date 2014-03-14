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
package org.bjculk.fsdb.implementation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.bjculk.fsdb.interfaces.Document;

/**
 *
 * @author Benjamin
 */
class DefaultDocument implements Document, Cloneable {

  private String mimeType;
  private String title;
  private String description;
  private List<String> content;
  private int size;
  private Map<String, String> metadata;

  @Override
  public String getMIMEType() {
    return mimeType;
  }

  @Override
  public String getTitle() {
    return title;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public List<String> getContent() {
    return content;
  }

  @Override
  public int getSize() {
    if (size == -1) {
      size = 0;
      for (String strang : content) {
        size += strang.length();
      }
    }
    return size;
  }

  @Override
  public Map<String, String> getMetadata() {
    return metadata;
  }

  DefaultDocument(String mimeType, String title, String description, List<String> content, int size, Map<String, String> metadata) {
    this.mimeType = mimeType;
    this.title = title;
    this.description = description;
    this.content = content;
    this.size = size;
    this.metadata = metadata;
  }

  DefaultDocument() {
  }

  void setMimeType(String mimeType) {
    this.mimeType = mimeType;
  }

  void setTitle(String title) {
    this.title = title;
  }

  void setDescription(String description) {
    this.description = description;
  }

  void setContent(List<String> content) {
    this.content = content;
  }

  void setSize(int size) {
    this.size = size;
  }

  void setMetadata(Map<String, String> metadata) {
    this.metadata = metadata;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 73 * hash + Objects.hashCode(this.title);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final DefaultDocument other = (DefaultDocument) obj;
    if (!Objects.equals(this.mimeType, other.mimeType)) {
      return false;
    }
    if (!Objects.equals(this.title, other.title)) {
      return false;
    }
    return this.size == other.size;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    super.clone();
    DefaultDocument dd = new DefaultDocument();
    dd.content = new LinkedList<>(content);
    dd.description = description;
    dd.metadata = new HashMap<>(metadata);
    dd.mimeType = mimeType;
    dd.size = size;
    dd.title = title;
    return dd;
  }

}
