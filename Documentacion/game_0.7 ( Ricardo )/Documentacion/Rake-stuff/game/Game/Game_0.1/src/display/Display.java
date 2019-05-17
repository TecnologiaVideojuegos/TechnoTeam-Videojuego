package display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

//Creamos la ventana de nuestro juego
public class Display {

		//Ventana del Juego
		private JFrame frame;
		//Gráficos del Juego
		private Canvas canvas;
		
		private String title;
		private int width, height;
		
		public Display(String title, int width, int height) {
			this.title=title;
			this.width=width;
			this.height=height;
			
			createDisplay();
		}
		
		private void createDisplay() {
			
			//Ventana
			frame= new JFrame(title);
			frame.setSize(width, height);
			//permite cerrar la ventana del juego
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//la ventana tiene un tamaño fijo (no puede cambiar)
			frame.setResizable(false);
			//Colocamos la ventana en el centro de la pantalla
			frame.setLocationRelativeTo(null);
			//la ventana se puede ver
			frame.setVisible(true);
			
			//Gráficos
			canvas= new Canvas();
			canvas.setPreferredSize(new Dimension(width, height));
			canvas.setMaximumSize(new Dimension(width, height));
			canvas.setMinimumSize(new Dimension(width, height));
			
			frame.add(canvas);
			frame.pack();
			
		}

		
		//Getters and Setters
		public Canvas getCanvas() {
			return canvas;
		}

		public void setCanvas(Canvas canvas) {
			this.canvas = canvas;
		}
		
		
		


}
