using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AddicTech_Library
{
    public class Employee
    {
        private string _fname;
        private string _lname;
        private int _age;
        private double _salary;
        private int _empid;
        private string _loginName;
        private string _password;
        private string _department;

        public Employee(string fname, string lname, int age, double salary, int empid, string loginName, string password, string department)
        {
            Fname = fname;
            Lname = lname;
            //Make sure employee is older than 18
            if(age >= 18)
            {
                Age = age;
            }
            else
            {
                throw new Exception("Must be older than 18");
            }
            Salary = salary;
            Empid = empid;
            LoginName = loginName;
            //check to make sure the password is at least six characters
            if (password.Length >= 6)
            {
                Password = password;
            }
            else
            {
                throw new Exception("Password must be at least 6 characters");
            }  
            Department = department;
        }

        //Get and Set methods
        public string Fname
        {
            get
            {
                return _fname;
            }

            set
            {
                _fname = value;
            }
        }

        public string Lname
        {
            get
            {
                return _lname;
            }

            set
            {
                _lname = value;
            }
        }

        public int Age
        {
            get
            {
                return _age;
            }

            set
            {
                _age = value;
            }
        }

        public double Salary
        {
            get
            {
                return _salary;
            }

            set
            {
                _salary = value;
            }
        }

        public int Empid
        {
            get
            {
                return _empid;
            }

            set
            {
                _empid = value;
            }
        }

        public string LoginName
        {
            get
            {
                return _loginName;
            }

            set
            {
                _loginName = value;
            }
        }

        public string Password
        {
            get
            {
                return _password;
            }

            set
            {
                //check to make sure the password is at least six characters
                if (value.Length >= 6)
                {
                    _password = value;
                }
                else
                {
                    throw new Exception("Password must be at least 6 characters");
                }
            }
        }

        public string Department
        {
            get
            {
                return _department;
            }

            set
            {
                _department = value;
            }
        }
        //Methods
        public void Login(string loginName, string password)
        {
            if (loginName == _loginName & password == _password)
            {
                _empid = 1;
                Department = "HR";
                Fname = "Carl";
                Lname = "Smith";
            }
            else
            {
                throw new Exception("Login incorrect.");
            }
        }

    }//End of class




}//End of NameSpace
