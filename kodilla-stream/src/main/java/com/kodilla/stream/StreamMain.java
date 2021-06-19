package com.kodilla.stream;

import com.kodilla.stream.bautifer.PoemBeautifer;

public class StreamMain {
    public static void main(String[] args) {

        System.out.println("Processing the beautifer");
        String text = "whatever";
        PoemBeautifer poemBeautifer = new PoemBeautifer();
        poemBeautifer.beautify(text,(textToBe -> textToBe.toUpperCase()));
        poemBeautifer.beautify(text,textToBe -> "ABC" + textToBe + "ABC");
        poemBeautifer.beautify(text, textToBe -> textToBe.concat(textToBe));
        poemBeautifer.beautify(text,textToBe -> textToBe.substring(2));
    }
}
