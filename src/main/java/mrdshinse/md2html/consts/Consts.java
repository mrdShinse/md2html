package mrdshinse.md2html.consts;

/*
 * The MIT License
 *
 * Copyright 2016 mrdShinse.
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
import java.io.File;

/**
 * Const class of md2html.
 *
 * @author mrdShinse
 */
public interface Consts {

    /**
     * Running directory.
     */
    final String CURRENT_DIR = System.getProperty("user.dir");
    /**
     * Path separator that don't depend on execution environment.
     */
    final String DELIMITER = File.separator;

    /**
     * Directory path for putting data.
     */
    final String DATA_DIR = CURRENT_DIR + DELIMITER + "data";
    /**
     * Directory path for putting temporary files.
     */
    final String TMP_DIR = DATA_DIR + DELIMITER + "tmp";
    /**
     * Directory path for putting markdown files.
     */
    final String MARKDOWN_DIR = DATA_DIR + DELIMITER + "markdown";
    /**
     * Directory path for putting template HTML files.
     */
    final String TEMPLATE_DIR = DATA_DIR + DELIMITER + "template";
    /**
     * Directory path for putting processed result files.
     */
    final String RESULT_DIR = DATA_DIR + DELIMITER + "result";

    /**
     * Extention of markdown files.
     */
    final String EXTENTION_MARKDOWN = ".md";
    /**
     * Extention of html files.
     */
    final String EXTENTION_HTML = ".html";
}
