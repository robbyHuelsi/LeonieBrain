package Objects;

import java.io.Serializable;

public class object implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private String path;
	
	private int depth;
	
	

	public object(String name, int xPos, int yPos, int width, int height, String path, int depth) {
		super();
		this.name = name;
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
		this.path = path;
		this.depth = depth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
	
}
