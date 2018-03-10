package uk.co.kmsomers.neverhaveiever.utils;

import java.lang.reflect.Array;
import java.util.Random;

/**
 * Created by kizer on 10/03/2018.
 */

public class CommonUtils {

    public static <T> T[] concatenate (T[] a, T[] b) {
        int aLen = a.length;
        int bLen = b.length;

        @SuppressWarnings("unchecked")
        T[] c = (T[]) Array.newInstance(a.getClass().getComponentType(), aLen+bLen);
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);

        return c;
    }

    public static String[] randomiseQuestions(String[] questions, String instruction){
        Random random = new Random();
        String[] randomisedQuestions = new String[questions.length + 1];
        randomisedQuestions[0] = instruction;

        //Randomise questions
        for (int pos = 0; pos < questions.length; pos++){
            int changePos = pos + random.nextInt(questions.length - pos);
            swapItems(questions, pos, changePos);
        }

        for (int i = 0; i < questions.length; i++){
            randomisedQuestions[i + 1] = questions[i];
        }

        return randomisedQuestions;
    }

    public static void swapItems(String[] questions, int pos, int changePos){
        String tempString = questions[pos];
        questions[pos] = questions[changePos];
        questions[changePos] = tempString;
    }
}
