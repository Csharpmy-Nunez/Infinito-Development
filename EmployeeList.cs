using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AddicTech_Library
{
    class EmployeeList
    {
        private List<Employee> _employeeList;
        private int _counter;

        public int Counter
        {
            get { return _counter;}
        }

        public EmployeeList()
        {
        }

        //Methods
        //Search employee by id
        private Employee getEmployee(int empid)
        {
            Employee tempEmpHolder = null;
            foreach(Employee item in _employeeList)
            {
                if(item.Empid == empid)
                {
                    tempEmpHolder = item;
                }
                else
                {
                    Console.WriteLine("Entry not found");
                }
            }

            return tempEmpHolder;
        }

        //Add item
        public void addEmployee(Employee item)
        {
            if (item != null)
            {
                _employeeList.Add(item);
                _counter++;
            }
            else
            {
                throw new NullReferenceException("Enter an employee object");
            }
        }
        //Remove item
        public bool removeEmployee(int empid)
        {
            return _employeeList.Remove(getEmployee(empid));
        }






    }//End of class
}//End of namespace
