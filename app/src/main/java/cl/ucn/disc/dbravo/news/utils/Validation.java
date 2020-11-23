/*
 * Copyright 2020 Diego Bravo B
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 *  and associated documentation files (the "Software"), to deal in the Software without
 *  restriction, including without limitation the rights to use, copy, modify, merge, publish,
 *  distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom
 *  the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 *  substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 *  BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 *  DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package cl.ucn.disc.dbravo.news.utils;

/**
 * The class for the validations of the News class attributes.
 *
 * @author Diego Bravo B
 */
public final class Validation {

    /**
     * This function checks if the size of a value complies the restrictions.
     *
     * @param value The value to check size.
     * @param minSize The minimum size that the value has to take.
     * @param message The error message.
     */
    public static void minSize(String value, int minSize, String message) {
        // Checks if the value given is null
        notNull(value, message);

        // Checks if the value have the minimum size
        if(value.length() > minSize) {
            throw new IllegalArgumentException("The argument was null or has the wrong size.");
        }

    }

    /**
     * This functions checks the nullity of a value.
     *
     * @param value The value to check nullity.
     * @param message The error message.
     */
    public static void notNull(Object value, String message) {
        if(value == null) {
            throw new IllegalArgumentException("The argument was null ->" + message);
        }
    }

}

