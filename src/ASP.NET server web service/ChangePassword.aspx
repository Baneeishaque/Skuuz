<%@ Page Title="Change Password" Language="C#" MasterPageFile="~/Site.master" AutoEventWireup="true"
    CodeFile="ChangePassword.aspx.cs" Inherits="Account_ChangePassword" %>


<asp:Content ID="BodyContent" runat="server" ContentPlaceHolderID="MainContent">
    <h2>
        Change Password
    </h2>
   
    <p>
        New passwords are required to be a minimum of 6 characters in length and maximum that is 112.
    </p>
    <asp:Label ID="Label2" runat="server"></asp:Label>
    <p>
                        <asp:Label ID="CurrentPasswordLabel" runat="server" >Old Password:</asp:Label>
                        
                        <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
                    </p>
                    <p>
                        <asp:Label ID="NewPasswordLabel" runat="server" >New Password:</asp:Label>
                       
                        <asp:TextBox ID="TextBox2" runat="server"></asp:TextBox>
                        <asp:Button ID="Cancel" runat="server" onclick="Cancel_Click" Text="Cancel" />
                        <asp:Button ID="Change" runat="server" onclick="Change_Click" Text="Change" />
                    </p>
                    <p>
                        <asp:Label ID="ConfirmNewPasswordLabel" runat="server">Confirm New Password:</asp:Label>
                        <asp:TextBox ID="TextBox3" runat="server"></asp:TextBox>
                       
                    </p>
                
</asp:Content>