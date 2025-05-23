import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;
interface DBInterface extends Remote
{
    public String input(String name1,String name2) throws RemoteException;
}

public class A2server extends UnicastRemoteObject implements DBInterface
{
    int flag=0,n,i,j;
    String name3;
    ResultSet r;
    public A2server() throws RemoteException
    { 
        try
        {
            System.out.println("Initializing Server\nServer Ready");
        }
        catch (Exception e)
        {
            System.out.println("ERROR: " +e.getMessage());
        }
    }

    public static void main(String[] args)
    { 
        try
        { 
            Server rs=new Server();
            java.rmi.registry.LocateRegistry.createRegistry(1030).rebind("DBServ", rs);
        }
        catch (Exception e)
        {
            System.out.println("ERROR: " +e.getMessage());
        }
    }

    public String input(String name1,String name2)
    {
        try
        {
            name3=name1.concat(name2);
        }
        catch (Exception e)
        {
            System.out.println("ERROR: " +e.getMessage());  
        }
        return name3;
    }
}