<%@ Page Title="Change Password" Language="C#" MasterPageFile="~/Site.master" AutoEventWireup="true"
    CodeFile="ChangePasswordSuccess.aspx.cs" Inherits="Account_ChangePasswordSuccess" %>


<asp:Content ID="BodyContent" runat="server" ContentPlaceHolderID="MainContent">
    <h2>
        Change Password
    </h2>
    <asp:Button ID="Button1" runat="server" onclick="Button1_Click" Text="Home" />
    <p>
        Your password has been changed successfully.
    </p>
</asp:Content>
