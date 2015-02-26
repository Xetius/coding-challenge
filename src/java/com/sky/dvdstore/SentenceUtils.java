package com.sky.dvdstore;

public class SentenceUtils {

    public static String limitWordCount(final String sentence, final int wordCount) {
        String[] words = sentence.split("\\s+");
        if (words.length <= wordCount) {
            return sentence;
        }

        return shortenSentence(wordCount, words);
    }

    private static String shortenSentence(final int wordCount, final String[] words) {
        StringBuilder stringBuilder = new StringBuilder();
        String separator = "";

        for (int index = 0; index < wordCount; index++) {
            stringBuilder.append(separator);
            stringBuilder.append(words[index]);
            separator = " ";
        }

        return stringBuilder.toString();
    }

    public static String limitWordCountWithSuffix(final String sentence, final int wordCount,
                                                  final String suffix) {
        String shortenedSentence = limitWordCount(sentence, wordCount);

        if (sentenceIsShorter(sentence, shortenedSentence)) {
            return sentenceWithAppendedSuffix(shortenedSentence, suffix);
        }

        return shortenedSentence;
    }

    private static boolean sentenceIsShorter(String sentence, String shortenedSentence) {
        return sentence.length() != shortenedSentence.length();
    }

    private static String sentenceWithAppendedSuffix(final String shortenedSentence,
                                                     final String suffix) {
        return shortenedSentence + suffix;
    }

}
