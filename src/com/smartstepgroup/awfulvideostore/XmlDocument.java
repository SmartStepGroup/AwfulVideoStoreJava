package com.smartstepgroup.awfulvideostore;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class XmlDocument {
    public final ArrayList<XmlElement> Elements;

    public XmlDocument() {
        this.Elements = new ArrayList<XmlElement>();
    }

    public void load() throws FileNotFoundException, XMLStreamException {
        Item[] items = new XmlParser().read("src\\com\\smartstepgroup\\awfulvideostore\\Database.xml");
        for (int i = 0; i < items.length; i++) {
            XmlElement xmlElement = new XmlElement();
            xmlElement.Values[0] = items[i].getName();
            xmlElement.Values[1] = items[i].getPrice();
            xmlElement.Values[2] = items[i].getRating();
            xmlElement.Values[3] = items[i].getCode();

            Elements.add(xmlElement);
        }
    }
}

