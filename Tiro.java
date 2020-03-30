import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.Image;

public class Tiro
{
	private boolean inVisivel;
	private Image imagem;
	private int largura;
	private int altura;
	private int y;
	private int x;

	private static final int LARGURA = 938;
	private static int VELOCIDADE = 3;

	public Tiro(int x, int y)
	{
		this.x = x;
		this.y = y;
		inVisivel = true;
	} 

	public void load()
	{
		ImageIcon referencia = new ImageIcon("imagens/tiroSimples.png");
		imagem = referencia.getImage();

		this.largura = imagem.getWidth(null);
		this.altura = imagem.getHeight(null);
	}

	public void update()
	{
		this.x += VELOCIDADE;

		if (this.x > LARGURA) 
		{
			inVisivel = false;		
		}
	}

	public Rectangle getBounds()
	{
		return new Rectangle(x,y,largura,altura);
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