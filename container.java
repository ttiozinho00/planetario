import javax.swing.JFrame;
import java.awt.Image;
import javax.swing.ImageIcon;

public class container extends JFrame
{
	private static final long serialVersionUID = 1;
	
	public container()
	{
		add(new fase());
		setTitle("Game");
		setSize(1024,728);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) 
	{
		cls();
        new container();     
	}

	public static void cls() 
	{
		try 
		{
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		}

		catch (final Exception E) 
		{
			System.out.println(E);
		}
	}
} 