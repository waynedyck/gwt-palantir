/*
 * Copyright 2016 Wayne Dyck
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.imaginedreal.gwt.palantir.client.util;

public class ParserUtils {

    /**
     * 
     * @param text
     * @param max
     * @return
     */
    public static String ellipsis(String text, int max) {
        if (text.length() <= max) {
            return text;
        }

        int end = text.lastIndexOf(' ', max - 1); // Chop at last word.

        return text.substring(0, end) + "...";
    }
}
