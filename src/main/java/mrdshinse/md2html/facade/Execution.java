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
package mrdshinse.md2html.facade;

import java.io.File;
import mrdshinse.md2html.consts.Consts;
import mrdshinse.md2html.logger.LogHelper;
import mrdshinse.md2html.service.CombertService;
import mrdshinse.md2html.service.CombinerService;
import mrdshinse.md2html.service.FinishingService;
import mrdshinse.md2html.service.InitializeService;
import mrdshinse.md2html.service.impl.CombertServiceImpl;
import mrdshinse.md2html.service.impl.CombinerServicempl;
import mrdshinse.md2html.service.impl.FinishingServiceImpl;
import mrdshinse.md2html.service.impl.InitializeServiceImpl;
import mrdshinse.md2html.util.FileUtil;

/**
 * Facade class of execution command.
 *
 * @author mrdShinse
 */
public class Execution implements Facade {

    /**
     * Logger
     */
    private static final LogHelper LOG = new LogHelper(CombertServiceImpl.class);

    private final InitializeService INIT;
    private final CombertService COMBERT;
    private final CombinerService COMBINE;
    private final FinishingService FINISH;

    public Execution() {
        this.INIT = new InitializeServiceImpl();
        this.COMBERT = new CombertServiceImpl();
        this.COMBINE = new CombinerServicempl();
        this.FINISH = new FinishingServiceImpl();
    }

    @Override
    public void exe() {
        INIT.exe();

        File[] mds = new File(Consts.MARKDOWN_DIR).listFiles((File f) -> f.isFile() && f.getName().endsWith(Consts.EXTENTION_MARKDOWN)
        );
        File template = new File(Consts.TEMPLATE_DIR + Consts.DELIMITER + "template.html");

        for (File md : mds) {
            COMBERT.exe(md);
            COMBINE.exe(template, new File(Consts.TMP_DIR + Consts.DELIMITER + FileUtil.getNoExtName(md) + Consts.EXTENTION_HTML));
        }
        FINISH.exe();
    }

}
