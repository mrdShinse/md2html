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
package mrdshinse.md2html.service.impl;

import java.io.File;
import java.io.IOException;
import mrdshinse.md2html.converter.MarkdownConverter;
import mrdshinse.md2html.converter.MarkdownConverterImpl;
import mrdshinse.md2html.logger.LogHelper;
import mrdshinse.md2html.service.CombertService;

/**
 * Implimentation class of {@link CombertService}
 *
 * @author mrdShinse
 */
public class CombertServiceImpl implements CombertService {

    /**
     * Logger
     */
    private static final LogHelper LOG = new LogHelper(CombertServiceImpl.class);

    private MarkdownConverter converter;

    public CombertServiceImpl() {
        this.converter = new MarkdownConverterImpl();
    }

    @Override
    public void exe(File file) {
        LOG.debug("");

        File result = converter.convert(file);
        try {
            result.createNewFile();
        } catch (IOException ex) {
        }
    }
}
