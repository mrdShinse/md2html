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
package mrdshinse.doc_tool.combiner;

import java.io.File;
import java.io.IOException;
import mrdshinse.doc_tool.consts.Consts;
import mrdshinse.doc_tool.logger.LogHelper;
import mrdshinse.doc_tool.util.FileUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author mrdShinse
 */
public class HtmlCombinerImpl implements HtmlCombiner {

    /**
     * Logger
     */
    private static final LogHelper LOG = new LogHelper(HtmlCombinerImpl.class);

    @Override
    public File combine(File base, File add) {
        Document doc = null;

        try {
            doc = Jsoup.parse(base, "UTF-8");
        } catch (IOException ex) {
            LOG.error(ex);
        }

        if (doc == null) {
            LOG.warn("combine(): get null argument. Returned empty File.");
            return new File("");
        }
        Element el = doc.body();
        el.append(FileUtil.toString(add));
        return FileUtil.create(new File(Consts.RESULT_DIR + Consts.DELIMITER + FileUtil.getNoExtName(add) + Consts.EXTENTION_HTML), doc.html());
    }

}
