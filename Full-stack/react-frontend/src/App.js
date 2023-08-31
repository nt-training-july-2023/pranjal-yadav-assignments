import "./App.css";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { HeaderComponent } from "./components/HeaderComponent";
import { ListEmployeeComponent } from "./components/ListEmployeeComponent";
import AddEmployeeComponent from "./components/AddEmployeeComponent";

function App() {
  return (
    <div>
      <Router>
        <HeaderComponent />
        <div className="container">
          <Routes>
            <Route path="/" element={<ListEmployeeComponent />}></Route>
            <Route path="/employees" element={<ListEmployeeComponent />} />
            <Route
              exact
              path="/add-employee"
              element={<AddEmployeeComponent />}
            />
            <Route
              path="/edit-employee/:id"
              Component={AddEmployeeComponent}
            ></Route>
          </Routes>
        </div>
      </Router>
    </div>
  );
}

export default App;
