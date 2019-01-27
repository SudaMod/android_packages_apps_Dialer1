/*
 * Copyright (C) 2019 The MoKee Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.dialer.smartdial.map;

import android.content.Context;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;

import com.android.dialer.dialpadview.DialpadCharMappings;
import com.android.dialer.smartdial.util.SmartDialMatchPosition;
import com.android.dialer.smartdial.util.SmartDialNameMatcher;
import com.android.providers.contacts.HanziToPinyin;
import com.google.common.base.Optional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ChineseSmartDialMap extends SmartDialMap {

    private static ChineseSmartDialMap instance;

    static ChineseSmartDialMap getInstance() {
        if (instance == null) {
            instance = new ChineseSmartDialMap();
        }

        return instance;
    }

    private ChineseSmartDialMap() {}

    /*
     * The switch statement in this function was generated using the python code:
     * from unidecode import unidecode
     * for i in range(192, 564):
     *     char = unichr(i)
     *     decoded = unidecode(char)
     *     # Unicode characters that decompose into multiple characters i.e.
     *     #  into ss are not supported for now
     *     if (len(decoded) == 1 and decoded.isalpha()):
     *         print "case '" + char + "': return Optional.of('" + unidecode(char) +  "');"
     *
     * This gives us a way to map characters containing accents/diacritics to their
     * alphabetic equivalents. The unidecode library can be found at:
     * http://pypi.python.org/pypi/Unidecode/0.04.1
     *
     * Also remaps all upper case latin characters to their lower case equivalents.
     */
    @Override
    Optional<Character> normalizeCharacter(char ch) {
        if (isValidDialpadAlphabeticChar(ch)) {
            return Optional.of(ch);
        }

        switch (ch) {
            case 'À':
                return Optional.of('a');
            case 'Á':
                return Optional.of('a');
            case 'Â':
                return Optional.of('a');
            case 'Ã':
                return Optional.of('a');
            case 'Ä':
                return Optional.of('a');
            case 'Å':
                return Optional.of('a');
            case 'Ç':
                return Optional.of('c');
            case 'È':
                return Optional.of('e');
            case 'É':
                return Optional.of('e');
            case 'Ê':
                return Optional.of('e');
            case 'Ë':
                return Optional.of('e');
            case 'Ì':
                return Optional.of('i');
            case 'Í':
                return Optional.of('i');
            case 'Î':
                return Optional.of('i');
            case 'Ï':
                return Optional.of('i');
            case 'Ð':
                return Optional.of('d');
            case 'Ñ':
                return Optional.of('n');
            case 'Ò':
                return Optional.of('o');
            case 'Ó':
                return Optional.of('o');
            case 'Ô':
                return Optional.of('o');
            case 'Õ':
                return Optional.of('o');
            case 'Ö':
                return Optional.of('o');
            case '×':
                return Optional.of('x');
            case 'Ø':
                return Optional.of('o');
            case 'Ù':
                return Optional.of('u');
            case 'Ú':
                return Optional.of('u');
            case 'Û':
                return Optional.of('u');
            case 'Ü':
                return Optional.of('u');
            case 'Ý':
                return Optional.of('u');
            case 'à':
                return Optional.of('a');
            case 'á':
                return Optional.of('a');
            case 'â':
                return Optional.of('a');
            case 'ã':
                return Optional.of('a');
            case 'ä':
                return Optional.of('a');
            case 'å':
                return Optional.of('a');
            case 'ç':
                return Optional.of('c');
            case 'è':
                return Optional.of('e');
            case 'é':
                return Optional.of('e');
            case 'ê':
                return Optional.of('e');
            case 'ë':
                return Optional.of('e');
            case 'ì':
                return Optional.of('i');
            case 'í':
                return Optional.of('i');
            case 'î':
                return Optional.of('i');
            case 'ï':
                return Optional.of('i');
            case 'ð':
                return Optional.of('d');
            case 'ñ':
                return Optional.of('n');
            case 'ò':
                return Optional.of('o');
            case 'ó':
                return Optional.of('o');
            case 'ô':
                return Optional.of('o');
            case 'õ':
                return Optional.of('o');
            case 'ö':
                return Optional.of('o');
            case 'ø':
                return Optional.of('o');
            case 'ù':
                return Optional.of('u');
            case 'ú':
                return Optional.of('u');
            case 'û':
                return Optional.of('u');
            case 'ü':
                return Optional.of('u');
            case 'ý':
                return Optional.of('y');
            case 'ÿ':
                return Optional.of('y');
            case 'Ā':
                return Optional.of('a');
            case 'ā':
                return Optional.of('a');
            case 'Ă':
                return Optional.of('a');
            case 'ă':
                return Optional.of('a');
            case 'Ą':
                return Optional.of('a');
            case 'ą':
                return Optional.of('a');
            case 'Ć':
                return Optional.of('c');
            case 'ć':
                return Optional.of('c');
            case 'Ĉ':
                return Optional.of('c');
            case 'ĉ':
                return Optional.of('c');
            case 'Ċ':
                return Optional.of('c');
            case 'ċ':
                return Optional.of('c');
            case 'Č':
                return Optional.of('c');
            case 'č':
                return Optional.of('c');
            case 'Ď':
                return Optional.of('d');
            case 'ď':
                return Optional.of('d');
            case 'Đ':
                return Optional.of('d');
            case 'đ':
                return Optional.of('d');
            case 'Ē':
                return Optional.of('e');
            case 'ē':
                return Optional.of('e');
            case 'Ĕ':
                return Optional.of('e');
            case 'ĕ':
                return Optional.of('e');
            case 'Ė':
                return Optional.of('e');
            case 'ė':
                return Optional.of('e');
            case 'Ę':
                return Optional.of('e');
            case 'ę':
                return Optional.of('e');
            case 'Ě':
                return Optional.of('e');
            case 'ě':
                return Optional.of('e');
            case 'Ĝ':
                return Optional.of('g');
            case 'ĝ':
                return Optional.of('g');
            case 'Ğ':
                return Optional.of('g');
            case 'ğ':
                return Optional.of('g');
            case 'Ġ':
                return Optional.of('g');
            case 'ġ':
                return Optional.of('g');
            case 'Ģ':
                return Optional.of('g');
            case 'ģ':
                return Optional.of('g');
            case 'Ĥ':
                return Optional.of('h');
            case 'ĥ':
                return Optional.of('h');
            case 'Ħ':
                return Optional.of('h');
            case 'ħ':
                return Optional.of('h');
            case 'Ĩ':
                return Optional.of('i');
            case 'ĩ':
                return Optional.of('i');
            case 'Ī':
                return Optional.of('i');
            case 'ī':
                return Optional.of('i');
            case 'Ĭ':
                return Optional.of('i');
            case 'ĭ':
                return Optional.of('i');
            case 'Į':
                return Optional.of('i');
            case 'į':
                return Optional.of('i');
            case 'İ':
                return Optional.of('i');
            case 'ı':
                return Optional.of('i');
            case 'Ĵ':
                return Optional.of('j');
            case 'ĵ':
                return Optional.of('j');
            case 'Ķ':
                return Optional.of('k');
            case 'ķ':
                return Optional.of('k');
            case 'ĸ':
                return Optional.of('k');
            case 'Ĺ':
                return Optional.of('l');
            case 'ĺ':
                return Optional.of('l');
            case 'Ļ':
                return Optional.of('l');
            case 'ļ':
                return Optional.of('l');
            case 'Ľ':
                return Optional.of('l');
            case 'ľ':
                return Optional.of('l');
            case 'Ŀ':
                return Optional.of('l');
            case 'ŀ':
                return Optional.of('l');
            case 'Ł':
                return Optional.of('l');
            case 'ł':
                return Optional.of('l');
            case 'Ń':
                return Optional.of('n');
            case 'ń':
                return Optional.of('n');
            case 'Ņ':
                return Optional.of('n');
            case 'ņ':
                return Optional.of('n');
            case 'Ň':
                return Optional.of('n');
            case 'ň':
                return Optional.of('n');
            case 'Ō':
                return Optional.of('o');
            case 'ō':
                return Optional.of('o');
            case 'Ŏ':
                return Optional.of('o');
            case 'ŏ':
                return Optional.of('o');
            case 'Ő':
                return Optional.of('o');
            case 'ő':
                return Optional.of('o');
            case 'Ŕ':
                return Optional.of('r');
            case 'ŕ':
                return Optional.of('r');
            case 'Ŗ':
                return Optional.of('r');
            case 'ŗ':
                return Optional.of('r');
            case 'Ř':
                return Optional.of('r');
            case 'ř':
                return Optional.of('r');
            case 'Ś':
                return Optional.of('s');
            case 'ś':
                return Optional.of('s');
            case 'Ŝ':
                return Optional.of('s');
            case 'ŝ':
                return Optional.of('s');
            case 'Ş':
                return Optional.of('s');
            case 'ş':
                return Optional.of('s');
            case 'Š':
                return Optional.of('s');
            case 'š':
                return Optional.of('s');
            case 'Ţ':
                return Optional.of('t');
            case 'ţ':
                return Optional.of('t');
            case 'Ť':
                return Optional.of('t');
            case 'ť':
                return Optional.of('t');
            case 'Ŧ':
                return Optional.of('t');
            case 'ŧ':
                return Optional.of('t');
            case 'Ũ':
                return Optional.of('u');
            case 'ũ':
                return Optional.of('u');
            case 'Ū':
                return Optional.of('u');
            case 'ū':
                return Optional.of('u');
            case 'Ŭ':
                return Optional.of('u');
            case 'ŭ':
                return Optional.of('u');
            case 'Ů':
                return Optional.of('u');
            case 'ů':
                return Optional.of('u');
            case 'Ű':
                return Optional.of('u');
            case 'ű':
                return Optional.of('u');
            case 'Ų':
                return Optional.of('u');
            case 'ų':
                return Optional.of('u');
            case 'Ŵ':
                return Optional.of('w');
            case 'ŵ':
                return Optional.of('w');
            case 'Ŷ':
                return Optional.of('y');
            case 'ŷ':
                return Optional.of('y');
            case 'Ÿ':
                return Optional.of('y');
            case 'Ź':
                return Optional.of('z');
            case 'ź':
                return Optional.of('z');
            case 'Ż':
                return Optional.of('z');
            case 'ż':
                return Optional.of('z');
            case 'Ž':
                return Optional.of('z');
            case 'ž':
                return Optional.of('z');
            case 'ſ':
                return Optional.of('s');
            case 'ƀ':
                return Optional.of('b');
            case 'Ɓ':
                return Optional.of('b');
            case 'Ƃ':
                return Optional.of('b');
            case 'ƃ':
                return Optional.of('b');
            case 'Ɔ':
                return Optional.of('o');
            case 'Ƈ':
                return Optional.of('c');
            case 'ƈ':
                return Optional.of('c');
            case 'Ɖ':
                return Optional.of('d');
            case 'Ɗ':
                return Optional.of('d');
            case 'Ƌ':
                return Optional.of('d');
            case 'ƌ':
                return Optional.of('d');
            case 'ƍ':
                return Optional.of('d');
            case 'Ɛ':
                return Optional.of('e');
            case 'Ƒ':
                return Optional.of('f');
            case 'ƒ':
                return Optional.of('f');
            case 'Ɠ':
                return Optional.of('g');
            case 'Ɣ':
                return Optional.of('g');
            case 'Ɩ':
                return Optional.of('i');
            case 'Ɨ':
                return Optional.of('i');
            case 'Ƙ':
                return Optional.of('k');
            case 'ƙ':
                return Optional.of('k');
            case 'ƚ':
                return Optional.of('l');
            case 'ƛ':
                return Optional.of('l');
            case 'Ɯ':
                return Optional.of('w');
            case 'Ɲ':
                return Optional.of('n');
            case 'ƞ':
                return Optional.of('n');
            case 'Ɵ':
                return Optional.of('o');
            case 'Ơ':
                return Optional.of('o');
            case 'ơ':
                return Optional.of('o');
            case 'Ƥ':
                return Optional.of('p');
            case 'ƥ':
                return Optional.of('p');
            case 'ƫ':
                return Optional.of('t');
            case 'Ƭ':
                return Optional.of('t');
            case 'ƭ':
                return Optional.of('t');
            case 'Ʈ':
                return Optional.of('t');
            case 'Ư':
                return Optional.of('u');
            case 'ư':
                return Optional.of('u');
            case 'Ʊ':
                return Optional.of('y');
            case 'Ʋ':
                return Optional.of('v');
            case 'Ƴ':
                return Optional.of('y');
            case 'ƴ':
                return Optional.of('y');
            case 'Ƶ':
                return Optional.of('z');
            case 'ƶ':
                return Optional.of('z');
            case 'ƿ':
                return Optional.of('w');
            case 'Ǎ':
                return Optional.of('a');
            case 'ǎ':
                return Optional.of('a');
            case 'Ǐ':
                return Optional.of('i');
            case 'ǐ':
                return Optional.of('i');
            case 'Ǒ':
                return Optional.of('o');
            case 'ǒ':
                return Optional.of('o');
            case 'Ǔ':
                return Optional.of('u');
            case 'ǔ':
                return Optional.of('u');
            case 'Ǖ':
                return Optional.of('u');
            case 'ǖ':
                return Optional.of('u');
            case 'Ǘ':
                return Optional.of('u');
            case 'ǘ':
                return Optional.of('u');
            case 'Ǚ':
                return Optional.of('u');
            case 'ǚ':
                return Optional.of('u');
            case 'Ǜ':
                return Optional.of('u');
            case 'ǜ':
                return Optional.of('u');
            case 'Ǟ':
                return Optional.of('a');
            case 'ǟ':
                return Optional.of('a');
            case 'Ǡ':
                return Optional.of('a');
            case 'ǡ':
                return Optional.of('a');
            case 'Ǥ':
                return Optional.of('g');
            case 'ǥ':
                return Optional.of('g');
            case 'Ǧ':
                return Optional.of('g');
            case 'ǧ':
                return Optional.of('g');
            case 'Ǩ':
                return Optional.of('k');
            case 'ǩ':
                return Optional.of('k');
            case 'Ǫ':
                return Optional.of('o');
            case 'ǫ':
                return Optional.of('o');
            case 'Ǭ':
                return Optional.of('o');
            case 'ǭ':
                return Optional.of('o');
            case 'ǰ':
                return Optional.of('j');
            case 'ǲ':
                return Optional.of('d');
            case 'Ǵ':
                return Optional.of('g');
            case 'ǵ':
                return Optional.of('g');
            case 'Ƿ':
                return Optional.of('w');
            case 'Ǹ':
                return Optional.of('n');
            case 'ǹ':
                return Optional.of('n');
            case 'Ǻ':
                return Optional.of('a');
            case 'ǻ':
                return Optional.of('a');
            case 'Ǿ':
                return Optional.of('o');
            case 'ǿ':
                return Optional.of('o');
            case 'Ȁ':
                return Optional.of('a');
            case 'ȁ':
                return Optional.of('a');
            case 'Ȃ':
                return Optional.of('a');
            case 'ȃ':
                return Optional.of('a');
            case 'Ȅ':
                return Optional.of('e');
            case 'ȅ':
                return Optional.of('e');
            case 'Ȇ':
                return Optional.of('e');
            case 'ȇ':
                return Optional.of('e');
            case 'Ȉ':
                return Optional.of('i');
            case 'ȉ':
                return Optional.of('i');
            case 'Ȋ':
                return Optional.of('i');
            case 'ȋ':
                return Optional.of('i');
            case 'Ȍ':
                return Optional.of('o');
            case 'ȍ':
                return Optional.of('o');
            case 'Ȏ':
                return Optional.of('o');
            case 'ȏ':
                return Optional.of('o');
            case 'Ȑ':
                return Optional.of('r');
            case 'ȑ':
                return Optional.of('r');
            case 'Ȓ':
                return Optional.of('r');
            case 'ȓ':
                return Optional.of('r');
            case 'Ȕ':
                return Optional.of('u');
            case 'ȕ':
                return Optional.of('u');
            case 'Ȗ':
                return Optional.of('u');
            case 'ȗ':
                return Optional.of('u');
            case 'Ș':
                return Optional.of('s');
            case 'ș':
                return Optional.of('s');
            case 'Ț':
                return Optional.of('t');
            case 'ț':
                return Optional.of('t');
            case 'Ȝ':
                return Optional.of('y');
            case 'ȝ':
                return Optional.of('y');
            case 'Ȟ':
                return Optional.of('h');
            case 'ȟ':
                return Optional.of('h');
            case 'Ȥ':
                return Optional.of('z');
            case 'ȥ':
                return Optional.of('z');
            case 'Ȧ':
                return Optional.of('a');
            case 'ȧ':
                return Optional.of('a');
            case 'Ȩ':
                return Optional.of('e');
            case 'ȩ':
                return Optional.of('e');
            case 'Ȫ':
                return Optional.of('o');
            case 'ȫ':
                return Optional.of('o');
            case 'Ȭ':
                return Optional.of('o');
            case 'ȭ':
                return Optional.of('o');
            case 'Ȯ':
                return Optional.of('o');
            case 'ȯ':
                return Optional.of('o');
            case 'Ȱ':
                return Optional.of('o');
            case 'ȱ':
                return Optional.of('o');
            case 'Ȳ':
                return Optional.of('y');
            case 'ȳ':
                return Optional.of('y');
            case 'A':
                return Optional.of('a');
            case 'B':
                return Optional.of('b');
            case 'C':
                return Optional.of('c');
            case 'D':
                return Optional.of('d');
            case 'E':
                return Optional.of('e');
            case 'F':
                return Optional.of('f');
            case 'G':
                return Optional.of('g');
            case 'H':
                return Optional.of('h');
            case 'I':
                return Optional.of('i');
            case 'J':
                return Optional.of('j');
            case 'K':
                return Optional.of('k');
            case 'L':
                return Optional.of('l');
            case 'M':
                return Optional.of('m');
            case 'N':
                return Optional.of('n');
            case 'O':
                return Optional.of('o');
            case 'P':
                return Optional.of('p');
            case 'Q':
                return Optional.of('q');
            case 'R':
                return Optional.of('r');
            case 'S':
                return Optional.of('s');
            case 'T':
                return Optional.of('t');
            case 'U':
                return Optional.of('u');
            case 'V':
                return Optional.of('v');
            case 'W':
                return Optional.of('w');
            case 'X':
                return Optional.of('x');
            case 'Y':
                return Optional.of('y');
            case 'Z':
                return Optional.of('z');
            default:
                return Optional.absent();
        }
    }

    @Override
    SimpleArrayMap<Character, Character> getCharToKeyMap() {
        return DialpadCharMappings.getDefaultCharToKeyMap();
    }

    /*
     * Generates a space delimited string of pinyins
     */
    private String tokenizeToPinyins(String displayName) {
        HanziToPinyin hanziToPinyin = HanziToPinyin.getInstance();
        ArrayList<HanziToPinyin.Token> tokens = hanziToPinyin.getTokens(displayName);
        ArrayList<String> pinyins = new ArrayList<String>();
        for (HanziToPinyin.Token token : tokens) {
            if (token.type != HanziToPinyin.Token.PINYIN) {
                return displayName;
            } else {
                pinyins.add(token.target);
            }
        }
        return TextUtils.join(" ", pinyins);
    }

    @Override
    public String transliterateName(String index) {
        return tokenizeToPinyins(index);
    }

    /*
     * Uses the default matching logic on the pinyin name and attempts to map the match positions
     * back to the original display name
     */
    @Override
    public boolean matchesCombination(Context context, SmartDialNameMatcher smartDialNameMatcher,
            String displayName, String query, ArrayList<SmartDialMatchPosition> matchList) {

        String pinyinName = tokenizeToPinyins(displayName);

        ArrayList<SmartDialMatchPosition> computedMatchList = new ArrayList<>();
        boolean matches = smartDialNameMatcher.matchesCombination(context, pinyinName, query, computedMatchList);
        if (!matches)
            return false;

        // name was translated to pinyin before matching.  attempt to map the match positions
        // back to the original display string
        if (!displayName.equals(pinyinName)) {

            // construct an array that maps each character of the pinyin name back to the index of
            // the hanzi token from which it came
            // For example, if:
            //  displayName = 红霞李
            //  pinyinName =  "hong xia li"
            // then:
            //  pinyinMapping = 0,0,0,0,-1,1,1,1,-1,2,2
            int[] pinyinMapping = new int[pinyinName.length()];
            int curToken = 0;
            for (int i=0; i < pinyinName.length(); ++i) {
                char c = pinyinName.charAt(i);
                if (c == ' ') {
                    ++curToken;
                    pinyinMapping[i] = -1;
                }
                else {
                    pinyinMapping[i] = curToken;
                }
            }

            // calculate unique hanzi characters that are matched
            Set<Integer> positionsToHighlight = new HashSet<>();
            for (SmartDialMatchPosition matchPosition : computedMatchList) {
                for (int pos = matchPosition.start; pos < matchPosition.end; ++pos) {
                    int mappedPos = pinyinMapping[pos];
                    if (mappedPos >= 0)
                        positionsToHighlight.add(mappedPos);
                }
            }

            // reset computed matches
            computedMatchList = new ArrayList<>();
            for (int matchPos : positionsToHighlight) {
                // use one object per position for simplicity
                computedMatchList.add(new SmartDialMatchPosition(matchPos, matchPos+1));
            }
        }

        matchList.addAll(computedMatchList);
        return true;
    }

}
