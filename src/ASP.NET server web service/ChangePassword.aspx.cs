using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;

public partial class Account_ChangePassword : System.Web.UI.Page
{
    DBhandler dh=new DBhandler();
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void Cancel_Click(object sender, EventArgs e)
    {
        Response.Redirect("Home.aspx");
    }
    protected void Change_Click(object sender, EventArgs e)
    {
        DataTable dt=dh.GetTable("select password,uid from [login] where uid='" + Session["user"] + "'");
        Label2.Visible = false;
        if (dt.Rows.Count < 1)
        {
            Label2.Text = "Unknown User";
            Label2.CssClass = "failurenotification";
            Label2.Visible = true;
        }
        else
        {
            if (!dt.Rows[0]["password"].ToString().Equals(TextBox1.Text))
            {
                Label2.Text = "Unknown password";
                Label2.CssClass = "failurenotification";
                Label2.Visible = true;
            }
            else
            {
                if (!TextBox2.Text.Equals(TextBox3.Text))
                {
                    Label2.CssClass = "failurenotification";
                    Label2.Text = "The Password and Confirmation Password must match.";
                    Label2.Visible = true;
                }
                else
                {

                    dh.Ins_Up_Del("update [login] set password='" + TextBox2.Text + "' where uid=" + dt.Rows[0]["uid"]);
                    Response.Redirect("ChangePasswordSuccess.aspx");
                }
            }
        }
    }
}
