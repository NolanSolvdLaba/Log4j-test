package org.example;

import java.util.List;

public class FlashcardApp {
    public static void main(String[] args) {
        try {
            // Create a new FlashcardDeck object
            FlashcardDeck deck = new FlashcardDeck();

            // Load the flashcards from the XML file
            deck.loadFlashcardsFromXmlFile("resources/flashcards.xml");

            // Get the list of flashcards from the deck
            List<Flashcard> flashcards = deck.getFlashcards();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}