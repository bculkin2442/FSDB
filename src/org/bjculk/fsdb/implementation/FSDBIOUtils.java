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

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

/**
 *
 * @author Benjamin
 */
public class FSDBIOUtils {

  public static void loadTitles(Path rootDir, Set<String> container) throws IOException {
    Path coreFolder = rootDir.resolve("core");
    if (Files.isDirectory(coreFolder)) {
      Path titleFile = coreFolder.resolve("titles.txt");
      if (Files.isRegularFile(titleFile)) {
        doLoadTitles(Files.newBufferedReader(rootDir, Charset.defaultCharset()), container);
      }
    }
  }

  private static void doLoadTitles(BufferedReader buf, Set<String> container) throws IOException {
    while (buf.ready()) {
      container.add(buf.readLine());
    }
  }
}
