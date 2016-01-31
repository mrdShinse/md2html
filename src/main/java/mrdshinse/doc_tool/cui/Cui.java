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
package mrdshinse.doc_tool.cui;

import java.io.File;
import mrdshinse.doc_tool.consts.Consts;
import mrdshinse.doc_tool.service.CombertService;
import mrdshinse.doc_tool.service.CombinerService;
import mrdshinse.doc_tool.service.FinishingService;
import mrdshinse.doc_tool.service.InitializeService;
import mrdshinse.doc_tool.service.impl.CombertServiceImpl;
import mrdshinse.doc_tool.service.impl.CombinerServicempl;
import mrdshinse.doc_tool.service.impl.FinishingServiceImpl;
import mrdshinse.doc_tool.service.impl.InitializeServiceImpl;
import mrdshinse.doc_tool.util.FileUtil;

/**
 *
 * @author mrdShinse
 */
public class Cui {

    private final InitializeService INIT;
    private final CombertService COMBERT;
    private final CombinerService COMBINE;
    private final FinishingService FINISH;

    public static void main(String[] args) {
        new Cui().exe(args);
    }

    public Cui() {
        this.INIT = new InitializeServiceImpl();
        this.COMBERT = new CombertServiceImpl();
        this.COMBINE = new CombinerServicempl();
        this.FINISH = new FinishingServiceImpl();
    }

    /**
     * execute tool.
     *
     * @param args
     */
    public void exe(String[] args) {
        INIT.exe();

        File sampleMd = new File(Consts.CURRENT_DIR + File.separator + "sample" + File.separator + "test.md");
        COMBERT.exe(sampleMd);
        File template = new File(Consts.CURRENT_DIR + File.separator + "sample" + File.separator + "test_template.html");
        COMBINE.exe(template, new File(Consts.TMP_DIR + Consts.DELIMITER + FileUtil.getNoExtName(sampleMd) + Consts.EXTENTION_HTML));

        FINISH.exe();
    }
}
