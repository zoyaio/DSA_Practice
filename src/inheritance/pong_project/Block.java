package inheritance.pong_project;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Block
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private Color color;

	private Color[] COLORS = {Color.RED, Color.BLUE, Color.GREEN};
	private Random rand = new Random();

	public Block()
	{
		this.xPos = 100;
		this.yPos = 150;
		this.width = 10;
		this.height = 10;
		this.color = Color.RED;
	}

	//add other Block constructors - x , y , width, height, color	
	public Block(int x, int y, int width, int height, Color color) {
		this.xPos = x;
		this.yPos = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}

	// add the other set methods
	public Block(int x, int y, int width, int height) {
		this.xPos = x;
		this.yPos = y;
		this.width = width;
		this.height = height;
		this.color = Color.RED;
	}

	public int getX() {
		return xPos;
	}

	public void setX(int xPos) {
		this.xPos = xPos;
	}

	public int getY() {
		return yPos;
	}

	public void setY(int yPos) {
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color col)
	{

		color = col;

	}

	public void draw(Graphics window)
	{
		//uncomment after you write the set and get methods

		window.setColor(color);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	public void drawNew(Graphics window)
	{

		window.setColor(COLORS[rand.nextInt(3)]);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}

	public void draw(Graphics window, Color col)
	{
		window.setColor(col);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}

	public boolean equals(Object obj)
	{

		try{
			Block bloc = (Block) obj;
			if (bloc.xPos == xPos && bloc.yPos == yPos && bloc.width == width && bloc.height == height) {
				return true;
			}
			return false;

		}
		catch(Exception e)
		{
			System.out.println("hi");
		}
		return false;
	}



	//add a toString() method  - x , y , width, height, color

	public String toString() {
		return xPos + " " + yPos + " " + width + " " + height + " " + color.toString();
	}
}