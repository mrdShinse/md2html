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
import mrdshinse.md2html.combiner.HtmlCombiner;
import mrdshinse.md2html.combiner.HtmlCombinerImpl;
import mrdshinse.md2html.logger.LogHelper;
import mrdshinse.md2html.service.CombinerService;

/**
 * Implimentation class of {@link CombinerService}
 *
 * @author mrdShinse
 */
public class CombinerServicempl implements CombinerService {

    /**
     * Logger
     */
    private static final LogHelper LOG = new LogHelper(CombinerServicempl.class);

    private HtmlCombiner combiner;

    public CombinerServicempl() {
        this.combiner = new HtmlCombinerImpl();
    }

    @Override
    public void exe(File template, File add) {
        LOG.debug("");

        File result = combiner.combine(template, add);
        try {
            result.createNewFile();
        } catch (IOException ex) {
        }
    }
}
