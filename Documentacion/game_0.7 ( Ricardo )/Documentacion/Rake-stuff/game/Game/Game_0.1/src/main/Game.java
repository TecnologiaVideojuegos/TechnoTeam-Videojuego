package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import display.Display;
import image.ImageLoader;
import image.SpriteSheet;


//Codigo sacado de CodeNMore 
//New Beginner 2d game programming

//Mirar el main Loop de slick y comparar con este

//Runnable te permite usar hilos (threads)
public class Game extends Canvas implements Runnable {
	
	
	private Display display;
	public String title;
	public int width, height;
	
	private boolean running=false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//Carga imagenes
	private BufferedImage imagen;
	private SpriteSheet sheet;
	
	//Usamos este constructor en lugar de Display para inicializar nuestra Ventana del Juego
	public Game(String title, int width, int height) {
		
		this.title=title;
		this.width=width;
		this.height=height;
		

	}
	

	
	//Loop (Bucle del Juego)
	private void init() {		
		display= new Display(title, width, height);
		
		//Carga las imagenes del juego
		imagen=ImageLoader.loadImage("/textures/golem.jpg");
		sheet=new SpriteSheet(imagen);
	}
	
	
	private void tick() {}
	
	
	private void render() {	
		bs=display.getCanvas().getBufferStrategy();
		
		if(bs==null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g=bs.getDrawGraphics();
		//Limpiar pantalla
		g.clearRect(0,0,width,height);
		
		//Pintar
		
		//Pintas una parte del SpriteSheet
		g.drawImage(sheet.cut(117,0,65,65),5,5,null);
		g.drawImage(sheet.cut(200,217,65,65),205,5,null);
		
		//Pinta una imagen de la carpeta /res/textures
		//g.drawImage(imagen,0,0,null);
		
		/* CODIGO DE PRUEBA	
		g.fillRect(0,0,width,height);  //Pinta un rectangulo que ocupa toda la pantalla
		g.setColor(Color.green);
		g.fillRect(10,50,50,70);
		g.setColor(Color.yellow);
		g.fillRect(0,0,50,70);
		*/
		
		
		//Dejar de pintar
		bs.show();
		g.dispose();
	}
	
	//Threads
	public void run() {
		
		init();
		
		//Loop
		while(running) {
			tick();
			render();
			
		}
		stop();
		
	}
	
	public synchronized void start() {
		
		if(running) return;		
		running=true;
		
		thread= new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		
		if(!running) return;
		running=false;
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



}
