package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FlashcardDeck {
    // a list holding the flashcards
    private List<Flashcard> flashcards = new ArrayList<>();

    // Empty constructor --> majority of work done belo
    public FlashcardDeck() {
    }

    public void loadFlashcardsFromXmlFile(String filename) throws Exception {
        //create a file object
        File inputFile = new File(filename);

        // create a DocumentBuilderFactory object
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder(); // create a DocumentBuilder object
        Document doc = dBuilder.parse(inputFile); // parse the input file into a Document object

        doc.getDocumentElement().normalize(); // normalize the document (this is optional)

        NodeList nList = doc.getElementsByTagName("flashcard"); // get a NodeList of all "flashcard" elements in the document

        for (int i = 0; i < nList.getLength(); i++) { // iterate over the NodeList
            Node nNode = nList.item(i); // get the current Node

            if (nNode.getNodeType() == Node.ELEMENT_NODE) { // check if the Node is an Element
                Element eElement = (Element) nNode; // cast the Node to an Element

                // get the question and answer from the "question" and "answer" elements, respectively
                String question = eElement.getElementsByTagName("question").item(0).getTextContent();
                String answer = eElement.getElementsByTagName("answer").item(0).getTextContent();

                // create a new Flashcard object and add it to the list of flashcards
                flashcards.add(new Flashcard(question, answer));
            }
        }
    }

    public List<Flashcard> getFlashcards() {
        return flashcards;
    }

    public void setFlashcards(List<Flashcard> flashcards) {
        this.flashcards = flashcards;
    }
}
