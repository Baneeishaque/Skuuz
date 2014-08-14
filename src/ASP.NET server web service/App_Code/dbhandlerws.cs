using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.SqlClient;
using System.Data;

/// <summary>
/// Summary description for dbhandler
/// </summary>
public class dbhandler
{
	public dbhandler()
	{
		//
		// TODO: Add constructor logic here
		//
	}

    static String dburl = @"Data Source=.\SQLEXPRESS;AttachDbFilename=C:\inetpub\wwwroot\SkuuzService\App_Data\skuuz.mdf;Integrated Security=True;User Instance=True";
    SqlConnection con = new SqlConnection(dburl);
    
    public void nonret(string s)
    {
        SqlCommand cmd = new SqlCommand();
        cmd.Connection = con;
        cmd.CommandText = s;
        con.Open();
        cmd.ExecuteNonQuery();
        con.Close();
    }

    public DataSet ret(string s)
    {
        SqlCommand cmd = new SqlCommand();
        cmd.Connection = con;
        cmd.CommandText = s;
        SqlDataAdapter da = new SqlDataAdapter();
        da.SelectCommand = cmd;
        DataSet ds = new DataSet();
        da.Fill(ds);
        return ds;
    }

    public object eleme(string s)
    {
        SqlCommand cmd = new SqlCommand(s, con);
        con.Open();
        object o;
        o = cmd.ExecuteScalar();
        con.Close();
        return o;
    }
}