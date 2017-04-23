import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

class LeaderboardParser {
    private Document document;
    private static final String FILENAME = "FinalProject-tphartke-ajdouglas-mikesims2/Files/leaderboardStorage.xml";
    private File filename = new File(FILENAME);

    LeaderboardParser() throws IOException, SAXException, ParserConfigurationException{
        document = buildDocument();
    }

    private Document buildDocument() throws IOException, SAXException, ParserConfigurationException {
        document = parseDocument(filename);
        return document;
    }

    private Document parseDocument(File filename) throws ParserConfigurationException, IOException, SAXException{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.parse(filename);
        return document;
    }

    Document getDocument(){
        return document;
    }

}
