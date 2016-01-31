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
package mrdshinse.md2html.logger;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Logger class for md2html.
 *
 * @author mrdShinse
 */
public class LogHelper {

    /**
     * Actual logger class.
     */
    private Logger logger;

    /**
     * Class for create log message.
     */
    private LogMessanger messanger;

    /**
     * Default constructor.
     */
    private LogHelper() {
        this.messanger = new LogMessanger();
    }

    /**
     * Constractor<br/>
     * Create logger by class name.
     *
     * @param clazz class Class
     */
    public LogHelper(Class clazz) {
        this();
        this.logger = LogManager.getLogger(clazz);
    }

    /**
     * Constractor<br/>
     * Create logger by name of the argument.
     *
     * @param name name of logger
     */
    public LogHelper(String name) {
        this();
        this.logger = LogManager.getLogger(name);
    }

    /**
     * Getter method of logger.
     *
     * @return actual logger
     */
    public Logger getLogger() {
        return this.logger;
    }

    /**
     * Output trace log.
     *
     * @param message Message to use to log.
     */
    public void trace(Object message) {
        if (this.isEnabled(Level.TRACE)) {
            logger.trace(messanger.trace(message));
        }
    }

    /**
     * Output debug log.
     *
     * @param message Message to use to log.
     */
    public void debug(Object message) {
        if (this.isEnabled(Level.DEBUG)) {
            logger.debug(messanger.debug(message));
        }
    }

    /**
     * Output info log.
     *
     * @param message Message to use to log.
     */
    public void info(Object message) {
        if (this.isEnabled(Level.INFO)) {
            logger.info(messanger.info(message));
        }
    }

    /**
     * Output warn log.
     *
     * @param message Message to use to log.
     */
    public void warn(Object message) {
        if (this.isEnabled(Level.WARN)) {
            logger.warn(messanger.warn(message));
        }
    }

    /**
     * Output debug log.
     *
     * @param message Message to use to log.
     */
    public void error(Object message) {
        if (this.isEnabled(Level.ERROR)) {
            logger.error(messanger.error(message));
        }
    }

    /**
     * Output fatal log.
     *
     * @param message Message to use to log.
     */
    public void fatal(Object message) {
        if (this.isEnabled(Level.FATAL)) {
            logger.fatal(messanger.fatal(message));
        }
    }

    /**
     * Judge whether log level of the argument enable.
     *
     * @return <code>true</code>:enable
     */
    private boolean isEnabled(Level lv) {
        return logger.isEnabled(lv);
    }
}
