
//import './App.css';
import Footer from './component/Footer/Footer';
import Header from './component/Header/Header';
import AdminRegistrationForm from './Pages/Registration/AdminRegistrationForm';
import Login from './Pages/LoginPage/Login';
import { Route,BrowserRouter,Routes } from 'react-router-dom';
// import Dashboard from './component/Dashboard';
import AdminDashBoard from './Pages/AdminDashboard/AdminDashBoard';
import AddEmployee from './component/AddEmployee/AddEmployee';
import DisplayEmployee from './Pages/AdminDashboard/Employee/DisplayEmployee';
import DisplayManager from './Pages/AdminDashboard/Manager/DisplayManager';
import DisplayProject from './Pages/AdminDashboard/Project/DisplayProject';
import AddProject from './component/AddProject/AddProject';
import EmployeeDashBoard from './Pages/EmployeeDashboard/EmployeeDashBoard';
import AssignProject from './component/AssignProject/AssignProject';
import EmpDisplayEmployee from '../src/Pages/EmployeeDashboard/EmployeeDashBoard';
import ManagerDashBoard from './Pages/ManagerDashboard/ManagerDashBoard';
import UpdateSkills from './component/UpdateSkills/UpdateSkills';
import ManagerDisplayEmployee from './Pages/ManagerDashboard/Employee/ManagerDisplayEmployee';
import RequestResource from './component/RequestResource/RequestResource';
import RequestNotification from './component/RequestNotification/RequestNotification';
import UnassignProject from './component/AssignProject/UnassignProject';



function App() {
  return (
    <div className="App">
    {/* // <div>  */}
       {/* <Header/> */}
       <BrowserRouter>
      <Routes>
        <Route path='/' element={<Login/>}></Route>
        <Route path='/adminRegister' element={<AdminRegistrationForm/>}></Route>
        {/* <Route path='/dashboard' element= {<Dashboard/>}></Route> */}
        <Route path='/MANAGER' element={<DisplayManager/>} />
        <Route path='/EMPLOYEE' element={<DisplayEmployee/>} />
        <Route path='/Organization' element={<EmpDisplayEmployee/>} />
        <Route path='/adminDashboard' element={<AdminDashBoard/>} />
        <Route path='/addEmployee' element={<AddEmployee/>} />
        <Route path='/PROJECT' element={<DisplayProject/>} />
        <Route path='/addProject' element={<AddProject/>} />
        <Route path='/employeeDashboard' element={<EmployeeDashBoard/>} />
        <Route path='/managerDashboard' element={<ManagerDashBoard/>} />
        <Route path='/assignProject' element={<AssignProject />} />
        <Route path='/updateSkills' element={<UpdateSkills />} />
        <Route path='/ManagerDisplayEmp' element={<ManagerDisplayEmployee/>} />
        <Route path='/requestResource' element={<RequestResource/>} />
        <Route path='/requests' element={<RequestNotification/>} />
        <Route path='/unassign/:id' element={<UnassignProject/>} />
      </Routes>
      </BrowserRouter>
      
      <Footer/>
    </div>
  );
}

export default App;
