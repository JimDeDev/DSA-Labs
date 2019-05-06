
package XMLParser;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/**
 *
 * @author Jaime King
 */
public class Main {

    private static Document document;
    private static final String filePrefix = "src/XMLParser/";
    
    public static void main(String[] args) {

        String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
        String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
//        String JAXP_SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";

        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            builderFactory.setNamespaceAware(true);
            builderFactory.setValidating(true);
            builderFactory.setAttribute(JAXP_SCHEMA_LANGUAGE,W3C_XML_SCHEMA);

            DocumentBuilder builder = builderFactory.newDocumentBuilder();
//            builderFactory.setAttribute(JAXP_SCHEMA_SOURCE, new File(filePrefix + "books.xsd"));
            InputStream in = new FileInputStream(new File(filePrefix + "ComputerBooks.xml"));

            document = builder.parse(in);
            document.getDocumentElement().normalize();
        } catch (Exception e) {
            e.printStackTrace();
        }

        DOMUtilities util = new DOMUtilities();

        Node rootXMLNode = document.getDocumentElement();

        ArrayList<Node> nodes = (ArrayList<Node>) util.getAllChildNodes(rootXMLNode, "book");

        ArrayList<Book> books = new ArrayList<>();

        for (Node aNode : nodes) {
            Book aBook = new Book();

            aBook.setCover(util.getAttributeString(aNode, "cover"));
            aBook.setIsbn(util.getAttributeString(aNode, "isbn"));
            aBook.setEdition(util.getAttributeString(aNode, "edition"));

            for (Node anAuthorNode : util.getAllChildNodes(aNode, "author")) {
                aBook.addAuthor(util.getTextContent(anAuthorNode));
            }

            for (Node aTitleNode : util.getAllChildNodes(aNode, "title")) {
                aBook.setTitle(util.getTextContent(aTitleNode));
            }

            for (Node aPubNode : util.getAllChildNodes(aNode, "pub")) {
                aBook.setPublisher(util.getAttributeString(aPubNode, "name"));
                aBook.setPublisherURL(util.getAttributeString(aPubNode, "website"));
            }

            books.add(aBook);
        }

        System.out.println("Books");
        for (Book aBook : books) System.out.println(aBook);
    }
}
