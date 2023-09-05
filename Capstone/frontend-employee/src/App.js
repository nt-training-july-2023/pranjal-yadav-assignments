
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
        <Route path='/USER' element={<DisplayEmployee/>} />
        <Route path='/adminDashboard' element={<AdminDashBoard/>} />
        <Route path='/addEmployee' element={<AddEmployee/>} />
      </Routes>
      </BrowserRouter>
      
      <Footer/>
      {/* <AdminDashBoard /> */}
      {/* <AddEmployee /> */}
    </div>
  );
}

export default App;
