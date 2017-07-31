package com.coderising.dp.builder;

import org.junit.Assert;
import org.junit.Test;


public class TagBuilderTest {

	@Test
	public void testToXML() {
		TagBuilder builder = new TagBuilder("order");
		String xml = builder.addChild("line-items")
				.addChild("line-item").setAttribute("pid", "p3677").setAttribute("qty", "3")
				.addSibling("line-item").setAttribute("pid", "p9877").setAttribute("qty", "10").toXML();
		
		String expected = "<order>"
				          +"<line-items>"
				          +"<line-item pid=\"p3677\" qty=\"3\"/>"
				          +"<line-item pid=\"p9877\" qty=\"10\"/>"
				          +"</line-items>"
				          +"</order>";
		
		System.out.println(xml);
		Assert.assertEquals(expected, xml);
	}
}
