import React, { useEffect } from 'react'
import './Unassign.css'
import { useNavigate, useParams } from 'react-router-dom'
import axios from 'axios';
import AdminService from '../../service/AdminService';
import CustomButton from '../CustomButton';

const UnassignProject = () => {
  const {id} = useParams();
  const navigate = useNavigate();
  useEffect(() => {
    getAllProjects();
  }, []);
  const getAllProjects = ()=>{
    console.log("djcbsaibuj" + id);
  }
  const respondToYes = () =>{
    try{
    //   // console.log(id);
    //   axios.put(`http://localhost:8080/user/unassign/${id}`)
    //   navigate("/adminDashboard")
  
    const response = AdminService.unassign(id).then((response) =>{
      console.log(response.data);
      navigate("/adminDashboard")
    })
  }
    catch(error){
      console.log("jhvhjsv"+ error);
    }
  }
  const respondToNo = () =>{
    navigate("/adminDashboard")
  }

  return (
    <div className='unassign_div'>
        <h3 className='unassign_question'>Are you sure to unassign project to this employee?</h3>
        {/* <button className='answer_yes' onClick={respondToYes}>Yes</button>
        <button className='answer_no' onClick={respondToNo}>No</button> */}
        <CustomButton text={"Yes"} style={"answer_yes"} onClick={respondToYes}/>
        <CustomButton text={"No"} style={"answer_no"} onClick={respondToNo}/>
    </div>
  )
}

export default UnassignProject
