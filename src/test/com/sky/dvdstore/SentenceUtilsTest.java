package com.sky.dvdstore;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SentenceUtilsTest {

    private static final String SUFFIX = "...";

    @Test
    public void limitingSentenceReturnsFullSentenceIfShorterThanWordCount() throws Exception {
        final int maxWordCount = 10;
        final String sentence = "one two three four five six";
        final String expectedSentence = "one two three four five six";
        final String actualSentence = SentenceUtils.limitWordCount(sentence, maxWordCount);
        assertEquals(expectedSentence, actualSentence);
    }

    @Test
    public void limitingSentenceReturnsShorterSentenceLimitedToWordCountForLongerSentences()
        throws Exception {
        final int maxWordCount = 10;
        final String sentence = "one two three four five six seven eight nine ten eleven twelve";
        final String expectedSentence = "one two three four five six seven eight nine ten";
        final String actualSentence = SentenceUtils.limitWordCount(sentence, maxWordCount);
        assertEquals(expectedSentence, actualSentence);
    }

    @Test
    public void limitingSentenceWithSuffixDoesNotAppendSuffixIfNotShortened() throws Exception {
        final int maxWordCount = 10;
        final String sentence = "one two three four five six";
        final String expectedSentence = "one two three four five six";
        final String
            actualSentence =
            SentenceUtils.limitWordCountWithSuffix(sentence, maxWordCount, SUFFIX);
        assertEquals(expectedSentence, actualSentence);
    }

    @Test
    public void limitingSentenceWithSuffixAppendsSuffixIfShortened() throws Exception {
        final int maxWordCount = 10;
        final String sentence = "one two three four five six seven eight nine ten eleven twelve";
        final String expectedSentence = "one two three four five six seven eight nine ten...";
        final String
            actualSentence =
            SentenceUtils.limitWordCountWithSuffix(sentence, maxWordCount, SUFFIX);
        assertEquals(expectedSentence, actualSentence);
    }

    @Test
    public void limitingSentenceLengthWithSuffixStripsFinalPunctuation() throws Exception {
        final int maxWordCount = 10;
        final String
            sentence =
            "one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve";
        final String
            expectedSentence =
            "one, two, three, four, five, six, seven, eight, nine, ten...";
        final String
            actualSentence =
            SentenceUtils.limitWordCountWithSuffix(sentence, maxWordCount, SUFFIX);
        assertEquals(expectedSentence, actualSentence);
    }
}