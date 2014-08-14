using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;
using System.Data;

public partial class Account_Login : System.Web.UI.Page
{
    DBhandler dh = new DBhandler();

    protected void Page_Load(object sender, EventArgs e)
    {
       }
    protected void LoginButton_Click(object sender, EventArgs e)
    {
       
        DataTable dt=dh.GetTable("select password,uid from login where (username = '" + UserName.Text + "')");

        if (dt.Rows.Count<1)
        {
            Label2.Text = "Unknown User";
            Label2.CssClass = "failurenotification";
            Label2.Visible = true;
        }
        else
        {

            if (!dt.Rows[0]["password"].ToString().Equals(Password.Text))
            {
                Label2.Text = "Unknown password";
                Label2.CssClass = "failurenotification";
                Label2.Visible = true;
            }
            else
            {
                //dh.Ins_Up_Del("update [login] set statusid = '" + DropDownList1.SelectedItem.ToString() + "' where (uid = " + dt.Rows[0]["uid"] + ")");
                Session["user"] = dt.Rows[0]["uid"];
                Response.Redirect("Home.aspx");
            }
        }
    }
}
