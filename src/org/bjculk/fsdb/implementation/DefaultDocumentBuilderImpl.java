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

import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bjculk.fsdb.interfaces.Document;
import org.bjculk.fsdb.interfaces.DocumentBuilder;

/**
 *
 * @author Benjamin
 */
class DefaultDocumentBuilderImpl implements DocumentBuilder {

  private DefaultDocument source;

  DefaultDocumentBuilderImpl() {
  }

  @Override
  public DocumentBuilder setTitle(String title) {
    source.setTitle(title);
    return this;
  }

  @Override
  public DocumentBuilder setMIMEType(String mimeType) {
    source.setMimeType(mimeType);
    return this;
  }

  @Override
  public DocumentBuilder setDescription(String description) {
    source.setDescription(description);
    return this;
  }

  @Override
  public DocumentBuilder setMetadata(String key, String value) {
    source.getMetadata().put(key, value);
    return this;
  }

  @Override
  public DocumentBuilder setBulkMetadata(Map<String, String> metadata) {
    source.getMetadata().putAll(metadata);
    return this;
  }

  @Override
  public Document getDocument(InputStream is) {
    try {
      DefaultDocument dd = (DefaultDocument) source.clone();
      dd.setContent(readContent(is));
      return dd;
    } catch (CloneNotSupportedException ex) {
      Logger.getLogger(DefaultDocumentBuilderImpl.class.getName()).log(Level.SEVERE, null, ex);
      return null;
    }
  }

  @Override
  public List<Document> getDocumentVolumes(List<InputStream> isl) {
    List<Document> docs = new ArrayList<>(isl.size());
    int i = 1;
    for (InputStream is : isl) {
      DefaultDocument dd = (DefaultDocument) getDocument(is);
      dd.setTitle(dd.getTitle() + ", Volume " + i);
      docs.add(dd);
      i++;
    }
    return docs;
  }

  @Override
  public void clear() {
    source = new DefaultDocument();
  }

  private List<String> readContent(InputStream is) {
    Scanner scn = new Scanner(is);
    List<String> cnt = new LinkedList<>();
    while (scn.hasNextLine()) {
      cnt.add(scn.nextLine());
    }
    return cnt;
  }

}
