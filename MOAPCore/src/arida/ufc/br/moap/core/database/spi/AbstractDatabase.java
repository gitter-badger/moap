package arida.ufc.br.moap.core.database.spi;

import arida.ufc.br.moap.core.datasource.spi.IDataSource;
import arida.ufc.br.moap.core.spi.IDataModel;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public abstract class AbstractDatabase implements IDataSource {

    private static Logger logger = Logger.getLogger(AbstractDatabase.class);
    protected static ConnectionProperty p;
    protected static Connection connection = getConnection();

    public static Connection getConnection() {
        p = null;
        try {
            p = ConnectionProperty.getInstance();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        connection = p.getConnection();
        logger.info(p.getString());
        return connection;
    };
	
    public String toString() {
        return ConnectionProperty.getString();
    }

    public abstract String getDriverClass();
    
    public abstract IDataModel getModel();
    
}
