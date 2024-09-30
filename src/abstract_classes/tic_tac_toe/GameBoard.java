package abstract_classes.tic_tac_toe;//(c) A+ Computer Science
//www.apluscompsci.com
//Name - 

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Canvas;

public class GameBoard extends Canvas implements MouseListener
{
	private int mouseX, mouseY;
	private boolean mouseClicked, gameOver;
	private int mouseButton, prevMouseButton;
	private Grid board;
	
	private final static int WIDTH=150;
	private final static int HEIGHT=150;
	private final static int SCALE = 50;
	private final static int BOARDSIZE = 3;

	public GameBoard()
	{
		mouseClicked = false;
		mouseX = mouseY = 0;
		mouseButton = 0;
		prevMouseButton = -1;
		
		board = new Grid(BOARDSIZE,BOARDSIZE);
		System.out.println("mouselisterner");
		addMouseListener(this);
		setBackground(Color.WHITE);
	}

	public void mouseClicked(MouseEvent e)
	{
		System.out.println("click");
		mouseClicked = true;
		mouseX=e.getX();
		mouseY=e.getY();
		mouseButton = e.getButton();
		repaint();
	}

	public void paint(Graphics window)
	{
		System.out.println("paint called");
		window.setColor(Color.white);
		window.fillRect(0,0,640,480);
		window.setFont(new Font("TAHOMA",Font.BOLD,12));
		window.setColor(Color.blue);
		window.drawString("TIC TAC TOE", 420,55);
		window.drawString("left mouse click == [X]", 420,85);
		window.drawString("right mouse click == [O]", 420,105);

		window.drawRect(50,50,WIDTH,HEIGHT);
		window.drawRect(100,50,WIDTH/3,HEIGHT);
		window.drawRect(50,100,WIDTH,HEIGHT/3);

		if(mouseClicked)
		{
			markBoard(window);
			board.drawGrid(window);

			if(determineWinner(window))
			{
			  //make a new board	
				System.out.println("winner!");
			  //clear the screen

			}	
			mouseClicked = false;
		}
	}

	public void markBoard(Graphics window)
	{
		System.out.println("markbaord");
		if(mouseX>=WIDTH/3&&mouseX<=WIDTH+50&&mouseY>=HEIGHT/3&&mouseY<=HEIGHT+50)
		{
			int r = mouseY/50-1;
			int c = mouseX/50-1;
			Piece piece = (Piece)board.getSpot(r,c);
			//if BUTTON1 was pressed and BUTTON1 was not pressed last mouse press
			if(mouseButton==MouseEvent.BUTTON1&&prevMouseButton!=mouseButton)		//left mouse button pressed
			{

				// if piece is empty
				if(piece==null)
				{
					Piece pieceNew = new Piece(5+c*50+50,5+r*50+50,WIDTH/3-10,HEIGHT/3-10,"O",Color.RED);
					board.setSpot(r,c, pieceNew);
					pieceNew.draw(window);

				}
				else{
					System.out.println("hi");
				}
				prevMouseButton=mouseButton;
			}

			//if BUTTON3 was pressed and BUTTON3 was not pressed last mouse press
			if(mouseButton==MouseEvent.BUTTON3&&prevMouseButton!=mouseButton)		//left mouse button pressed
			{
				// if piece is empty
				if(piece==null)
				{
					// create a new piece
					Piece pieceNew = new Piece(5+c*50+50,5+r*50+50,WIDTH/3-10,HEIGHT/3-10,"X",Color.GREEN);
					// adds the piece to the board and draws it
					System.out.println("rc: "+  r +" " + "c");
					board.setSpot(r,c,pieceNew);
					pieceNew.draw(window);
				}
				else{
					System.out.println("bye");
				}
				//save the current button pressed to compare to next button pressed
				prevMouseButton=mouseButton;
			}


		
		}
	}
	
	public boolean determineWinner(Graphics window)
	{
		String winner="";
		for (int r = 0; r<board.getNumRows(); r++)
		{
			Piece row0 = (Piece)board.getSpot(r,0);
			Piece row1 = (Piece)board.getSpot(r,1);
			Piece row2 = (Piece)board.getSpot(r,2);
			
			if(row0==null||row1==null||row2==null) continue;
			
			if(row0.getName().equals(row1.getName())&&row0.getName().equals(row2.getName()))
			{
				winner=row0.getName()+" wins horizontally!";
				break;
			}
		}
		
		//check for vertical winner
		
		if(winner.equals(""))
		{
			//check for diagonal winner
		}
		
		if(winner.equals(""))
		{
			//check for diagonal winner
		}

		if(winner.indexOf("no name")>-1){
		   board.drawGrid(window);
		   return false;
		}
		else if(board.drawGrid(window)&&winner.length()==0){
		   winner =  "cat's game - no winner!\n\n";
		}
				
		if(winner.length()>0)
		{
			window.setFont(new Font("TAHOMA",Font.BOLD,22));
			window.setColor(Color.orange);
			window.drawString(winner, 320,355);	
			try{
			   Thread.currentThread().sleep(100000);
			}
			catch(Exception e){
			}
			repaint();
			return true;
		}
		return false;
	}

	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }
	public void mousePressed(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }
}