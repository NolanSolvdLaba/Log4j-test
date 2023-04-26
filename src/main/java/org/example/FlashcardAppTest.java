package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FlashcardAppTest {

    private static final Logger logger = LogManager.getLogger(FlashcardAppTest.class);

    public static void main(String[] args) {
        logger.info("Starting testFlashcardExists");

        // Your test code here
        if (flashcardExists()) {
            logger.info("Flashcard exists");
        } else {
            logger.error("Flashcard does not exist");
        }

        logger.info("Ending testFlashcardExists");
    }

    private static boolean flashcardExists() {
        // Your implementation of checking if flashcard exists
        return true;
    }
}
