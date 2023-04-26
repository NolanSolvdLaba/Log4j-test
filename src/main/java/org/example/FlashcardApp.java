package org.example;

import java.util.List;
import java.util.Scanner;

public class FlashcardApp {

    public static void main(String[] args) {
        FlashcardDeck deck = new FlashcardDeck();
        try {
            deck.loadFlashcardsFromXmlFile("C:/Users/Nolan/IdeaProjects/Log4j-test/resources/flashcards.xml");
        } catch (Exception e) {
            System.err.println("Error loading flashcards: " + e.getMessage());
            System.exit(1);
        }
        start(deck);
    }

    public static void start(FlashcardDeck deck) {
        List<Flashcard> flashcards = deck.getFlashcards();
        Scanner scanner = new Scanner(System.in);
        int numCorrect = 0;

        for (Flashcard flashcard : flashcards) {
            System.out.println(flashcard.getQuestion());
            String answer = scanner.nextLine();
            if (answer.equals(flashcard.getAnswer())) {
                System.out.println("Correct!");
                numCorrect++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + flashcard.getAnswer());
            }
        }

        System.out.println("Quiz complete. You answered " + numCorrect + " out of " + flashcards.size() + " correctly.");
    }

}
