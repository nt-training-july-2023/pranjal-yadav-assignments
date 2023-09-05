import React from "react";
import "../style/DashBoard.css";
import { Link, Route, Routes } from "react-router-dom";
import DisplayEmployee from "./DisplayEmployee";
import DisplayManager from "./DisplayManager";

const Dashboard = () => {
  return (
    <div>
      <div className="head">
        <h1 className="button">
          <Link to="/USER">Employees</Link>
        </h1>
        <h1 className="button">
          <Link to="/all-managers">Managers</Link>
        </h1>
        <h1 className="button">
          <Link to="/all-emp">Projects</Link>
        </h1>
      </div>
      <Routes>
        <Route path="/all-emp" element={<DisplayEmployee />} />
        <Route path="/all-managers" element={<DisplayManager />} />
      </Routes>
    </div>
  );
};

export default Dashboard;
