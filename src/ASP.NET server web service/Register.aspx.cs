using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;
using System.Data;

public partial class Account_Register : System.Web.UI.Page
{

    DBhandler dh = new DBhandler();
    protected void Page_Load(object sender, EventArgs e)
    {

    }



    protected void CreateUserButton_Click(object sender, EventArgs e)
    {
        Label6.Visible = false;
        if (TextBox5.Text.Length > 20)
        {
            Label6.CssClass = "failurenotification";
            Label6.Text="Maximum length is 20";
            Label6.Visible = true;
        }
        else
        {
            if(TextBox5.Text.Length < 6)
            {
                Label6.CssClass = "failurenotification";
                Label6.Text="Minimum length is 6";
                Label6.Visible = true;
            }
            else
            {
                Label1.Visible = false;
                if ((TextBox1.Text.Length > 12) || (TextBox1.Text.Length < 6))
                {
                    Label1.CssClass = "failurenotification";
                    Label1.Visible = true;
                }
                else
                {

              
                    DataTable dt = dh.GetTable("select uid from login where username='" + TextBox1.Text + "'");
                
                    if (dt.Rows.Count>0)
                    {
                        Label1.CssClass = "failurenotification";
                        Label1.Text = "Username is already taken,Please choose another one";
                        Label1.Visible = true;
                    }
                    else
                    {
                        Label2.Visible = false;
                        if (string.IsNullOrEmpty(TextBox2.Text))
                        {
                            Label2.CssClass = "failurenotification";
                            Label2.Visible = true;
                        }
                        else
                        {
                        
                            dt.Clear();
                            dt = dh.GetTable("select uid from [user] where (email='" + TextBox2.Text + "')");
                
                            if (dt.Rows.Count>0)
                            {
                                Label2.CssClass = "failurenotification";
                                Label2.Text = "Email is already used,Please choose another one";
                                Label2.Visible = true;
                            }
                            else
                            {
                                Label3.Visible = false;
                                if ((TextBox3.Text.Length < 6) || (TextBox3.Text.Length > 16))
                                {
                                    Label3.CssClass = "failurenotification";
                                    Label3.Visible = true;
                                }
                                else
                                {
                                    Label4.Visible = false;
                                    if (!TextBox3.Text.Equals(TextBox4.Text))
                                    {
                                        Label4.CssClass = "failurenotification";
                                        Label4.Text = "The Password and Confirmation Password must match.";
                                        Label4.Visible = true;
                                    }
                                    else
                                    {

                                   
                                        int uc = Convert.ToInt32(dh.GetValue("select uc from sdata"));
                                        uc++;
                                        string gen = DropDownListe0.SelectedItem.ToString();
                                    
                                        string genp = DropDownListp.SelectedItem.ToString();
                                        string gene = DropDownListe.SelectedItem.ToString();

                                        dh.Ins_Up_Del("insert into [user](uid,name,phone,email,place,gender,phones,emails)values(" + uc + ",'" + TextBox5.Text + "','" + TextBox6.Text + "','" + TextBox2.Text + "','" + TextBox7.Text + "','" + gen + "','" + genp + "','" + gene + "')");
                                    
                                        dh.Ins_Up_Del("insert into [login](uid,username,password,statusid)values(" + uc + ",'" + TextBox1.Text + "','" + TextBox3.Text + "','offline')");



                                        dh.Ins_Up_Del("update [sdata] set uc=" + uc);
                                        Response.Redirect("login.aspx");
                                    
                                    }
                                }
                            }

                        }
                    } 
                }

            }
        }
       
    }
}