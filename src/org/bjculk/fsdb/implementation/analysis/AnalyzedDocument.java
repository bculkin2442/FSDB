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
package org.bjculk.fsdb.implementation.analysis;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.bjculk.fsdb.interfaces.Document;

/**
 *
 * @author Benjamin
 */
public class AnalyzedDocument {

  private Document src;

  private Map<String, Integer> wordFreqs;

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 37 * hash + Objects.hashCode(this.src);
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
    final AnalyzedDocument other = (AnalyzedDocument) obj;
    if (!Objects.equals(this.src, other.src)) {
      return false;
    }
    return true;
  }

  public Document getSrc() {
    return src;
  }

  public void setSrc(Document src) {
    this.src = src;
  }

  public Map<String, Integer> getWordFreqs() {
    return wordFreqs;
  }

  public void setWordFreqs(Map<String, Integer> wordFreqs) {
    this.wordFreqs = wordFreqs;
  }

}
