import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.awt.Rectangle;
import java.util.List;

public class Player
{
	private Image imagem;
	private int largura;
	private int altura;
	private int dx;
	private int dy;
	private int x;
	private int y;
	private List <Tiro> tiros;
	private boolean isVisivel;

	public Player()
	{
		this.x = 100;
		this.y = 100;
		isVisivel = true;

		tiros = new ArrayList<Tiro>();
	}

	public void load()
	{
		ImageIcon referencia = new ImageIcon("imagens/spaceship.png");
		imagem = referencia.getImage();
		altura = imagem.getHeight(null);
		largura= imagem.getWidth(null);
	}

	public void update()
	{
		x += dx;
		y += dy;
	}

	public void tiroSimples()
	{
		this.tiros.add(new Tiro(x + largura, y + (altura/2)));
	}

	public Rectangle getBounds()
	{
		return new Rectangle(x,y,largura,altura);
	}

	public void keyPressed(KeyEvent tecla)
	{
		int codigo = tecla.getKeyCode();

		if (codigo == KeyEvent.VK_A) 
		{
			tiroSimples();
		}

		if (codigo == KeyEvent.VK_UP) 
		{
			dy = -3;
		}

		if (codigo == KeyEvent.VK_DOWN) 
		{
			dy = 3;
		}

		if (codigo == KeyEvent.VK_LEFT) 
		{
			dx = -3;
		}

		if (codigo == KeyEvent.VK_RIGHT) 
		{
			dx = 3;
		}
	}

	public void keyRelease(KeyEvent tecla)
	{
		int codigo = tecla.getKeyCode();

		if (codigo == KeyEvent.VK_UP) 
		{
			dy = 0;
		}

		if (codigo == KeyEvent.VK_DOWN) 
		{
			dy = 0;
		}

		if (codigo == KeyEvent.VK_LEFT) 
		{
			dx = 0;
		}

		if (codigo == KeyEvent.VK_RIGHT) 
		{
			dx = 0;
		}
	}

	public boolean isVisivel()
	{
		return isVisivel;
	}

	public void setVisivel(boolean isVisivel)
	{
		this.isVisivel = isVisivel;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public Image getImagem()
	{
		return imagem;
	}

	public List<Tiro> getTiros()
	{
		return tiros;
	}
}