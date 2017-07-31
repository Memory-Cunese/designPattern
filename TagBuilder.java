package com.coderising.dp.builder;

public class TagBuilder {

	private TagNode rootNode;
	private TagNode currentNode;
	private TagNode parentNode;
	
	public TagBuilder(String rootTagName) {
		rootNode = new TagNode(rootTagName);
		currentNode = rootNode;
		parentNode = null;
	}
	
	public TagBuilder addChild(String childName) {
		parentNode = this.currentNode;
		this.currentNode = new TagNode(childName);
		parentNode.add(currentNode);
		return this;
	}
	
	public TagBuilder addSibling(String siblingName) {
		this.currentNode = new TagNode(siblingName);
		parentNode.add(currentNode);
		return this;
	}
	
	public TagBuilder setAttribute(String name, String value) {
		this.currentNode.setAttribute(name, value);
		return this;
	}
	
	public TagBuilder setText(String value) {
		this.currentNode.setValue(value);
		return this;
	}
	
	public String toXML() {
		return this.rootNode.toXML();
	}
}
