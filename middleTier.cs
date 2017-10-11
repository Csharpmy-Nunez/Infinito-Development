using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Data.SqlClient;
using System.Configuration;

namespace BaseObjects
{
    class middleTier
    {
        //connection object
        SqlConnection conn = new SqlConnection();
        //command objects
        SqlCommand scmd = new SqlCommand();
        SqlCommand scmdCustomer = new SqlCommand();
        SqlCommand scmdSales = new SqlCommand();
        SqlCommand scmdDeleteCommand = new SqlCommand();

        SqlDataAdapter adaptEmployee = new SqlDataAdapter();
        SqlDataAdapter adapCustomer = new SqlDataAdapter();
        SqlDataAdapter adapSales = new SqlDataAdapter();
        SqlDataAdapter adaptImages = new SqlDataAdapter();

        public middleTier()
        {
            //Connection string from the app.config file
            conn.ConnectionString = ConfigurationManager.ConnectionStrings["NorthwindConnection"].ToString();
        }

        //Retun all products from the Products table
        public SqlDataReader ReturnAllProducts()
        {
            try
            {
                conn.Open();
                scmd.Connection = conn;
                scmd.CommandType = CommandType.Text;
                scmd.CommandText = "select ProductID, ProductName, QuantityPerUnit, UnitPrice, UnitsInStock, ReorderLevel, Discontinued from Products";
                return scmd.ExecuteReader(CommandBehavior.CloseConnection);
            }
            catch (SqlException sql)
            {
                throw sql;
            }
            catch (Exception ex)
            {
                throw ex;
            }
        }//End of ReturnAllProducts method


        //-------------------------------------------------------LINQ





    }//End of class
}
