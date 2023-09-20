
//import './App.css';
import Footer from './component/Footer';
import Header from './component/Header';
import AdminRegistrationForm from './component/AdminRegistrationForm';
import Login from './component/Login';
import { Route,BrowserRouter,Routes } from 'react-router-dom';
import Dashboard from './component/Dashboard';
import AdminDashBoard from './component/AdminDashBoard';
import AddEmployee from './component/AddEmployee';
import DisplayEmployee from './component/DisplayEmployee';
import DisplayManager from './component/DisplayManager';
import DisplayProject from './component/DisplayProject';
import AddProject from './component/AddProject';
import EmployeeDashBoard from './component/EmployeeComponents/EmployeeDashBoard';
import AssignProject from './component/AssignProject';
import EmpDisplayEmployee from './component/EmployeeComponents/EmpDisplayEmployee';
import ManagerDashBoard from './component/ManagerComponent/ManagerDashBoard';
import UpdateSkills from './component/EmployeeComponents/UpdateSkills';



function App() {
  return (
    <div className="App">
    {/* // <div>  */}
       <Header/>
       <BrowserRouter>
      <Routes>
        <Route path='/' element={<Login/>}></Route>
        <Route path='/adminRegister' element={<AdminRegistrationForm/>}></Route>
        <Route path='/dashboard' element= {<Dashboard/>}></Route>
        <Route path='/MANAGER' element={<DisplayManager/>} />
        <Route path='/EMPLOYEE' element={<DisplayEmployee/>} />
        <Route path='/Organization' element={<EmpDisplayEmployee/>} />
        <Route path='/adminDashboard' element={<AdminDashBoard/>} />
        <Route path='/addEmployee' element={<AddEmployee/>} />
        <Route path='/PROJECT' element={<DisplayProject/>} />
        <Route path='/addProject' element={<AddProject/>} />
        <Route path='/employeeDashboard' element={<EmployeeDashBoard/>} />
        <Route path='/managerDashboard' element={<ManagerDashBoard/>} />
        <Route path='/assignProject/:id' element={<AssignProject />} />
        <Route path='/updateSkills/:id' element={<UpdateSkills />} />
      </Routes>
      </BrowserRouter>
      
      <Footer/>
    </div>
  );
}

export default App;
