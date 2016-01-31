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
import mrdshinse.md2html.util.FileUtil;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author mrdShinse
 */
public class TestExecution {

    @Before
    public void initialize() {
        cleanBase();

        File testMd = new File(Consts.MARKDOWN_DIR + Consts.DELIMITER + "test.md");
        FileUtil.create(testMd, "This is *sample* text.");

        File testTemp = new File(Consts.TEMPLATE_DIR + Consts.DELIMITER + "template.html");
        String template = "<!DOCTYPE html>\n<head>\n<title>Page Title</title>\n</head>\n<body>\n</body>\n";
        FileUtil.create(testTemp, template);
    }

    @After
    public void finish() {
        cleanBase();
    }

    @Test
    public void exe() {
        new Execution().exe();

        Assert.assertThat(
                FileUtil.toString(new File(Consts.RESULT_DIR + Consts.DELIMITER + "test.html")),
                CoreMatchers.containsString("<p>This is <em>sample</em> text.</p>")
        );
    }

    private void cleanBase() {
        File basedir = new File(Consts.DATA_DIR);
        if (basedir.exists()) {
            basedir.delete();
        }
        basedir.mkdirs();

        new File(Consts.MARKDOWN_DIR).mkdirs();
        new File(Consts.TMP_DIR).mkdirs();
        new File(Consts.TEMPLATE_DIR).mkdirs();
        new File(Consts.RESULT_DIR).mkdirs();
    }
}
