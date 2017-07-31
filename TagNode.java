package com.coderising.dp.builder;

import java.util.ArrayList;
import java.util.List;

public class TagNode {

	private String tagName;
	private String tagValue;
	private List<TagNode> children = new ArrayList<>();
	private List<Attribute> attributes = new ArrayList<>();
	
	public TagNode(String name) {
		this.tagName = name;
	}
	
	public void add(TagNode child) {
		this.children.add(child);
	}
	
	public void setAttribute(String name, String value) {
		Attribute attr = findAttribute(name);
		if(attr != null) {
			attr.value = value;
		}
		
		this.attributes.add(new Attribute(name, value));
	}
	
	private Attribute findAttribute(String name) {
		for(Attribute attr : attributes) {
			if(attr.name.equals(name)) {
				return attr;
			}
		}
		
		return null;
	}
	
	public void setValue(String value) {
		this.tagValue = value;
	}
	
	public String getTagName() {
		return this.tagName;
	}
	
	public List<TagNode> getChildren() {
		return this.children;
	}
	public static class Attribute{
		private String name;
		private String value;
		
		
		public Attribute(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}
	
	public String toXML(){
		return toXML(this);
	}

	private String toXML(TagNode tagNode) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<").append(tagNode.tagName);
		if(tagNode.attributes.size() > 0) {
			for(Attribute attr : tagNode.attributes) {
				buffer.append(" ").append(toXML(attr));
			}
		}
		
		if(tagNode.children.size() == 0) {
			buffer.append("/>");
			return buffer.toString();
		}
		
		buffer.append(">");
		for(TagNode childNode : tagNode.children) {
			buffer.append(toXML(childNode));
		}
		
		buffer.append("</").append(tagNode.tagName).append(">");
		return buffer.toString();
	}

	private String toXML(Attribute attr) {
		
		return attr.name+"=\""+attr.value+"\"";
	}
}
