package com.example.student.myapplication;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class MyDataHandler extends DefaultHandler {
    boolean isTitle = false;
    boolean isItem = false;
    boolean isLink = false;
    public ArrayList<RSSNewsItem> data = new ArrayList<>();
    RSSNewsItem item;
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (qName.equals("title"))
        {
            isTitle = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (qName.equals("title"))
        {
            isTitle = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if (isTitle)
        {
            item.title = new String(ch, start, length);
            // Log.d("NET", new String(ch, start, length));
        }
        if (isItem && isLink)
        {
            item.link = new String(ch, start, length);
            // Log.d("NET", new String(ch, start, length));
        }
    }
}