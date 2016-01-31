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
package mrdshinse.doc_tool.converter;

import java.io.File;
import mrdshinse.doc_tool.consts.Consts;
import mrdshinse.doc_tool.logger.LogHelper;
import mrdshinse.doc_tool.util.FileUtil;
import org.markdownj.MarkdownProcessor;

/**
 *
 * @author mrdShinse
 */
public class MarkdownConverterImpl implements MarkdownConverter {

    /**
     * Logger
     */
    private static final LogHelper LOG = new LogHelper(MarkdownConverterImpl.class);

    @Override
    public File convert(File file) {
        if (file == null) {
            LOG.warn("convert(): get null argument. Returned original argument.");
            return file;
        }
        MarkdownProcessor processor = new MarkdownProcessor();
        String html = processor.markdown(FileUtil.toString(file));
        File retFile = new File(Consts.TMP_DIR + Consts.DELIMITER + FileUtil.getNoExtName(file) + Consts.EXTENTION_HTML);
        FileUtil.create(retFile, html);
        return retFile;
    }

}
