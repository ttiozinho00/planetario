import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.util.Random;
import java.awt.Image;

public class Stars
{
	private boolean inVisivel;
	private Image imagem;
	private int largura;
	private int altura;
	private int y;
	private int x;

	//private static final int LARGURA = 938;
	private static int VELOCIDADE = 3;

	public Stars(int x, int y)
	{
		this.x = x;
		this.y = y;
		inVisivel = true;
	} 

	public void load()
	{
		ImageIcon referencia = new ImageIcon("imagens/Stars.png");
		imagem = referencia.getImage();

		this.largura = imagem.getWidth(null);
		this.altura = imagem.getHeight(null);
	}

	public void update()
	{
		if (this.x < 0) 
		{
			this.x = largura;
			Random a = new Random();
			int m = a.nextInt(500);
			this.x = m + 1024;

			Random r = new Random();
			int n = r.nextInt(768);
			this.y = n;		
		}

		else
		{
			this.x -= VELOCIDADE;
		}
	}

	public boolean inVisivel()
	{
		return inVisivel;
	}

	public void setVisivel(boolean inVisivel)
	{
		this.inVisivel = inVisivel;
	}

	public static int getVELOCIDADE(int vELOCIDADE)
	{
		return vELOCIDADE;
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
}