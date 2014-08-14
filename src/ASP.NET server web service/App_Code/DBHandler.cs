using System;
using System.Data;
using System.Configuration;
using System.Linq;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.HtmlControls;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Xml.Linq;
using System.Data.SqlClient;
/// <summary>
/// Summary description for DBhandler
/// </summary>
/// 
public class DBhandler
{

    SqlConnection con;

    DataTable dt;
    SqlDataAdapter da;

    public DBhandler()
    {
        con = new SqlConnection(@"Data Source=.\SQLEXPRESS;AttachDbFilename=C:\inetpub\wwwroot\Skuuz!\App_Data\Skuuz!.mdf;Integrated Security=True;User Instance=True");

    }

    public DataTable GetTable(String str)
    {

        da = new SqlDataAdapter(str, con);
        dt = new DataTable();
        da.Fill(dt);
        return dt;

    }



   

    public string GetValue(String query)
    {

        SqlCommand cmd = new SqlCommand();
        con.Open();

        string str;
        try
        {
            cmd = new SqlCommand(query, con);
            str = cmd.ExecuteScalar().ToString();
        }
        catch (Exception x)
        {
            str = "0";
        }
        con.Close();

        return str;
    }
    public void Ins_Up_Del(String query)
    {
        con.Open();
        SqlCommand cmd = new SqlCommand(query, con);

        cmd.ExecuteNonQuery();
        con.Close();
    }




}





