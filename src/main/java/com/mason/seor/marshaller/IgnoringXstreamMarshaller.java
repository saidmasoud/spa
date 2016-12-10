package com.mason.seor.marshaller;

import org.springframework.oxm.xstream.XStreamMarshaller;

import com.thoughtworks.xstream.XStream;

public class IgnoringXstreamMarshaller extends XStreamMarshaller {
	
	@Override
    protected void configureXStream(final XStream xstream) {
        super.configureXStream(xstream);
        xstream.ignoreUnknownElements(); // will it blend?
    }

}
