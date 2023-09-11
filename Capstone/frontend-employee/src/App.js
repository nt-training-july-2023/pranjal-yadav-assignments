
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
        <Route path='/adminDashboard' element={<AdminDashBoard/>} />
        <Route path='/addEmployee' element={<AddEmployee/>} />
        <Route path='/PROJECT' element={<DisplayProject/>} />
        <Route path='/addProject' element={<AddProject/>} />
        <Route path='/employeeDashboard' element={<EmployeeDashBoard/>} />
      </Routes>
      </BrowserRouter>
      
      <Footer/>
    </div>
  );
}

export default App;
