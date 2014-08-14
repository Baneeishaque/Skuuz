<%@ Page Title="Register" Language="C#" MasterPageFile="~/Site.master" AutoEventWireup="true"
    CodeFile="Register.aspx.cs" Inherits="Account_Register" %>


<asp:Content ID="BodyContent" runat="server" ContentPlaceHolderID="MainContent">
   
       
            
                    
                        <fieldset class="register">
                            <legend>Registration</legend>
                            <p>
                                <asp:Label ID="Label5" runat="server" AssociatedControlID="TextBox5">Full Name:</asp:Label>
                                <asp:TextBox ID="TextBox5" runat="server" Width="320px"></asp:TextBox>
                                
                            </p>
                            <p>
                               <b>
                                    <asp:Label ID="Label6" runat="server" 
                                    Text="Maximum length is 20 &amp; Minimum of that is 6"></asp:Label>
                               &nbsp;</b></p>
                            
                            <p>
                                <asp:Label ID="Label7" runat="server" AssociatedControlID="TextBox6">Phone Number:</asp:Label>
                                <asp:TextBox ID="TextBox6" runat="server" Width="320px"></asp:TextBox>
                                
                            &nbsp;&nbsp;
                                <asp:DropDownList ID="DropDownListp" runat="server">
                                    <asp:ListItem>Private</asp:ListItem>
                                    <asp:ListItem>Public</asp:ListItem>
                                </asp:DropDownList>
                                
                            </p>
                            <p>
                               <b>
                                    <asp:Label ID="Label8" runat="server" Text="Please use international format"></asp:Label>
                               </b>
                               </p>

                               <p>
                                <asp:Label ID="EmailLabel" runat="server" AssociatedControlID="TextBox2">E-mail:</asp:Label>
                                <asp:TextBox ID="TextBox2" runat="server" Width="320px"></asp:TextBox>
                                
                            &nbsp;&nbsp;
                                <asp:DropDownList ID="DropDownListe" runat="server">
                                    <asp:ListItem>Private</asp:ListItem>
                                    <asp:ListItem>Public</asp:ListItem>
                                </asp:DropDownList>
                                
                            </p>
                            <p>
                           
                                 <b>
                                 
                           
                                 <asp:RegularExpressionValidator ID="RegularExpressionValidator1" runat="server" 
                                     ControlToValidate="TextBox2" CssClass="failureNotification" 
                                     ErrorMessage="Plaese enter a valid email address" 
                                     ToolTip="Plaese enter a valid email address" 
                                     ValidationExpression="\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*"></asp:RegularExpressionValidator>
                                 
                           
                                 </b>
                            </p>
                            <p>
                                 <b><asp:Label ID="Label2" runat="server" Text="Plaese enter a valid email address"></asp:Label></b>
                            </p>

                            <p>
                                <asp:Label ID="Label9" runat="server" AssociatedControlID="TextBox7">Home Place:</asp:Label>
                                <asp:TextBox ID="TextBox7" runat="server" Width="320px"></asp:TextBox>
                                
                            </p>
                            <p>
                               <b>
                                    <asp:Label ID="Label10" runat="server" Text="Maximum length is 20"></asp:Label>
                               </b>
                               </p>
                               <p>
                               <asp:Label ID="Label11" runat="server">Gender :</asp:Label>
                              
                                   &nbsp;&nbsp;<asp:DropDownList ID="DropDownListe0" runat="server" 
                                       style="margin-bottom: 0px" Height="21px">
                                    <asp:ListItem>Male</asp:ListItem>
                                    <asp:ListItem>Female</asp:ListItem>
                                </asp:DropDownList>
                                
                            </p>
                            

                            <p>
                                <asp:Label ID="UserNameLabel" runat="server" AssociatedControlID="TextBox1">User Name:</asp:Label>
                                <asp:TextBox ID="TextBox1" runat="server" Width="320px"></asp:TextBox>
                                
                            </p>
                            <p>
                               <b>
                                    <asp:Label ID="Label1" runat="server" Text="Maximum length of username is 12,Minimum of that is 6"></asp:Label>
                               </b>
                               </p>
                            
                            <p>
                                <asp:Label ID="PasswordLabel" runat="server" AssociatedControlID="TextBox3">Password:</asp:Label>
                                <asp:TextBox ID="TextBox3" runat="server" Width="320px"></asp:TextBox>
        
                             
                            </p>
                            <p>
                                
                            
                                <b><asp:Label ID="Label3" runat="server" Text="Minimum length of password is 6,Maximum of that is 16."></asp:Label></b>
                                </p>
                            <p>
                                <asp:Label ID="ConfirmPasswordLabel" runat="server" AssociatedControlID="TextBox4">Confirm Password:</asp:Label>
                                <asp:TextBox ID="TextBox4" runat="server" Width="320px"></asp:TextBox>
                               
                                
                            </p>
                            <p>
                                
                            
                                <b><asp:Label ID="Label4" runat="server" Text="Please re-enter your password"></asp:Label></b>
                                </p>
                        </fieldset>
                        <p class="submitButton">
                            <asp:Button ID="CreateUserButton" runat="server" CommandName="MoveNext" Text="Submit" 
                                 ValidationGroup="RegisterUserValidationGroup" 
                                onclick="CreateUserButton_Click"/>
                        </p>
                   </asp:Content>
                
