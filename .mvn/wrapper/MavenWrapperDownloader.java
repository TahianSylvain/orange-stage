import java.io.IOException;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public final class MavenWrapperDownloader
{
    private static final String WRAPPER_VERSION = "3.2.0";

    private static final boolean VERBOSE = Boolean.parseBoolean( System.getenv( "MVNW_VERBOSE" ) );

    public static void main( String[] args )
    {
        log( "Apache Maven Wrapper Downloader " + WRAPPER_VERSION );

        if ( args.length != 2 )
        {
            System.err.println( " - ERROR wrapperUrl or wrapperJarPath parameter missing" );
            System.exit( 1 );
        }

        try
        {
            log( " - Downloader started" );
            final URL wrapperUrl = new URL( args[0] );
            final String jarPath = args[1].replace( "..", "" ); // Sanitize path
            final Path wrapperJarPath = Paths.get( jarPath ).toAbsolutePath().normalize();
            downloadFileFromURL( wrapperUrl, wrapperJarPath );
            log( "Done" );
        }
        catch ( IOException e )
        {
            System.err.println( "- Error downloading: " + e.getMessage() );
            if ( VERBOSE )
            {
                e.printStackTrace();
            }
            System.exit( 1 );
        }
    }

    private static void downloadFileFromURL( URL wrapperUrl, Path wrapperJarPath )
        throws IOException
    {
        log( " - Downloading to: " + wrapperJarPath );
        if ( System.getenv( "MVNW_USERNAME" ) != null && System.getenv( "MVNW_PASSWORD" ) != null )
        {
            final String username = System.getenv( "MVNW_USERNAME" );
            final char[] password = System.getenv( "MVNW_PASSWORD" ).toCharArray();
            Authenticator.setDefault( new Authenticator()
            {
                @Override
                protected PasswordAuthentication getPasswordAuthentication()
                {
                    return new PasswordAuthentication( username, password );
                }
            } );
        }
        try ( InputStream inStream = wrapperUrl.openStream() )
        {
            Files.copy( inStream, wrapperJarPath, StandardCopyOption.REPLACE_EXISTING );
        }
        log( " - Downloader complete" );
    }

    private static void log( String msg )
    {
        if ( VERBOSE )
        {
            System.out.println( msg );
        }
    }

}
