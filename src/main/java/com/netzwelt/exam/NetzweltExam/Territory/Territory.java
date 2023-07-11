package com.netzwelt.exam.NetzweltExam.Territory;

import java.util.ArrayList;
import java.util.List;

public class Territory {
    private String id;
    private String name;
    private String parent;
    private List<Territory> children;


    public void addChild(Territory child) {
        if (children == null) {
            children = new ArrayList<>();
        }
        children.add(child);
    }


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getParent() {
		return parent;
	}


	public void setParent(String parent) {
		this.parent = parent;
	}


	public List<Territory> getChildren() {
		return children;
	}


	public void setChildren(List<Territory> children) {
		this.children = children;
	}
    
    
}


