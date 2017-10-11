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
        private int _couner;

        public EmployeeList(){
        }

        //Methods

        //Add item
        public void addEmployee(Employee employee){
            if(employee != null){
                _employeeList.Add(employee);
                _couner++;
            }else
            {
                Console.WriteLine("Enter an employee object");
            }
        }






    }//End of class
}//End of namespace
