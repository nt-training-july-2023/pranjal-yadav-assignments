
import './App.css';
import Footer from './component/Footer';
import Header from './component/Header';
import AdminRegistrationForm from './component/AdminRegistrationForm';
import Login from './component/Login';
import { Route,BrowserRouter,Routes } from 'react-router-dom';
import Dashboard from './component/Dashboard';



function App() {
  return (
    <div className="App">
      <Header/>
      <BrowserRouter>
      <Routes>
        <Route path='/' element={<Login/>}></Route>
        <Route path='/adminRegister' element={<AdminRegistrationForm/>}></Route>
        <Route path='/dashboard' element= {<Dashboard/>}></Route>
      </Routes>
      </BrowserRouter>
      
      <Footer/>
    </div>
  );
}

export default App;
