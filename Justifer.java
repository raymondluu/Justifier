/************************
* File Name: Justifer
* Coder Name: Raymond Luu
* Assignment: 6
************************/
import java.io.*; 
import java.util.*; 

public class Justifer
{ 
	public static final int TAB_SPACES = 4;
	
	public static void main( String[] args )
	throws FileNotFoundException
	{
		Scanner console = new Scanner( System.in );
		File f = getFile( console );
		Scanner input = new Scanner( f );
		justifyJavaFile(input);
	}
	public static File getFile( Scanner keyboard )
	{
		System.out.print( "Enter name of file to be processed: ");
		String fileName = keyboard.nextLine();
		File f = new File( fileName );
		while( !f.canRead() )
		{
			System.out.println( "The file named " + fileName + " not found." );
			System.out.print( "Enter name of file to be processed: ");
			fileName = keyboard.nextLine();
			f = new File( fileName );
		}
		return f;
	}
	public static void justifyJavaFile( Scanner input )
	{
		int bracketCount1 = 0;
		int bracketCount2 = 0;
		//while there is input run loop
		while( input.hasNextLine() )
		{
			String bracket1 = "{";
			String bracket2 = "}";	
			//variable rawText is the text unedited
			String text = input.nextLine();
			int a = 0;
			while( a < text.length() && text.charAt(a) == ' ' ) a++;
			text = text.substring( a, text.length() );
			//String rawText = input.nextLine();
			//variable text is the text with all the leading spaces replaced
			//String text = rawText.replaceAll( "^\\s+", "" );
			//looks for line ending with { 
			if( text.endsWith( bracket1 ) )
			{
				bracketCount1++;
				for( int i = 1; i <= bracketCount1 - bracketCount2 - 1; i++ )
				{
					for( int j = 1; j <= TAB_SPACES; j++ )
					{
						System.out.print(" ");
					}
				}
				System.out.println( text );
			}
			//looks for line ending with }
			else if( text.endsWith( bracket2 ) )
			{
				bracketCount2++;
				for( int i = 1; i <= bracketCount1 - bracketCount2; i++ )
				{
					for( int j = 1; j <= TAB_SPACES; j++ )
					{
						System.out.print(" ");
					}
				}
				System.out.println( text );
			}
			else//all other lines without { or } 
			{
				for( int i = 1; i <= bracketCount1 - bracketCount2; i++ )
				{
					for( int j = 1; j <= TAB_SPACES; j++ )
					{
						System.out.print(" ");
					}
				}
				System.out.println( text );
			}
		}
	}
}