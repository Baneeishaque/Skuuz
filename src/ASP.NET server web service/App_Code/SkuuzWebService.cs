using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Data;

/// <summary>
/// Summary description for SkuuzWebService
/// </summary>
[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
// [System.Web.Script.Services.ScriptService]
public class SkuuzWebService : System.Web.Services.WebService {

    dbhandler db = new dbhandler();

    public SkuuzWebService () {

        //Uncomment the following line if using designed components 
        //InitializeComponent(); 
    }

    [WebMethod]
    public string login(string a, string b)
    {
       
        string s = "select * from users where username='" + a + "' and password='" + b + "'";
        DataTable dt = db.ret(s).Tables[0];
        if (dt.Rows.Count > 0)
        {
            return "ok";
        }
        else
        {
            return "no";
        }
    }

    [WebMethod]
    public string reset(string ime, string pwd)
    {
       // Class1 db = new Class1();
        string s = "update  register set password='" + pwd + "' where ime='" + ime + "' ";
        db.nonret(s);
        return "ok";
    }
    [WebMethod]
    public string insert(string imei, string longi, string lati)
    {
      //  Class1 db = new Class1();
        string s = "update register set longitude='" + longi + "',latitude='" + lati + "' where ime='" + imei + "' ";
        db.nonret(s);



        return "ok";
    }
    [WebMethod]
    public string insertip(string ime, string ip)
    {
       // Class1 db = new Class1();
        string s = "update register set ip='" + ip + "' where ime='" + ime + "' ";
        db.nonret(s);
        return "ok";
    }
    [WebMethod]
    public string getcontact(string imei)
    {
       // Class1 db = new Class1();
        string s = "select mobileno from register where ime='" + imei + "'";
        return db.eleme(s).ToString();

    }
    [WebMethod]
    public string getquestion(string imei)
    {
       // Class1 db = new Class1();
        string s = "select question from register where ime='" + imei + "'";
        return db.eleme(s).ToString();

    }
    [WebMethod]
    public string recover(string ime, string ans)
    {
      //  Class1 db = new Class1();
        string s = "select * from register where ime='" + ime + "' and answer='" + ans + "'";
        DataTable dt = db.ret(s).Tables[0];
        if (dt.Rows.Count > 0)
        {
           /* string s1 = "select password from register where ime='" + ime + "' and answer='" + ans + "'";
            string pwd = db.eleme(s1).ToString();
            string s2 = "select email from register where ime='" + ime + "' and answer='" + ans + "'";
            string email = db.eleme(s2).ToString();
            MailMessage a = new MailMessage();
            a.From = new MailAddress(" groupofmda@gmail.com");
            a.To.Add(email);
            a.Body = "Your password for mobile data access application is" + pwd;
            a.Subject = "Password Recovery ";

            SmtpClient ab = new SmtpClient("smtp.gmail.com", 587);
            ab.Credentials = new NetworkCredential("groupofmda", "mdaproject");
            ab.EnableSsl = true;

            ab.Send(a);*/
            return "ok";
        }
        else
        {
            return "no";
        }

    }

}
