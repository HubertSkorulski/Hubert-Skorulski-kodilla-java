package com.kodilla.stream.bautifer;

public class PoemBeautifer {
    public void beautify(String textToBe, PoemDecorator poemDecorator) {
        String result = poemDecorator.decorator(textToBe);
        System.out.println(result);
    }
}
