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
package mrdshinse.doc_tool.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import mrdshinse.doc_tool.logger.LogHelper;
import org.apache.commons.io.FileUtils;

/**
 * Utility class of File Class.
 *
 * @author mrdShinse
 */
public class FileUtil {

    /**
     * Logger
     */
    private static final LogHelper LOG = new LogHelper(FileUtil.class);

    /**
     * Get file content by String.
     *
     * @param file file
     * @return file content
     */
    public static String toString(File file) {

        try {
            return FileUtils.readFileToString(file);
        } catch (IOException ex) {
            LOG.error(ex);
            return "";
        }
    }

    /**
     * Create file by String.
     *
     * @param file File class for output file.
     * @param str file content
     * @return Processed file
     */
    public static File create(File file, String str) {

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
            pw.print(str);
        } catch (IOException ex) {
            LOG.error(ex);
            return file;
        }
        return file;
    }

    /**
     * Get file name without extention.<br/>
     * The dot(.) before extention will remove.
     *
     * @param file file
     * @return file name without extention
     */
    public static String getNoExtName(File file) {
        if (file == null) {
            LOG.warn("getNoExtName(): get null argument. Returned empty String.");
            return "";
        }

        String fileName = file.getName();
        String retStr = fileName.substring(0, fileName.lastIndexOf("."));
        return retStr;
    }

}
