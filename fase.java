import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.awt.Rectangle;
import javax.swing.Timer;
import java.util.List;

public class fase extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1;
	private  Image fundo;
	private Player player;
	private Timer timer;
	private List<Enemy1> enemy1;
	private List<Stars> stars;
	private boolean emJogo;

	public fase()
	{
		setFocusable(true);
		setDoubleBuffered(true);

		ImageIcon imagem = new ImageIcon("imagens/background.jpg");
		fundo = imagem.getImage();

		player = new Player();
		player.load();

		addKeyListener(new TecladoAdapter());

		timer = new Timer(5, this);
		timer.start();

		iniciallizaInimigos();
		iniciallizaStars();
		emJogo = true;
	} 

	public void iniciallizaInimigos()
	{
		int coordenadas[] = new int[80];
		enemy1 = new ArrayList<Enemy1>();
		int i;
		int x;
		int y;

		for (i = 0;i < coordenadas.length;i++) 
		{
			x = (int)(Math.random() * 8000 + 1024);
			y = (int)(Math.random() * 650 + 30);
			enemy1.add(new Enemy1(x, y));
		}	
	}

	public void iniciallizaStars()
	{
		int coordenadas[] = new int[40];
		stars = new ArrayList<Stars>();
		int i;
		int x;
		int y;

		for (i = 0;i < coordenadas.length;i++) 
		{
			x = (int)(Math.random() * 1024 + 0);
			y = (int)(Math.random() * 768 + 0);
			stars.add(new Stars(x, y));
		}	
	}	



	public void paint(Graphics g)
	{
		int i;
		int e;
		int p;
		Graphics2D graficos = (Graphics2D) g;

		if (emJogo == true) 
		{
			graficos.drawImage(fundo, 0, 0, null);

			for (p = 0; p < stars.size(); p++) 
			{
				Stars d = stars.get(p);	
				d.load();
				graficos.drawImage(d.getImagem(), d.getX(), d.getY(), this);
			}			

			graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);
			List<Tiro> tiros = player.getTiros();

			for (i = 0; i < tiros.size(); i++) 
			{
				Tiro m = tiros.get(i);	
				m.load();
				graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
			}

			for (e = 0;e < enemy1.size(); e++)
			{
				Enemy1 in = enemy1.get(e);
				in.load();
				graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);
			}			
		}

		else
		{
			ImageIcon fimJogo = new ImageIcon("imagens/fim.png");
			graficos.drawImage(fimJogo.getImage(), 0, 0, null);
		}
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		int v;
		int i;
		int p;

		player.update();

		for (p = 0;p < stars.size();p++) 
		{
			Stars on = stars.get(p);

			if (on.inVisivel()) 
			{
				on.update();	
			}

			else
			{
				stars.remove(p);
			}
		}

		List<Tiro> tiros = player.getTiros();

		for (i = 0; i < tiros.size(); i++) 
		{
			Tiro m = tiros.get(i);

			if (m.inVisivel()) 
			{
				m.update();			
			}

			else
			{
				tiros.remove(i);
			}	
		}

		for (v = 0;v < enemy1.size(); v++) 
		{
			Enemy1 ve = enemy1.get(v);

			if (ve.inVisivel()) 
			{
				ve.update();				
			}

			else
			{
				enemy1.remove(v);
			}				
		}
		checarColisoes();
		repaint();
	}

	public void checarColisoes()
	{
		int i;
		int j;
		int o;
		Rectangle formaNave = player.getBounds();
		Rectangle formaEnemy1;
		Rectangle formaTiro;

		for (i = 0;i < enemy1.size();i++) 
		{
			Enemy1 tempEnemy1 = enemy1.get(i);
			formaEnemy1 = tempEnemy1.getBounds();

			if (formaNave.intersects(formaEnemy1)) 
			{
				player.setVisivel(false);
				tempEnemy1.setVisivel(false);
				emJogo = false;			
			}	
		}
		List<Tiro> tiros = player.getTiros();

		for(j = 0; j < tiros.size();j++)
		{
			Tiro tempTiro = tiros.get(j);
			formaTiro = tempTiro.getBounds();

			for( o = 0; o < enemy1.size();o++)
			{
				Enemy1 tempEnemy1 = enemy1.get(o);
				formaEnemy1 = tempEnemy1.getBounds();

				if (formaTiro.intersects(formaEnemy1)) 
				{
					tempEnemy1.setVisivel(false);	
					tempTiro.setVisivel(false);					
				}				
			}
		}
	}

	private class TecladoAdapter extends KeyAdapter
	{

        @Override
		public void keyPressed(KeyEvent e)
		{
			player.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e)
		{
			player.keyRelease(e);
		}
	}
}	