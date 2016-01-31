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

/**
 * Class for create log message.
 *
 * @author mrdShinse
 */
public class LogMessanger {

    /**
     * When log message is null, this value use.
     */
    protected static final String NULL_VALUE = "null";

    /**
     * The delimiter for log message.
     */
    protected static final String DELIMITER = "\"";

    /**
     * Create message for trace log.
     *
     * @param message original message
     * @return processed message
     */
    protected String trace(Object message) {
        return this.createMessage(message);
    }

    /**
     * Create message for debug log.
     *
     * @param message original message
     * @return processed message
     */
    protected String debug(Object message) {
        return this.createMessage(message);
    }

    /**
     * Create message for info log.
     *
     * @param message original message
     * @return processed message
     */
    protected String info(Object message) {
        return this.createMessage(message);
    }

    /**
     * Create message for warn log.
     *
     * @param message original message
     * @return processed message
     */
    protected String warn(Object message) {
        return this.createMessage(message);
    }

    /**
     * Create message for error log.
     *
     * @param message original message
     * @return processed message
     */
    protected String error(Object message) {
        return this.createMessage(message);
    }

    /**
     * Create message for fatal log.
     *
     * @param message original message
     * @return processed message
     */
    protected String fatal(Object message) {
        return this.createMessage(message);
    }

    /**
     * Create message.
     *
     * @param message original message
     * @return processed message
     */
    private String createMessage(Object message) {

        StringBuilder sb = new StringBuilder();

        if (message != null) {
            sb.append(DELIMITER).append(message).append(DELIMITER);
        } else {
            sb.append(NULL_VALUE);
        }
        return sb.toString();
    }
}
