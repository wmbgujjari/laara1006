package com.harleeninfo.flysskill.storage.web;

public class FileResponse {
    private String name;
    private String uri;
    private String type;
    private long size;

    public FileResponse(String name, String uri, String type, long size) {
        this.setName(name);
        this.setUri(uri);
        this.setType(type);
        this.setSize(size);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

    // getters and setters removed for the sake of brevity
}
