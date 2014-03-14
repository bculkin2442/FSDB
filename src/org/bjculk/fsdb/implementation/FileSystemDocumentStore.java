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

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bjculk.fsdb.implementation.analysis.AnalyzedDocument;
import org.bjculk.fsdb.implementation.analysis.DocumentAnalyzer;
import org.bjculk.fsdb.interfaces.Document;
import org.bjculk.fsdb.interfaces.DocumentStore;
import org.bjculk.fsdb.interfaces.Searcher;

/**
 *
 * @author Benjamin
 */
class FileSystemDocumentStore implements DocumentStore {

  private final FileSystem root;

  private final Path rootDir;

  private final Set<String> titles;

  private final Map<String, AnalyzedDocument> docs;

  public FileSystemDocumentStore(String initString, Map<String, String> properties) {
    root = FileSystems.getDefault();
    rootDir = root.getPath(initString);
    titles = new HashSet<>();
    try {
      FSDBIOUtils.loadTitles(rootDir, titles);
    } catch (IOException ex) {
      Logger.getLogger(FileSystemDocumentStore.class.getName()).log(Level.SEVERE, "Could not read titles file", ex);
    }
    docs = new HashMap<>();
  }

  @Override
  public boolean storeDocument(Document doc) {
    if (titles.contains(doc.getTitle())) {
      return false;
    }
    docs.put(doc.getTitle(), DocumentAnalyzer.analyze(doc));
    return true;
  }

  @Override
  public List<Boolean> storeDocuments(List<Document> dl) {
    List<Boolean> bl = new ArrayList<>(dl.size());
    for (Document document : dl) {
      bl.add(storeDocument(document));
    }
    return bl;
  }

  @Override
  public boolean removeDocument(String doc) {
    if (docs.containsKey(doc)) {
      docs.remove(doc);
      return true;
    }
    return false;
  }

  @Override
  public List<Boolean> removeDocuments(List<String> dl) {
    List<Boolean> bl = new ArrayList<>(dl.size());
    for (String strang : dl) {
      bl.add(removeDocument(strang));
    }
    return bl;
  }

  @Override
  public Document getDocument(String title) {
    return docs.get(title).getSrc();
  }

  @Override
  public List<Document> getDocuments(List<String> titles) {
    List<Document> dl = new ArrayList<>(titles.size());
    for (String strang : titles) {
      dl.add(getDocument(strang));
    }
    return dl;
  }

  @Override
  public List<Document> getAllDocuments() {
    List<Document> dl = new ArrayList<>(docs.size());
    for (AnalyzedDocument analyzedDocument : docs.values()) {
      dl.add(analyzedDocument.getSrc());
    }
    return dl;
  }

  @Override
  public Searcher getDocumentSearcher() {
    return new DocumentSearcher();
  }

  @Override
  public boolean flush() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean refresh() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean clean() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
