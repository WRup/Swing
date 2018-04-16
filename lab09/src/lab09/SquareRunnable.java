package lab09;

import javax.swing.JComponent;



public class SquareRunnable implements Runnable {
		private Square square;
		private JComponent jComponent;

		public SquareRunnable(Square square, JComponent jComponent) {
			this.square = square;
			this.jComponent = jComponent;
		}

		public void run() {
			try {

				while (true) {
					square.move(jComponent.getBounds());
					jComponent.repaint();
					Thread.sleep(10);
				}
			} catch (InterruptedException e) {

			}
		}
}
